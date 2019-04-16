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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.yithro.audit.constants.Actions;
import com.liferay.yithro.audit.service.AuditEntryLocalService;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.constants.TicketFlagType;
import com.liferay.yithro.ticket.constants.TicketFlagValue;
import com.liferay.yithro.ticket.model.TicketComment;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.model.TicketFlag;
import com.liferay.yithro.ticket.service.TicketFlagLocalService;
import com.liferay.yithro.ticket.service.base.TicketEntryLocalServiceBaseImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
	public TicketEntry reindexTicketEntry(long ticketEntryId)
		throws PortalException {

		return ticketEntryPersistence.findByPrimaryKey(ticketEntryId);
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
			ticketEntry.getTicketEntryId(), TicketFlagType.PENDING_ALL,
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
					StringPool.BLANK, true);
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
					StringPool.BLANK, false);
			}
		}

		ticketEntry.setModifiedDate(now);

		ticketEntryPersistence.update(ticketEntry);

		reindexTicketEntry(ticketEntry.getTicketEntryId());
	}

	@Reference
	protected AuditEntryLocalService auditEntryLocalService;

	@Reference
	protected TicketFlagLocalService ticketFlagLocalService;

}