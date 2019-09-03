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

package com.liferay.yithro.rules.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ActionSoap implements Serializable {

	public static ActionSoap toSoapModel(Action model) {
		ActionSoap soapModel = new ActionSoap();

		soapModel.setActionId(model.getActionId());
		soapModel.setRuleId(model.getRuleId());
		soapModel.setEntity(model.getEntity());
		soapModel.setName(model.getName());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static ActionSoap[] toSoapModels(Action[] models) {
		ActionSoap[] soapModels = new ActionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActionSoap[][] toSoapModels(Action[][] models) {
		ActionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActionSoap[] toSoapModels(List<Action> models) {
		List<ActionSoap> soapModels = new ArrayList<ActionSoap>(models.size());

		for (Action model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActionSoap[soapModels.size()]);
	}

	public ActionSoap() {
	}

	public long getPrimaryKey() {
		return _actionId;
	}

	public void setPrimaryKey(long pk) {
		setActionId(pk);
	}

	public long getActionId() {
		return _actionId;
	}

	public void setActionId(long actionId) {
		_actionId = actionId;
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
	}

	public String getEntity() {
		return _entity;
	}

	public void setEntity(String entity) {
		_entity = entity;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _actionId;
	private long _ruleId;
	private String _entity;
	private String _name;
	private String _value;

}