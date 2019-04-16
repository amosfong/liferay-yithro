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
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.service.base.TicketFieldLocalServiceBaseImpl;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketField",
	service = AopService.class
)
public class TicketFieldLocalServiceImpl
	extends TicketFieldLocalServiceBaseImpl {

	public TicketField addTicketField(
			Map<Locale, String> nameMap, int type, int visibility)
		throws PortalException {

		Date now = new Date();

		long ticketFieldId = counterLocalService.increment();

		TicketField ticketField = ticketFieldPersistence.create(ticketFieldId);

		ticketField.setCreateDate(now);
		ticketField.setModifiedDate(now);
		ticketField.setNameMap(nameMap);
		ticketField.setType(type);
		ticketField.setVisibility(visibility);

		return ticketFieldPersistence.update(ticketField);
	}

}