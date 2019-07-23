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
public class ExpressionSoap implements Serializable {

	public static ExpressionSoap toSoapModel(Expression model) {
		ExpressionSoap soapModel = new ExpressionSoap();

		soapModel.setExpressionId(model.getExpressionId());
		soapModel.setRuleId(model.getRuleId());
		soapModel.setType(model.getType());
		soapModel.setField(model.getField());
		soapModel.setOperation(model.getOperation());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static ExpressionSoap[] toSoapModels(Expression[] models) {
		ExpressionSoap[] soapModels = new ExpressionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExpressionSoap[][] toSoapModels(Expression[][] models) {
		ExpressionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExpressionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExpressionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExpressionSoap[] toSoapModels(List<Expression> models) {
		List<ExpressionSoap> soapModels = new ArrayList<ExpressionSoap>(
			models.size());

		for (Expression model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExpressionSoap[soapModels.size()]);
	}

	public ExpressionSoap() {
	}

	public long getPrimaryKey() {
		return _expressionId;
	}

	public void setPrimaryKey(long pk) {
		setExpressionId(pk);
	}

	public long getExpressionId() {
		return _expressionId;
	}

	public void setExpressionId(long expressionId) {
		_expressionId = expressionId;
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

	private long _expressionId;
	private long _ruleId;
	private String _type;
	private String _field;
	private String _operation;
	private String _value;

}