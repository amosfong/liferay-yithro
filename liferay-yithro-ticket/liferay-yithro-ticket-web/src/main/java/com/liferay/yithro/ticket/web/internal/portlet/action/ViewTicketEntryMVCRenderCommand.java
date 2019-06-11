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

package com.liferay.yithro.ticket.web.internal.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.constants.TicketWebKeys;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.service.TicketEntryLocalService;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"javax.portlet.name=" + TicketPortletKeys.MY_REQUESTED_TICKETS,
		"javax.portlet.name=" + TicketPortletKeys.SIMPLE_TICKET_SEARCH,
		"mvc.command.name=/view_ticket_entry"
	},
	service = MVCRenderCommand.class
)
public class ViewTicketEntryMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		try {
			long ticketEntryId = ParamUtil.getLong(
				renderRequest, "ticketEntryId");

			if (ticketEntryId > 0) {
				TicketEntry ticketEntry =
					_ticketEntryLocalService.getTicketEntry(ticketEntryId);

				renderRequest.setAttribute(
					TicketWebKeys.TICKET_ENTRY, ticketEntry);
			}

			return "/common/view_ticket_entry.jsp";
		}
		catch (Exception e) {
			SessionErrors.add(renderRequest, e.getClass());

			return "/common/error.jsp";
		}
	}

	@Reference
	private TicketEntryLocalService _ticketEntryLocalService;

}