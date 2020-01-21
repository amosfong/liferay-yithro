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
 * Provides the local service utility for TicketField. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketFieldLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldLocalService
 * @generated
 */
public class TicketFieldLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketFieldLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.yithro.ticket.model.TicketField addTicketField(
			long userId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int type,
			int visibility,
			java.util.List<com.liferay.yithro.ticket.model.TicketFieldOption>
				ticketFieldOptions)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketField(
			userId, nameMap, descriptionMap, type, visibility,
			ticketFieldOptions);
	}

	/**
	 * Adds the ticket field to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketField the ticket field
	 * @return the ticket field that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketField addTicketField(
		com.liferay.yithro.ticket.model.TicketField ticketField) {

		return getService().addTicketField(ticketField);
	}

	/**
	 * Creates a new ticket field with the primary key. Does not add the ticket field to the database.
	 *
	 * @param ticketFieldId the primary key for the new ticket field
	 * @return the new ticket field
	 */
	public static com.liferay.yithro.ticket.model.TicketField createTicketField(
		long ticketFieldId) {

		return getService().createTicketField(ticketFieldId);
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
	 * Deletes the ticket field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field that was removed
	 * @throws PortalException if a ticket field with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketField deleteTicketField(
			long ticketFieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketField(ticketFieldId);
	}

	/**
	 * Deletes the ticket field from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketField the ticket field
	 * @return the ticket field that was removed
	 */
	public static com.liferay.yithro.ticket.model.TicketField deleteTicketField(
		com.liferay.yithro.ticket.model.TicketField ticketField) {

		return getService().deleteTicketField(ticketField);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldModelImpl</code>.
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

	public static com.liferay.yithro.ticket.model.TicketField fetchTicketField(
		long ticketFieldId) {

		return getService().fetchTicketField(ticketFieldId);
	}

	public static com.liferay.yithro.ticket.model.TicketField fetchTicketField(
		String systemKey) {

		return getService().fetchTicketField(systemKey);
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
	 * Returns the ticket field with the primary key.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field
	 * @throws PortalException if a ticket field with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketField getTicketField(
			long ticketFieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketField(ticketFieldId);
	}

	/**
	 * Returns a range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @return the range of ticket fields
	 */
	public static java.util.List<com.liferay.yithro.ticket.model.TicketField>
		getTicketFields(int start, int end) {

		return getService().getTicketFields(start, end);
	}

	public static java.util.List<com.liferay.yithro.ticket.model.TicketField>
		getTicketFields(int status, int start, int end) {

		return getService().getTicketFields(status, start, end);
	}

	/**
	 * Returns the number of ticket fields.
	 *
	 * @return the number of ticket fields
	 */
	public static int getTicketFieldsCount() {
		return getService().getTicketFieldsCount();
	}

	public static int getTicketFieldsCount(int status) {
		return getService().getTicketFieldsCount(status);
	}

	public static void updateStatus(long ticketFieldId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateStatus(ticketFieldId, status);
	}

	public static com.liferay.yithro.ticket.model.TicketField updateTicketField(
			long ticketFieldId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int type,
			int visibility,
			java.util.List<com.liferay.yithro.ticket.model.TicketFieldOption>
				ticketFieldOptions)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketField(
			ticketFieldId, nameMap, descriptionMap, type, visibility,
			ticketFieldOptions);
	}

	/**
	 * Updates the ticket field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketField the ticket field
	 * @return the ticket field that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketField updateTicketField(
		com.liferay.yithro.ticket.model.TicketField ticketField) {

		return getService().updateTicketField(ticketField);
	}

	public static TicketFieldLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketFieldLocalService, TicketFieldLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketFieldLocalService.class);

		ServiceTracker<TicketFieldLocalService, TicketFieldLocalService>
			serviceTracker =
				new ServiceTracker
					<TicketFieldLocalService, TicketFieldLocalService>(
						bundle.getBundleContext(),
						TicketFieldLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}