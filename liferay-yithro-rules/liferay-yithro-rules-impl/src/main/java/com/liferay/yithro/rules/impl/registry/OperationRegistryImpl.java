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

package com.liferay.yithro.rules.impl.registry;

import com.liferay.yithro.rules.model.Operation;
import com.liferay.yithro.rules.registry.OperationRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Kyle Bischof
 */
public class OperationRegistryImpl implements OperationRegistry {

	public Operation getOperation(String symbol) {
		return _operationsMap.get(symbol);
	}

	public Map<String, Operation> getOperationsMap() {
		return _operationsMap;
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	protected void registerOperation(
			Operation operation, Map<String, Object> properties)
		throws Exception {

		_operationsMap.put(operation.getSymbol(), operation);
	}

	protected void unregisterOperation(
		Operation operation, Map<String, Object> properties) {

		_operationsMap.remove(operation.getSymbol());
	}

	private final Map<String, Operation> _operationsMap =
		new ConcurrentHashMap<>();

}