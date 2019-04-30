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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SupportTeam}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportTeam
 * @generated
 */
@ProviderType
public class SupportTeamWrapper
	extends BaseModelWrapper<SupportTeam>
	implements SupportTeam, ModelWrapper<SupportTeam> {

	public SupportTeamWrapper(SupportTeam supportTeam) {
		super(supportTeam);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supportTeamId", getSupportTeamId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("parentSupportTeamId", getParentSupportTeamId());
		attributes.put("supportLaborId", getSupportLaborId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("assignedWork", getAssignedWork());
		attributes.put("maxWork", getMaxWork());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supportTeamId = (Long)attributes.get("supportTeamId");

		if (supportTeamId != null) {
			setSupportTeamId(supportTeamId);
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

		Long parentSupportTeamId = (Long)attributes.get("parentSupportTeamId");

		if (parentSupportTeamId != null) {
			setParentSupportTeamId(parentSupportTeamId);
		}

		Long supportLaborId = (Long)attributes.get("supportLaborId");

		if (supportLaborId != null) {
			setSupportLaborId(supportLaborId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Double assignedWork = (Double)attributes.get("assignedWork");

		if (assignedWork != null) {
			setAssignedWork(assignedWork);
		}

		Double maxWork = (Double)attributes.get("maxWork");

		if (maxWork != null) {
			setMaxWork(maxWork);
		}
	}

	/**
	 * Returns the assigned work of this support team.
	 *
	 * @return the assigned work of this support team
	 */
	@Override
	public double getAssignedWork() {
		return model.getAssignedWork();
	}

	/**
	 * Returns the company ID of this support team.
	 *
	 * @return the company ID of this support team
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this support team.
	 *
	 * @return the create date of this support team
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this support team.
	 *
	 * @return the description of this support team
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the max work of this support team.
	 *
	 * @return the max work of this support team
	 */
	@Override
	public double getMaxWork() {
		return model.getMaxWork();
	}

	/**
	 * Returns the modified date of this support team.
	 *
	 * @return the modified date of this support team
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this support team.
	 *
	 * @return the name of this support team
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the parent support team ID of this support team.
	 *
	 * @return the parent support team ID of this support team
	 */
	@Override
	public long getParentSupportTeamId() {
		return model.getParentSupportTeamId();
	}

	/**
	 * Returns the primary key of this support team.
	 *
	 * @return the primary key of this support team
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the support labor ID of this support team.
	 *
	 * @return the support labor ID of this support team
	 */
	@Override
	public long getSupportLaborId() {
		return model.getSupportLaborId();
	}

	/**
	 * Returns the support team ID of this support team.
	 *
	 * @return the support team ID of this support team
	 */
	@Override
	public long getSupportTeamId() {
		return model.getSupportTeamId();
	}

	/**
	 * Returns the user ID of this support team.
	 *
	 * @return the user ID of this support team
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this support team.
	 *
	 * @return the user name of this support team
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this support team.
	 *
	 * @return the user uuid of this support team
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
	 * Sets the assigned work of this support team.
	 *
	 * @param assignedWork the assigned work of this support team
	 */
	@Override
	public void setAssignedWork(double assignedWork) {
		model.setAssignedWork(assignedWork);
	}

	/**
	 * Sets the company ID of this support team.
	 *
	 * @param companyId the company ID of this support team
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this support team.
	 *
	 * @param createDate the create date of this support team
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this support team.
	 *
	 * @param description the description of this support team
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the max work of this support team.
	 *
	 * @param maxWork the max work of this support team
	 */
	@Override
	public void setMaxWork(double maxWork) {
		model.setMaxWork(maxWork);
	}

	/**
	 * Sets the modified date of this support team.
	 *
	 * @param modifiedDate the modified date of this support team
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this support team.
	 *
	 * @param name the name of this support team
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the parent support team ID of this support team.
	 *
	 * @param parentSupportTeamId the parent support team ID of this support team
	 */
	@Override
	public void setParentSupportTeamId(long parentSupportTeamId) {
		model.setParentSupportTeamId(parentSupportTeamId);
	}

	/**
	 * Sets the primary key of this support team.
	 *
	 * @param primaryKey the primary key of this support team
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the support labor ID of this support team.
	 *
	 * @param supportLaborId the support labor ID of this support team
	 */
	@Override
	public void setSupportLaborId(long supportLaborId) {
		model.setSupportLaborId(supportLaborId);
	}

	/**
	 * Sets the support team ID of this support team.
	 *
	 * @param supportTeamId the support team ID of this support team
	 */
	@Override
	public void setSupportTeamId(long supportTeamId) {
		model.setSupportTeamId(supportTeamId);
	}

	/**
	 * Sets the user ID of this support team.
	 *
	 * @param userId the user ID of this support team
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this support team.
	 *
	 * @param userName the user name of this support team
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this support team.
	 *
	 * @param userUuid the user uuid of this support team
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SupportTeamWrapper wrap(SupportTeam supportTeam) {
		return new SupportTeamWrapper(supportTeam);
	}

}