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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link TicketEntryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryLocalService
 * @generated
 */
@ProviderType
public class TicketEntryLocalServiceWrapper
	implements TicketEntryLocalService,
			   ServiceWrapper<TicketEntryLocalService> {

	public TicketEntryLocalServiceWrapper(
		TicketEntryLocalService ticketEntryLocalService) {

		_ticketEntryLocalService = ticketEntryLocalService;
	}

	/**
	 * Adds the ticket entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketEntry addTicketEntry(
		com.liferay.yithro.ticket.model.TicketEntry ticketEntry) {

		return _ticketEntryLocalService.addTicketEntry(ticketEntry);
	}

	/**
	 * Creates a new ticket entry with the primary key. Does not add the ticket entry to the database.
	 *
	 * @param ticketEntryId the primary key for the new ticket entry
	 * @return the new ticket entry
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketEntry createTicketEntry(
		long ticketEntryId) {

		return _ticketEntryLocalService.createTicketEntry(ticketEntryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry that was removed
	 * @throws PortalException if a ticket entry with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketEntry deleteTicketEntry(
			long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryLocalService.deleteTicketEntry(ticketEntryId);
	}

	/**
	 * Deletes the ticket entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketEntry deleteTicketEntry(
		com.liferay.yithro.ticket.model.TicketEntry ticketEntry) {

		return _ticketEntryLocalService.deleteTicketEntry(ticketEntry);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketEntryLocalService.dynamicQuery();
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

		return _ticketEntryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketEntryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketEntryLocalService.dynamicQuery(
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

		return _ticketEntryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketEntryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketEntry fetchTicketEntry(
		long ticketEntryId) {

		return _ticketEntryLocalService.fetchTicketEntry(ticketEntryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketEntryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketEntryLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of ticket entries
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketEntry>
		getTicketEntries(int start, int end) {

		return _ticketEntryLocalService.getTicketEntries(start, end);
	}

	/**
	 * Returns the number of ticket entries.
	 *
	 * @return the number of ticket entries
	 */
	@Override
	public int getTicketEntriesCount() {
		return _ticketEntryLocalService.getTicketEntriesCount();
	}

	/**
	 * Returns the ticket entry with the primary key.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry
	 * @throws PortalException if a ticket entry with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketEntry getTicketEntry(
			long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryLocalService.getTicketEntry(ticketEntryId);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketEntry reindexTicketEntry(
			long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketEntryLocalService.reindexTicketEntry(ticketEntryId);
	}

	/**
	 * Updates the ticket entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketEntry updateTicketEntry(
		com.liferay.yithro.ticket.model.TicketEntry ticketEntry) {

		return _ticketEntryLocalService.updateTicketEntry(ticketEntry);
	}

	@Override
	public TicketEntryLocalService getWrappedService() {
		return _ticketEntryLocalService;
	}

	@Override
	public void setWrappedService(
		TicketEntryLocalService ticketEntryLocalService) {

		_ticketEntryLocalService = ticketEntryLocalService;
	}

	private TicketEntryLocalService _ticketEntryLocalService;

}