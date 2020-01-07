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

package com.liferay.yithro.ticket.rules.internal.model.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.rules.internal.TicketEntryEvent;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(service = ModelListener.class)
public class TicketEntryModelListener extends BaseModelListener<TicketEntry> {

	@Override
	public void onAfterCreate(TicketEntry ticketEntry)
		throws ModelListenerException {

		_ticketEntryEvent.add(ticketEntry);
	}

	@Override
	public void onAfterRemove(TicketEntry ticketEntry)
		throws ModelListenerException {

		_ticketEntryEvent.delete(ticketEntry);
	}

	@Override
	public void onAfterUpdate(TicketEntry ticketEntry)
		throws ModelListenerException {

		_ticketEntryEvent.update(ticketEntry);
	}

	@Reference
	private TicketEntryEvent _ticketEntryEvent;

}