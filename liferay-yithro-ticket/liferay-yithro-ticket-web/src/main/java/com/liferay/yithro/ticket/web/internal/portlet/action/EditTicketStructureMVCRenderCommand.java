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
import com.liferay.yithro.ticket.model.TicketStructure;
import com.liferay.yithro.ticket.service.TicketStructureLocalService;

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
		"javax.portlet.name=" + TicketPortletKeys.TICKET_CONFIGURATION,
		"mvc.command.name=/ticket_configuration/edit_ticket_structure"
	},
	service = MVCRenderCommand.class
)
public class EditTicketStructureMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		try {
			long ticketStructureId = ParamUtil.getLong(
				renderRequest, "ticketStructureId");

			if (ticketStructureId > 0) {
				TicketStructure ticketStructure =
					_ticketStructureLocalService.getTicketStructure(
						ticketStructureId);

				renderRequest.setAttribute(
					TicketWebKeys.TICKET_STRUCTURE, ticketStructure);
			}

			return "/ticket_configuration/edit_ticket_structure.jsp";
		}
		catch (Exception e) {
			SessionErrors.add(renderRequest, e.getClass());

			return "/ticket_configuration/error.jsp";
		}
	}

	@Reference
	private TicketStructureLocalService _ticketStructureLocalService;

}