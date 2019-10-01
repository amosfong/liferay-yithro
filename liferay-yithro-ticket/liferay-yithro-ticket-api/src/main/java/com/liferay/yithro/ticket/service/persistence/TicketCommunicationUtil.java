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

package com.liferay.yithro.ticket.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.ticket.model.TicketCommunication;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket communication service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketCommunicationPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommunicationPersistence
 * @generated
 */
public class TicketCommunicationUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TicketCommunication ticketCommunication) {
		getPersistence().clearCache(ticketCommunication);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TicketCommunication> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketCommunication> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketCommunication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketCommunication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketCommunication update(
		TicketCommunication ticketCommunication) {

		return getPersistence().update(ticketCommunication);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketCommunication update(
		TicketCommunication ticketCommunication,
		ServiceContext serviceContext) {

		return getPersistence().update(ticketCommunication, serviceContext);
	}

	/**
	 * Returns all the ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @return the matching ticket communications
	 */
	public static List<TicketCommunication> findByTEI_V(
		long ticketEntryId, int visibility) {

		return getPersistence().findByTEI_V(ticketEntryId, visibility);
	}

	/**
	 * Returns a range of all the ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @return the range of matching ticket communications
	 */
	public static List<TicketCommunication> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibility, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket communications
	 */
	public static List<TicketCommunication> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibility, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket communications
	 */
	public static List<TicketCommunication> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_V(
			ticketEntryId, visibility, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket communication
	 * @throws NoSuchTicketCommunicationException if a matching ticket communication could not be found
	 */
	public static TicketCommunication findByTEI_V_First(
			long ticketEntryId, int visibility,
			OrderByComparator<TicketCommunication> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketCommunicationException {

		return getPersistence().findByTEI_V_First(
			ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns the first ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket communication, or <code>null</code> if a matching ticket communication could not be found
	 */
	public static TicketCommunication fetchByTEI_V_First(
		long ticketEntryId, int visibility,
		OrderByComparator<TicketCommunication> orderByComparator) {

		return getPersistence().fetchByTEI_V_First(
			ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns the last ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket communication
	 * @throws NoSuchTicketCommunicationException if a matching ticket communication could not be found
	 */
	public static TicketCommunication findByTEI_V_Last(
			long ticketEntryId, int visibility,
			OrderByComparator<TicketCommunication> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketCommunicationException {

		return getPersistence().findByTEI_V_Last(
			ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns the last ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket communication, or <code>null</code> if a matching ticket communication could not be found
	 */
	public static TicketCommunication fetchByTEI_V_Last(
		long ticketEntryId, int visibility,
		OrderByComparator<TicketCommunication> orderByComparator) {

		return getPersistence().fetchByTEI_V_Last(
			ticketEntryId, visibility, orderByComparator);
	}

	/**
	 * Returns the ticket communications before and after the current ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketCommunicationId the primary key of the current ticket communication
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket communication
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	public static TicketCommunication[] findByTEI_V_PrevAndNext(
			long ticketCommunicationId, long ticketEntryId, int visibility,
			OrderByComparator<TicketCommunication> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketCommunicationException {

		return getPersistence().findByTEI_V_PrevAndNext(
			ticketCommunicationId, ticketEntryId, visibility,
			orderByComparator);
	}

	/**
	 * Removes all the ticket communications where ticketEntryId = &#63; and visibility = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 */
	public static void removeByTEI_V(long ticketEntryId, int visibility) {
		getPersistence().removeByTEI_V(ticketEntryId, visibility);
	}

	/**
	 * Returns the number of ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @return the number of matching ticket communications
	 */
	public static int countByTEI_V(long ticketEntryId, int visibility) {
		return getPersistence().countByTEI_V(ticketEntryId, visibility);
	}

	/**
	 * Caches the ticket communication in the entity cache if it is enabled.
	 *
	 * @param ticketCommunication the ticket communication
	 */
	public static void cacheResult(TicketCommunication ticketCommunication) {
		getPersistence().cacheResult(ticketCommunication);
	}

	/**
	 * Caches the ticket communications in the entity cache if it is enabled.
	 *
	 * @param ticketCommunications the ticket communications
	 */
	public static void cacheResult(
		List<TicketCommunication> ticketCommunications) {

		getPersistence().cacheResult(ticketCommunications);
	}

	/**
	 * Creates a new ticket communication with the primary key. Does not add the ticket communication to the database.
	 *
	 * @param ticketCommunicationId the primary key for the new ticket communication
	 * @return the new ticket communication
	 */
	public static TicketCommunication create(long ticketCommunicationId) {
		return getPersistence().create(ticketCommunicationId);
	}

	/**
	 * Removes the ticket communication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication that was removed
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	public static TicketCommunication remove(long ticketCommunicationId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketCommunicationException {

		return getPersistence().remove(ticketCommunicationId);
	}

	public static TicketCommunication updateImpl(
		TicketCommunication ticketCommunication) {

		return getPersistence().updateImpl(ticketCommunication);
	}

	/**
	 * Returns the ticket communication with the primary key or throws a <code>NoSuchTicketCommunicationException</code> if it could not be found.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	public static TicketCommunication findByPrimaryKey(
			long ticketCommunicationId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketCommunicationException {

		return getPersistence().findByPrimaryKey(ticketCommunicationId);
	}

	/**
	 * Returns the ticket communication with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication, or <code>null</code> if a ticket communication with the primary key could not be found
	 */
	public static TicketCommunication fetchByPrimaryKey(
		long ticketCommunicationId) {

		return getPersistence().fetchByPrimaryKey(ticketCommunicationId);
	}

	/**
	 * Returns all the ticket communications.
	 *
	 * @return the ticket communications
	 */
	public static List<TicketCommunication> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @return the range of ticket communications
	 */
	public static List<TicketCommunication> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket communications
	 */
	public static List<TicketCommunication> findAll(
		int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket communications
	 */
	public static List<TicketCommunication> findAll(
		int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket communications from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket communications.
	 *
	 * @return the number of ticket communications
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketCommunicationPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketCommunicationPersistence, TicketCommunicationPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketCommunicationPersistence.class);

		ServiceTracker
			<TicketCommunicationPersistence, TicketCommunicationPersistence>
				serviceTracker =
					new ServiceTracker
						<TicketCommunicationPersistence,
						 TicketCommunicationPersistence>(
							 bundle.getBundleContext(),
							 TicketCommunicationPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}