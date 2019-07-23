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
public class RuleSoap implements Serializable {

	public static RuleSoap toSoapModel(Rule model) {
		RuleSoap soapModel = new RuleSoap();

		soapModel.setRuleId(model.getRuleId());
		soapModel.setName(model.getName());
		soapModel.setTriggerAction(model.getTriggerAction());
		soapModel.setTriggerObject(model.getTriggerObject());

		return soapModel;
	}

	public static RuleSoap[] toSoapModels(Rule[] models) {
		RuleSoap[] soapModels = new RuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RuleSoap[][] toSoapModels(Rule[][] models) {
		RuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RuleSoap[] toSoapModels(List<Rule> models) {
		List<RuleSoap> soapModels = new ArrayList<RuleSoap>(models.size());

		for (Rule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RuleSoap[soapModels.size()]);
	}

	public RuleSoap() {
	}

	public long getPrimaryKey() {
		return _ruleId;
	}

	public void setPrimaryKey(long pk) {
		setRuleId(pk);
	}

	public long getRuleId() {
		return _ruleId;
	}

	public void setRuleId(long ruleId) {
		_ruleId = ruleId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTriggerAction() {
		return _triggerAction;
	}

	public void setTriggerAction(String triggerAction) {
		_triggerAction = triggerAction;
	}

	public String getTriggerObject() {
		return _triggerObject;
	}

	public void setTriggerObject(String triggerObject) {
		_triggerObject = triggerObject;
	}

	private long _ruleId;
	private String _name;
	private String _triggerAction;
	private String _triggerObject;

}