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
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.yithro.ticket.exception.TicketFieldOptionNameException;
import com.liferay.yithro.ticket.model.TicketFieldOption;
import com.liferay.yithro.ticket.service.base.TicketFieldOptionLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketFieldOptionOption",
	service = AopService.class
)
public class TicketFieldOptionLocalServiceImpl
	extends TicketFieldOptionLocalServiceBaseImpl {

	public TicketFieldOption addTicketFieldOption(
			long companyId, long ticketFieldId, Map<Locale, String> nameMap,
			int visibility, int order, int status)
		throws PortalException {

		Date now = new Date();

		validate(nameMap);

		long ticketFieldOptionId = counterLocalService.increment();

		TicketFieldOption ticketFieldOption =
			ticketFieldOptionPersistence.create(ticketFieldOptionId);

		ticketFieldOption.setCompanyId(companyId);
		ticketFieldOption.setCreateDate(now);
		ticketFieldOption.setModifiedDate(now);
		ticketFieldOption.setTicketFieldId(ticketFieldId);
		ticketFieldOption.setNameMap(nameMap);
		ticketFieldOption.setVisibility(visibility);
		ticketFieldOption.setOrder(order);
		ticketFieldOption.setStatus(WorkflowConstants.STATUS_APPROVED);

		return ticketFieldOptionPersistence.update(ticketFieldOption);
	}

	public List<TicketFieldOption> getTicketFieldOptions(long ticketFieldId) {
		return ticketFieldOptionPersistence.findByTicketFieldId(ticketFieldId);
	}

	public List<TicketFieldOption> getTicketFieldOptions(
		long ticketFieldId, int status) {

		return ticketFieldOptionPersistence.findByTFI_S(ticketFieldId, status);
	}

	public TicketFieldOption updateTicketFieldOption(
			long ticketFieldOptionId, Map<Locale, String> nameMap,
			int visibility, int order)
		throws PortalException {

		validate(nameMap);

		TicketFieldOption ticketFieldOption =
			ticketFieldOptionPersistence.findByPrimaryKey(ticketFieldOptionId);

		ticketFieldOption.setModifiedDate(new Date());
		ticketFieldOption.setNameMap(nameMap);
		ticketFieldOption.setVisibility(visibility);
		ticketFieldOption.setOrder(order);

		return ticketFieldOptionPersistence.update(ticketFieldOption);
	}

	protected void validate(Map<Locale, String> nameMap)
		throws PortalException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String name = nameMap.get(defaultLocale);

		if (Validator.isNull(name)) {
			throw new TicketFieldOptionNameException(
				"Name is null for locale " + defaultLocale.getDisplayName());
		}
	}

}