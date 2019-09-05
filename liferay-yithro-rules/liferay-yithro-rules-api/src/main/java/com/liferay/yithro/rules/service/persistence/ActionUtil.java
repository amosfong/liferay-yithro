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
import com.liferay.yithro.rules.model.Action;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the action service. This utility wraps <code>com.liferay.yithro.rules.service.persistence.impl.ActionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActionPersistence
 * @generated
 */
@ProviderType
public class ActionUtil {

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
	public static void clearCache(Action action) {
		getPersistence().clearCache(action);
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
	public static Map<Serializable, Action> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Action> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Action> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Action> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Action> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Action update(Action action) {
		return getPersistence().update(action);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Action update(Action action, ServiceContext serviceContext) {
		return getPersistence().update(action, serviceContext);
	}

	/**
	 * Returns all the actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching actions
	 */
	public static List<Action> findByRuleId(long ruleId) {
		return getPersistence().findByRuleId(ruleId);
	}

	/**
	 * Returns a range of all the actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @return the range of matching actions
	 */
	public static List<Action> findByRuleId(long ruleId, int start, int end) {
		return getPersistence().findByRuleId(ruleId, start, end);
	}

	/**
	 * Returns an ordered range of all the actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actions
	 */
	public static List<Action> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<Action> orderByComparator) {

		return getPersistence().findByRuleId(
			ruleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actions
	 */
	public static List<Action> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<Action> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByRuleId(
			ruleId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action
	 * @throws NoSuchActionException if a matching action could not be found
	 */
	public static Action findByRuleId_First(
			long ruleId, OrderByComparator<Action> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchActionException {

		return getPersistence().findByRuleId_First(ruleId, orderByComparator);
	}

	/**
	 * Returns the first action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action, or <code>null</code> if a matching action could not be found
	 */
	public static Action fetchByRuleId_First(
		long ruleId, OrderByComparator<Action> orderByComparator) {

		return getPersistence().fetchByRuleId_First(ruleId, orderByComparator);
	}

	/**
	 * Returns the last action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action
	 * @throws NoSuchActionException if a matching action could not be found
	 */
	public static Action findByRuleId_Last(
			long ruleId, OrderByComparator<Action> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchActionException {

		return getPersistence().findByRuleId_Last(ruleId, orderByComparator);
	}

	/**
	 * Returns the last action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action, or <code>null</code> if a matching action could not be found
	 */
	public static Action fetchByRuleId_Last(
		long ruleId, OrderByComparator<Action> orderByComparator) {

		return getPersistence().fetchByRuleId_Last(ruleId, orderByComparator);
	}

	/**
	 * Returns the actions before and after the current action in the ordered set where ruleId = &#63;.
	 *
	 * @param actionId the primary key of the current action
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next action
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	public static Action[] findByRuleId_PrevAndNext(
			long actionId, long ruleId,
			OrderByComparator<Action> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchActionException {

		return getPersistence().findByRuleId_PrevAndNext(
			actionId, ruleId, orderByComparator);
	}

	/**
	 * Removes all the actions where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 */
	public static void removeByRuleId(long ruleId) {
		getPersistence().removeByRuleId(ruleId);
	}

	/**
	 * Returns the number of actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching actions
	 */
	public static int countByRuleId(long ruleId) {
		return getPersistence().countByRuleId(ruleId);
	}

	/**
	 * Caches the action in the entity cache if it is enabled.
	 *
	 * @param action the action
	 */
	public static void cacheResult(Action action) {
		getPersistence().cacheResult(action);
	}

	/**
	 * Caches the actions in the entity cache if it is enabled.
	 *
	 * @param actions the actions
	 */
	public static void cacheResult(List<Action> actions) {
		getPersistence().cacheResult(actions);
	}

	/**
	 * Creates a new action with the primary key. Does not add the action to the database.
	 *
	 * @param actionId the primary key for the new action
	 * @return the new action
	 */
	public static Action create(long actionId) {
		return getPersistence().create(actionId);
	}

	/**
	 * Removes the action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the action
	 * @return the action that was removed
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	public static Action remove(long actionId)
		throws com.liferay.yithro.rules.exception.NoSuchActionException {

		return getPersistence().remove(actionId);
	}

	public static Action updateImpl(Action action) {
		return getPersistence().updateImpl(action);
	}

	/**
	 * Returns the action with the primary key or throws a <code>NoSuchActionException</code> if it could not be found.
	 *
	 * @param actionId the primary key of the action
	 * @return the action
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	public static Action findByPrimaryKey(long actionId)
		throws com.liferay.yithro.rules.exception.NoSuchActionException {

		return getPersistence().findByPrimaryKey(actionId);
	}

	/**
	 * Returns the action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionId the primary key of the action
	 * @return the action, or <code>null</code> if a action with the primary key could not be found
	 */
	public static Action fetchByPrimaryKey(long actionId) {
		return getPersistence().fetchByPrimaryKey(actionId);
	}

	/**
	 * Returns all the actions.
	 *
	 * @return the actions
	 */
	public static List<Action> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @return the range of actions
	 */
	public static List<Action> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of actions
	 */
	public static List<Action> findAll(
		int start, int end, OrderByComparator<Action> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of actions
	 */
	public static List<Action> findAll(
		int start, int end, OrderByComparator<Action> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the actions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of actions.
	 *
	 * @return the number of actions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ActionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ActionPersistence, ActionPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ActionPersistence.class);

		ServiceTracker<ActionPersistence, ActionPersistence> serviceTracker =
			new ServiceTracker<ActionPersistence, ActionPersistence>(
				bundle.getBundleContext(), ActionPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}