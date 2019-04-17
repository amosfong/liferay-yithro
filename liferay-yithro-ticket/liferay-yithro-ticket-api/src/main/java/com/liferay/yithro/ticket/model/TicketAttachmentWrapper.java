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
 * This class is a wrapper for {@link TicketAttachment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketAttachment
 * @generated
 */
@ProviderType
public class TicketAttachmentWrapper
	extends BaseModelWrapper<TicketAttachment>
	implements TicketAttachment, ModelWrapper<TicketAttachment> {

	public TicketAttachmentWrapper(TicketAttachment ticketAttachment) {
		super(ticketAttachment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketAttachmentId", getTicketAttachmentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("fileName", getFileName());
		attributes.put("fileSize", getFileSize());
		attributes.put("visibility", getVisibility());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketAttachmentId = (Long)attributes.get("ticketAttachmentId");

		if (ticketAttachmentId != null) {
			setTicketAttachmentId(ticketAttachmentId);
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

		String fileName = (String)attributes.get("fileName");

		if (fileName != null) {
			setFileName(fileName);
		}

		Long fileSize = (Long)attributes.get("fileSize");

		if (fileSize != null) {
			setFileSize(fileSize);
		}

		Integer visibility = (Integer)attributes.get("visibility");

		if (visibility != null) {
			setVisibility(visibility);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	 * Returns the company ID of this ticket attachment.
	 *
	 * @return the company ID of this ticket attachment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket attachment.
	 *
	 * @return the create date of this ticket attachment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public java.io.File getFile() {
		return model.getFile();
	}

	@Override
	public String getFileDir() {
		return model.getFileDir();
	}

	/**
	 * Returns the file name of this ticket attachment.
	 *
	 * @return the file name of this ticket attachment
	 */
	@Override
	public String getFileName() {
		return model.getFileName();
	}

	@Override
	public String getFilePath() {
		return model.getFilePath();
	}

	/**
	 * Returns the file size of this ticket attachment.
	 *
	 * @return the file size of this ticket attachment
	 */
	@Override
	public long getFileSize() {
		return model.getFileSize();
	}

	/**
	 * Returns the primary key of this ticket attachment.
	 *
	 * @return the primary key of this ticket attachment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this ticket attachment.
	 *
	 * @return the status of this ticket attachment
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ticket attachment ID of this ticket attachment.
	 *
	 * @return the ticket attachment ID of this ticket attachment
	 */
	@Override
	public long getTicketAttachmentId() {
		return model.getTicketAttachmentId();
	}

	/**
	 * Returns the ticket entry ID of this ticket attachment.
	 *
	 * @return the ticket entry ID of this ticket attachment
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the user ID of this ticket attachment.
	 *
	 * @return the user ID of this ticket attachment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket attachment.
	 *
	 * @return the user name of this ticket attachment
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket attachment.
	 *
	 * @return the user uuid of this ticket attachment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the visibility of this ticket attachment.
	 *
	 * @return the visibility of this ticket attachment
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
	 * Sets the company ID of this ticket attachment.
	 *
	 * @param companyId the company ID of this ticket attachment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket attachment.
	 *
	 * @param createDate the create date of this ticket attachment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	@Override
	public void setFile(java.io.File file) {
		model.setFile(file);
	}

	/**
	 * Sets the file name of this ticket attachment.
	 *
	 * @param fileName the file name of this ticket attachment
	 */
	@Override
	public void setFileName(String fileName) {
		model.setFileName(fileName);
	}

	/**
	 * Sets the file size of this ticket attachment.
	 *
	 * @param fileSize the file size of this ticket attachment
	 */
	@Override
	public void setFileSize(long fileSize) {
		model.setFileSize(fileSize);
	}

	/**
	 * Sets the primary key of this ticket attachment.
	 *
	 * @param primaryKey the primary key of this ticket attachment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this ticket attachment.
	 *
	 * @param status the status of this ticket attachment
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ticket attachment ID of this ticket attachment.
	 *
	 * @param ticketAttachmentId the ticket attachment ID of this ticket attachment
	 */
	@Override
	public void setTicketAttachmentId(long ticketAttachmentId) {
		model.setTicketAttachmentId(ticketAttachmentId);
	}

	/**
	 * Sets the ticket entry ID of this ticket attachment.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket attachment
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the user ID of this ticket attachment.
	 *
	 * @param userId the user ID of this ticket attachment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket attachment.
	 *
	 * @param userName the user name of this ticket attachment
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket attachment.
	 *
	 * @param userUuid the user uuid of this ticket attachment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the visibility of this ticket attachment.
	 *
	 * @param visibility the visibility of this ticket attachment
	 */
	@Override
	public void setVisibility(int visibility) {
		model.setVisibility(visibility);
	}

	@Override
	protected TicketAttachmentWrapper wrap(TicketAttachment ticketAttachment) {
		return new TicketAttachmentWrapper(ticketAttachment);
	}

}