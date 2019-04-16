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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketFlagServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketFlagSoap implements Serializable {

	public static TicketFlagSoap toSoapModel(TicketFlag model) {
		TicketFlagSoap soapModel = new TicketFlagSoap();

		soapModel.setTicketFlagId(model.getTicketFlagId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTicketEntryId(model.getTicketEntryId());
		soapModel.setType(model.getType());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static TicketFlagSoap[] toSoapModels(TicketFlag[] models) {
		TicketFlagSoap[] soapModels = new TicketFlagSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketFlagSoap[][] toSoapModels(TicketFlag[][] models) {
		TicketFlagSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TicketFlagSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketFlagSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketFlagSoap[] toSoapModels(List<TicketFlag> models) {
		List<TicketFlagSoap> soapModels = new ArrayList<TicketFlagSoap>(
			models.size());

		for (TicketFlag model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketFlagSoap[soapModels.size()]);
	}

	public TicketFlagSoap() {
	}

	public long getPrimaryKey() {
		return _ticketFlagId;
	}

	public void setPrimaryKey(long pk) {
		setTicketFlagId(pk);
	}

	public long getTicketFlagId() {
		return _ticketFlagId;
	}

	public void setTicketFlagId(long ticketFlagId) {
		_ticketFlagId = ticketFlagId;
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

	public int getType() {
		return _type;
	}

	public void setType(int type) {
		_type = type;
	}

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	private long _ticketFlagId;
	private long _companyId;
	private long _userId;
	private Date _modifiedDate;
	private long _ticketEntryId;
	private int _type;
	private int _value;

}