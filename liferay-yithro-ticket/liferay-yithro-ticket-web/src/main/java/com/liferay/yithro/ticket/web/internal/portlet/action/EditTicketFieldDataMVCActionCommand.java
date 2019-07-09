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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.service.TicketFieldDataLocalService;

import java.util.HashMap;
import java.util.Map;

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
		"javax.portlet.name=" + TicketPortletKeys.TICKET_FIELDS_DISPLAY,
		"mvc.command.name=/edit_ticket_field_data"
	},
	service = MVCActionCommand.class
)
public class EditTicketFieldDataMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			updateTicketFieldData(actionRequest);

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw e;
		}
	}

	protected void updateTicketFieldData(ActionRequest actionRequest)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long ticketEntryId = ParamUtil.getLong(actionRequest, "ticketEntryId");

		long ticketFieldId = ParamUtil.getLong(actionRequest, "ticketFieldId");
		String data = ParamUtil.getString(actionRequest, "data");

		Map<Long, String> ticketFieldsMap = new HashMap<Long, String>() {
			{
				put(ticketFieldId, data);
			}
		};

		_ticketFieldDataLocalService.updateTicketFieldData(
			themeDisplay.getUserId(), ticketEntryId, ticketFieldsMap,
			new ServiceContext());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditTicketCommentMVCActionCommand.class);

	@Reference
	private TicketFieldDataLocalService _ticketFieldDataLocalService;

}