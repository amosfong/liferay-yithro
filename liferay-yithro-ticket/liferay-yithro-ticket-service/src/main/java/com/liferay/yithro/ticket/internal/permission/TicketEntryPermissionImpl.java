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

package com.liferay.yithro.ticket.internal.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.permission.TicketEntryPermission;
import com.liferay.yithro.ticket.service.TicketEntryLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = TicketEntryPermission.class)
public class TicketEntryPermissionImpl implements TicketEntryPermission {

	@Override
	public void check(
			PermissionChecker permissionChecker, long ticketEntryId,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, ticketEntryId, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, TicketEntry.class.getName(), ticketEntryId,
				actionId);
		}
	}

	@Override
	public void check(
			PermissionChecker permissionChecker, TicketEntry ticketEntry,
			String actionId)
		throws PortalException {

		if (!contains(permissionChecker, ticketEntry, actionId)) {
			throw new PrincipalException.MustHavePermission(
				permissionChecker, TicketEntry.class.getName(),
				ticketEntry.getTicketEntryId(), actionId);
		}
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, long ticketEntryId,
			String actionId)
		throws PortalException {

		if (contains(
				permissionChecker,
				_ticketEntryLocalService.getTicketEntry(ticketEntryId),
				actionId)) {

			return true;
		}

		return false;
	}

	@Override
	public boolean contains(
			PermissionChecker permissionChecker, TicketEntry ticketEntry,
			String actionId)
		throws PortalException {

		return permissionChecker.hasPermission(
			ticketEntry.getGroupId(), TicketEntry.class.getName(),
			ticketEntry.getTicketEntryId(), actionId);
	}

	@Reference
	private TicketEntryLocalService _ticketEntryLocalService;

}