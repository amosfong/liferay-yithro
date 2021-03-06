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
 * Provides the local service utility for TicketCommentTemplate. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketCommentTemplateLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentTemplateLocalService
 * @generated
 */
public class TicketCommentTemplateLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketCommentTemplateLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
			addTicketCommentTemplate(
				long userId, String defaultLanguageId, String name,
				String content)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketCommentTemplate(
			userId, defaultLanguageId, name, content);
	}

	/**
	 * Adds the ticket comment template to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 * @return the ticket comment template that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
		addTicketCommentTemplate(
			com.liferay.yithro.ticket.model.TicketCommentTemplate
				ticketCommentTemplate) {

		return getService().addTicketCommentTemplate(ticketCommentTemplate);
	}

	/**
	 * Creates a new ticket comment template with the primary key. Does not add the ticket comment template to the database.
	 *
	 * @param ticketCommentTemplateId the primary key for the new ticket comment template
	 * @return the new ticket comment template
	 */
	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
		createTicketCommentTemplate(long ticketCommentTemplateId) {

		return getService().createTicketCommentTemplate(
			ticketCommentTemplateId);
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
	 * Deletes the ticket comment template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template that was removed
	 * @throws PortalException if a ticket comment template with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
			deleteTicketCommentTemplate(long ticketCommentTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketCommentTemplate(
			ticketCommentTemplateId);
	}

	/**
	 * Deletes the ticket comment template from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 * @return the ticket comment template that was removed
	 */
	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
		deleteTicketCommentTemplate(
			com.liferay.yithro.ticket.model.TicketCommentTemplate
				ticketCommentTemplate) {

		return getService().deleteTicketCommentTemplate(ticketCommentTemplate);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentTemplateModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentTemplateModelImpl</code>.
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

	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
		fetchTicketCommentTemplate(long ticketCommentTemplateId) {

		return getService().fetchTicketCommentTemplate(ticketCommentTemplateId);
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
	 * Returns the ticket comment template with the primary key.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template
	 * @throws PortalException if a ticket comment template with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
			getTicketCommentTemplate(long ticketCommentTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketCommentTemplate(ticketCommentTemplateId);
	}

	/**
	 * Returns a range of all the ticket comment templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comment templates
	 * @param end the upper bound of the range of ticket comment templates (not inclusive)
	 * @return the range of ticket comment templates
	 */
	public static java.util.List
		<com.liferay.yithro.ticket.model.TicketCommentTemplate>
			getTicketCommentTemplates(int start, int end) {

		return getService().getTicketCommentTemplates(start, end);
	}

	/**
	 * Returns the number of ticket comment templates.
	 *
	 * @return the number of ticket comment templates
	 */
	public static int getTicketCommentTemplatesCount() {
		return getService().getTicketCommentTemplatesCount();
	}

	public static void removeCommentTemplateLocale(
			long ticketCommentTemplateId, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().removeCommentTemplateLocale(
			ticketCommentTemplateId, languageId);
	}

	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
			updateTicketCommentTemplate(
				long ticketCommentTemplateId, String defaultLanguageId,
				String languageId, String name, String content)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketCommentTemplate(
			ticketCommentTemplateId, defaultLanguageId, languageId, name,
			content);
	}

	/**
	 * Updates the ticket comment template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 * @return the ticket comment template that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketCommentTemplate
		updateTicketCommentTemplate(
			com.liferay.yithro.ticket.model.TicketCommentTemplate
				ticketCommentTemplate) {

		return getService().updateTicketCommentTemplate(ticketCommentTemplate);
	}

	public static TicketCommentTemplateLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketCommentTemplateLocalService, TicketCommentTemplateLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketCommentTemplateLocalService.class);

		ServiceTracker
			<TicketCommentTemplateLocalService,
			 TicketCommentTemplateLocalService> serviceTracker =
				new ServiceTracker
					<TicketCommentTemplateLocalService,
					 TicketCommentTemplateLocalService>(
						 bundle.getBundleContext(),
						 TicketCommentTemplateLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}