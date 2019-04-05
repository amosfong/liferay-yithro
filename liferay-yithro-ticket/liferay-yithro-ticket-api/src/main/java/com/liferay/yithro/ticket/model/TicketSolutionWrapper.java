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
 * This class is a wrapper for {@link TicketSolution}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketSolution
 * @generated
 */
@ProviderType
public class TicketSolutionWrapper
	extends BaseModelWrapper<TicketSolution>
	implements TicketSolution, ModelWrapper<TicketSolution> {

	public TicketSolutionWrapper(TicketSolution ticketSolution) {
		super(ticketSolution);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketSolutionId", getTicketSolutionId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("ticketEntryId", getTicketEntryId());
		attributes.put("solution", getSolution());
		attributes.put("type", getType());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("statusMessage", getStatusMessage());
		attributes.put("statusReason", getStatusReason());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketSolutionId = (Long)attributes.get("ticketSolutionId");

		if (ticketSolutionId != null) {
			setTicketSolutionId(ticketSolutionId);
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

		String solution = (String)attributes.get("solution");

		if (solution != null) {
			setSolution(solution);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String statusMessage = (String)attributes.get("statusMessage");

		if (statusMessage != null) {
			setStatusMessage(statusMessage);
		}

		Integer statusReason = (Integer)attributes.get("statusReason");

		if (statusReason != null) {
			setStatusReason(statusReason);
		}
	}

	/**
	 * Returns the create date of this ticket solution.
	 *
	 * @return the create date of this ticket solution
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the primary key of this ticket solution.
	 *
	 * @return the primary key of this ticket solution
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the solution of this ticket solution.
	 *
	 * @return the solution of this ticket solution
	 */
	@Override
	public String getSolution() {
		return model.getSolution();
	}

	/**
	 * Returns the status of this ticket solution.
	 *
	 * @return the status of this ticket solution
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this ticket solution.
	 *
	 * @return the status by user ID of this ticket solution
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this ticket solution.
	 *
	 * @return the status by user name of this ticket solution
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this ticket solution.
	 *
	 * @return the status by user uuid of this ticket solution
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this ticket solution.
	 *
	 * @return the status date of this ticket solution
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the status message of this ticket solution.
	 *
	 * @return the status message of this ticket solution
	 */
	@Override
	public String getStatusMessage() {
		return model.getStatusMessage();
	}

	/**
	 * Returns the status reason of this ticket solution.
	 *
	 * @return the status reason of this ticket solution
	 */
	@Override
	public int getStatusReason() {
		return model.getStatusReason();
	}

	/**
	 * Returns the ticket entry ID of this ticket solution.
	 *
	 * @return the ticket entry ID of this ticket solution
	 */
	@Override
	public long getTicketEntryId() {
		return model.getTicketEntryId();
	}

	/**
	 * Returns the ticket solution ID of this ticket solution.
	 *
	 * @return the ticket solution ID of this ticket solution
	 */
	@Override
	public long getTicketSolutionId() {
		return model.getTicketSolutionId();
	}

	/**
	 * Returns the type of this ticket solution.
	 *
	 * @return the type of this ticket solution
	 */
	@Override
	public int getType() {
		return model.getType();
	}

	/**
	 * Returns the user ID of this ticket solution.
	 *
	 * @return the user ID of this ticket solution
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket solution.
	 *
	 * @return the user name of this ticket solution
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket solution.
	 *
	 * @return the user uuid of this ticket solution
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns <code>true</code> if this ticket solution is approved.
	 *
	 * @return <code>true</code> if this ticket solution is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this ticket solution is denied.
	 *
	 * @return <code>true</code> if this ticket solution is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this ticket solution is a draft.
	 *
	 * @return <code>true</code> if this ticket solution is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this ticket solution is expired.
	 *
	 * @return <code>true</code> if this ticket solution is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this ticket solution is inactive.
	 *
	 * @return <code>true</code> if this ticket solution is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this ticket solution is incomplete.
	 *
	 * @return <code>true</code> if this ticket solution is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this ticket solution is pending.
	 *
	 * @return <code>true</code> if this ticket solution is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this ticket solution is scheduled.
	 *
	 * @return <code>true</code> if this ticket solution is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this ticket solution.
	 *
	 * @param createDate the create date of this ticket solution
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the primary key of this ticket solution.
	 *
	 * @param primaryKey the primary key of this ticket solution
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the solution of this ticket solution.
	 *
	 * @param solution the solution of this ticket solution
	 */
	@Override
	public void setSolution(String solution) {
		model.setSolution(solution);
	}

	/**
	 * Sets the status of this ticket solution.
	 *
	 * @param status the status of this ticket solution
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this ticket solution.
	 *
	 * @param statusByUserId the status by user ID of this ticket solution
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this ticket solution.
	 *
	 * @param statusByUserName the status by user name of this ticket solution
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this ticket solution.
	 *
	 * @param statusByUserUuid the status by user uuid of this ticket solution
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this ticket solution.
	 *
	 * @param statusDate the status date of this ticket solution
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the status message of this ticket solution.
	 *
	 * @param statusMessage the status message of this ticket solution
	 */
	@Override
	public void setStatusMessage(String statusMessage) {
		model.setStatusMessage(statusMessage);
	}

	/**
	 * Sets the status reason of this ticket solution.
	 *
	 * @param statusReason the status reason of this ticket solution
	 */
	@Override
	public void setStatusReason(int statusReason) {
		model.setStatusReason(statusReason);
	}

	/**
	 * Sets the ticket entry ID of this ticket solution.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket solution
	 */
	@Override
	public void setTicketEntryId(long ticketEntryId) {
		model.setTicketEntryId(ticketEntryId);
	}

	/**
	 * Sets the ticket solution ID of this ticket solution.
	 *
	 * @param ticketSolutionId the ticket solution ID of this ticket solution
	 */
	@Override
	public void setTicketSolutionId(long ticketSolutionId) {
		model.setTicketSolutionId(ticketSolutionId);
	}

	/**
	 * Sets the type of this ticket solution.
	 *
	 * @param type the type of this ticket solution
	 */
	@Override
	public void setType(int type) {
		model.setType(type);
	}

	/**
	 * Sets the user ID of this ticket solution.
	 *
	 * @param userId the user ID of this ticket solution
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket solution.
	 *
	 * @param userName the user name of this ticket solution
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket solution.
	 *
	 * @param userUuid the user uuid of this ticket solution
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TicketSolutionWrapper wrap(TicketSolution ticketSolution) {
		return new TicketSolutionWrapper(ticketSolution);
	}

}