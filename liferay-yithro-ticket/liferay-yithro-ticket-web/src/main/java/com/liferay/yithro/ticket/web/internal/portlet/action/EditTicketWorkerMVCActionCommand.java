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
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.service.TicketWorkerLocalService;

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
		"javax.portlet.name=" + TicketPortletKeys.TICKET_DETAILS_DISPLAY,
		"mvc.command.name=/edit_ticket_workers"
	},
	service = MVCActionCommand.class
)
public class EditTicketWorkerMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			updateTicketWorker(actionRequest);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw e;
		}
	}

	protected void updateTicketWorker(ActionRequest actionRequest)
		throws Exception {

		long ticketEntryId = ParamUtil.getLong(actionRequest, "ticketEntryId");

		long[] ticketWorkerUserIds = ParamUtil.getLongValues(
			actionRequest, "ticketWorkerUserIds");

		int[] roles = new int[ticketWorkerUserIds.length];

		for (int i = 0; i < ticketWorkerUserIds.length; i++) {
			roles[i] = ParamUtil.getInteger(
				actionRequest, "role_" + ticketWorkerUserIds[i]);
		}

		long primaryUserId = ParamUtil.getLong(actionRequest, "primary");

		_ticketWorkerLocalService.setTicketWorkers(
			ticketEntryId, ticketWorkerUserIds, roles, primaryUserId);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditTicketEntryMVCActionCommand.class);

	@Reference
	private TicketWorkerLocalService _ticketWorkerLocalService;

}