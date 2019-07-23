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

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link TicketFieldLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldLocalService
 * @generated
 */
@ProviderType
public class TicketFieldLocalServiceWrapper
	implements TicketFieldLocalService,
			   ServiceWrapper<TicketFieldLocalService> {

	public TicketFieldLocalServiceWrapper(
		TicketFieldLocalService ticketFieldLocalService) {

		_ticketFieldLocalService = ticketFieldLocalService;
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketField addTicketField(
			long userId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int type,
			int visibility,
			java.util.List<com.liferay.yithro.ticket.model.TicketFieldOption>
				ticketFieldOptions)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldLocalService.addTicketField(
			userId, nameMap, descriptionMap, type, visibility,
			ticketFieldOptions);
	}

	/**
	 * Adds the ticket field to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketField the ticket field
	 * @return the ticket field that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketField addTicketField(
		com.liferay.yithro.ticket.model.TicketField ticketField) {

		return _ticketFieldLocalService.addTicketField(ticketField);
	}

	/**
	 * Creates a new ticket field with the primary key. Does not add the ticket field to the database.
	 *
	 * @param ticketFieldId the primary key for the new ticket field
	 * @return the new ticket field
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketField createTicketField(
		long ticketFieldId) {

		return _ticketFieldLocalService.createTicketField(ticketFieldId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field that was removed
	 * @throws PortalException if a ticket field with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketField deleteTicketField(
			long ticketFieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldLocalService.deleteTicketField(ticketFieldId);
	}

	/**
	 * Deletes the ticket field from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketField the ticket field
	 * @return the ticket field that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketField deleteTicketField(
		com.liferay.yithro.ticket.model.TicketField ticketField) {

		return _ticketFieldLocalService.deleteTicketField(ticketField);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketFieldLocalService.dynamicQuery();
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

		return _ticketFieldLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketFieldLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketFieldLocalService.dynamicQuery(
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

		return _ticketFieldLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketFieldLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketField fetchTicketField(
		long ticketFieldId) {

		return _ticketFieldLocalService.fetchTicketField(ticketFieldId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketFieldLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketFieldLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketFieldLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket field with the primary key.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field
	 * @throws PortalException if a ticket field with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketField getTicketField(
			long ticketFieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldLocalService.getTicketField(ticketFieldId);
	}

	/**
	 * Returns a range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @return the range of ticket fields
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketField>
		getTicketFields(int start, int end) {

		return _ticketFieldLocalService.getTicketFields(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketField>
		getTicketFields(int status, int start, int end) {

		return _ticketFieldLocalService.getTicketFields(status, start, end);
	}

	/**
	 * Returns the number of ticket fields.
	 *
	 * @return the number of ticket fields
	 */
	@Override
	public int getTicketFieldsCount() {
		return _ticketFieldLocalService.getTicketFieldsCount();
	}

	@Override
	public int getTicketFieldsCount(int status) {
		return _ticketFieldLocalService.getTicketFieldsCount(status);
	}

	@Override
	public void updateStatus(long ticketFieldId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketFieldLocalService.updateStatus(ticketFieldId, status);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketField updateTicketField(
			long ticketFieldId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int type,
			int visibility,
			java.util.List<com.liferay.yithro.ticket.model.TicketFieldOption>
				ticketFieldOptions)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldLocalService.updateTicketField(
			ticketFieldId, nameMap, descriptionMap, type, visibility,
			ticketFieldOptions);
	}

	/**
	 * Updates the ticket field in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketField the ticket field
	 * @return the ticket field that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketField updateTicketField(
		com.liferay.yithro.ticket.model.TicketField ticketField) {

		return _ticketFieldLocalService.updateTicketField(ticketField);
	}

	@Override
	public TicketFieldLocalService getWrappedService() {
		return _ticketFieldLocalService;
	}

	@Override
	public void setWrappedService(
		TicketFieldLocalService ticketFieldLocalService) {

		_ticketFieldLocalService = ticketFieldLocalService;
	}

	private TicketFieldLocalService _ticketFieldLocalService;

}