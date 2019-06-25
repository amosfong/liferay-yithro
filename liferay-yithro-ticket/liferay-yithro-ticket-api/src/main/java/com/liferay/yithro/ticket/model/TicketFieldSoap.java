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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketFieldServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketFieldSoap implements Serializable {

	public static TicketFieldSoap toSoapModel(TicketField model) {
		TicketFieldSoap soapModel = new TicketFieldSoap();

		soapModel.setTicketFieldId(model.getTicketFieldId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setType(model.getType());
		soapModel.setVisibility(model.getVisibility());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static TicketFieldSoap[] toSoapModels(TicketField[] models) {
		TicketFieldSoap[] soapModels = new TicketFieldSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketFieldSoap[][] toSoapModels(TicketField[][] models) {
		TicketFieldSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TicketFieldSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketFieldSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketFieldSoap[] toSoapModels(List<TicketField> models) {
		List<TicketFieldSoap> soapModels = new ArrayList<TicketFieldSoap>(
			models.size());

		for (TicketField model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketFieldSoap[soapModels.size()]);
	}

	public TicketFieldSoap() {
	}

	public long getPrimaryKey() {
		return _ticketFieldId;
	}

	public void setPrimaryKey(long pk) {
		setTicketFieldId(pk);
	}

	public long getTicketFieldId() {
		return _ticketFieldId;
	}

	public void setTicketFieldId(long ticketFieldId) {
		_ticketFieldId = ticketFieldId;
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

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getVisibility() {
		return _visibility;
	}

	public void setVisibility(int visibility) {
		_visibility = visibility;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _ticketFieldId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private int _type;
	private int _visibility;
	private int _status;

}