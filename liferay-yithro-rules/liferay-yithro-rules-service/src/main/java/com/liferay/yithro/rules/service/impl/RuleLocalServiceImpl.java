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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.rules.exception.RuleObjectNameException;
import com.liferay.yithro.rules.model.Rule;
import com.liferay.yithro.rules.service.base.RuleLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.yithro.rules.model.Rule",
	service = AopService.class
)
public class RuleLocalServiceImpl extends RuleLocalServiceBaseImpl {

	public Rule addRule(String name, String objectName, String objectEvent)
		throws PortalException {

		validate(objectName);

		long ruleId = counterLocalService.increment();

		Rule rule = rulePersistence.create(ruleId);

		rule.setName(name);
		rule.setObjectName(objectName);
		rule.setObjectEvent(objectEvent);

		return rulePersistence.update(rule);
	}

	public List<Rule> getRules(String objectName, String objectEvent) {
		return rulePersistence.findByON_OE(objectName, objectEvent);
	}

	protected void validate(String objectName) throws RuleObjectNameException {
		if (Validator.isNull(objectName)) {
			throw new RuleObjectNameException();
		}
	}

}