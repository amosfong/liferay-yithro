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
 * Provides a wrapper for {@link TicketAttachmentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TicketAttachmentLocalService
 * @generated
 */
@ProviderType
public class TicketAttachmentLocalServiceWrapper
	implements TicketAttachmentLocalService,
			   ServiceWrapper<TicketAttachmentLocalService> {

	public TicketAttachmentLocalServiceWrapper(
		TicketAttachmentLocalService ticketAttachmentLocalService) {

		_ticketAttachmentLocalService = ticketAttachmentLocalService;
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment addTicketAttachment(
			long userId, long ticketEntryId, String fileName, java.io.File file,
			int visibility, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.addTicketAttachment(
			userId, ticketEntryId, fileName, file, visibility, status,
			serviceContext);
	}

	/**
	 * Adds the ticket attachment to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachment the ticket attachment
	 * @return the ticket attachment that was added
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment addTicketAttachment(
		com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment) {

		return _ticketAttachmentLocalService.addTicketAttachment(
			ticketAttachment);
	}

	/**
	 * Creates a new ticket attachment with the primary key. Does not add the ticket attachment to the database.
	 *
	 * @param ticketAttachmentId the primary key for the new ticket attachment
	 * @return the new ticket attachment
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment
		createTicketAttachment(long ticketAttachmentId) {

		return _ticketAttachmentLocalService.createTicketAttachment(
			ticketAttachmentId);
	}

	@Override
	public void deleteOrphanTicketAttachments()
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketAttachmentLocalService.deleteOrphanTicketAttachments();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the ticket attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachmentId the primary key of the ticket attachment
	 * @return the ticket attachment that was removed
	 * @throws PortalException if a ticket attachment with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment
			deleteTicketAttachment(long ticketAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.deleteTicketAttachment(
			ticketAttachmentId);
	}

	/**
	 * Deletes the ticket attachment from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachment the ticket attachment
	 * @return the ticket attachment that was removed
	 * @throws PortalException
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment
			deleteTicketAttachment(
				com.liferay.yithro.ticket.model.TicketAttachment
					ticketAttachment)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.deleteTicketAttachment(
			ticketAttachment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ticketAttachmentLocalService.dynamicQuery();
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

		return _ticketAttachmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketAttachmentLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _ticketAttachmentLocalService.dynamicQuery(
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

		return _ticketAttachmentLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ticketAttachmentLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment
		fetchTicketAttachment(long ticketAttachmentId) {

		return _ticketAttachmentLocalService.fetchTicketAttachment(
			ticketAttachmentId);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment
		fetchTicketAttachment(
			long ticketEntryId, String fileName, int visibility, int status) {

		return _ticketAttachmentLocalService.fetchTicketAttachment(
			ticketEntryId, fileName, visibility, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ticketAttachmentLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.io.InputStream getFileAsStream(
			com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.getFileAsStream(ticketAttachment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ticketAttachmentLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ticketAttachmentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the ticket attachment with the primary key.
	 *
	 * @param ticketAttachmentId the primary key of the ticket attachment
	 * @return the ticket attachment
	 * @throws PortalException if a ticket attachment with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment getTicketAttachment(
			long ticketAttachmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.getTicketAttachment(
			ticketAttachmentId);
	}

	/**
	 * Returns a range of all the ticket attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of ticket attachments
	 */
	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketAttachment>
		getTicketAttachments(int start, int end) {

		return _ticketAttachmentLocalService.getTicketAttachments(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketAttachment>
		getTicketAttachments(long ticketEntryId, int status) {

		return _ticketAttachmentLocalService.getTicketAttachments(
			ticketEntryId, status);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketAttachment>
		getTicketAttachments(
			long ticketEntryId, int[] visibilities, int status) {

		return _ticketAttachmentLocalService.getTicketAttachments(
			ticketEntryId, visibilities, status);
	}

	@Override
	public java.util.List<com.liferay.yithro.ticket.model.TicketAttachment>
		getTicketAttachments(
			long userId, long ticketEntryId, int visibility, int status) {

		return _ticketAttachmentLocalService.getTicketAttachments(
			userId, ticketEntryId, visibility, status);
	}

	/**
	 * Returns the number of ticket attachments.
	 *
	 * @return the number of ticket attachments
	 */
	@Override
	public int getTicketAttachmentsCount() {
		return _ticketAttachmentLocalService.getTicketAttachmentsCount();
	}

	@Override
	public java.io.File getTicketAttachmentsZipFile(
			long ticketEntryId, int[] visibilities)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.getTicketAttachmentsZipFile(
			ticketEntryId, visibilities);
	}

	@Override
	public void updateStatus(
			long userId,
			com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment,
			long ticketEntryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		_ticketAttachmentLocalService.updateStatus(
			userId, ticketAttachment, ticketEntryId, status, serviceContext);
	}

	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment
			updateTicketAttachment(long ticketAttachmentId, long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ticketAttachmentLocalService.updateTicketAttachment(
			ticketAttachmentId, ticketEntryId);
	}

	/**
	 * Updates the ticket attachment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachment the ticket attachment
	 * @return the ticket attachment that was updated
	 */
	@Override
	public com.liferay.yithro.ticket.model.TicketAttachment
		updateTicketAttachment(
			com.liferay.yithro.ticket.model.TicketAttachment ticketAttachment) {

		return _ticketAttachmentLocalService.updateTicketAttachment(
			ticketAttachment);
	}

	@Override
	public TicketAttachmentLocalService getWrappedService() {
		return _ticketAttachmentLocalService;
	}

	@Override
	public void setWrappedService(
		TicketAttachmentLocalService ticketAttachmentLocalService) {

		_ticketAttachmentLocalService = ticketAttachmentLocalService;
	}

	private TicketAttachmentLocalService _ticketAttachmentLocalService;

}