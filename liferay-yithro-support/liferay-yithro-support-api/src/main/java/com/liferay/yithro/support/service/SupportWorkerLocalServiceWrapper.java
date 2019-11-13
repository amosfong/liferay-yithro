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

/**
 * Provides a wrapper for {@link SupportWorkerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorkerLocalService
 * @generated
 */
public class SupportWorkerLocalServiceWrapper
	implements ServiceWrapper<SupportWorkerLocalService>,
			   SupportWorkerLocalService {

	public SupportWorkerLocalServiceWrapper(
		SupportWorkerLocalService supportWorkerLocalService) {

		_supportWorkerLocalService = supportWorkerLocalService;
	}

	/**
	 * Adds the support worker to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was added
	 */
	@Override
	public com.liferay.yithro.support.model.SupportWorker addSupportWorker(
		com.liferay.yithro.support.model.SupportWorker supportWorker) {

		return _supportWorkerLocalService.addSupportWorker(supportWorker);
	}

	@Override
	public void addSupportWorkers(
			long[] userIds, long supportTeamId, double[] maxWork, int[] roles)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportWorkerLocalService.addSupportWorkers(
			userIds, supportTeamId, maxWork, roles);
	}

	/**
	 * Creates a new support worker with the primary key. Does not add the support worker to the database.
	 *
	 * @param supportWorkerId the primary key for the new support worker
	 * @return the new support worker
	 */
	@Override
	public com.liferay.yithro.support.model.SupportWorker createSupportWorker(
		long supportWorkerId) {

		return _supportWorkerLocalService.createSupportWorker(supportWorkerId);
	}

	@Override
	public void decreaseAssignedWork(long userId, double work)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportWorkerLocalService.decreaseAssignedWork(userId, work);
	}

	@Override
	public void decreaseTicketEntryAssignedWork(long ticketEntryId, double work)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportWorkerLocalService.decreaseTicketEntryAssignedWork(
			ticketEntryId, work);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the support worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker that was removed
	 * @throws PortalException if a support worker with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.support.model.SupportWorker deleteSupportWorker(
			long supportWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.deleteSupportWorker(supportWorkerId);
	}

	/**
	 * Deletes the support worker from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was removed
	 */
	@Override
	public com.liferay.yithro.support.model.SupportWorker deleteSupportWorker(
		com.liferay.yithro.support.model.SupportWorker supportWorker) {

		return _supportWorkerLocalService.deleteSupportWorker(supportWorker);
	}

	@Override
	public void deleteSupportWorkers(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportWorkerLocalService.deleteSupportWorkers(userId);
	}

	@Override
	public void deleteSupportWorkers(long[] userIds, long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportWorkerLocalService.deleteSupportWorkers(userIds, supportTeamId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supportWorkerLocalService.dynamicQuery();
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

		return _supportWorkerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>.
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

		return _supportWorkerLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>.
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

		return _supportWorkerLocalService.dynamicQuery(
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

		return _supportWorkerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _supportWorkerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.support.model.SupportWorker fetchSupportWorker(
		long supportWorkerId) {

		return _supportWorkerLocalService.fetchSupportWorker(supportWorkerId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _supportWorkerLocalService.getActionableDynamicQuery();
	}

	@Override
	public double getAssignedWork(long userId) {
		return _supportWorkerLocalService.getAssignedWork(userId);
	}

	@Override
	public com.liferay.yithro.support.model.SupportWorker
			getAvailableSupportWorker(long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.getAvailableSupportWorker(
			ticketEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _supportWorkerLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.yithro.support.model.SupportWorker
			getLongestOpenSupportWorker(
				java.util.List<com.liferay.yithro.support.model.SupportWorker>
					supportWorkers,
				long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.getLongestOpenSupportWorker(
			supportWorkers, ticketEntryId);
	}

	@Override
	public com.liferay.yithro.support.model.SupportWorker
			getMostAvailableSupportWorker(
				long ticketEntryId,
				java.util.LinkedHashMap<String, Object> params)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.getMostAvailableSupportWorker(
			ticketEntryId, params);
	}

	@Override
	public com.liferay.yithro.support.model.SupportWorker
			getNextOpenSupportWorker(
				java.util.List<com.liferay.yithro.support.model.SupportWorker>
					supportWorkers,
				long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.getNextOpenSupportWorker(
			supportWorkers, ticketEntryId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _supportWorkerLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.yithro.support.model.SupportWorker>
		getSupportTeamSupportWorkers(long supportTeamId) {

		return _supportWorkerLocalService.getSupportTeamSupportWorkers(
			supportTeamId);
	}

	/**
	 * Returns the support worker with the primary key.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker
	 * @throws PortalException if a support worker with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.support.model.SupportWorker getSupportWorker(
			long supportWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.getSupportWorker(supportWorkerId);
	}

	@Override
	public com.liferay.yithro.support.model.SupportWorker getSupportWorker(
			long userId, long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.getSupportWorker(
			userId, supportTeamId);
	}

	/**
	 * Returns a range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of support workers
	 */
	@Override
	public java.util.List<com.liferay.yithro.support.model.SupportWorker>
		getSupportWorkers(int start, int end) {

		return _supportWorkerLocalService.getSupportWorkers(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.support.model.SupportWorker>
			getSupportWorkersBySupportLaborId(long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.getSupportWorkersBySupportLaborId(
			supportLaborId);
	}

	/**
	 * Returns the number of support workers.
	 *
	 * @return the number of support workers
	 */
	@Override
	public int getSupportWorkersCount() {
		return _supportWorkerLocalService.getSupportWorkersCount();
	}

	@Override
	public int getSupportWorkersCountBySupportLaborId(long supportLaborId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.
			getSupportWorkersCountBySupportLaborId(supportLaborId);
	}

	@Override
	public java.util.List<com.liferay.yithro.support.model.SupportWorker>
		getUserSupportWorkers(long userId) {

		return _supportWorkerLocalService.getUserSupportWorkers(userId);
	}

	@Override
	public boolean hasSupportWorker(long userId, long supportTeamId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.hasSupportWorker(
			userId, supportTeamId);
	}

	@Override
	public void increaseAssignedWork(long userId, double work)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportWorkerLocalService.increaseAssignedWork(userId, work);
	}

	@Override
	public void increaseTicketEntryAssignedWork(long ticketEntryId, double work)
		throws com.liferay.portal.kernel.exception.PortalException {

		_supportWorkerLocalService.increaseTicketEntryAssignedWork(
			ticketEntryId, work);
	}

	@Override
	public void recalculateUtilization() {
		_supportWorkerLocalService.recalculateUtilization();
	}

	@Override
	public com.liferay.yithro.support.model.SupportWorker updateSupportWorker(
			long supportWorkerId, long supportTeamId, double maxWork)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportWorkerLocalService.updateSupportWorker(
			supportWorkerId, supportTeamId, maxWork);
	}

	/**
	 * Updates the support worker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was updated
	 */
	@Override
	public com.liferay.yithro.support.model.SupportWorker updateSupportWorker(
		com.liferay.yithro.support.model.SupportWorker supportWorker) {

		return _supportWorkerLocalService.updateSupportWorker(supportWorker);
	}

	@Override
	public SupportWorkerLocalService getWrappedService() {
		return _supportWorkerLocalService;
	}

	@Override
	public void setWrappedService(
		SupportWorkerLocalService supportWorkerLocalService) {

		_supportWorkerLocalService = supportWorkerLocalService;
	}

	private SupportWorkerLocalService _supportWorkerLocalService;

}