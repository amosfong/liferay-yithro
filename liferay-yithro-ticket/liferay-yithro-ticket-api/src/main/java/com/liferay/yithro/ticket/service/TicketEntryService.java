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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketEntry;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for TicketEntry. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TicketEntryService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketEntryServiceUtil} to access the ticket entry remote service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketEntryServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public TicketEntry addTicketEntry(
			long ticketStructureId, long ticketStatusId, String languageId,
			String summary, String description, int weight,
			Map<Long, String> ticketFieldsMap,
			List<TicketAttachment> ticketAttachments)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	public TicketEntry updateTicketEntry(
			long ticketEntryId, long reporterUserId, String summary,
			String description)
		throws PortalException;

	public TicketEntry updateTicketStatus(
			long ticketEntryId, long ticketStatusId)
		throws PortalException;

}