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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.yithro.ticket.exception.NoSuchTicketFieldException;
import com.liferay.yithro.ticket.model.TicketField;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket fields
	 */
	public java.util.List<TicketField> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketField>
			orderByComparator,
		boolean retrieveFromCache);

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