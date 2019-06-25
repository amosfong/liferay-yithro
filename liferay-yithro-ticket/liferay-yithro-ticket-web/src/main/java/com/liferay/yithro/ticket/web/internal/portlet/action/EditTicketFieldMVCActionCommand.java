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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.exception.TicketFieldNameException;
import com.liferay.yithro.ticket.service.TicketFieldLocalService;

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
		"mvc.command.name=/ticket_configuration/edit_ticket_field"
	},
	service = MVCActionCommand.class
)
public class EditTicketFieldMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DEACTIVATE)) {
				updateStatus(actionRequest, WorkflowConstants.STATUS_INACTIVE);
			}
			else if (cmd.equals(Constants.RESTORE)) {
				updateStatus(actionRequest, WorkflowConstants.STATUS_APPROVED);
			}
			else {
				updateTicketField(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof TicketFieldNameException) {
				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					"/ticket_configuration/edit_ticket_field");
			}
			else {
				_log.error(e, e);

				throw e;
			}
		}
	}

	protected void updateStatus(ActionRequest actionRequest, int status)
		throws PortalException {

		long ticketFieldId = ParamUtil.getLong(actionRequest, "ticketFieldId");

		_ticketFieldLocalService.updateStatus(ticketFieldId, status);
	}

	protected void updateTicketField(ActionRequest actionRequest)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long ticketFieldId = ParamUtil.getLong(actionRequest, "ticketFieldId");

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "name");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");
		int type = ParamUtil.getInteger(actionRequest, "type");
		int visibility = ParamUtil.getInteger(actionRequest, "visibility");

		if (ticketFieldId <= 0) {
			_ticketFieldLocalService.addTicketField(
				themeDisplay.getUserId(), nameMap, descriptionMap, type,
				visibility);
		}
		else {
			_ticketFieldLocalService.updateTicketField(
				ticketFieldId, nameMap, descriptionMap, type, visibility);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditTicketFieldMVCActionCommand.class);

	@Reference
	private TicketFieldLocalService _ticketFieldLocalService;

}