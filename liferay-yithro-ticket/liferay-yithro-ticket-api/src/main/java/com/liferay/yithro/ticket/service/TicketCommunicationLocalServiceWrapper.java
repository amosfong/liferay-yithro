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
 * Provides a wrapper for {@link TicketCommunicationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommunicationLocalService
 * @generated
 */
@ProviderType
public class TicketCommunicationLocalServiceWrapper
	implements TicketCommunicationLocalService,
			   ServiceWrapper<TicketCommunicationLocalService> {

	public TicketCommunicationLocalServiceWrapper(
		TicketCommunicationLocalService ticketCommunicationLocalService) {

		_ticketCommunicationLocalService = ticketCommunicationLocalService;
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
			addTicketCommunication(
				long userId, long ticketEntryId, String channel,
				com.liferay.portal.kernel.json.JSONObject dataJSONObject,
				int visibility)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommunicationLocalService.addTicketCommunication(
			userId, ticketEntryId, channel, dataJSONObject, visibility);
	}

	/**
	 * Adds the ticket communication to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
		addTicketCommunication(
			com.liferay.yithro.ticket.model.TicketCommunication
				ticketCommunication) {

		return _ticketCommunicationLocalService.addTicketCommunication(
			ticketCommunication);
	}

	/**
	 * Creates a new ticket communication with the primary key. Does not add the ticket communication to the database.
	 *
	 * @param ticketCommunicationId the primary key for the new ticket communication
	 * @return the new ticket communication
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
		createTicketCommunication(long ticketCommunicationId) {

		return _ticketCommunicationLocalService.createTicketCommunication(
			ticketCommunicationId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommunicationLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the ticket communication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication that was removed
	 * @throws PortalException if a ticket communication with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
			deleteTicketCommunication(long ticketCommunicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommunicationLocalService.deleteTicketCommunication(
			ticketCommunicationId);
	}

	/**
	 * Deletes the ticket communication from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
		deleteTicketCommunication(
			com.liferay.yithro.ticket.model.TicketCommunication
				ticketCommunication) {

		return _ticketCommunicationLocalService.deleteTicketCommunication(
			ticketCommunication);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketCommunicationLocalService.dynamicQuery();
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

		return _ticketCommunicationLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ticketCommunicationLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ticketCommunicationLocalService.dynamicQuery(
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

		return _ticketCommunicationLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketCommunicationLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
		fetchTicketCommunication(long ticketCommunicationId) {

		return _ticketCommunicationLocalService.fetchTicketCommunication(
			ticketCommunicationId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketCommunicationLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketCommunicationLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketCommunicationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommunicationLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the ticket communication with the primary key.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication
	 * @throws PortalException if a ticket communication with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
			getTicketCommunication(long ticketCommunicationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommunicationLocalService.getTicketCommunication(
			ticketCommunicationId);
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
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketCommunication>
		getTicketCommunications(int start, int end) {

		return _ticketCommunicationLocalService.getTicketCommunications(
			start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketCommunication>
			getTicketCommunications(
				long ticketEntryId, int visibility, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommunicationLocalService.getTicketCommunications(
			ticketEntryId, visibility, start, end);
	}

	/**
	 * Returns the number of ticket communications.
	 *
	 * @return the number of ticket communications
	 */
	@Override
	public int getTicketCommunicationsCount() {
		return _ticketCommunicationLocalService.getTicketCommunicationsCount();
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
			updateTicketCommunication(
				long ticketCommunicationId,
				com.liferay.portal.kernel.json.JSONObject dataJSONObject)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketCommunicationLocalService.updateTicketCommunication(
			ticketCommunicationId, dataJSONObject);
	}

	/**
	 * Updates the ticket communication in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunication the ticket communication
	 * @return the ticket communication that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketCommunication
		updateTicketCommunication(
			com.liferay.yithro.ticket.model.TicketCommunication
				ticketCommunication) {

		return _ticketCommunicationLocalService.updateTicketCommunication(
			ticketCommunication);
	}

	@Override
	public TicketCommunicationLocalService getWrappedService() {
		return _ticketCommunicationLocalService;
	}

	@Override
	public void setWrappedService(
		TicketCommunicationLocalService ticketCommunicationLocalService) {

		_ticketCommunicationLocalService = ticketCommunicationLocalService;
	}

	private TicketCommunicationLocalService _ticketCommunicationLocalService;

}