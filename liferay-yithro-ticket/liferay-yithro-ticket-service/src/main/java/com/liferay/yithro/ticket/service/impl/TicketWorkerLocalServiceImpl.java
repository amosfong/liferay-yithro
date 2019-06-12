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
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.yithro.audit.constants.Actions;
import com.liferay.yithro.audit.constants.Fields;
import com.liferay.yithro.audit.service.AuditEntryLocalService;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.constants.TicketWorkerRoles;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.model.TicketWorker;
import com.liferay.yithro.ticket.service.TicketEntryLocalService;
import com.liferay.yithro.ticket.service.base.TicketWorkerLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketWorker",
	service = AopService.class
)
public class TicketWorkerLocalServiceImpl
	extends TicketWorkerLocalServiceBaseImpl {

	public TicketWorker addTicketWorker(
			long userId, long workerUserId, long ticketEntryId,
			long sourceClassNameId, long sourceClassPK, int role,
			boolean primary)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		User workerUser = userLocalService.getUser(workerUserId);
		Date now = new Date();

		TicketWorker ticketWorker = ticketWorkerPersistence.fetchByU_TEI(
			workerUserId, ticketEntryId);

		if (ticketWorker != null) {
			return updateTicketWorker(
				userId, ticketWorker.getTicketWorkerId(), role, primary);
		}

		long ticketWorkerId = counterLocalService.increment();

		ticketWorker = ticketWorkerPersistence.create(ticketWorkerId);

		ticketWorker.setCompanyId(user.getCompanyId());
		ticketWorker.setUserId(workerUserId);
		ticketWorker.setUserName(workerUser.getFullName());
		ticketWorker.setTicketEntryId(ticketEntryId);
		ticketWorker.setSourceClassNameId(sourceClassNameId);
		ticketWorker.setSourceClassPK(sourceClassPK);
		ticketWorker.setRole(role);

		ticketWorkerPersistence.update(ticketWorker);

		// Audit entry

		long auditSetId = auditEntryLocalService.getNextAuditSetId(
			TicketEntry.class.getName(), ticketEntryId);

		auditEntryLocalService.addAuditEntry(
			userId, now, TicketEntry.class, ticketEntryId, auditSetId,
			TicketWorker.class, ticketWorkerId, Actions.ASSIGN, Fields.USER,
			Visibilities.PUBLIC, StringPool.BLANK, StringPool.BLANK,
			workerUser.getFullName(), workerUserId, StringPool.BLANK);

		auditEntryLocalService.addAuditEntry(
			userId, now, TicketEntry.class, ticketEntryId, auditSetId,
			TicketWorker.class, ticketWorkerId, Actions.ASSIGN, Fields.ROLE,
			Visibilities.WORKER, StringPool.BLANK, StringPool.BLANK,
			ticketWorker.getRoleLabel(), ticketWorker.getRole(),
			StringPool.BLANK);

		if (primary) {
			setPrimaryTicketWorker(userId, now, ticketWorker, auditSetId);
		}

		// Ticket entry

		ticketEntryLocalService.reindexTicketEntry(
			ticketWorker.getTicketEntryId());

		return ticketWorker;
	}

	public void deleteTicketWorker(long userId, long ticketWorkerId)
		throws PortalException {

		Date now = new Date();

		TicketWorker ticketWorker = ticketWorkerPersistence.findByPrimaryKey(
			ticketWorkerId);

		ticketWorkerPersistence.remove(ticketWorker);

		// Audit entry

		long auditSetId = auditEntryLocalService.getNextAuditSetId(
			TicketEntry.class.getName(), ticketWorker.getTicketEntryId());

		User ticketWorkerUser = userLocalService.getUser(
			ticketWorker.getUserId());

		auditEntryLocalService.addAuditEntry(
			userId, now, TicketEntry.class, ticketWorker.getTicketEntryId(),
			auditSetId, TicketWorker.class, ticketWorker.getTicketWorkerId(),
			Actions.UNASSIGN, Fields.USER, Visibilities.PUBLIC,
			ticketWorkerUser.getFullName(), ticketWorkerUser.getUserId(),
			StringPool.BLANK, StringPool.BLANK, StringPool.BLANK);

		auditEntryLocalService.addAuditEntry(
			userId, now, TicketEntry.class, ticketWorker.getTicketEntryId(),
			auditSetId, TicketWorker.class, ticketWorker.getTicketWorkerId(),
			Actions.UNASSIGN, Fields.ROLE, Visibilities.WORKER,
			ticketWorker.getRoleLabel(), String.valueOf(ticketWorker.getRole()),
			StringPool.BLANK, StringPool.BLANK, StringPool.BLANK);

		// Ticket entry

		ticketEntryLocalService.reindexTicketEntry(
			ticketWorker.getTicketEntryId());
	}

	public void deleteTicketWorkers(long userId) throws PortalException {
		List<TicketWorker> ticketWorkers = ticketWorkerPersistence.findByUserId(
			userId);

		for (TicketWorker ticketWorker : ticketWorkers) {
			ticketWorkerPersistence.remove(ticketWorker);

			ticketEntryLocalService.reindexTicketEntry(
				ticketWorker.getTicketEntryId());
		}
	}

	public TicketWorker fetchLatestTicketWorker(long ticketEntryId) {
		return ticketWorkerPersistence.fetchByTicketEntryId_First(
			ticketEntryId, null);
	}

	public TicketWorker fetchPrimaryTicketWorker(long ticketEntryId) {
		return ticketWorkerPersistence.fetchByTEI_P(ticketEntryId, true);
	}

	public TicketWorker fetchTicketWorker(long userId, long ticketEntryId) {
		return ticketWorkerPersistence.fetchByU_TEI(userId, ticketEntryId);
	}

	public TicketWorker getTicketWorker(long userId, long ticketEntryId)
		throws PortalException {

		return ticketWorkerPersistence.findByU_TEI(userId, ticketEntryId);
	}

	public List<TicketWorker> getTicketWorkers(long ticketEntryId) {
		return ticketWorkerPersistence.findByTicketEntryId(ticketEntryId);
	}

	public List<TicketWorker> getTicketWorkers(
		long sourceClassNameId, long sourceClassPK) {

		return ticketWorkerPersistence.findBySCNI_SCPK(
			sourceClassNameId, sourceClassPK);
	}

	public List<TicketWorker> getUserTicketWorkers(long userId) {
		return ticketWorkerPersistence.findByUserId(userId);
	}

	public int getUserTicketWorkersCount(long userId) {
		return ticketWorkerPersistence.countByUserId(userId);
	}

	public boolean hasTicketWorker(long userId, long ticketEntryId) {
		TicketWorker ticketWorker = ticketWorkerPersistence.fetchByU_TEI(
			userId, ticketEntryId);

		if (ticketWorker == null) {
			return false;
		}

		return true;
	}

	public TicketWorker updateTicketWorker(
			long userId, long ticketWorkerId, int role, boolean primary)
		throws PortalException {

		Date now = new Date();

		TicketWorker ticketWorker = ticketWorkerPersistence.findByPrimaryKey(
			ticketWorkerId);

		long auditSetId = auditEntryLocalService.getNextAuditSetId(
			TicketEntry.class.getName(), ticketWorker.getTicketEntryId());

		if (ticketWorker.getRole() != role) {

			// Ticket worker

			int oldRole = ticketWorker.getRole();

			ticketWorker.setRole(role);

			ticketWorkerPersistence.update(ticketWorker);

			// Audit entry

			auditEntryLocalService.addAuditEntry(
				userId, now, TicketEntry.class, ticketWorker.getTicketEntryId(),
				auditSetId, TicketWorker.class,
				ticketWorker.getTicketWorkerId(), Actions.UPDATE, Fields.ROLE,
				Visibilities.WORKER, TicketWorkerRoles.getLabel(oldRole),
				oldRole, ticketWorker.getRoleLabel(), ticketWorker.getRole(),
				StringPool.BLANK);
		}

		if (primary) {
			setPrimaryTicketWorker(userId, now, ticketWorker, auditSetId);
		}

		ticketEntryLocalService.reindexTicketEntry(
			ticketWorker.getTicketEntryId());

		return ticketWorker;
	}

	protected void setPrimaryTicketWorker(
			long userId, Date now, TicketWorker ticketWorker, long auditSetId)
		throws PortalException {

		if (ticketWorker.isPrimary()) {
			return;
		}

		TicketWorker oldTicketWorker = ticketWorkerPersistence.fetchByTEI_P(
			ticketWorker.getTicketEntryId(), true);

		if (oldTicketWorker != null) {
			oldTicketWorker.setPrimary(false);

			ticketWorkerPersistence.update(oldTicketWorker);
		}

		ticketWorker.setPrimary(true);

		ticketWorkerPersistence.update(ticketWorker);

		// Audit entry

		auditEntryLocalService.addAuditEntry(
			userId, now, TicketEntry.class, ticketWorker.getTicketEntryId(),
			auditSetId, TicketWorker.class, ticketWorker.getTicketWorkerId(),
			Actions.ASSIGN, Fields.PRIMARY, Visibilities.WORKER,
			oldTicketWorker.getUserName(), oldTicketWorker.getUserId(),
			ticketWorker.getUserName(), ticketWorker.getUserId(),
			StringPool.BLANK);
	}

	@Reference
	protected AuditEntryLocalService auditEntryLocalService;

	@Reference
	protected TicketEntryLocalService ticketEntryLocalService;

}