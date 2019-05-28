/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.yithro.ticket.service.impl;

import com.liferay.document.library.kernel.exception.DuplicateDirectoryException;
import com.liferay.document.library.kernel.exception.NoSuchFileException;
import com.liferay.document.library.kernel.store.DLStoreUtil;
import com.liferay.document.library.kernel.util.DLValidatorUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.zip.ZipWriter;
import com.liferay.portal.kernel.zip.ZipWriterFactoryUtil;
import com.liferay.yithro.audit.service.AuditEntryLocalService;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.constants.TicketAttachmentConstants;
import com.liferay.yithro.ticket.exception.DuplicateTicketAttachmentException;
import com.liferay.yithro.ticket.exception.TicketAttachmentVisibilityException;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketCommunication;
import com.liferay.yithro.ticket.service.TicketCommunicationLocalService;
import com.liferay.yithro.ticket.service.base.TicketAttachmentLocalServiceBaseImpl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketAttachment",
	service = AopService.class
)
public class TicketAttachmentLocalServiceImpl
	extends TicketAttachmentLocalServiceBaseImpl {

	public void addTicketAttachments(
			long userId, long ticketEntryId, String[] fileNames, File[] files,
			int visibility, int status, ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		Date now = serviceContext.getCreateDate(new Date());

		for (int i = 0; i < files.length; i++) {
			String fileName = fileNames[i];
			File file = files[i];

			validate(ticketEntryId, fileName, file.length(), visibility);
		}

		List<TicketAttachment> ticketAttachments = new ArrayList<>();

		for (int i = 0; i < files.length; i++) {
			String fileName = fileNames[i];
			File file = files[i];

			long ticketAttachmentId = counterLocalService.increment();

			TicketAttachment ticketAttachment =
				ticketAttachmentPersistence.create(ticketAttachmentId);

			ticketAttachment.setUserId(user.getUserId());
			ticketAttachment.setUserName(user.getFullName());
			ticketAttachment.setCompanyId(user.getCompanyId());
			ticketAttachment.setCreateDate(now);
			ticketAttachment.setTicketEntryId(ticketEntryId);
			ticketAttachment.setFileName(fileName);
			ticketAttachment.setFileSize(file.length());
			ticketAttachment.setVisibility(visibility);

			ticketAttachmentPersistence.update(ticketAttachment);

			// File

			try {
				DLStoreUtil.addDirectory(
					ticketAttachment.getCompanyId(), CompanyConstants.SYSTEM,
					ticketAttachment.getFileDir());
			}
			catch (DuplicateDirectoryException dde) {
			}

			DLStoreUtil.addFile(
				ticketAttachment.getCompanyId(), CompanyConstants.SYSTEM,
				ticketAttachment.getFilePath(), file);

			ticketAttachments.add(ticketAttachment);
		}

		updateStatus(
			userId, ticketAttachments, ticketEntryId, visibility, status,
			serviceContext);
	}

	public void deleteOrphanTicketAttachments() throws PortalException {
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, -1);

		List<TicketAttachment> ticketAttachments =
			ticketAttachmentPersistence.findByCD_TEI(
				calendar.getTime(),
				TicketAttachmentConstants.TICKET_ENTRY_DEFAULT_ID);

		for (TicketAttachment ticketAttachment : ticketAttachments) {
			deleteTicketAttachment(ticketAttachment);
		}
	}

	public TicketAttachment deleteTicketAttachment(long ticketAttachmentId)
		throws PortalException {

		TicketAttachment ticketAttachment =
			ticketAttachmentPersistence.fetchByPrimaryKey(ticketAttachmentId);

		return deleteTicketAttachment(ticketAttachment);
	}

	public TicketAttachment deleteTicketAttachment(
			TicketAttachment ticketAttachment)
		throws PortalException {

		// Ticket attachment

		ticketAttachmentPersistence.remove(ticketAttachment);

		// File

		try {
			DLStoreUtil.deleteFile(
				ticketAttachment.getCompanyId(), CompanyConstants.SYSTEM,
				ticketAttachment.getFilePath());
		}
		catch (NoSuchFileException nsfe) {
		}

		if ((ticketAttachment.getTicketEntryId() ==
				TicketAttachmentConstants.TICKET_ENTRY_DEFAULT_ID) ||
			(ticketAttachment.getStatus() == WorkflowConstants.STATUS_DRAFT)) {

			return ticketAttachment;
		}

		// Ticket communication

		TicketCommunication ticketCommunication =
			ticketCommunicationLocalService.getTicketCommunication(
				ticketAttachment.getTicketCommunicationId());

		JSONObject jsonObject = ticketCommunication.getDataJSONObject();

		JSONArray jsonArray = updateJSONArray(
			jsonObject.getJSONArray("ticketAttachments"),
			ticketAttachment.getTicketAttachmentId());

		if (jsonArray.length() > 0) {
			jsonObject.put("ticketAttachments", jsonArray);

			ticketCommunicationLocalService.updateTicketCommunication(
				ticketCommunication.getTicketCommunicationId(), jsonObject);
		}
		else {
			ticketCommunicationLocalService.deleteTicketCommunication(
				ticketCommunication.getTicketCommunicationId());
		}

		return ticketAttachment;
	}

	public void deleteTicketAttachments(long[] ticketAttachmentIds)
		throws PortalException {

		for (long ticketAttachmentId : ticketAttachmentIds) {
			deleteTicketAttachment(ticketAttachmentId);
		}
	}

	public TicketAttachment fetchTicketAttachment(
		long ticketEntryId, String fileName, int visibility, int status) {

		return ticketAttachmentPersistence.fetchByTEI_FN_V_S(
			ticketEntryId, fileName, visibility, status);
	}

	public InputStream getFileAsStream(TicketAttachment ticketAttachment)
		throws PortalException {

		return DLStoreUtil.getFileAsStream(
			ticketAttachment.getCompanyId(), CompanyConstants.SYSTEM,
			ticketAttachment.getFilePath());
	}

	public List<TicketAttachment> getTicketAttachments(
		long ticketEntryId, int status) {

		return ticketAttachmentPersistence.findByTEI_S(ticketEntryId, status);
	}

	public List<TicketAttachment> getTicketAttachments(
		long ticketEntryId, int[] visibilities, int status) {

		return ticketAttachmentPersistence.findByTEI_V_S(
			ticketEntryId, visibilities, status);
	}

	public List<TicketAttachment> getTicketAttachments(
		long userId, long ticketEntryId, int visibility, int status) {

		return ticketAttachmentPersistence.findByU_TEI_V_S(
			userId, ticketEntryId, visibility, status);
	}

	public File getTicketAttachmentsZipFile(
			long ticketEntryId, int[] visibilities)
		throws PortalException {

		List<TicketAttachment> ticketAttachments = getTicketAttachments(
			ticketEntryId, visibilities, WorkflowConstants.STATUS_APPROVED);

		ZipWriter zipWriter = ZipWriterFactoryUtil.getZipWriter();

		try {
			for (TicketAttachment ticketAttachment : ticketAttachments) {
				zipWriter.addEntry(
					ticketAttachment.getFileName(),
					getFileAsStream(ticketAttachment));
			}
		}
		catch (IOException ioe) {
			throw new PortalException(ioe);
		}

		return zipWriter.getFile();
	}

	public void updateStatus(
			long userId, List<TicketAttachment> ticketAttachments,
			long ticketEntryId, int visibility, int status,
			ServiceContext serviceContext)
		throws PortalException {

		// Ticket attachment

		Date now = serviceContext.getCreateDate(new Date());

		for (TicketAttachment ticketAttachment : ticketAttachments) {
			if (status == WorkflowConstants.STATUS_APPROVED) {
				if (ticketAttachment.getStatus() ==
						WorkflowConstants.STATUS_DRAFT) {

					ticketAttachment.setCreateDate(now);
				}
			}

			ticketAttachment.setStatus(status);

			ticketAttachmentPersistence.update(ticketAttachment);
		}

		if ((status != WorkflowConstants.STATUS_APPROVED) ||
			(ticketEntryId ==
				TicketAttachmentConstants.TICKET_ENTRY_DEFAULT_ID)) {

			return;
		}

		// Ticket communication

		TicketCommunication ticketCommunication =
			ticketCommunicationLocalService.addTicketCommunication(
				userId, ticketEntryId, TicketAttachment.class.getName(),
				getDataJSONObject(ticketAttachments), visibility);

		for (TicketAttachment ticketAttachment : ticketAttachments) {
			ticketAttachment.setTicketCommunicationId(
				ticketCommunication.getTicketCommunicationId());

			ticketAttachmentPersistence.update(ticketAttachment);
		}
	}

	public TicketAttachment updateTicketAttachment(
			long ticketAttachmentId, long ticketEntryId)
		throws PortalException {

		TicketAttachment ticketAttachment =
			ticketAttachmentPersistence.findByPrimaryKey(ticketAttachmentId);

		if (ticketAttachment.getTicketEntryId() == ticketEntryId) {
			return ticketAttachment;
		}

		String oldFilePath = ticketAttachment.getFilePath();

		ticketAttachment.setTicketEntryId(ticketEntryId);
		ticketAttachment.setStatus(WorkflowConstants.STATUS_APPROVED);

		ticketAttachmentPersistence.update(ticketAttachment);

		// File

		try {
			DLStoreUtil.addDirectory(
				ticketAttachment.getCompanyId(), CompanyConstants.SYSTEM,
				ticketAttachment.getFileDir());
		}
		catch (DuplicateDirectoryException dde) {
		}

		DLStoreUtil.updateFile(
			ticketAttachment.getCompanyId(), CompanyConstants.SYSTEM,
			oldFilePath, ticketAttachment.getFilePath());

		return ticketAttachment;
	}

	protected JSONObject getDataJSONObject(
		List<TicketAttachment> ticketAttachments) {

		JSONObject jsonObject = jsonFactory.createJSONObject();

		JSONArray jsonArray = jsonFactory.createJSONArray();

		for (TicketAttachment ticketAttachment : ticketAttachments) {
			JSONObject attachmentJSONObject = jsonFactory.createJSONObject();

			attachmentJSONObject.put(
				"fileName", ticketAttachment.getFileName());
			attachmentJSONObject.put(
				"fileSize", ticketAttachment.getFileSize());
			attachmentJSONObject.put(
				"ticketAttachmentId", ticketAttachment.getTicketAttachmentId());

			jsonArray.put(attachmentJSONObject);
		}

		jsonObject.put("ticketAttachments", jsonArray);

		return jsonObject;
	}

	protected JSONArray updateJSONArray(
		JSONArray jsonArray, long removeTicketAttachmentId) {

		JSONArray newJSONArray = jsonFactory.createJSONArray();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);

			if (jsonObject.getLong("ticketAttachmentId") ==
					removeTicketAttachmentId) {

				continue;
			}

			newJSONArray.put(jsonObject);
		}

		return newJSONArray;
	}

	protected void validate(
			long ticketEntryId, String fileName, long fileSize, int visibility)
		throws PortalException {

		if ((ticketEntryId > 0) &&
			(ticketAttachmentPersistence.countByTEI_FN_V_S(
				ticketEntryId, fileName, visibility,
				WorkflowConstants.STATUS_APPROVED) > 0)) {

			throw new DuplicateTicketAttachmentException();
		}

		DLValidatorUtil.validateFileSize(fileName, fileSize);

		if (!Visibilities.hasVisibility(visibility)) {
			throw new TicketAttachmentVisibilityException();
		}
	}

	@Reference
	protected AuditEntryLocalService auditEntryLocalService;

	@Reference
	protected JSONFactory jsonFactory;

	@Reference
	protected TicketCommunicationLocalService ticketCommunicationLocalService;

}