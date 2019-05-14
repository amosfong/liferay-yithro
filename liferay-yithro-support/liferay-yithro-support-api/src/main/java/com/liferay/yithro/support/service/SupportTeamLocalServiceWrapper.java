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

package com.liferay.yithro.support.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link SupportTeamLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupportTeamLocalService
 * @generated
 */
@ProviderType
public class SupportTeamLocalServiceWrapper
	implements SupportTeamLocalService,
			   ServiceWrapper<SupportTeamLocalService> {

	public SupportTeamLocalServiceWrapper(
		SupportTeamLocalService supportTeamLocalService) {

		_supportTeamLocalService = supportTeamLocalService;
	}

	@Override
	public com.liferay.yithro.support.model.SupportTeam addSupportTeam(
			long userId, long parentSupportTeamId, long supportLaborId,
			String name, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTeamLocalService.addSupportTeam(
			userId, parentSupportTeamId, supportLaborId, name, description);
	}

	/**
	 * Adds the support team to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeam the support team
	 * @return the support team that was added
	 */
	@Override
	public com.liferay.yithro.support.model.SupportTeam addSupportTeam(
		com.liferay.yithro.support.model.SupportTeam supportTeam) {

		return _supportTeamLocalService.addSupportTeam(supportTeam);
	}

	/**
	 * Creates a new support team with the primary key. Does not add the support team to the database.
	 *
	 * @param supportTeamId the primary key for the new support team
	 * @return the new support team
	 */
	@Override
	public com.liferay.yithro.support.model.SupportTeam createSupportTeam(
		long supportTeamId) {

		return _supportTeamLocalService.createSupportTeam(supportTeamId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTeamLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the support team with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team that was removed
	 * @throws PortalException if a support team with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.support.model.SupportTeam deleteSupportTeam(
			long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTeamLocalService.deleteSupportTeam(supportTeamId);
	}

	/**
	 * Deletes the support team from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeam the support team
	 * @return the support team that was removed
	 */
	@Override
	public com.liferay.yithro.support.model.SupportTeam deleteSupportTeam(
		com.liferay.yithro.support.model.SupportTeam supportTeam) {

		return _supportTeamLocalService.deleteSupportTeam(supportTeam);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supportTeamLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _supportTeamLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _supportTeamLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _supportTeamLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _supportTeamLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _supportTeamLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.support.model.SupportTeam fetchSupportTeam(
		long supportTeamId) {

		return _supportTeamLocalService.fetchSupportTeam(supportTeamId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _supportTeamLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.liferay.yithro.support.model.SupportTeam>
		getChildSupportTeams(long supportTeamId, boolean recursive) {

		return _supportTeamLocalService.getChildSupportTeams(
			supportTeamId, recursive);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _supportTeamLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _supportTeamLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTeamLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.yithro.support.model.SupportTeam>
		getSupportLaborSupportTeams(long supportLaborId) {

		return _supportTeamLocalService.getSupportLaborSupportTeams(
			supportLaborId);
	}

	/**
	 * Returns the support team with the primary key.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team
	 * @throws PortalException if a support team with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.support.model.SupportTeam getSupportTeam(
			long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTeamLocalService.getSupportTeam(supportTeamId);
	}

	/**
	 * Returns a range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of support teams
	 */
	@Override
	public java.util.List<com.liferay.yithro.support.model.SupportTeam>
		getSupportTeams(int start, int end) {

		return _supportTeamLocalService.getSupportTeams(start, end);
	}

	/**
	 * Returns the number of support teams.
	 *
	 * @return the number of support teams
	 */
	@Override
	public int getSupportTeamsCount() {
		return _supportTeamLocalService.getSupportTeamsCount();
	}

	@Override
	public com.liferay.yithro.support.model.SupportTeam updateSupportTeam(
			long supportTeamId, long parentSupportTeamId, long supportLaborId,
			String name, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportTeamLocalService.updateSupportTeam(
			supportTeamId, parentSupportTeamId, supportLaborId, name,
			description);
	}

	/**
	 * Updates the support team in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeam the support team
	 * @return the support team that was updated
	 */
	@Override
	public com.liferay.yithro.support.model.SupportTeam updateSupportTeam(
		com.liferay.yithro.support.model.SupportTeam supportTeam) {

		return _supportTeamLocalService.updateSupportTeam(supportTeam);
	}

	@Override
	public void updateSupportTeamChildren(
			long parentSupportTeamId, long[] childSupportTeamIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportTeamLocalService.updateSupportTeamChildren(
			parentSupportTeamId, childSupportTeamIds);
	}

	@Override
	public void updateSupportTeamLabor(
			long[] supportTeamIds, long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportTeamLocalService.updateSupportTeamLabor(
			supportTeamIds, supportLaborId);
	}

	@Override
	public SupportTeamLocalService getWrappedService() {
		return _supportTeamLocalService;
	}

	@Override
	public void setWrappedService(
		SupportTeamLocalService supportTeamLocalService) {

		_supportTeamLocalService = supportTeamLocalService;
	}

	private SupportTeamLocalService _supportTeamLocalService;

}