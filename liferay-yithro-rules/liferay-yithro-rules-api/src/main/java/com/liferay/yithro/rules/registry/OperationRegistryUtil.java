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

package com.liferay.yithro.rules.registry;

import com.liferay.osgi.util.ServiceTrackerFactory;
import com.liferay.yithro.rules.model.Operation;

import java.util.Map;

import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Kyle Bischof
 */
public class OperationRegistryUtil {

	public static Operation getOperation(String symbol) {
		OperationRegistry operationRegistry = _serviceTracker.getService();

		return operationRegistry.getOperation(symbol);
	}

	public static Map<String, Operation> getOperationsMap() {
		OperationRegistry operationRegistry = _serviceTracker.getService();

		return operationRegistry.getOperationsMap();
	}

	private static final ServiceTracker<?, OperationRegistry> _serviceTracker =
		ServiceTrackerFactory.open(OperationRegistry.class);

}