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

package com.liferay.yithro.ticket.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.ticket.model.TicketLink;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket link service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketLinkPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketLinkPersistence
 * @generated
 */
public class TicketLinkUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TicketLink ticketLink) {
		getPersistence().clearCache(ticketLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TicketLink> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketLink> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketLink update(TicketLink ticketLink) {
		return getPersistence().update(ticketLink);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketLink update(
		TicketLink ticketLink, ServiceContext serviceContext) {

		return getPersistence().update(ticketLink, serviceContext);
	}

	/**
	 * Returns all the ticket links where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket links
	 */
	public static List<TicketLink> findByTicketEntryId(long ticketEntryId) {
		return getPersistence().findByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns a range of all the ticket links where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of matching ticket links
	 */
	public static List<TicketLink> findByTicketEntryId(
		long ticketEntryId, int start, int end) {

		return getPersistence().findByTicketEntryId(ticketEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket links
	 */
	public static List<TicketLink> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket links
	 */
	public static List<TicketLink> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	public static TicketLink findByTicketEntryId_First(
			long ticketEntryId, OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTicketEntryId_First(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	public static TicketLink fetchByTicketEntryId_First(
		long ticketEntryId, OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().fetchByTicketEntryId_First(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	public static TicketLink findByTicketEntryId_Last(
			long ticketEntryId, OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTicketEntryId_Last(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	public static TicketLink fetchByTicketEntryId_Last(
		long ticketEntryId, OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().fetchByTicketEntryId_Last(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the ticket links before and after the current ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketLinkId the primary key of the current ticket link
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	public static TicketLink[] findByTicketEntryId_PrevAndNext(
			long ticketLinkId, long ticketEntryId,
			OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTicketEntryId_PrevAndNext(
			ticketLinkId, ticketEntryId, orderByComparator);
	}

	/**
	 * Removes all the ticket links where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	public static void removeByTicketEntryId(long ticketEntryId) {
		getPersistence().removeByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns the number of ticket links where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket links
	 */
	public static int countByTicketEntryId(long ticketEntryId) {
		return getPersistence().countByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns all the ticket links where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @return the matching ticket links
	 */
	public static List<TicketLink> findByTicketCommunicationId(
		long ticketCommunicationId) {

		return getPersistence().findByTicketCommunicationId(
			ticketCommunicationId);
	}

	/**
	 * Returns a range of all the ticket links where ticketCommunicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of matching ticket links
	 */
	public static List<TicketLink> findByTicketCommunicationId(
		long ticketCommunicationId, int start, int end) {

		return getPersistence().findByTicketCommunicationId(
			ticketCommunicationId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketCommunicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket links
	 */
	public static List<TicketLink> findByTicketCommunicationId(
		long ticketCommunicationId, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().findByTicketCommunicationId(
			ticketCommunicationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketCommunicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket links
	 */
	public static List<TicketLink> findByTicketCommunicationId(
		long ticketCommunicationId, int start, int end,
		OrderByComparator<TicketLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTicketCommunicationId(
			ticketCommunicationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	public static TicketLink findByTicketCommunicationId_First(
			long ticketCommunicationId,
			OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTicketCommunicationId_First(
			ticketCommunicationId, orderByComparator);
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	public static TicketLink fetchByTicketCommunicationId_First(
		long ticketCommunicationId,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().fetchByTicketCommunicationId_First(
			ticketCommunicationId, orderByComparator);
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	public static TicketLink findByTicketCommunicationId_Last(
			long ticketCommunicationId,
			OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTicketCommunicationId_Last(
			ticketCommunicationId, orderByComparator);
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	public static TicketLink fetchByTicketCommunicationId_Last(
		long ticketCommunicationId,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().fetchByTicketCommunicationId_Last(
			ticketCommunicationId, orderByComparator);
	}

	/**
	 * Returns the ticket links before and after the current ticket link in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketLinkId the primary key of the current ticket link
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	public static TicketLink[] findByTicketCommunicationId_PrevAndNext(
			long ticketLinkId, long ticketCommunicationId,
			OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTicketCommunicationId_PrevAndNext(
			ticketLinkId, ticketCommunicationId, orderByComparator);
	}

	/**
	 * Removes all the ticket links where ticketCommunicationId = &#63; from the database.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 */
	public static void removeByTicketCommunicationId(
		long ticketCommunicationId) {

		getPersistence().removeByTicketCommunicationId(ticketCommunicationId);
	}

	/**
	 * Returns the number of ticket links where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @return the number of matching ticket links
	 */
	public static int countByTicketCommunicationId(long ticketCommunicationId) {
		return getPersistence().countByTicketCommunicationId(
			ticketCommunicationId);
	}

	/**
	 * Returns all the ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @return the matching ticket links
	 */
	public static List<TicketLink> findByTEI_V(
		long ticketEntryId, int visibility) {

		return getPersistence().findByTEI_V(ticketEntryId, visibility);
	}

	/**
	 * Returns a range of all the ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of matching ticket links
	 */
	public static List<TicketLink> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibility, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket links
	 */
	public static List<TicketLink> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibility, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket links
	 */
	public static List<TicketLink> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end,
		OrderByComparator<TicketLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibility, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	public static TicketLink findByTEI_V_First(
			long ticketEntryId, int visibility,
			OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTEI_V_First(
			ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	public static TicketLink fetchByTEI_V_First(
		long ticketEntryId, int visibility,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().fetchByTEI_V_First(
			ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	public static TicketLink findByTEI_V_Last(
			long ticketEntryId, int visibility,
			OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTEI_V_Last(
			ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	public static TicketLink fetchByTEI_V_Last(
		long ticketEntryId, int visibility,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().fetchByTEI_V_Last(
			ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns the ticket links before and after the current ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketLinkId the primary key of the current ticket link
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	public static TicketLink[] findByTEI_V_PrevAndNext(
			long ticketLinkId, long ticketEntryId, int visibility,
			OrderByComparator<TicketLink> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByTEI_V_PrevAndNext(
			ticketLinkId, ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns all the ticket links where ticketEntryId = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @return the matching ticket links
	 */
	public static List<TicketLink> findByTEI_V(
		long ticketEntryId, int[] visibilities) {

		return getPersistence().findByTEI_V(ticketEntryId, visibilities);
	}

	/**
	 * Returns a range of all the ticket links where ticketEntryId = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of matching ticket links
	 */
	public static List<TicketLink> findByTEI_V(
		long ticketEntryId, int[] visibilities, int start, int end) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibilities, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket links
	 */
	public static List<TicketLink> findByTEI_V(
		long ticketEntryId, int[] visibilities, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibilities, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and visibility = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket links
	 */
	public static List<TicketLink> findByTEI_V(
		long ticketEntryId, int[] visibilities, int start, int end,
		OrderByComparator<TicketLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibilities, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the ticket links where ticketEntryId = &#63; and visibility = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 */
	public static void removeByTEI_V(long ticketEntryId, int visibility) {
		getPersistence().removeByTEI_V(ticketEntryId, visibility);
	}

	/**
	 * Returns the number of ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @return the number of matching ticket links
	 */
	public static int countByTEI_V(long ticketEntryId, int visibility) {
		return getPersistence().countByTEI_V(ticketEntryId, visibility);
	}

	/**
	 * Returns the number of ticket links where ticketEntryId = &#63; and visibility = any &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @return the number of matching ticket links
	 */
	public static int countByTEI_V(long ticketEntryId, int[] visibilities) {
		return getPersistence().countByTEI_V(ticketEntryId, visibilities);
	}

	/**
	 * Caches the ticket link in the entity cache if it is enabled.
	 *
	 * @param ticketLink the ticket link
	 */
	public static void cacheResult(TicketLink ticketLink) {
		getPersistence().cacheResult(ticketLink);
	}

	/**
	 * Caches the ticket links in the entity cache if it is enabled.
	 *
	 * @param ticketLinks the ticket links
	 */
	public static void cacheResult(List<TicketLink> ticketLinks) {
		getPersistence().cacheResult(ticketLinks);
	}

	/**
	 * Creates a new ticket link with the primary key. Does not add the ticket link to the database.
	 *
	 * @param ticketLinkId the primary key for the new ticket link
	 * @return the new ticket link
	 */
	public static TicketLink create(long ticketLinkId) {
		return getPersistence().create(ticketLinkId);
	}

	/**
	 * Removes the ticket link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketLinkId the primary key of the ticket link
	 * @return the ticket link that was removed
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	public static TicketLink remove(long ticketLinkId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().remove(ticketLinkId);
	}

	public static TicketLink updateImpl(TicketLink ticketLink) {
		return getPersistence().updateImpl(ticketLink);
	}

	/**
	 * Returns the ticket link with the primary key or throws a <code>NoSuchTicketLinkException</code> if it could not be found.
	 *
	 * @param ticketLinkId the primary key of the ticket link
	 * @return the ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	public static TicketLink findByPrimaryKey(long ticketLinkId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketLinkException {

		return getPersistence().findByPrimaryKey(ticketLinkId);
	}

	/**
	 * Returns the ticket link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketLinkId the primary key of the ticket link
	 * @return the ticket link, or <code>null</code> if a ticket link with the primary key could not be found
	 */
	public static TicketLink fetchByPrimaryKey(long ticketLinkId) {
		return getPersistence().fetchByPrimaryKey(ticketLinkId);
	}

	/**
	 * Returns all the ticket links.
	 *
	 * @return the ticket links
	 */
	public static List<TicketLink> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of ticket links
	 */
	public static List<TicketLink> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket links
	 */
	public static List<TicketLink> findAll(
		int start, int end, OrderByComparator<TicketLink> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket links
	 */
	public static List<TicketLink> findAll(
		int start, int end, OrderByComparator<TicketLink> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket links from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket links.
	 *
	 * @return the number of ticket links
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketLinkPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TicketLinkPersistence, TicketLinkPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketLinkPersistence.class);

		ServiceTracker<TicketLinkPersistence, TicketLinkPersistence>
			serviceTracker =
				new ServiceTracker
					<TicketLinkPersistence, TicketLinkPersistence>(
						bundle.getBundleContext(), TicketLinkPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}