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
import com.liferay.yithro.ticket.exception.NoSuchTicketStructureException;
import com.liferay.yithro.ticket.model.TicketStructure;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketStructureUtil
 * @generated
 */
@ProviderType
public interface TicketStructurePersistence
	extends BasePersistence<TicketStructure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketStructureUtil} to access the ticket structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the ticket structure in the entity cache if it is enabled.
	 *
	 * @param ticketStructure the ticket structure
	 */
	public void cacheResult(TicketStructure ticketStructure);

	/**
	 * Caches the ticket structures in the entity cache if it is enabled.
	 *
	 * @param ticketStructures the ticket structures
	 */
	public void cacheResult(java.util.List<TicketStructure> ticketStructures);

	/**
	 * Creates a new ticket structure with the primary key. Does not add the ticket structure to the database.
	 *
	 * @param ticketStructureId the primary key for the new ticket structure
	 * @return the new ticket structure
	 */
	public TicketStructure create(long ticketStructureId);

	/**
	 * Removes the ticket structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure that was removed
	 * @throws NoSuchTicketStructureException if a ticket structure with the primary key could not be found
	 */
	public TicketStructure remove(long ticketStructureId)
		throws NoSuchTicketStructureException;

	public TicketStructure updateImpl(TicketStructure ticketStructure);

	/**
	 * Returns the ticket structure with the primary key or throws a <code>NoSuchTicketStructureException</code> if it could not be found.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure
	 * @throws NoSuchTicketStructureException if a ticket structure with the primary key could not be found
	 */
	public TicketStructure findByPrimaryKey(long ticketStructureId)
		throws NoSuchTicketStructureException;

	/**
	 * Returns the ticket structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure, or <code>null</code> if a ticket structure with the primary key could not be found
	 */
	public TicketStructure fetchByPrimaryKey(long ticketStructureId);

	/**
	 * Returns all the ticket structures.
	 *
	 * @return the ticket structures
	 */
	public java.util.List<TicketStructure> findAll();

	/**
	 * Returns a range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @return the range of ticket structures
	 */
	public java.util.List<TicketStructure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket structures
	 */
	public java.util.List<TicketStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStructure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket structures
	 */
	public java.util.List<TicketStructure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketStructure>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the ticket structures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket structures.
	 *
	 * @return the number of ticket structures
	 */
	public int countAll();

}