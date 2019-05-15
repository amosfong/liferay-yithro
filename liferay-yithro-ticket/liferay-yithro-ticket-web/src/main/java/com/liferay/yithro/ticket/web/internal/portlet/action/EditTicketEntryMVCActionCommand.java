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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.model.TicketStatus;
import com.liferay.yithro.ticket.service.TicketEntryService;
import com.liferay.yithro.ticket.service.TicketStatusLocalService;

import java.util.Collections;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TicketPortletKeys.ADD_TICKET_FORM,
		"javax.portlet.name=" + TicketPortletKeys.MY_REQUESTED_TICKETS,
		"mvc.command.name=/edit_ticket_entry"
	},
	service = MVCActionCommand.class
)
public class EditTicketEntryMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals("update_ticket_status")) {
				updateTicketStatus(actionRequest);
			}
			else {
				updateTicketEntry(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw e;
		}
	}

	protected void updateTicketEntry(ActionRequest actionRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String subject = ParamUtil.getString(actionRequest, "subject");
		String description = ParamUtil.getString(actionRequest, "description");

		TicketStatus ticketStatus =
			_ticketStatusLocalService.getInitialTicketStatus();

		_ticketEntryService.addTicketEntry(
			ticketStatus.getTicketStatusId(), themeDisplay.getLanguageId(),
			subject, description, 0, Collections.emptyMap(),
			Collections.emptyList());
	}

	protected void updateTicketStatus(ActionRequest actionRequest)
		throws Exception {

		long ticketEntryId = ParamUtil.getLong(actionRequest, "ticketEntryId");

		long ticketStatusId = ParamUtil.getLong(
			actionRequest, "ticketStatusId");

		_ticketEntryService.updateTicketStatus(ticketEntryId, ticketStatusId);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditTicketEntryMVCActionCommand.class);

	@Reference
	private TicketEntryService _ticketEntryService;

	@Reference
	private TicketStatusLocalService _ticketStatusLocalService;

}