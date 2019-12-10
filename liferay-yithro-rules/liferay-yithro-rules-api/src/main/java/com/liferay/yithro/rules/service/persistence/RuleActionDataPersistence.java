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
import com.liferay.yithro.rules.exception.NoSuchRuleActionDataException;
import com.liferay.yithro.rules.model.RuleActionData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the rule action data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionDataUtil
 * @generated
 */
@ProviderType
public interface RuleActionDataPersistence
	extends BasePersistence<RuleActionData> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleActionDataUtil} to access the rule action data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the rule action datas where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @return the matching rule action datas
	 */
	public java.util.List<RuleActionData> findByRuleActionId(long ruleActionId);

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
	public java.util.List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end);

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
	public java.util.List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
			orderByComparator);

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
	public java.util.List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action data
	 * @throws NoSuchRuleActionDataException if a matching rule action data could not be found
	 */
	public RuleActionData findByRuleActionId_First(
			long ruleActionId,
			com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
				orderByComparator)
		throws NoSuchRuleActionDataException;

	/**
	 * Returns the first rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action data, or <code>null</code> if a matching rule action data could not be found
	 */
	public RuleActionData fetchByRuleActionId_First(
		long ruleActionId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
			orderByComparator);

	/**
	 * Returns the last rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action data
	 * @throws NoSuchRuleActionDataException if a matching rule action data could not be found
	 */
	public RuleActionData findByRuleActionId_Last(
			long ruleActionId,
			com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
				orderByComparator)
		throws NoSuchRuleActionDataException;

	/**
	 * Returns the last rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action data, or <code>null</code> if a matching rule action data could not be found
	 */
	public RuleActionData fetchByRuleActionId_Last(
		long ruleActionId,
		com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
			orderByComparator);

	/**
	 * Returns the rule action datas before and after the current rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionDataId the primary key of the current rule action data
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule action data
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	public RuleActionData[] findByRuleActionId_PrevAndNext(
			long ruleActionDataId, long ruleActionId,
			com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
				orderByComparator)
		throws NoSuchRuleActionDataException;

	/**
	 * Removes all the rule action datas where ruleActionId = &#63; from the database.
	 *
	 * @param ruleActionId the rule action ID
	 */
	public void removeByRuleActionId(long ruleActionId);

	/**
	 * Returns the number of rule action datas where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @return the number of matching rule action datas
	 */
	public int countByRuleActionId(long ruleActionId);

	/**
	 * Caches the rule action data in the entity cache if it is enabled.
	 *
	 * @param ruleActionData the rule action data
	 */
	public void cacheResult(RuleActionData ruleActionData);

	/**
	 * Caches the rule action datas in the entity cache if it is enabled.
	 *
	 * @param ruleActionDatas the rule action datas
	 */
	public void cacheResult(java.util.List<RuleActionData> ruleActionDatas);

	/**
	 * Creates a new rule action data with the primary key. Does not add the rule action data to the database.
	 *
	 * @param ruleActionDataId the primary key for the new rule action data
	 * @return the new rule action data
	 */
	public RuleActionData create(long ruleActionDataId);

	/**
	 * Removes the rule action data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data that was removed
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	public RuleActionData remove(long ruleActionDataId)
		throws NoSuchRuleActionDataException;

	public RuleActionData updateImpl(RuleActionData ruleActionData);

	/**
	 * Returns the rule action data with the primary key or throws a <code>NoSuchRuleActionDataException</code> if it could not be found.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	public RuleActionData findByPrimaryKey(long ruleActionDataId)
		throws NoSuchRuleActionDataException;

	/**
	 * Returns the rule action data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data, or <code>null</code> if a rule action data with the primary key could not be found
	 */
	public RuleActionData fetchByPrimaryKey(long ruleActionDataId);

	/**
	 * Returns all the rule action datas.
	 *
	 * @return the rule action datas
	 */
	public java.util.List<RuleActionData> findAll();

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
	public java.util.List<RuleActionData> findAll(int start, int end);

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
	public java.util.List<RuleActionData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
			orderByComparator);

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
	public java.util.List<RuleActionData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<RuleActionData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the rule action datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of rule action datas.
	 *
	 * @return the number of rule action datas
	 */
	public int countAll();

}