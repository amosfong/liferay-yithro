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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TicketWorker. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketWorkerLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketWorkerLocalService
 * @generated
 */
public class TicketWorkerLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketWorkerLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketWorkerLocalServiceUtil} to access the ticket worker local service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketWorkerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static com.liferay.yithro.ticket.model.TicketWorker addTicketWorker(
			long workerUserId, long ticketEntryId, long sourceClassNameId,
			long sourceClassPK, int role, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketWorker(
			workerUserId, ticketEntryId, sourceClassNameId, sourceClassPK, role,
			primary);
	}

	/**
	 * Adds the ticket worker to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketWorker addTicketWorker(
		com.liferay.yithro.ticket.model.TicketWorker ticketWorker) {

		return getService().addTicketWorker(ticketWorker);
	}

	/**
	 * Creates a new ticket worker with the primary key. Does not add the ticket worker to the database.
	 *
	 * @param ticketWorkerId the primary key for the new ticket worker
	 * @return the new ticket worker
	 */
	public static com.liferay.yithro.ticket.model.TicketWorker
		createTicketWorker(long ticketWorkerId) {

		return getService().createTicketWorker(ticketWorkerId);
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
	 * Deletes the ticket worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker that was removed
	 * @throws PortalException if a ticket worker with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketWorker
			deleteTicketWorker(long ticketWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketWorker(ticketWorkerId);
	}

	/**
	 * Deletes the ticket worker from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was removed
	 */
	public static com.liferay.yithro.ticket.model.TicketWorker
		deleteTicketWorker(
			com.liferay.yithro.ticket.model.TicketWorker ticketWorker) {

		return getService().deleteTicketWorker(ticketWorker);
	}

	public static void deleteTicketWorkers(long userId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteTicketWorkers(userId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.yithro.ticket.model.TicketWorker
		fetchLatestTicketWorker(long ticketEntryId) {

		return getService().fetchLatestTicketWorker(ticketEntryId);
	}

	public static com.liferay.yithro.ticket.model.TicketWorker
		fetchPrimaryTicketWorker(long ticketEntryId) {

		return getService().fetchPrimaryTicketWorker(ticketEntryId);
	}

	public static com.liferay.yithro.ticket.model.TicketWorker
		fetchTicketWorker(long ticketWorkerId) {

		return getService().fetchTicketWorker(ticketWorkerId);
	}

	public static com.liferay.yithro.ticket.model.TicketWorker
		fetchTicketWorker(long userId, long ticketEntryId) {

		return getService().fetchTicketWorker(userId, ticketEntryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	/**
	 * Returns the ticket worker with the primary key.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker
	 * @throws PortalException if a ticket worker with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketWorker getTicketWorker(
			long ticketWorkerId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketWorker(ticketWorkerId);
	}

	public static com.liferay.yithro.ticket.model.TicketWorker getTicketWorker(
			long userId, long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketWorker(userId, ticketEntryId);
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
	public static java.util.List<com.liferay.yithro.ticket.model.TicketWorker>
		getTicketWorkers(int start, int end) {

		return getService().getTicketWorkers(start, end);
	}

	public static java.util.List<com.liferay.yithro.ticket.model.TicketWorker>
		getTicketWorkers(long ticketEntryId) {

		return getService().getTicketWorkers(ticketEntryId);
	}

	public static java.util.List<com.liferay.yithro.ticket.model.TicketWorker>
		getTicketWorkers(long sourceClassNameId, long sourceClassPK) {

		return getService().getTicketWorkers(sourceClassNameId, sourceClassPK);
	}

	/**
	 * Returns the number of ticket workers.
	 *
	 * @return the number of ticket workers
	 */
	public static int getTicketWorkersCount() {
		return getService().getTicketWorkersCount();
	}

	public static java.util.List<com.liferay.yithro.ticket.model.TicketWorker>
		getUserTicketWorkers(long userId) {

		return getService().getUserTicketWorkers(userId);
	}

	public static int getUserTicketWorkersCount(long userId) {
		return getService().getUserTicketWorkersCount(userId);
	}

	public static boolean hasTicketWorker(long userId, long ticketEntryId) {
		return getService().hasTicketWorker(userId, ticketEntryId);
	}

	public static void setTicketWorkers(
			long ticketEntryId, long[] userIds, int[] roles, long primaryUserId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().setTicketWorkers(
			ticketEntryId, userIds, roles, primaryUserId);
	}

	public static com.liferay.yithro.ticket.model.TicketWorker
			updateTicketWorker(long ticketWorkerId, int role, boolean primary)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketWorker(ticketWorkerId, role, primary);
	}

	/**
	 * Updates the ticket worker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketWorker
		updateTicketWorker(
			com.liferay.yithro.ticket.model.TicketWorker ticketWorker) {

		return getService().updateTicketWorker(ticketWorker);
	}

	public static TicketWorkerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketWorkerLocalService, TicketWorkerLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketWorkerLocalService.class);

		ServiceTracker<TicketWorkerLocalService, TicketWorkerLocalService>
			serviceTracker =
				new ServiceTracker
					<TicketWorkerLocalService, TicketWorkerLocalService>(
						bundle.getBundleContext(),
						TicketWorkerLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}