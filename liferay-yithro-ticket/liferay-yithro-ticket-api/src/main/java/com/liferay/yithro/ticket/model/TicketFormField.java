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

package com.liferay.yithro.ticket.model;

/**
 * @author Amos Fong
 */
public class TicketFormField {

	public String getDisplayRules() {
		return _displayRules;
	}

	public TicketField getTicketField() {
		return _ticketField;
	}

	public void setDisplayRules(String displayRules) {
		_displayRules = displayRules;
	}

	public void setTicketField(TicketField ticketField) {
		_ticketField = ticketField;
	}

	private String _displayRules;
	private TicketField _ticketField;

}