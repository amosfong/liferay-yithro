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
 * This class is a wrapper for {@link TicketWorker}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketWorker
 * @generated
 */
@ProviderType
public class TicketWorkerWrapper
	extends BaseModelWrapper<TicketWorker>
	implements TicketWorker, ModelWrapper<TicketWorker> {

	public TicketWorkerWrapper(TicketWorker ticketWorker) {
		super(ticketWorker);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketWorkerId", getTicketWorkerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("sourceClassNameId", getSourceClassNameId());
		attributes.put("sourceClassPK", getSourceClassPK());
		attributes.put("role", getRole());
		attributes.put("primary", isPrimary());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketWorkerId = (Long)attributes.get("ticketWorkerId");

		if (ticketWorkerId != null) {
			setTicketWorkerId(ticketWorkerId);
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

		Long sourceClassNameId = (Long)attributes.get("sourceClassNameId");

		if (sourceClassNameId != null) {
			setSourceClassNameId(sourceClassNameId);
		}

		Long sourceClassPK = (Long)attributes.get("sourceClassPK");

		if (sourceClassPK != null) {
			setSourceClassPK(sourceClassPK);
		}

		Integer role = (Integer)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Boolean primary = (Boolean)attributes.get("primary");

		if (primary != null) {
			setPrimary(primary);
		}
	}

	/**
	 * Returns the company ID of this ticket worker.
	 *
	 * @return the company ID of this ticket worker
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket worker.
	 *
	 * @return the create date of this ticket worker
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the primary of this ticket worker.
	 *
	 * @return the primary of this ticket worker
	 */
	@Override
	public boolean getPrimary() {
		return model.getPrimary();
	}

	/**
	 * Returns the primary key of this ticket worker.
	 *
	 * @return the primary key of this ticket worker
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this ticket worker.
	 *
	 * @return the role of this ticket worker
	 */
	@Override
	public int getRole() {
		return model.getRole();
	}

	@Override
	public String getRoleLabel() {
		return model.getRoleLabel();
	}

	/**
	 * Returns the source class name ID of this ticket worker.
	 *
	 * @return the source class name ID of this ticket worker
	 */
	@Override
	public long getSourceClassNameId() {
		return model.getSourceClassNameId();
	}

	/**
	 * Returns the source class pk of this ticket worker.
	 *
	 * @return the source class pk of this ticket worker
	 */
	@Override
	public long getSourceClassPK() {
		return model.getSourceClassPK();
	}

	@Override
	public TicketEntry getTicketEntry()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTicketEntry();
	}

	/**
	 * Returns the ticket entry ID of this ticket worker.
	 *
	 * @return the ticket entry ID of this ticket worker
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the ticket worker ID of this ticket worker.
	 *
	 * @return the ticket worker ID of this ticket worker
	 */
	@Override
	public long getTicketWorkerId() {
		return model.getTicketWorkerId();
	}

	/**
	 * Returns the user ID of this ticket worker.
	 *
	 * @return the user ID of this ticket worker
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket worker.
	 *
	 * @return the user name of this ticket worker
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket worker.
	 *
	 * @return the user uuid of this ticket worker
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this ticket worker is primary.
	 *
	 * @return <code>true</code> if this ticket worker is primary; <code>false</code> otherwise
	 */
	@Override
	public boolean isPrimary() {
		return model.isPrimary();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this ticket worker.
	 *
	 * @param companyId the company ID of this ticket worker
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket worker.
	 *
	 * @param createDate the create date of this ticket worker
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets whether this ticket worker is primary.
	 *
	 * @param primary the primary of this ticket worker
	 */
	@Override
	public void setPrimary(boolean primary) {
		model.setPrimary(primary);
	}

	/**
	 * Sets the primary key of this ticket worker.
	 *
	 * @param primaryKey the primary key of this ticket worker
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this ticket worker.
	 *
	 * @param role the role of this ticket worker
	 */
	@Override
	public void setRole(int role) {
		model.setRole(role);
	}

	/**
	 * Sets the source class name ID of this ticket worker.
	 *
	 * @param sourceClassNameId the source class name ID of this ticket worker
	 */
	@Override
	public void setSourceClassNameId(long sourceClassNameId) {
		model.setSourceClassNameId(sourceClassNameId);
	}

	/**
	 * Sets the source class pk of this ticket worker.
	 *
	 * @param sourceClassPK the source class pk of this ticket worker
	 */
	@Override
	public void setSourceClassPK(long sourceClassPK) {
		model.setSourceClassPK(sourceClassPK);
	}

	/**
	 * Sets the ticket entry ID of this ticket worker.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket worker
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the ticket worker ID of this ticket worker.
	 *
	 * @param ticketWorkerId the ticket worker ID of this ticket worker
	 */
	@Override
	public void setTicketWorkerId(long ticketWorkerId) {
		model.setTicketWorkerId(ticketWorkerId);
	}

	/**
	 * Sets the user ID of this ticket worker.
	 *
	 * @param userId the user ID of this ticket worker
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket worker.
	 *
	 * @param userName the user name of this ticket worker
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket worker.
	 *
	 * @param userUuid the user uuid of this ticket worker
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TicketWorkerWrapper wrap(TicketWorker ticketWorker) {
		return new TicketWorkerWrapper(ticketWorker);
	}

}