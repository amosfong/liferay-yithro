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
import com.liferay.yithro.ticket.exception.NoSuchTicketFieldDataException;
import com.liferay.yithro.ticket.model.TicketFieldData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ticket field data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldDataUtil
 * @generated
 */
@ProviderType
public interface TicketFieldDataPersistence
	extends BasePersistence<TicketFieldData> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketFieldDataUtil} to access the ticket field data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ticket field datas where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket field datas
	 */
	public java.util.List<TicketFieldData> findByTicketEntryId(
		long ticketEntryId);

	/**
	 * Returns a range of all the ticket field datas where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @return the range of matching ticket field datas
	 */
	public java.util.List<TicketFieldData> findByTicketEntryId(
		long ticketEntryId, int start, int end);

	/**
	 * Returns an ordered range of all the ticket field datas where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket field datas
	 */
	public java.util.List<TicketFieldData> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket field datas where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket field datas
	 */
	public java.util.List<TicketFieldData> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field data
	 * @throws NoSuchTicketFieldDataException if a matching ticket field data could not be found
	 */
	public TicketFieldData findByTicketEntryId_First(
			long ticketEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
				orderByComparator)
		throws NoSuchTicketFieldDataException;

	/**
	 * Returns the first ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field data, or <code>null</code> if a matching ticket field data could not be found
	 */
	public TicketFieldData fetchByTicketEntryId_First(
		long ticketEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
			orderByComparator);

	/**
	 * Returns the last ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field data
	 * @throws NoSuchTicketFieldDataException if a matching ticket field data could not be found
	 */
	public TicketFieldData findByTicketEntryId_Last(
			long ticketEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
				orderByComparator)
		throws NoSuchTicketFieldDataException;

	/**
	 * Returns the last ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field data, or <code>null</code> if a matching ticket field data could not be found
	 */
	public TicketFieldData fetchByTicketEntryId_Last(
		long ticketEntryId,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
			orderByComparator);

	/**
	 * Returns the ticket field datas before and after the current ticket field data in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketFieldDataId the primary key of the current ticket field data
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field data
	 * @throws NoSuchTicketFieldDataException if a ticket field data with the primary key could not be found
	 */
	public TicketFieldData[] findByTicketEntryId_PrevAndNext(
			long ticketFieldDataId, long ticketEntryId,
			com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
				orderByComparator)
		throws NoSuchTicketFieldDataException;

	/**
	 * Removes all the ticket field datas where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	public void removeByTicketEntryId(long ticketEntryId);

	/**
	 * Returns the number of ticket field datas where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket field datas
	 */
	public int countByTicketEntryId(long ticketEntryId);

	/**
	 * Returns the ticket field data where ticketEntryId = &#63; and ticketFieldId = &#63; or throws a <code>NoSuchTicketFieldDataException</code> if it could not be found.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket field data
	 * @throws NoSuchTicketFieldDataException if a matching ticket field data could not be found
	 */
	public TicketFieldData findByTEI_TFI(long ticketEntryId, long ticketFieldId)
		throws NoSuchTicketFieldDataException;

	/**
	 * Returns the ticket field data where ticketEntryId = &#63; and ticketFieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket field data, or <code>null</code> if a matching ticket field data could not be found
	 */
	public TicketFieldData fetchByTEI_TFI(
		long ticketEntryId, long ticketFieldId);

	/**
	 * Returns the ticket field data where ticketEntryId = &#63; and ticketFieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket field data, or <code>null</code> if a matching ticket field data could not be found
	 */
	public TicketFieldData fetchByTEI_TFI(
		long ticketEntryId, long ticketFieldId, boolean useFinderCache);

	/**
	 * Removes the ticket field data where ticketEntryId = &#63; and ticketFieldId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the ticket field data that was removed
	 */
	public TicketFieldData removeByTEI_TFI(
			long ticketEntryId, long ticketFieldId)
		throws NoSuchTicketFieldDataException;

	/**
	 * Returns the number of ticket field datas where ticketEntryId = &#63; and ticketFieldId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the number of matching ticket field datas
	 */
	public int countByTEI_TFI(long ticketEntryId, long ticketFieldId);

	/**
	 * Caches the ticket field data in the entity cache if it is enabled.
	 *
	 * @param ticketFieldData the ticket field data
	 */
	public void cacheResult(TicketFieldData ticketFieldData);

	/**
	 * Caches the ticket field datas in the entity cache if it is enabled.
	 *
	 * @param ticketFieldDatas the ticket field datas
	 */
	public void cacheResult(java.util.List<TicketFieldData> ticketFieldDatas);

	/**
	 * Creates a new ticket field data with the primary key. Does not add the ticket field data to the database.
	 *
	 * @param ticketFieldDataId the primary key for the new ticket field data
	 * @return the new ticket field data
	 */
	public TicketFieldData create(long ticketFieldDataId);

	/**
	 * Removes the ticket field data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data that was removed
	 * @throws NoSuchTicketFieldDataException if a ticket field data with the primary key could not be found
	 */
	public TicketFieldData remove(long ticketFieldDataId)
		throws NoSuchTicketFieldDataException;

	public TicketFieldData updateImpl(TicketFieldData ticketFieldData);

	/**
	 * Returns the ticket field data with the primary key or throws a <code>NoSuchTicketFieldDataException</code> if it could not be found.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data
	 * @throws NoSuchTicketFieldDataException if a ticket field data with the primary key could not be found
	 */
	public TicketFieldData findByPrimaryKey(long ticketFieldDataId)
		throws NoSuchTicketFieldDataException;

	/**
	 * Returns the ticket field data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFieldDataId the primary key of the ticket field data
	 * @return the ticket field data, or <code>null</code> if a ticket field data with the primary key could not be found
	 */
	public TicketFieldData fetchByPrimaryKey(long ticketFieldDataId);

	/**
	 * Returns all the ticket field datas.
	 *
	 * @return the ticket field datas
	 */
	public java.util.List<TicketFieldData> findAll();

	/**
	 * Returns a range of all the ticket field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @return the range of ticket field datas
	 */
	public java.util.List<TicketFieldData> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ticket field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket field datas
	 */
	public java.util.List<TicketFieldData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ticket field datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldDataModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field datas
	 * @param end the upper bound of the range of ticket field datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket field datas
	 */
	public java.util.List<TicketFieldData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketFieldData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ticket field datas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket field datas.
	 *
	 * @return the number of ticket field datas
	 */
	public int countAll();

}