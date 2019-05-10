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
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.exception.TicketStatusNameException;
import com.liferay.yithro.ticket.service.TicketStatusLocalService;

import java.util.Locale;
import java.util.Map;

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
		"mvc.command.name=/ticket_configuration/edit_ticket_status"
	},
	service = MVCActionCommand.class
)
public class EditTicketStatusMVCActionCommand extends BaseMVCActionCommand {

	protected void deleteTicketStatus(ActionRequest actionRequest)
		throws PortalException {

		long ticketStatusId = ParamUtil.getLong(
			actionRequest, "ticketStatusId");

		_ticketStatusLocalService.deleteTicketStatus(ticketStatusId);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteTicketStatus(actionRequest);
			}
			else {
				updateTicketStatus(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof TicketStatusNameException) {
				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					"/ticket_configuration/edit_ticket_status");
			}
			else {
				_log.error(e, e);

				throw e;
			}
		}
	}

	protected void updateTicketStatus(ActionRequest actionRequest)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long ticketStatusId = ParamUtil.getLong(
			actionRequest, "ticketStatusId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");
		int order = ParamUtil.getInteger(actionRequest, "order");
		boolean terminal = ParamUtil.getBoolean(actionRequest, "terminal");

		if (ticketStatusId <= 0) {
			_ticketStatusLocalService.addTicketStatus(
				themeDisplay.getUserId(), nameMap, descriptionMap, order,
				terminal);
		}
		else {
			_ticketStatusLocalService.updateTicketStatus(
				ticketStatusId, nameMap, descriptionMap, order, terminal);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditTicketStatusMVCActionCommand.class);

	@Reference
	private TicketStatusLocalService _ticketStatusLocalService;

}