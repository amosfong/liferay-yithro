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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.support.service.http.SupportWorkerServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SupportWorkerSoap implements Serializable {

	public static SupportWorkerSoap toSoapModel(SupportWorker model) {
		SupportWorkerSoap soapModel = new SupportWorkerSoap();

		soapModel.setSupportWorkerId(model.getSupportWorkerId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setSupportTeamId(model.getSupportTeamId());
		soapModel.setSupportLaborId(model.getSupportLaborId());
		soapModel.setAssignedWork(model.getAssignedWork());
		soapModel.setMaxWork(model.getMaxWork());
		soapModel.setRole(model.getRole());

		return soapModel;
	}

	public static SupportWorkerSoap[] toSoapModels(SupportWorker[] models) {
		SupportWorkerSoap[] soapModels = new SupportWorkerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SupportWorkerSoap[][] toSoapModels(SupportWorker[][] models) {
		SupportWorkerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SupportWorkerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SupportWorkerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SupportWorkerSoap[] toSoapModels(List<SupportWorker> models) {
		List<SupportWorkerSoap> soapModels = new ArrayList<SupportWorkerSoap>(
			models.size());

		for (SupportWorker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SupportWorkerSoap[soapModels.size()]);
	}

	public SupportWorkerSoap() {
	}

	public long getPrimaryKey() {
		return _supportWorkerId;
	}

	public void setPrimaryKey(long pk) {
		setSupportWorkerId(pk);
	}

	public long getSupportWorkerId() {
		return _supportWorkerId;
	}

	public void setSupportWorkerId(long supportWorkerId) {
		_supportWorkerId = supportWorkerId;
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

	public long getSupportTeamId() {
		return _supportTeamId;
	}

	public void setSupportTeamId(long supportTeamId) {
		_supportTeamId = supportTeamId;
	}

	public long getSupportLaborId() {
		return _supportLaborId;
	}

	public void setSupportLaborId(long supportLaborId) {
		_supportLaborId = supportLaborId;
	}

	public double getAssignedWork() {
		return _assignedWork;
	}

	public void setAssignedWork(double assignedWork) {
		_assignedWork = assignedWork;
	}

	public double getMaxWork() {
		return _maxWork;
	}

	public void setMaxWork(double maxWork) {
		_maxWork = maxWork;
	}

	public int getRole() {
		return _role;
	}

	public void setRole(int role) {
		_role = role;
	}

	private long _supportWorkerId;
	private long _companyId;
	private long _userId;
	private long _supportTeamId;
	private long _supportLaborId;
	private double _assignedWork;
	private double _maxWork;
	private int _role;

}