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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.yithro.ticket.service.TicketEntryServiceUtil;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the HTTP utility for the
 * <code>TicketEntryServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryServiceSoap
 * @generated
 */
@ProviderType
public class TicketEntryServiceHttp {

	public static com.liferay.yithro.ticket.model.TicketEntry addTicketEntry(
			HttpPrincipal httpPrincipal, long ticketStructureId,
			long ticketStatusId, String languageId, String summary,
			String description, int weight,
			java.util.Map<Long, String> ticketFieldsMap,
			java.util.List<com.liferay.yithro.ticket.model.TicketAttachment>
				ticketAttachments)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TicketEntryServiceUtil.class, "addTicketEntry",
				_addTicketEntryParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, ticketStructureId, ticketStatusId, languageId,
				summary, description, weight, ticketFieldsMap,
				ticketAttachments);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.yithro.ticket.model.TicketEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.yithro.ticket.model.TicketEntry updateTicketEntry(
			HttpPrincipal httpPrincipal, long ticketEntryId,
			long reporterUserId, String summary, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TicketEntryServiceUtil.class, "updateTicketEntry",
				_updateTicketEntryParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, ticketEntryId, reporterUserId, summary, description);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.yithro.ticket.model.TicketEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	public static com.liferay.yithro.ticket.model.TicketEntry
			updateTicketStatus(
				HttpPrincipal httpPrincipal, long ticketEntryId,
				long ticketStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				TicketEntryServiceUtil.class, "updateTicketStatus",
				_updateTicketStatusParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, ticketEntryId, ticketStatusId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception e) {
				if (e instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						e;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					e);
			}

			return (com.liferay.yithro.ticket.model.TicketEntry)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException se) {
			_log.error(se, se);

			throw se;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		TicketEntryServiceHttp.class);

	private static final Class<?>[] _addTicketEntryParameterTypes0 =
		new Class[] {
			long.class, long.class, String.class, String.class, String.class,
			int.class, java.util.Map.class, java.util.List.class
		};
	private static final Class<?>[] _updateTicketEntryParameterTypes1 =
		new Class[] {long.class, long.class, String.class, String.class};
	private static final Class<?>[] _updateTicketStatusParameterTypes2 =
		new Class[] {long.class, long.class};

}