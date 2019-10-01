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
import com.liferay.yithro.ticket.model.TicketEntry;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket entry service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketEntryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryPersistence
 * @generated
 */
public class TicketEntryUtil {

	/**
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
	public static void clearCache(TicketEntry ticketEntry) {
		getPersistence().clearCache(ticketEntry);
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
	public static Map<Serializable, TicketEntry> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketEntry update(TicketEntry ticketEntry) {
		return getPersistence().update(ticketEntry);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketEntry update(
		TicketEntry ticketEntry, ServiceContext serviceContext) {

		return getPersistence().update(ticketEntry, serviceContext);
	}

	/**
	 * Returns all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @return the matching ticket entries
	 */
	public static List<TicketEntry> findByGtModifiedDate(Date modifiedDate) {
		return getPersistence().findByGtModifiedDate(modifiedDate);
	}

	/**
	 * Returns a range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	public static List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end) {

		return getPersistence().findByGtModifiedDate(modifiedDate, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	public static List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().findByGtModifiedDate(
			modifiedDate, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	public static List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGtModifiedDate(
			modifiedDate, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	public static TicketEntry findByGtModifiedDate_First(
			Date modifiedDate, OrderByComparator<TicketEntry> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketEntryException {

		return getPersistence().findByGtModifiedDate_First(
			modifiedDate, orderByComparator);
	}

	/**
	 * Returns the first ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	public static TicketEntry fetchByGtModifiedDate_First(
		Date modifiedDate, OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().fetchByGtModifiedDate_First(
			modifiedDate, orderByComparator);
	}

	/**
	 * Returns the last ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	public static TicketEntry findByGtModifiedDate_Last(
			Date modifiedDate, OrderByComparator<TicketEntry> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketEntryException {

		return getPersistence().findByGtModifiedDate_Last(
			modifiedDate, orderByComparator);
	}

	/**
	 * Returns the last ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	public static TicketEntry fetchByGtModifiedDate_Last(
		Date modifiedDate, OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().fetchByGtModifiedDate_Last(
			modifiedDate, orderByComparator);
	}

	/**
	 * Returns the ticket entries before and after the current ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param ticketEntryId the primary key of the current ticket entry
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	public static TicketEntry[] findByGtModifiedDate_PrevAndNext(
			long ticketEntryId, Date modifiedDate,
			OrderByComparator<TicketEntry> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketEntryException {

		return getPersistence().findByGtModifiedDate_PrevAndNext(
			ticketEntryId, modifiedDate, orderByComparator);
	}

	/**
	 * Removes all the ticket entries where modifiedDate &ge; &#63; from the database.
	 *
	 * @param modifiedDate the modified date
	 */
	public static void removeByGtModifiedDate(Date modifiedDate) {
		getPersistence().removeByGtModifiedDate(modifiedDate);
	}

	/**
	 * Returns the number of ticket entries where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @return the number of matching ticket entries
	 */
	public static int countByGtModifiedDate(Date modifiedDate) {
		return getPersistence().countByGtModifiedDate(modifiedDate);
	}

