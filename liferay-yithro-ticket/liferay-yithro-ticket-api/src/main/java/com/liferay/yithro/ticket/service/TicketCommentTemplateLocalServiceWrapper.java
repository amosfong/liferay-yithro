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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TicketCommentTemplateLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentTemplateLocalService
 * @generated
 */
public class TicketCommentTemplateLocalServiceWrapper
	implements TicketCommentTemplateLocalService,
			   ServiceWrapper<TicketCommentTemplateLocalService> {

	public TicketCommentTemplateLocalServiceWrapper(
		TicketCommentTemplateLocalService ticketCommentTemplateLocalService) {

		_ticketCommentTemplateLocalService = ticketCommentTemplateLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketCommentTemplateLocalServiceUtil} to access the ticket comment template local service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketCommentTemplateLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
			addTicketCommentTemplate(
				long userId, String defaultLanguageId, String name,
				String content)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommentTemplateLocalService.addTicketCommentTemplate(
			userId, defaultLanguageId, name, content);
	}

	/**
	 * Adds the ticket comment template to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 * @return the ticket comment template that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
		addTicketCommentTemplate(
			com.liferay.yithro.ticket.model.TicketCommentTemplate
				ticketCommentTemplate) {

		return _ticketCommentTemplateLocalService.addTicketCommentTemplate(
			ticketCommentTemplate);
	}

	/**
	 * Creates a new ticket comment template with the primary key. Does not add the ticket comment template to the database.
	 *
	 * @param ticketCommentTemplateId the primary key for the new ticket comment template
	 * @return the new ticket comment template
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
		createTicketCommentTemplate(long ticketCommentTemplateId) {

		return _ticketCommentTemplateLocalService.createTicketCommentTemplate(
			ticketCommentTemplateId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommentTemplateLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the ticket comment template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template that was removed
	 * @throws PortalException if a ticket comment template with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
			deleteTicketCommentTemplate(long ticketCommentTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommentTemplateLocalService.deleteTicketCommentTemplate(
			ticketCommentTemplateId);
	}

	/**
	 * Deletes the ticket comment template from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 * @return the ticket comment template that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
		deleteTicketCommentTemplate(
			com.liferay.yithro.ticket.model.TicketCommentTemplate
				ticketCommentTemplate) {

		return _ticketCommentTemplateLocalService.deleteTicketCommentTemplate(
			ticketCommentTemplate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketCommentTemplateLocalService.dynamicQuery();
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

		return _ticketCommentTemplateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentTemplateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketCommentTemplateLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentTemplateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketCommentTemplateLocalService.dynamicQuery(
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

		return _ticketCommentTemplateLocalService.dynamicQueryCount(
			dynamicQuery);
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

		return _ticketCommentTemplateLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
		fetchTicketCommentTemplate(long ticketCommentTemplateId) {

		return _ticketCommentTemplateLocalService.fetchTicketCommentTemplate(
			ticketCommentTemplateId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketCommentTemplateLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketCommentTemplateLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketCommentTemplateLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommentTemplateLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the ticket comment template with the primary key.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template
	 * @throws PortalException if a ticket comment template with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
			getTicketCommentTemplate(long ticketCommentTemplateId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommentTemplateLocalService.getTicketCommentTemplate(
			ticketCommentTemplateId);
	}

	/**
	 * Returns a range of all the ticket comment templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketCommentTemplateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comment templates
	 * @param end the upper bound of the range of ticket comment templates (not inclusive)
	 * @return the range of ticket comment templates
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketCommentTemplate>
		getTicketCommentTemplates(int start, int end) {

		return _ticketCommentTemplateLocalService.getTicketCommentTemplates(
			start, end);
	}

	/**
	 * Returns the number of ticket comment templates.
	 *
	 * @return the number of ticket comment templates
	 */
	@Override
	public int getTicketCommentTemplatesCount() {
		return _ticketCommentTemplateLocalService.
			getTicketCommentTemplatesCount();
	}

	@Override
	public void removeCommentTemplateLocale(
			long ticketCommentTemplateId, String languageId)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketCommentTemplateLocalService.removeCommentTemplateLocale(
			ticketCommentTemplateId, languageId);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
			updateTicketCommentTemplate(
				long ticketCommentTemplateId, String defaultLanguageId,
				String languageId, String name, String content)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommentTemplateLocalService.updateTicketCommentTemplate(
			ticketCommentTemplateId, defaultLanguageId, languageId, name,
			content);
	}

	/**
	 * Updates the ticket comment template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 * @return the ticket comment template that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommentTemplate
		updateTicketCommentTemplate(
			com.liferay.yithro.ticket.model.TicketCommentTemplate
				ticketCommentTemplate) {

		return _ticketCommentTemplateLocalService.updateTicketCommentTemplate(
			ticketCommentTemplate);
	}

	@Override
	public TicketCommentTemplateLocalService getWrappedService() {
		return _ticketCommentTemplateLocalService;
	}

	@Override
	public void setWrappedService(
		TicketCommentTemplateLocalService ticketCommentTemplateLocalService) {

		_ticketCommentTemplateLocalService = ticketCommentTemplateLocalService;
	}

	private TicketCommentTemplateLocalService
		_ticketCommentTemplateLocalService;

}