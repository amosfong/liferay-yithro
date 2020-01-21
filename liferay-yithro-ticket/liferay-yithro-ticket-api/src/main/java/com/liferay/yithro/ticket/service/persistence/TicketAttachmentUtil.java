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
import com.liferay.yithro.ticket.model.TicketAttachment;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket attachment service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketAttachmentPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketAttachmentPersistence
 * @generated
 */
public class TicketAttachmentUtil {

	/*
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
	public static void clearCache(TicketAttachment ticketAttachment) {
		getPersistence().clearCache(ticketAttachment);
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
	public static Map<Serializable, TicketAttachment> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketAttachment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketAttachment update(TicketAttachment ticketAttachment) {
		return getPersistence().update(ticketAttachment);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketAttachment update(
		TicketAttachment ticketAttachment, ServiceContext serviceContext) {

		return getPersistence().update(ticketAttachment, serviceContext);
	}

	/**
	 * Returns all the ticket attachments where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket attachments
	 */
	public static List<TicketAttachment> findByTicketEntryId(
		long ticketEntryId) {

		return getPersistence().findByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns a range of all the ticket attachments where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTicketEntryId(
		long ticketEntryId, int start, int end) {

		return getPersistence().findByTicketEntryId(ticketEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTicketEntryId_First(
			long ticketEntryId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTicketEntryId_First(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTicketEntryId_First(
		long ticketEntryId,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByTicketEntryId_First(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTicketEntryId_Last(
			long ticketEntryId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTicketEntryId_Last(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTicketEntryId_Last(
		long ticketEntryId,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByTicketEntryId_Last(
			ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the ticket attachments before and after the current ticket attachment in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketAttachmentId the primary key of the current ticket attachment
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket attachment
	 * @throws NoSuchTicketAttachmentException if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment[] findByTicketEntryId_PrevAndNext(
			long ticketAttachmentId, long ticketEntryId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTicketEntryId_PrevAndNext(
			ticketAttachmentId, ticketEntryId, orderByComparator);
	}

	/**
	 * Removes all the ticket attachments where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	public static void removeByTicketEntryId(long ticketEntryId) {
		getPersistence().removeByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns the number of ticket attachments where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket attachments
	 */
	public static int countByTicketEntryId(long ticketEntryId) {
		return getPersistence().countByTicketEntryId(ticketEntryId);
	}

	/**
	 * Returns all the ticket attachments where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @return the matching ticket attachments
	 */
	public static List<TicketAttachment> findByTicketCommunicationId(
		long ticketCommunicationId) {

		return getPersistence().findByTicketCommunicationId(
			ticketCommunicationId);
	}

	/**
	 * Returns a range of all the ticket attachments where ticketCommunicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTicketCommunicationId(
		long ticketCommunicationId, int start, int end) {

		return getPersistence().findByTicketCommunicationId(
			ticketCommunicationId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketCommunicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTicketCommunicationId(
		long ticketCommunicationId, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findByTicketCommunicationId(
			ticketCommunicationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketCommunicationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTicketCommunicationId(
		long ticketCommunicationId, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTicketCommunicationId(
			ticketCommunicationId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTicketCommunicationId_First(
			long ticketCommunicationId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTicketCommunicationId_First(
			ticketCommunicationId, orderByComparator);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTicketCommunicationId_First(
		long ticketCommunicationId,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByTicketCommunicationId_First(
			ticketCommunicationId, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTicketCommunicationId_Last(
			long ticketCommunicationId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTicketCommunicationId_Last(
			ticketCommunicationId, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTicketCommunicationId_Last(
		long ticketCommunicationId,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByTicketCommunicationId_Last(
			ticketCommunicationId, orderByComparator);
	}

	/**
	 * Returns the ticket attachments before and after the current ticket attachment in the ordered set where ticketCommunicationId = &#63;.
	 *
	 * @param ticketAttachmentId the primary key of the current ticket attachment
	 * @param ticketCommunicationId the ticket communication ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket attachment
	 * @throws NoSuchTicketAttachmentException if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment[] findByTicketCommunicationId_PrevAndNext(
			long ticketAttachmentId, long ticketCommunicationId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTicketCommunicationId_PrevAndNext(
			ticketAttachmentId, ticketCommunicationId, orderByComparator);
	}

	/**
	 * Removes all the ticket attachments where ticketCommunicationId = &#63; from the database.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 */
	public static void removeByTicketCommunicationId(
		long ticketCommunicationId) {

		getPersistence().removeByTicketCommunicationId(ticketCommunicationId);
	}

	/**
	 * Returns the number of ticket attachments where ticketCommunicationId = &#63;.
	 *
	 * @param ticketCommunicationId the ticket communication ID
	 * @return the number of matching ticket attachments
	 */
	public static int countByTicketCommunicationId(long ticketCommunicationId) {
		return getPersistence().countByTicketCommunicationId(
			ticketCommunicationId);
	}

	/**
	 * Returns all the ticket attachments where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket attachments
	 */
	public static List<TicketAttachment> findByCD_TEI(
		Date createDate, long ticketEntryId) {

		return getPersistence().findByCD_TEI(createDate, ticketEntryId);
	}

	/**
	 * Returns a range of all the ticket attachments where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByCD_TEI(
		Date createDate, long ticketEntryId, int start, int end) {

		return getPersistence().findByCD_TEI(
			createDate, ticketEntryId, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByCD_TEI(
		Date createDate, long ticketEntryId, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findByCD_TEI(
			createDate, ticketEntryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByCD_TEI(
		Date createDate, long ticketEntryId, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCD_TEI(
			createDate, ticketEntryId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByCD_TEI_First(
			Date createDate, long ticketEntryId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByCD_TEI_First(
			createDate, ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByCD_TEI_First(
		Date createDate, long ticketEntryId,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByCD_TEI_First(
			createDate, ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByCD_TEI_Last(
			Date createDate, long ticketEntryId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByCD_TEI_Last(
			createDate, ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByCD_TEI_Last(
		Date createDate, long ticketEntryId,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByCD_TEI_Last(
			createDate, ticketEntryId, orderByComparator);
	}

	/**
	 * Returns the ticket attachments before and after the current ticket attachment in the ordered set where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * @param ticketAttachmentId the primary key of the current ticket attachment
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket attachment
	 * @throws NoSuchTicketAttachmentException if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment[] findByCD_TEI_PrevAndNext(
			long ticketAttachmentId, Date createDate, long ticketEntryId,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByCD_TEI_PrevAndNext(
			ticketAttachmentId, createDate, ticketEntryId, orderByComparator);
	}

	/**
	 * Removes all the ticket attachments where createDate &lt; &#63; and ticketEntryId = &#63; from the database.
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 */
	public static void removeByCD_TEI(Date createDate, long ticketEntryId) {
		getPersistence().removeByCD_TEI(createDate, ticketEntryId);
	}

	/**
	 * Returns the number of ticket attachments where createDate &lt; &#63; and ticketEntryId = &#63;.
	 *
	 * @param createDate the create date
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket attachments
	 */
	public static int countByCD_TEI(Date createDate, long ticketEntryId) {
		return getPersistence().countByCD_TEI(createDate, ticketEntryId);
	}

	/**
	 * Returns the ticket attachment where ticketEntryId = &#63; and ticketFieldId = &#63; or throws a <code>NoSuchTicketAttachmentException</code> if it could not be found.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTEI_TFI(
			long ticketEntryId, long ticketFieldId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTEI_TFI(ticketEntryId, ticketFieldId);
	}

	/**
	 * Returns the ticket attachment where ticketEntryId = &#63; and ticketFieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTEI_TFI(
		long ticketEntryId, long ticketFieldId) {

		return getPersistence().fetchByTEI_TFI(ticketEntryId, ticketFieldId);
	}

	/**
	 * Returns the ticket attachment where ticketEntryId = &#63; and ticketFieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTEI_TFI(
		long ticketEntryId, long ticketFieldId, boolean useFinderCache) {

		return getPersistence().fetchByTEI_TFI(
			ticketEntryId, ticketFieldId, useFinderCache);
	}

	/**
	 * Removes the ticket attachment where ticketEntryId = &#63; and ticketFieldId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the ticket attachment that was removed
	 */
	public static TicketAttachment removeByTEI_TFI(
			long ticketEntryId, long ticketFieldId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().removeByTEI_TFI(ticketEntryId, ticketFieldId);
	}

	/**
	 * Returns the number of ticket attachments where ticketEntryId = &#63; and ticketFieldId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketFieldId the ticket field ID
	 * @return the number of matching ticket attachments
	 */
	public static int countByTEI_TFI(long ticketEntryId, long ticketFieldId) {
		return getPersistence().countByTEI_TFI(ticketEntryId, ticketFieldId);
	}

	/**
	 * Returns all the ticket attachments where ticketEntryId = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @return the matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_S(
		long ticketEntryId, int status) {

		return getPersistence().findByTEI_S(ticketEntryId, status);
	}

	/**
	 * Returns a range of all the ticket attachments where ticketEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_S(
		long ticketEntryId, int status, int start, int end) {

		return getPersistence().findByTEI_S(ticketEntryId, status, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_S(
		long ticketEntryId, int status, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findByTEI_S(
			ticketEntryId, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketEntryId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_S(
		long ticketEntryId, int status, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_S(
			ticketEntryId, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where ticketEntryId = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTEI_S_First(
			long ticketEntryId, int status,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTEI_S_First(
			ticketEntryId, status, orderByComparator);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where ticketEntryId = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTEI_S_First(
		long ticketEntryId, int status,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByTEI_S_First(
			ticketEntryId, status, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where ticketEntryId = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTEI_S_Last(
			long ticketEntryId, int status,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTEI_S_Last(
			ticketEntryId, status, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where ticketEntryId = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTEI_S_Last(
		long ticketEntryId, int status,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByTEI_S_Last(
			ticketEntryId, status, orderByComparator);
	}

	/**
	 * Returns the ticket attachments before and after the current ticket attachment in the ordered set where ticketEntryId = &#63; and status = &#63;.
	 *
	 * @param ticketAttachmentId the primary key of the current ticket attachment
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket attachment
	 * @throws NoSuchTicketAttachmentException if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment[] findByTEI_S_PrevAndNext(
			long ticketAttachmentId, long ticketEntryId, int status,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTEI_S_PrevAndNext(
			ticketAttachmentId, ticketEntryId, status, orderByComparator);
	}

	/**
	 * Removes all the ticket attachments where ticketEntryId = &#63; and status = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 */
	public static void removeByTEI_S(long ticketEntryId, int status) {
		getPersistence().removeByTEI_S(ticketEntryId, status);
	}

	/**
	 * Returns the number of ticket attachments where ticketEntryId = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param status the status
	 * @return the number of matching ticket attachments
	 */
	public static int countByTEI_S(long ticketEntryId, int status) {
		return getPersistence().countByTEI_S(ticketEntryId, status);
	}

	/**
	 * Returns all the ticket attachments where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @return the matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_V_S(
		long ticketEntryId, int visibility, int status) {

		return getPersistence().findByTEI_V_S(
			ticketEntryId, visibility, status);
	}

	/**
	 * Returns a range of all the ticket attachments where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_V_S(
		long ticketEntryId, int visibility, int status, int start, int end) {

		return getPersistence().findByTEI_V_S(
			ticketEntryId, visibility, status, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_V_S(
		long ticketEntryId, int visibility, int status, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findByTEI_V_S(
			ticketEntryId, visibility, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_V_S(
		long ticketEntryId, int visibility, int status, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_V_S(
			ticketEntryId, visibility, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTEI_V_S_First(
			long ticketEntryId, int visibility, int status,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTEI_V_S_First(
			ticketEntryId, visibility, status, orderByComparator);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTEI_V_S_First(
		long ticketEntryId, int visibility, int status,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByTEI_V_S_First(
			ticketEntryId, visibility, status, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTEI_V_S_Last(
			long ticketEntryId, int visibility, int status,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTEI_V_S_Last(
			ticketEntryId, visibility, status, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTEI_V_S_Last(
		long ticketEntryId, int visibility, int status,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByTEI_V_S_Last(
			ticketEntryId, visibility, status, orderByComparator);
	}

	/**
	 * Returns the ticket attachments before and after the current ticket attachment in the ordered set where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketAttachmentId the primary key of the current ticket attachment
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket attachment
	 * @throws NoSuchTicketAttachmentException if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment[] findByTEI_V_S_PrevAndNext(
			long ticketAttachmentId, long ticketEntryId, int visibility,
			int status, OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTEI_V_S_PrevAndNext(
			ticketAttachmentId, ticketEntryId, visibility, status,
			orderByComparator);
	}

	/**
	 * Returns all the ticket attachments where ticketEntryId = &#63; and visibility = any &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @param status the status
	 * @return the matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_V_S(
		long ticketEntryId, int[] visibilities, int status) {

		return getPersistence().findByTEI_V_S(
			ticketEntryId, visibilities, status);
	}

	/**
	 * Returns a range of all the ticket attachments where ticketEntryId = &#63; and visibility = any &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_V_S(
		long ticketEntryId, int[] visibilities, int status, int start,
		int end) {

		return getPersistence().findByTEI_V_S(
			ticketEntryId, visibilities, status, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketEntryId = &#63; and visibility = any &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_V_S(
		long ticketEntryId, int[] visibilities, int status, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findByTEI_V_S(
			ticketEntryId, visibilities, status, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where ticketEntryId = &#63; and visibility = &#63; and status = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByTEI_V_S(
		long ticketEntryId, int[] visibilities, int status, int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTEI_V_S(
			ticketEntryId, visibilities, status, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Removes all the ticket attachments where ticketEntryId = &#63; and visibility = &#63; and status = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 */
	public static void removeByTEI_V_S(
		long ticketEntryId, int visibility, int status) {

		getPersistence().removeByTEI_V_S(ticketEntryId, visibility, status);
	}

	/**
	 * Returns the number of ticket attachments where ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @return the number of matching ticket attachments
	 */
	public static int countByTEI_V_S(
		long ticketEntryId, int visibility, int status) {

		return getPersistence().countByTEI_V_S(
			ticketEntryId, visibility, status);
	}

	/**
	 * Returns the number of ticket attachments where ticketEntryId = &#63; and visibility = any &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @param status the status
	 * @return the number of matching ticket attachments
	 */
	public static int countByTEI_V_S(
		long ticketEntryId, int[] visibilities, int status) {

		return getPersistence().countByTEI_V_S(
			ticketEntryId, visibilities, status);
	}

	/**
	 * Returns all the ticket attachments where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @return the matching ticket attachments
	 */
	public static List<TicketAttachment> findByU_TEI_V_S(
		long userId, long ticketEntryId, int visibility, int status) {

		return getPersistence().findByU_TEI_V_S(
			userId, ticketEntryId, visibility, status);
	}

	/**
	 * Returns a range of all the ticket attachments where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByU_TEI_V_S(
		long userId, long ticketEntryId, int visibility, int status, int start,
		int end) {

		return getPersistence().findByU_TEI_V_S(
			userId, ticketEntryId, visibility, status, start, end);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByU_TEI_V_S(
		long userId, long ticketEntryId, int visibility, int status, int start,
		int end, OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findByU_TEI_V_S(
			userId, ticketEntryId, visibility, status, start, end,
			orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket attachments where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket attachments
	 */
	public static List<TicketAttachment> findByU_TEI_V_S(
		long userId, long ticketEntryId, int visibility, int status, int start,
		int end, OrderByComparator<TicketAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByU_TEI_V_S(
			userId, ticketEntryId, visibility, status, start, end,
			orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByU_TEI_V_S_First(
			long userId, long ticketEntryId, int visibility, int status,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByU_TEI_V_S_First(
			userId, ticketEntryId, visibility, status, orderByComparator);
	}

	/**
	 * Returns the first ticket attachment in the ordered set where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByU_TEI_V_S_First(
		long userId, long ticketEntryId, int visibility, int status,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByU_TEI_V_S_First(
			userId, ticketEntryId, visibility, status, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByU_TEI_V_S_Last(
			long userId, long ticketEntryId, int visibility, int status,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByU_TEI_V_S_Last(
			userId, ticketEntryId, visibility, status, orderByComparator);
	}

	/**
	 * Returns the last ticket attachment in the ordered set where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByU_TEI_V_S_Last(
		long userId, long ticketEntryId, int visibility, int status,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().fetchByU_TEI_V_S_Last(
			userId, ticketEntryId, visibility, status, orderByComparator);
	}

	/**
	 * Returns the ticket attachments before and after the current ticket attachment in the ordered set where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketAttachmentId the primary key of the current ticket attachment
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket attachment
	 * @throws NoSuchTicketAttachmentException if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment[] findByU_TEI_V_S_PrevAndNext(
			long ticketAttachmentId, long userId, long ticketEntryId,
			int visibility, int status,
			OrderByComparator<TicketAttachment> orderByComparator)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByU_TEI_V_S_PrevAndNext(
			ticketAttachmentId, userId, ticketEntryId, visibility, status,
			orderByComparator);
	}

	/**
	 * Removes all the ticket attachments where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 */
	public static void removeByU_TEI_V_S(
		long userId, long ticketEntryId, int visibility, int status) {

		getPersistence().removeByU_TEI_V_S(
			userId, ticketEntryId, visibility, status);
	}

	/**
	 * Returns the number of ticket attachments where userId = &#63; and ticketEntryId = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param status the status
	 * @return the number of matching ticket attachments
	 */
	public static int countByU_TEI_V_S(
		long userId, long ticketEntryId, int visibility, int status) {

		return getPersistence().countByU_TEI_V_S(
			userId, ticketEntryId, visibility, status);
	}

	/**
	 * Returns the ticket attachment where ticketEntryId = &#63; and fileName = &#63; and visibility = &#63; and status = &#63; or throws a <code>NoSuchTicketAttachmentException</code> if it could not be found.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fileName the file name
	 * @param visibility the visibility
	 * @param status the status
	 * @return the matching ticket attachment
	 * @throws NoSuchTicketAttachmentException if a matching ticket attachment could not be found
	 */
	public static TicketAttachment findByTEI_FN_V_S(
			long ticketEntryId, String fileName, int visibility, int status)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByTEI_FN_V_S(
			ticketEntryId, fileName, visibility, status);
	}

	/**
	 * Returns the ticket attachment where ticketEntryId = &#63; and fileName = &#63; and visibility = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fileName the file name
	 * @param visibility the visibility
	 * @param status the status
	 * @return the matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTEI_FN_V_S(
		long ticketEntryId, String fileName, int visibility, int status) {

		return getPersistence().fetchByTEI_FN_V_S(
			ticketEntryId, fileName, visibility, status);
	}

	/**
	 * Returns the ticket attachment where ticketEntryId = &#63; and fileName = &#63; and visibility = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fileName the file name
	 * @param visibility the visibility
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket attachment, or <code>null</code> if a matching ticket attachment could not be found
	 */
	public static TicketAttachment fetchByTEI_FN_V_S(
		long ticketEntryId, String fileName, int visibility, int status,
		boolean useFinderCache) {

		return getPersistence().fetchByTEI_FN_V_S(
			ticketEntryId, fileName, visibility, status, useFinderCache);
	}

	/**
	 * Removes the ticket attachment where ticketEntryId = &#63; and fileName = &#63; and visibility = &#63; and status = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fileName the file name
	 * @param visibility the visibility
	 * @param status the status
	 * @return the ticket attachment that was removed
	 */
	public static TicketAttachment removeByTEI_FN_V_S(
			long ticketEntryId, String fileName, int visibility, int status)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().removeByTEI_FN_V_S(
			ticketEntryId, fileName, visibility, status);
	}

	/**
	 * Returns the number of ticket attachments where ticketEntryId = &#63; and fileName = &#63; and visibility = &#63; and status = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fileName the file name
	 * @param visibility the visibility
	 * @param status the status
	 * @return the number of matching ticket attachments
	 */
	public static int countByTEI_FN_V_S(
		long ticketEntryId, String fileName, int visibility, int status) {

		return getPersistence().countByTEI_FN_V_S(
			ticketEntryId, fileName, visibility, status);
	}

	/**
	 * Caches the ticket attachment in the entity cache if it is enabled.
	 *
	 * @param ticketAttachment the ticket attachment
	 */
	public static void cacheResult(TicketAttachment ticketAttachment) {
		getPersistence().cacheResult(ticketAttachment);
	}

	/**
	 * Caches the ticket attachments in the entity cache if it is enabled.
	 *
	 * @param ticketAttachments the ticket attachments
	 */
	public static void cacheResult(List<TicketAttachment> ticketAttachments) {
		getPersistence().cacheResult(ticketAttachments);
	}

	/**
	 * Creates a new ticket attachment with the primary key. Does not add the ticket attachment to the database.
	 *
	 * @param ticketAttachmentId the primary key for the new ticket attachment
	 * @return the new ticket attachment
	 */
	public static TicketAttachment create(long ticketAttachmentId) {
		return getPersistence().create(ticketAttachmentId);
	}

	/**
	 * Removes the ticket attachment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketAttachmentId the primary key of the ticket attachment
	 * @return the ticket attachment that was removed
	 * @throws NoSuchTicketAttachmentException if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment remove(long ticketAttachmentId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().remove(ticketAttachmentId);
	}

	public static TicketAttachment updateImpl(
		TicketAttachment ticketAttachment) {

		return getPersistence().updateImpl(ticketAttachment);
	}

	/**
	 * Returns the ticket attachment with the primary key or throws a <code>NoSuchTicketAttachmentException</code> if it could not be found.
	 *
	 * @param ticketAttachmentId the primary key of the ticket attachment
	 * @return the ticket attachment
	 * @throws NoSuchTicketAttachmentException if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment findByPrimaryKey(long ticketAttachmentId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketAttachmentException {

		return getPersistence().findByPrimaryKey(ticketAttachmentId);
	}

	/**
	 * Returns the ticket attachment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketAttachmentId the primary key of the ticket attachment
	 * @return the ticket attachment, or <code>null</code> if a ticket attachment with the primary key could not be found
	 */
	public static TicketAttachment fetchByPrimaryKey(long ticketAttachmentId) {
		return getPersistence().fetchByPrimaryKey(ticketAttachmentId);
	}

	/**
	 * Returns all the ticket attachments.
	 *
	 * @return the ticket attachments
	 */
	public static List<TicketAttachment> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @return the range of ticket attachments
	 */
	public static List<TicketAttachment> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket attachments
	 */
	public static List<TicketAttachment> findAll(
		int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket attachments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketAttachmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket attachments
	 * @param end the upper bound of the range of ticket attachments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket attachments
	 */
	public static List<TicketAttachment> findAll(
		int start, int end,
		OrderByComparator<TicketAttachment> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket attachments from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket attachments.
	 *
	 * @return the number of ticket attachments
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketAttachmentPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketAttachmentPersistence, TicketAttachmentPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketAttachmentPersistence.class);

		ServiceTracker<TicketAttachmentPersistence, TicketAttachmentPersistence>
			serviceTracker =
				new ServiceTracker
					<TicketAttachmentPersistence, TicketAttachmentPersistence>(
						bundle.getBundleContext(),
						TicketAttachmentPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}