	/**
	 * Returns all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @return the matching ticket entries
	 */
	public static List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId) {

		return getPersistence().findByU_TSI(userId, ticketStatusId);
	}

	/**
	 * Returns a range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	public static List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end) {

		return getPersistence().findByU_TSI(userId, ticketStatusId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	public static List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().findByU_TSI(
			userId, ticketStatusId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	public static List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_TSI(
			userId, ticketStatusId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	public static TicketEntry findByU_TSI_First(
			long userId, long ticketStatusId,
			OrderByComparator<TicketEntry> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketEntryException {

		return getPersistence().findByU_TSI_First(
			userId, ticketStatusId, orderByComparator);
	}

	/**
	 * Returns the first ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	public static TicketEntry fetchByU_TSI_First(
		long userId, long ticketStatusId,
		OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().fetchByU_TSI_First(
			userId, ticketStatusId, orderByComparator);
	}

	/**
	 * Returns the last ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	public static TicketEntry findByU_TSI_Last(
			long userId, long ticketStatusId,
			OrderByComparator<TicketEntry> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketEntryException {

		return getPersistence().findByU_TSI_Last(
			userId, ticketStatusId, orderByComparator);
	}

	/**
	 * Returns the last ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	public static TicketEntry fetchByU_TSI_Last(
		long userId, long ticketStatusId,
		OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().fetchByU_TSI_Last(
			userId, ticketStatusId, orderByComparator);
	}

	/**
	 * Returns the ticket entries before and after the current ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param ticketEntryId the primary key of the current ticket entry
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	public static TicketEntry[] findByU_TSI_PrevAndNext(
			long ticketEntryId, long userId, long ticketStatusId,
			OrderByComparator<TicketEntry> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketEntryException {

		return getPersistence().findByU_TSI_PrevAndNext(
			ticketEntryId, userId, ticketStatusId, orderByComparator);
	}

	/**
	 * Returns all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @return the matching ticket entries
	 */
	public static List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds) {

		return getPersistence().findByU_TSI(userId, ticketStatusIds);
	}

	/**
	 * Returns a range of all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	public static List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end) {

		return getPersistence().findByU_TSI(
			userId, ticketStatusIds, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	public static List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().findByU_TSI(
			userId, ticketStatusIds, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	public static List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_TSI(
			userId, ticketStatusIds, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the ticket entries where userId = &#63; and ticketStatusId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 */
	public static void removeByU_TSI(long userId, long ticketStatusId) {
		getPersistence().removeByU_TSI(userId, ticketStatusId);
	}

	/**
	 * Returns the number of ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @return the number of matching ticket entries
	 */
	public static int countByU_TSI(long userId, long ticketStatusId) {
		return getPersistence().countByU_TSI(userId, ticketStatusId);
	}

	/**
	 * Returns the number of ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @return the number of matching ticket entries
	 */
	public static int countByU_TSI(long userId, long[] ticketStatusIds) {
		return getPersistence().countByU_TSI(userId, ticketStatusIds);
	}

	/**
	 * Caches the ticket entry in the entity cache if it is enabled.
	 *
	 * @param ticketEntry the ticket entry
	 */
	public static void cacheResult(TicketEntry ticketEntry) {
		getPersistence().cacheResult(ticketEntry);
	}

	/**
	 * Caches the ticket entries in the entity cache if it is enabled.
	 *
	 * @param ticketEntries the ticket entries
	 */
	public static void cacheResult(List<TicketEntry> ticketEntries) {
		getPersistence().cacheResult(ticketEntries);
	}

	/**
	 * Creates a new ticket entry with the primary key. Does not add the ticket entry to the database.
	 *
	 * @param ticketEntryId the primary key for the new ticket entry
	 * @return the new ticket entry
	 */
	public static TicketEntry create(long ticketEntryId) {
		return getPersistence().create(ticketEntryId);
	}

	/**
	 * Removes the ticket entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry that was removed
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	public static TicketEntry remove(long ticketEntryId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketEntryException {

		return getPersistence().remove(ticketEntryId);
	}

	public static TicketEntry updateImpl(TicketEntry ticketEntry) {
		return getPersistence().updateImpl(ticketEntry);
	}

	/**
	 * Returns the ticket entry with the primary key or throws a <code>NoSuchTicketEntryException</code> if it could not be found.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	public static TicketEntry findByPrimaryKey(long ticketEntryId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketEntryException {

		return getPersistence().findByPrimaryKey(ticketEntryId);
	}

	/**
	 * Returns the ticket entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry, or <code>null</code> if a ticket entry with the primary key could not be found
	 */
	public static TicketEntry fetchByPrimaryKey(long ticketEntryId) {
		return getPersistence().fetchByPrimaryKey(ticketEntryId);
	}

	/**
	 * Returns all the ticket entries.
	 *
	 * @return the ticket entries
	 */
	public static List<TicketEntry> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of ticket entries
	 */
	public static List<TicketEntry> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket entries
	 */
	public static List<TicketEntry> findAll(
		int start, int end, OrderByComparator<TicketEntry> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket entries
	 */
	public static List<TicketEntry> findAll(
		int start, int end, OrderByComparator<TicketEntry> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket entries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket entries.
	 *
	 * @return the number of ticket entries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketEntryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketEntryPersistence, TicketEntryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketEntryPersistence.class);

		ServiceTracker<TicketEntryPersistence, TicketEntryPersistence>
			serviceTracker =
				new ServiceTracker
					<TicketEntryPersistence, TicketEntryPersistence>(
						bundle.getBundleContext(), TicketEntryPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}