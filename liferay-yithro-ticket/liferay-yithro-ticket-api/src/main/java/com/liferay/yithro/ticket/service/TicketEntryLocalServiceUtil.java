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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for TicketEntry. This utility wraps
 * <code>com.liferay.yithro.ticket.service.impl.TicketEntryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryLocalService
 * @generated
 */
public class TicketEntryLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketEntryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketEntryLocalServiceUtil} to access the ticket entry local service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketEntryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static com.liferay.yithro.ticket.model.TicketEntry addTicketEntry(
			long userId, long ticketStructureId, long ticketStatusId,
			String languageId, String summary, String description, int weight,
			java.util.Map<Long, String> ticketFieldsMap,
			java.util.List<com.liferay.yithro.ticket.model.TicketAttachment>
				ticketAttachments)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addTicketEntry(
			userId, ticketStructureId, ticketStatusId, languageId, summary,
			description, weight, ticketFieldsMap, ticketAttachments);
	}

	/**
	 * Adds the ticket entry to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was added
	 */
	public static com.liferay.yithro.ticket.model.TicketEntry addTicketEntry(
		com.liferay.yithro.ticket.model.TicketEntry ticketEntry) {

		return getService().addTicketEntry(ticketEntry);
	}

	/**
	 * Creates a new ticket entry with the primary key. Does not add the ticket entry to the database.
	 *
	 * @param ticketEntryId the primary key for the new ticket entry
	 * @return the new ticket entry
	 */
	public static com.liferay.yithro.ticket.model.TicketEntry createTicketEntry(
		long ticketEntryId) {

		return getService().createTicketEntry(ticketEntryId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the ticket entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry that was removed
	 * @throws PortalException if a ticket entry with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketEntry deleteTicketEntry(
			long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketEntry(ticketEntryId);
	}

	/**
	 * Deletes the ticket entry from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was removed
	 * @throws PortalException
	 */
	public static com.liferay.yithro.ticket.model.TicketEntry deleteTicketEntry(
			com.liferay.yithro.ticket.model.TicketEntry ticketEntry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteTicketEntry(ticketEntry);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.yithro.ticket.model.TicketEntry fetchTicketEntry(
		long ticketEntryId) {

		return getService().fetchTicketEntry(ticketEntryId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static java.util.List<com.liferay.yithro.ticket.model.TicketEntry>
		getTicketEntries(java.util.Date modifiedDate, int start, int end) {

		return getService().getTicketEntries(modifiedDate, start, end);
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
	public static java.util.List<com.liferay.yithro.ticket.model.TicketEntry>
		getTicketEntries(int start, int end) {

		return getService().getTicketEntries(start, end);
	}

	public static java.util.List<com.liferay.yithro.ticket.model.TicketEntry>
		getTicketEntries(
			long userId, long[] ticketStatusIds, int start, int end) {

		return getService().getTicketEntries(
			userId, ticketStatusIds, start, end);
	}

	/**
	 * Returns the number of ticket entries.
	 *
	 * @return the number of ticket entries
	 */
	public static int getTicketEntriesCount() {
		return getService().getTicketEntriesCount();
	}

	public static int getTicketEntriesCount(java.util.Date modifiedDate) {
		return getService().getTicketEntriesCount(modifiedDate);
	}

	public static int getTicketEntriesCount(
		long userId, long[] ticketStatusIds) {

		return getService().getTicketEntriesCount(userId, ticketStatusIds);
	}

	/**
	 * Returns the ticket entry with the primary key.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry
	 * @throws PortalException if a ticket entry with the primary key could not be found
	 */
	public static com.liferay.yithro.ticket.model.TicketEntry getTicketEntry(
			long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTicketEntry(ticketEntryId);
	}

	public static com.liferay.yithro.ticket.model.TicketEntry
			reindexTicketEntry(long ticketEntryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().reindexTicketEntry(ticketEntryId);
	}

	public static com.liferay.portal.kernel.search.Hits search(
		long companyId, String keywords, int start, int end,
		com.liferay.portal.kernel.search.Sort sort) {

		return getService().search(companyId, keywords, start, end, sort);
	}

	public static void sendEmail(
			long userId,
			com.liferay.yithro.ticket.model.TicketEntry ticketEntry,
			com.liferay.yithro.ticket.model.TicketComment ticketComment,
			String action)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().sendEmail(userId, ticketEntry, ticketComment, action);
	}

	public static void updatePendingTypes(
			long userId, long ticketEntryId, int[] pendingTypes)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updatePendingTypes(userId, ticketEntryId, pendingTypes);
	}

	public static com.liferay.yithro.ticket.model.TicketEntry updateTicketEntry(
			long ticketEntryId, long reportedByUserId, long ticketStatusId,
			String languageId, String summary, String description, int weight,
			java.util.Date dueDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketEntry(
			ticketEntryId, reportedByUserId, ticketStatusId, languageId,
			summary, description, weight, dueDate);
	}

	/**
	 * Updates the ticket entry in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntry the ticket entry
	 * @return the ticket entry that was updated
	 */
	public static com.liferay.yithro.ticket.model.TicketEntry updateTicketEntry(
		com.liferay.yithro.ticket.model.TicketEntry ticketEntry) {

		return getService().updateTicketEntry(ticketEntry);
	}

	public static com.liferay.yithro.ticket.model.TicketEntry
			updateTicketStatus(long ticketEntryId, long ticketStatusId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().updateTicketStatus(ticketEntryId, ticketStatusId);
	}

	public static TicketEntryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketEntryLocalService, TicketEntryLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TicketEntryLocalService.class);

		ServiceTracker<TicketEntryLocalService, TicketEntryLocalService>
			serviceTracker =
				new ServiceTracker
					<TicketEntryLocalService, TicketEntryLocalService>(
						bundle.getBundleContext(),
						TicketEntryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}