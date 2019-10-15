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

package com.liferay.yithro.support.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.support.model.SupportLabor;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the support labor service. This utility wraps <code>com.liferay.yithro.support.service.persistence.impl.SupportLaborPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportLaborPersistence
 * @generated
 */
public class SupportLaborUtil {

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
	public static void clearCache(SupportLabor supportLabor) {
		getPersistence().clearCache(supportLabor);
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
	public static Map<Serializable, SupportLabor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SupportLabor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SupportLabor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SupportLabor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SupportLabor> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SupportLabor update(SupportLabor supportLabor) {
		return getPersistence().update(supportLabor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SupportLabor update(
		SupportLabor supportLabor, ServiceContext serviceContext) {

		return getPersistence().update(supportLabor, serviceContext);
	}

	/**
	 * Caches the support labor in the entity cache if it is enabled.
	 *
	 * @param supportLabor the support labor
	 */
	public static void cacheResult(SupportLabor supportLabor) {
		getPersistence().cacheResult(supportLabor);
	}

	/**
	 * Caches the support labors in the entity cache if it is enabled.
	 *
	 * @param supportLabors the support labors
	 */
	public static void cacheResult(List<SupportLabor> supportLabors) {
		getPersistence().cacheResult(supportLabors);
	}

	/**
	 * Creates a new support labor with the primary key. Does not add the support labor to the database.
	 *
	 * @param supportLaborId the primary key for the new support labor
	 * @return the new support labor
	 */
	public static SupportLabor create(long supportLaborId) {
		return getPersistence().create(supportLaborId);
	}

	/**
	 * Removes the support labor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor that was removed
	 * @throws NoSuchSupportLaborException if a support labor with the primary key could not be found
	 */
	public static SupportLabor remove(long supportLaborId)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportLaborException {

		return getPersistence().remove(supportLaborId);
	}

	public static SupportLabor updateImpl(SupportLabor supportLabor) {
		return getPersistence().updateImpl(supportLabor);
	}

	/**
	 * Returns the support labor with the primary key or throws a <code>NoSuchSupportLaborException</code> if it could not be found.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor
	 * @throws NoSuchSupportLaborException if a support labor with the primary key could not be found
	 */
	public static SupportLabor findByPrimaryKey(long supportLaborId)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportLaborException {

		return getPersistence().findByPrimaryKey(supportLaborId);
	}

	/**
	 * Returns the support labor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor, or <code>null</code> if a support labor with the primary key could not be found
	 */
	public static SupportLabor fetchByPrimaryKey(long supportLaborId) {
		return getPersistence().fetchByPrimaryKey(supportLaborId);
	}

	/**
	 * Returns all the support labors.
	 *
	 * @return the support labors
	 */
	public static List<SupportLabor> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the support labors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLaborModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support labors
	 * @param end the upper bound of the range of support labors (not inclusive)
	 * @return the range of support labors
	 */
	public static List<SupportLabor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the support labors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLaborModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support labors
	 * @param end the upper bound of the range of support labors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support labors
	 */
	public static List<SupportLabor> findAll(
		int start, int end, OrderByComparator<SupportLabor> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support labors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLaborModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support labors
	 * @param end the upper bound of the range of support labors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of support labors
	 */
	public static List<SupportLabor> findAll(
		int start, int end, OrderByComparator<SupportLabor> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the support labors from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of support labors.
	 *
	 * @return the number of support labors
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SupportLaborPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SupportLaborPersistence, SupportLaborPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SupportLaborPersistence.class);

		ServiceTracker<SupportLaborPersistence, SupportLaborPersistence>
			serviceTracker =
				new ServiceTracker
					<SupportLaborPersistence, SupportLaborPersistence>(
						bundle.getBundleContext(),
						SupportLaborPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}