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

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for SupportWorker. This utility wraps
 * <code>com.liferay.yithro.support.service.impl.SupportWorkerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorkerLocalService
 * @generated
 */
@ProviderType
public class SupportWorkerLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.support.service.impl.SupportWorkerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the support worker to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was added
	 */
	public static com.liferay.yithro.support.model.SupportWorker
		addSupportWorker(
			com.liferay.yithro.support.model.SupportWorker supportWorker) {

		return getService().addSupportWorker(supportWorker);
	}

	public static void addSupportWorkers(
			long[] userIds, long supportTeamId, double[] maxWork, int[] roles)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addSupportWorkers(userIds, supportTeamId, maxWork, roles);
	}

	/**
	 * Creates a new support worker with the primary key. Does not add the support worker to the database.
	 *
	 * @param supportWorkerId the primary key for the new support worker
	 * @return the new support worker
	 */
	public static com.liferay.yithro.support.model.SupportWorker
		createSupportWorker(long supportWorkerId) {

		return getService().createSupportWorker(supportWorkerId);
	}

	public static void decreaseAssignedWork(long userId, double work)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().decreaseAssignedWork(userId, work);
	}

	public static void decreaseTicketEntryAssignedWork(
			long ticketEntryId, double work)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().decreaseTicketEntryAssignedWork(ticketEntryId, work);
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
	 * Deletes the support worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker that was removed
	 * @throws PortalException if a support worker with the primary key could not be found
	 */
	public static com.liferay.yithro.support.model.SupportWorker
			deleteSupportWorker(long supportWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteSupportWorker(supportWorkerId);
	}

	/**
	 * Deletes the support worker from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was removed
	 */
	public static com.liferay.yithro.support.model.SupportWorker
		deleteSupportWorker(
			com.liferay.yithro.support.model.SupportWorker supportWorker) {

		return getService().deleteSupportWorker(supportWorker);
	}

	public static void deleteSupportWorkers(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteSupportWorkers(userId);
	}

	public static void deleteSupportWorkers(long[] userIds, long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteSupportWorkers(userIds, supportTeamId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.yithro.support.model.SupportWorker
		fetchSupportWorker(long supportWorkerId) {

		return getService().fetchSupportWorker(supportWorkerId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static double getAssignedWork(long userId) {
		return getService().getAssignedWork(userId);
	}

	public static com.liferay.yithro.support.model.SupportWorker
			getAvailableSupportWorker(long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAvailableSupportWorker(ticketEntryId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static com.liferay.yithro.support.model.SupportWorker
			getLongestOpenSupportWorker(
				java.util.List<com.liferay.yithro.support.model.SupportWorker>
					supportWorkers,
				long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLongestOpenSupportWorker(
			supportWorkers, ticketEntryId);
	}

	public static com.liferay.yithro.support.model.SupportWorker
			getMostAvailableSupportWorker(
				long ticketEntryId,
				java.util.LinkedHashMap<String, Object> params)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMostAvailableSupportWorker(
			ticketEntryId, params);
	}

	public static com.liferay.yithro.support.model.SupportWorker
			getNextOpenSupportWorker(
				java.util.List<com.liferay.yithro.support.model.SupportWorker>
					supportWorkers,
				long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNextOpenSupportWorker(
			supportWorkers, ticketEntryId);
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

	public static java.util.List<com.liferay.yithro.support.model.SupportWorker>
		getSupportTeamSupportWorkers(long supportTeamId) {

		return getService().getSupportTeamSupportWorkers(supportTeamId);
	}

	/**
	 * Returns the support worker with the primary key.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker
	 * @throws PortalException if a support worker with the primary key could not be found
	 */
	public static com.liferay.yithro.support.model.SupportWorker
			getSupportWorker(long supportWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSupportWorker(supportWorkerId);
	}

	public static com.liferay.yithro.support.model.SupportWorker
			getSupportWorker(long userId, long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSupportWorker(userId, supportTeamId);
	}

	/**
	 * Returns a range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of support workers
	 */
	public static java.util.List<com.liferay.yithro.support.model.SupportWorker>
		getSupportWorkers(int start, int end) {

		return getService().getSupportWorkers(start, end);
	}

	public static java.util.List<com.liferay.yithro.support.model.SupportWorker>
			getSupportWorkersBySupportLaborId(long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSupportWorkersBySupportLaborId(supportLaborId);
	}

	/**
	 * Returns the number of support workers.
	 *
	 * @return the number of support workers
	 */
	public static int getSupportWorkersCount() {
		return getService().getSupportWorkersCount();
	}

	public static int getSupportWorkersCountBySupportLaborId(
			long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getSupportWorkersCountBySupportLaborId(
			supportLaborId);
	}

	public static java.util.List<com.liferay.yithro.support.model.SupportWorker>
		getUserSupportWorkers(long userId) {

		return getService().getUserSupportWorkers(userId);
	}

	public static void increaseAssignedWork(long userId, double work)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().increaseAssignedWork(userId, work);
	}

	public static void increaseTicketEntryAssignedWork(
			long ticketEntryId, double work)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().increaseTicketEntryAssignedWork(ticketEntryId, work);
	}

	public static void recalculateUtilization() {
		getService().recalculateUtilization();
	}

	public static com.liferay.yithro.support.model.SupportWorker
			updateSupportWorker(
				long supportWorkerId, long supportTeamId, double maxWork)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateSupportWorker(
			supportWorkerId, supportTeamId, maxWork);
	}

	/**
	 * Updates the support worker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was updated
	 */
	public static com.liferay.yithro.support.model.SupportWorker
		updateSupportWorker(
			com.liferay.yithro.support.model.SupportWorker supportWorker) {

		return getService().updateSupportWorker(supportWorker);
	}

	public static SupportWorkerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<SupportWorkerLocalService, SupportWorkerLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			SupportWorkerLocalService.class);

		ServiceTracker<SupportWorkerLocalService, SupportWorkerLocalService>
			serviceTracker =
				new ServiceTracker
					<SupportWorkerLocalService, SupportWorkerLocalService>(
						bundle.getBundleContext(),
						SupportWorkerLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}