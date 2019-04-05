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
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketEntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketEntrySoap implements Serializable {

	public static TicketEntrySoap toSoapModel(TicketEntry model) {
		TicketEntrySoap soapModel = new TicketEntrySoap();

		soapModel.setTicketEntryId(model.getTicketEntryId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setTicketNumber(model.getTicketNumber());
		soapModel.setSubject(model.getSubject());
		soapModel.setDescription(model.getDescription());
		soapModel.setSeverity(model.getSeverity());
		soapModel.setStatus(model.getStatus());
		soapModel.setWeight(model.getWeight());
		soapModel.setEscalationLevel(model.getEscalationLevel());
		soapModel.setResolution(model.getResolution());
		soapModel.setHoldDate(model.getHoldDate());
		soapModel.setClosedDate(model.getClosedDate());
		soapModel.setDueDate(model.getDueDate());

		return soapModel;
	}

	public static TicketEntrySoap[] toSoapModels(TicketEntry[] models) {
		TicketEntrySoap[] soapModels = new TicketEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketEntrySoap[][] toSoapModels(TicketEntry[][] models) {
		TicketEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TicketEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketEntrySoap[] toSoapModels(List<TicketEntry> models) {
		List<TicketEntrySoap> soapModels = new ArrayList<TicketEntrySoap>(
			models.size());

		for (TicketEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TicketEntrySoap[soapModels.size()]);
	}

	public TicketEntrySoap() {
	}

	public long getPrimaryKey() {
		return _ticketEntryId;
	}

	public void setPrimaryKey(long pk) {
		setTicketEntryId(pk);
	}

	public long getTicketEntryId() {
		return _ticketEntryId;
	}

	public void setTicketEntryId(long ticketEntryId) {
		_ticketEntryId = ticketEntryId;
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

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public long getTicketNumber() {
		return _ticketNumber;
	}

	public void setTicketNumber(long ticketNumber) {
		_ticketNumber = ticketNumber;
	}

	public String getSubject() {
		return _subject;
	}

	public void setSubject(String subject) {
		_subject = subject;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public int getSeverity() {
		return _severity;
	}

	public void setSeverity(int severity) {
		_severity = severity;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public int getWeight() {
		return _weight;
	}

	public void setWeight(int weight) {
		_weight = weight;
	}

	public int getEscalationLevel() {
		return _escalationLevel;
	}

	public void setEscalationLevel(int escalationLevel) {
		_escalationLevel = escalationLevel;
	}

	public int getResolution() {
		return _resolution;
	}

	public void setResolution(int resolution) {
		_resolution = resolution;
	}

	public Date getHoldDate() {
		return _holdDate;
	}

	public void setHoldDate(Date holdDate) {
		_holdDate = holdDate;
	}

	public Date getClosedDate() {
		return _closedDate;
	}

	public void setClosedDate(Date closedDate) {
		_closedDate = closedDate;
	}

	public Date getDueDate() {
		return _dueDate;
	}

	public void setDueDate(Date dueDate) {
		_dueDate = dueDate;
	}

	private long _ticketEntryId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _languageId;
	private long _ticketNumber;
	private String _subject;
	private String _description;
	private int _severity;
	private int _status;
	private int _weight;
	private int _escalationLevel;
	private int _resolution;
	private Date _holdDate;
	private Date _closedDate;
	private Date _dueDate;

}