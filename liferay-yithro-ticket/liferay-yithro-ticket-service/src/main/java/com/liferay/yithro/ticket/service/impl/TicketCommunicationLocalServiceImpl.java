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
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.yithro.ticket.model.TicketCommunication;
import com.liferay.yithro.ticket.service.base.TicketCommunicationLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketCommunication",
	service = AopService.class
)
public class TicketCommunicationLocalServiceImpl
	extends TicketCommunicationLocalServiceBaseImpl {

	public TicketCommunication addTicketCommunication(
			long userId, long ticketEntryId, String channel,
			JSONObject dataJSONObject, int visibility)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		ticketEntryPersistence.findByPrimaryKey(ticketEntryId);

		long ticketCommunicationId = counterLocalService.increment();

		TicketCommunication ticketCommunication =
			ticketCommunicationPersistence.create(ticketCommunicationId);

		ticketCommunication.setUserId(user.getUserId());
		ticketCommunication.setTicketEntryId(ticketEntryId);
		ticketCommunication.setChannel(channel);
		ticketCommunication.setData(dataJSONObject.toString());
		ticketCommunication.setVisibility(visibility);

		return ticketCommunicationPersistence.update(ticketCommunication);
	}

	public List<TicketCommunication> getTicketCommunications(
			long ticketEntryId, int visibility, int start, int end)
		throws PortalException {

		return ticketCommunicationPersistence.findByTEI_V(
			ticketEntryId, visibility, start, end);
	}

	public TicketCommunication updateTicketCommunication(
			long ticketCommunicationId, JSONObject dataJSONObject)
		throws PortalException {

		TicketCommunication ticketCommunication =
			ticketCommunicationPersistence.findByPrimaryKey(
				ticketCommunicationId);

		ticketCommunication.setData(dataJSONObject.toString());

		return ticketCommunicationPersistence.update(ticketCommunication);
	}

}