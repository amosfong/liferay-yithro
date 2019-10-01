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
import com.liferay.yithro.ticket.model.TicketFlag;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket flag service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketFlagPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFlagPersistence
 * @generated
 */
public class TicketFlagUtil {

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
	public static void clearCache(TicketFlag ticketFlag) {
		getPersistence().clearCache(ticketFlag);
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
	public static Map<Serializable, TicketFlag> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketFlag> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketFlag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketFlag> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketFlag update(TicketFlag ticketFlag) {
		return getPersistence().update(ticketFlag);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketFlag update(
		TicketFlag ticketFlag, ServiceContext serviceContext) {

		return getPersistence().update(ticketFlag, serviceContext);
	}

	/**
	 * Returns all the ticket flags where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket flags
	 */
	public static List<TicketFlag> findByTicketEntryId(long ticketEntryId) {
		return getPersistence().findByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns a range of all the ticket flags where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of matching ticket flags
	 */
	public static List<TicketFlag> findByTicketEntryId(
		long ticketEntryId, int start, int end) {

		return getPersistence().findByTicketEntryId(ticketEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket flags
	 */
	public static List<TicketFlag> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket flags
	 */
	public static List<TicketFlag> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	public static TicketFlag findByTicketEntryId_First(
			long ticketEntryId, OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTicketEntryId_First(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	public static TicketFlag fetchByTicketEntryId_First(
		long ticketEntryId, OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().fetchByTicketEntryId_First(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	public static TicketFlag findByTicketEntryId_Last(
			long ticketEntryId, OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTicketEntryId_Last(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	public static TicketFlag fetchByTicketEntryId_Last(
		long ticketEntryId, OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().fetchByTicketEntryId_Last(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the ticket flags before and after the current ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketFlagId the primary key of the current ticket flag
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	public static TicketFlag[] findByTicketEntryId_PrevAndNext(
			long ticketFlagId, long ticketEntryId,
			OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTicketEntryId_PrevAndNext(
			ticketFlagId, ticketEntryId, orderByComparator);
	}

	/**
	 * Removes all the ticket flags where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	public static void removeByTicketEntryId(long ticketEntryId) {
		getPersistence().removeByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns the number of ticket flags where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket flags
	 */
	public static int countByTicketEntryId(long ticketEntryId) {
		return getPersistence().countByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns all the ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T(long ticketEntryId, int type) {
		return getPersistence().findByTEI_T(ticketEntryId, type);
	}

	/**
	 * Returns a range of all the ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T(
		long ticketEntryId, int type, int start, int end) {

		return getPersistence().findByTEI_T(ticketEntryId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T(
		long ticketEntryId, int type, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().findByTEI_T(
			ticketEntryId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T(
		long ticketEntryId, int type, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_T(
			ticketEntryId, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	public static TicketFlag findByTEI_T_First(
			long ticketEntryId, int type,
			OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTEI_T_First(
			ticketEntryId, type, orderByComparator);
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	public static TicketFlag fetchByTEI_T_First(
		long ticketEntryId, int type,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().fetchByTEI_T_First(
			ticketEntryId, type, orderByComparator);
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	public static TicketFlag findByTEI_T_Last(
			long ticketEntryId, int type,
			OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTEI_T_Last(
			ticketEntryId, type, orderByComparator);
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	public static TicketFlag fetchByTEI_T_Last(
		long ticketEntryId, int type,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().fetchByTEI_T_Last(
			ticketEntryId, type, orderByComparator);
	}

	/**
	 * Returns the ticket flags before and after the current ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketFlagId the primary key of the current ticket flag
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	public static TicketFlag[] findByTEI_T_PrevAndNext(
			long ticketFlagId, long ticketEntryId, int type,
			OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTEI_T_PrevAndNext(
			ticketFlagId, ticketEntryId, type, orderByComparator);
	}

	/**
	 * Removes all the ticket flags where ticketEntryId = &#63; and type = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 */
	public static void removeByTEI_T(long ticketEntryId, int type) {
		getPersistence().removeByTEI_T(ticketEntryId, type);
	}

	/**
	 * Returns the number of ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the number of matching ticket flags
	 */
	public static int countByTEI_T(long ticketEntryId, int type) {
		return getPersistence().countByTEI_T(ticketEntryId, type);
	}

	/**
	 * Returns the ticket flag where userId = &#63; and ticketEntryId = &#63; and type = &#63; or throws a <code>NoSuchTicketFlagException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	public static TicketFlag findByU_TEI_T(
			long userId, long ticketEntryId, int type)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByU_TEI_T(userId, ticketEntryId, type);
	}

	/**
	 * Returns the ticket flag where userId = &#63; and ticketEntryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	public static TicketFlag fetchByU_TEI_T(
		long userId, long ticketEntryId, int type) {

		return getPersistence().fetchByU_TEI_T(userId, ticketEntryId, type);
	}

	/**
	 * Returns the ticket flag where userId = &#63; and ticketEntryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	public static TicketFlag fetchByU_TEI_T(
		long userId, long ticketEntryId, int type, boolean useFinderCache) {

		return getPersistence().fetchByU_TEI_T(
			userId, ticketEntryId, type, useFinderCache);
	}

	/**
	 * Removes the ticket flag where userId = &#63; and ticketEntryId = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the ticket flag that was removed
	 */
	public static TicketFlag removeByU_TEI_T(
			long userId, long ticketEntryId, int type)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().removeByU_TEI_T(userId, ticketEntryId, type);
	}

	/**
	 * Returns the number of ticket flags where userId = &#63; and ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the number of matching ticket flags
	 */
	public static int countByU_TEI_T(
		long userId, long ticketEntryId, int type) {

		return getPersistence().countByU_TEI_T(userId, ticketEntryId, type);
	}

	/**
	 * Returns all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @return the matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int type, int value) {

		return getPersistence().findByTEI_T_V(ticketEntryId, type, value);
	}

	/**
	 * Returns a range of all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int type, int value, int start, int end) {

		return getPersistence().findByTEI_T_V(
			ticketEntryId, type, value, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int type, int value, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().findByTEI_T_V(
			ticketEntryId, type, value, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int type, int value, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_T_V(
			ticketEntryId, type, value, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	public static TicketFlag findByTEI_T_V_First(
			long ticketEntryId, int type, int value,
			OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTEI_T_V_First(
			ticketEntryId, type, value, orderByComparator);
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	public static TicketFlag fetchByTEI_T_V_First(
		long ticketEntryId, int type, int value,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().fetchByTEI_T_V_First(
			ticketEntryId, type, value, orderByComparator);
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	public static TicketFlag findByTEI_T_V_Last(
			long ticketEntryId, int type, int value,
			OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTEI_T_V_Last(
			ticketEntryId, type, value, orderByComparator);
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	public static TicketFlag fetchByTEI_T_V_Last(
		long ticketEntryId, int type, int value,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().fetchByTEI_T_V_Last(
			ticketEntryId, type, value, orderByComparator);
	}

	/**
	 * Returns the ticket flags before and after the current ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketFlagId the primary key of the current ticket flag
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	public static TicketFlag[] findByTEI_T_V_PrevAndNext(
			long ticketFlagId, long ticketEntryId, int type, int value,
			OrderByComparator<TicketFlag> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByTEI_T_V_PrevAndNext(
			ticketFlagId, ticketEntryId, type, value, orderByComparator);
	}

	/**
	 * Returns all the ticket flags where ticketEntryId = &#63; and type = any &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param types the types
	 * @param value the value
	 * @return the matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int[] types, int value) {

		return getPersistence().findByTEI_T_V(ticketEntryId, types, value);
	}

	/**
	 * Returns a range of all the ticket flags where ticketEntryId = &#63; and type = any &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param types the types
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int[] types, int value, int start, int end) {

		return getPersistence().findByTEI_T_V(
			ticketEntryId, types, value, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = any &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param types the types
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int[] types, int value, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().findByTEI_T_V(
			ticketEntryId, types, value, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket flags
	 */
	public static List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int[] types, int value, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_T_V(
			ticketEntryId, types, value, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 */
	public static void removeByTEI_T_V(
		long ticketEntryId, int type, int value) {

		getPersistence().removeByTEI_T_V(ticketEntryId, type, value);
	}

	/**
	 * Returns the number of ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @return the number of matching ticket flags
	 */
	public static int countByTEI_T_V(long ticketEntryId, int type, int value) {
		return getPersistence().countByTEI_T_V(ticketEntryId, type, value);
	}

	/**
	 * Returns the number of ticket flags where ticketEntryId = &#63; and type = any &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param types the types
	 * @param value the value
	 * @return the number of matching ticket flags
	 */
	public static int countByTEI_T_V(
		long ticketEntryId, int[] types, int value) {

		return getPersistence().countByTEI_T_V(ticketEntryId, types, value);
	}

	/**
	 * Caches the ticket flag in the entity cache if it is enabled.
	 *
	 * @param ticketFlag the ticket flag
	 */
	public static void cacheResult(TicketFlag ticketFlag) {
		getPersistence().cacheResult(ticketFlag);
	}

	/**
	 * Caches the ticket flags in the entity cache if it is enabled.
	 *
	 * @param ticketFlags the ticket flags
	 */
	public static void cacheResult(List<TicketFlag> ticketFlags) {
		getPersistence().cacheResult(ticketFlags);
	}

	/**
	 * Creates a new ticket flag with the primary key. Does not add the ticket flag to the database.
	 *
	 * @param ticketFlagId the primary key for the new ticket flag
	 * @return the new ticket flag
	 */
	public static TicketFlag create(long ticketFlagId) {
		return getPersistence().create(ticketFlagId);
	}

	/**
	 * Removes the ticket flag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFlagId the primary key of the ticket flag
	 * @return the ticket flag that was removed
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	public static TicketFlag remove(long ticketFlagId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().remove(ticketFlagId);
	}

	public static TicketFlag updateImpl(TicketFlag ticketFlag) {
		return getPersistence().updateImpl(ticketFlag);
	}

	/**
	 * Returns the ticket flag with the primary key or throws a <code>NoSuchTicketFlagException</code> if it could not be found.
	 *
	 * @param ticketFlagId the primary key of the ticket flag
	 * @return the ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	public static TicketFlag findByPrimaryKey(long ticketFlagId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFlagException {

		return getPersistence().findByPrimaryKey(ticketFlagId);
	}

	/**
	 * Returns the ticket flag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFlagId the primary key of the ticket flag
	 * @return the ticket flag, or <code>null</code> if a ticket flag with the primary key could not be found
	 */
	public static TicketFlag fetchByPrimaryKey(long ticketFlagId) {
		return getPersistence().fetchByPrimaryKey(ticketFlagId);
	}

	/**
	 * Returns all the ticket flags.
	 *
	 * @return the ticket flags
	 */
	public static List<TicketFlag> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket flags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of ticket flags
	 */
	public static List<TicketFlag> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket flags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket flags
	 */
	public static List<TicketFlag> findAll(
		int start, int end, OrderByComparator<TicketFlag> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket flags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket flags
	 */
	public static List<TicketFlag> findAll(
		int start, int end, OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket flags from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket flags.
	 *
	 * @return the number of ticket flags
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketFlagPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<TicketFlagPersistence, TicketFlagPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketFlagPersistence.class);

		ServiceTracker<TicketFlagPersistence, TicketFlagPersistence>
			serviceTracker =
				new ServiceTracker
					<TicketFlagPersistence, TicketFlagPersistence>(
						bundle.getBundleContext(), TicketFlagPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}