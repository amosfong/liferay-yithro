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
import com.liferay.yithro.rules.model.RuleAction;
import com.liferay.yithro.rules.service.base.RuleActionLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.yithro.rules.model.RuleAction",
	service = AopService.class
)
public class RuleActionLocalServiceImpl extends RuleActionLocalServiceBaseImpl {

	public RuleAction addRuleAction(long ruleId, String actionClassName)
		throws PortalException {

		long ruleActionId = counterLocalService.increment();

		RuleAction ruleAction = ruleActionPersistence.create(ruleActionId);

		ruleAction.setRuleId(ruleId);
		ruleAction.setActionClassName(actionClassName);

		return ruleAction;
	}

	public List<RuleAction> getRuleActions(long ruleId) {
		return ruleActionPersistence.findByRuleId(ruleId);
	}

}