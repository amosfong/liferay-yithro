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
 * This class is a wrapper for {@link TicketInformation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketInformation
 * @generated
 */
@ProviderType
public class TicketInformationWrapper
	extends BaseModelWrapper<TicketInformation>
	implements TicketInformation, ModelWrapper<TicketInformation> {

	public TicketInformationWrapper(TicketInformation ticketInformation) {
		super(ticketInformation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketInformationId", getTicketInformationId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("fieldId", getFieldId());
		attributes.put("data", getData());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketInformationId = (Long)attributes.get("ticketInformationId");

		if (ticketInformationId != null) {
			setTicketInformationId(ticketInformationId);
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

		Long fieldId = (Long)attributes.get("fieldId");

		if (fieldId != null) {
			setFieldId(fieldId);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}
	}

	/**
	 * Returns the create date of this ticket information.
	 *
	 * @return the create date of this ticket information
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data of this ticket information.
	 *
	 * @return the data of this ticket information
	 */
	@Override
	public String getData() {
		return model.getData();
	}

	/**
	 * Returns the field ID of this ticket information.
	 *
	 * @return the field ID of this ticket information
	 */
	@Override
	public long getFieldId() {
		return model.getFieldId();
	}

	/**
	 * Returns the modified date of this ticket information.
	 *
	 * @return the modified date of this ticket information
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ticket information.
	 *
	 * @return the primary key of this ticket information
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ticket entry ID of this ticket information.
	 *
	 * @return the ticket entry ID of this ticket information
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the ticket information ID of this ticket information.
	 *
	 * @return the ticket information ID of this ticket information
	 */
	@Override
	public long getTicketInformationId() {
		return model.getTicketInformationId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this ticket information.
	 *
	 * @param createDate the create date of this ticket information
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data of this ticket information.
	 *
	 * @param data the data of this ticket information
	 */
	@Override
	public void setData(String data) {
		model.setData(data);
	}

	/**
	 * Sets the field ID of this ticket information.
	 *
	 * @param fieldId the field ID of this ticket information
	 */
	@Override
	public void setFieldId(long fieldId) {
		model.setFieldId(fieldId);
	}

	/**
	 * Sets the modified date of this ticket information.
	 *
	 * @param modifiedDate the modified date of this ticket information
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ticket information.
	 *
	 * @param primaryKey the primary key of this ticket information
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ticket entry ID of this ticket information.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket information
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the ticket information ID of this ticket information.
	 *
	 * @param ticketInformationId the ticket information ID of this ticket information
	 */
	@Override
	public void setTicketInformationId(long ticketInformationId) {
		model.setTicketInformationId(ticketInformationId);
	}

	@Override
	protected TicketInformationWrapper wrap(
		TicketInformation ticketInformation) {

		return new TicketInformationWrapper(ticketInformation);
	}

}