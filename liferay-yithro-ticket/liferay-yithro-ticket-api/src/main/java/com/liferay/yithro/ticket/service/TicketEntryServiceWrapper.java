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
 * Provides a wrapper for {@link TicketEntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryService
 * @generated
 */
public class TicketEntryServiceWrapper
	implements TicketEntryService, ServiceWrapper<TicketEntryService> {

	public TicketEntryServiceWrapper(TicketEntryService ticketEntryService) {
		_ticketEntryService = ticketEntryService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketEntryServiceUtil} to access the ticket entry remote service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketEntryServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
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
			long ticketEntryId, long reporterUserId, String summary,
			String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryService.updateTicketEntry(
			ticketEntryId, reporterUserId, summary, description);
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