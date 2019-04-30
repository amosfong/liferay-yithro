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

package com.liferay.yithro.ticket.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TicketWorkerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketWorkerLocalService
 * @generated
 */
@ProviderType
public class TicketWorkerLocalServiceWrapper
	implements TicketWorkerLocalService,
			   ServiceWrapper<TicketWorkerLocalService> {

	public TicketWorkerLocalServiceWrapper(
		TicketWorkerLocalService ticketWorkerLocalService) {

		_ticketWorkerLocalService = ticketWorkerLocalService;
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketWorker addTicketWorker(
			long userId, long workerUserId, long ticketEntryId,
			long sourceClassNameId, long sourceClassPK, int role,
			boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketWorkerLocalService.addTicketWorker(
			userId, workerUserId, ticketEntryId, sourceClassNameId,
			sourceClassPK, role, primary);
	}

	/**
	 * Adds the ticket worker to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketWorker addTicketWorker(
		com.liferay.yithro.ticket.model.TicketWorker ticketWorker) {

		return _ticketWorkerLocalService.addTicketWorker(ticketWorker);
	}

	/**
	 * Creates a new ticket worker with the primary key. Does not add the ticket worker to the database.
	 *
	 * @param ticketWorkerId the primary key for the new ticket worker
	 * @return the new ticket worker
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketWorker createTicketWorker(
		long ticketWorkerId) {

		return _ticketWorkerLocalService.createTicketWorker(ticketWorkerId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketWorkerLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker that was removed
	 * @throws PortalException if a ticket worker with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketWorker deleteTicketWorker(
			long ticketWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketWorkerLocalService.deleteTicketWorker(ticketWorkerId);
	}

	@Override
	public void deleteTicketWorker(long userId, long ticketWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketWorkerLocalService.deleteTicketWorker(userId, ticketWorkerId);
	}

	/**
	 * Deletes the ticket worker from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketWorker deleteTicketWorker(
		com.liferay.yithro.ticket.model.TicketWorker ticketWorker) {

		return _ticketWorkerLocalService.deleteTicketWorker(ticketWorker);
	}

	@Override
	public void deleteTicketWorkers(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketWorkerLocalService.deleteTicketWorkers(userId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketWorkerLocalService.dynamicQuery();
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

		return _ticketWorkerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketWorkerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketWorkerLocalService.dynamicQuery(
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

		return _ticketWorkerLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketWorkerLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketWorker fetchLatestTicketWorker(
		long ticketEntryId) {

		return _ticketWorkerLocalService.fetchLatestTicketWorker(ticketEntryId);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketWorker
		fetchPrimaryTicketWorker(long ticketEntryId) {

		return _ticketWorkerLocalService.fetchPrimaryTicketWorker(
			ticketEntryId);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketWorker fetchTicketWorker(
		long ticketWorkerId) {

		return _ticketWorkerLocalService.fetchTicketWorker(ticketWorkerId);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketWorker fetchTicketWorker(
		long userId, long ticketEntryId) {

		return _ticketWorkerLocalService.fetchTicketWorker(
			userId, ticketEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketWorkerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketWorkerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketWorkerLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketWorkerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket worker with the primary key.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker
	 * @throws PortalException if a ticket worker with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketWorker getTicketWorker(
			long ticketWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketWorkerLocalService.getTicketWorker(ticketWorkerId);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketWorker getTicketWorker(
			long userId, long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketWorkerLocalService.getTicketWorker(userId, ticketEntryId);
	}

	/**
	 * Returns a range of all the ticket workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @return the range of ticket workers
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketWorker>
		getTicketWorkers(int start, int end) {

		return _ticketWorkerLocalService.getTicketWorkers(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketWorker>
		getTicketWorkers(long ticketEntryId) {

		return _ticketWorkerLocalService.getTicketWorkers(ticketEntryId);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketWorker>
		getTicketWorkers(long sourceClassNameId, long sourceClassPK) {

		return _ticketWorkerLocalService.getTicketWorkers(
			sourceClassNameId, sourceClassPK);
	}

	/**
	 * Returns the number of ticket workers.
	 *
	 * @return the number of ticket workers
	 */
	@Override
	public int getTicketWorkersCount() {
		return _ticketWorkerLocalService.getTicketWorkersCount();
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketWorker>
		getUserTicketWorkers(long userId) {

		return _ticketWorkerLocalService.getUserTicketWorkers(userId);
	}

	@Override
	public int getUserTicketWorkersCount(long userId) {
		return _ticketWorkerLocalService.getUserTicketWorkersCount(userId);
	}

	@Override
	public boolean hasTicketWorker(long userId, long ticketEntryId) {
		return _ticketWorkerLocalService.hasTicketWorker(userId, ticketEntryId);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketWorker updateTicketWorker(
			long userId, long ticketWorkerId, int role, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketWorkerLocalService.updateTicketWorker(
			userId, ticketWorkerId, role, primary);
	}

	/**
	 * Updates the ticket worker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketWorker updateTicketWorker(
		com.liferay.yithro.ticket.model.TicketWorker ticketWorker) {

		return _ticketWorkerLocalService.updateTicketWorker(ticketWorker);
	}

	@Override
	public TicketWorkerLocalService getWrappedService() {
		return _ticketWorkerLocalService;
	}

	@Override
	public void setWrappedService(
		TicketWorkerLocalService ticketWorkerLocalService) {

		_ticketWorkerLocalService = ticketWorkerLocalService;
	}

	private TicketWorkerLocalService _ticketWorkerLocalService;

}