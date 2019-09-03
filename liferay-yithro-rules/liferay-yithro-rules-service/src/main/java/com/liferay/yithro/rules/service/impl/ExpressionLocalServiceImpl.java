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
import com.liferay.yithro.rules.model.Expression;
import com.liferay.yithro.rules.service.base.ExpressionLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(
	property = "model.class.name=com.liferay.yithro.rules.model.Expression",
	service = AopService.class
)
public class ExpressionLocalServiceImpl extends ExpressionLocalServiceBaseImpl {

	public Expression addExpression(
			long ruleId, String type, String field, String operation,
			String value)
		throws PortalException {

		long expressionId = counterLocalService.increment();

		Expression expression = expressionPersistence.create(expressionId);

		expression.setRuleId(ruleId);
		expression.setType(type);
		expression.setField(field);
		expression.setOperation(operation);
		expression.setValue(value);

		return expressionPersistence.update(expression);
	}

	public List<Expression> findByR_T(long ruleId, String type) {
		return expressionPersistence.findByR_T(ruleId, type);
	}

}