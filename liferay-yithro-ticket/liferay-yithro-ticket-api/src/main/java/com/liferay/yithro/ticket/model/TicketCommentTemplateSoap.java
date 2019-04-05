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
 * This class is used by SOAP remote services, specifically {@link com.liferay.yithro.ticket.service.http.TicketCommentTemplateServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketCommentTemplateSoap implements Serializable {

	public static TicketCommentTemplateSoap toSoapModel(
		TicketCommentTemplate model) {

		TicketCommentTemplateSoap soapModel = new TicketCommentTemplateSoap();

		soapModel.setTicketCommentTemplateId(
			model.getTicketCommentTemplateId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setContent(model.getContent());
		soapModel.setUseCount(model.getUseCount());

		return soapModel;
	}

	public static TicketCommentTemplateSoap[] toSoapModels(
		TicketCommentTemplate[] models) {

		TicketCommentTemplateSoap[] soapModels =
			new TicketCommentTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TicketCommentTemplateSoap[][] toSoapModels(
		TicketCommentTemplate[][] models) {

		TicketCommentTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new TicketCommentTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TicketCommentTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TicketCommentTemplateSoap[] toSoapModels(
		List<TicketCommentTemplate> models) {

		List<TicketCommentTemplateSoap> soapModels =
			new ArrayList<TicketCommentTemplateSoap>(models.size());

		for (TicketCommentTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new TicketCommentTemplateSoap[soapModels.size()]);
	}

	public TicketCommentTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _ticketCommentTemplateId;
	}

	public void setPrimaryKey(long pk) {
		setTicketCommentTemplateId(pk);
	}

	public long getTicketCommentTemplateId() {
		return _ticketCommentTemplateId;
	}

	public void setTicketCommentTemplateId(long ticketCommentTemplateId) {
		_ticketCommentTemplateId = ticketCommentTemplateId;
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

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public int getUseCount() {
		return _useCount;
	}

	public void setUseCount(int useCount) {
		_useCount = useCount;
	}

	private long _ticketCommentTemplateId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _content;
	private int _useCount;

}