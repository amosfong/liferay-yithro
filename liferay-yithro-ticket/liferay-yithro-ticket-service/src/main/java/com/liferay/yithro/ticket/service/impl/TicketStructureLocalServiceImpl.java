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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.ticket.exception.TicketStructureNameException;
import com.liferay.yithro.ticket.model.TicketStructure;
import com.liferay.yithro.ticket.service.base.TicketStructureLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketStructure",
	service = AopService.class
)
public class TicketStructureLocalServiceImpl
	extends TicketStructureLocalServiceBaseImpl {

	public TicketStructure addTicketStructure(
			long userId, String name, String description, String structure)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(name);

		long ticketStructureId = counterLocalService.increment();

		TicketStructure ticketStructure = ticketStructurePersistence.create(
			ticketStructureId);

		ticketStructure.setCompanyId(user.getCompanyId());
		ticketStructure.setUserId(userId);
		ticketStructure.setName(name);
		ticketStructure.setDescription(description);
		ticketStructure.setStructure(structure);

		return ticketStructurePersistence.update(ticketStructure);
	}

	public TicketStructure updateTicketStructure(
			long ticketStructureId, String name, String description,
			String structure)
		throws PortalException {

		validate(name);

		TicketStructure ticketStructure =
			ticketStructurePersistence.findByPrimaryKey(ticketStructureId);

		ticketStructure.setModifiedDate(new Date());
		ticketStructure.setName(name);
		ticketStructure.setDescription(description);
		ticketStructure.setStructure(structure);

		return ticketStructurePersistence.update(ticketStructure);
	}

	protected void validate(String name) throws PortalException {
		if (Validator.isNull(name)) {
			throw new TicketStructureNameException();
		}
	}

}