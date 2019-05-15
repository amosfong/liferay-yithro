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

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.yithro.ticket.constants.TicketCommentType;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.service.TicketCommentLocalService;

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
		"javax.portlet.name=" + TicketPortletKeys.MY_REQUESTED_TICKETS,
		"mvc.command.name=/add_ticket_comment"
	},
	service = MVCActionCommand.class
)
public class AddTicketCommentMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long ticketEntryId = ParamUtil.getLong(actionRequest, "ticketEntryId");
		String body = ParamUtil.getString(actionRequest, "body");
		int visibility = ParamUtil.getInteger(actionRequest, "visibility");

		_ticketCommentLocalService.addTicketComment(
			themeDisplay.getUserId(), ticketEntryId, body,
			TicketCommentType.NORMAL, visibility,
			WorkflowConstants.STATUS_APPROVED, new int[0],
			new ServiceContext());

		sendRedirect(actionRequest, actionResponse);
	}

	@Reference
	private TicketCommentLocalService _ticketCommentLocalService;

}