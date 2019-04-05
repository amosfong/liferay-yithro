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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TicketComment. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketCommentLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentLocalService
 * @generated
 */
@ProviderType
public class TicketCommentLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketCommentLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the ticket comment to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketComment the ticket comment
	 * @return the ticket comment that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketComment
		addTicketComment(
			com.liferay.yithro.ticket.model.TicketComment ticketComment) {

		return getService().addTicketComment(ticketComment);
	}

	/**
	 * Creates a new ticket comment with the primary key. Does not add the ticket comment to the database.
	 *
	 * @param ticketCommentId the primary key for the new ticket comment
	 * @return the new ticket comment
	 */
	public static com.liferay.yithro.ticket.model.TicketComment
		createTicketComment(long ticketCommentId) {

		return getService().createTicketComment(ticketCommentId);
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
	 * Deletes the ticket comment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentId the primary key of the ticket comment
	 * @return the ticket comment that was removed
	 * @throws PortalException if a ticket comment with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketComment
			deleteTicketComment(long ticketCommentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketComment(ticketCommentId);
	}

	/**
	 * Deletes the ticket comment from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketComment the ticket comment
	 * @return the ticket comment that was removed
	 */
	public static com.liferay.yithro.ticket.model.TicketComment
		deleteTicketComment(
			com.liferay.yithro.ticket.model.TicketComment ticketComment) {

		return getService().deleteTicketComment(ticketComment);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.yithro.ticket.model.TicketComment
		fetchTicketComment(long ticketCommentId) {

		return getService().fetchTicketComment(ticketCommentId);
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
	 * Returns the ticket comment with the primary key.
	 *
	 * @param ticketCommentId the primary key of the ticket comment
	 * @return the ticket comment
	 * @throws PortalException if a ticket comment with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketComment
			getTicketComment(long ticketCommentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketComment(ticketCommentId);
	}

	/**
	 * Returns a range of all the ticket comments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comments
	 * @param end the upper bound of the range of ticket comments (not inclusive)
	 * @return the range of ticket comments
	 */
	public static java.util.List<com.liferay.yithro.ticket.model.TicketComment>
		getTicketComments(int start, int end) {

		return getService().getTicketComments(start, end);
	}

	/**
	 * Returns the number of ticket comments.
	 *
	 * @return the number of ticket comments
	 */
	public static int getTicketCommentsCount() {
		return getService().getTicketCommentsCount();
	}

	/**
	 * Updates the ticket comment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketComment the ticket comment
	 * @return the ticket comment that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketComment
		updateTicketComment(
			com.liferay.yithro.ticket.model.TicketComment ticketComment) {

		return getService().updateTicketComment(ticketComment);
	}

	public static TicketCommentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketCommentLocalService, TicketCommentLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketCommentLocalService.class);

		ServiceTracker<TicketCommentLocalService, TicketCommentLocalService>
			serviceTracker =
				new ServiceTracker
					<TicketCommentLocalService, TicketCommentLocalService>(
						bundle.getBundleContext(),
						TicketCommentLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}