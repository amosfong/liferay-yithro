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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Amos Fong
 */
@ProviderType
public class TicketCommunicationImpl extends TicketCommunicationBaseImpl {

	public TicketCommunicationImpl() {
	}

	public JSONObject getDataJSONObject() throws PortalException {
		return JSONFactoryUtil.createJSONObject(getData());
	}

	public User getUser() throws PortalException {
		return UserLocalServiceUtil.getUser(getUserId());
	}

}