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

package com.liferay.yithro.ticket.rules.internal;

import com.liferay.yithro.rules.engine.BaseEvent;
import com.liferay.yithro.rules.engine.Event;
import com.liferay.yithro.rules.engine.constants.EventKeys;
import com.liferay.yithro.ticket.model.TicketEntry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(service = {Event.class, TicketEntryEvent.class})
public class TicketEntryEvent extends BaseEvent {

	public void add(TicketEntry ticketEntry) {
		fire(getObjectName(), EventKeys.ADD, serialize(ticketEntry));
	}

	public void delete(TicketEntry ticketEntry) {
		fire(getObjectName(), EventKeys.DELETE, serialize(ticketEntry));
	}

	@Override
	public Set<String> getEventKeys() {
		return _eventKeys;
	}

	@Override
	public String getObjectName() {
		return "Ticket";
	}

	public void update(TicketEntry ticketEntry) {
		fire(getObjectName(), EventKeys.UPDATE, serialize(ticketEntry));
	}

	protected Map<String, Object> serialize(TicketEntry ticketEntry) {
		Map<String, Object> fields = new HashMap<>();

		// todo

		return fields;
	}

	private final Set<String> _eventKeys = new HashSet<>(
		Arrays.asList(EventKeys.ADD, EventKeys.DELETE, EventKeys.UPDATE));

}