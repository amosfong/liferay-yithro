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
import com.liferay.yithro.ticket.exception.NoSuchTicketFieldOptionException;
import com.liferay.yithro.ticket.model.TicketFieldOption;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket field option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldOptionUtil
 * @generated
 */
@ProviderType
public interface TicketFieldOptionPersistence
	extends BasePersistence<TicketFieldOption> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketFieldOptionUtil} to access the ticket field option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ticket field options where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket field options
	 */
	public java.util.List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId);

	/**
	 * Returns a range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of matching ticket field options
	 */
	public java.util.List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end);

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket field options
	 */
	public java.util.List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket field options
	 */
	public java.util.List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	public TicketFieldOption findByTicketFieldId_First(
			long ticketFieldId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
				orderByComparator)
		throws NoSuchTicketFieldOptionException;

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	public TicketFieldOption fetchByTicketFieldId_First(
		long ticketFieldId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator);

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	public TicketFieldOption findByTicketFieldId_Last(
			long ticketFieldId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
				orderByComparator)
		throws NoSuchTicketFieldOptionException;

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	public TicketFieldOption fetchByTicketFieldId_Last(
		long ticketFieldId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator);

	/**
	 * Returns the ticket field options before and after the current ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldOptionId the primary key of the current ticket field option
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	public TicketFieldOption[] findByTicketFieldId_PrevAndNext(
			long ticketFieldOptionId, long ticketFieldId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
				orderByComparator)
		throws NoSuchTicketFieldOptionException;

	/**
	 * Removes all the ticket field options where ticketFieldId = &#63; from the database.
	 *
	 * @param ticketFieldId the ticket field ID
	 */
	public void removeByTicketFieldId(long ticketFieldId);

	/**
	 * Returns the number of ticket field options where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @return the number of matching ticket field options
	 */
	public int countByTicketFieldId(long ticketFieldId);

	/**
	 * Returns all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @return the matching ticket field options
	 */
	public java.util.List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status);

	/**
	 * Returns a range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of matching ticket field options
	 */
	public java.util.List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end);

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket field options
	 */
	public java.util.List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket field options
	 */
	public java.util.List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	public TicketFieldOption findByTFI_S_First(
			long ticketFieldId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
				orderByComparator)
		throws NoSuchTicketFieldOptionException;

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	public TicketFieldOption fetchByTFI_S_First(
		long ticketFieldId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator);

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	public TicketFieldOption findByTFI_S_Last(
			long ticketFieldId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
				orderByComparator)
		throws NoSuchTicketFieldOptionException;

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	public TicketFieldOption fetchByTFI_S_Last(
		long ticketFieldId, int status,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator);

	/**
	 * Returns the ticket field options before and after the current ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldOptionId the primary key of the current ticket field option
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	public TicketFieldOption[] findByTFI_S_PrevAndNext(
			long ticketFieldOptionId, long ticketFieldId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
				orderByComparator)
		throws NoSuchTicketFieldOptionException;

	/**
	 * Removes all the ticket field options where ticketFieldId = &#63; and status = &#63; from the database.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 */
	public void removeByTFI_S(long ticketFieldId, int status);

	/**
	 * Returns the number of ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @return the number of matching ticket field options
	 */
	public int countByTFI_S(long ticketFieldId, int status);

	/**
	 * Caches the ticket field option in the entity cache if it is enabled.
	 *
	 * @param ticketFieldOption the ticket field option
	 */
	public void cacheResult(TicketFieldOption ticketFieldOption);

	/**
	 * Caches the ticket field options in the entity cache if it is enabled.
	 *
	 * @param ticketFieldOptions the ticket field options
	 */
	public void cacheResult(
		java.util.List<TicketFieldOption> ticketFieldOptions);

	/**
	 * Creates a new ticket field option with the primary key. Does not add the ticket field option to the database.
	 *
	 * @param ticketFieldOptionId the primary key for the new ticket field option
	 * @return the new ticket field option
	 */
	public TicketFieldOption create(long ticketFieldOptionId);

	/**
	 * Removes the ticket field option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option that was removed
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	public TicketFieldOption remove(long ticketFieldOptionId)
		throws NoSuchTicketFieldOptionException;

	public TicketFieldOption updateImpl(TicketFieldOption ticketFieldOption);

	/**
	 * Returns the ticket field option with the primary key or throws a <code>NoSuchTicketFieldOptionException</code> if it could not be found.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	public TicketFieldOption findByPrimaryKey(long ticketFieldOptionId)
		throws NoSuchTicketFieldOptionException;

	/**
	 * Returns the ticket field option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option, or <code>null</code> if a ticket field option with the primary key could not be found
	 */
	public TicketFieldOption fetchByPrimaryKey(long ticketFieldOptionId);

	/**
	 * Returns all the ticket field options.
	 *
	 * @return the ticket field options
	 */
	public java.util.List<TicketFieldOption> findAll();

	/**
	 * Returns a range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of ticket field options
	 */
	public java.util.List<TicketFieldOption> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket field options
	 */
	public java.util.List<TicketFieldOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket field options
	 */
	public java.util.List<TicketFieldOption> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldOption>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket field options from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket field options.
	 *
	 * @return the number of ticket field options
	 */
	public int countAll();

}