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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TicketFieldData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldData
 * @generated
 */
@ProviderType
public class TicketFieldDataWrapper
	extends BaseModelWrapper<TicketFieldData>
	implements TicketFieldData, ModelWrapper<TicketFieldData> {

	public TicketFieldDataWrapper(TicketFieldData ticketFieldData) {
		super(ticketFieldData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketFieldDataId", getTicketFieldDataId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("ticketFieldId", getTicketFieldId());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketFieldDataId = (Long)attributes.get("ticketFieldDataId");

		if (ticketFieldDataId != null) {
			setTicketFieldDataId(ticketFieldDataId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long ticketEntryId = (Long)attributes.get("ticketEntryId");

		if (ticketEntryId != null) {
			setTicketEntryId(ticketEntryId);
		}

		Long ticketFieldId = (Long)attributes.get("ticketFieldId");

		if (ticketFieldId != null) {
			setTicketFieldId(ticketFieldId);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	/**
	 * Returns the company ID of this ticket field data.
	 *
	 * @return the company ID of this ticket field data
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket field data.
	 *
	 * @return the create date of this ticket field data
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data of this ticket field data.
	 *
	 * @return the data of this ticket field data
	 */
	@Override
	public String getData() {
		return model.getData();
	}

	/**
	 * Returns the modified date of this ticket field data.
	 *
	 * @return the modified date of this ticket field data
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ticket field data.
	 *
	 * @return the primary key of this ticket field data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ticket entry ID of this ticket field data.
	 *
	 * @return the ticket entry ID of this ticket field data
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the ticket field data ID of this ticket field data.
	 *
	 * @return the ticket field data ID of this ticket field data
	 */
	@Override
	public long getTicketFieldDataId() {
		return model.getTicketFieldDataId();
	}

	/**
	 * Returns the ticket field ID of this ticket field data.
	 *
	 * @return the ticket field ID of this ticket field data
	 */
	@Override
	public long getTicketFieldId() {
		return model.getTicketFieldId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this ticket field data.
	 *
	 * @param companyId the company ID of this ticket field data
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket field data.
	 *
	 * @param createDate the create date of this ticket field data
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data of this ticket field data.
	 *
	 * @param data the data of this ticket field data
	 */
	@Override
	public void setData(String data) {
		model.setData(data);
	}

	/**
	 * Sets the modified date of this ticket field data.
	 *
	 * @param modifiedDate the modified date of this ticket field data
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ticket field data.
	 *
	 * @param primaryKey the primary key of this ticket field data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ticket entry ID of this ticket field data.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket field data
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the ticket field data ID of this ticket field data.
	 *
	 * @param ticketFieldDataId the ticket field data ID of this ticket field data
	 */
	@Override
	public void setTicketFieldDataId(long ticketFieldDataId) {
		model.setTicketFieldDataId(ticketFieldDataId);
	}

	/**
	 * Sets the ticket field ID of this ticket field data.
	 *
	 * @param ticketFieldId the ticket field ID of this ticket field data
	 */
	@Override
	public void setTicketFieldId(long ticketFieldId) {
		model.setTicketFieldId(ticketFieldId);
	}

	@Override
	protected TicketFieldDataWrapper wrap(TicketFieldData ticketFieldData) {
		return new TicketFieldDataWrapper(ticketFieldData);
	}

}