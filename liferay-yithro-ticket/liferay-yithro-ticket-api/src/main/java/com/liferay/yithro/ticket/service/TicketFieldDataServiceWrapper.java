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

package com.liferay.yithro.ticket.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TicketFieldDataService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldDataService
 * @generated
 */
public class TicketFieldDataServiceWrapper
	implements ServiceWrapper<TicketFieldDataService>, TicketFieldDataService {

	public TicketFieldDataServiceWrapper(
		TicketFieldDataService ticketFieldDataService) {

		_ticketFieldDataService = ticketFieldDataService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketFieldDataService.getOSGiServiceIdentifier();
	}

	@Override
	public TicketFieldDataService getWrappedService() {
		return _ticketFieldDataService;
	}

	@Override
	public void setWrappedService(
		TicketFieldDataService ticketFieldDataService) {

		_ticketFieldDataService = ticketFieldDataService;
	}

	private TicketFieldDataService _ticketFieldDataService;

}