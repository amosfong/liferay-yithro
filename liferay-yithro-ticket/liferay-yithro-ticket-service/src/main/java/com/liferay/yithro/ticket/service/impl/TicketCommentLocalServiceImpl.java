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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.yithro.audit.constants.Actions;
import com.liferay.yithro.audit.constants.Fields;
import com.liferay.yithro.audit.service.AuditEntryLocalService;
import com.liferay.yithro.constants.MailActionKeys;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.constants.TicketCommentFormat;
import com.liferay.yithro.ticket.exception.TicketCommentBodyException;
import com.liferay.yithro.ticket.exception.TicketCommentMaximumDraftException;
import com.liferay.yithro.ticket.exception.TicketCommentVisibilityException;
import com.liferay.yithro.ticket.exception.TicketEntryClosedException;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketComment;
import com.liferay.yithro.ticket.model.TicketCommunication;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.service.TicketAttachmentLocalService;
import com.liferay.yithro.ticket.service.TicketCommunicationLocalService;
import com.liferay.yithro.ticket.service.TicketEntryLocalService;
import com.liferay.yithro.ticket.service.base.TicketCommentLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketComment",
	service = AopService.class
)
public class TicketCommentLocalServiceImpl
	extends TicketCommentLocalServiceBaseImpl {

	public TicketComment addTicketComment(
			long userId, long ticketEntryId, String body, int type,
			int visibility, int status, int[] pendingTypes,
			ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		TicketEntry ticketEntry = ticketEntryPersistence.findByPrimaryKey(
			ticketEntryId);

		validate(
			ticketEntry, userId, body, type, visibility,
			WorkflowConstants.STATUS_ANY, status);

		long ticketCommentId = counterLocalService.increment();

		TicketComment ticketComment = ticketCommentPersistence.create(
			ticketCommentId);

		ticketComment.setUserId(user.getUserId());
		ticketComment.setUserName(user.getFullName());
		ticketComment.setTicketEntryId(ticketEntryId);
		ticketComment.setBody(body);
		ticketComment.setType(type);
		ticketComment.setFormat(TicketCommentFormat.BBCODE);
		ticketComment.setVisibility(visibility);

		if (status == WorkflowConstants.STATUS_DRAFT) {
			ticketComment.setSettingsProperty(
				"pendingTypes", StringUtil.merge(pendingTypes));
		}

		int statusReason = GetterUtil.getInteger(
			serviceContext.getAttribute("statusReason"));

		if (statusReason > 0) {
			ticketComment.setSettingsProperty(
				"statusReason", String.valueOf(statusReason));
		}

		ticketCommentPersistence.update(ticketComment);

		updateStatus(
			user, ticketComment, ticketEntry, status, pendingTypes,
			serviceContext);

		return ticketComment;
	}

	public TicketComment deleteTicketComment(long userId, long ticketCommentId)
		throws PortalException {

		TicketComment ticketComment = ticketCommentPersistence.findByPrimaryKey(
			ticketCommentId);

		return deleteTicketComment(userId, ticketComment);
	}

	public TicketComment deleteTicketComment(
			long userId, TicketComment ticketComment)
		throws PortalException {

		ticketCommentPersistence.remove(ticketComment);

		if (ticketComment.getStatus() != WorkflowConstants.STATUS_DRAFT) {
			auditEntryLocalService.addAuditEntry(
				userId, new Date(), TicketEntry.class,
				ticketComment.getTicketEntryId(), 0, TicketComment.class,
				ticketComment.getTicketCommentId(), Actions.DELETE, Fields.BODY,
				ticketComment.getVisibility(), StringPool.BLANK,
				ticketComment.getBody(), StringPool.BLANK, StringPool.BLANK,
				StringPool.BLANK);

			// Ticket communication

			ticketCommunicationLocalService.deleteTicketCommunication(
				ticketComment.getTicketCommunicationId());
		}
		else {
			List<TicketAttachment> ticketAttachments =
				ticketAttachmentLocalService.getTicketAttachments(
					userId, ticketComment.getTicketEntryId(),
					ticketComment.getVisibility(),
					WorkflowConstants.STATUS_DRAFT);

			for (TicketAttachment ticketAttachment : ticketAttachments) {
				ticketAttachmentLocalService.deleteTicketAttachment(
					ticketAttachment);
			}
		}

		return ticketComment;
	}

	public TicketComment fetchLastTicketComment(
		long userId, long ticketEntryId, int visibility, int status, int type,
		OrderByComparator obc) {

		return ticketCommentPersistence.fetchByU_TEI_V_S_T_Last(
			userId, ticketEntryId, visibility, status, type, obc);
	}

	public TicketComment fetchLastTicketComment(
		long userId, long ticketEntryId, int visibility, int status,
		OrderByComparator obc) {

		return ticketCommentPersistence.fetchByU_TEI_V_S_Last(
			userId, ticketEntryId, visibility, status, obc);
	}

	public TicketComment getLastTicketComment(
			long ticketEntryId, int visibility, OrderByComparator obc)
		throws PortalException {

		return ticketCommentPersistence.findByTEI_V_S_Last(
			ticketEntryId, visibility, WorkflowConstants.STATUS_APPROVED, obc);
	}

	public List<TicketComment> getTicketComments(
		long ticketEntryId, int[] visibilities, int[] statuses) {

		return ticketCommentPersistence.findByTEI_V_S(
			ticketEntryId, visibilities, statuses);
	}

	public List<TicketComment> getTicketComments(
		long userId, long ticketEntryId, int[] visibilities, int[] statuses) {

		return ticketCommentPersistence.findByU_TEI_V_S(
			userId, ticketEntryId, visibilities, statuses);
	}

	public int getTicketCommentsCount(
		long ticketEntryId, int[] visibilities, int[] statuses) {

		return ticketCommentPersistence.countByTEI_V_S(
			ticketEntryId, visibilities, statuses);
	}

	public int getTicketCommentsCount(
		long userId, long ticketEntryId, int[] visibilities, int[] statuses) {

		return ticketCommentPersistence.countByU_TEI_V_S(
			userId, ticketEntryId, visibilities, statuses);
	}

	public synchronized TicketComment updateTicketComment(
			long userId, long ticketCommentId, long ticketEntryId, String body,
			int visibility, int status, int[] pendingTypes,
			ServiceContext serviceContext)
		throws PortalException {

		EntityCacheUtil.clearLocalCache();

		User user = userLocalService.getUser(userId);
		TicketEntry ticketEntry = ticketEntryPersistence.findByPrimaryKey(
			ticketEntryId);

		TicketComment ticketComment = ticketCommentPersistence.findByPrimaryKey(
			ticketCommentId);

		validate(
			ticketEntry, userId, body, ticketComment.getType(), visibility,
			ticketComment.getStatus(), status);

		ticketComment.setModifiedDate(new Date());
		ticketComment.setTicketEntryId(ticketEntryId);
		ticketComment.setBody(body);
		ticketComment.setFormat(TicketCommentFormat.PLAIN);
		ticketComment.setVisibility(visibility);

		if (status == WorkflowConstants.STATUS_DRAFT) {
			ticketComment.setSettingsProperty(
				"pendingTypes", StringUtil.merge(pendingTypes));
		}

		ticketCommentPersistence.update(ticketComment);

		updateStatus(
			user, ticketComment, ticketEntry, status, pendingTypes,
			serviceContext);

		return ticketComment;
	}

	protected JSONObject getDataJSONObject(TicketComment ticketComment) {
		JSONObject jsonObject = jsonFactory.createJSONObject();

		String body = ticketComment.getBody();

		jsonObject.put("content", body.replace("\n", "<br />"));

		jsonObject.put("ticketCommentId", ticketComment.getTicketCommentId());

		return jsonObject;
	}

	protected void updateStatus(
			User user, TicketComment ticketComment, TicketEntry ticketEntry,
			int status, int[] pendingTypes, ServiceContext serviceContext)
		throws PortalException {

		Date now = serviceContext.getCreateDate(new Date());

		// Ticket comment

		if ((ticketComment.getStatus() == WorkflowConstants.STATUS_DRAFT) &&
			(status == WorkflowConstants.STATUS_APPROVED)) {

			ticketComment.setCreateDate(now);
		}

		ticketComment.setStatus(status);

		ticketCommentPersistence.update(ticketComment);

		if (status != WorkflowConstants.STATUS_APPROVED) {
			return;
		}

		if (ticketComment.getStatus() == WorkflowConstants.STATUS_DRAFT) {

			// Ticket attachments

			List<TicketAttachment> ticketAttachments =
				ticketAttachmentLocalService.getTicketAttachments(
					user.getUserId(), ticketComment.getTicketEntryId(),
					ticketComment.getVisibility(),
					WorkflowConstants.STATUS_DRAFT);

			ticketAttachmentLocalService.updateStatus(
				user.getUserId(), ticketAttachments,
				ticketComment.getTicketEntryId(), ticketComment.getVisibility(),
				status, serviceContext);
		}

		// Pending types

		if (!ArrayUtil.isEmpty(pendingTypes)) {
			ticketEntryLocalService.updatePendingTypes(
				user.getUserId(), ticketComment.getTicketEntryId(),
				pendingTypes);
		}

		// Ticket communication

		if (ticketComment.getTicketCommunicationId() > 0) {
			ticketCommunicationLocalService.updateTicketCommunication(
				ticketComment.getTicketCommunicationId(),
				getDataJSONObject(ticketComment));
		}
		else {
			TicketCommunication ticketCommunication =
				ticketCommunicationLocalService.addTicketCommunication(
					ticketComment.getUserId(), ticketComment.getTicketEntryId(),
					TicketComment.class.getName(),
					getDataJSONObject(ticketComment),
					ticketComment.getVisibility());

			ticketComment.setTicketCommunicationId(
				ticketCommunication.getTicketCommunicationId());

			ticketCommentPersistence.update(ticketComment);
		}

		// Email

		ticketEntryLocalService.sendEmail(
			user.getUserId(), ticketEntry, ticketComment,
			MailActionKeys.COMMENTED);

		// Indexer

		ticketEntryLocalService.reindexTicketEntry(
			ticketEntry.getTicketEntryId());
	}

	protected void validate(
			TicketEntry ticketEntry, long userId, String body, int type,
			int visibility, int oldStatus, int status)
		throws PortalException {

		if (Validator.isNull(body)) {
			throw new TicketCommentBodyException();
		}

		if (!Visibilities.hasVisibility(visibility)) {
			throw new TicketCommentVisibilityException();
		}

		if ((oldStatus == WorkflowConstants.STATUS_APPROVED) &&
			(oldStatus != status)) {

			throw new WorkflowException();
		}

		if ((oldStatus != status) &&
			(status == WorkflowConstants.STATUS_DRAFT) &&
			(getTicketCommentsCount(
				userId, ticketEntry.getTicketEntryId(), new int[] {visibility},
				new int[] {WorkflowConstants.STATUS_DRAFT}) > 0)) {

			if (ticketEntry.isClosed()) {
				throw new TicketEntryClosedException();
			}
			else {
				throw new TicketCommentMaximumDraftException();
			}
		}
	}

	@Reference
	protected AuditEntryLocalService auditEntryLocalService;

	@Reference
	protected JSONFactory jsonFactory;

	@Reference
	protected TicketAttachmentLocalService ticketAttachmentLocalService;

	@Reference
	protected TicketCommunicationLocalService ticketCommunicationLocalService;

	@Reference
	protected TicketEntryLocalService ticketEntryLocalService;

}