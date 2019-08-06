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
import com.liferay.yithro.ticket.exception.NoSuchTicketEntryException;
import com.liferay.yithro.ticket.model.TicketEntry;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketEntryUtil
 * @generated
 */
@ProviderType
public interface TicketEntryPersistence extends BasePersistence<TicketEntry> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketEntryUtil} to access the ticket entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @return the matching ticket entries
	 */
	public java.util.List<TicketEntry> findByGtModifiedDate(Date modifiedDate);

	/**
	 * Returns a range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end);

	/**
	 * Returns an ordered range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	public TicketEntry findByGtModifiedDate_First(
			Date modifiedDate,
			com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
				orderByComparator)
		throws NoSuchTicketEntryException;

	/**
	 * Returns the first ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	public TicketEntry fetchByGtModifiedDate_First(
		Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator);

	/**
	 * Returns the last ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	public TicketEntry findByGtModifiedDate_Last(
			Date modifiedDate,
			com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
				orderByComparator)
		throws NoSuchTicketEntryException;

	/**
	 * Returns the last ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	public TicketEntry fetchByGtModifiedDate_Last(
		Date modifiedDate,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator);

	/**
	 * Returns the ticket entries before and after the current ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param ticketEntryId the primary key of the current ticket entry
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	public TicketEntry[] findByGtModifiedDate_PrevAndNext(
			long ticketEntryId, Date modifiedDate,
			com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
				orderByComparator)
		throws NoSuchTicketEntryException;

	/**
	 * Removes all the ticket entries where modifiedDate &ge; &#63; from the database.
	 *
	 * @param modifiedDate the modified date
	 */
	public void removeByGtModifiedDate(Date modifiedDate);

	/**
	 * Returns the number of ticket entries where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @return the number of matching ticket entries
	 */
	public int countByGtModifiedDate(Date modifiedDate);

	/**
	 * Returns all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @return the matching ticket entries
	 */
	public java.util.List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId);

	/**
	 * Returns a range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end);

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	public TicketEntry findByU_TSI_First(
			long userId, long ticketStatusId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
				orderByComparator)
		throws NoSuchTicketEntryException;

	/**
	 * Returns the first ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	public TicketEntry fetchByU_TSI_First(
		long userId, long ticketStatusId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator);

	/**
	 * Returns the last ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	public TicketEntry findByU_TSI_Last(
			long userId, long ticketStatusId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
				orderByComparator)
		throws NoSuchTicketEntryException;

	/**
	 * Returns the last ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	public TicketEntry fetchByU_TSI_Last(
		long userId, long ticketStatusId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator);

	/**
	 * Returns the ticket entries before and after the current ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param ticketEntryId the primary key of the current ticket entry
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	public TicketEntry[] findByU_TSI_PrevAndNext(
			long ticketEntryId, long userId, long ticketStatusId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
				orderByComparator)
		throws NoSuchTicketEntryException;

	/**
	 * Returns all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @return the matching ticket entries
	 */
	public java.util.List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds);

	/**
	 * Returns a range of all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end);

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	public java.util.List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket entries where userId = &#63; and ticketStatusId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 */
	public void removeByU_TSI(long userId, long ticketStatusId);

	/**
	 * Returns the number of ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @return the number of matching ticket entries
	 */
	public int countByU_TSI(long userId, long ticketStatusId);

	/**
	 * Returns the number of ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @return the number of matching ticket entries
	 */
	public int countByU_TSI(long userId, long[] ticketStatusIds);

	/**
	 * Caches the ticket entry in the entity cache if it is enabled.
	 *
	 * @param ticketEntry the ticket entry
	 */
	public void cacheResult(TicketEntry ticketEntry);

	/**
	 * Caches the ticket entries in the entity cache if it is enabled.
	 *
	 * @param ticketEntries the ticket entries
	 */
	public void cacheResult(java.util.List<TicketEntry> ticketEntries);

	/**
	 * Creates a new ticket entry with the primary key. Does not add the ticket entry to the database.
	 *
	 * @param ticketEntryId the primary key for the new ticket entry
	 * @return the new ticket entry
	 */
	public TicketEntry create(long ticketEntryId);

	/**
	 * Removes the ticket entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry that was removed
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	public TicketEntry remove(long ticketEntryId)
		throws NoSuchTicketEntryException;

	public TicketEntry updateImpl(TicketEntry ticketEntry);

	/**
	 * Returns the ticket entry with the primary key or throws a <code>NoSuchTicketEntryException</code> if it could not be found.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	public TicketEntry findByPrimaryKey(long ticketEntryId)
		throws NoSuchTicketEntryException;

	/**
	 * Returns the ticket entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry, or <code>null</code> if a ticket entry with the primary key could not be found
	 */
	public TicketEntry fetchByPrimaryKey(long ticketEntryId);

	/**
	 * Returns all the ticket entries.
	 *
	 * @return the ticket entries
	 */
	public java.util.List<TicketEntry> findAll();

	/**
	 * Returns a range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of ticket entries
	 */
	public java.util.List<TicketEntry> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket entries
	 */
	public java.util.List<TicketEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket entries
	 */
	public java.util.List<TicketEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketEntry>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket entries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket entries.
	 *
	 * @return the number of ticket entries
	 */
	public int countAll();

}