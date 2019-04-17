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
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.service.base.TicketEntryServiceBaseImpl;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"json.web.service.context.name=yithro",
		"json.web.service.context.path=TicketEntry"
	},
	service = AopService.class
)
public class TicketEntryServiceImpl extends TicketEntryServiceBaseImpl {

	public TicketEntry addTicketEntry(
			String languageId, String subject, String description, int status,
			int weight, Map<Long, String> ticketFieldsMap,
			List<TicketAttachment> ticketAttachments)
		throws PortalException {

		return ticketEntryLocalService.addTicketEntry(
			getUserId(), languageId, subject, description, status, weight,
			ticketFieldsMap, ticketAttachments);
	}

}