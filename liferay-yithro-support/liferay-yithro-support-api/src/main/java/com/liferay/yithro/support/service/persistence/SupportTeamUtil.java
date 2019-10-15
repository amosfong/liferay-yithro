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
import com.liferay.yithro.support.model.SupportTeam;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the support team service. This utility wraps <code>com.liferay.yithro.support.service.persistence.impl.SupportTeamPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportTeamPersistence
 * @generated
 */
public class SupportTeamUtil {

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
	public static void clearCache(SupportTeam supportTeam) {
		getPersistence().clearCache(supportTeam);
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
	public static Map<Serializable, SupportTeam> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<SupportTeam> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SupportTeam> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SupportTeam> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static SupportTeam update(SupportTeam supportTeam) {
		return getPersistence().update(supportTeam);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static SupportTeam update(
		SupportTeam supportTeam, ServiceContext serviceContext) {

		return getPersistence().update(supportTeam, serviceContext);
	}

	/**
	 * Returns all the support teams where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @return the matching support teams
	 */
	public static List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId) {

		return getPersistence().findByParentSupportTeamId(parentSupportTeamId);
	}

	/**
	 * Returns a range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of matching support teams
	 */
	public static List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end) {

		return getPersistence().findByParentSupportTeamId(
			parentSupportTeamId, start, end);
	}

