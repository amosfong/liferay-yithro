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

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link TicketStructure}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketStructure
 * @generated
 */
@ProviderType
public class TicketStructureWrapper
	extends BaseModelWrapper<TicketStructure>
	implements TicketStructure, ModelWrapper<TicketStructure> {

	public TicketStructureWrapper(TicketStructure ticketStructure) {
		super(ticketStructure);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketStructureId", getTicketStructureId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("structure", getStructure());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketStructureId = (Long)attributes.get("ticketStructureId");

		if (ticketStructureId != null) {
			setTicketStructureId(ticketStructureId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String structure = (String)attributes.get("structure");

		if (structure != null) {
			setStructure(structure);
		}
	}

	/**
	 * Returns the company ID of this ticket structure.
	 *
	 * @return the company ID of this ticket structure
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket structure.
	 *
	 * @return the create date of this ticket structure
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this ticket structure.
	 *
	 * @return the description of this ticket structure
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the modified date of this ticket structure.
	 *
	 * @return the modified date of this ticket structure
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this ticket structure.
	 *
	 * @return the name of this ticket structure
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this ticket structure.
	 *
	 * @return the primary key of this ticket structure
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the structure of this ticket structure.
	 *
	 * @return the structure of this ticket structure
	 */
	@Override
	public String getStructure() {
		return model.getStructure();
	}

	/**
	 * Returns the ticket structure ID of this ticket structure.
	 *
	 * @return the ticket structure ID of this ticket structure
	 */
	@Override
	public long getTicketStructureId() {
		return model.getTicketStructureId();
	}

	/**
	 * Returns the user ID of this ticket structure.
	 *
	 * @return the user ID of this ticket structure
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket structure.
	 *
	 * @return the user name of this ticket structure
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket structure.
	 *
	 * @return the user uuid of this ticket structure
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this ticket structure.
	 *
	 * @param companyId the company ID of this ticket structure
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket structure.
	 *
	 * @param createDate the create date of this ticket structure
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this ticket structure.
	 *
	 * @param description the description of this ticket structure
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the modified date of this ticket structure.
	 *
	 * @param modifiedDate the modified date of this ticket structure
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this ticket structure.
	 *
	 * @param name the name of this ticket structure
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this ticket structure.
	 *
	 * @param primaryKey the primary key of this ticket structure
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the structure of this ticket structure.
	 *
	 * @param structure the structure of this ticket structure
	 */
	@Override
	public void setStructure(String structure) {
		model.setStructure(structure);
	}

	/**
	 * Sets the ticket structure ID of this ticket structure.
	 *
	 * @param ticketStructureId the ticket structure ID of this ticket structure
	 */
	@Override
	public void setTicketStructureId(long ticketStructureId) {
		model.setTicketStructureId(ticketStructureId);
	}

	/**
	 * Sets the user ID of this ticket structure.
	 *
	 * @param userId the user ID of this ticket structure
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket structure.
	 *
	 * @param userName the user name of this ticket structure
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket structure.
	 *
	 * @param userUuid the user uuid of this ticket structure
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TicketStructureWrapper wrap(TicketStructure ticketStructure) {
		return new TicketStructureWrapper(ticketStructure);
	}

}