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
 * This class is a wrapper for {@link TicketCommunication}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommunication
 * @generated
 */
@ProviderType
public class TicketCommunicationWrapper
	extends BaseModelWrapper<TicketCommunication>
	implements TicketCommunication, ModelWrapper<TicketCommunication> {

	public TicketCommunicationWrapper(TicketCommunication ticketCommunication) {
		super(ticketCommunication);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketCommunicationId", getTicketCommunicationId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("content", getContent());
		attributes.put("properties", getProperties());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketCommunicationId = (Long)attributes.get(
			"ticketCommunicationId");

		if (ticketCommunicationId != null) {
			setTicketCommunicationId(ticketCommunicationId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
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

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String properties = (String)attributes.get("properties");

		if (properties != null) {
			setProperties(properties);
		}
	}

	/**
	 * Returns the fully qualified class name of this ticket communication.
	 *
	 * @return the fully qualified class name of this ticket communication
	 */
	@Override
	public String getClassName() {
		return model.getClassName();
	}

	/**
	 * Returns the class name ID of this ticket communication.
	 *
	 * @return the class name ID of this ticket communication
	 */
	@Override
	public long getClassNameId() {
		return model.getClassNameId();
	}

	/**
	 * Returns the class pk of this ticket communication.
	 *
	 * @return the class pk of this ticket communication
	 */
	@Override
	public long getClassPK() {
		return model.getClassPK();
	}

	/**
	 * Returns the company ID of this ticket communication.
	 *
	 * @return the company ID of this ticket communication
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this ticket communication.
	 *
	 * @return the content of this ticket communication
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the create date of this ticket communication.
	 *
	 * @return the create date of this ticket communication
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the modified date of this ticket communication.
	 *
	 * @return the modified date of this ticket communication
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ticket communication.
	 *
	 * @return the primary key of this ticket communication
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the properties of this ticket communication.
	 *
	 * @return the properties of this ticket communication
	 */
	@Override
	public String getProperties() {
		return model.getProperties();
	}

	/**
	 * Returns the ticket communication ID of this ticket communication.
	 *
	 * @return the ticket communication ID of this ticket communication
	 */
	@Override
	public long getTicketCommunicationId() {
		return model.getTicketCommunicationId();
	}

	/**
	 * Returns the ticket entry ID of this ticket communication.
	 *
	 * @return the ticket entry ID of this ticket communication
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the user ID of this ticket communication.
	 *
	 * @return the user ID of this ticket communication
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this ticket communication.
	 *
	 * @return the user uuid of this ticket communication
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void setClassName(String className) {
		model.setClassName(className);
	}

	/**
	 * Sets the class name ID of this ticket communication.
	 *
	 * @param classNameId the class name ID of this ticket communication
	 */
	@Override
	public void setClassNameId(long classNameId) {
		model.setClassNameId(classNameId);
	}

	/**
	 * Sets the class pk of this ticket communication.
	 *
	 * @param classPK the class pk of this ticket communication
	 */
	@Override
	public void setClassPK(long classPK) {
		model.setClassPK(classPK);
	}

	/**
	 * Sets the company ID of this ticket communication.
	 *
	 * @param companyId the company ID of this ticket communication
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this ticket communication.
	 *
	 * @param content the content of this ticket communication
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the create date of this ticket communication.
	 *
	 * @param createDate the create date of this ticket communication
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this ticket communication.
	 *
	 * @param modifiedDate the modified date of this ticket communication
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ticket communication.
	 *
	 * @param primaryKey the primary key of this ticket communication
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the properties of this ticket communication.
	 *
	 * @param properties the properties of this ticket communication
	 */
	@Override
	public void setProperties(String properties) {
		model.setProperties(properties);
	}

	/**
	 * Sets the ticket communication ID of this ticket communication.
	 *
	 * @param ticketCommunicationId the ticket communication ID of this ticket communication
	 */
	@Override
	public void setTicketCommunicationId(long ticketCommunicationId) {
		model.setTicketCommunicationId(ticketCommunicationId);
	}

	/**
	 * Sets the ticket entry ID of this ticket communication.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket communication
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the user ID of this ticket communication.
	 *
	 * @param userId the user ID of this ticket communication
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this ticket communication.
	 *
	 * @param userUuid the user uuid of this ticket communication
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TicketCommunicationWrapper wrap(
		TicketCommunication ticketCommunication) {

		return new TicketCommunicationWrapper(ticketCommunication);
	}

}