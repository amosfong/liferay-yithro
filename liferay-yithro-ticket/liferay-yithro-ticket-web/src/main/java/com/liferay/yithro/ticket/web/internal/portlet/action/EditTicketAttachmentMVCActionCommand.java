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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.service.TicketAttachmentLocalService;

import java.io.File;

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
		"mvc.command.name=/edit_ticket_attachment"
	},
	service = MVCActionCommand.class
)
public class EditTicketAttachmentMVCActionCommand extends BaseMVCActionCommand {

	protected void addTicketAttachment(ActionRequest actionRequest)
		throws PortalException {

		UploadPortletRequest uploadPortletRequest =
			_portal.getUploadPortletRequest(actionRequest);

		ThemeDisplay themeDisplay =
			(ThemeDisplay)uploadPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long ticketEntryId = ParamUtil.getLong(
			uploadPortletRequest, "ticketEntryId");

		String fileName = uploadPortletRequest.getFileName("file");
		File file = uploadPortletRequest.getFile("file");
		int visibility = ParamUtil.getInteger(
			uploadPortletRequest, "visibility");

		_ticketAttachmentLocalService.addTicketAttachment(
			themeDisplay.getUserId(), ticketEntryId, fileName, file, visibility,
			WorkflowConstants.STATUS_APPROVED, new ServiceContext());
	}

	protected void deleteTicketAttachment(ActionRequest actionRequest)
		throws PortalException {

		long ticketAttachmentId = ParamUtil.getLong(
			actionRequest, "ticketAttachmentId");

		_ticketAttachmentLocalService.deleteTicketAttachment(
			ticketAttachmentId);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteTicketAttachment(actionRequest);
			}
			else {
				addTicketAttachment(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw e;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditTicketAttachmentMVCActionCommand.class);

	@Reference
	private Portal _portal;

	@Reference
	private TicketAttachmentLocalService _ticketAttachmentLocalService;

}