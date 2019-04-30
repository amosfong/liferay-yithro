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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.yithro.support.exception.NoSuchSupportTeamException;
import com.liferay.yithro.support.model.SupportTeam;

/**
 * The persistence interface for the support team service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportTeamUtil
 * @generated
 */
@ProviderType
public interface SupportTeamPersistence extends BasePersistence<SupportTeam> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupportTeamUtil} to access the support team persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the support teams where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @return the matching support teams
	 */
	public java.util.List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId);

	/**
	 * Returns a range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of matching support teams
	 */
	public java.util.List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end);

	/**
	 * Returns an ordered range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support teams
	 */
	public java.util.List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support teams
	 */
	public java.util.List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public SupportTeam findByParentSupportTeamId_First(
			long parentSupportTeamId,
			com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
				orderByComparator)
		throws NoSuchSupportTeamException;

	/**
	 * Returns the first support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public SupportTeam fetchByParentSupportTeamId_First(
		long parentSupportTeamId,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator);

	/**
	 * Returns the last support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public SupportTeam findByParentSupportTeamId_Last(
			long parentSupportTeamId,
			com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
				orderByComparator)
		throws NoSuchSupportTeamException;

	/**
	 * Returns the last support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public SupportTeam fetchByParentSupportTeamId_Last(
		long parentSupportTeamId,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator);

	/**
	 * Returns the support teams before and after the current support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param supportTeamId the primary key of the current support team
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	public SupportTeam[] findByParentSupportTeamId_PrevAndNext(
			long supportTeamId, long parentSupportTeamId,
			com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
				orderByComparator)
		throws NoSuchSupportTeamException;

	/**
	 * Removes all the support teams where parentSupportTeamId = &#63; from the database.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 */
	public void removeByParentSupportTeamId(long parentSupportTeamId);

	/**
	 * Returns the number of support teams where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @return the number of matching support teams
	 */
	public int countByParentSupportTeamId(long parentSupportTeamId);

	/**
	 * Returns all the support teams where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the matching support teams
	 */
	public java.util.List<SupportTeam> findBySupportLaborId(
		long supportLaborId);

	/**
	 * Returns a range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of matching support teams
	 */
	public java.util.List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end);

	/**
	 * Returns an ordered range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support teams
	 */
	public java.util.List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support teams
	 */
	public java.util.List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Returns the first support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public SupportTeam findBySupportLaborId_First(
			long supportLaborId,
			com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
				orderByComparator)
		throws NoSuchSupportTeamException;

	/**
	 * Returns the first support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public SupportTeam fetchBySupportLaborId_First(
		long supportLaborId,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator);

	/**
	 * Returns the last support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public SupportTeam findBySupportLaborId_Last(
			long supportLaborId,
			com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
				orderByComparator)
		throws NoSuchSupportTeamException;

	/**
	 * Returns the last support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public SupportTeam fetchBySupportLaborId_Last(
		long supportLaborId,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator);

	/**
	 * Returns the support teams before and after the current support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportTeamId the primary key of the current support team
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	public SupportTeam[] findBySupportLaborId_PrevAndNext(
			long supportTeamId, long supportLaborId,
			com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
				orderByComparator)
		throws NoSuchSupportTeamException;

	/**
	 * Removes all the support teams where supportLaborId = &#63; from the database.
	 *
	 * @param supportLaborId the support labor ID
	 */
	public void removeBySupportLaborId(long supportLaborId);

	/**
	 * Returns the number of support teams where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the number of matching support teams
	 */
	public int countBySupportLaborId(long supportLaborId);

	/**
	 * Returns the support team where name = &#63; or throws a <code>NoSuchSupportTeamException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public SupportTeam findByName(String name)
		throws NoSuchSupportTeamException;

	/**
	 * Returns the support team where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public SupportTeam fetchByName(String name);

	/**
	 * Returns the support team where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public SupportTeam fetchByName(String name, boolean retrieveFromCache);

	/**
	 * Removes the support team where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the support team that was removed
	 */
	public SupportTeam removeByName(String name)
		throws NoSuchSupportTeamException;

	/**
	 * Returns the number of support teams where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching support teams
	 */
	public int countByName(String name);

	/**
	 * Caches the support team in the entity cache if it is enabled.
	 *
	 * @param supportTeam the support team
	 */
	public void cacheResult(SupportTeam supportTeam);

	/**
	 * Caches the support teams in the entity cache if it is enabled.
	 *
	 * @param supportTeams the support teams
	 */
	public void cacheResult(java.util.List<SupportTeam> supportTeams);

	/**
	 * Creates a new support team with the primary key. Does not add the support team to the database.
	 *
	 * @param supportTeamId the primary key for the new support team
	 * @return the new support team
	 */
	public SupportTeam create(long supportTeamId);

	/**
	 * Removes the support team with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team that was removed
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	public SupportTeam remove(long supportTeamId)
		throws NoSuchSupportTeamException;

	public SupportTeam updateImpl(SupportTeam supportTeam);

	/**
	 * Returns the support team with the primary key or throws a <code>NoSuchSupportTeamException</code> if it could not be found.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	public SupportTeam findByPrimaryKey(long supportTeamId)
		throws NoSuchSupportTeamException;

	/**
	 * Returns the support team with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team, or <code>null</code> if a support team with the primary key could not be found
	 */
	public SupportTeam fetchByPrimaryKey(long supportTeamId);

	/**
	 * Returns all the support teams.
	 *
	 * @return the support teams
	 */
	public java.util.List<SupportTeam> findAll();

	/**
	 * Returns a range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of support teams
	 */
	public java.util.List<SupportTeam> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support teams
	 */
	public java.util.List<SupportTeam> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator);

	/**
	 * Returns an ordered range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of support teams
	 */
	public java.util.List<SupportTeam> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportTeam>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the support teams from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of support teams.
	 *
	 * @return the number of support teams
	 */
	public int countAll();

}