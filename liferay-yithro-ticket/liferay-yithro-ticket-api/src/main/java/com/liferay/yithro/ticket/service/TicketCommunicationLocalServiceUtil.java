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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TicketCommunication. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketCommunicationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommunicationLocalService
 * @generated
 */
@ProviderType
public class TicketCommunicationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketCommunicationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.yithro.ticket.model.TicketCommunication
			addTicketCommunication(
				long userId, long ticketEntryId, Class<?> clazz, long classPK,
				String content,
				com.liferay.portal.kernel.json.JSONObject propertiesJSONObject)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketCommunication(
			userId, ticketEntryId, clazz, classPK, content,
			propertiesJSONObject);
	}

	public static com.liferay.yithro.ticket.model.TicketCommunication
			addTicketCommunication(
				long userId, long ticketEntryId, long classNameId, long classPK,
				String content,
				com.liferay.portal.kernel.json.JSONObject propertiesJSONObject)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketCommunication(
			userId, ticketEntryId, classNameId, classPK, content,
			propertiesJSONObject);
	}

	/**
	 * Adds the ticket communication to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketCommunication
		addTicketCommunication(
			com.liferay.yithro.ticket.model.TicketCommunication
				ticketCommunication) {

		return getService().addTicketCommunication(ticketCommunication);
	}

	/**
	 * Creates a new ticket communication with the primary key. Does not add the ticket communication to the database.
	 *
	 * @param ticketCommunicationId the primary key for the new ticket communication
	 * @return the new ticket communication
	 */
	public static com.liferay.yithro.ticket.model.TicketCommunication
		createTicketCommunication(long ticketCommunicationId) {

		return getService().createTicketCommunication(ticketCommunicationId);
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

	public static com.liferay.yithro.ticket.model.TicketCommunication
			deleteTicketCommunication(Class<?> clazz, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketCommunication(clazz, classPK);
	}

	/**
	 * Deletes the ticket communication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication that was removed
	 * @throws PortalException if a ticket communication with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketCommunication
			deleteTicketCommunication(long ticketCommunicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketCommunication(ticketCommunicationId);
	}

	public static com.liferay.yithro.ticket.model.TicketCommunication
			deleteTicketCommunication(long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketCommunication(classNameId, classPK);
	}

	/**
	 * Deletes the ticket communication from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was removed
	 */
	public static com.liferay.yithro.ticket.model.TicketCommunication
		deleteTicketCommunication(
			com.liferay.yithro.ticket.model.TicketCommunication
				ticketCommunication) {

		return getService().deleteTicketCommunication(ticketCommunication);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.yithro.ticket.model.TicketCommunication
		fetchTicketCommunication(Class<?> clazz, long classPK) {

		return getService().fetchTicketCommunication(clazz, classPK);
	}

	public static com.liferay.yithro.ticket.model.TicketCommunication
		fetchTicketCommunication(long ticketCommunicationId) {

		return getService().fetchTicketCommunication(ticketCommunicationId);
	}

	public static com.liferay.yithro.ticket.model.TicketCommunication
		fetchTicketCommunication(long classNameId, long classPK) {

		return getService().fetchTicketCommunication(classNameId, classPK);
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
	 * Returns the ticket communication with the primary key.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication
	 * @throws PortalException if a ticket communication with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketCommunication
			getTicketCommunication(long ticketCommunicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketCommunication(ticketCommunicationId);
	}

	/**
	 * Returns a range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @return the range of ticket communications
	 */
	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketCommunication>
			getTicketCommunications(int start, int end) {

		return getService().getTicketCommunications(start, end);
	}

	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketCommunication>
				getTicketCommunications(long ticketEntryId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketCommunications(ticketEntryId);
	}

	/**
	 * Returns the number of ticket communications.
	 *
	 * @return the number of ticket communications
	 */
	public static int getTicketCommunicationsCount() {
		return getService().getTicketCommunicationsCount();
	}

	public static com.liferay.yithro.ticket.model.TicketCommunication
			updateTicketCommunication(
				long ticketCommunicationId, String content,
				com.liferay.portal.kernel.json.JSONObject propertiesJSONObject)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketCommunication(
			ticketCommunicationId, content, propertiesJSONObject);
	}

	/**
	 * Updates the ticket communication in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketCommunication
		updateTicketCommunication(
			com.liferay.yithro.ticket.model.TicketCommunication
				ticketCommunication) {

		return getService().updateTicketCommunication(ticketCommunication);
	}

	public static TicketCommunicationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketCommunicationLocalService, TicketCommunicationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketCommunicationLocalService.class);

		ServiceTracker
			<TicketCommunicationLocalService, TicketCommunicationLocalService>
				serviceTracker =
					new ServiceTracker
						<TicketCommunicationLocalService,
						 TicketCommunicationLocalService>(
							 bundle.getBundleContext(),
							 TicketCommunicationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}