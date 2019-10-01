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

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketFieldOptionServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketFieldOptionSoap implements Serializable {

	public static TicketFieldOptionSoap toSoapModel(TicketFieldOption model) {
		TicketFieldOptionSoap soapModel = new TicketFieldOptionSoap();

		soapModel.setTicketFieldOptionId(model.getTicketFieldOptionId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTicketFieldId(model.getTicketFieldId());
		soapModel.setName(model.getName());
		soapModel.setVisibility(model.getVisibility());
		soapModel.setOrder(model.getOrder());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static TicketFieldOptionSoap[] toSoapModels(
		TicketFieldOption[] models) {

		TicketFieldOptionSoap[] soapModels =
			new TicketFieldOptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketFieldOptionSoap[][] toSoapModels(
		TicketFieldOption[][] models) {

		TicketFieldOptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TicketFieldOptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketFieldOptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketFieldOptionSoap[] toSoapModels(
		List<TicketFieldOption> models) {

		List<TicketFieldOptionSoap> soapModels =
			new ArrayList<TicketFieldOptionSoap>(models.size());

		for (TicketFieldOption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketFieldOptionSoap[soapModels.size()]);
	}

	public TicketFieldOptionSoap() {
	}

	public long getPrimaryKey() {
		return _ticketFieldOptionId;
	}

	public void setPrimaryKey(long pk) {
		setTicketFieldOptionId(pk);
	}

	public long getTicketFieldOptionId() {
		return _ticketFieldOptionId;
	}

	public void setTicketFieldOptionId(long ticketFieldOptionId) {
		_ticketFieldOptionId = ticketFieldOptionId;
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

	public long getTicketFieldId() {
		return _ticketFieldId;
	}

	public void setTicketFieldId(long ticketFieldId) {
		_ticketFieldId = ticketFieldId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getVisibility() {
		return _visibility;
	}

	public void setVisibility(int visibility) {
		_visibility = visibility;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _ticketFieldOptionId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ticketFieldId;
	private String _name;
	private int _visibility;
	private int _order;
	private int _status;

}