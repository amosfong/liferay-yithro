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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link Expression}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Expression
 * @generated
 */
@ProviderType
public class ExpressionWrapper
	extends BaseModelWrapper<Expression>
	implements Expression, ModelWrapper<Expression> {

	public ExpressionWrapper(Expression expression) {
		super(expression);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("expressionId", getExpressionId());
		attributes.put("ruleId", getRuleId());
		attributes.put("type", getType());
		attributes.put("field", getField());
		attributes.put("operation", getOperation());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long expressionId = (Long)attributes.get("expressionId");

		if (expressionId != null) {
			setExpressionId(expressionId);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String field = (String)attributes.get("field");

		if (field != null) {
			setField(field);
		}

		String operation = (String)attributes.get("operation");

		if (operation != null) {
			setOperation(operation);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public boolean evaluate(Map<String, ?> map) {
		return model.evaluate(map);
	}

	/**
	 * Returns the expression ID of this expression.
	 *
	 * @return the expression ID of this expression
	 */
	@Override
	public long getExpressionId() {
		return model.getExpressionId();
	}

	/**
	 * Returns the field of this expression.
	 *
	 * @return the field of this expression
	 */
	@Override
	public String getField() {
		return model.getField();
	}

	/**
	 * Returns the operation of this expression.
	 *
	 * @return the operation of this expression
	 */
	@Override
	public String getOperation() {
		return model.getOperation();
	}

	/**
	 * Returns the primary key of this expression.
	 *
	 * @return the primary key of this expression
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rule ID of this expression.
	 *
	 * @return the rule ID of this expression
	 */
	@Override
	public long getRuleId() {
		return model.getRuleId();
	}

	/**
	 * Returns the type of this expression.
	 *
	 * @return the type of this expression
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the value of this expression.
	 *
	 * @return the value of this expression
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the expression ID of this expression.
	 *
	 * @param expressionId the expression ID of this expression
	 */
	@Override
	public void setExpressionId(long expressionId) {
		model.setExpressionId(expressionId);
	}

	/**
	 * Sets the field of this expression.
	 *
	 * @param field the field of this expression
	 */
	@Override
	public void setField(String field) {
		model.setField(field);
	}

	/**
	 * Sets the operation of this expression.
	 *
	 * @param operation the operation of this expression
	 */
	@Override
	public void setOperation(String operation) {
		model.setOperation(operation);
	}

	/**
	 * Sets the primary key of this expression.
	 *
	 * @param primaryKey the primary key of this expression
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rule ID of this expression.
	 *
	 * @param ruleId the rule ID of this expression
	 */
	@Override
	public void setRuleId(long ruleId) {
		model.setRuleId(ruleId);
	}

	/**
	 * Sets the type of this expression.
	 *
	 * @param type the type of this expression
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the value of this expression.
	 *
	 * @param value the value of this expression
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected ExpressionWrapper wrap(Expression expression) {
		return new ExpressionWrapper(expression);
	}

}