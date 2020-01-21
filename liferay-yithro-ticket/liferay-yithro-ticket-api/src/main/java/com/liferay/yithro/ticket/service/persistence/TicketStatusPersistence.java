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
import com.liferay.yithro.ticket.exception.NoSuchTicketStatusException;
import com.liferay.yithro.ticket.model.TicketStatus;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketStatusUtil
 * @generated
 */
@ProviderType
public interface TicketStatusPersistence extends BasePersistence<TicketStatus> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketStatusUtil} to access the ticket status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ticket statuses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ticket statuses
	 */
	public java.util.List<TicketStatus> findByS(int status);

	/**
	 * Returns a range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of matching ticket statuses
	 */
	public java.util.List<TicketStatus> findByS(int status, int start, int end);

	/**
	 * Returns an ordered range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket statuses
	 */
	public java.util.List<TicketStatus> findByS(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket statuses
	 */
	public java.util.List<TicketStatus> findByS(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	public TicketStatus findByS_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
				orderByComparator)
		throws NoSuchTicketStatusException;

	/**
	 * Returns the first ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	public TicketStatus fetchByS_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator);

	/**
	 * Returns the last ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	public TicketStatus findByS_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
				orderByComparator)
		throws NoSuchTicketStatusException;

	/**
	 * Returns the last ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	public TicketStatus fetchByS_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator);

	/**
	 * Returns the ticket statuses before and after the current ticket status in the ordered set where status = &#63;.
	 *
	 * @param ticketStatusId the primary key of the current ticket status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	public TicketStatus[] findByS_PrevAndNext(
			long ticketStatusId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
				orderByComparator)
		throws NoSuchTicketStatusException;

	/**
	 * Removes all the ticket statuses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByS(int status);

	/**
	 * Returns the number of ticket statuses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ticket statuses
	 */
	public int countByS(int status);

	/**
	 * Returns all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @return the matching ticket statuses
	 */
	public java.util.List<TicketStatus> findByT_S(boolean terminal, int status);

	/**
	 * Returns a range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of matching ticket statuses
	 */
	public java.util.List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end);

	/**
	 * Returns an ordered range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket statuses
	 */
	public java.util.List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket statuses
	 */
	public java.util.List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	public TicketStatus findByT_S_First(
			boolean terminal, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
				orderByComparator)
		throws NoSuchTicketStatusException;

	/**
	 * Returns the first ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	public TicketStatus fetchByT_S_First(
		boolean terminal, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator);

	/**
	 * Returns the last ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	public TicketStatus findByT_S_Last(
			boolean terminal, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
				orderByComparator)
		throws NoSuchTicketStatusException;

	/**
	 * Returns the last ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	public TicketStatus fetchByT_S_Last(
		boolean terminal, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator);

	/**
	 * Returns the ticket statuses before and after the current ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param ticketStatusId the primary key of the current ticket status
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	public TicketStatus[] findByT_S_PrevAndNext(
			long ticketStatusId, boolean terminal, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
				orderByComparator)
		throws NoSuchTicketStatusException;

	/**
	 * Removes all the ticket statuses where terminal = &#63; and status = &#63; from the database.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 */
	public void removeByT_S(boolean terminal, int status);

	/**
	 * Returns the number of ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @return the number of matching ticket statuses
	 */
	public int countByT_S(boolean terminal, int status);

	/**
	 * Caches the ticket status in the entity cache if it is enabled.
	 *
	 * @param ticketStatus the ticket status
	 */
	public void cacheResult(TicketStatus ticketStatus);

	/**
	 * Caches the ticket statuses in the entity cache if it is enabled.
	 *
	 * @param ticketStatuses the ticket statuses
	 */
	public void cacheResult(java.util.List<TicketStatus> ticketStatuses);

	/**
	 * Creates a new ticket status with the primary key. Does not add the ticket status to the database.
	 *
	 * @param ticketStatusId the primary key for the new ticket status
	 * @return the new ticket status
	 */
	public TicketStatus create(long ticketStatusId);

	/**
	 * Removes the ticket status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status that was removed
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	public TicketStatus remove(long ticketStatusId)
		throws NoSuchTicketStatusException;

	public TicketStatus updateImpl(TicketStatus ticketStatus);

	/**
	 * Returns the ticket status with the primary key or throws a <code>NoSuchTicketStatusException</code> if it could not be found.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	public TicketStatus findByPrimaryKey(long ticketStatusId)
		throws NoSuchTicketStatusException;

	/**
	 * Returns the ticket status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status, or <code>null</code> if a ticket status with the primary key could not be found
	 */
	public TicketStatus fetchByPrimaryKey(long ticketStatusId);

	/**
	 * Returns all the ticket statuses.
	 *
	 * @return the ticket statuses
	 */
	public java.util.List<TicketStatus> findAll();

	/**
	 * Returns a range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of ticket statuses
	 */
	public java.util.List<TicketStatus> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket statuses
	 */
	public java.util.List<TicketStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket statuses
	 */
	public java.util.List<TicketStatus> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStatus>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket statuses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket statuses.
	 *
	 * @return the number of ticket statuses
	 */
	public int countAll();

}