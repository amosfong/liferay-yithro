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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.yithro.ticket.constants.TicketLinkTypes;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.service.TicketLinkLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"javax.portlet.name=" + TicketPortletKeys.MY_REQUESTED_TICKETS,
		"javax.portlet.name=" + TicketPortletKeys.SIMPLE_TICKET_SEARCH,
		"mvc.command.name=/edit_ticket_link"
	},
	service = MVCActionCommand.class
)
public class EditTicketLinkMVCActionCommand extends BaseMVCActionCommand {

	protected void addTicketLinks(ActionRequest actionRequest)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long ticketEntryId = ParamUtil.getLong(actionRequest, "ticketEntryId");

		int visibility = ParamUtil.getInteger(actionRequest, "visibility");

		String[] urls = new String[0];
		int[] types = new int[0];

		int[] urlIndexes = StringUtil.split(
			ParamUtil.getString(actionRequest, "urlIndexes"), 0);

		for (int urlIndex : urlIndexes) {
			String url = ParamUtil.getString(actionRequest, "url_" + urlIndex);

			urls = ArrayUtil.append(urls, url);

			types = ArrayUtil.append(types, TicketLinkTypes.NORMAL);
		}

		_ticketLinkLocalService.addTicketLinks(
			themeDisplay.getUserId(), ticketEntryId, urls, types, visibility);
	}

	protected void deleteTicketLinks(ActionRequest actionRequest)
		throws PortalException {

		long[] ticketLinkIds = ParamUtil.getLongValues(
			actionRequest, "ticketLinkId");

		_ticketLinkLocalService.deleteTicketLinks(ticketLinkIds);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteTicketLinks(actionRequest);
			}
			else {
				addTicketLinks(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw e;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditTicketLinkMVCActionCommand.class);

	@Reference
	private TicketLinkLocalService _ticketLinkLocalService;

}