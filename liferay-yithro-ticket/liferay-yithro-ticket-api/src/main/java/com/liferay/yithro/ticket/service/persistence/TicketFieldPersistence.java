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
import com.liferay.yithro.ticket.exception.NoSuchTicketFieldException;
import com.liferay.yithro.ticket.model.TicketField;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldUtil
 * @generated
 */
@ProviderType
public interface TicketFieldPersistence extends BasePersistence<TicketField> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketFieldUtil} to access the ticket field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the ticket field where systemKey = &#63; or throws a <code>NoSuchTicketFieldException</code> if it could not be found.
	 *
	 * @param systemKey the system key
	 * @return the matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	public TicketField findBySystemKey(String systemKey)
		throws NoSuchTicketFieldException;

	/**
	 * Returns the ticket field where systemKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param systemKey the system key
	 * @return the matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	public TicketField fetchBySystemKey(String systemKey);

	/**
	 * Returns the ticket field where systemKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param systemKey the system key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	public TicketField fetchBySystemKey(
		String systemKey, boolean useFinderCache);

	/**
	 * Removes the ticket field where systemKey = &#63; from the database.
	 *
	 * @param systemKey the system key
	 * @return the ticket field that was removed
	 */
	public TicketField removeBySystemKey(String systemKey)
		throws NoSuchTicketFieldException;

	/**
	 * Returns the number of ticket fields where systemKey = &#63;.
	 *
	 * @param systemKey the system key
	 * @return the number of matching ticket fields
	 */
	public int countBySystemKey(String systemKey);

	/**
	 * Returns all the ticket fields where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ticket fields
	 */
	public java.util.List<TicketField> findByStatus(int status);

	/**
	 * Returns a range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @return the range of matching ticket fields
	 */
	public java.util.List<TicketField> findByStatus(
		int status, int start, int end);

	/**
	 * Returns an ordered range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket fields
	 */
	public java.util.List<TicketField> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketField>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket fields
	 */
	public java.util.List<TicketField> findByStatus(
		int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	public TicketField findByStatus_First(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketField>
				orderByComparator)
		throws NoSuchTicketFieldException;

	/**
	 * Returns the first ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	public TicketField fetchByStatus_First(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<TicketField>
			orderByComparator);

	/**
	 * Returns the last ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	public TicketField findByStatus_Last(
			int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketField>
				orderByComparator)
		throws NoSuchTicketFieldException;

	/**
	 * Returns the last ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	public TicketField fetchByStatus_Last(
		int status,
		com.liferay.portal.kernel.util.OrderByComparator<TicketField>
			orderByComparator);

	/**
	 * Returns the ticket fields before and after the current ticket field in the ordered set where status = &#63;.
	 *
	 * @param ticketFieldId the primary key of the current ticket field
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	public TicketField[] findByStatus_PrevAndNext(
			long ticketFieldId, int status,
			com.liferay.portal.kernel.util.OrderByComparator<TicketField>
				orderByComparator)
		throws NoSuchTicketFieldException;

	/**
	 * Removes all the ticket fields where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	public void removeByStatus(int status);

	/**
	 * Returns the number of ticket fields where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ticket fields
	 */
	public int countByStatus(int status);

	/**
	 * Caches the ticket field in the entity cache if it is enabled.
	 *
	 * @param ticketField the ticket field
	 */
	public void cacheResult(TicketField ticketField);

	/**
	 * Caches the ticket fields in the entity cache if it is enabled.
	 *
	 * @param ticketFields the ticket fields
	 */
	public void cacheResult(java.util.List<TicketField> ticketFields);

	/**
	 * Creates a new ticket field with the primary key. Does not add the ticket field to the database.
	 *
	 * @param ticketFieldId the primary key for the new ticket field
	 * @return the new ticket field
	 */
	public TicketField create(long ticketFieldId);

	/**
	 * Removes the ticket field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field that was removed
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	public TicketField remove(long ticketFieldId)
		throws NoSuchTicketFieldException;

	public TicketField updateImpl(TicketField ticketField);

	/**
	 * Returns the ticket field with the primary key or throws a <code>NoSuchTicketFieldException</code> if it could not be found.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	public TicketField findByPrimaryKey(long ticketFieldId)
		throws NoSuchTicketFieldException;

	/**
	 * Returns the ticket field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field, or <code>null</code> if a ticket field with the primary key could not be found
	 */
	public TicketField fetchByPrimaryKey(long ticketFieldId);

	/**
	 * Returns all the ticket fields.
	 *
	 * @return the ticket fields
	 */
	public java.util.List<TicketField> findAll();

	/**
	 * Returns a range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @return the range of ticket fields
	 */
	public java.util.List<TicketField> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket fields
	 */
	public java.util.List<TicketField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketField>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket fields
	 */
	public java.util.List<TicketField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketField>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket fields from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket fields.
	 *
	 * @return the number of ticket fields
	 */
	public int countAll();

}