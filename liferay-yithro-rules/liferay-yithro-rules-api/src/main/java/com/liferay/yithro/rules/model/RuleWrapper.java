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
 * This class is a wrapper for {@link Rule}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Rule
 * @generated
 */
public class RuleWrapper
	extends BaseModelWrapper<Rule> implements ModelWrapper<Rule>, Rule {

	public RuleWrapper(Rule rule) {
		super(rule);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ruleId", getRuleId());
		attributes.put("name", getName());
		attributes.put("objectName", getObjectName());
		attributes.put("objectEvent", getObjectEvent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ruleId = (Long)attributes.get("ruleId");

		if (ruleId != null) {
			setRuleId(ruleId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String objectName = (String)attributes.get("objectName");

		if (objectName != null) {
			setObjectName(objectName);
		}

		String objectEvent = (String)attributes.get("objectEvent");

		if (objectEvent != null) {
			setObjectEvent(objectEvent);
		}
	}

	/**
	 * Returns the name of this rule.
	 *
	 * @return the name of this rule
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the object event of this rule.
	 *
	 * @return the object event of this rule
	 */
	@Override
	public String getObjectEvent() {
		return model.getObjectEvent();
	}

	/**
	 * Returns the object name of this rule.
	 *
	 * @return the object name of this rule
	 */
	@Override
	public String getObjectName() {
		return model.getObjectName();
	}

	/**
	 * Returns the primary key of this rule.
	 *
	 * @return the primary key of this rule
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rule ID of this rule.
	 *
	 * @return the rule ID of this rule
	 */
	@Override
	public long getRuleId() {
		return model.getRuleId();
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a rule model instance should use the <code>Rule</code> interface instead.
	 */
	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the name of this rule.
	 *
	 * @param name the name of this rule
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the object event of this rule.
	 *
	 * @param objectEvent the object event of this rule
	 */
	@Override
	public void setObjectEvent(String objectEvent) {
		model.setObjectEvent(objectEvent);
	}

	/**
	 * Sets the object name of this rule.
	 *
	 * @param objectName the object name of this rule
	 */
	@Override
	public void setObjectName(String objectName) {
		model.setObjectName(objectName);
	}

	/**
	 * Sets the primary key of this rule.
	 *
	 * @param primaryKey the primary key of this rule
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rule ID of this rule.
	 *
	 * @param ruleId the rule ID of this rule
	 */
	@Override
	public void setRuleId(long ruleId) {
		model.setRuleId(ruleId);
	}

	@Override
	protected RuleWrapper wrap(Rule rule) {
		return new RuleWrapper(rule);
	}

}