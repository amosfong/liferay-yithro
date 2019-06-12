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

package com.liferay.yithro.ticket.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.yithro.ticket.model.TicketStatus;
import com.liferay.yithro.ticket.service.TicketStatusLocalServiceUtil;

/**
 * @author Amos Fong
 */
@ProviderType
public class TicketEntryImpl extends TicketEntryBaseImpl {

	public TicketEntryImpl() {
	}

	public TicketStatus getTicketStatus() throws PortalException {
		return TicketStatusLocalServiceUtil.getTicketStatus(
			getTicketStatusId());
	}

	public boolean isClosed() throws PortalException {
		TicketStatus ticketStatus = getTicketStatus();

		if (ticketStatus.isTerminal()) {
			return true;
		}

		return false;
	}

}