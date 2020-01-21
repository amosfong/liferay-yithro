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
 * Provides the local service utility for TicketStructure. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketStructureLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketStructureLocalService
 * @generated
 */
public class TicketStructureLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketStructureLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.yithro.ticket.model.TicketStructure
			addTicketStructure(
				long userId, String name, String description, String structure)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketStructure(
			userId, name, description, structure);
	}

	/**
	 * Adds the ticket structure to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructure the ticket structure
	 * @return the ticket structure that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketStructure
		addTicketStructure(
			com.liferay.yithro.ticket.model.TicketStructure ticketStructure) {

		return getService().addTicketStructure(ticketStructure);
	}

	/**
	 * Creates a new ticket structure with the primary key. Does not add the ticket structure to the database.
	 *
	 * @param ticketStructureId the primary key for the new ticket structure
	 * @return the new ticket structure
	 */
	public static com.liferay.yithro.ticket.model.TicketStructure
		createTicketStructure(long ticketStructureId) {

		return getService().createTicketStructure(ticketStructureId);
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
	 * Deletes the ticket structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure that was removed
	 * @throws PortalException if a ticket structure with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketStructure
			deleteTicketStructure(long ticketStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketStructure(ticketStructureId);
	}

	/**
	 * Deletes the ticket structure from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructure the ticket structure
	 * @return the ticket structure that was removed
	 */
	public static com.liferay.yithro.ticket.model.TicketStructure
		deleteTicketStructure(
			com.liferay.yithro.ticket.model.TicketStructure ticketStructure) {

		return getService().deleteTicketStructure(ticketStructure);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStructureModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStructureModelImpl</code>.
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

	public static com.liferay.yithro.ticket.model.TicketStructure
		fetchTicketStructure(long ticketStructureId) {

		return getService().fetchTicketStructure(ticketStructureId);
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
	 * Returns the ticket structure with the primary key.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure
	 * @throws PortalException if a ticket structure with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketStructure
			getTicketStructure(long ticketStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketStructure(ticketStructureId);
	}

	/**
	 * Returns a range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStructureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @return the range of ticket structures
	 */
	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketStructure> getTicketStructures(
			int start, int end) {

		return getService().getTicketStructures(start, end);
	}

	/**
	 * Returns the number of ticket structures.
	 *
	 * @return the number of ticket structures
	 */
	public static int getTicketStructuresCount() {
		return getService().getTicketStructuresCount();
	}

	public static com.liferay.yithro.ticket.model.TicketStructure
			updateTicketStructure(
				long ticketStructureId, String name, String description,
				String structure)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketStructure(
			ticketStructureId, name, description, structure);
	}

	/**
	 * Updates the ticket structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructure the ticket structure
	 * @return the ticket structure that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketStructure
		updateTicketStructure(
			com.liferay.yithro.ticket.model.TicketStructure ticketStructure) {

		return getService().updateTicketStructure(ticketStructure);
	}

	public static TicketStructureLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketStructureLocalService, TicketStructureLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketStructureLocalService.class);

		ServiceTracker<TicketStructureLocalService, TicketStructureLocalService>
			serviceTracker =
				new ServiceTracker
					<TicketStructureLocalService, TicketStructureLocalService>(
						bundle.getBundleContext(),
						TicketStructureLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}