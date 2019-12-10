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
public class RuleActionDataSoap implements Serializable {

	public static RuleActionDataSoap toSoapModel(RuleActionData model) {
		RuleActionDataSoap soapModel = new RuleActionDataSoap();

		soapModel.setRuleActionDataId(model.getRuleActionDataId());
		soapModel.setRuleActionId(model.getRuleActionId());
		soapModel.setField(model.getField());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static RuleActionDataSoap[] toSoapModels(RuleActionData[] models) {
		RuleActionDataSoap[] soapModels = new RuleActionDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RuleActionDataSoap[][] toSoapModels(
		RuleActionData[][] models) {

		RuleActionDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new RuleActionDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RuleActionDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RuleActionDataSoap[] toSoapModels(
		List<RuleActionData> models) {

		List<RuleActionDataSoap> soapModels = new ArrayList<RuleActionDataSoap>(
			models.size());

		for (RuleActionData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RuleActionDataSoap[soapModels.size()]);
	}

	public RuleActionDataSoap() {
	}

	public long getPrimaryKey() {
		return _ruleActionDataId;
	}

	public void setPrimaryKey(long pk) {
		setRuleActionDataId(pk);
	}

	public long getRuleActionDataId() {
		return _ruleActionDataId;
	}

	public void setRuleActionDataId(long ruleActionDataId) {
		_ruleActionDataId = ruleActionDataId;
	}

	public long getRuleActionId() {
		return _ruleActionId;
	}

	public void setRuleActionId(long ruleActionId) {
		_ruleActionId = ruleActionId;
	}

	public String getField() {
		return _field;
	}

	public void setField(String field) {
		_field = field;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private long _ruleActionDataId;
	private long _ruleActionId;
	private String _field;
	private String _value;

}