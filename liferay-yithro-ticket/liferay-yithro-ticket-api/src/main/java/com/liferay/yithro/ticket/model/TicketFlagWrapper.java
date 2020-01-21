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
 * This class is a wrapper for {@link TicketFlag}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFlag
 * @generated
 */
public class TicketFlagWrapper
	extends BaseModelWrapper<TicketFlag>
	implements ModelWrapper<TicketFlag>, TicketFlag {

	public TicketFlagWrapper(TicketFlag ticketFlag) {
		super(ticketFlag);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketFlagId", getTicketFlagId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("type", getType());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketFlagId = (Long)attributes.get("ticketFlagId");

		if (ticketFlagId != null) {
			setTicketFlagId(ticketFlagId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long ticketEntryId = (Long)attributes.get("ticketEntryId");

		if (ticketEntryId != null) {
			setTicketEntryId(ticketEntryId);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer value = (Integer)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	 * Returns the company ID of this ticket flag.
	 *
	 * @return the company ID of this ticket flag
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the modified date of this ticket flag.
	 *
	 * @return the modified date of this ticket flag
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ticket flag.
	 *
	 * @return the primary key of this ticket flag
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ticket entry ID of this ticket flag.
	 *
	 * @return the ticket entry ID of this ticket flag
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the ticket flag ID of this ticket flag.
	 *
	 * @return the ticket flag ID of this ticket flag
	 */
	@Override
	public long getTicketFlagId() {
		return model.getTicketFlagId();
	}

	/**
	 * Returns the type of this ticket flag.
	 *
	 * @return the type of this ticket flag
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	@Override
	public String getTypeLabel() {
		return model.getTypeLabel();
	}

	/**
	 * Returns the user ID of this ticket flag.
	 *
	 * @return the user ID of this ticket flag
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this ticket flag.
	 *
	 * @return the user uuid of this ticket flag
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the value of this ticket flag.
	 *
	 * @return the value of this ticket flag
	 */
	@Override
	public int getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this ticket flag.
	 *
	 * @param companyId the company ID of this ticket flag
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the modified date of this ticket flag.
	 *
	 * @param modifiedDate the modified date of this ticket flag
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ticket flag.
	 *
	 * @param primaryKey the primary key of this ticket flag
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ticket entry ID of this ticket flag.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket flag
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the ticket flag ID of this ticket flag.
	 *
	 * @param ticketFlagId the ticket flag ID of this ticket flag
	 */
	@Override
	public void setTicketFlagId(long ticketFlagId) {
		model.setTicketFlagId(ticketFlagId);
	}

	/**
	 * Sets the type of this ticket flag.
	 *
	 * @param type the type of this ticket flag
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this ticket flag.
	 *
	 * @param userId the user ID of this ticket flag
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this ticket flag.
	 *
	 * @param userUuid the user uuid of this ticket flag
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the value of this ticket flag.
	 *
	 * @param value the value of this ticket flag
	 */
	@Override
	public void setValue(int value) {
		model.setValue(value);
	}

	@Override
	protected TicketFlagWrapper wrap(TicketFlag ticketFlag) {
		return new TicketFlagWrapper(ticketFlag);
	}

}