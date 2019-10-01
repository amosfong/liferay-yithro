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
import com.liferay.yithro.support.model.SupportLevelAgreement;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the support level agreement service. This utility wraps <code>com.liferay.yithro.support.service.persistence.impl.SupportLevelAgreementPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportLevelAgreementPersistence
 * @generated
 */
public class SupportLevelAgreementUtil {

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
	public static void clearCache(SupportLevelAgreement supportLevelAgreement) {
		getPersistence().clearCache(supportLevelAgreement);
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
	public static Map<Serializable, SupportLevelAgreement> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SupportLevelAgreement> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SupportLevelAgreement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SupportLevelAgreement> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SupportLevelAgreement> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SupportLevelAgreement update(
		SupportLevelAgreement supportLevelAgreement) {

		return getPersistence().update(supportLevelAgreement);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SupportLevelAgreement update(
		SupportLevelAgreement supportLevelAgreement,
		ServiceContext serviceContext) {

		return getPersistence().update(supportLevelAgreement, serviceContext);
	}

	/**
	 * Returns the support level agreement where name = &#63; or throws a <code>NoSuchSupportLevelAgreementException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching support level agreement
	 * @throws NoSuchSupportLevelAgreementException if a matching support level agreement could not be found
	 */
	public static SupportLevelAgreement findByName(String name)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportLevelAgreementException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the support level agreement where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching support level agreement, or <code>null</code> if a matching support level agreement could not be found
	 */
	public static SupportLevelAgreement fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the support level agreement where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching support level agreement, or <code>null</code> if a matching support level agreement could not be found
	 */
	public static SupportLevelAgreement fetchByName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the support level agreement where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the support level agreement that was removed
	 */
	public static SupportLevelAgreement removeByName(String name)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportLevelAgreementException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of support level agreements where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching support level agreements
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the support level agreement in the entity cache if it is enabled.
	 *
	 * @param supportLevelAgreement the support level agreement
	 */
	public static void cacheResult(
		SupportLevelAgreement supportLevelAgreement) {

		getPersistence().cacheResult(supportLevelAgreement);
	}

	/**
	 * Caches the support level agreements in the entity cache if it is enabled.
	 *
	 * @param supportLevelAgreements the support level agreements
	 */
	public static void cacheResult(
		List<SupportLevelAgreement> supportLevelAgreements) {

		getPersistence().cacheResult(supportLevelAgreements);
	}

	/**
	 * Creates a new support level agreement with the primary key. Does not add the support level agreement to the database.
	 *
	 * @param supportLevelAgreementId the primary key for the new support level agreement
	 * @return the new support level agreement
	 */
	public static SupportLevelAgreement create(long supportLevelAgreementId) {
		return getPersistence().create(supportLevelAgreementId);
	}

	/**
	 * Removes the support level agreement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement that was removed
	 * @throws NoSuchSupportLevelAgreementException if a support level agreement with the primary key could not be found
	 */
	public static SupportLevelAgreement remove(long supportLevelAgreementId)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportLevelAgreementException {

		return getPersistence().remove(supportLevelAgreementId);
	}

	public static SupportLevelAgreement updateImpl(
		SupportLevelAgreement supportLevelAgreement) {

		return getPersistence().updateImpl(supportLevelAgreement);
	}

	/**
	 * Returns the support level agreement with the primary key or throws a <code>NoSuchSupportLevelAgreementException</code> if it could not be found.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement
	 * @throws NoSuchSupportLevelAgreementException if a support level agreement with the primary key could not be found
	 */
	public static SupportLevelAgreement findByPrimaryKey(
			long supportLevelAgreementId)
		throws com.liferay.yithro.support.exception.
			NoSuchSupportLevelAgreementException {

		return getPersistence().findByPrimaryKey(supportLevelAgreementId);
	}

	/**
	 * Returns the support level agreement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement, or <code>null</code> if a support level agreement with the primary key could not be found
	 */
	public static SupportLevelAgreement fetchByPrimaryKey(
		long supportLevelAgreementId) {

		return getPersistence().fetchByPrimaryKey(supportLevelAgreementId);
	}

	/**
	 * Returns all the support level agreements.
	 *
	 * @return the support level agreements
	 */
	public static List<SupportLevelAgreement> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @return the range of support level agreements
	 */
	public static List<SupportLevelAgreement> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support level agreements
	 */
	public static List<SupportLevelAgreement> findAll(
		int start, int end,
		OrderByComparator<SupportLevelAgreement> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of support level agreements
	 */
	public static List<SupportLevelAgreement> findAll(
		int start, int end,
		OrderByComparator<SupportLevelAgreement> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the support level agreements from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of support level agreements.
	 *
	 * @return the number of support level agreements
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SupportLevelAgreementPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SupportLevelAgreementPersistence, SupportLevelAgreementPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SupportLevelAgreementPersistence.class);

		ServiceTracker
			<SupportLevelAgreementPersistence, SupportLevelAgreementPersistence>
				serviceTracker =
					new ServiceTracker
						<SupportLevelAgreementPersistence,
						 SupportLevelAgreementPersistence>(
							 bundle.getBundleContext(),
							 SupportLevelAgreementPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}