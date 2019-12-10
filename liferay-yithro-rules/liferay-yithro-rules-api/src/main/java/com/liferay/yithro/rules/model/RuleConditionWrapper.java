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

/**
 * <p>
 * This class is a wrapper for {@link RuleCondition}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleCondition
 * @generated
 */
public class RuleConditionWrapper
	extends BaseModelWrapper<RuleCondition>
	implements ModelWrapper<RuleCondition>, RuleCondition {

	public RuleConditionWrapper(RuleCondition ruleCondition) {
		super(ruleCondition);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ruleConditionId", getRuleConditionId());
		attributes.put("ruleId", getRuleId());
		attributes.put("type", getType());
		attributes.put("field", getField());
		attributes.put("operation", getOperation());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ruleConditionId = (Long)attributes.get("ruleConditionId");

		if (ruleConditionId != null) {
			setRuleConditionId(ruleConditionId);
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

	/**
	 * Returns the field of this rule condition.
	 *
	 * @return the field of this rule condition
	 */
	@Override
	public String getField() {
		return model.getField();
	}

	/**
	 * Returns the operation of this rule condition.
	 *
	 * @return the operation of this rule condition
	 */
	@Override
	public String getOperation() {
		return model.getOperation();
	}

	/**
	 * Returns the primary key of this rule condition.
	 *
	 * @return the primary key of this rule condition
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rule condition ID of this rule condition.
	 *
	 * @return the rule condition ID of this rule condition
	 */
	@Override
	public long getRuleConditionId() {
		return model.getRuleConditionId();
	}

	/**
	 * Returns the rule ID of this rule condition.
	 *
	 * @return the rule ID of this rule condition
	 */
	@Override
	public long getRuleId() {
		return model.getRuleId();
	}

	/**
	 * Returns the type of this rule condition.
	 *
	 * @return the type of this rule condition
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the value of this rule condition.
	 *
	 * @return the value of this rule condition
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rule condition model instance should use the <code>RuleCondition</code> interface instead.
	 */
	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the field of this rule condition.
	 *
	 * @param field the field of this rule condition
	 */
	@Override
	public void setField(String field) {
		model.setField(field);
	}

	/**
	 * Sets the operation of this rule condition.
	 *
	 * @param operation the operation of this rule condition
	 */
	@Override
	public void setOperation(String operation) {
		model.setOperation(operation);
	}

	/**
	 * Sets the primary key of this rule condition.
	 *
	 * @param primaryKey the primary key of this rule condition
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rule condition ID of this rule condition.
	 *
	 * @param ruleConditionId the rule condition ID of this rule condition
	 */
	@Override
	public void setRuleConditionId(long ruleConditionId) {
		model.setRuleConditionId(ruleConditionId);
	}

	/**
	 * Sets the rule ID of this rule condition.
	 *
	 * @param ruleId the rule ID of this rule condition
	 */
	@Override
	public void setRuleId(long ruleId) {
		model.setRuleId(ruleId);
	}

	/**
	 * Sets the type of this rule condition.
	 *
	 * @param type the type of this rule condition
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the value of this rule condition.
	 *
	 * @param value the value of this rule condition
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected RuleConditionWrapper wrap(RuleCondition ruleCondition) {
		return new RuleConditionWrapper(ruleCondition);
	}

}