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
 * Provides a wrapper for {@link TicketStructureLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketStructureLocalService
 * @generated
 */
@ProviderType
public class TicketStructureLocalServiceWrapper
	implements TicketStructureLocalService,
			   ServiceWrapper<TicketStructureLocalService> {

	public TicketStructureLocalServiceWrapper(
		TicketStructureLocalService ticketStructureLocalService) {

		_ticketStructureLocalService = ticketStructureLocalService;
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketStructure addTicketStructure(
			long userId, String name, String description, String structure)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStructureLocalService.addTicketStructure(
			userId, name, description, structure);
	}

	/**
	 * Adds the ticket structure to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructure the ticket structure
	 * @return the ticket structure that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStructure addTicketStructure(
		com.liferay.yithro.ticket.model.TicketStructure ticketStructure) {

		return _ticketStructureLocalService.addTicketStructure(ticketStructure);
	}

	/**
	 * Creates a new ticket structure with the primary key. Does not add the ticket structure to the database.
	 *
	 * @param ticketStructureId the primary key for the new ticket structure
	 * @return the new ticket structure
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStructure
		createTicketStructure(long ticketStructureId) {

		return _ticketStructureLocalService.createTicketStructure(
			ticketStructureId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStructureLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the ticket structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure that was removed
	 * @throws PortalException if a ticket structure with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStructure
			deleteTicketStructure(long ticketStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStructureLocalService.deleteTicketStructure(
			ticketStructureId);
	}

	/**
	 * Deletes the ticket structure from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructure the ticket structure
	 * @return the ticket structure that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStructure
		deleteTicketStructure(
			com.liferay.yithro.ticket.model.TicketStructure ticketStructure) {

		return _ticketStructureLocalService.deleteTicketStructure(
			ticketStructure);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketStructureLocalService.dynamicQuery();
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

		return _ticketStructureLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketStructureLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketStructureLocalService.dynamicQuery(
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

		return _ticketStructureLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketStructureLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketStructure fetchTicketStructure(
		long ticketStructureId) {

		return _ticketStructureLocalService.fetchTicketStructure(
			ticketStructureId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketStructureLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketStructureLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketStructureLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStructureLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket structure with the primary key.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure
	 * @throws PortalException if a ticket structure with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStructure getTicketStructure(
			long ticketStructureId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStructureLocalService.getTicketStructure(
			ticketStructureId);
	}

	/**
	 * Returns a range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @return the range of ticket structures
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketStructure>
		getTicketStructures(int start, int end) {

		return _ticketStructureLocalService.getTicketStructures(start, end);
	}

	/**
	 * Returns the number of ticket structures.
	 *
	 * @return the number of ticket structures
	 */
	@Override
	public int getTicketStructuresCount() {
		return _ticketStructureLocalService.getTicketStructuresCount();
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketStructure
			updateTicketStructure(
				long ticketStructureId, String name, String description,
				String structure)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketStructureLocalService.updateTicketStructure(
			ticketStructureId, name, description, structure);
	}

	/**
	 * Updates the ticket structure in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructure the ticket structure
	 * @return the ticket structure that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketStructure
		updateTicketStructure(
			com.liferay.yithro.ticket.model.TicketStructure ticketStructure) {

		return _ticketStructureLocalService.updateTicketStructure(
			ticketStructure);
	}

	@Override
	public TicketStructureLocalService getWrappedService() {
		return _ticketStructureLocalService;
	}

	@Override
	public void setWrappedService(
		TicketStructureLocalService ticketStructureLocalService) {

		_ticketStructureLocalService = ticketStructureLocalService;
	}

	private TicketStructureLocalService _ticketStructureLocalService;

}