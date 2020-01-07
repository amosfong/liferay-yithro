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

package com.liferay.yithro.rules.engine.registry;

import com.liferay.yithro.rules.engine.Event;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Amos Fong
 */
@Component(service = EventRegistry.class)
public class EventRegistryImpl implements EventRegistry {

	public Map<String, Set<String>> getObjectEvents() {
		return _eventMap;
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY
	)
	protected void registerEvent(Event event, Map<String, Object> properties) {
		Set<String> eventKeys = _eventMap.get(event.getObjectName());

		if (eventKeys == null) {
			eventKeys = new TreeSet<>();

			_eventMap.put(event.getObjectName(), eventKeys);
		}

		eventKeys.addAll(event.getEventKeys());
	}

	protected void unregisterEvent(
		Event event, Map<String, Object> properties) {

		Set<String> eventKeys = _eventMap.get(event.getObjectName());

		eventKeys.removeAll(event.getEventKeys());

		if (eventKeys.isEmpty()) {
			_eventMap.remove(event.getObjectName());
		}
	}

	private final Map<String, Set<String>> _eventMap =
		new ConcurrentHashMap<>();

}