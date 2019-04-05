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
import com.liferay.yithro.ticket.constants.TicketWorkerRoles;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.service.TicketEntryLocalServiceUtil;

/**
 * @author Amos Fong
 */
@ProviderType
public class TicketWorkerImpl extends TicketWorkerBaseImpl {

	public TicketWorkerImpl() {
	}

	public String getRoleLabel() {
		return TicketWorkerRoles.getLabel(getRole());
	}

	public TicketEntry getTicketEntry() throws PortalException {
		return TicketEntryLocalServiceUtil.getTicketEntry(getTicketEntryId());
	}

}