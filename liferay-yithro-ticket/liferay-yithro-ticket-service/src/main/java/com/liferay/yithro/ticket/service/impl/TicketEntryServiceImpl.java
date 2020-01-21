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
import com.liferay.yithro.constants.ActionKeys;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.permission.TicketEntryPermission;
import com.liferay.yithro.ticket.permission.TicketResourcePermission;
import com.liferay.yithro.ticket.service.base.TicketEntryServiceBaseImpl;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

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
			long groupId, long ticketStructureId, long ticketStatusId,
			String languageId, String summary, String description, int weight,
			Map<Long, String> ticketFieldsMap,
			List<TicketAttachment> ticketAttachments)
		throws PortalException {

		_ticketResourcePermission.check(
			getPermissionChecker(), groupId, ActionKeys.ADD_TICKET);

		return ticketEntryLocalService.addTicketEntry(
			getUserId(), groupId, ticketStructureId, ticketStatusId, languageId,
			summary, description, weight, ticketFieldsMap, ticketAttachments);
	}

	public TicketEntry updateTicketEntry(
			long ticketEntryId, long reporterUserId, String summary,
			String description)
		throws PortalException {

		TicketEntry ticketEntry = ticketEntryLocalService.getTicketEntry(
			ticketEntryId);

		_ticketEntryPermission.check(
			getPermissionChecker(), ticketEntry, ActionKeys.UPDATE);

		return ticketEntryLocalService.updateTicketEntry(
			ticketEntryId, reporterUserId, ticketEntry.getTicketStatusId(),
			ticketEntry.getLanguageId(), summary, description,
			ticketEntry.getWeight(), ticketEntry.getDueDate());
	}

	public TicketEntry updateTicketStatus(
			long ticketEntryId, long ticketStatusId)
		throws PortalException {

		_ticketEntryPermission.check(
			getPermissionChecker(), ticketEntryId, ActionKeys.UPDATE);

		return ticketEntryLocalService.updateTicketStatus(
			ticketEntryId, ticketStatusId);
	}

	@Reference
	private TicketEntryPermission _ticketEntryPermission;

	@Reference
	private TicketResourcePermission _ticketResourcePermission;

}