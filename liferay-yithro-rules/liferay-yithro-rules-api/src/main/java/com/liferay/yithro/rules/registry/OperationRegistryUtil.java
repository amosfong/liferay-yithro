/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
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