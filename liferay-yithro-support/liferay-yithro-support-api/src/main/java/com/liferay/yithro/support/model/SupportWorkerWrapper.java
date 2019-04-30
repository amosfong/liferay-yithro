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

package com.liferay.yithro.support.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SupportWorker}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorker
 * @generated
 */
@ProviderType
public class SupportWorkerWrapper
	extends BaseModelWrapper<SupportWorker>
	implements SupportWorker, ModelWrapper<SupportWorker> {

	public SupportWorkerWrapper(SupportWorker supportWorker) {
		super(supportWorker);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supportWorkerId", getSupportWorkerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("supportTeamId", getSupportTeamId());
		attributes.put("supportLaborId", getSupportLaborId());
		attributes.put("assignedWork", getAssignedWork());
		attributes.put("maxWork", getMaxWork());
		attributes.put("role", getRole());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supportWorkerId = (Long)attributes.get("supportWorkerId");

		if (supportWorkerId != null) {
			setSupportWorkerId(supportWorkerId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long supportTeamId = (Long)attributes.get("supportTeamId");

		if (supportTeamId != null) {
			setSupportTeamId(supportTeamId);
		}

		Long supportLaborId = (Long)attributes.get("supportLaborId");

		if (supportLaborId != null) {
			setSupportLaborId(supportLaborId);
		}

		Double assignedWork = (Double)attributes.get("assignedWork");

		if (assignedWork != null) {
			setAssignedWork(assignedWork);
		}

		Double maxWork = (Double)attributes.get("maxWork");

		if (maxWork != null) {
			setMaxWork(maxWork);
		}

		Integer role = (Integer)attributes.get("role");

		if (role != null) {
			setRole(role);
		}
	}

	/**
	 * Returns the assigned work of this support worker.
	 *
	 * @return the assigned work of this support worker
	 */
	@Override
	public double getAssignedWork() {
		return model.getAssignedWork();
	}

	/**
	 * Returns the company ID of this support worker.
	 *
	 * @return the company ID of this support worker
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the max work of this support worker.
	 *
	 * @return the max work of this support worker
	 */
	@Override
	public double getMaxWork() {
		return model.getMaxWork();
	}

	/**
	 * Returns the primary key of this support worker.
	 *
	 * @return the primary key of this support worker
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the role of this support worker.
	 *
	 * @return the role of this support worker
	 */
	@Override
	public int getRole() {
		return model.getRole();
	}

	@Override
	public SupportLabor getSupportLabor()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getSupportLabor();
	}

	/**
	 * Returns the support labor ID of this support worker.
	 *
	 * @return the support labor ID of this support worker
	 */
	@Override
	public long getSupportLaborId() {
		return model.getSupportLaborId();
	}

	@Override
	public SupportTeam getSupportTeam()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getSupportTeam();
	}

	/**
	 * Returns the support team ID of this support worker.
	 *
	 * @return the support team ID of this support worker
	 */
	@Override
	public long getSupportTeamId() {
		return model.getSupportTeamId();
	}

	/**
	 * Returns the support worker ID of this support worker.
	 *
	 * @return the support worker ID of this support worker
	 */
	@Override
	public long getSupportWorkerId() {
		return model.getSupportWorkerId();
	}

	@Override
	public Long getTimeUntilClose()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTimeUntilClose();
	}

	@Override
	public Long getTimeUntilOpen()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.getTimeUntilOpen();
	}

	/**
	 * Returns the user ID of this support worker.
	 *
	 * @return the user ID of this support worker
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this support worker.
	 *
	 * @return the user uuid of this support worker
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	@Override
	public boolean isActive() {
		return model.isActive();
	}

	@Override
	public boolean isAvailable()
		throws com.liferay.portal.kernel.exception.PortalException {

		return model.isAvailable();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the assigned work of this support worker.
	 *
	 * @param assignedWork the assigned work of this support worker
	 */
	@Override
	public void setAssignedWork(double assignedWork) {
		model.setAssignedWork(assignedWork);
	}

	/**
	 * Sets the company ID of this support worker.
	 *
	 * @param companyId the company ID of this support worker
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the max work of this support worker.
	 *
	 * @param maxWork the max work of this support worker
	 */
	@Override
	public void setMaxWork(double maxWork) {
		model.setMaxWork(maxWork);
	}

	/**
	 * Sets the primary key of this support worker.
	 *
	 * @param primaryKey the primary key of this support worker
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the role of this support worker.
	 *
	 * @param role the role of this support worker
	 */
	@Override
	public void setRole(int role) {
		model.setRole(role);
	}

	/**
	 * Sets the support labor ID of this support worker.
	 *
	 * @param supportLaborId the support labor ID of this support worker
	 */
	@Override
	public void setSupportLaborId(long supportLaborId) {
		model.setSupportLaborId(supportLaborId);
	}

	/**
	 * Sets the support team ID of this support worker.
	 *
	 * @param supportTeamId the support team ID of this support worker
	 */
	@Override
	public void setSupportTeamId(long supportTeamId) {
		model.setSupportTeamId(supportTeamId);
	}

	/**
	 * Sets the support worker ID of this support worker.
	 *
	 * @param supportWorkerId the support worker ID of this support worker
	 */
	@Override
	public void setSupportWorkerId(long supportWorkerId) {
		model.setSupportWorkerId(supportWorkerId);
	}

	/**
	 * Sets the user ID of this support worker.
	 *
	 * @param userId the user ID of this support worker
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this support worker.
	 *
	 * @param userUuid the user uuid of this support worker
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SupportWorkerWrapper wrap(SupportWorker supportWorker) {
		return new SupportWorkerWrapper(supportWorker);
	}

}