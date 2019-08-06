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
import com.liferay.yithro.ticket.model.TicketFieldData;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket field data service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketFieldDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldDataPersistence
 * @generated
 */
@ProviderType
public class TicketFieldDataUtil {

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
	public static void clearCache(TicketFieldData ticketFieldData) {
		getPersistence().clearCache(ticketFieldData);
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
	public static Map<Serializable, TicketFieldData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketFieldData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketFieldData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketFieldData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketFieldData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketFieldData update(TicketFieldData ticketFieldData) {
		return getPersistence().update(ticketFieldData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketFieldData update(
		TicketFieldData ticketFieldData, ServiceContext serviceContext) {

		return getPersistence().update(ticketFieldData, serviceContext);
	}

	/**
	 * Returns all the ticket field datas where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket field datas
	 */
	public static List<TicketFieldData> findByTicketEntryId(
		long ticketEntryId) {

		return getPersistence().findByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns a range of all the ticket field datas where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @return the range of matching ticket field datas
	 */
	public static List<TicketFieldData> findByTicketEntryId(
		long ticketEntryId, int start, int end) {

		return getPersistence().findByTicketEntryId(ticketEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket field datas where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket field datas
	 */
	public static List<TicketFieldData> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketFieldData> orderByComparator) {

		return getPersistence().findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket field datas where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket field datas
	 */
	public static List<TicketFieldData> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketFieldData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field data
	 * @throws NoSuchTicketFieldDataException if a matching ticket field data could not be found
	 */
	public static TicketFieldData findByTicketEntryId_First(
			long ticketEntryId,
			OrderByComparator<TicketFieldData> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldDataException {

		return getPersistence().findByTicketEntryId_First(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the first ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field data, or <code>null</code> if a matching ticket field data could not be found
	 */
	public static TicketFieldData fetchByTicketEntryId_First(
		long ticketEntryId,
		OrderByComparator<TicketFieldData> orderByComparator) {

		return getPersistence().fetchByTicketEntryId_First(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field data
	 * @throws NoSuchTicketFieldDataException if a matching ticket field data could not be found
	 */
	public static TicketFieldData findByTicketEntryId_Last(
			long ticketEntryId,
			OrderByComparator<TicketFieldData> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldDataException {

		return getPersistence().findByTicketEntryId_Last(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field data, or <code>null</code> if a matching ticket field data could not be found
	 */
	public static TicketFieldData fetchByTicketEntryId_Last(
		long ticketEntryId,
		OrderByComparator<TicketFieldData> orderByComparator) {

		return getPersistence().fetchByTicketEntryId_Last(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the ticket field datas before and after the current ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketFieldDataId the primary key of the current ticket field data
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field data
	 * @throws NoSuchTicketFieldDataException if a ticket field data with the primary key could not be found
	 */
	public static TicketFieldData[] findByTicketEntryId_PrevAndNext(
			long ticketFieldDataId, long ticketEntryId,
			OrderByComparator<TicketFieldData> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldDataException {

		return getPersistence().findByTicketEntryId_PrevAndNext(
			ticketFieldDataId, ticketEntryId, orderByComparator);
	}

	/**
	 * Removes all the ticket field datas where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	public static void removeByTicketEntryId(long ticketEntryId) {
		getPersistence().removeByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns the number of ticket field datas where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket field datas
	 */
	public static int countByTicketEntryId(long ticketEntryId) {
		return getPersistence().countByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns the ticket field data where ticketEntryId = &#63; and ticketFieldId = &#63; or throws a <code>NoSuchTicketFieldDataException</code> if it could not be found.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket field data
	 * @throws NoSuchTicketFieldDataException if a matching ticket field data could not be found
	 */
	public static TicketFieldData findByTEI_TFI(
			long ticketEntryId, long ticketFieldId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldDataException {

		return getPersistence().findByTEI_TFI(ticketEntryId, ticketFieldId);
	}

	/**
	 * Returns the ticket field data where ticketEntryId = &#63; and ticketFieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket field data, or <code>null</code> if a matching ticket field data could not be found
	 */
	public static TicketFieldData fetchByTEI_TFI(
		long ticketEntryId, long ticketFieldId) {

		return getPersistence().fetchByTEI_TFI(ticketEntryId, ticketFieldId);
	}

	/**
	 * Returns the ticket field data where ticketEntryId = &#63; and ticketFieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket field data, or <code>null</code> if a matching ticket field data could not be found
	 */
	public static TicketFieldData fetchByTEI_TFI(
		long ticketEntryId, long ticketFieldId, boolean useFinderCache) {

		return getPersistence().fetchByTEI_TFI(
			ticketEntryId, ticketFieldId, useFinderCache);
	}

	/**
	 * Removes the ticket field data where ticketEntryId = &#63; and ticketFieldId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the ticket field data that was removed
	 */
	public static TicketFieldData removeByTEI_TFI(
			long ticketEntryId, long ticketFieldId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldDataException {

		return getPersistence().removeByTEI_TFI(ticketEntryId, ticketFieldId);
	}

	/**
	 * Returns the number of ticket field datas where ticketEntryId = &#63; and ticketFieldId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the number of matching ticket field datas
	 */
	public static int countByTEI_TFI(long ticketEntryId, long ticketFieldId) {
		return getPersistence().countByTEI_TFI(ticketEntryId, ticketFieldId);
	}

	/**
	 * Caches the ticket field data in the entity cache if it is enabled.
	 *
	 * @param ticketFieldData the ticket field data
	 */
	public static void cacheResult(TicketFieldData ticketFieldData) {
		getPersistence().cacheResult(ticketFieldData);
	}

	/**
	 * Caches the ticket field datas in the entity cache if it is enabled.
	 *
	 * @param ticketFieldDatas the ticket field datas
	 */
	public static void cacheResult(List<TicketFieldData> ticketFieldDatas) {
		getPersistence().cacheResult(ticketFieldDatas);
	}

	/**
	 * Creates a new ticket field data with the primary key. Does not add the ticket field data to the database.
	 *
	 * @param ticketFieldDataId the primary key for the new ticket field data
	 * @return the new ticket field data
	 */
	public static TicketFieldData create(long ticketFieldDataId) {
		return getPersistence().create(ticketFieldDataId);
	}

	/**
	 * Removes the ticket field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data that was removed
	 * @throws NoSuchTicketFieldDataException if a ticket field data with the primary key could not be found
	 */
	public static TicketFieldData remove(long ticketFieldDataId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldDataException {

		return getPersistence().remove(ticketFieldDataId);
	}

	public static TicketFieldData updateImpl(TicketFieldData ticketFieldData) {
		return getPersistence().updateImpl(ticketFieldData);
	}

	/**
	 * Returns the ticket field data with the primary key or throws a <code>NoSuchTicketFieldDataException</code> if it could not be found.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data
	 * @throws NoSuchTicketFieldDataException if a ticket field data with the primary key could not be found
	 */
	public static TicketFieldData findByPrimaryKey(long ticketFieldDataId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketFieldDataException {

		return getPersistence().findByPrimaryKey(ticketFieldDataId);
	}

	/**
	 * Returns the ticket field data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data, or <code>null</code> if a ticket field data with the primary key could not be found
	 */
	public static TicketFieldData fetchByPrimaryKey(long ticketFieldDataId) {
		return getPersistence().fetchByPrimaryKey(ticketFieldDataId);
	}

	/**
	 * Returns all the ticket field datas.
	 *
	 * @return the ticket field datas
	 */
	public static List<TicketFieldData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @return the range of ticket field datas
	 */
	public static List<TicketFieldData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket field datas
	 */
	public static List<TicketFieldData> findAll(
		int start, int end,
		OrderByComparator<TicketFieldData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket field datas
	 */
	public static List<TicketFieldData> findAll(
		int start, int end,
		OrderByComparator<TicketFieldData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket field datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket field datas.
	 *
	 * @return the number of ticket field datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketFieldDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketFieldDataPersistence, TicketFieldDataPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketFieldDataPersistence.class);

		ServiceTracker<TicketFieldDataPersistence, TicketFieldDataPersistence>
			serviceTracker =
				new ServiceTracker
					<TicketFieldDataPersistence, TicketFieldDataPersistence>(
						bundle.getBundleContext(),
						TicketFieldDataPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}