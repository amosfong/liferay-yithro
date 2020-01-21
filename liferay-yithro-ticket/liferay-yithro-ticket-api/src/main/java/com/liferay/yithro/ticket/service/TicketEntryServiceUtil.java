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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for TicketEntry. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketEntryServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryService
 * @generated
 */
public class TicketEntryServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketEntryServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.yithro.ticket.model.TicketEntry addTicketEntry(
			long groupId, long ticketStructureId, long ticketStatusId,
			String languageId, String summary, String description, int weight,
			java.util.Map<Long, String> ticketFieldsMap,
			java.util.List<com.liferay.yithro.ticket.model.TicketAttachment>
				ticketAttachments)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketEntry(
			groupId, ticketStructureId, ticketStatusId, languageId, summary,
			description, weight, ticketFieldsMap, ticketAttachments);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.yithro.ticket.model.TicketEntry updateTicketEntry(
			long ticketEntryId, long reporterUserId, String summary,
			String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketEntry(
			ticketEntryId, reporterUserId, summary, description);
	}

	public static com.liferay.yithro.ticket.model.TicketEntry
			updateTicketStatus(long ticketEntryId, long ticketStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketStatus(ticketEntryId, ticketStatusId);
	}

	public static TicketEntryService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TicketEntryService, TicketEntryService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketEntryService.class);

		ServiceTracker<TicketEntryService, TicketEntryService> serviceTracker =
			new ServiceTracker<TicketEntryService, TicketEntryService>(
				bundle.getBundleContext(), TicketEntryService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}