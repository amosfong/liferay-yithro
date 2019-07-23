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

package com.liferay.yithro.rules.impl.operation;

import com.liferay.petra.string.StringPool;
import com.liferay.yithro.rules.model.Operation;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = Operation.class)
public class Equals extends Operation {

	public Equals() {
		super(StringPool.EQUAL);
	}

	@Override
	public String getSymbol() {
		return StringPool.EQUAL;
	}

	@Override
	public boolean interpret(Object expressionValue, Object objectValue) {
		if (objectValue == null) {
			return false;
		}

		if (expressionValue.equals(objectValue)) {
			return true;
		}

		return false;
	}

}