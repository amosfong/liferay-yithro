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

package com.liferay.yithro.ticket.internal.initializer;

import com.liferay.portal.instances.service.PortalInstancesLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.constants.TicketFieldType;
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.service.TicketFieldLocalService;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = {})
public class TicketFieldInitializer {

	@Activate
	public void activate() throws PortalException {
		initSystemTicketField(
			"description", "Description",
			"This is a description of the ticket.");
		initSystemTicketField(
			"summary", "Summary", "This is a summary of the ticket.");
	}

	protected void initSystemTicketField(
			String systemKey, String name, String description)
		throws PortalException {

		TicketField ticketField = _ticketFieldLocalService.fetchTicketField(
			systemKey);

		if (ticketField == null) {
			long companyId = _portalInstancesLocalService.getDefaultCompanyId();

			long userId = _userLocalService.getDefaultUserId(companyId);

			Map<Locale, String> nameMap = new HashMap<Locale, String>() {
				{
					put(LocaleUtil.getDefault(), name);
				}
			};

			Map<Locale, String> descriptionMap = new HashMap<Locale, String>() {
				{
					put(LocaleUtil.getDefault(), description);
				}
			};

			ticketField = _ticketFieldLocalService.addTicketField(
				userId, nameMap, descriptionMap, TicketFieldType.TEXT,
				Visibilities.PUBLIC, null);

			ticketField.setSystemKey(systemKey);

			_ticketFieldLocalService.updateTicketField(ticketField);
		}
	}

	@Reference
	private PortalInstancesLocalService _portalInstancesLocalService;

	@Reference
	private TicketFieldLocalService _ticketFieldLocalService;

	@Reference
	private UserLocalService _userLocalService;

}