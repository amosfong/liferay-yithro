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
import com.liferay.yithro.rules.exception.NoSuchRuleActionException;
import com.liferay.yithro.rules.model.RuleAction;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rule action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionUtil
 * @generated
 */
@ProviderType
public interface RuleActionPersistence extends BasePersistence<RuleAction> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleActionUtil} to access the rule action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the rule actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching rule actions
	 */
	public java.util.List<RuleAction> findByRuleId(long ruleId);

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
	public java.util.List<RuleAction> findByRuleId(
		long ruleId, int start, int end);

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
	public java.util.List<RuleAction> findByRuleId(
		long ruleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
			orderByComparator);

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
	public java.util.List<RuleAction> findByRuleId(
		long ruleId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action
	 * @throws NoSuchRuleActionException if a matching rule action could not be found
	 */
	public RuleAction findByRuleId_First(
			long ruleId,
			com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
				orderByComparator)
		throws NoSuchRuleActionException;

	/**
	 * Returns the first rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action, or <code>null</code> if a matching rule action could not be found
	 */
	public RuleAction fetchByRuleId_First(
		long ruleId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
			orderByComparator);

	/**
	 * Returns the last rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action
	 * @throws NoSuchRuleActionException if a matching rule action could not be found
	 */
	public RuleAction findByRuleId_Last(
			long ruleId,
			com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
				orderByComparator)
		throws NoSuchRuleActionException;

	/**
	 * Returns the last rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action, or <code>null</code> if a matching rule action could not be found
	 */
	public RuleAction fetchByRuleId_Last(
		long ruleId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
			orderByComparator);

	/**
	 * Returns the rule actions before and after the current rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleActionId the primary key of the current rule action
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule action
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	public RuleAction[] findByRuleId_PrevAndNext(
			long ruleActionId, long ruleId,
			com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
				orderByComparator)
		throws NoSuchRuleActionException;

	/**
	 * Removes all the rule actions where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 */
	public void removeByRuleId(long ruleId);

	/**
	 * Returns the number of rule actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching rule actions
	 */
	public int countByRuleId(long ruleId);

	/**
	 * Caches the rule action in the entity cache if it is enabled.
	 *
	 * @param ruleAction the rule action
	 */
	public void cacheResult(RuleAction ruleAction);

	/**
	 * Caches the rule actions in the entity cache if it is enabled.
	 *
	 * @param ruleActions the rule actions
	 */
	public void cacheResult(java.util.List<RuleAction> ruleActions);

	/**
	 * Creates a new rule action with the primary key. Does not add the rule action to the database.
	 *
	 * @param ruleActionId the primary key for the new rule action
	 * @return the new rule action
	 */
	public RuleAction create(long ruleActionId);

	/**
	 * Removes the rule action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action that was removed
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	public RuleAction remove(long ruleActionId)
		throws NoSuchRuleActionException;

	public RuleAction updateImpl(RuleAction ruleAction);

	/**
	 * Returns the rule action with the primary key or throws a <code>NoSuchRuleActionException</code> if it could not be found.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	public RuleAction findByPrimaryKey(long ruleActionId)
		throws NoSuchRuleActionException;

	/**
	 * Returns the rule action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action, or <code>null</code> if a rule action with the primary key could not be found
	 */
	public RuleAction fetchByPrimaryKey(long ruleActionId);

	/**
	 * Returns all the rule actions.
	 *
	 * @return the rule actions
	 */
	public java.util.List<RuleAction> findAll();

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
	public java.util.List<RuleAction> findAll(int start, int end);

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
	public java.util.List<RuleAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
			orderByComparator);

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
	public java.util.List<RuleAction> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleAction>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rule actions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rule actions.
	 *
	 * @return the number of rule actions
	 */
	public int countAll();

}