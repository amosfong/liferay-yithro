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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SupportLevelAgreement}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportLevelAgreement
 * @generated
 */
public class SupportLevelAgreementWrapper
	extends BaseModelWrapper<SupportLevelAgreement>
	implements ModelWrapper<SupportLevelAgreement>, SupportLevelAgreement {

	public SupportLevelAgreementWrapper(
		SupportLevelAgreement supportLevelAgreement) {

		super(supportLevelAgreement);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supportLevelAgreementId", getSupportLevelAgreementId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supportLevelAgreementId = (Long)attributes.get(
			"supportLevelAgreementId");

		if (supportLevelAgreementId != null) {
			setSupportLevelAgreementId(supportLevelAgreementId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	 * Returns the company ID of this support level agreement.
	 *
	 * @return the company ID of this support level agreement
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this support level agreement.
	 *
	 * @return the create date of this support level agreement
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this support level agreement.
	 *
	 * @return the description of this support level agreement
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the modified date of this support level agreement.
	 *
	 * @return the modified date of this support level agreement
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this support level agreement.
	 *
	 * @return the name of this support level agreement
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this support level agreement.
	 *
	 * @return the primary key of this support level agreement
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the support level agreement ID of this support level agreement.
	 *
	 * @return the support level agreement ID of this support level agreement
	 */
	@Override
	public long getSupportLevelAgreementId() {
		return model.getSupportLevelAgreementId();
	}

	/**
	 * Returns the user ID of this support level agreement.
	 *
	 * @return the user ID of this support level agreement
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user uuid of this support level agreement.
	 *
	 * @return the user uuid of this support level agreement
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a support level agreement model instance should use the <code>SupportLevelAgreement</code> interface instead.
	 */
	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this support level agreement.
	 *
	 * @param companyId the company ID of this support level agreement
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this support level agreement.
	 *
	 * @param createDate the create date of this support level agreement
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this support level agreement.
	 *
	 * @param description the description of this support level agreement
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the modified date of this support level agreement.
	 *
	 * @param modifiedDate the modified date of this support level agreement
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this support level agreement.
	 *
	 * @param name the name of this support level agreement
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this support level agreement.
	 *
	 * @param primaryKey the primary key of this support level agreement
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the support level agreement ID of this support level agreement.
	 *
	 * @param supportLevelAgreementId the support level agreement ID of this support level agreement
	 */
	@Override
	public void setSupportLevelAgreementId(long supportLevelAgreementId) {
		model.setSupportLevelAgreementId(supportLevelAgreementId);
	}

	/**
	 * Sets the user ID of this support level agreement.
	 *
	 * @param userId the user ID of this support level agreement
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user uuid of this support level agreement.
	 *
	 * @param userUuid the user uuid of this support level agreement
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected SupportLevelAgreementWrapper wrap(
		SupportLevelAgreement supportLevelAgreement) {

		return new SupportLevelAgreementWrapper(supportLevelAgreement);
	}

}