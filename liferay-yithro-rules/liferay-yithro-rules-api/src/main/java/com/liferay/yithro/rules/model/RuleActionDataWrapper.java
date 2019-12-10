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
 * This class is a wrapper for {@link RuleActionData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionData
 * @generated
 */
public class RuleActionDataWrapper
	extends BaseModelWrapper<RuleActionData>
	implements ModelWrapper<RuleActionData>, RuleActionData {

	public RuleActionDataWrapper(RuleActionData ruleActionData) {
		super(ruleActionData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ruleActionDataId", getRuleActionDataId());
		attributes.put("ruleActionId", getRuleActionId());
		attributes.put("field", getField());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ruleActionDataId = (Long)attributes.get("ruleActionDataId");

		if (ruleActionDataId != null) {
			setRuleActionDataId(ruleActionDataId);
		}

		Long ruleActionId = (Long)attributes.get("ruleActionId");

		if (ruleActionId != null) {
			setRuleActionId(ruleActionId);
		}

		String field = (String)attributes.get("field");

		if (field != null) {
			setField(field);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	 * Returns the field of this rule action data.
	 *
	 * @return the field of this rule action data
	 */
	@Override
	public String getField() {
		return model.getField();
	}

	/**
	 * Returns the primary key of this rule action data.
	 *
	 * @return the primary key of this rule action data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rule action data ID of this rule action data.
	 *
	 * @return the rule action data ID of this rule action data
	 */
	@Override
	public long getRuleActionDataId() {
		return model.getRuleActionDataId();
	}

	/**
	 * Returns the rule action ID of this rule action data.
	 *
	 * @return the rule action ID of this rule action data
	 */
	@Override
	public long getRuleActionId() {
		return model.getRuleActionId();
	}

	/**
	 * Returns the value of this rule action data.
	 *
	 * @return the value of this rule action data
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rule action data model instance should use the <code>RuleActionData</code> interface instead.
	 */
	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the field of this rule action data.
	 *
	 * @param field the field of this rule action data
	 */
	@Override
	public void setField(String field) {
		model.setField(field);
	}

	/**
	 * Sets the primary key of this rule action data.
	 *
	 * @param primaryKey the primary key of this rule action data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rule action data ID of this rule action data.
	 *
	 * @param ruleActionDataId the rule action data ID of this rule action data
	 */
	@Override
	public void setRuleActionDataId(long ruleActionDataId) {
		model.setRuleActionDataId(ruleActionDataId);
	}

	/**
	 * Sets the rule action ID of this rule action data.
	 *
	 * @param ruleActionId the rule action ID of this rule action data
	 */
	@Override
	public void setRuleActionId(long ruleActionId) {
		model.setRuleActionId(ruleActionId);
	}

	/**
	 * Sets the value of this rule action data.
	 *
	 * @param value the value of this rule action data
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected RuleActionDataWrapper wrap(RuleActionData ruleActionData) {
		return new RuleActionDataWrapper(ruleActionData);
	}

}