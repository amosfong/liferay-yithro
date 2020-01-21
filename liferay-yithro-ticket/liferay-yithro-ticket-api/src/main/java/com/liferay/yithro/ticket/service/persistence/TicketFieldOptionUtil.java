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
import com.liferay.yithro.ticket.model.TicketFieldOption;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket field option service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketFieldOptionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldOptionPersistence
 * @generated
 */
public class TicketFieldOptionUtil {

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
	public static void clearCache(TicketFieldOption ticketFieldOption) {
		getPersistence().clearCache(ticketFieldOption);
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
	public static Map<Serializable, TicketFieldOption> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketFieldOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketFieldOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketFieldOption> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketFieldOption update(
		TicketFieldOption ticketFieldOption) {

		return getPersistence().update(ticketFieldOption);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketFieldOption update(
		TicketFieldOption ticketFieldOption, ServiceContext serviceContext) {

		return getPersistence().update(ticketFieldOption, serviceContext);
	}

	/**
	 * Returns all the ticket field options where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket field options
	 */
	public static List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId) {

		return getPersistence().findByTicketFieldId(ticketFieldId);
	}

	/**
	 * Returns a range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of matching ticket field options
	 */
	public static List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end) {

		return getPersistence().findByTicketFieldId(ticketFieldId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket field options
	 */
	public static List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return getPersistence().findByTicketFieldId(
			ticketFieldId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket field options
	 */
	public static List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTicketFieldId(
			ticketFieldId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	public static TicketFieldOption findByTicketFieldId_First(
			long ticketFieldId,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldOptionException {

		return getPersistence().findByTicketFieldId_First(
			ticketFieldId, orderByComparator);
	}

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	public static TicketFieldOption fetchByTicketFieldId_First(
		long ticketFieldId,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return getPersistence().fetchByTicketFieldId_First(
			ticketFieldId, orderByComparator);
	}

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	public static TicketFieldOption findByTicketFieldId_Last(
			long ticketFieldId,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldOptionException {

		return getPersistence().findByTicketFieldId_Last(
			ticketFieldId, orderByComparator);
	}

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	public static TicketFieldOption fetchByTicketFieldId_Last(
		long ticketFieldId,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return getPersistence().fetchByTicketFieldId_Last(
			ticketFieldId, orderByComparator);
	}

	/**
	 * Returns the ticket field options before and after the current ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldOptionId the primary key of the current ticket field option
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	public static TicketFieldOption[] findByTicketFieldId_PrevAndNext(
			long ticketFieldOptionId, long ticketFieldId,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldOptionException {

		return getPersistence().findByTicketFieldId_PrevAndNext(
			ticketFieldOptionId, ticketFieldId, orderByComparator);
	}

	/**
	 * Removes all the ticket field options where ticketFieldId = &#63; from the database.
	 *
	 * @param ticketFieldId the ticket field ID
	 */
	public static void removeByTicketFieldId(long ticketFieldId) {
		getPersistence().removeByTicketFieldId(ticketFieldId);
	}

	/**
	 * Returns the number of ticket field options where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @return the number of matching ticket field options
	 */
	public static int countByTicketFieldId(long ticketFieldId) {
		return getPersistence().countByTicketFieldId(ticketFieldId);
	}

	/**
	 * Returns all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @return the matching ticket field options
	 */
	public static List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status) {

		return getPersistence().findByTFI_S(ticketFieldId, status);
	}

	/**
	 * Returns a range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of matching ticket field options
	 */
	public static List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end) {

		return getPersistence().findByTFI_S(ticketFieldId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket field options
	 */
	public static List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return getPersistence().findByTFI_S(
			ticketFieldId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket field options
	 */
	public static List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTFI_S(
			ticketFieldId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	public static TicketFieldOption findByTFI_S_First(
			long ticketFieldId, int status,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldOptionException {

		return getPersistence().findByTFI_S_First(
			ticketFieldId, status, orderByComparator);
	}

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	public static TicketFieldOption fetchByTFI_S_First(
		long ticketFieldId, int status,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return getPersistence().fetchByTFI_S_First(
			ticketFieldId, status, orderByComparator);
	}

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	public static TicketFieldOption findByTFI_S_Last(
			long ticketFieldId, int status,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldOptionException {

		return getPersistence().findByTFI_S_Last(
			ticketFieldId, status, orderByComparator);
	}

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	public static TicketFieldOption fetchByTFI_S_Last(
		long ticketFieldId, int status,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return getPersistence().fetchByTFI_S_Last(
			ticketFieldId, status, orderByComparator);
	}

	/**
	 * Returns the ticket field options before and after the current ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldOptionId the primary key of the current ticket field option
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	public static TicketFieldOption[] findByTFI_S_PrevAndNext(
			long ticketFieldOptionId, long ticketFieldId, int status,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldOptionException {

		return getPersistence().findByTFI_S_PrevAndNext(
			ticketFieldOptionId, ticketFieldId, status, orderByComparator);
	}

	/**
	 * Removes all the ticket field options where ticketFieldId = &#63; and status = &#63; from the database.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 */
	public static void removeByTFI_S(long ticketFieldId, int status) {
		getPersistence().removeByTFI_S(ticketFieldId, status);
	}

	/**
	 * Returns the number of ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @return the number of matching ticket field options
	 */
	public static int countByTFI_S(long ticketFieldId, int status) {
		return getPersistence().countByTFI_S(ticketFieldId, status);
	}

	/**
	 * Caches the ticket field option in the entity cache if it is enabled.
	 *
	 * @param ticketFieldOption the ticket field option
	 */
	public static void cacheResult(TicketFieldOption ticketFieldOption) {
		getPersistence().cacheResult(ticketFieldOption);
	}

	/**
	 * Caches the ticket field options in the entity cache if it is enabled.
	 *
	 * @param ticketFieldOptions the ticket field options
	 */
	public static void cacheResult(List<TicketFieldOption> ticketFieldOptions) {
		getPersistence().cacheResult(ticketFieldOptions);
	}

	/**
	 * Creates a new ticket field option with the primary key. Does not add the ticket field option to the database.
	 *
	 * @param ticketFieldOptionId the primary key for the new ticket field option
	 * @return the new ticket field option
	 */
	public static TicketFieldOption create(long ticketFieldOptionId) {
		return getPersistence().create(ticketFieldOptionId);
	}

	/**
	 * Removes the ticket field option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option that was removed
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	public static TicketFieldOption remove(long ticketFieldOptionId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldOptionException {

		return getPersistence().remove(ticketFieldOptionId);
	}

	public static TicketFieldOption updateImpl(
		TicketFieldOption ticketFieldOption) {

		return getPersistence().updateImpl(ticketFieldOption);
	}

	/**
	 * Returns the ticket field option with the primary key or throws a <code>NoSuchTicketFieldOptionException</code> if it could not be found.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	public static TicketFieldOption findByPrimaryKey(long ticketFieldOptionId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldOptionException {

		return getPersistence().findByPrimaryKey(ticketFieldOptionId);
	}

	/**
	 * Returns the ticket field option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option, or <code>null</code> if a ticket field option with the primary key could not be found
	 */
	public static TicketFieldOption fetchByPrimaryKey(
		long ticketFieldOptionId) {

		return getPersistence().fetchByPrimaryKey(ticketFieldOptionId);
	}

	/**
	 * Returns all the ticket field options.
	 *
	 * @return the ticket field options
	 */
	public static List<TicketFieldOption> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of ticket field options
	 */
	public static List<TicketFieldOption> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket field options
	 */
	public static List<TicketFieldOption> findAll(
		int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket field options
	 */
	public static List<TicketFieldOption> findAll(
		int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket field options from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket field options.
	 *
	 * @return the number of ticket field options
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketFieldOptionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketFieldOptionPersistence, TicketFieldOptionPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketFieldOptionPersistence.class);

		ServiceTracker
			<TicketFieldOptionPersistence, TicketFieldOptionPersistence>
				serviceTracker =
					new ServiceTracker
						<TicketFieldOptionPersistence,
						 TicketFieldOptionPersistence>(
							 bundle.getBundleContext(),
							 TicketFieldOptionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}