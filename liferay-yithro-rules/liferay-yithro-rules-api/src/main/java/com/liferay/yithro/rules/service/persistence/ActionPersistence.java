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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.yithro.rules.exception.NoSuchActionException;
import com.liferay.yithro.rules.model.Action;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ActionUtil
 * @generated
 */
@ProviderType
public interface ActionPersistence extends BasePersistence<Action> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActionUtil} to access the action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching actions
	 */
	public java.util.List<Action> findByRuleId(long ruleId);

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
	public java.util.List<Action> findByRuleId(long ruleId, int start, int end);

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
	public java.util.List<Action> findByRuleId(
		long ruleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Action>
			orderByComparator);

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
	public java.util.List<Action> findByRuleId(
		long ruleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Action>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action
	 * @throws NoSuchActionException if a matching action could not be found
	 */
	public Action findByRuleId_First(
			long ruleId,
			com.liferay.portal.kernel.util.OrderByComparator<Action>
				orderByComparator)
		throws NoSuchActionException;

	/**
	 * Returns the first action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action, or <code>null</code> if a matching action could not be found
	 */
	public Action fetchByRuleId_First(
		long ruleId,
		com.liferay.portal.kernel.util.OrderByComparator<Action>
			orderByComparator);

	/**
	 * Returns the last action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action
	 * @throws NoSuchActionException if a matching action could not be found
	 */
	public Action findByRuleId_Last(
			long ruleId,
			com.liferay.portal.kernel.util.OrderByComparator<Action>
				orderByComparator)
		throws NoSuchActionException;

	/**
	 * Returns the last action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action, or <code>null</code> if a matching action could not be found
	 */
	public Action fetchByRuleId_Last(
		long ruleId,
		com.liferay.portal.kernel.util.OrderByComparator<Action>
			orderByComparator);

	/**
	 * Returns the actions before and after the current action in the ordered set where ruleId = &#63;.
	 *
	 * @param actionId the primary key of the current action
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next action
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	public Action[] findByRuleId_PrevAndNext(
			long actionId, long ruleId,
			com.liferay.portal.kernel.util.OrderByComparator<Action>
				orderByComparator)
		throws NoSuchActionException;

	/**
	 * Removes all the actions where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 */
	public void removeByRuleId(long ruleId);

	/**
	 * Returns the number of actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching actions
	 */
	public int countByRuleId(long ruleId);

	/**
	 * Caches the action in the entity cache if it is enabled.
	 *
	 * @param action the action
	 */
	public void cacheResult(Action action);

	/**
	 * Caches the actions in the entity cache if it is enabled.
	 *
	 * @param actions the actions
	 */
	public void cacheResult(java.util.List<Action> actions);

	/**
	 * Creates a new action with the primary key. Does not add the action to the database.
	 *
	 * @param actionId the primary key for the new action
	 * @return the new action
	 */
	public Action create(long actionId);

	/**
	 * Removes the action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the action
	 * @return the action that was removed
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	public Action remove(long actionId) throws NoSuchActionException;

	public Action updateImpl(Action action);

	/**
	 * Returns the action with the primary key or throws a <code>NoSuchActionException</code> if it could not be found.
	 *
	 * @param actionId the primary key of the action
	 * @return the action
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	public Action findByPrimaryKey(long actionId) throws NoSuchActionException;

	/**
	 * Returns the action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionId the primary key of the action
	 * @return the action, or <code>null</code> if a action with the primary key could not be found
	 */
	public Action fetchByPrimaryKey(long actionId);

	/**
	 * Returns all the actions.
	 *
	 * @return the actions
	 */
	public java.util.List<Action> findAll();

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
	public java.util.List<Action> findAll(int start, int end);

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
	public java.util.List<Action> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Action>
			orderByComparator);

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
	public java.util.List<Action> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Action>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the actions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of actions.
	 *
	 * @return the number of actions
	 */
	public int countAll();

}