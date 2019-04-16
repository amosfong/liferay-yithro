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
 * This class is a wrapper for {@link TicketComment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketComment
 * @generated
 */
@ProviderType
public class TicketCommentWrapper
	extends BaseModelWrapper<TicketComment>
	implements TicketComment, ModelWrapper<TicketComment> {

	public TicketCommentWrapper(TicketComment ticketComment) {
		super(ticketComment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketCommentId", getTicketCommentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("body", getBody());
		attributes.put("type", getType());
		attributes.put("format", getFormat());
		attributes.put("visibility", getVisibility());
		attributes.put("settings", getSettings());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketCommentId = (Long)attributes.get("ticketCommentId");

		if (ticketCommentId != null) {
			setTicketCommentId(ticketCommentId);
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

		Long ticketEntryId = (Long)attributes.get("ticketEntryId");

		if (ticketEntryId != null) {
			setTicketEntryId(ticketEntryId);
		}

		String body = (String)attributes.get("body");

		if (body != null) {
			setBody(body);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String format = (String)attributes.get("format");

		if (format != null) {
			setFormat(format);
		}

		Integer visibility = (Integer)attributes.get("visibility");

		if (visibility != null) {
			setVisibility(visibility);
		}

		String settings = (String)attributes.get("settings");

		if (settings != null) {
			setSettings(settings);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the body of this ticket comment.
	 *
	 * @return the body of this ticket comment
	 */
	@Override
	public String getBody() {
		return model.getBody();
	}

	/**
	 * Returns the company ID of this ticket comment.
	 *
	 * @return the company ID of this ticket comment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket comment.
	 *
	 * @return the create date of this ticket comment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the format of this ticket comment.
	 *
	 * @return the format of this ticket comment
	 */
	@Override
	public String getFormat() {
		return model.getFormat();
	}

	/**
	 * Returns the modified date of this ticket comment.
	 *
	 * @return the modified date of this ticket comment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ticket comment.
	 *
	 * @return the primary key of this ticket comment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the settings of this ticket comment.
	 *
	 * @return the settings of this ticket comment
	 */
	@Override
	public String getSettings() {
		return model.getSettings();
	}

	@Override
	public com.liferay.portal.kernel.util.UnicodeProperties
		getSettingsProperties() {

		return model.getSettingsProperties();
	}

	@Override
	public String getSettingsProperty(String key) {
		return model.getSettingsProperty(key);
	}

	/**
	 * Returns the status of this ticket comment.
	 *
	 * @return the status of this ticket comment
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ticket comment ID of this ticket comment.
	 *
	 * @return the ticket comment ID of this ticket comment
	 */
	@Override
	public long getTicketCommentId() {
		return model.getTicketCommentId();
	}

	/**
	 * Returns the ticket entry ID of this ticket comment.
	 *
	 * @return the ticket entry ID of this ticket comment
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the type of this ticket comment.
	 *
	 * @return the type of this ticket comment
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this ticket comment.
	 *
	 * @return the user ID of this ticket comment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket comment.
	 *
	 * @return the user name of this ticket comment
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket comment.
	 *
	 * @return the user uuid of this ticket comment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the visibility of this ticket comment.
	 *
	 * @return the visibility of this ticket comment
	 */
	@Override
	public int getVisibility() {
		return model.getVisibility();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the body of this ticket comment.
	 *
	 * @param body the body of this ticket comment
	 */
	@Override
	public void setBody(String body) {
		model.setBody(body);
	}

	/**
	 * Sets the company ID of this ticket comment.
	 *
	 * @param companyId the company ID of this ticket comment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket comment.
	 *
	 * @param createDate the create date of this ticket comment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the format of this ticket comment.
	 *
	 * @param format the format of this ticket comment
	 */
	@Override
	public void setFormat(String format) {
		model.setFormat(format);
	}

	/**
	 * Sets the modified date of this ticket comment.
	 *
	 * @param modifiedDate the modified date of this ticket comment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ticket comment.
	 *
	 * @param primaryKey the primary key of this ticket comment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the settings of this ticket comment.
	 *
	 * @param settings the settings of this ticket comment
	 */
	@Override
	public void setSettings(String settings) {
		model.setSettings(settings);
	}

	@Override
	public void setSettingsProperties(
		com.liferay.portal.kernel.util.UnicodeProperties settingsProperties) {

		model.setSettingsProperties(settingsProperties);
	}

	@Override
	public void setSettingsProperty(String key, String value) {
		model.setSettingsProperty(key, value);
	}

	/**
	 * Sets the status of this ticket comment.
	 *
	 * @param status the status of this ticket comment
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ticket comment ID of this ticket comment.
	 *
	 * @param ticketCommentId the ticket comment ID of this ticket comment
	 */
	@Override
	public void setTicketCommentId(long ticketCommentId) {
		model.setTicketCommentId(ticketCommentId);
	}

	/**
	 * Sets the ticket entry ID of this ticket comment.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket comment
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the type of this ticket comment.
	 *
	 * @param type the type of this ticket comment
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this ticket comment.
	 *
	 * @param userId the user ID of this ticket comment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket comment.
	 *
	 * @param userName the user name of this ticket comment
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket comment.
	 *
	 * @param userUuid the user uuid of this ticket comment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the visibility of this ticket comment.
	 *
	 * @param visibility the visibility of this ticket comment
	 */
	@Override
	public void setVisibility(int visibility) {
		model.setVisibility(visibility);
	}

	@Override
	protected TicketCommentWrapper wrap(TicketComment ticketComment) {
		return new TicketCommentWrapper(ticketComment);
	}

}