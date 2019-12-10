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
import com.liferay.yithro.rules.exception.NoSuchRuleConditionException;
import com.liferay.yithro.rules.model.RuleCondition;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rule condition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleConditionUtil
 * @generated
 */
@ProviderType
public interface RuleConditionPersistence
	extends BasePersistence<RuleCondition> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleConditionUtil} to access the rule condition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the matching rule conditions
	 */
	public java.util.List<RuleCondition> findByR_T(long ruleId, String type);

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
	public java.util.List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end);

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
	public java.util.List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
			orderByComparator);

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
	public java.util.List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule condition
	 * @throws NoSuchRuleConditionException if a matching rule condition could not be found
	 */
	public RuleCondition findByR_T_First(
			long ruleId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
				orderByComparator)
		throws NoSuchRuleConditionException;

	/**
	 * Returns the first rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule condition, or <code>null</code> if a matching rule condition could not be found
	 */
	public RuleCondition fetchByR_T_First(
		long ruleId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
			orderByComparator);

	/**
	 * Returns the last rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule condition
	 * @throws NoSuchRuleConditionException if a matching rule condition could not be found
	 */
	public RuleCondition findByR_T_Last(
			long ruleId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
				orderByComparator)
		throws NoSuchRuleConditionException;

	/**
	 * Returns the last rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule condition, or <code>null</code> if a matching rule condition could not be found
	 */
	public RuleCondition fetchByR_T_Last(
		long ruleId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
			orderByComparator);

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
	public RuleCondition[] findByR_T_PrevAndNext(
			long ruleConditionId, long ruleId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
				orderByComparator)
		throws NoSuchRuleConditionException;

	/**
	 * Removes all the rule conditions where ruleId = &#63; and type = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 */
	public void removeByR_T(long ruleId, String type);

	/**
	 * Returns the number of rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the number of matching rule conditions
	 */
	public int countByR_T(long ruleId, String type);

	/**
	 * Caches the rule condition in the entity cache if it is enabled.
	 *
	 * @param ruleCondition the rule condition
	 */
	public void cacheResult(RuleCondition ruleCondition);

	/**
	 * Caches the rule conditions in the entity cache if it is enabled.
	 *
	 * @param ruleConditions the rule conditions
	 */
	public void cacheResult(java.util.List<RuleCondition> ruleConditions);

	/**
	 * Creates a new rule condition with the primary key. Does not add the rule condition to the database.
	 *
	 * @param ruleConditionId the primary key for the new rule condition
	 * @return the new rule condition
	 */
	public RuleCondition create(long ruleConditionId);

	/**
	 * Removes the rule condition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition that was removed
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	public RuleCondition remove(long ruleConditionId)
		throws NoSuchRuleConditionException;

	public RuleCondition updateImpl(RuleCondition ruleCondition);

	/**
	 * Returns the rule condition with the primary key or throws a <code>NoSuchRuleConditionException</code> if it could not be found.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	public RuleCondition findByPrimaryKey(long ruleConditionId)
		throws NoSuchRuleConditionException;

	/**
	 * Returns the rule condition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition, or <code>null</code> if a rule condition with the primary key could not be found
	 */
	public RuleCondition fetchByPrimaryKey(long ruleConditionId);

	/**
	 * Returns all the rule conditions.
	 *
	 * @return the rule conditions
	 */
	public java.util.List<RuleCondition> findAll();

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
	public java.util.List<RuleCondition> findAll(int start, int end);

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
	public java.util.List<RuleCondition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
			orderByComparator);

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
	public java.util.List<RuleCondition> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleCondition>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rule conditions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rule conditions.
	 *
	 * @return the number of rule conditions
	 */
	public int countAll();

}