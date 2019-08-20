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
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.yithro.ticket.constants.TicketFieldType;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.model.TicketStatus;
import com.liferay.yithro.ticket.service.TicketAttachmentLocalService;
import com.liferay.yithro.ticket.service.TicketEntryService;
import com.liferay.yithro.ticket.service.TicketFieldLocalService;
import com.liferay.yithro.ticket.service.TicketStatusLocalService;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

		UploadPortletRequest uploadPortletRequest =
			_portal.getUploadPortletRequest(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long ticketEntryId = ParamUtil.getLong(
			uploadPortletRequest, "ticketEntryId");

		long ticketStructureId = ParamUtil.getLong(
			uploadPortletRequest, "ticketStructureId");
		String summary = ParamUtil.getString(uploadPortletRequest, "summary");
		String description = ParamUtil.getString(
			uploadPortletRequest, "description");

		long[] ticketFieldIds = StringUtil.split(
			ParamUtil.getString(uploadPortletRequest, "ticketFieldIds"), 0L);

		Map<Long, String> ticketFieldsMap = new HashMap<>();
		List<TicketAttachment> ticketAttachments = new ArrayList<>();

		for (long ticketFieldId : ticketFieldIds) {
			TicketField ticketField = _ticketFieldLocalService.getTicketField(
				ticketFieldId);

			if (ticketField.getType() == TicketFieldType.ATTACHMENT) {
				String fileName = uploadPortletRequest.getFileName(
					"ticketFieldIdData_" + ticketFieldId);
				File file = uploadPortletRequest.getFile(
					"ticketFieldIdData_" + ticketFieldId);

				if ((file == null) || Validator.isNull(fileName)) {
					continue;
				}

				TicketAttachment ticketAttachment =
					_ticketAttachmentLocalService.createTicketAttachment(0);

				ticketAttachment.setTicketFieldId(ticketFieldId);
				ticketAttachment.setFile(file);
				ticketAttachment.setFileName(fileName);

				ticketAttachments.add(ticketAttachment);

				ticketFieldsMap.put(ticketFieldId, fileName);
			}
			else {
				String ticketFieldData = ParamUtil.getString(
					uploadPortletRequest, "ticketFieldIdData_" + ticketFieldId);

				ticketFieldsMap.put(ticketFieldId, ticketFieldData);
			}
		}

		if (ticketEntryId > 0) {
			_ticketEntryService.updateTicketEntry(
				ticketEntryId, summary, description);
		}
		else {
			TicketStatus ticketStatus =
				_ticketStatusLocalService.getInitialTicketStatus();

			_ticketEntryService.addTicketEntry(
				ticketStructureId, ticketStatus.getTicketStatusId(),
				themeDisplay.getLanguageId(), summary, description, 0,
				ticketFieldsMap, ticketAttachments);
		}
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
	private Portal _portal;

	@Reference
	private TicketAttachmentLocalService _ticketAttachmentLocalService;

	@Reference
	private TicketEntryService _ticketEntryService;

	@Reference
	private TicketFieldLocalService _ticketFieldLocalService;

	@Reference
	private TicketStatusLocalService _ticketStatusLocalService;

}