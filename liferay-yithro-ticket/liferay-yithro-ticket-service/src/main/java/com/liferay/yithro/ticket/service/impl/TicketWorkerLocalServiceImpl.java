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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.yithro.ticket.model.TicketWorker;
import com.liferay.yithro.ticket.service.TicketEntryLocalService;
import com.liferay.yithro.ticket.service.base.TicketWorkerLocalServiceBaseImpl;

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
			long workerUserId, long ticketEntryId, long sourceClassNameId,
			long sourceClassPK, int role, boolean primary)
		throws PortalException {

		User workerUser = userLocalService.getUser(workerUserId);

		TicketWorker ticketWorker = ticketWorkerPersistence.fetchByU_TEI(
			workerUserId, ticketEntryId);

		if (ticketWorker != null) {
			return updateTicketWorker(
				ticketWorker.getTicketWorkerId(), role, primary);
		}

		long ticketWorkerId = counterLocalService.increment();

		ticketWorker = ticketWorkerPersistence.create(ticketWorkerId);

		ticketWorker.setCompanyId(workerUser.getCompanyId());
		ticketWorker.setUserId(workerUserId);
		ticketWorker.setUserName(workerUser.getFullName());
		ticketWorker.setTicketEntryId(ticketEntryId);
		ticketWorker.setSourceClassNameId(sourceClassNameId);
		ticketWorker.setSourceClassPK(sourceClassPK);
		ticketWorker.setRole(role);

		ticketWorkerPersistence.update(ticketWorker);

		if (primary) {
			setPrimaryTicketWorker(ticketWorker);
		}

		// Ticket entry

		ticketEntryLocalService.reindexTicketEntry(
			ticketWorker.getTicketEntryId());

		return ticketWorker;
	}

	@Override
	public TicketWorker deleteTicketWorker(long ticketWorkerId)
		throws PortalException {

		TicketWorker ticketWorker = ticketWorkerPersistence.findByPrimaryKey(
			ticketWorkerId);

		ticketWorkerPersistence.remove(ticketWorker);

		// Ticket entry

		ticketEntryLocalService.reindexTicketEntry(
			ticketWorker.getTicketEntryId());

		return ticketWorker;
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

	public void setTicketWorkers(
			long ticketEntryId, long[] userIds, int[] roles, long primaryUserId)
		throws PortalException {

		List<TicketWorker> ticketWorkers =
			ticketWorkerPersistence.findByTicketEntryId(ticketEntryId);

		for (TicketWorker ticketWorker : ticketWorkers) {
			if (!ArrayUtil.contains(userIds, ticketWorker.getUserId())) {
				deleteTicketWorker(ticketWorker.getTicketWorkerId());
			}
		}

		for (int i = 0; i < userIds.length; i++) {
			long userId = userIds[i];
			int role = roles[i];

			boolean primary = false;

			if (userId == primaryUserId) {
				primary = true;
			}

			addTicketWorker(userId, ticketEntryId, 0, 0, role, primary);
		}
	}

	public TicketWorker updateTicketWorker(
			long ticketWorkerId, int role, boolean primary)
		throws PortalException {

		TicketWorker ticketWorker = ticketWorkerPersistence.findByPrimaryKey(
			ticketWorkerId);

		if (ticketWorker.getRole() != role) {
			ticketWorker.setRole(role);

			ticketWorkerPersistence.update(ticketWorker);
		}

		if (primary) {
			setPrimaryTicketWorker(ticketWorker);
		}

		ticketEntryLocalService.reindexTicketEntry(
			ticketWorker.getTicketEntryId());

		return ticketWorker;
	}

	protected void setPrimaryTicketWorker(TicketWorker ticketWorker)
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
	}

	@Reference
	protected TicketEntryLocalService ticketEntryLocalService;

}