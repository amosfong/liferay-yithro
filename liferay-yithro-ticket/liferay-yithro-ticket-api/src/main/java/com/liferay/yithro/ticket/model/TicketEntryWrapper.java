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
 * This class is a wrapper for {@link TicketEntry}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntry
 * @generated
 */
@ProviderType
public class TicketEntryWrapper
	extends BaseModelWrapper<TicketEntry>
	implements TicketEntry, ModelWrapper<TicketEntry> {

	public TicketEntryWrapper(TicketEntry ticketEntry) {
		super(ticketEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("languageId", getLanguageId());
		attributes.put("ticketNumber", getTicketNumber());
		attributes.put("subject", getSubject());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("weight", getWeight());
		attributes.put("holdDate", getHoldDate());
		attributes.put("closedDate", getClosedDate());
		attributes.put("dueDate", getDueDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketEntryId = (Long)attributes.get("ticketEntryId");

		if (ticketEntryId != null) {
			setTicketEntryId(ticketEntryId);
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

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		Long ticketNumber = (Long)attributes.get("ticketNumber");

		if (ticketNumber != null) {
			setTicketNumber(ticketNumber);
		}

		String subject = (String)attributes.get("subject");

		if (subject != null) {
			setSubject(subject);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Integer weight = (Integer)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Date holdDate = (Date)attributes.get("holdDate");

		if (holdDate != null) {
			setHoldDate(holdDate);
		}

		Date closedDate = (Date)attributes.get("closedDate");

		if (closedDate != null) {
			setClosedDate(closedDate);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}
	}

	/**
	 * Returns the closed date of this ticket entry.
	 *
	 * @return the closed date of this ticket entry
	 */
	@Override
	public Date getClosedDate() {
		return model.getClosedDate();
	}

	/**
	 * Returns the company ID of this ticket entry.
	 *
	 * @return the company ID of this ticket entry
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket entry.
	 *
	 * @return the create date of this ticket entry
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this ticket entry.
	 *
	 * @return the description of this ticket entry
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the due date of this ticket entry.
	 *
	 * @return the due date of this ticket entry
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the hold date of this ticket entry.
	 *
	 * @return the hold date of this ticket entry
	 */
	@Override
	public Date getHoldDate() {
		return model.getHoldDate();
	}

	/**
	 * Returns the language ID of this ticket entry.
	 *
	 * @return the language ID of this ticket entry
	 */
	@Override
	public String getLanguageId() {
		return model.getLanguageId();
	}

	/**
	 * Returns the modified date of this ticket entry.
	 *
	 * @return the modified date of this ticket entry
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ticket entry.
	 *
	 * @return the primary key of this ticket entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this ticket entry.
	 *
	 * @return the status of this ticket entry
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the subject of this ticket entry.
	 *
	 * @return the subject of this ticket entry
	 */
	@Override
	public String getSubject() {
		return model.getSubject();
	}

	/**
	 * Returns the ticket entry ID of this ticket entry.
	 *
	 * @return the ticket entry ID of this ticket entry
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the ticket number of this ticket entry.
	 *
	 * @return the ticket number of this ticket entry
	 */
	@Override
	public long getTicketNumber() {
		return model.getTicketNumber();
	}

	/**
	 * Returns the user ID of this ticket entry.
	 *
	 * @return the user ID of this ticket entry
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket entry.
	 *
	 * @return the user name of this ticket entry
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket entry.
	 *
	 * @return the user uuid of this ticket entry
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the weight of this ticket entry.
	 *
	 * @return the weight of this ticket entry
	 */
	@Override
	public int getWeight() {
		return model.getWeight();
	}

	@Override
	public boolean isClosed() {
		return model.isClosed();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the closed date of this ticket entry.
	 *
	 * @param closedDate the closed date of this ticket entry
	 */
	@Override
	public void setClosedDate(Date closedDate) {
		model.setClosedDate(closedDate);
	}

	/**
	 * Sets the company ID of this ticket entry.
	 *
	 * @param companyId the company ID of this ticket entry
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket entry.
	 *
	 * @param createDate the create date of this ticket entry
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this ticket entry.
	 *
	 * @param description the description of this ticket entry
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the due date of this ticket entry.
	 *
	 * @param dueDate the due date of this ticket entry
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the hold date of this ticket entry.
	 *
	 * @param holdDate the hold date of this ticket entry
	 */
	@Override
	public void setHoldDate(Date holdDate) {
		model.setHoldDate(holdDate);
	}

	/**
	 * Sets the language ID of this ticket entry.
	 *
	 * @param languageId the language ID of this ticket entry
	 */
	@Override
	public void setLanguageId(String languageId) {
		model.setLanguageId(languageId);
	}

	/**
	 * Sets the modified date of this ticket entry.
	 *
	 * @param modifiedDate the modified date of this ticket entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ticket entry.
	 *
	 * @param primaryKey the primary key of this ticket entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this ticket entry.
	 *
	 * @param status the status of this ticket entry
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the subject of this ticket entry.
	 *
	 * @param subject the subject of this ticket entry
	 */
	@Override
	public void setSubject(String subject) {
		model.setSubject(subject);
	}

	/**
	 * Sets the ticket entry ID of this ticket entry.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket entry
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the ticket number of this ticket entry.
	 *
	 * @param ticketNumber the ticket number of this ticket entry
	 */
	@Override
	public void setTicketNumber(long ticketNumber) {
		model.setTicketNumber(ticketNumber);
	}

	/**
	 * Sets the user ID of this ticket entry.
	 *
	 * @param userId the user ID of this ticket entry
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket entry.
	 *
	 * @param userName the user name of this ticket entry
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket entry.
	 *
	 * @param userUuid the user uuid of this ticket entry
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the weight of this ticket entry.
	 *
	 * @param weight the weight of this ticket entry
	 */
	@Override
	public void setWeight(int weight) {
		model.setWeight(weight);
	}

	@Override
	protected TicketEntryWrapper wrap(TicketEntry ticketEntry) {
		return new TicketEntryWrapper(ticketEntry);
	}

}