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

package com.liferay.yithro.ticket.service;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.ticket.model.TicketFlag;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TicketFlag. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketFlagLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TicketFlagLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketFlagLocalServiceUtil} to access the ticket flag local service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketFlagLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the ticket flag to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFlag the ticket flag
	 * @return the ticket flag that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TicketFlag addTicketFlag(TicketFlag ticketFlag);

	/**
	 * Creates a new ticket flag with the primary key. Does not add the ticket flag to the database.
	 *
	 * @param ticketFlagId the primary key for the new ticket flag
	 * @return the new ticket flag
	 */
	@Transactional(enabled = false)
	public TicketFlag createTicketFlag(long ticketFlagId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the ticket flag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFlagId the primary key of the ticket flag
	 * @return the ticket flag that was removed
	 * @throws PortalException if a ticket flag with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TicketFlag deleteTicketFlag(long ticketFlagId)
		throws PortalException;

	/**
	 * Deletes the ticket flag from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFlag the ticket flag
	 * @return the ticket flag that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TicketFlag deleteTicketFlag(TicketFlag ticketFlag);

	public void deleteTicketFlags(long ticketEntryId, int type, int value);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketFlag fetchTicketFlag(long ticketFlagId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the ticket flag with the primary key.
	 *
	 * @param ticketFlagId the primary key of the ticket flag
	 * @return the ticket flag
	 * @throws PortalException if a ticket flag with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketFlag getTicketFlag(long ticketFlagId) throws PortalException;

	/**
	 * Returns a range of all the ticket flags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of ticket flags
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketFlag> getTicketFlags(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketFlag> getTicketFlags(
		long ticketEntryId, int type, int value);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketFlag> getTicketFlags(
		long ticketEntryId, int[] types, int value);

	/**
	 * Returns the number of ticket flags.
	 *
	 * @return the number of ticket flags
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTicketFlagsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTicketFlagsCount(long ticketEntryId, int type, int value);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int[] getTicketFlagTypes(long ticketEntryId, int[] types, int value);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasTicketFlag(long ticketEntryId, int type, int value);

	public TicketFlag updateTicketFlag(
			long userId, long ticketEntryId, int type, int value)
		throws PortalException;

	/**
	 * Updates the ticket flag in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFlag the ticket flag
	 * @return the ticket flag that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TicketFlag updateTicketFlag(TicketFlag ticketFlag);

}