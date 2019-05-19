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

package com.liferay.yithro.ticket.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.audit.constants.Actions;
import com.liferay.yithro.audit.constants.Fields;
import com.liferay.yithro.audit.service.AuditEntryLocalService;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.exception.TicketLinkTypeException;
import com.liferay.yithro.ticket.exception.TicketLinkURLException;
import com.liferay.yithro.ticket.exception.TicketLinkVisibilityException;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.model.TicketLink;
import com.liferay.yithro.ticket.service.TicketCommunicationLocalService;
import com.liferay.yithro.ticket.service.base.TicketLinkLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketLink",
	service = AopService.class
)
public class TicketLinkLocalServiceImpl extends TicketLinkLocalServiceBaseImpl {

	public TicketLink addTicketLink(
			long userId, long ticketEntryId, String url, int type,
			int visibility, ServiceContext serviceContext)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		Date now = serviceContext.getCreateDate(new Date());

		validate(ticketEntryId, url, type, visibility);

		long auditSetId = GetterUtil.getInteger(
			serviceContext.getAttribute("auditSetId"));

		if (auditSetId <= 0) {
			auditSetId = auditEntryLocalService.getNextAuditSetId(
				TicketEntry.class.getName(), ticketEntryId);
		}

		int auditAction = GetterUtil.getInteger(
			serviceContext.getAttribute("auditAction"));

		if (auditAction <= 0) {
			auditAction = Actions.ADD;
		}

		long ticketLinkId = counterLocalService.increment();

		TicketLink ticketLink = ticketLinkPersistence.create(ticketLinkId);

		ticketLink.setCompanyId(user.getCompanyId());
		ticketLink.setUserId(user.getUserId());
		ticketLink.setUserName(user.getFullName());
		ticketLink.setCreateDate(now);
		ticketLink.setTicketEntryId(ticketEntryId);
		ticketLink.setUrl(url);
		ticketLink.setType(type);
		ticketLink.setVisibility(visibility);

		ticketLinkPersistence.update(ticketLink);

		// Ticket communication

		ticketCommunicationLocalService.addTicketCommunication(
			ticketLink.getUserId(), ticketLink.getTicketEntryId(),
			TicketLink.class, ticketLink.getTicketLinkId(), null,
			getJSONObject(ticketLink));

		// Audit entry

		auditEntryLocalService.addAuditEntry(
			userId, now, TicketEntry.class, ticketEntryId, auditSetId,
			TicketLink.class, ticketLinkId, auditAction, Fields.URL, visibility,
			StringPool.BLANK, StringPool.BLANK, StringPool.BLANK, url,
			StringPool.BLANK);

		return ticketLink;
	}

	public TicketLink deleteTicketLink(long ticketLinkId)
		throws PortalException {

		TicketLink ticketLink = ticketLinkPersistence.findByPrimaryKey(
			ticketLinkId);

		return deleteTicketLink(ticketLink);
	}

	public TicketLink deleteTicketLink(TicketLink ticketLink)
		throws PortalException {

		ticketLinkPersistence.remove(ticketLink);

		// Ticket communication

		ticketCommunicationLocalService.deleteTicketCommunication(
			TicketLink.class, ticketLink.getTicketLinkId());

		return ticketLink;
	}

	public List<TicketLink> getTicketLinks(long ticketEntryId, int visibility) {
		return ticketLinkPersistence.findByTEI_V(ticketEntryId, visibility);
	}

	public List<TicketLink> getTicketLinks(
		long ticketEntryId, int[] visibilities) {

		return ticketLinkPersistence.findByTEI_V(ticketEntryId, visibilities);
	}

	public int getTicketLinksCount(long ticketEntryId, int visibility) {
		return ticketLinkPersistence.countByTEI_V(ticketEntryId, visibility);
	}

	public int getTicketLinksCount(long ticketEntryId, int[] visibilities) {
		return ticketLinkPersistence.countByTEI_V(ticketEntryId, visibilities);
	}

	protected JSONObject getJSONObject(TicketLink ticketLink) {
		JSONObject jsonObject = jsonFactory.createJSONObject();

		JSONArray jsonArray = jsonFactory.createJSONArray();

		JSONObject linkJSONObject = jsonFactory.createJSONObject();

		linkJSONObject.put("url", ticketLink.getUrl());

		jsonArray.put(linkJSONObject);

		jsonObject.put("ticketLinks", jsonArray);

		return jsonObject;
	}

	protected void validate(
			long ticketEntryId, String url, int type, int visibility)
		throws PortalException {

		ticketEntryPersistence.findByPrimaryKey(ticketEntryId);

		if (!Validator.isUrl(url)) {
			throw new TicketLinkURLException();
		}

		if ((type < 0) || (type > 4)) {
			throw new TicketLinkTypeException();
		}

		if (!Visibilities.hasVisibility(visibility)) {
			throw new TicketLinkVisibilityException();
		}
	}

	@Reference
	protected AuditEntryLocalService auditEntryLocalService;

	@Reference
	protected JSONFactory jsonFactory;

	@Reference
	protected TicketCommunicationLocalService ticketCommunicationLocalService;

}