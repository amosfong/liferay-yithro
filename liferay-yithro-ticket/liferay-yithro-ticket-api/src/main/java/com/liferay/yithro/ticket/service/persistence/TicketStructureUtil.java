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
import com.liferay.yithro.ticket.model.TicketStructure;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket structure service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketStructurePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketStructurePersistence
 * @generated
 */
@ProviderType
public class TicketStructureUtil {

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
	public static void clearCache(TicketStructure ticketStructure) {
		getPersistence().clearCache(ticketStructure);
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
	public static Map<Serializable, TicketStructure> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketStructure> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketStructure> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketStructure update(TicketStructure ticketStructure) {
		return getPersistence().update(ticketStructure);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketStructure update(
		TicketStructure ticketStructure, ServiceContext serviceContext) {

		return getPersistence().update(ticketStructure, serviceContext);
	}

	/**
	 * Caches the ticket structure in the entity cache if it is enabled.
	 *
	 * @param ticketStructure the ticket structure
	 */
	public static void cacheResult(TicketStructure ticketStructure) {
		getPersistence().cacheResult(ticketStructure);
	}

	/**
	 * Caches the ticket structures in the entity cache if it is enabled.
	 *
	 * @param ticketStructures the ticket structures
	 */
	public static void cacheResult(List<TicketStructure> ticketStructures) {
		getPersistence().cacheResult(ticketStructures);
	}

	/**
	 * Creates a new ticket structure with the primary key. Does not add the ticket structure to the database.
	 *
	 * @param ticketStructureId the primary key for the new ticket structure
	 * @return the new ticket structure
	 */
	public static TicketStructure create(long ticketStructureId) {
		return getPersistence().create(ticketStructureId);
	}

	/**
	 * Removes the ticket structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure that was removed
	 * @throws NoSuchTicketStructureException if a ticket structure with the primary key could not be found
	 */
	public static TicketStructure remove(long ticketStructureId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketStructureException {

		return getPersistence().remove(ticketStructureId);
	}

	public static TicketStructure updateImpl(TicketStructure ticketStructure) {
		return getPersistence().updateImpl(ticketStructure);
	}

	/**
	 * Returns the ticket structure with the primary key or throws a <code>NoSuchTicketStructureException</code> if it could not be found.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure
	 * @throws NoSuchTicketStructureException if a ticket structure with the primary key could not be found
	 */
	public static TicketStructure findByPrimaryKey(long ticketStructureId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketStructureException {

		return getPersistence().findByPrimaryKey(ticketStructureId);
	}

	/**
	 * Returns the ticket structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure, or <code>null</code> if a ticket structure with the primary key could not be found
	 */
	public static TicketStructure fetchByPrimaryKey(long ticketStructureId) {
		return getPersistence().fetchByPrimaryKey(ticketStructureId);
	}

	/**
	 * Returns all the ticket structures.
	 *
	 * @return the ticket structures
	 */
	public static List<TicketStructure> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @return the range of ticket structures
	 */
	public static List<TicketStructure> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket structures
	 */
	public static List<TicketStructure> findAll(
		int start, int end,
		OrderByComparator<TicketStructure> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket structures
	 */
	public static List<TicketStructure> findAll(
		int start, int end,
		OrderByComparator<TicketStructure> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket structures from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket structures.
	 *
	 * @return the number of ticket structures
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketStructurePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketStructurePersistence, TicketStructurePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketStructurePersistence.class);

		ServiceTracker<TicketStructurePersistence, TicketStructurePersistence>
			serviceTracker =
				new ServiceTracker
					<TicketStructurePersistence, TicketStructurePersistence>(
						bundle.getBundleContext(),
						TicketStructurePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}