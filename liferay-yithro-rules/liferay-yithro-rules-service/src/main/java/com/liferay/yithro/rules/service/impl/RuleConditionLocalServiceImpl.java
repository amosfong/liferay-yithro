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

package com.liferay.yithro.rules.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.yithro.rules.model.RuleCondition;
import com.liferay.yithro.rules.service.base.RuleConditionLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.yithro.rules.model.RuleCondition",
	service = AopService.class
)
public class RuleConditionLocalServiceImpl
	extends RuleConditionLocalServiceBaseImpl {

	public RuleCondition addRuleCondition(
			long ruleId, String type, String field, String operation,
			String value)
		throws PortalException {

		long ruleConditionId = counterLocalService.increment();

		RuleCondition ruleCondition = ruleConditionPersistence.create(
			ruleConditionId);

		ruleCondition.setRuleId(ruleId);
		ruleCondition.setType(type);
		ruleCondition.setField(field);
		ruleCondition.setOperation(operation);
		ruleCondition.setValue(value);

		return ruleConditionPersistence.update(ruleCondition);
	}

	public List<RuleCondition> findByR_T(long ruleId, String type) {
		return ruleConditionPersistence.findByR_T(ruleId, type);
	}

}