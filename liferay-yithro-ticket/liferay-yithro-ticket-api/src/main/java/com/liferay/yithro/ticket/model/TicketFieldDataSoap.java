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
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketFieldDataServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketFieldDataSoap implements Serializable {

	public static TicketFieldDataSoap toSoapModel(TicketFieldData model) {
		TicketFieldDataSoap soapModel = new TicketFieldDataSoap();

		soapModel.setTicketFieldDataId(model.getTicketFieldDataId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTicketEntryId(model.getTicketEntryId());
		soapModel.setTicketFieldId(model.getTicketFieldId());
		soapModel.setData(model.getData());

		return soapModel;
	}

	public static TicketFieldDataSoap[] toSoapModels(TicketFieldData[] models) {
		TicketFieldDataSoap[] soapModels =
			new TicketFieldDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketFieldDataSoap[][] toSoapModels(
		TicketFieldData[][] models) {

		TicketFieldDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TicketFieldDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketFieldDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketFieldDataSoap[] toSoapModels(
		List<TicketFieldData> models) {

		List<TicketFieldDataSoap> soapModels =
			new ArrayList<TicketFieldDataSoap>(models.size());

		for (TicketFieldData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketFieldDataSoap[soapModels.size()]);
	}

	public TicketFieldDataSoap() {
	}

	public long getPrimaryKey() {
		return _ticketFieldDataId;
	}

	public void setPrimaryKey(long pk) {
		setTicketFieldDataId(pk);
	}

	public long getTicketFieldDataId() {
		return _ticketFieldDataId;
	}

	public void setTicketFieldDataId(long ticketFieldDataId) {
		_ticketFieldDataId = ticketFieldDataId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getTicketEntryId() {
		return _ticketEntryId;
	}

	public void setTicketEntryId(long ticketEntryId) {
		_ticketEntryId = ticketEntryId;
	}

	public long getTicketFieldId() {
		return _ticketFieldId;
	}

	public void setTicketFieldId(long ticketFieldId) {
		_ticketFieldId = ticketFieldId;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	private long _ticketFieldDataId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ticketEntryId;
	private long _ticketFieldId;
	private String _data;

}