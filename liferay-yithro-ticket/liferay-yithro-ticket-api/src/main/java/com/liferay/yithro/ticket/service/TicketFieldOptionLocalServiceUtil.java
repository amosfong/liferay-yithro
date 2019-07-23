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
 * Provides the local service utility for TicketFieldOption. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketFieldOptionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldOptionLocalService
 * @generated
 */
@ProviderType
public class TicketFieldOptionLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketFieldOptionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.yithro.ticket.model.TicketFieldOption
			addTicketFieldOption(
				long companyId, long ticketFieldId,
				java.util.Map<java.util.Locale, String> nameMap, int visibility,
				int order, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketFieldOption(
			companyId, ticketFieldId, nameMap, visibility, order, status);
	}

	/**
	 * Adds the ticket field option to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOption the ticket field option
	 * @return the ticket field option that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketFieldOption
		addTicketFieldOption(
			com.liferay.yithro.ticket.model.TicketFieldOption
				ticketFieldOption) {

		return getService().addTicketFieldOption(ticketFieldOption);
	}

	/**
	 * Creates a new ticket field option with the primary key. Does not add the ticket field option to the database.
	 *
	 * @param ticketFieldOptionId the primary key for the new ticket field option
	 * @return the new ticket field option
	 */
	public static com.liferay.yithro.ticket.model.TicketFieldOption
		createTicketFieldOption(long ticketFieldOptionId) {

		return getService().createTicketFieldOption(ticketFieldOptionId);
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
	 * Deletes the ticket field option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option that was removed
	 * @throws PortalException if a ticket field option with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketFieldOption
			deleteTicketFieldOption(long ticketFieldOptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketFieldOption(ticketFieldOptionId);
	}

	/**
	 * Deletes the ticket field option from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOption the ticket field option
	 * @return the ticket field option that was removed
	 */
	public static com.liferay.yithro.ticket.model.TicketFieldOption
		deleteTicketFieldOption(
			com.liferay.yithro.ticket.model.TicketFieldOption
				ticketFieldOption) {

		return getService().deleteTicketFieldOption(ticketFieldOption);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.yithro.ticket.model.TicketFieldOption
		fetchTicketFieldOption(long ticketFieldOptionId) {

		return getService().fetchTicketFieldOption(ticketFieldOptionId);
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
	 * Returns the ticket field option with the primary key.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option
	 * @throws PortalException if a ticket field option with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketFieldOption
			getTicketFieldOption(long ticketFieldOptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketFieldOption(ticketFieldOptionId);
	}

	/**
	 * Returns a range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of ticket field options
	 */
	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketFieldOption>
			getTicketFieldOptions(int start, int end) {

		return getService().getTicketFieldOptions(start, end);
	}

	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketFieldOption>
			getTicketFieldOptions(long ticketFieldId) {

		return getService().getTicketFieldOptions(ticketFieldId);
	}

	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketFieldOption>
			getTicketFieldOptions(long ticketFieldId, int status) {

		return getService().getTicketFieldOptions(ticketFieldId, status);
	}

	/**
	 * Returns the number of ticket field options.
	 *
	 * @return the number of ticket field options
	 */
	public static int getTicketFieldOptionsCount() {
		return getService().getTicketFieldOptionsCount();
	}

	public static com.liferay.yithro.ticket.model.TicketFieldOption
			updateTicketFieldOption(
				long ticketFieldOptionId,
				java.util.Map<java.util.Locale, String> nameMap, int visibility,
				int order)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketFieldOption(
			ticketFieldOptionId, nameMap, visibility, order);
	}

	/**
	 * Updates the ticket field option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOption the ticket field option
	 * @return the ticket field option that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketFieldOption
		updateTicketFieldOption(
			com.liferay.yithro.ticket.model.TicketFieldOption
				ticketFieldOption) {

		return getService().updateTicketFieldOption(ticketFieldOption);
	}

	public static TicketFieldOptionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketFieldOptionLocalService, TicketFieldOptionLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketFieldOptionLocalService.class);

		ServiceTracker
			<TicketFieldOptionLocalService, TicketFieldOptionLocalService>
				serviceTracker =
					new ServiceTracker
						<TicketFieldOptionLocalService,
						 TicketFieldOptionLocalService>(
							 bundle.getBundleContext(),
							 TicketFieldOptionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}