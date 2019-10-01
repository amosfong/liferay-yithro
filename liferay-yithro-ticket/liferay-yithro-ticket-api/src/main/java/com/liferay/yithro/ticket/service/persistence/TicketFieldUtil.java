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
import com.liferay.yithro.ticket.model.TicketField;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket field service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketFieldPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldPersistence
 * @generated
 */
public class TicketFieldUtil {

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
	public static void clearCache(TicketField ticketField) {
		getPersistence().clearCache(ticketField);
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
	public static Map<Serializable, TicketField> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketField> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketField> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketField> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketField update(TicketField ticketField) {
		return getPersistence().update(ticketField);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketField update(
		TicketField ticketField, ServiceContext serviceContext) {

		return getPersistence().update(ticketField, serviceContext);
	}

	/**
	 * Returns the ticket field where systemKey = &#63; or throws a <code>NoSuchTicketFieldException</code> if it could not be found.
	 *
	 * @param systemKey the system key
	 * @return the matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	public static TicketField findBySystemKey(String systemKey)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFieldException {

		return getPersistence().findBySystemKey(systemKey);
	}

	/**
	 * Returns the ticket field where systemKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param systemKey the system key
	 * @return the matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	public static TicketField fetchBySystemKey(String systemKey) {
		return getPersistence().fetchBySystemKey(systemKey);
	}

	/**
	 * Returns the ticket field where systemKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param systemKey the system key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	public static TicketField fetchBySystemKey(
		String systemKey, boolean useFinderCache) {

		return getPersistence().fetchBySystemKey(systemKey, useFinderCache);
	}

	/**
	 * Removes the ticket field where systemKey = &#63; from the database.
	 *
	 * @param systemKey the system key
	 * @return the ticket field that was removed
	 */
	public static TicketField removeBySystemKey(String systemKey)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFieldException {

		return getPersistence().removeBySystemKey(systemKey);
	}

	/**
	 * Returns the number of ticket fields where systemKey = &#63;.
	 *
	 * @param systemKey the system key
	 * @return the number of matching ticket fields
	 */
	public static int countBySystemKey(String systemKey) {
		return getPersistence().countBySystemKey(systemKey);
	}

	/**
	 * Returns all the ticket fields where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ticket fields
	 */
	public static List<TicketField> findByStatus(int status) {
		return getPersistence().findByStatus(status);
	}

	/**
	 * Returns a range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @return the range of matching ticket fields
	 */
	public static List<TicketField> findByStatus(
		int status, int start, int end) {

		return getPersistence().findByStatus(status, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket fields
	 */
	public static List<TicketField> findByStatus(
		int status, int start, int end,
		OrderByComparator<TicketField> orderByComparator) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket fields
	 */
	public static List<TicketField> findByStatus(
		int status, int start, int end,
		OrderByComparator<TicketField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByStatus(
			status, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	public static TicketField findByStatus_First(
			int status, OrderByComparator<TicketField> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFieldException {

		return getPersistence().findByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the first ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	public static TicketField fetchByStatus_First(
		int status, OrderByComparator<TicketField> orderByComparator) {

		return getPersistence().fetchByStatus_First(status, orderByComparator);
	}

	/**
	 * Returns the last ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	public static TicketField findByStatus_Last(
			int status, OrderByComparator<TicketField> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFieldException {

		return getPersistence().findByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the last ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	public static TicketField fetchByStatus_Last(
		int status, OrderByComparator<TicketField> orderByComparator) {

		return getPersistence().fetchByStatus_Last(status, orderByComparator);
	}

	/**
	 * Returns the ticket fields before and after the current ticket field in the ordered set where status = &#63;.
	 *
	 * @param ticketFieldId the primary key of the current ticket field
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	public static TicketField[] findByStatus_PrevAndNext(
			long ticketFieldId, int status,
			OrderByComparator<TicketField> orderByComparator)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFieldException {

		return getPersistence().findByStatus_PrevAndNext(
			ticketFieldId, status, orderByComparator);
	}

	/**
	 * Removes all the ticket fields where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public static void removeByStatus(int status) {
		getPersistence().removeByStatus(status);
	}

	/**
	 * Returns the number of ticket fields where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ticket fields
	 */
	public static int countByStatus(int status) {
		return getPersistence().countByStatus(status);
	}

	/**
	 * Caches the ticket field in the entity cache if it is enabled.
	 *
	 * @param ticketField the ticket field
	 */
	public static void cacheResult(TicketField ticketField) {
		getPersistence().cacheResult(ticketField);
	}

	/**
	 * Caches the ticket fields in the entity cache if it is enabled.
	 *
	 * @param ticketFields the ticket fields
	 */
	public static void cacheResult(List<TicketField> ticketFields) {
		getPersistence().cacheResult(ticketFields);
	}

	/**
	 * Creates a new ticket field with the primary key. Does not add the ticket field to the database.
	 *
	 * @param ticketFieldId the primary key for the new ticket field
	 * @return the new ticket field
	 */
	public static TicketField create(long ticketFieldId) {
		return getPersistence().create(ticketFieldId);
	}

	/**
	 * Removes the ticket field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field that was removed
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	public static TicketField remove(long ticketFieldId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFieldException {

		return getPersistence().remove(ticketFieldId);
	}

	public static TicketField updateImpl(TicketField ticketField) {
		return getPersistence().updateImpl(ticketField);
	}

	/**
	 * Returns the ticket field with the primary key or throws a <code>NoSuchTicketFieldException</code> if it could not be found.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	public static TicketField findByPrimaryKey(long ticketFieldId)
		throws com.liferay.yithro.ticket.exception.NoSuchTicketFieldException {

		return getPersistence().findByPrimaryKey(ticketFieldId);
	}

	/**
	 * Returns the ticket field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field, or <code>null</code> if a ticket field with the primary key could not be found
	 */
	public static TicketField fetchByPrimaryKey(long ticketFieldId) {
		return getPersistence().fetchByPrimaryKey(ticketFieldId);
	}

	/**
	 * Returns all the ticket fields.
	 *
	 * @return the ticket fields
	 */
	public static List<TicketField> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @return the range of ticket fields
	 */
	public static List<TicketField> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket fields
	 */
	public static List<TicketField> findAll(
		int start, int end, OrderByComparator<TicketField> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket fields
	 */
	public static List<TicketField> findAll(
		int start, int end, OrderByComparator<TicketField> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket fields from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket fields.
	 *
	 * @return the number of ticket fields
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketFieldPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketFieldPersistence, TicketFieldPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketFieldPersistence.class);

		ServiceTracker<TicketFieldPersistence, TicketFieldPersistence>
			serviceTracker =
				new ServiceTracker
					<TicketFieldPersistence, TicketFieldPersistence>(
						bundle.getBundleContext(), TicketFieldPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}