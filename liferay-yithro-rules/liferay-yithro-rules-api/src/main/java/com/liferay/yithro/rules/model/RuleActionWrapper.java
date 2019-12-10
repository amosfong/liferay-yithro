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
 * This class is a wrapper for {@link RuleAction}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleAction
 * @generated
 */
public class RuleActionWrapper
	extends BaseModelWrapper<RuleAction>
	implements ModelWrapper<RuleAction>, RuleAction {

	public RuleActionWrapper(RuleAction ruleAction) {
		super(ruleAction);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ruleActionId", getRuleActionId());
		attributes.put("ruleId", getRuleId());
		attributes.put("actionClassName", getActionClassName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ruleActionId = (Long)attributes.get("ruleActionId");

		if (ruleActionId != null) {
			setRuleActionId(ruleActionId);
		}

		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		String actionClassName = (String)attributes.get("actionClassName");

		if (actionClassName != null) {
			setActionClassName(actionClassName);
		}
	}

	/**
	 * Returns the action class name of this rule action.
	 *
	 * @return the action class name of this rule action
	 */
	@Override
	public String getActionClassName() {
		return model.getActionClassName();
	}

	/**
	 * Returns the primary key of this rule action.
	 *
	 * @return the primary key of this rule action
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rule action ID of this rule action.
	 *
	 * @return the rule action ID of this rule action
	 */
	@Override
	public long getRuleActionId() {
		return model.getRuleActionId();
	}

	/**
	 * Returns the rule ID of this rule action.
	 *
	 * @return the rule ID of this rule action
	 */
	@Override
	public long getRuleId() {
		return model.getRuleId();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rule action model instance should use the <code>RuleAction</code> interface instead.
	 */
	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the action class name of this rule action.
	 *
	 * @param actionClassName the action class name of this rule action
	 */
	@Override
	public void setActionClassName(String actionClassName) {
		model.setActionClassName(actionClassName);
	}

	/**
	 * Sets the primary key of this rule action.
	 *
	 * @param primaryKey the primary key of this rule action
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rule action ID of this rule action.
	 *
	 * @param ruleActionId the rule action ID of this rule action
	 */
	@Override
	public void setRuleActionId(long ruleActionId) {
		model.setRuleActionId(ruleActionId);
	}

	/**
	 * Sets the rule ID of this rule action.
	 *
	 * @param ruleId the rule ID of this rule action
	 */
	@Override
	public void setRuleId(long ruleId) {
		model.setRuleId(ruleId);
	}

	@Override
	protected RuleActionWrapper wrap(RuleAction ruleAction) {
		return new RuleActionWrapper(ruleAction);
	}

}