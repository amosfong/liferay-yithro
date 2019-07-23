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
 * This class is a wrapper for {@link Action}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Action
 * @generated
 */
@ProviderType
public class ActionWrapper
	extends BaseModelWrapper<Action> implements Action, ModelWrapper<Action> {

	public ActionWrapper(Action action) {
		super(action);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("actionId", getActionId());
		attributes.put("ruleId", getRuleId());
		attributes.put("name", getName());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long actionId = (Long)attributes.get("actionId");

		if (actionId != null) {
			setActionId(actionId);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	 * Returns the action ID of this action.
	 *
	 * @return the action ID of this action
	 */
	@Override
	public long getActionId() {
		return model.getActionId();
	}

	/**
	 * Returns the name of this action.
	 *
	 * @return the name of this action
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this action.
	 *
	 * @return the primary key of this action
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rule ID of this action.
	 *
	 * @return the rule ID of this action
	 */
	@Override
	public long getRuleId() {
		return model.getRuleId();
	}

	/**
	 * Returns the value of this action.
	 *
	 * @return the value of this action
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
	 * Sets the action ID of this action.
	 *
	 * @param actionId the action ID of this action
	 */
	@Override
	public void setActionId(long actionId) {
		model.setActionId(actionId);
	}

	/**
	 * Sets the name of this action.
	 *
	 * @param name the name of this action
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this action.
	 *
	 * @param primaryKey the primary key of this action
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rule ID of this action.
	 *
	 * @param ruleId the rule ID of this action
	 */
	@Override
	public void setRuleId(long ruleId) {
		model.setRuleId(ruleId);
	}

	/**
	 * Sets the value of this action.
	 *
	 * @param value the value of this action
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	protected ActionWrapper wrap(Action action) {
		return new ActionWrapper(action);
	}

}