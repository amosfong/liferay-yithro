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

package com.liferay.yithro.ticket.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.yithro.ticket.service.TicketEntryServiceUtil;

import java.rmi.RemoteException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the SOAP utility for the
 * <code>TicketEntryServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.yithro.ticket.model.TicketEntrySoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.yithro.ticket.model.TicketEntry</code>, that is translated to a
 * <code>com.liferay.yithro.ticket.model.TicketEntrySoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryServiceHttp
 * @generated
 */
@ProviderType
public class TicketEntryServiceSoap {

	public static com.liferay.yithro.ticket.model.TicketEntrySoap
			updateTicketEntry(
				long ticketEntryId, String summary, String description)
		throws RemoteException {

		try {
			com.liferay.yithro.ticket.model.TicketEntry returnValue =
				TicketEntryServiceUtil.updateTicketEntry(
					ticketEntryId, summary, description);

			return com.liferay.yithro.ticket.model.TicketEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.yithro.ticket.model.TicketEntrySoap
			updateTicketStatus(long ticketEntryId, long ticketStatusId)
		throws RemoteException {

		try {
			com.liferay.yithro.ticket.model.TicketEntry returnValue =
				TicketEntryServiceUtil.updateTicketStatus(
					ticketEntryId, ticketStatusId);

			return com.liferay.yithro.ticket.model.TicketEntrySoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TicketEntryServiceSoap.class);

}