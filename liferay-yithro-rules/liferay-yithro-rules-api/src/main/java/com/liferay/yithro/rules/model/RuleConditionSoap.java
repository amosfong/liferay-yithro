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

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RuleConditionSoap implements Serializable {

	public static RuleConditionSoap toSoapModel(RuleCondition model) {
		RuleConditionSoap soapModel = new RuleConditionSoap();

		soapModel.setRuleConditionId(model.getRuleConditionId());
		soapModel.setRuleId(model.getRuleId());
		soapModel.setType(model.getType());
		soapModel.setField(model.getField());
		soapModel.setOperation(model.getOperation());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static RuleConditionSoap[] toSoapModels(RuleCondition[] models) {
		RuleConditionSoap[] soapModels = new RuleConditionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RuleConditionSoap[][] toSoapModels(RuleCondition[][] models) {
		RuleConditionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RuleConditionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RuleConditionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RuleConditionSoap[] toSoapModels(List<RuleCondition> models) {
		List<RuleConditionSoap> soapModels = new ArrayList<RuleConditionSoap>(
			models.size());

		for (RuleCondition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RuleConditionSoap[soapModels.size()]);
	}

	public RuleConditionSoap() {
	}

	public long getPrimaryKey() {
		return _ruleConditionId;
	}

	public void setPrimaryKey(long pk) {
		setRuleConditionId(pk);
	}

	public long getRuleConditionId() {
		return _ruleConditionId;
	}

	public void setRuleConditionId(long ruleConditionId) {
		_ruleConditionId = ruleConditionId;
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getField() {
		return _field;
	}

	public void setField(String field) {
		_field = field;
	}

	public String getOperation() {
		return _operation;
	}

	public void setOperation(String operation) {
		_operation = operation;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _ruleConditionId;
	private long _ruleId;
	private String _type;
	private String _field;
	private String _operation;
	private String _value;

}