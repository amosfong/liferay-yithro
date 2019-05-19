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
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketCommunicationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketCommunicationSoap implements Serializable {

	public static TicketCommunicationSoap toSoapModel(
		TicketCommunication model) {

		TicketCommunicationSoap soapModel = new TicketCommunicationSoap();

		soapModel.setTicketCommunicationId(model.getTicketCommunicationId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTicketEntryId(model.getTicketEntryId());
		soapModel.setClassNameId(model.getClassNameId());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setContent(model.getContent());
		soapModel.setProperties(model.getProperties());

		return soapModel;
	}

	public static TicketCommunicationSoap[] toSoapModels(
		TicketCommunication[] models) {

		TicketCommunicationSoap[] soapModels =
			new TicketCommunicationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketCommunicationSoap[][] toSoapModels(
		TicketCommunication[][] models) {

		TicketCommunicationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TicketCommunicationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketCommunicationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketCommunicationSoap[] toSoapModels(
		List<TicketCommunication> models) {

		List<TicketCommunicationSoap> soapModels =
			new ArrayList<TicketCommunicationSoap>(models.size());

		for (TicketCommunication model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TicketCommunicationSoap[soapModels.size()]);
	}

	public TicketCommunicationSoap() {
	}

	public long getPrimaryKey() {
		return _ticketCommunicationId;
	}

	public void setPrimaryKey(long pk) {
		setTicketCommunicationId(pk);
	}

	public long getTicketCommunicationId() {
		return _ticketCommunicationId;
	}

	public void setTicketCommunicationId(long ticketCommunicationId) {
		_ticketCommunicationId = ticketCommunicationId;
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

	public long getTicketEntryId() {
		return _ticketEntryId;
	}

	public void setTicketEntryId(long ticketEntryId) {
		_ticketEntryId = ticketEntryId;
	}

	public long getClassNameId() {
		return _classNameId;
	}

	public void setClassNameId(long classNameId) {
		_classNameId = classNameId;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public String getProperties() {
		return _properties;
	}

	public void setProperties(String properties) {
		_properties = properties;
	}

	private long _ticketCommunicationId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _ticketEntryId;
	private long _classNameId;
	private long _classPK;
	private String _content;
	private String _properties;

}