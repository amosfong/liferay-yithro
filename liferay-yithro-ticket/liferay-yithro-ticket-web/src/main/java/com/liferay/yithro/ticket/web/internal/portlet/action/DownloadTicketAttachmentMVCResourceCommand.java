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

import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.service.TicketAttachmentLocalService;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + TicketPortletKeys.MY_REQUESTED_TICKETS,
		"mvc.command.name=/download_ticket_attachment"
	},
	service = MVCResourceCommand.class
)
public class DownloadTicketAttachmentMVCResourceCommand
	extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws Exception {

		long ticketAttachmentId = ParamUtil.getLong(
			resourceRequest, "ticketAttachmentId");

		TicketAttachment ticketAttachment =
			_ticketAttachmentLocalService.getTicketAttachment(
				ticketAttachmentId);

		String contentDispositionType =
			HttpHeaders.CONTENT_DISPOSITION_ATTACHMENT;

		boolean preview = ParamUtil.getBoolean(resourceRequest, "preview");

		if (preview) {
			contentDispositionType = HttpHeaders.CONTENT_DISPOSITION_INLINE;
		}

		PortletResponseUtil.sendFile(
			resourceRequest, resourceResponse, ticketAttachment.getFileName(),
			_ticketAttachmentLocalService.getFileAsStream(ticketAttachment),
			ticketAttachment.getContentLength(),
			MimeTypesUtil.getContentType(ticketAttachment.getFileName()),
			contentDispositionType);
	}

	@Reference
	private TicketAttachmentLocalService _ticketAttachmentLocalService;

}