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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.yithro.ticket.model.TicketFlag;
import com.liferay.yithro.ticket.service.base.TicketFlagLocalServiceBaseImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 * @author Alan Zhang
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketFlag",
	service = AopService.class
)
public class TicketFlagLocalServiceImpl extends TicketFlagLocalServiceBaseImpl {

	public void deleteTicketFlags(long ticketEntryId, int type, int value) {
		ticketFlagPersistence.removeByTEI_T_V(ticketEntryId, type, value);
	}

	public List<TicketFlag> getTicketFlags(
		long ticketEntryId, int type, int value) {

		return ticketFlagPersistence.findByTEI_T_V(ticketEntryId, type, value);
	}

	public List<TicketFlag> getTicketFlags(
		long ticketEntryId, int[] types, int value) {

		return ticketFlagPersistence.findByTEI_T_V(ticketEntryId, types, value);
	}

	public int getTicketFlagsCount(long ticketEntryId, int type, int value) {
		return ticketFlagPersistence.countByTEI_T_V(ticketEntryId, type, value);
	}

	public int[] getTicketFlagTypes(
		long ticketEntryId, int[] types, int value) {

		Set<Integer> ticketFlagTypes = new HashSet<>();

		List<TicketFlag> ticketFlags = ticketFlagPersistence.findByTEI_T_V(
			ticketEntryId, types, value);

		for (TicketFlag ticketFlag : ticketFlags) {
			ticketFlagTypes.add(ticketFlag.getType());
		}

		return ArrayUtil.toArray(ticketFlagTypes.toArray(new Integer[0]));
	}

	public boolean hasTicketFlag(long ticketEntryId, int type, int value) {
		if (ticketFlagPersistence.countByTEI_T_V(ticketEntryId, type, value) >
				0) {

			return true;
		}

		return false;
	}

	public TicketFlag updateTicketFlag(
			long userId, long ticketEntryId, int type, int value)
		throws PortalException {

		validate(userId, ticketEntryId, type);

		TicketFlag ticketFlag = ticketFlagPersistence.fetchByU_TEI_T(
			userId, ticketEntryId, type);

		if (ticketFlag == null) {
			long ticketFlagId = counterLocalService.increment();

			ticketFlag = ticketFlagPersistence.create(ticketFlagId);
		}

		ticketFlag.setUserId(userId);
		ticketFlag.setModifiedDate(new Date());
		ticketFlag.setTicketEntryId(ticketEntryId);
		ticketFlag.setType(type);
		ticketFlag.setValue(value);

		return ticketFlagPersistence.update(ticketFlag);
	}

	protected void validate(long userId, long ticketEntryId, int type)
		throws PortalException {

		userLocalService.getUser(userId);

		ticketEntryPersistence.findByPrimaryKey(ticketEntryId);
	}

}