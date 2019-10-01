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
import com.liferay.yithro.ticket.model.TicketStatus;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket status service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketStatusPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketStatusPersistence
 * @generated
 */
public class TicketStatusUtil {

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
	public static void clearCache(TicketStatus ticketStatus) {
		getPersistence().clearCache(ticketStatus);
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
	public static Map<Serializable, TicketStatus> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketStatus> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketStatus update(TicketStatus ticketStatus) {
		return getPersistence().update(ticketStatus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketStatus update(
		TicketStatus ticketStatus, ServiceContext serviceContext) {

		return getPersistence().update(ticketStatus, serviceContext);
	}

	/**
	 * Returns all the ticket statuses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ticket statuses
	 */
	public static List<TicketStatus> findByS(int status) {
		return getPersistence().findByS(status);
	}

	/**
	 * Returns a range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of matching ticket statuses
	 */
	public static List<TicketStatus> findByS(int status, int start, int end) {
		return getPersistence().findByS(status, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket statuses
	 */
	public static List<TicketStatus> findByS(
		int status, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator) {

		return getPersistence().findByS(status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket statuses
	 */
	public static List<TicketStatus> findByS(
		int status, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByS(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	public static TicketStatus findByS_First(
			int status, OrderByComparator<TicketStatus> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketStatusException {

		return getPersistence().findByS_First(status, orderByComparator);
	}

	/**
	 * Returns the first ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	public static TicketStatus fetchByS_First(
		int status, OrderByComparator<TicketStatus> orderByComparator) {

		return getPersistence().fetchByS_First(status, orderByComparator);
	}

	/**
	 * Returns the last ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	public static TicketStatus findByS_Last(
			int status, OrderByComparator<TicketStatus> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketStatusException {

		return getPersistence().findByS_Last(status, orderByComparator);
	}

	/**
	 * Returns the last ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	public static TicketStatus fetchByS_Last(
		int status, OrderByComparator<TicketStatus> orderByComparator) {

		return getPersistence().fetchByS_Last(status, orderByComparator);
	}

	/**
	 * Returns the ticket statuses before and after the current ticket status in the ordered set where status = &#63;.
	 *
	 * @param ticketStatusId the primary key of the current ticket status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	public static TicketStatus[] findByS_PrevAndNext(
			long ticketStatusId, int status,
			OrderByComparator<TicketStatus> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketStatusException {

		return getPersistence().findByS_PrevAndNext(
			ticketStatusId, status, orderByComparator);
	}

	/**
	 * Removes all the ticket statuses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByS(int status) {
		getPersistence().removeByS(status);
	}

	/**
	 * Returns the number of ticket statuses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ticket statuses
	 */
	public static int countByS(int status) {
		return getPersistence().countByS(status);
	}

	/**
	 * Returns all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @return the matching ticket statuses
	 */
	public static List<TicketStatus> findByT_S(boolean terminal, int status) {
		return getPersistence().findByT_S(terminal, status);
	}

	/**
	 * Returns a range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of matching ticket statuses
	 */
	public static List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end) {

		return getPersistence().findByT_S(terminal, status, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket statuses
	 */
	public static List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator) {

		return getPersistence().findByT_S(
			terminal, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket statuses
	 */
	public static List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByT_S(
			terminal, status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	public static TicketStatus findByT_S_First(
			boolean terminal, int status,
			OrderByComparator<TicketStatus> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketStatusException {

		return getPersistence().findByT_S_First(
			terminal, status, orderByComparator);
	}

	/**
	 * Returns the first ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	public static TicketStatus fetchByT_S_First(
		boolean terminal, int status,
		OrderByComparator<TicketStatus> orderByComparator) {

		return getPersistence().fetchByT_S_First(
			terminal, status, orderByComparator);
	}

	/**
	 * Returns the last ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	public static TicketStatus findByT_S_Last(
			boolean terminal, int status,
			OrderByComparator<TicketStatus> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketStatusException {

		return getPersistence().findByT_S_Last(
			terminal, status, orderByComparator);
	}

	/**
	 * Returns the last ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	public static TicketStatus fetchByT_S_Last(
		boolean terminal, int status,
		OrderByComparator<TicketStatus> orderByComparator) {

		return getPersistence().fetchByT_S_Last(
			terminal, status, orderByComparator);
	}

	/**
	 * Returns the ticket statuses before and after the current ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param ticketStatusId the primary key of the current ticket status
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	public static TicketStatus[] findByT_S_PrevAndNext(
			long ticketStatusId, boolean terminal, int status,
			OrderByComparator<TicketStatus> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketStatusException {

		return getPersistence().findByT_S_PrevAndNext(
			ticketStatusId, terminal, status, orderByComparator);
	}

	/**
	 * Removes all the ticket statuses where terminal = &#63; and status = &#63; from the database.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 */
	public static void removeByT_S(boolean terminal, int status) {
		getPersistence().removeByT_S(terminal, status);
	}

	/**
	 * Returns the number of ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @return the number of matching ticket statuses
	 */
	public static int countByT_S(boolean terminal, int status) {
		return getPersistence().countByT_S(terminal, status);
	}

	/**
	 * Caches the ticket status in the entity cache if it is enabled.
	 *
	 * @param ticketStatus the ticket status
	 */
	public static void cacheResult(TicketStatus ticketStatus) {
		getPersistence().cacheResult(ticketStatus);
	}

	/**
	 * Caches the ticket statuses in the entity cache if it is enabled.
	 *
	 * @param ticketStatuses the ticket statuses
	 */
	public static void cacheResult(List<TicketStatus> ticketStatuses) {
		getPersistence().cacheResult(ticketStatuses);
	}

	/**
	 * Creates a new ticket status with the primary key. Does not add the ticket status to the database.
	 *
	 * @param ticketStatusId the primary key for the new ticket status
	 * @return the new ticket status
	 */
	public static TicketStatus create(long ticketStatusId) {
		return getPersistence().create(ticketStatusId);
	}

	/**
	 * Removes the ticket status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status that was removed
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	public static TicketStatus remove(long ticketStatusId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketStatusException {

		return getPersistence().remove(ticketStatusId);
	}

	public static TicketStatus updateImpl(TicketStatus ticketStatus) {
		return getPersistence().updateImpl(ticketStatus);
	}

	/**
	 * Returns the ticket status with the primary key or throws a <code>NoSuchTicketStatusException</code> if it could not be found.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	public static TicketStatus findByPrimaryKey(long ticketStatusId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketStatusException {

		return getPersistence().findByPrimaryKey(ticketStatusId);
	}

	/**
	 * Returns the ticket status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status, or <code>null</code> if a ticket status with the primary key could not be found
	 */
	public static TicketStatus fetchByPrimaryKey(long ticketStatusId) {
		return getPersistence().fetchByPrimaryKey(ticketStatusId);
	}

	/**
	 * Returns all the ticket statuses.
	 *
	 * @return the ticket statuses
	 */
	public static List<TicketStatus> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of ticket statuses
	 */
	public static List<TicketStatus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket statuses
	 */
	public static List<TicketStatus> findAll(
		int start, int end, OrderByComparator<TicketStatus> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket statuses
	 */
	public static List<TicketStatus> findAll(
		int start, int end, OrderByComparator<TicketStatus> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket statuses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket statuses.
	 *
	 * @return the number of ticket statuses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketStatusPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketStatusPersistence, TicketStatusPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketStatusPersistence.class);

		ServiceTracker<TicketStatusPersistence, TicketStatusPersistence>
			serviceTracker =
				new ServiceTracker
					<TicketStatusPersistence, TicketStatusPersistence>(
						bundle.getBundleContext(),
						TicketStatusPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}