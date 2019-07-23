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
 * Provides a wrapper for {@link TicketFieldOptionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldOptionLocalService
 * @generated
 */
@ProviderType
public class TicketFieldOptionLocalServiceWrapper
	implements TicketFieldOptionLocalService,
			   ServiceWrapper<TicketFieldOptionLocalService> {

	public TicketFieldOptionLocalServiceWrapper(
		TicketFieldOptionLocalService ticketFieldOptionLocalService) {

		_ticketFieldOptionLocalService = ticketFieldOptionLocalService;
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
			addTicketFieldOption(
				long companyId, long ticketFieldId,
				java.util.Map<java.util.Locale, String> nameMap, int visibility,
				int order, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldOptionLocalService.addTicketFieldOption(
			companyId, ticketFieldId, nameMap, visibility, order, status);
	}

	/**
	 * Adds the ticket field option to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOption the ticket field option
	 * @return the ticket field option that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
		addTicketFieldOption(
			com.liferay.yithro.ticket.model.TicketFieldOption
				ticketFieldOption) {

		return _ticketFieldOptionLocalService.addTicketFieldOption(
			ticketFieldOption);
	}

	/**
	 * Creates a new ticket field option with the primary key. Does not add the ticket field option to the database.
	 *
	 * @param ticketFieldOptionId the primary key for the new ticket field option
	 * @return the new ticket field option
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
		createTicketFieldOption(long ticketFieldOptionId) {

		return _ticketFieldOptionLocalService.createTicketFieldOption(
			ticketFieldOptionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldOptionLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the ticket field option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option that was removed
	 * @throws PortalException if a ticket field option with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
			deleteTicketFieldOption(long ticketFieldOptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldOptionLocalService.deleteTicketFieldOption(
			ticketFieldOptionId);
	}

	/**
	 * Deletes the ticket field option from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOption the ticket field option
	 * @return the ticket field option that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
		deleteTicketFieldOption(
			com.liferay.yithro.ticket.model.TicketFieldOption
				ticketFieldOption) {

		return _ticketFieldOptionLocalService.deleteTicketFieldOption(
			ticketFieldOption);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketFieldOptionLocalService.dynamicQuery();
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

		return _ticketFieldOptionLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ticketFieldOptionLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ticketFieldOptionLocalService.dynamicQuery(
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

		return _ticketFieldOptionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketFieldOptionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
		fetchTicketFieldOption(long ticketFieldOptionId) {

		return _ticketFieldOptionLocalService.fetchTicketFieldOption(
			ticketFieldOptionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketFieldOptionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketFieldOptionLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketFieldOptionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldOptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket field option with the primary key.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option
	 * @throws PortalException if a ticket field option with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
			getTicketFieldOption(long ticketFieldOptionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldOptionLocalService.getTicketFieldOption(
			ticketFieldOptionId);
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
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketFieldOption>
		getTicketFieldOptions(int start, int end) {

		return _ticketFieldOptionLocalService.getTicketFieldOptions(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketFieldOption>
		getTicketFieldOptions(long ticketFieldId) {

		return _ticketFieldOptionLocalService.getTicketFieldOptions(
			ticketFieldId);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketFieldOption>
		getTicketFieldOptions(long ticketFieldId, int status) {

		return _ticketFieldOptionLocalService.getTicketFieldOptions(
			ticketFieldId, status);
	}

	/**
	 * Returns the number of ticket field options.
	 *
	 * @return the number of ticket field options
	 */
	@Override
	public int getTicketFieldOptionsCount() {
		return _ticketFieldOptionLocalService.getTicketFieldOptionsCount();
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
			updateTicketFieldOption(
				long ticketFieldOptionId,
				java.util.Map<java.util.Locale, String> nameMap, int visibility,
				int order)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldOptionLocalService.updateTicketFieldOption(
			ticketFieldOptionId, nameMap, visibility, order);
	}

	/**
	 * Updates the ticket field option in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOption the ticket field option
	 * @return the ticket field option that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldOption
		updateTicketFieldOption(
			com.liferay.yithro.ticket.model.TicketFieldOption
				ticketFieldOption) {

		return _ticketFieldOptionLocalService.updateTicketFieldOption(
			ticketFieldOption);
	}

	@Override
	public TicketFieldOptionLocalService getWrappedService() {
		return _ticketFieldOptionLocalService;
	}

	@Override
	public void setWrappedService(
		TicketFieldOptionLocalService ticketFieldOptionLocalService) {

		_ticketFieldOptionLocalService = ticketFieldOptionLocalService;
	}

	private TicketFieldOptionLocalService _ticketFieldOptionLocalService;

}