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
 * Provides a wrapper for {@link TicketLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketLinkLocalService
 * @generated
 */
@ProviderType
public class TicketLinkLocalServiceWrapper
	implements TicketLinkLocalService, ServiceWrapper<TicketLinkLocalService> {

	public TicketLinkLocalServiceWrapper(
		TicketLinkLocalService ticketLinkLocalService) {

		_ticketLinkLocalService = ticketLinkLocalService;
	}

	/**
	 * Adds the ticket link to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketLink the ticket link
	 * @return the ticket link that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketLink addTicketLink(
		com.liferay.yithro.ticket.model.TicketLink ticketLink) {

		return _ticketLinkLocalService.addTicketLink(ticketLink);
	}

	@Override
	public void addTicketLinks(
			long userId, long ticketEntryId, String[] urls, int[] types,
			int visibility)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketLinkLocalService.addTicketLinks(
			userId, ticketEntryId, urls, types, visibility);
	}

	/**
	 * Creates a new ticket link with the primary key. Does not add the ticket link to the database.
	 *
	 * @param ticketLinkId the primary key for the new ticket link
	 * @return the new ticket link
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketLink createTicketLink(
		long ticketLinkId) {

		return _ticketLinkLocalService.createTicketLink(ticketLinkId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketLinkLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketLinkId the primary key of the ticket link
	 * @return the ticket link that was removed
	 * @throws PortalException if a ticket link with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketLink deleteTicketLink(
			long ticketLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketLinkLocalService.deleteTicketLink(ticketLinkId);
	}

	/**
	 * Deletes the ticket link from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketLink the ticket link
	 * @return the ticket link that was removed
	 * @throws PortalException
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketLink deleteTicketLink(
			com.liferay.yithro.ticket.model.TicketLink ticketLink)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketLinkLocalService.deleteTicketLink(ticketLink);
	}

	@Override
	public void deleteTicketLinks(long[] ticketLinkIds)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketLinkLocalService.deleteTicketLinks(ticketLinkIds);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketLinkLocalService.dynamicQuery();
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

		return _ticketLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketLinkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketLinkLocalService.dynamicQuery(
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

		return _ticketLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketLink fetchTicketLink(
		long ticketLinkId) {

		return _ticketLinkLocalService.fetchTicketLink(ticketLinkId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketLinkLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketLinkLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket link with the primary key.
	 *
	 * @param ticketLinkId the primary key of the ticket link
	 * @return the ticket link
	 * @throws PortalException if a ticket link with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketLink getTicketLink(
			long ticketLinkId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketLinkLocalService.getTicketLink(ticketLinkId);
	}

	/**
	 * Returns a range of all the ticket links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of ticket links
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketLink>
		getTicketLinks(int start, int end) {

		return _ticketLinkLocalService.getTicketLinks(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketLink>
		getTicketLinks(long ticketEntryId, int visibility) {

		return _ticketLinkLocalService.getTicketLinks(
			ticketEntryId, visibility);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketLink>
		getTicketLinks(long ticketEntryId, int[] visibilities) {

		return _ticketLinkLocalService.getTicketLinks(
			ticketEntryId, visibilities);
	}

	/**
	 * Returns the number of ticket links.
	 *
	 * @return the number of ticket links
	 */
	@Override
	public int getTicketLinksCount() {
		return _ticketLinkLocalService.getTicketLinksCount();
	}

	@Override
	public int getTicketLinksCount(long ticketEntryId, int visibility) {
		return _ticketLinkLocalService.getTicketLinksCount(
			ticketEntryId, visibility);
	}

	@Override
	public int getTicketLinksCount(long ticketEntryId, int[] visibilities) {
		return _ticketLinkLocalService.getTicketLinksCount(
			ticketEntryId, visibilities);
	}

	/**
	 * Updates the ticket link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketLink the ticket link
	 * @return the ticket link that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketLink updateTicketLink(
		com.liferay.yithro.ticket.model.TicketLink ticketLink) {

		return _ticketLinkLocalService.updateTicketLink(ticketLink);
	}

	@Override
	public TicketLinkLocalService getWrappedService() {
		return _ticketLinkLocalService;
	}

	@Override
	public void setWrappedService(
		TicketLinkLocalService ticketLinkLocalService) {

		_ticketLinkLocalService = ticketLinkLocalService;
	}

	private TicketLinkLocalService _ticketLinkLocalService;

}