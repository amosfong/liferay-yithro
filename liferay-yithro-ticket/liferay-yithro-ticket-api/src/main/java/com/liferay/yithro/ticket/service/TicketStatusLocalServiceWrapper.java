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
 * Provides a wrapper for {@link TicketStatusLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketStatusLocalService
 * @generated
 */
public class TicketStatusLocalServiceWrapper
	implements TicketStatusLocalService,
			   ServiceWrapper<TicketStatusLocalService> {

	public TicketStatusLocalServiceWrapper(
		TicketStatusLocalService ticketStatusLocalService) {

		_ticketStatusLocalService = ticketStatusLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketStatusLocalServiceUtil} to access the ticket status local service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketStatusLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStatus addTicketStatus(
			long userId, java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int order,
			boolean terminal)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.addTicketStatus(
			userId, nameMap, descriptionMap, order, terminal);
	}

	/**
	 * Adds the ticket status to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStatus the ticket status
	 * @return the ticket status that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStatus addTicketStatus(
		com.liferay.yithro.ticket.model.TicketStatus ticketStatus) {

		return _ticketStatusLocalService.addTicketStatus(ticketStatus);
	}

	/**
	 * Creates a new ticket status with the primary key. Does not add the ticket status to the database.
	 *
	 * @param ticketStatusId the primary key for the new ticket status
	 * @return the new ticket status
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStatus createTicketStatus(
		long ticketStatusId) {

		return _ticketStatusLocalService.createTicketStatus(ticketStatusId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status that was removed
	 * @throws PortalException if a ticket status with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStatus deleteTicketStatus(
			long ticketStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.deleteTicketStatus(ticketStatusId);
	}

	/**
	 * Deletes the ticket status from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStatus the ticket status
	 * @return the ticket status that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStatus deleteTicketStatus(
		com.liferay.yithro.ticket.model.TicketStatus ticketStatus) {

		return _ticketStatusLocalService.deleteTicketStatus(ticketStatus);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketStatusLocalService.dynamicQuery();
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

		return _ticketStatusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketStatusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketStatusLocalService.dynamicQuery(
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

		return _ticketStatusLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketStatusLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketStatus fetchTicketStatus(
		long ticketStatusId) {

		return _ticketStatusLocalService.fetchTicketStatus(ticketStatusId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketStatusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketStatusLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketStatus getInitialTicketStatus()
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.getInitialTicketStatus();
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketStatus getNextTicketStatus(
			long ticketStatusId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.getNextTicketStatus(
			ticketStatusId, status);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketStatusLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket status with the primary key.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status
	 * @throws PortalException if a ticket status with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStatus getTicketStatus(
			long ticketStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.getTicketStatus(ticketStatusId);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketStatus>
		getTicketStatuses(boolean terminal, int status, int start, int end) {

		return _ticketStatusLocalService.getTicketStatuses(
			terminal, status, start, end);
	}

	/**
	 * Returns a range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of ticket statuses
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketStatus>
		getTicketStatuses(int start, int end) {

		return _ticketStatusLocalService.getTicketStatuses(start, end);
	}

	/**
	 * Returns the number of ticket statuses.
	 *
	 * @return the number of ticket statuses
	 */
	@Override
	public int getTicketStatusesCount() {
		return _ticketStatusLocalService.getTicketStatusesCount();
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketStatus updateStatus(
			long ticketStatusId, int status)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.updateStatus(ticketStatusId, status);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketStatus updateTicketStatus(
			long ticketStatusId,
			java.util.Map<java.util.Locale, String> nameMap,
			java.util.Map<java.util.Locale, String> descriptionMap, int order,
			boolean terminal)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStatusLocalService.updateTicketStatus(
			ticketStatusId, nameMap, descriptionMap, order, terminal);
	}

	/**
	 * Updates the ticket status in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStatus the ticket status
	 * @return the ticket status that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStatus updateTicketStatus(
		com.liferay.yithro.ticket.model.TicketStatus ticketStatus) {

		return _ticketStatusLocalService.updateTicketStatus(ticketStatus);
	}

	@Override
	public TicketStatusLocalService getWrappedService() {
		return _ticketStatusLocalService;
	}

	@Override
	public void setWrappedService(
		TicketStatusLocalService ticketStatusLocalService) {

		_ticketStatusLocalService = ticketStatusLocalService;
	}

	private TicketStatusLocalService _ticketStatusLocalService;

}