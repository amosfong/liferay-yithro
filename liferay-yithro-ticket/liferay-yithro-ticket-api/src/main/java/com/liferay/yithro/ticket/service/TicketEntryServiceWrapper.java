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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link TicketEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryService
 * @generated
 */
@ProviderType
public class TicketEntryServiceWrapper
	implements TicketEntryService, ServiceWrapper<TicketEntryService> {

	public TicketEntryServiceWrapper(TicketEntryService ticketEntryService) {
		_ticketEntryService = ticketEntryService;
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketEntry addTicketEntry(
			long ticketStructureId, long ticketStatusId, String languageId,
			String summary, String description, int weight,
			java.util.Map<Long, String> ticketFieldsMap,
			java.util.List<com.liferay.yithro.ticket.model.TicketAttachment>
				ticketAttachments)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryService.addTicketEntry(
			ticketStructureId, ticketStatusId, languageId, summary, description,
			weight, ticketFieldsMap, ticketAttachments);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketEntryService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketEntry updateTicketEntry(
			long ticketEntryId, String summary, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryService.updateTicketEntry(
			ticketEntryId, summary, description);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketEntry updateTicketStatus(
			long ticketEntryId, long ticketStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryService.updateTicketStatus(
			ticketEntryId, ticketStatusId);
	}

	@Override
	public TicketEntryService getWrappedService() {
		return _ticketEntryService;
	}

	@Override
	public void setWrappedService(TicketEntryService ticketEntryService) {
		_ticketEntryService = ticketEntryService;
	}

	private TicketEntryService _ticketEntryService;

}