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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.exception.TicketStructureNameException;
import com.liferay.yithro.ticket.service.TicketStructureLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
	service = MVCActionCommand.class
)
public class EditTicketStructureMVCActionCommand extends BaseMVCActionCommand {

	protected void deleteTicketStructure(ActionRequest actionRequest)
		throws PortalException {

		long ticketStructureId = ParamUtil.getLong(
			actionRequest, "ticketStructureId");

		_ticketStructureLocalService.deleteTicketStructure(ticketStructureId);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteTicketStructure(actionRequest);
			}
			else {
				updateTicketStructure(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof TicketStructureNameException) {
				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					"/ticket_configuration/edit_ticket_structure");
			}
			else {
				_log.error(e, e);

				throw e;
			}
		}
	}

	protected void updateTicketStructure(ActionRequest actionRequest)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long ticketStructureId = ParamUtil.getLong(
			actionRequest, "ticketStructureId");

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		String structure = ParamUtil.getString(actionRequest, "structure");

		if (ticketStructureId <= 0) {
			_ticketStructureLocalService.addTicketStructure(
				themeDisplay.getUserId(), name, description, structure);
		}
		else {
			_ticketStructureLocalService.updateTicketStructure(
				ticketStructureId, name, description, structure);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditTicketStructureMVCActionCommand.class);

	@Reference
	private TicketStructureLocalService _ticketStructureLocalService;

}