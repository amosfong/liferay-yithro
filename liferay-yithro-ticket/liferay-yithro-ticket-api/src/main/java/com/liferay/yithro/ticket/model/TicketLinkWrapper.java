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

package com.liferay.yithro.ticket.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TicketLink}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketLink
 * @generated
 */
public class TicketLinkWrapper
	extends BaseModelWrapper<TicketLink>
	implements ModelWrapper<TicketLink>, TicketLink {

	public TicketLinkWrapper(TicketLink ticketLink) {
		super(ticketLink);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketLinkId", getTicketLinkId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("ticketCommunicationId", getTicketCommunicationId());
		attributes.put("url", getUrl());
		attributes.put("type", getType());
		attributes.put("visibility", getVisibility());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketLinkId = (Long)attributes.get("ticketLinkId");

		if (ticketLinkId != null) {
			setTicketLinkId(ticketLinkId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long ticketEntryId = (Long)attributes.get("ticketEntryId");

		if (ticketEntryId != null) {
			setTicketEntryId(ticketEntryId);
		}

		Long ticketCommunicationId = (Long)attributes.get(
			"ticketCommunicationId");

		if (ticketCommunicationId != null) {
			setTicketCommunicationId(ticketCommunicationId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer visibility = (Integer)attributes.get("visibility");

		if (visibility != null) {
			setVisibility(visibility);
		}
	}

	/**
	 * Returns the company ID of this ticket link.
	 *
	 * @return the company ID of this ticket link
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket link.
	 *
	 * @return the create date of this ticket link
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the primary key of this ticket link.
	 *
	 * @return the primary key of this ticket link
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ticket communication ID of this ticket link.
	 *
	 * @return the ticket communication ID of this ticket link
	 */
	@Override
	public long getTicketCommunicationId() {
		return model.getTicketCommunicationId();
	}

	/**
	 * Returns the ticket entry ID of this ticket link.
	 *
	 * @return the ticket entry ID of this ticket link
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the ticket link ID of this ticket link.
	 *
	 * @return the ticket link ID of this ticket link
	 */
	@Override
	public long getTicketLinkId() {
		return model.getTicketLinkId();
	}

	/**
	 * Returns the type of this ticket link.
	 *
	 * @return the type of this ticket link
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the url of this ticket link.
	 *
	 * @return the url of this ticket link
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the user ID of this ticket link.
	 *
	 * @return the user ID of this ticket link
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket link.
	 *
	 * @return the user name of this ticket link
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket link.
	 *
	 * @return the user uuid of this ticket link
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the visibility of this ticket link.
	 *
	 * @return the visibility of this ticket link
	 */
	@Override
	public int getVisibility() {
		return model.getVisibility();
	}

	@Override
	public String getVisibilityLabel() {
		return model.getVisibilityLabel();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this ticket link.
	 *
	 * @param companyId the company ID of this ticket link
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket link.
	 *
	 * @param createDate the create date of this ticket link
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the primary key of this ticket link.
	 *
	 * @param primaryKey the primary key of this ticket link
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ticket communication ID of this ticket link.
	 *
	 * @param ticketCommunicationId the ticket communication ID of this ticket link
	 */
	@Override
	public void setTicketCommunicationId(long ticketCommunicationId) {
		model.setTicketCommunicationId(ticketCommunicationId);
	}

	/**
	 * Sets the ticket entry ID of this ticket link.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket link
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the ticket link ID of this ticket link.
	 *
	 * @param ticketLinkId the ticket link ID of this ticket link
	 */
	@Override
	public void setTicketLinkId(long ticketLinkId) {
		model.setTicketLinkId(ticketLinkId);
	}

	/**
	 * Sets the type of this ticket link.
	 *
	 * @param type the type of this ticket link
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the url of this ticket link.
	 *
	 * @param url the url of this ticket link
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the user ID of this ticket link.
	 *
	 * @param userId the user ID of this ticket link
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket link.
	 *
	 * @param userName the user name of this ticket link
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket link.
	 *
	 * @param userUuid the user uuid of this ticket link
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the visibility of this ticket link.
	 *
	 * @param visibility the visibility of this ticket link
	 */
	@Override
	public void setVisibility(int visibility) {
		model.setVisibility(visibility);
	}

	@Override
	protected TicketLinkWrapper wrap(TicketLink ticketLink) {
		return new TicketLinkWrapper(ticketLink);
	}

}