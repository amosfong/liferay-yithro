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
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketStructureServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketStructureSoap implements Serializable {

	public static TicketStructureSoap toSoapModel(TicketStructure model) {
		TicketStructureSoap soapModel = new TicketStructureSoap();

		soapModel.setTicketStructureId(model.getTicketStructureId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setDescription(model.getDescription());
		soapModel.setStructure(model.getStructure());

		return soapModel;
	}

	public static TicketStructureSoap[] toSoapModels(TicketStructure[] models) {
		TicketStructureSoap[] soapModels =
			new TicketStructureSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketStructureSoap[][] toSoapModels(
		TicketStructure[][] models) {

		TicketStructureSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TicketStructureSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketStructureSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketStructureSoap[] toSoapModels(
		List<TicketStructure> models) {

		List<TicketStructureSoap> soapModels =
			new ArrayList<TicketStructureSoap>(models.size());

		for (TicketStructure model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketStructureSoap[soapModels.size()]);
	}

	public TicketStructureSoap() {
	}

	public long getPrimaryKey() {
		return _ticketStructureId;
	}

	public void setPrimaryKey(long pk) {
		setTicketStructureId(pk);
	}

	public long getTicketStructureId() {
		return _ticketStructureId;
	}

	public void setTicketStructureId(long ticketStructureId) {
		_ticketStructureId = ticketStructureId;
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

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
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

	public String getStructure() {
		return _structure;
	}

	public void setStructure(String structure) {
		_structure = structure;
	}

	private long _ticketStructureId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _description;
	private String _structure;

}