	/**
	 * Returns an ordered range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support teams
	 */
	public static List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator) {

		return getPersistence().findByParentSupportTeamId(
			parentSupportTeamId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching support teams
	 */
	public static List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByParentSupportTeamId(
			parentSupportTeamId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public static SupportTeam findByParentSupportTeamId_First(
			long parentSupportTeamId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().findByParentSupportTeamId_First(
			parentSupportTeamId, orderByComparator);
	}

	/**
	 * Returns the first support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public static SupportTeam fetchByParentSupportTeamId_First(
		long parentSupportTeamId,
		OrderByComparator<SupportTeam> orderByComparator) {

		return getPersistence().fetchByParentSupportTeamId_First(
			parentSupportTeamId, orderByComparator);
	}

	/**
	 * Returns the last support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public static SupportTeam findByParentSupportTeamId_Last(
			long parentSupportTeamId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().findByParentSupportTeamId_Last(
			parentSupportTeamId, orderByComparator);
	}

	/**
	 * Returns the last support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public static SupportTeam fetchByParentSupportTeamId_Last(
		long parentSupportTeamId,
		OrderByComparator<SupportTeam> orderByComparator) {

		return getPersistence().fetchByParentSupportTeamId_Last(
			parentSupportTeamId, orderByComparator);
	}

	/**
	 * Returns the support teams before and after the current support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param supportTeamId the primary key of the current support team
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	public static SupportTeam[] findByParentSupportTeamId_PrevAndNext(
			long supportTeamId, long parentSupportTeamId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().findByParentSupportTeamId_PrevAndNext(
			supportTeamId, parentSupportTeamId, orderByComparator);
	}

	/**
	 * Removes all the support teams where parentSupportTeamId = &#63; from the database.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 */
	public static void removeByParentSupportTeamId(long parentSupportTeamId) {
		getPersistence().removeByParentSupportTeamId(parentSupportTeamId);
	}

	/**
	 * Returns the number of support teams where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @return the number of matching support teams
	 */
	public static int countByParentSupportTeamId(long parentSupportTeamId) {
		return getPersistence().countByParentSupportTeamId(parentSupportTeamId);
	}

	/**
	 * Returns all the support teams where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the matching support teams
	 */
	public static List<SupportTeam> findBySupportLaborId(long supportLaborId) {
		return getPersistence().findBySupportLaborId(supportLaborId);
	}

	/**
	 * Returns a range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of matching support teams
	 */
	public static List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end) {

		return getPersistence().findBySupportLaborId(
			supportLaborId, start, end);
	}

	/**
	 * Returns an ordered range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support teams
	 */
	public static List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator) {

		return getPersistence().findBySupportLaborId(
			supportLaborId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching support teams
	 */
	public static List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findBySupportLaborId(
			supportLaborId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public static SupportTeam findBySupportLaborId_First(
			long supportLaborId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().findBySupportLaborId_First(
			supportLaborId, orderByComparator);
	}

	/**
	 * Returns the first support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public static SupportTeam fetchBySupportLaborId_First(
		long supportLaborId, OrderByComparator<SupportTeam> orderByComparator) {

		return getPersistence().fetchBySupportLaborId_First(
			supportLaborId, orderByComparator);
	}

	/**
	 * Returns the last support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public static SupportTeam findBySupportLaborId_Last(
			long supportLaborId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().findBySupportLaborId_Last(
			supportLaborId, orderByComparator);
	}

	/**
	 * Returns the last support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public static SupportTeam fetchBySupportLaborId_Last(
		long supportLaborId, OrderByComparator<SupportTeam> orderByComparator) {

		return getPersistence().fetchBySupportLaborId_Last(
			supportLaborId, orderByComparator);
	}

	/**
	 * Returns the support teams before and after the current support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportTeamId the primary key of the current support team
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	public static SupportTeam[] findBySupportLaborId_PrevAndNext(
			long supportTeamId, long supportLaborId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().findBySupportLaborId_PrevAndNext(
			supportTeamId, supportLaborId, orderByComparator);
	}

	/**
	 * Removes all the support teams where supportLaborId = &#63; from the database.
	 *
	 * @param supportLaborId the support labor ID
	 */
	public static void removeBySupportLaborId(long supportLaborId) {
		getPersistence().removeBySupportLaborId(supportLaborId);
	}

	/**
	 * Returns the number of support teams where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the number of matching support teams
	 */
	public static int countBySupportLaborId(long supportLaborId) {
		return getPersistence().countBySupportLaborId(supportLaborId);
	}

	/**
	 * Returns the support team where name = &#63; or throws a <code>NoSuchSupportTeamException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	public static SupportTeam findByName(String name)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().findByName(name);
	}

	/**
	 * Returns the support team where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public static SupportTeam fetchByName(String name) {
		return getPersistence().fetchByName(name);
	}

	/**
	 * Returns the support team where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching support team, or <code>null</code> if a matching support team could not be found
	 */
	public static SupportTeam fetchByName(String name, boolean useFinderCache) {
		return getPersistence().fetchByName(name, useFinderCache);
	}

	/**
	 * Removes the support team where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the support team that was removed
	 */
	public static SupportTeam removeByName(String name)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().removeByName(name);
	}

	/**
	 * Returns the number of support teams where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching support teams
	 */
	public static int countByName(String name) {
		return getPersistence().countByName(name);
	}

	/**
	 * Caches the support team in the entity cache if it is enabled.
	 *
	 * @param supportTeam the support team
	 */
	public static void cacheResult(SupportTeam supportTeam) {
		getPersistence().cacheResult(supportTeam);
	}

	/**
	 * Caches the support teams in the entity cache if it is enabled.
	 *
	 * @param supportTeams the support teams
	 */
	public static void cacheResult(List<SupportTeam> supportTeams) {
		getPersistence().cacheResult(supportTeams);
	}

	/**
	 * Creates a new support team with the primary key. Does not add the support team to the database.
	 *
	 * @param supportTeamId the primary key for the new support team
	 * @return the new support team
	 */
	public static SupportTeam create(long supportTeamId) {
		return getPersistence().create(supportTeamId);
	}

	/**
	 * Removes the support team with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team that was removed
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	public static SupportTeam remove(long supportTeamId)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().remove(supportTeamId);
	}

	public static SupportTeam updateImpl(SupportTeam supportTeam) {
		return getPersistence().updateImpl(supportTeam);
	}

	/**
	 * Returns the support team with the primary key or throws a <code>NoSuchSupportTeamException</code> if it could not be found.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	public static SupportTeam findByPrimaryKey(long supportTeamId)
		throws com.liferay.yithro.support.exception.NoSuchSupportTeamException {

		return getPersistence().findByPrimaryKey(supportTeamId);
	}

	/**
	 * Returns the support team with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team, or <code>null</code> if a support team with the primary key could not be found
	 */
	public static SupportTeam fetchByPrimaryKey(long supportTeamId) {
		return getPersistence().fetchByPrimaryKey(supportTeamId);
	}

	/**
	 * Returns all the support teams.
	 *
	 * @return the support teams
	 */
	public static List<SupportTeam> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of support teams
	 */
	public static List<SupportTeam> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support teams
	 */
	public static List<SupportTeam> findAll(
		int start, int end, OrderByComparator<SupportTeam> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of support teams
	 */
	public static List<SupportTeam> findAll(
		int start, int end, OrderByComparator<SupportTeam> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the support teams from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of support teams.
	 *
	 * @return the number of support teams
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SupportTeamPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SupportTeamPersistence, SupportTeamPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SupportTeamPersistence.class);

		ServiceTracker<SupportTeamPersistence, SupportTeamPersistence>
			serviceTracker =
				new ServiceTracker
					<SupportTeamPersistence, SupportTeamPersistence>(
						bundle.getBundleContext(), SupportTeamPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}