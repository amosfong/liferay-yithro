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

package com.liferay.yithro.support.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Time;
import com.liferay.yithro.support.exception.SupportWorkerMaxWorkException;
import com.liferay.yithro.support.model.SupportTeam;
import com.liferay.yithro.support.model.SupportWorker;
import com.liferay.yithro.support.service.base.SupportWorkerLocalServiceBaseImpl;
import com.liferay.yithro.ticket.model.TicketWorker;
import com.liferay.yithro.ticket.service.TicketWorkerLocalService;

import java.util.LinkedHashMap;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.support.model.SupportWorker",
	service = AopService.class
)
public class SupportWorkerLocalServiceImpl
	extends SupportWorkerLocalServiceBaseImpl {

	public void addSupportWorkers(
			long[] userIds, long supportTeamId, double[] maxWork, int[] roles)
		throws PortalException {

		SupportTeam supportTeam = supportTeamPersistence.findByPrimaryKey(
			supportTeamId);

		for (int i = 0; i < userIds.length; i++) {
			long userId = userIds[i];

			double curMaxWork = maxWork[i];

			validate(curMaxWork);

			SupportWorker supportWorker = supportWorkerPersistence.fetchByU_STI(
				userId, supportTeamId);

			if (supportWorker == null) {
				long supportWorkerId = counterLocalService.increment();

				supportWorker = supportWorkerPersistence.create(
					supportWorkerId);

				User user = userLocalService.getUser(userId);

				double assignedWork = getAssignedWork(userId);

				supportWorker.setCompanyId(user.getCompanyId());
				supportWorker.setUserId(userId);
				supportWorker.setSupportTeamId(supportTeamId);
				supportWorker.setAssignedWork(assignedWork);
				supportWorker.setMaxWork(curMaxWork);

				supportTeam.setAssignedWork(
					supportTeam.getAssignedWork() + assignedWork);
				supportTeam.setMaxWork(supportTeam.getMaxWork() + curMaxWork);
			}

			supportWorker.setRole(roles[i]);

			supportWorkerPersistence.update(supportWorker);

			supportTeamPersistence.update(supportTeam);
		}
	}

	public void decreaseAssignedWork(long userId, double work)
		throws PortalException {

		List<SupportWorker> supportWorkers =
			supportWorkerPersistence.findByUserId(userId);

		for (SupportWorker supportWorker : supportWorkers) {
			supportWorker.setAssignedWork(
				supportWorker.getAssignedWork() - work);

			supportWorkerPersistence.update(supportWorker);

			SupportTeam supportTeam = supportTeamPersistence.findByPrimaryKey(
				supportWorker.getSupportTeamId());

			supportTeam.setAssignedWork(supportTeam.getAssignedWork() - work);

			supportTeamPersistence.update(supportTeam);
		}
	}

	public void decreaseTicketEntryAssignedWork(long ticketEntryId, double work)
		throws PortalException {

		List<TicketWorker> ticketWorkers =
			ticketWorkerLocalService.getTicketWorkers(ticketEntryId);

		for (TicketWorker ticketWorker : ticketWorkers) {
			if (ticketWorker.isPrimary()) {
				decreaseAssignedWork(ticketWorker.getUserId(), work);
			}
		}
	}

	public void deleteSupportWorkers(long userId) throws PortalException {
		List<SupportWorker> supportWorkers = getUserSupportWorkers(userId);

		for (SupportWorker supportWorker : supportWorkers) {
			deleteSupportWorkers(
				new long[] {supportWorker.getSupportWorkerId()},
				supportWorker.getSupportTeamId());
		}
	}

	public void deleteSupportWorkers(long[] userIds, long supportTeamId)
		throws PortalException {

		SupportTeam supportTeam = supportTeamPersistence.findByPrimaryKey(
			supportTeamId);

		double supportTeamAssignedWork = supportTeam.getAssignedWork();
		double supportTeamMaxWork = supportTeam.getMaxWork();

		for (long userId : userIds) {
			SupportWorker supportWorker = supportWorkerPersistence.fetchByU_STI(
				userId, supportTeamId);

			if (supportWorker == null) {
				continue;
			}

			supportTeamAssignedWork -= supportWorker.getAssignedWork();
			supportTeamMaxWork -= supportWorker.getMaxWork();

			supportWorkerPersistence.remove(supportWorker);
		}

		supportTeam.setAssignedWork(supportTeamAssignedWork);
		supportTeam.setMaxWork(supportTeamMaxWork);

		supportTeamPersistence.update(supportTeam);
	}

	public double getAssignedWork(long userId) {

		// TODO

		return 0;
	}

	public SupportWorker getAvailableSupportWorker(long ticketEntryId)
		throws PortalException {

		// TODO

		return null;
	}

	public SupportWorker getLongestOpenSupportWorker(
			List<SupportWorker> supportWorkers, long ticketEntryId)
		throws PortalException {

		SupportWorker supportWorker = null;

		long timeUntilClose = 0;

		for (SupportWorker curSupportWorker : supportWorkers) {
			if (!curSupportWorker.isActive()) {
				continue;
			}

			if (ticketWorkerLocalService.hasTicketWorker(
					curSupportWorker.getUserId(), ticketEntryId)) {

				continue;
			}

			if (!curSupportWorker.isAvailable()) {
				continue;
			}

			Long curTimeUntilClose = curSupportWorker.getTimeUntilClose();

			if ((curTimeUntilClose == null) ||
				(curTimeUntilClose > (6 * Time.HOUR))) {

				curTimeUntilClose = 6 * Time.HOUR;
			}

			if ((supportWorker == null) ||
				(curTimeUntilClose > timeUntilClose)) {

				supportWorker = curSupportWorker;

				timeUntilClose = curTimeUntilClose;
			}
		}

		return supportWorker;
	}

	public SupportWorker getMostAvailableSupportWorker(
			long ticketEntryId, LinkedHashMap<String, Object> params)
		throws PortalException {

		// TODO

		return null;
	}

	public SupportWorker getNextOpenSupportWorker(
			List<SupportWorker> supportWorkers, long ticketEntryId)
		throws PortalException {

		SupportWorker supportWorker = null;

		long timeUntilOpen = 0;
		Long timeUntilClose = 0L;

		TicketWorker currentTicketWorker =
			ticketWorkerLocalService.fetchLatestTicketWorker(ticketEntryId);

		for (SupportWorker curSupportWorker : supportWorkers) {
			if (!curSupportWorker.isActive()) {
				continue;
			}

			if ((currentTicketWorker != null) &&
				(currentTicketWorker.getUserId() ==
					curSupportWorker.getUserId())) {

				continue;
			}

			Long curTimeUntilOpen = curSupportWorker.getTimeUntilOpen();

			if (curTimeUntilOpen == null) {
				continue;
			}

			Long curTimeUntilClose = curSupportWorker.getTimeUntilClose();

			if ((curTimeUntilClose == null) ||
				(curTimeUntilClose > (6 * Time.HOUR))) {

				curTimeUntilClose = 6 * Time.HOUR;
			}

			if (ticketWorkerLocalService.hasTicketWorker(
					curSupportWorker.getUserId(), ticketEntryId)) {

				if (curTimeUntilOpen == 0) {
					curTimeUntilClose += 30 * Time.MINUTE;
				}
				else {
					curTimeUntilOpen -= 30 * Time.MINUTE;

					if (curTimeUntilOpen < 0) {
						curTimeUntilOpen = 0L;
					}
				}
			}

			if (supportWorker != null) {
				if (curTimeUntilOpen > timeUntilOpen) {
					continue;
				}

				if ((curTimeUntilOpen == timeUntilOpen) &&
					(timeUntilClose >= curTimeUntilClose)) {

					continue;
				}
			}

			supportWorker = curSupportWorker;

			timeUntilOpen = curTimeUntilOpen;
			timeUntilClose = curTimeUntilClose;
		}

		return supportWorker;
	}

	public List<SupportWorker> getSupportTeamSupportWorkers(
		long supportTeamId) {

		return supportWorkerPersistence.findBySupportTeamId(supportTeamId);
	}

	public SupportWorker getSupportWorker(long userId, long supportTeamId)
		throws PortalException {

		return supportWorkerPersistence.findByU_STI(userId, supportTeamId);
	}

	public List<SupportWorker> getSupportWorkersBySupportLaborId(
			long supportLaborId)
		throws PortalException {

		return supportWorkerPersistence.findBySupportLaborId(supportLaborId);
	}

	public int getSupportWorkersCountBySupportLaborId(long supportLaborId)
		throws PortalException {

		return supportWorkerPersistence.countBySupportLaborId(supportLaborId);
	}

	public List<SupportWorker> getUserSupportWorkers(long userId) {
		return supportWorkerPersistence.findByUserId(userId);
	}

	public void increaseAssignedWork(long userId, double work)
		throws PortalException {

		List<SupportWorker> supportWorkers =
			supportWorkerPersistence.findByUserId(userId);

		for (SupportWorker supportWorker : supportWorkers) {
			supportWorker.setAssignedWork(
				supportWorker.getAssignedWork() + work);

			supportWorkerPersistence.update(supportWorker);

			SupportTeam supportTeam = supportTeamPersistence.findByPrimaryKey(
				supportWorker.getSupportTeamId());

			supportTeam.setAssignedWork(supportTeam.getAssignedWork() + work);

			supportTeamPersistence.update(supportTeam);
		}
	}

	public void increaseTicketEntryAssignedWork(long ticketEntryId, double work)
		throws PortalException {

		List<TicketWorker> ticketWorkers =
			ticketWorkerLocalService.getTicketWorkers(ticketEntryId);

		for (TicketWorker ticketWorker : ticketWorkers) {
			if (ticketWorker.isPrimary()) {
				increaseAssignedWork(ticketWorker.getUserId(), work);
			}
		}
	}

	public void recalculateUtilization() {

		// TODO

	}

	public SupportWorker updateSupportWorker(
			long supportWorkerId, long supportTeamId, double maxWork)
		throws PortalException {

		validate(maxWork);

		SupportTeam supportTeam = supportTeamPersistence.findByPrimaryKey(
			supportTeamId);

		SupportWorker supportWorker = supportWorkerPersistence.findByPrimaryKey(
			supportWorkerId);

		if (supportTeamId != supportWorker.getSupportTeamId()) {
			SupportTeam oldSupportTeam = supportWorker.getSupportTeam();

			oldSupportTeam.setAssignedWork(
				oldSupportTeam.getAssignedWork() -
					supportWorker.getAssignedWork());
			oldSupportTeam.setMaxWork(
				oldSupportTeam.getMaxWork() - supportWorker.getMaxWork());

			supportTeam.setAssignedWork(
				supportTeam.getAssignedWork() +
					supportWorker.getAssignedWork());
			supportTeam.setMaxWork(supportTeam.getMaxWork() + maxWork);

			supportTeamPersistence.update(oldSupportTeam);
		}
		else {
			supportTeam.setMaxWork(
				supportTeam.getMaxWork() + maxWork -
					supportWorker.getMaxWork());
		}

		supportTeamPersistence.update(supportTeam);

		supportWorker.setSupportTeamId(supportTeamId);
		supportWorker.setMaxWork(maxWork);

		return supportWorkerPersistence.update(supportWorker);
	}

	protected void validate(double maxWork) throws PortalException {
		if (maxWork <= 0) {
			throw new SupportWorkerMaxWorkException();
		}
	}

	@Reference
	protected TicketWorkerLocalService ticketWorkerLocalService;

}