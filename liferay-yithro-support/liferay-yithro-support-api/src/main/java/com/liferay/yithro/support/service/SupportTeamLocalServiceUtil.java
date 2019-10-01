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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SupportTeam. This utility wraps
 * <code>com.liferay.yithro.support.service.impl.SupportTeamLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SupportTeamLocalService
 * @generated
 */
public class SupportTeamLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.support.service.impl.SupportTeamLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupportTeamLocalServiceUtil} to access the support team local service. Add custom service methods to <code>com.liferay.yithro.support.service.impl.SupportTeamLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static com.liferay.yithro.support.model.SupportTeam addSupportTeam(
			long userId, long parentSupportTeamId, long supportLaborId,
			String name, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addSupportTeam(
			userId, parentSupportTeamId, supportLaborId, name, description);
	}

	/**
	 * Adds the support team to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeam the support team
	 * @return the support team that was added
	 */
	public static com.liferay.yithro.support.model.SupportTeam addSupportTeam(
		com.liferay.yithro.support.model.SupportTeam supportTeam) {

		return getService().addSupportTeam(supportTeam);
	}

	/**
	 * Creates a new support team with the primary key. Does not add the support team to the database.
	 *
	 * @param supportTeamId the primary key for the new support team
	 * @return the new support team
	 */
	public static com.liferay.yithro.support.model.SupportTeam
		createSupportTeam(long supportTeamId) {

		return getService().createSupportTeam(supportTeamId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the support team with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team that was removed
	 * @throws PortalException if a support team with the primary key could not be found
	 */
	public static com.liferay.yithro.support.model.SupportTeam
			deleteSupportTeam(long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSupportTeam(supportTeamId);
	}

	/**
	 * Deletes the support team from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeam the support team
	 * @return the support team that was removed
	 */
	public static com.liferay.yithro.support.model.SupportTeam
		deleteSupportTeam(
			com.liferay.yithro.support.model.SupportTeam supportTeam) {

		return getService().deleteSupportTeam(supportTeam);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.yithro.support.model.SupportTeam fetchSupportTeam(
		long supportTeamId) {

		return getService().fetchSupportTeam(supportTeamId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.liferay.yithro.support.model.SupportTeam>
		getChildSupportTeams(long supportTeamId, boolean recursive) {

		return getService().getChildSupportTeams(supportTeamId, recursive);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<com.liferay.yithro.support.model.SupportTeam>
		getSupportLaborSupportTeams(long supportLaborId) {

		return getService().getSupportLaborSupportTeams(supportLaborId);
	}

	/**
	 * Returns the support team with the primary key.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team
	 * @throws PortalException if a support team with the primary key could not be found
	 */
	public static com.liferay.yithro.support.model.SupportTeam getSupportTeam(
			long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSupportTeam(supportTeamId);
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
	public static java.util.List<com.liferay.yithro.support.model.SupportTeam>
		getSupportTeams(int start, int end) {

		return getService().getSupportTeams(start, end);
	}

	/**
	 * Returns the number of support teams.
	 *
	 * @return the number of support teams
	 */
	public static int getSupportTeamsCount() {
		return getService().getSupportTeamsCount();
	}

	public static com.liferay.yithro.support.model.SupportTeam
			updateSupportTeam(
				long supportTeamId, long parentSupportTeamId,
				long supportLaborId, String name, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSupportTeam(
			supportTeamId, parentSupportTeamId, supportLaborId, name,
			description);
	}

	/**
	 * Updates the support team in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeam the support team
	 * @return the support team that was updated
	 */
	public static com.liferay.yithro.support.model.SupportTeam
		updateSupportTeam(
			com.liferay.yithro.support.model.SupportTeam supportTeam) {

		return getService().updateSupportTeam(supportTeam);
	}

	public static void updateSupportTeamChildren(
			long parentSupportTeamId, long[] childSupportTeamIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateSupportTeamChildren(
			parentSupportTeamId, childSupportTeamIds);
	}

	public static void updateSupportTeamLabor(
			long[] supportTeamIds, long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateSupportTeamLabor(supportTeamIds, supportLaborId);
	}

	public static SupportTeamLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SupportTeamLocalService, SupportTeamLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SupportTeamLocalService.class);

		ServiceTracker<SupportTeamLocalService, SupportTeamLocalService>
			serviceTracker =
				new ServiceTracker
					<SupportTeamLocalService, SupportTeamLocalService>(
						bundle.getBundleContext(),
						SupportTeamLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}