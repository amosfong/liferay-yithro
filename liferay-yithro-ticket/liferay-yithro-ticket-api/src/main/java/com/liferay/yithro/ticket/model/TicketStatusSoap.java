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
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketStatusServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketStatusSoap implements Serializable {

	public static TicketStatusSoap toSoapModel(TicketStatus model) {
		TicketStatusSoap soapModel = new TicketStatusSoap();

		soapModel.setTicketStatusId(model.getTicketStatusId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setOrder(model.getOrder());
		soapModel.setTerminal(model.isTerminal());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static TicketStatusSoap[] toSoapModels(TicketStatus[] models) {
		TicketStatusSoap[] soapModels = new TicketStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketStatusSoap[][] toSoapModels(TicketStatus[][] models) {
		TicketStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TicketStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketStatusSoap[] toSoapModels(List<TicketStatus> models) {
		List<TicketStatusSoap> soapModels = new ArrayList<TicketStatusSoap>(
			models.size());

		for (TicketStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketStatusSoap[soapModels.size()]);
	}

	public TicketStatusSoap() {
	}

	public long getPrimaryKey() {
		return _ticketStatusId;
	}

	public void setPrimaryKey(long pk) {
		setTicketStatusId(pk);
	}

	public long getTicketStatusId() {
		return _ticketStatusId;
	}

	public void setTicketStatusId(long ticketStatusId) {
		_ticketStatusId = ticketStatusId;
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

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public boolean getTerminal() {
		return _terminal;
	}

	public boolean isTerminal() {
		return _terminal;
	}

	public void setTerminal(boolean terminal) {
		_terminal = terminal;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _ticketStatusId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private int _order;
	private boolean _terminal;
	private int _status;

}