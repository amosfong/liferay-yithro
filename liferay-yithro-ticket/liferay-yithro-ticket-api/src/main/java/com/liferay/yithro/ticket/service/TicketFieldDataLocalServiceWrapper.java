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
 * Provides a wrapper for {@link TicketFieldDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldDataLocalService
 * @generated
 */
@ProviderType
public class TicketFieldDataLocalServiceWrapper
	implements TicketFieldDataLocalService,
			   ServiceWrapper<TicketFieldDataLocalService> {

	public TicketFieldDataLocalServiceWrapper(
		TicketFieldDataLocalService ticketFieldDataLocalService) {

		_ticketFieldDataLocalService = ticketFieldDataLocalService;
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketFieldData addTicketFieldData(
			long ticketEntryId, long ticketFieldId, String data)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldDataLocalService.addTicketFieldData(
			ticketEntryId, ticketFieldId, data);
	}

	@Override
	public void addTicketFieldData(
			long ticketEntryId, java.util.Map<Long, String> ticketFieldsMap)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketFieldDataLocalService.addTicketFieldData(
			ticketEntryId, ticketFieldsMap);
	}

	/**
	 * Adds the ticket field data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldData the ticket field data
	 * @return the ticket field data that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldData addTicketFieldData(
		com.liferay.yithro.ticket.model.TicketFieldData ticketFieldData) {

		return _ticketFieldDataLocalService.addTicketFieldData(ticketFieldData);
	}

	/**
	 * Creates a new ticket field data with the primary key. Does not add the ticket field data to the database.
	 *
	 * @param ticketFieldDataId the primary key for the new ticket field data
	 * @return the new ticket field data
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldData
		createTicketFieldData(long ticketFieldDataId) {

		return _ticketFieldDataLocalService.createTicketFieldData(
			ticketFieldDataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldDataLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the ticket field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data that was removed
	 * @throws PortalException if a ticket field data with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldData
			deleteTicketFieldData(long ticketFieldDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldDataLocalService.deleteTicketFieldData(
			ticketFieldDataId);
	}

	/**
	 * Deletes the ticket field data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldData the ticket field data
	 * @return the ticket field data that was removed
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldData
		deleteTicketFieldData(
			com.liferay.yithro.ticket.model.TicketFieldData ticketFieldData) {

		return _ticketFieldDataLocalService.deleteTicketFieldData(
			ticketFieldData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketFieldDataLocalService.dynamicQuery();
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

		return _ticketFieldDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketFieldDataLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketFieldDataLocalService.dynamicQuery(
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

		return _ticketFieldDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketFieldDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketFieldData fetchTicketFieldData(
		long ticketFieldDataId) {

		return _ticketFieldDataLocalService.fetchTicketFieldData(
			ticketFieldDataId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketFieldDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public String getData(long ticketEntryId, long ticketFieldId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldDataLocalService.getData(
			ticketEntryId, ticketFieldId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketFieldDataLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketFieldDataLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldDataLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketFieldData>
		getTicketEntryFieldData(long ticketEntryId) {

		return _ticketFieldDataLocalService.getTicketEntryFieldData(
			ticketEntryId);
	}

	/**
	 * Returns the ticket field data with the primary key.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data
	 * @throws PortalException if a ticket field data with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldData getTicketFieldData(
			long ticketFieldDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketFieldDataLocalService.getTicketFieldData(
			ticketFieldDataId);
	}

	/**
	 * Returns a range of all the ticket field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @return the range of ticket field datas
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketFieldData>
		getTicketFieldDatas(int start, int end) {

		return _ticketFieldDataLocalService.getTicketFieldDatas(start, end);
	}

	/**
	 * Returns the number of ticket field datas.
	 *
	 * @return the number of ticket field datas
	 */
	@Override
	public int getTicketFieldDatasCount() {
		return _ticketFieldDataLocalService.getTicketFieldDatasCount();
	}

	@Override
	public java.util.Map<Long, String> getTicketFieldsMap(long ticketEntryId) {
		return _ticketFieldDataLocalService.getTicketFieldsMap(ticketEntryId);
	}

	@Override
	public void updateTicketFieldData(
			long userId, long ticketEntryId,
			java.util.Map<Long, String> ticketFieldsMap,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketFieldDataLocalService.updateTicketFieldData(
			userId, ticketEntryId, ticketFieldsMap, serviceContext);
	}

	/**
	 * Updates the ticket field data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldData the ticket field data
	 * @return the ticket field data that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketFieldData
		updateTicketFieldData(
			com.liferay.yithro.ticket.model.TicketFieldData ticketFieldData) {

		return _ticketFieldDataLocalService.updateTicketFieldData(
			ticketFieldData);
	}

	@Override
	public TicketFieldDataLocalService getWrappedService() {
		return _ticketFieldDataLocalService;
	}

	@Override
	public void setWrappedService(
		TicketFieldDataLocalService ticketFieldDataLocalService) {

		_ticketFieldDataLocalService = ticketFieldDataLocalService;
	}

	private TicketFieldDataLocalService _ticketFieldDataLocalService;

}