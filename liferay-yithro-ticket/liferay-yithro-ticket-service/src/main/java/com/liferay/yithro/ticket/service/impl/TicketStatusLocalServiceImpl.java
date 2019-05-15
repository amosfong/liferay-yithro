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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.yithro.ticket.exception.TicketStatusNameException;
import com.liferay.yithro.ticket.model.TicketStatus;
import com.liferay.yithro.ticket.service.base.TicketStatusLocalServiceBaseImpl;
import com.liferay.yithro.ticket.util.comparator.TicketStatusOrderComparator;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketStatus",
	service = AopService.class
)
public class TicketStatusLocalServiceImpl
	extends TicketStatusLocalServiceBaseImpl {

	public TicketStatus addTicketStatus(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, int order, boolean terminal)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(nameMap);

		long ticketStatusId = counterLocalService.increment();

		TicketStatus ticketStatus = ticketStatusPersistence.create(
			ticketStatusId);

		ticketStatus.setCompanyId(user.getCompanyId());
		ticketStatus.setUserId(userId);
		ticketStatus.setNameMap(nameMap);
		ticketStatus.setDescriptionMap(descriptionMap);
		ticketStatus.setOrder(order);
		ticketStatus.setTerminal(terminal);
		ticketStatus.setStatus(WorkflowConstants.STATUS_APPROVED);

		return ticketStatusPersistence.update(ticketStatus);
	}

	public TicketStatus getInitialTicketStatus() throws PortalException {
		return ticketStatusPersistence.findByT_S_First(
			false, WorkflowConstants.STATUS_APPROVED, null);
	}

	public TicketStatus getNextTicketStatus(long ticketStatusId, int status)
		throws PortalException {

		TicketStatus[] ticketStatuses =
			ticketStatusPersistence.findByS_PrevAndNext(
				ticketStatusId, status, new TicketStatusOrderComparator(true));

		return ticketStatuses[2];
	}

	public List<TicketStatus> getTicketStatuses(
		boolean terminal, int status, int start, int end) {

		return ticketStatusPersistence.findByT_S(terminal, status, start, end);
	}

	public TicketStatus updateStatus(long ticketStatusId, int status)
		throws PortalException {

		TicketStatus ticketStatus = ticketStatusPersistence.findByPrimaryKey(
			ticketStatusId);

		ticketStatus.setStatus(status);

		return ticketStatusPersistence.update(ticketStatus);
	}

	public TicketStatus updateTicketStatus(
			long ticketStatusId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, int order, boolean terminal)
		throws PortalException {

		TicketStatus ticketStatus = ticketStatusPersistence.findByPrimaryKey(
			ticketStatusId);

		ticketStatus.setNameMap(nameMap);
		ticketStatus.setDescriptionMap(descriptionMap);
		ticketStatus.setOrder(order);
		ticketStatus.setTerminal(terminal);

		return ticketStatusPersistence.update(ticketStatus);
	}

	protected void validate(Map<Locale, String> nameMap)
		throws PortalException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String name = nameMap.get(defaultLocale);

		if (Validator.isNull(name)) {
			throw new TicketStatusNameException(
				"Name is null for locale " + defaultLocale.getDisplayName());
		}
	}

}