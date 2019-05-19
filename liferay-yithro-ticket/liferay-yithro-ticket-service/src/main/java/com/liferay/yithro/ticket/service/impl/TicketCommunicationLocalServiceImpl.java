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
			long userId, long ticketEntryId, Class<?> clazz, long classPK,
			String content, JSONObject propertiesJSONObject)
		throws PortalException {

		long classNameId = classNameLocalService.getClassNameId(clazz);

		return addTicketCommunication(
			userId, ticketEntryId, classNameId, classPK, content,
			propertiesJSONObject);
	}

	public TicketCommunication addTicketCommunication(
			long userId, long ticketEntryId, long classNameId, long classPK,
			String content, JSONObject propertiesJSONObject)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		ticketEntryPersistence.findByPrimaryKey(ticketEntryId);

		long ticketCommunicationId = counterLocalService.increment();

		TicketCommunication ticketCommunication =
			ticketCommunicationPersistence.create(ticketCommunicationId);

		ticketCommunication.setUserId(user.getUserId());
		ticketCommunication.setTicketEntryId(ticketEntryId);
		ticketCommunication.setClassNameId(classNameId);
		ticketCommunication.setClassPK(classPK);
		ticketCommunication.setContent(content);
		ticketCommunication.setProperties(propertiesJSONObject.toString());

		return ticketCommunicationPersistence.update(ticketCommunication);
	}

	public TicketCommunication deleteTicketCommunication(
			Class<?> clazz, long classPK)
		throws PortalException {

		long classNameId = classNameLocalService.getClassNameId(clazz);

		return deleteTicketCommunication(classNameId, classPK);
	}

	public TicketCommunication deleteTicketCommunication(
			long classNameId, long classPK)
		throws PortalException {

		return ticketCommunicationPersistence.removeByC_C(classNameId, classPK);
	}

	public TicketCommunication fetchTicketCommunication(
		Class<?> clazz, long classPK) {

		long classNameId = classNameLocalService.getClassNameId(clazz);

		return fetchTicketCommunication(classNameId, classPK);
	}

	public TicketCommunication fetchTicketCommunication(
		long classNameId, long classPK) {

		return ticketCommunicationPersistence.fetchByC_C(classNameId, classPK);
	}

	public List<TicketCommunication> getTicketCommunications(long ticketEntryId)
		throws PortalException {

		return ticketCommunicationPersistence.findByTicketEntryId(
			ticketEntryId);
	}

	public TicketCommunication updateTicketCommunication(
			long ticketCommunicationId, String content,
			JSONObject propertiesJSONObject)
		throws PortalException {

		TicketCommunication ticketCommunication =
			ticketCommunicationPersistence.findByPrimaryKey(
				ticketCommunicationId);

		ticketCommunication.setContent(content);
		ticketCommunication.setProperties(propertiesJSONObject.toString());

		return ticketCommunicationPersistence.update(ticketCommunication);
	}

}