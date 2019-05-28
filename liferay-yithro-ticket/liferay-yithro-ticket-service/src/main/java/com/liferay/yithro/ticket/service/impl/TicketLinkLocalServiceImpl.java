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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.audit.service.AuditEntryLocalService;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.exception.TicketLinkTypeException;
import com.liferay.yithro.ticket.exception.TicketLinkURLException;
import com.liferay.yithro.ticket.exception.TicketLinkVisibilityException;
import com.liferay.yithro.ticket.model.TicketCommunication;
import com.liferay.yithro.ticket.model.TicketLink;
import com.liferay.yithro.ticket.service.TicketCommunicationLocalService;
import com.liferay.yithro.ticket.service.base.TicketLinkLocalServiceBaseImpl;

import java.util.ArrayList;
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

	public void addTicketLinks(
			long userId, long ticketEntryId, String[] urls, int[] types,
			int visibility)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		if (ArrayUtil.isEmpty(urls)) {
			throw new TicketLinkURLException();
		}

		List<TicketLink> ticketLinks = new ArrayList<>();

		for (int i = 0; i < urls.length; i++) {
			String url = urls[i];
			int type = types[i];

			validate(ticketEntryId, url, type, visibility);

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

			ticketLinks.add(ticketLink);
		}

		TicketCommunication ticketCommunication =
			ticketCommunicationLocalService.addTicketCommunication(
				userId, ticketEntryId, TicketLink.class.getName(),
				getDataJSONObject(ticketLinks), visibility);

		for (TicketLink ticketLink : ticketLinks) {
			ticketLink.setTicketCommunicationId(
				ticketCommunication.getTicketCommunicationId());

			ticketLinkPersistence.update(ticketLink);
		}
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

		TicketCommunication ticketCommunication =
			ticketCommunicationLocalService.getTicketCommunication(
				ticketLink.getTicketCommunicationId());

		JSONObject jsonObject = ticketCommunication.getDataJSONObject();

		JSONArray jsonArray = updateJSONArray(
			jsonObject.getJSONArray("ticketLinks"),
			ticketLink.getTicketLinkId());

		if (jsonArray.length() > 0) {
			jsonObject.put("ticketLinks", jsonArray);

			ticketCommunicationLocalService.updateTicketCommunication(
				ticketCommunication.getTicketCommunicationId(), jsonObject);
		}
		else {
			ticketCommunicationLocalService.deleteTicketCommunication(
				ticketCommunication.getTicketCommunicationId());
		}

		return ticketLink;
	}

	public void deleteTicketLinks(long[] ticketLinkIds) throws PortalException {
		for (long ticketLinkId : ticketLinkIds) {
			deleteTicketLink(ticketLinkId);
		}
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

	protected JSONObject getDataJSONObject(List<TicketLink> ticketLinks) {
		JSONObject jsonObject = jsonFactory.createJSONObject();

		JSONArray jsonArray = jsonFactory.createJSONArray();

		for (TicketLink ticketLink : ticketLinks) {
			JSONObject linkJSONObject = jsonFactory.createJSONObject();

			linkJSONObject.put("ticketLinkId", ticketLink.getTicketLinkId());
			linkJSONObject.put("url", ticketLink.getUrl());

			jsonArray.put(linkJSONObject);
		}

		jsonObject.put("ticketLinks", jsonArray);

		return jsonObject;
	}

	protected JSONArray updateJSONArray(
		JSONArray jsonArray, long removeTicketLinkId) {

		JSONArray newJSONArray = jsonFactory.createJSONArray();

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);

			if (jsonObject.getLong("ticketLinkId") == removeTicketLinkId) {
				continue;
			}

			newJSONArray.put(jsonObject);
		}

		return newJSONArray;
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