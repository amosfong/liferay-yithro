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
import com.liferay.yithro.rules.model.RuleAction;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rule action service. This utility wraps <code>com.liferay.yithro.rules.service.persistence.impl.RuleActionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionPersistence
 * @generated
 */
public class RuleActionUtil {

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
	public static void clearCache(RuleAction ruleAction) {
		getPersistence().clearCache(ruleAction);
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
	public static Map<Serializable, RuleAction> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<RuleAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<RuleAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<RuleAction> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<RuleAction> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static RuleAction update(RuleAction ruleAction) {
		return getPersistence().update(ruleAction);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static RuleAction update(
		RuleAction ruleAction, ServiceContext serviceContext) {

		return getPersistence().update(ruleAction, serviceContext);
	}

	/**
	 * Returns all the rule actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching rule actions
	 */
	public static List<RuleAction> findByRuleId(long ruleId) {
		return getPersistence().findByRuleId(ruleId);
	}

	/**
	 * Returns a range of all the rule actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @return the range of matching rule actions
	 */
	public static List<RuleAction> findByRuleId(
		long ruleId, int start, int end) {

		return getPersistence().findByRuleId(ruleId, start, end);
	}

	/**
	 * Returns an ordered range of all the rule actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule actions
	 */
	public static List<RuleAction> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<RuleAction> orderByComparator) {

		return getPersistence().findByRuleId(
			ruleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rule actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rule actions
	 */
	public static List<RuleAction> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<RuleAction> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByRuleId(
			ruleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action
	 * @throws NoSuchRuleActionException if a matching rule action could not be found
	 */
	public static RuleAction findByRuleId_First(
			long ruleId, OrderByComparator<RuleAction> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleActionException {

		return getPersistence().findByRuleId_First(ruleId, orderByComparator);
	}

	/**
	 * Returns the first rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action, or <code>null</code> if a matching rule action could not be found
	 */
	public static RuleAction fetchByRuleId_First(
		long ruleId, OrderByComparator<RuleAction> orderByComparator) {

		return getPersistence().fetchByRuleId_First(ruleId, orderByComparator);
	}

	/**
	 * Returns the last rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action
	 * @throws NoSuchRuleActionException if a matching rule action could not be found
	 */
	public static RuleAction findByRuleId_Last(
			long ruleId, OrderByComparator<RuleAction> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleActionException {

		return getPersistence().findByRuleId_Last(ruleId, orderByComparator);
	}

	/**
	 * Returns the last rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action, or <code>null</code> if a matching rule action could not be found
	 */
	public static RuleAction fetchByRuleId_Last(
		long ruleId, OrderByComparator<RuleAction> orderByComparator) {

		return getPersistence().fetchByRuleId_Last(ruleId, orderByComparator);
	}

	/**
	 * Returns the rule actions before and after the current rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleActionId the primary key of the current rule action
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule action
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	public static RuleAction[] findByRuleId_PrevAndNext(
			long ruleActionId, long ruleId,
			OrderByComparator<RuleAction> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleActionException {

		return getPersistence().findByRuleId_PrevAndNext(
			ruleActionId, ruleId, orderByComparator);
	}

	/**
	 * Removes all the rule actions where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 */
	public static void removeByRuleId(long ruleId) {
		getPersistence().removeByRuleId(ruleId);
	}

	/**
	 * Returns the number of rule actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching rule actions
	 */
	public static int countByRuleId(long ruleId) {
		return getPersistence().countByRuleId(ruleId);
	}

	/**
	 * Caches the rule action in the entity cache if it is enabled.
	 *
	 * @param ruleAction the rule action
	 */
	public static void cacheResult(RuleAction ruleAction) {
		getPersistence().cacheResult(ruleAction);
	}

	/**
	 * Caches the rule actions in the entity cache if it is enabled.
	 *
	 * @param ruleActions the rule actions
	 */
	public static void cacheResult(List<RuleAction> ruleActions) {
		getPersistence().cacheResult(ruleActions);
	}

	/**
	 * Creates a new rule action with the primary key. Does not add the rule action to the database.
	 *
	 * @param ruleActionId the primary key for the new rule action
	 * @return the new rule action
	 */
	public static RuleAction create(long ruleActionId) {
		return getPersistence().create(ruleActionId);
	}

	/**
	 * Removes the rule action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action that was removed
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	public static RuleAction remove(long ruleActionId)
		throws com.liferay.yithro.rules.exception.NoSuchRuleActionException {

		return getPersistence().remove(ruleActionId);
	}

	public static RuleAction updateImpl(RuleAction ruleAction) {
		return getPersistence().updateImpl(ruleAction);
	}

	/**
	 * Returns the rule action with the primary key or throws a <code>NoSuchRuleActionException</code> if it could not be found.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	public static RuleAction findByPrimaryKey(long ruleActionId)
		throws com.liferay.yithro.rules.exception.NoSuchRuleActionException {

		return getPersistence().findByPrimaryKey(ruleActionId);
	}

	/**
	 * Returns the rule action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action, or <code>null</code> if a rule action with the primary key could not be found
	 */
	public static RuleAction fetchByPrimaryKey(long ruleActionId) {
		return getPersistence().fetchByPrimaryKey(ruleActionId);
	}

	/**
	 * Returns all the rule actions.
	 *
	 * @return the rule actions
	 */
	public static List<RuleAction> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rule actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @return the range of rule actions
	 */
	public static List<RuleAction> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rule actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rule actions
	 */
	public static List<RuleAction> findAll(
		int start, int end, OrderByComparator<RuleAction> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rule actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rule actions
	 */
	public static List<RuleAction> findAll(
		int start, int end, OrderByComparator<RuleAction> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rule actions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rule actions.
	 *
	 * @return the number of rule actions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RuleActionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RuleActionPersistence, RuleActionPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RuleActionPersistence.class);

		ServiceTracker<RuleActionPersistence, RuleActionPersistence>
			serviceTracker =
				new ServiceTracker
					<RuleActionPersistence, RuleActionPersistence>(
						bundle.getBundleContext(), RuleActionPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}