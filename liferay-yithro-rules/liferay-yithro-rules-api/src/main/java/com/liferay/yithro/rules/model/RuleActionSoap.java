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
public class RuleActionSoap implements Serializable {

	public static RuleActionSoap toSoapModel(RuleAction model) {
		RuleActionSoap soapModel = new RuleActionSoap();

		soapModel.setRuleActionId(model.getRuleActionId());
		soapModel.setRuleId(model.getRuleId());
		soapModel.setActionClassName(model.getActionClassName());

		return soapModel;
	}

	public static RuleActionSoap[] toSoapModels(RuleAction[] models) {
		RuleActionSoap[] soapModels = new RuleActionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RuleActionSoap[][] toSoapModels(RuleAction[][] models) {
		RuleActionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RuleActionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RuleActionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RuleActionSoap[] toSoapModels(List<RuleAction> models) {
		List<RuleActionSoap> soapModels = new ArrayList<RuleActionSoap>(
			models.size());

		for (RuleAction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RuleActionSoap[soapModels.size()]);
	}

	public RuleActionSoap() {
	}

	public long getPrimaryKey() {
		return _ruleActionId;
	}

	public void setPrimaryKey(long pk) {
		setRuleActionId(pk);
	}

	public long getRuleActionId() {
		return _ruleActionId;
	}

	public void setRuleActionId(long ruleActionId) {
		_ruleActionId = ruleActionId;
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
	}

	public String getActionClassName() {
		return _actionClassName;
	}

	public void setActionClassName(String actionClassName) {
		_actionClassName = actionClassName;
	}

	private long _ruleActionId;
	private long _ruleId;
	private String _actionClassName;

}