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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.support.service.http.SupportLevelAgreementServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SupportLevelAgreementSoap implements Serializable {

	public static SupportLevelAgreementSoap toSoapModel(
		SupportLevelAgreement model) {

		SupportLevelAgreementSoap soapModel = new SupportLevelAgreementSoap();

		soapModel.setSupportLevelAgreementId(
			model.getSupportLevelAgreementId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static SupportLevelAgreementSoap[] toSoapModels(
		SupportLevelAgreement[] models) {

		SupportLevelAgreementSoap[] soapModels =
			new SupportLevelAgreementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SupportLevelAgreementSoap[][] toSoapModels(
		SupportLevelAgreement[][] models) {

		SupportLevelAgreementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new SupportLevelAgreementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SupportLevelAgreementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SupportLevelAgreementSoap[] toSoapModels(
		List<SupportLevelAgreement> models) {

		List<SupportLevelAgreementSoap> soapModels =
			new ArrayList<SupportLevelAgreementSoap>(models.size());

		for (SupportLevelAgreement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new SupportLevelAgreementSoap[soapModels.size()]);
	}

	public SupportLevelAgreementSoap() {
	}

	public long getPrimaryKey() {
		return _supportLevelAgreementId;
	}

	public void setPrimaryKey(long pk) {
		setSupportLevelAgreementId(pk);
	}

	public long getSupportLevelAgreementId() {
		return _supportLevelAgreementId;
	}

	public void setSupportLevelAgreementId(long supportLevelAgreementId) {
		_supportLevelAgreementId = supportLevelAgreementId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _supportLevelAgreementId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;

}