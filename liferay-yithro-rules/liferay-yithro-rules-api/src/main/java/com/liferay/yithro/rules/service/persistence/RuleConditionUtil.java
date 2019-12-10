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
import com.liferay.yithro.rules.model.RuleCondition;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rule condition service. This utility wraps <code>com.liferay.yithro.rules.service.persistence.impl.RuleConditionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleConditionPersistence
 * @generated
 */
public class RuleConditionUtil {

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
	public static void clearCache(RuleCondition ruleCondition) {
		getPersistence().clearCache(ruleCondition);
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
	public static Map<Serializable, RuleCondition> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RuleCondition> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RuleCondition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RuleCondition> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RuleCondition> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RuleCondition update(RuleCondition ruleCondition) {
		return getPersistence().update(ruleCondition);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RuleCondition update(
		RuleCondition ruleCondition, ServiceContext serviceContext) {

		return getPersistence().update(ruleCondition, serviceContext);
	}

	/**
	 * Returns all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the matching rule conditions
	 */
	public static List<RuleCondition> findByR_T(long ruleId, String type) {
		return getPersistence().findByR_T(ruleId, type);
	}

	/**
	 * Returns a range of all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @return the range of matching rule conditions
	 */
	public static List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end) {

		return getPersistence().findByR_T(ruleId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule conditions
	 */
	public static List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end,
		OrderByComparator<RuleCondition> orderByComparator) {

		return getPersistence().findByR_T(
			ruleId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rule conditions
	 */
	public static List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end,
		OrderByComparator<RuleCondition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByR_T(
			ruleId, type, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule condition
	 * @throws NoSuchRuleConditionException if a matching rule condition could not be found
	 */
	public static RuleCondition findByR_T_First(
			long ruleId, String type,
			OrderByComparator<RuleCondition> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleConditionException {

		return getPersistence().findByR_T_First(
			ruleId, type, orderByComparator);
	}

	/**
	 * Returns the first rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule condition, or <code>null</code> if a matching rule condition could not be found
	 */
	public static RuleCondition fetchByR_T_First(
		long ruleId, String type,
		OrderByComparator<RuleCondition> orderByComparator) {

		return getPersistence().fetchByR_T_First(
			ruleId, type, orderByComparator);
	}

	/**
	 * Returns the last rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule condition
	 * @throws NoSuchRuleConditionException if a matching rule condition could not be found
	 */
	public static RuleCondition findByR_T_Last(
			long ruleId, String type,
			OrderByComparator<RuleCondition> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleConditionException {

		return getPersistence().findByR_T_Last(ruleId, type, orderByComparator);
	}

	/**
	 * Returns the last rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule condition, or <code>null</code> if a matching rule condition could not be found
	 */
	public static RuleCondition fetchByR_T_Last(
		long ruleId, String type,
		OrderByComparator<RuleCondition> orderByComparator) {

		return getPersistence().fetchByR_T_Last(
			ruleId, type, orderByComparator);
	}

	/**
	 * Returns the rule conditions before and after the current rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleConditionId the primary key of the current rule condition
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule condition
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	public static RuleCondition[] findByR_T_PrevAndNext(
			long ruleConditionId, long ruleId, String type,
			OrderByComparator<RuleCondition> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleConditionException {

		return getPersistence().findByR_T_PrevAndNext(
			ruleConditionId, ruleId, type, orderByComparator);
	}

	/**
	 * Removes all the rule conditions where ruleId = &#63; and type = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 */
	public static void removeByR_T(long ruleId, String type) {
		getPersistence().removeByR_T(ruleId, type);
	}

	/**
	 * Returns the number of rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the number of matching rule conditions
	 */
	public static int countByR_T(long ruleId, String type) {
		return getPersistence().countByR_T(ruleId, type);
	}

	/**
	 * Caches the rule condition in the entity cache if it is enabled.
	 *
	 * @param ruleCondition the rule condition
	 */
	public static void cacheResult(RuleCondition ruleCondition) {
		getPersistence().cacheResult(ruleCondition);
	}

	/**
	 * Caches the rule conditions in the entity cache if it is enabled.
	 *
	 * @param ruleConditions the rule conditions
	 */
	public static void cacheResult(List<RuleCondition> ruleConditions) {
		getPersistence().cacheResult(ruleConditions);
	}

	/**
	 * Creates a new rule condition with the primary key. Does not add the rule condition to the database.
	 *
	 * @param ruleConditionId the primary key for the new rule condition
	 * @return the new rule condition
	 */
	public static RuleCondition create(long ruleConditionId) {
		return getPersistence().create(ruleConditionId);
	}

	/**
	 * Removes the rule condition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition that was removed
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	public static RuleCondition remove(long ruleConditionId)
		throws com.liferay.yithro.rules.exception.NoSuchRuleConditionException {

		return getPersistence().remove(ruleConditionId);
	}

	public static RuleCondition updateImpl(RuleCondition ruleCondition) {
		return getPersistence().updateImpl(ruleCondition);
	}

	/**
	 * Returns the rule condition with the primary key or throws a <code>NoSuchRuleConditionException</code> if it could not be found.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	public static RuleCondition findByPrimaryKey(long ruleConditionId)
		throws com.liferay.yithro.rules.exception.NoSuchRuleConditionException {

		return getPersistence().findByPrimaryKey(ruleConditionId);
	}

	/**
	 * Returns the rule condition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition, or <code>null</code> if a rule condition with the primary key could not be found
	 */
	public static RuleCondition fetchByPrimaryKey(long ruleConditionId) {
		return getPersistence().fetchByPrimaryKey(ruleConditionId);
	}

	/**
	 * Returns all the rule conditions.
	 *
	 * @return the rule conditions
	 */
	public static List<RuleCondition> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rule conditions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @return the range of rule conditions
	 */
	public static List<RuleCondition> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rule conditions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rule conditions
	 */
	public static List<RuleCondition> findAll(
		int start, int end,
		OrderByComparator<RuleCondition> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rule conditions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rule conditions
	 */
	public static List<RuleCondition> findAll(
		int start, int end, OrderByComparator<RuleCondition> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rule conditions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rule conditions.
	 *
	 * @return the number of rule conditions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RuleConditionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RuleConditionPersistence, RuleConditionPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RuleConditionPersistence.class);

		ServiceTracker<RuleConditionPersistence, RuleConditionPersistence>
			serviceTracker =
				new ServiceTracker
					<RuleConditionPersistence, RuleConditionPersistence>(
						bundle.getBundleContext(),
						RuleConditionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}