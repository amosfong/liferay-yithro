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

import com.liferay.yithro.rules.model.Operation;
import com.liferay.yithro.rules.registry.OperationRegistry;

import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@ProviderType
public class ExpressionImpl extends ExpressionBaseImpl {

	public ExpressionImpl() {
	}

	public boolean evaluate(Map<String, ?> map) {
		Operation operation = _operationRegistry.getOperation(getOperation());

		if (operation != null) {
			Object objectValue = map.get(getField());

			if (operation.interpret(getValue(), objectValue)) {
				return true;
			}
		}

		return false;
	}

	@Reference
	private OperationRegistry _operationRegistry;

}