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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.yithro.ticket.exception.NoSuchTicketCommunicationException;
import com.liferay.yithro.ticket.model.TicketCommunication;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket communication service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommunicationUtil
 * @generated
 */
@ProviderType
public interface TicketCommunicationPersistence
	extends BasePersistence<TicketCommunication> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketCommunicationUtil} to access the ticket communication persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @return the matching ticket communications
	 */
	public java.util.List<TicketCommunication> findByTEI_V(
		long ticketEntryId, int visibility);

	/**
	 * Returns a range of all the ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @return the range of matching ticket communications
	 */
	public java.util.List<TicketCommunication> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end);

	/**
	 * Returns an ordered range of all the ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket communications
	 */
	public java.util.List<TicketCommunication> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketCommunication>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>.
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
	public java.util.List<TicketCommunication> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketCommunication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket communication
	 * @throws NoSuchTicketCommunicationException if a matching ticket communication could not be found
	 */
	public TicketCommunication findByTEI_V_First(
			long ticketEntryId, int visibility,
			com.liferay.portal.kernel.util.OrderByComparator
				<TicketCommunication> orderByComparator)
		throws NoSuchTicketCommunicationException;

	/**
	 * Returns the first ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket communication, or <code>null</code> if a matching ticket communication could not be found
	 */
	public TicketCommunication fetchByTEI_V_First(
		long ticketEntryId, int visibility,
		com.liferay.portal.kernel.util.OrderByComparator<TicketCommunication>
			orderByComparator);

	/**
	 * Returns the last ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket communication
	 * @throws NoSuchTicketCommunicationException if a matching ticket communication could not be found
	 */
	public TicketCommunication findByTEI_V_Last(
			long ticketEntryId, int visibility,
			com.liferay.portal.kernel.util.OrderByComparator
				<TicketCommunication> orderByComparator)
		throws NoSuchTicketCommunicationException;

	/**
	 * Returns the last ticket communication in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket communication, or <code>null</code> if a matching ticket communication could not be found
	 */
	public TicketCommunication fetchByTEI_V_Last(
		long ticketEntryId, int visibility,
		com.liferay.portal.kernel.util.OrderByComparator<TicketCommunication>
			orderByComparator);

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
	public TicketCommunication[] findByTEI_V_PrevAndNext(
			long ticketCommunicationId, long ticketEntryId, int visibility,
			com.liferay.portal.kernel.util.OrderByComparator
				<TicketCommunication> orderByComparator)
		throws NoSuchTicketCommunicationException;

	/**
	 * Removes all the ticket communications where ticketEntryId = &#63; and visibility = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 */
	public void removeByTEI_V(long ticketEntryId, int visibility);

	/**
	 * Returns the number of ticket communications where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @return the number of matching ticket communications
	 */
	public int countByTEI_V(long ticketEntryId, int visibility);

	/**
	 * Caches the ticket communication in the entity cache if it is enabled.
	 *
	 * @param ticketCommunication the ticket communication
	 */
	public void cacheResult(TicketCommunication ticketCommunication);

	/**
	 * Caches the ticket communications in the entity cache if it is enabled.
	 *
	 * @param ticketCommunications the ticket communications
	 */
	public void cacheResult(
		java.util.List<TicketCommunication> ticketCommunications);

	/**
	 * Creates a new ticket communication with the primary key. Does not add the ticket communication to the database.
	 *
	 * @param ticketCommunicationId the primary key for the new ticket communication
	 * @return the new ticket communication
	 */
	public TicketCommunication create(long ticketCommunicationId);

	/**
	 * Removes the ticket communication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication that was removed
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	public TicketCommunication remove(long ticketCommunicationId)
		throws NoSuchTicketCommunicationException;

	public TicketCommunication updateImpl(
		TicketCommunication ticketCommunication);

	/**
	 * Returns the ticket communication with the primary key or throws a <code>NoSuchTicketCommunicationException</code> if it could not be found.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	public TicketCommunication findByPrimaryKey(long ticketCommunicationId)
		throws NoSuchTicketCommunicationException;

	/**
	 * Returns the ticket communication with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication, or <code>null</code> if a ticket communication with the primary key could not be found
	 */
	public TicketCommunication fetchByPrimaryKey(long ticketCommunicationId);

	/**
	 * Returns all the ticket communications.
	 *
	 * @return the ticket communications
	 */
	public java.util.List<TicketCommunication> findAll();

	/**
	 * Returns a range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @return the range of ticket communications
	 */
	public java.util.List<TicketCommunication> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket communications
	 */
	public java.util.List<TicketCommunication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketCommunication>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket communications
	 */
	public java.util.List<TicketCommunication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketCommunication>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket communications from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket communications.
	 *
	 * @return the number of ticket communications
	 */
	public int countAll();

}