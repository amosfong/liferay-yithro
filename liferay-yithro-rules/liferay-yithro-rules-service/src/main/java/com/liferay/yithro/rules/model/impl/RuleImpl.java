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

package com.liferay.yithro.rules.model.impl;

import com.liferay.yithro.rules.model.Expression;
import com.liferay.yithro.rules.service.ExpressionLocalServiceUtil;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Kyle Bischof
 */
@ProviderType
public class RuleImpl extends RuleBaseImpl {

	public RuleImpl() {
	}

	public boolean evaluate(Map<String, ?> map) {
		List<Expression> andExpressions = ExpressionLocalServiceUtil.findByR_T(
			getRuleId(), "AND");

		for (Expression expression : andExpressions) {
			if (!expression.evaluate(map)) {
				return false;
			}
		}

		List<Expression> orExpressions = ExpressionLocalServiceUtil.findByR_T(
			getRuleId(), "OR");

		for (Expression expression : orExpressions) {
			if (expression.evaluate(map)) {
				return true;
			}
		}

		return false;
	}

}