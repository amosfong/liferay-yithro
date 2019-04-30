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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SupportWorkerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorkerLocalService
 * @generated
 */
@ProviderType
public class SupportWorkerLocalServiceWrapper
	implements SupportWorkerLocalService,
			   ServiceWrapper<SupportWorkerLocalService> {

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _supportWorkerLocalService.getIndexableActionableDynamicQuery();
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
	@Override
	public java.util.List<com.liferay.yithro.support.model.SupportWorker>
		getSupportWorkers(int start, int end) {

		return _supportWorkerLocalService.getSupportWorkers(start, end);
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