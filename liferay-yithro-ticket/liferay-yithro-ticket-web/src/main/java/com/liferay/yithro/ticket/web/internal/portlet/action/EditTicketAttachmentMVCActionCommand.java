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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
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
		"javax.portlet.name=" + TicketPortletKeys.SIMPLE_TICKET_SEARCH,
		"mvc.command.name=/edit_ticket_attachment"
	},
	service = MVCActionCommand.class
)
public class EditTicketAttachmentMVCActionCommand extends BaseMVCActionCommand {

	protected void addTicketAttachments(ActionRequest actionRequest)
		throws PortalException {

		UploadPortletRequest uploadPortletRequest =
			_portal.getUploadPortletRequest(actionRequest);

		ThemeDisplay themeDisplay =
			(ThemeDisplay)uploadPortletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		long ticketEntryId = ParamUtil.getLong(
			uploadPortletRequest, "ticketEntryId");

		int visibility = ParamUtil.getInteger(
			uploadPortletRequest, "visibility");

		String[] fileNames = new String[0];
		File[] files = new File[0];

		int[] fileIndexes = StringUtil.split(
			ParamUtil.getString(actionRequest, "fileIndexes"), 0);

		for (int fileIndex : fileIndexes) {
			String fileName = uploadPortletRequest.getFileName(
				"file_" + fileIndex);
			File file = uploadPortletRequest.getFile("file_" + fileIndex);

			fileNames = ArrayUtil.append(fileNames, fileName);
			files = ArrayUtil.append(files, file);
		}

		_ticketAttachmentLocalService.addTicketAttachments(
			themeDisplay.getUserId(), ticketEntryId, new long[files.length],
			fileNames, files, visibility, WorkflowConstants.STATUS_APPROVED,
			new ServiceContext());
	}

	protected void deleteTicketAttachments(ActionRequest actionRequest)
		throws PortalException {

		long[] ticketAttachmentIds = ParamUtil.getLongValues(
			actionRequest, "ticketAttachmentId");

		_ticketAttachmentLocalService.deleteTicketAttachments(
			ticketAttachmentIds);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteTicketAttachments(actionRequest);
			}
			else {
				addTicketAttachments(actionRequest);
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