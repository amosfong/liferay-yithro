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
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.QueryConfig;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.yithro.audit.constants.Actions;
import com.liferay.yithro.audit.constants.Fields;
import com.liferay.yithro.audit.service.AuditEntryLocalService;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.constants.TicketFlagType;
import com.liferay.yithro.ticket.constants.TicketFlagValue;
import com.liferay.yithro.ticket.exception.TicketEntryDescriptionException;
import com.liferay.yithro.ticket.exception.TicketEntrySubjectException;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketComment;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.model.TicketFlag;
import com.liferay.yithro.ticket.model.TicketStatus;
import com.liferay.yithro.ticket.service.TicketAttachmentLocalService;
import com.liferay.yithro.ticket.service.TicketFieldDataLocalService;
import com.liferay.yithro.ticket.service.TicketFlagLocalService;
import com.liferay.yithro.ticket.service.base.TicketEntryLocalServiceBaseImpl;

import java.io.File;
import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketEntry",
	service = AopService.class
)
public class TicketEntryLocalServiceImpl
	extends TicketEntryLocalServiceBaseImpl {

	@Indexable(type = IndexableType.REINDEX)
	public TicketEntry addTicketEntry(
			long userId, long ticketStatusId, String languageId, String subject,
			String description, int weight, Map<Long, String> ticketFieldsMap,
			List<TicketAttachment> ticketAttachments)
		throws PortalException {

		// Ticket entry

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		validate(subject, description);

		long ticketEntryId = counterLocalService.increment();

		TicketEntry ticketEntry = ticketEntryPersistence.create(ticketEntryId);

		ticketEntry.setUserId(user.getUserId());
		ticketEntry.setUserName(user.getFullName());
		ticketEntry.setCreateDate(now);
		ticketEntry.setModifiedDate(now);
		ticketEntry.setTicketStatusId(ticketStatusId);
		ticketEntry.setLanguageId(languageId);
		ticketEntry.setTicketNumber(getTicketNumber(userId));
		ticketEntry.setSubject(subject);
		ticketEntry.setDescription(description);
		ticketEntry.setWeight(weight);

		ticketEntryPersistence.update(ticketEntry);

		// Ticket information

		ticketFieldDataLocalService.addTicketFieldData(
			ticketEntryId, ticketFieldsMap);

		// Ticket attachments

		String[] fileNames = new String[0];
		File[] files = new File[0];

		for (TicketAttachment ticketAttachment : ticketAttachments) {
			if (ticketAttachment.getTicketAttachmentId() > 0) {
				ticketAttachmentLocalService.updateTicketAttachment(
					ticketAttachment.getTicketAttachmentId(),
					ticketEntry.getTicketEntryId());
			}
			else {
				fileNames = ArrayUtil.append(
					fileNames, ticketAttachment.getFileName());
				files = ArrayUtil.append(files, ticketAttachment.getFile());
			}
		}

		if (!ArrayUtil.isEmpty(files)) {
			ticketAttachmentLocalService.addTicketAttachments(
				userId, ticketEntry.getTicketEntryId(), fileNames, files,
				Visibilities.PUBLIC, WorkflowConstants.STATUS_APPROVED,
				new ServiceContext());
		}

		return ticketEntry;
	}

	@Indexable(type = IndexableType.DELETE)
	@Override
	public TicketEntry deleteTicketEntry(TicketEntry ticketEntry)
		throws PortalException {

		// Ticket entry

		ticketEntryPersistence.remove(ticketEntry);

		// Ticket attachments

		List<TicketAttachment> ticketAttachments =
			ticketAttachmentPersistence.findByTicketEntryId(
				ticketEntry.getTicketEntryId());

		for (TicketAttachment ticketAttachment : ticketAttachments) {
			ticketAttachmentLocalService.deleteTicketAttachment(
				ticketAttachment);
		}

		// Ticket comments

		ticketCommentPersistence.removeByTicketEntryId(
			ticketEntry.getTicketEntryId());

		// Ticket field data

		ticketFieldDataPersistence.removeByTicketEntryId(
			ticketEntry.getTicketEntryId());

		// Ticket links

		ticketLinkPersistence.removeByTicketEntryId(
			ticketEntry.getTicketEntryId());

		// Ticket workers

		ticketWorkerPersistence.removeByTicketEntryId(
			ticketEntry.getTicketEntryId());

		return ticketEntry;
	}

	public List<TicketEntry> getTicketEntries(
		Date modifiedDate, int start, int end) {

		return ticketEntryPersistence.findByGtModifiedDate(
			modifiedDate, start, end);
	}

	public List<TicketEntry> getTicketEntries(
		long userId, long[] ticketStatusIds, int start, int end) {

		return ticketEntryPersistence.findByU_TSI(
			userId, ticketStatusIds, start, end);
	}

	public int getTicketEntriesCount(Date modifiedDate) {
		return ticketEntryPersistence.countByGtModifiedDate(modifiedDate);
	}

	public int getTicketEntriesCount(long userId, long[] ticketStatusIds) {
		return ticketEntryPersistence.countByU_TSI(userId, ticketStatusIds);
	}

	@Indexable(type = IndexableType.REINDEX)
	public TicketEntry reindexTicketEntry(long ticketEntryId)
		throws PortalException {

		return ticketEntryPersistence.findByPrimaryKey(ticketEntryId);
	}

	public Hits search(
		long companyId, String keywords, int start, int end, Sort sort) {

		try {
			Indexer<TicketEntry> indexer =
				IndexerRegistryUtil.nullSafeGetIndexer(TicketEntry.class);

			SearchContext searchContext = new SearchContext();

			searchContext.setAndSearch(false);

			Map<String, Serializable> attributes = new HashMap<>();

			attributes.put("description", keywords);
			attributes.put("subject", keywords);

			searchContext.setAttributes(attributes);

			searchContext.setCompanyId(companyId);
			searchContext.setEnd(end);

			if (sort != null) {
				searchContext.setSorts(sort);
			}

			searchContext.setStart(start);

			QueryConfig queryConfig = searchContext.getQueryConfig();

			queryConfig.setHighlightEnabled(false);
			queryConfig.setScoreEnabled(false);

			return indexer.search(searchContext);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	public void sendEmail(
			long userId, TicketEntry ticketEntry, TicketComment ticketComment,
			String action)
		throws PortalException {
	}

	public void updatePendingTypes(
			long userId, long ticketEntryId, int[] pendingTypes)
		throws PortalException {

		TicketEntry ticketEntry = ticketEntryPersistence.findByPrimaryKey(
			ticketEntryId);

		if (ticketEntry.isClosed()) {
			return;
		}

		updatePendingTypes(userId, ticketEntry, pendingTypes);
	}

	public TicketEntry updateTicketEntry(
			long userId, long ticketEntryId, long reportedByUserId,
			long ticketStatusId, String languageId, String subject,
			String description, int weight, Date dueDate,
			Map<Long, String> ticketFieldsMap, ServiceContext serviceContext)
		throws PortalException {

		// Ticket entry

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		validate(subject, description);

		TicketEntry ticketEntry = ticketEntryPersistence.findByPrimaryKey(
			ticketEntryId);

		TicketEntry oldTicketEntry = (TicketEntry)ticketEntry.clone();

		if (ticketEntry.getUserId() != reportedByUserId) {
			User reportedByUser = userLocalService.getUser(reportedByUserId);

			ticketEntry.setUserId(reportedByUserId);
			ticketEntry.setUserName(reportedByUser.getFullName());
		}

		ticketEntry.setModifiedDate(now);
		ticketEntry.setTicketStatusId(ticketStatusId);
		ticketEntry.setLanguageId(languageId);
		ticketEntry.setSubject(subject);
		ticketEntry.setDescription(description);
		ticketEntry.setWeight(weight);

		if (ticketEntry.isClosed() && (ticketEntry.getClosedDate() == null)) {
			ticketEntry.setClosedDate(new Date());
		}

		if (dueDate != null) {
			ticketEntry.setDueDate(dueDate);
		}

		ticketEntryPersistence.update(ticketEntry);

		long auditSetId = auditEntryLocalService.getNextAuditSetId(
			TicketEntry.class.getName(), ticketEntryId);

		serviceContext.setAttribute("auditSetId", auditSetId);

		serviceContext.setCreateDate(now);

		// Ticket information

		ticketFieldDataLocalService.updateTicketFieldData(
			userId, ticketEntryId, ticketFieldsMap, serviceContext);

		// Audit entry

		updateAuditEntry(
			user.getUserId(), now, auditSetId, oldTicketEntry, ticketEntry);

		return ticketEntry;
	}

	public TicketEntry updateTicketStatus(
			long ticketEntryId, long ticketStatusId)
		throws PortalException {

		TicketEntry ticketEntry = ticketEntryPersistence.findByPrimaryKey(
			ticketEntryId);

		ticketEntry.setTicketStatusId(ticketStatusId);

		return ticketEntryPersistence.update(ticketEntry);
	}

	protected long getTicketNumber(long userId) {
		return counterLocalService.increment(
			TicketEntry.class.getName() + "#" + userId);
	}

	protected void updateAuditEntry(
			long userId, Date createDate, long auditSetId,
			TicketEntry oldTicketEntry, TicketEntry ticketEntry)
		throws PortalException {

		long ticketEntryId = ticketEntry.getTicketEntryId();

		if (oldTicketEntry.getUserId() != ticketEntry.getUserId()) {
			auditEntryLocalService.addAuditEntry(
				userId, createDate, TicketEntry.class, ticketEntryId,
				auditSetId, TicketEntry.class, ticketEntryId, Actions.UPDATE,
				Fields.REPORTED_BY, Visibilities.PUBLIC,
				oldTicketEntry.getUserName(), oldTicketEntry.getUserId(),
				ticketEntry.getUserName(), ticketEntry.getUserId(),
				StringPool.BLANK);
		}

		String oldSubject = oldTicketEntry.getSubject();

		if (!oldSubject.equals(ticketEntry.getSubject())) {
			auditEntryLocalService.addAuditEntry(
				userId, createDate, TicketEntry.class, ticketEntryId,
				auditSetId, TicketEntry.class, ticketEntryId, Actions.UPDATE,
				Fields.SUBJECT, Visibilities.PUBLIC, StringPool.BLANK,
				oldSubject, StringPool.BLANK, ticketEntry.getSubject(),
				StringPool.BLANK);
		}

		String oldDescription = oldTicketEntry.getDescription();

		if (!oldDescription.equals(ticketEntry.getDescription())) {
			auditEntryLocalService.addAuditEntry(
				userId, createDate, TicketEntry.class, ticketEntryId,
				auditSetId, TicketEntry.class, ticketEntryId, Actions.UPDATE,
				Fields.DESCRIPTION, Visibilities.PUBLIC, StringPool.BLANK,
				oldDescription, StringPool.BLANK, ticketEntry.getDescription(),
				StringPool.BLANK);
		}

		if (oldTicketEntry.getTicketStatusId() !=
				ticketEntry.getTicketStatusId()) {

			TicketStatus ticketStatus =
				ticketStatusPersistence.findByPrimaryKey(
					ticketEntry.getTicketStatusId());
			TicketStatus oldticketStatus =
				ticketStatusPersistence.findByPrimaryKey(
					oldTicketEntry.getTicketStatusId());

			Locale defaultLocale = LocaleUtil.getDefault();

			auditEntryLocalService.addAuditEntry(
				userId, createDate, TicketEntry.class, ticketEntryId,
				auditSetId, TicketStatus.class, ticketEntry.getTicketStatusId(),
				Actions.UPDATE, Fields.STATUS, Visibilities.PUBLIC,
				oldticketStatus.getName(defaultLocale),
				oldTicketEntry.getTicketStatusId(),
				ticketStatus.getName(defaultLocale),
				ticketEntry.getTicketStatusId(), StringPool.BLANK);
		}

		if (oldTicketEntry.getWeight() != ticketEntry.getWeight()) {
			auditEntryLocalService.addAuditEntry(
				userId, createDate, TicketEntry.class, ticketEntryId,
				auditSetId, TicketEntry.class, ticketEntryId, Actions.UPDATE,
				Fields.WEIGHT, Visibilities.ADMIN, StringPool.BLANK,
				oldTicketEntry.getWeight(), StringPool.BLANK,
				ticketEntry.getWeight(), StringPool.BLANK);
		}

		Date oldDueDate = oldTicketEntry.getDueDate();
		Date dueDate = ticketEntry.getDueDate();

		if (DateUtil.compareTo(oldDueDate, dueDate) != 0) {
			auditEntryLocalService.addAuditEntry(
				userId, createDate, TicketEntry.class, ticketEntryId,
				auditSetId, TicketEntry.class, ticketEntryId, Actions.UPDATE,
				Fields.DUE_DATE, Visibilities.WORKER, oldDueDate.toString(),
				oldDueDate.getTime(), dueDate.toString(), dueDate.getTime(),
				StringPool.BLANK);
		}
	}

	protected void updatePendingTypes(
			long userId, TicketEntry ticketEntry, int[] pendingTypes)
		throws PortalException {

		if (pendingTypes == null) {
			return;
		}

		Date now = new Date();

		long auditSetId = auditEntryLocalService.getNextAuditSetId(
			TicketEntry.class.getName(), ticketEntry.getTicketEntryId());

		Set<Integer> previousPendingTypes = new HashSet<>();

		List<TicketFlag> ticketFlags = ticketFlagPersistence.findByTEI_T_V(
			ticketEntry.getTicketEntryId(), TicketFlagType.PENDING_VALUES,
			TicketFlagValue.PENDING_TRUE);

		for (TicketFlag ticketFlag : ticketFlags) {
			previousPendingTypes.add(ticketFlag.getType());

			if (!ArrayUtil.contains(pendingTypes, ticketFlag.getType())) {
				ticketFlagPersistence.remove(ticketFlag.getTicketFlagId());

				auditEntryLocalService.addAuditEntry(
					userId, now, TicketEntry.class,
					ticketEntry.getTicketEntryId(), auditSetId,
					TicketFlag.class, ticketFlag.getTicketFlagId(),
					Actions.DELETE, ticketFlag.getTypeLabel(),
					Visibilities.PUBLIC, ticketFlag.getTypeLabel(),
					ticketFlag.getType(), StringPool.BLANK, StringPool.BLANK,
					StringPool.BLANK);
			}
		}

		for (int pendingType : pendingTypes) {
			if (!previousPendingTypes.contains(pendingType)) {
				TicketFlag ticketFlag = ticketFlagLocalService.updateTicketFlag(
					userId, ticketEntry.getTicketEntryId(), pendingType,
					TicketFlagValue.PENDING_TRUE);

				auditEntryLocalService.addAuditEntry(
					userId, now, TicketEntry.class,
					ticketEntry.getTicketEntryId(), auditSetId,
					TicketFlag.class, ticketFlag.getTicketFlagId(), Actions.ADD,
					ticketFlag.getTypeLabel(), Visibilities.PUBLIC,
					StringPool.BLANK, StringPool.BLANK,
					ticketFlag.getTypeLabel(), ticketFlag.getType(),
					StringPool.BLANK);
			}
		}

		ticketEntry.setModifiedDate(now);

		ticketEntryPersistence.update(ticketEntry);

		reindexTicketEntry(ticketEntry.getTicketEntryId());
	}

	protected void validate(String subject, String description)
		throws PortalException {

		if (Validator.isNull(subject)) {
			throw new TicketEntrySubjectException();
		}

		if (Validator.isNull(description)) {
			throw new TicketEntryDescriptionException();
		}
	}

	@Reference
	protected AuditEntryLocalService auditEntryLocalService;

	@BeanReference(type = TicketAttachmentLocalService.class)
	protected TicketAttachmentLocalService ticketAttachmentLocalService;

	@Reference
	protected TicketFieldDataLocalService ticketFieldDataLocalService;

	@BeanReference(type = TicketFlagLocalService.class)
	protected TicketFlagLocalService ticketFlagLocalService;

}