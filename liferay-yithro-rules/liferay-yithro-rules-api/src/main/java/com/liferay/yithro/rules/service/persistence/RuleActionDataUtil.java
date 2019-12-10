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

package com.liferay.yithro.rules.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.rules.model.RuleActionData;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rule action data service. This utility wraps <code>com.liferay.yithro.rules.service.persistence.impl.RuleActionDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionDataPersistence
 * @generated
 */
public class RuleActionDataUtil {

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
	public static void clearCache(RuleActionData ruleActionData) {
		getPersistence().clearCache(ruleActionData);
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
	public static Map<Serializable, RuleActionData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RuleActionData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RuleActionData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RuleActionData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RuleActionData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RuleActionData update(RuleActionData ruleActionData) {
		return getPersistence().update(ruleActionData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RuleActionData update(
		RuleActionData ruleActionData, ServiceContext serviceContext) {

		return getPersistence().update(ruleActionData, serviceContext);
	}

	/**
	 * Returns all the rule action datas where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @return the matching rule action datas
	 */
	public static List<RuleActionData> findByRuleActionId(long ruleActionId) {
		return getPersistence().findByRuleActionId(ruleActionId);
	}

	/**
	 * Returns a range of all the rule action datas where ruleActionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param ruleActionId the rule action ID
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @return the range of matching rule action datas
	 */
	public static List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end) {

		return getPersistence().findByRuleActionId(ruleActionId, start, end);
	}

	/**
	 * Returns an ordered range of all the rule action datas where ruleActionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param ruleActionId the rule action ID
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule action datas
	 */
	public static List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end,
		OrderByComparator<RuleActionData> orderByComparator) {

		return getPersistence().findByRuleActionId(
			ruleActionId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rule action datas where ruleActionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param ruleActionId the rule action ID
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rule action datas
	 */
	public static List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end,
		OrderByComparator<RuleActionData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRuleActionId(
			ruleActionId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action data
	 * @throws NoSuchRuleActionDataException if a matching rule action data could not be found
	 */
	public static RuleActionData findByRuleActionId_First(
			long ruleActionId,
			OrderByComparator<RuleActionData> orderByComparator)
		throws com.liferay.yithro.rules.exception.
			NoSuchRuleActionDataException {

		return getPersistence().findByRuleActionId_First(
			ruleActionId, orderByComparator);
	}

	/**
	 * Returns the first rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action data, or <code>null</code> if a matching rule action data could not be found
	 */
	public static RuleActionData fetchByRuleActionId_First(
		long ruleActionId,
		OrderByComparator<RuleActionData> orderByComparator) {

		return getPersistence().fetchByRuleActionId_First(
			ruleActionId, orderByComparator);
	}

	/**
	 * Returns the last rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action data
	 * @throws NoSuchRuleActionDataException if a matching rule action data could not be found
	 */
	public static RuleActionData findByRuleActionId_Last(
			long ruleActionId,
			OrderByComparator<RuleActionData> orderByComparator)
		throws com.liferay.yithro.rules.exception.
			NoSuchRuleActionDataException {

		return getPersistence().findByRuleActionId_Last(
			ruleActionId, orderByComparator);
	}

	/**
	 * Returns the last rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action data, or <code>null</code> if a matching rule action data could not be found
	 */
	public static RuleActionData fetchByRuleActionId_Last(
		long ruleActionId,
		OrderByComparator<RuleActionData> orderByComparator) {

		return getPersistence().fetchByRuleActionId_Last(
			ruleActionId, orderByComparator);
	}

	/**
	 * Returns the rule action datas before and after the current rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionDataId the primary key of the current rule action data
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule action data
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	public static RuleActionData[] findByRuleActionId_PrevAndNext(
			long ruleActionDataId, long ruleActionId,
			OrderByComparator<RuleActionData> orderByComparator)
		throws com.liferay.yithro.rules.exception.
			NoSuchRuleActionDataException {

		return getPersistence().findByRuleActionId_PrevAndNext(
			ruleActionDataId, ruleActionId, orderByComparator);
	}

	/**
	 * Removes all the rule action datas where ruleActionId = &#63; from the database.
	 *
	 * @param ruleActionId the rule action ID
	 */
	public static void removeByRuleActionId(long ruleActionId) {
		getPersistence().removeByRuleActionId(ruleActionId);
	}

	/**
	 * Returns the number of rule action datas where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @return the number of matching rule action datas
	 */
	public static int countByRuleActionId(long ruleActionId) {
		return getPersistence().countByRuleActionId(ruleActionId);
	}

	/**
	 * Caches the rule action data in the entity cache if it is enabled.
	 *
	 * @param ruleActionData the rule action data
	 */
	public static void cacheResult(RuleActionData ruleActionData) {
		getPersistence().cacheResult(ruleActionData);
	}

	/**
	 * Caches the rule action datas in the entity cache if it is enabled.
	 *
	 * @param ruleActionDatas the rule action datas
	 */
	public static void cacheResult(List<RuleActionData> ruleActionDatas) {
		getPersistence().cacheResult(ruleActionDatas);
	}

	/**
	 * Creates a new rule action data with the primary key. Does not add the rule action data to the database.
	 *
	 * @param ruleActionDataId the primary key for the new rule action data
	 * @return the new rule action data
	 */
	public static RuleActionData create(long ruleActionDataId) {
		return getPersistence().create(ruleActionDataId);
	}

	/**
	 * Removes the rule action data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data that was removed
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	public static RuleActionData remove(long ruleActionDataId)
		throws com.liferay.yithro.rules.exception.
			NoSuchRuleActionDataException {

		return getPersistence().remove(ruleActionDataId);
	}

	public static RuleActionData updateImpl(RuleActionData ruleActionData) {
		return getPersistence().updateImpl(ruleActionData);
	}

	/**
	 * Returns the rule action data with the primary key or throws a <code>NoSuchRuleActionDataException</code> if it could not be found.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	public static RuleActionData findByPrimaryKey(long ruleActionDataId)
		throws com.liferay.yithro.rules.exception.
			NoSuchRuleActionDataException {

		return getPersistence().findByPrimaryKey(ruleActionDataId);
	}

	/**
	 * Returns the rule action data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data, or <code>null</code> if a rule action data with the primary key could not be found
	 */
	public static RuleActionData fetchByPrimaryKey(long ruleActionDataId) {
		return getPersistence().fetchByPrimaryKey(ruleActionDataId);
	}

	/**
	 * Returns all the rule action datas.
	 *
	 * @return the rule action datas
	 */
	public static List<RuleActionData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rule action datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @return the range of rule action datas
	 */
	public static List<RuleActionData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rule action datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rule action datas
	 */
	public static List<RuleActionData> findAll(
		int start, int end,
		OrderByComparator<RuleActionData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rule action datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rule action datas
	 */
	public static List<RuleActionData> findAll(
		int start, int end, OrderByComparator<RuleActionData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rule action datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rule action datas.
	 *
	 * @return the number of rule action datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RuleActionDataPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RuleActionDataPersistence, RuleActionDataPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RuleActionDataPersistence.class);

		ServiceTracker<RuleActionDataPersistence, RuleActionDataPersistence>
			serviceTracker =
				new ServiceTracker
					<RuleActionDataPersistence, RuleActionDataPersistence>(
						bundle.getBundleContext(),
						RuleActionDataPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}