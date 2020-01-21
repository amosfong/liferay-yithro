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
import com.liferay.yithro.ticket.model.TicketWorker;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for TicketWorker. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see TicketWorkerLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface TicketWorkerLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketWorkerLocalServiceUtil} to access the ticket worker local service. Add custom service methods to <code>com.liferay.yithro.ticket.service.impl.TicketWorkerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public TicketWorker addTicketWorker(
			long workerUserId, long ticketEntryId, long sourceClassNameId,
			long sourceClassPK, int role, boolean primary)
		throws PortalException;

	/**
	 * Adds the ticket worker to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TicketWorker addTicketWorker(TicketWorker ticketWorker);

	/**
	 * Creates a new ticket worker with the primary key. Does not add the ticket worker to the database.
	 *
	 * @param ticketWorkerId the primary key for the new ticket worker
	 * @return the new ticket worker
	 */
	@Transactional(enabled = false)
	public TicketWorker createTicketWorker(long ticketWorkerId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the ticket worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker that was removed
	 * @throws PortalException if a ticket worker with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public TicketWorker deleteTicketWorker(long ticketWorkerId)
		throws PortalException;

	/**
	 * Deletes the ticket worker from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public TicketWorker deleteTicketWorker(TicketWorker ticketWorker);

	public void deleteTicketWorkers(long userId) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code>.
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
	public TicketWorker fetchLatestTicketWorker(long ticketEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketWorker fetchPrimaryTicketWorker(long ticketEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketWorker fetchTicketWorker(long ticketWorkerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketWorker fetchTicketWorker(long userId, long ticketEntryId);

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
	 * Returns the ticket worker with the primary key.
	 *
	 * @param ticketWorkerId the primary key of the ticket worker
	 * @return the ticket worker
	 * @throws PortalException if a ticket worker with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketWorker getTicketWorker(long ticketWorkerId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public TicketWorker getTicketWorker(long userId, long ticketEntryId)
		throws PortalException;

	/**
	 * Returns a range of all the ticket workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.ticket.model.impl.TicketWorkerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket workers
	 * @param end the upper bound of the range of ticket workers (not inclusive)
	 * @return the range of ticket workers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketWorker> getTicketWorkers(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketWorker> getTicketWorkers(long ticketEntryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketWorker> getTicketWorkers(
		long sourceClassNameId, long sourceClassPK);

	/**
	 * Returns the number of ticket workers.
	 *
	 * @return the number of ticket workers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getTicketWorkersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<TicketWorker> getUserTicketWorkers(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserTicketWorkersCount(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasTicketWorker(long userId, long ticketEntryId);

	public void setTicketWorkers(
			long ticketEntryId, long[] userIds, int[] roles, long primaryUserId)
		throws PortalException;

	public TicketWorker updateTicketWorker(
			long ticketWorkerId, int role, boolean primary)
		throws PortalException;

	/**
	 * Updates the ticket worker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ticketWorker the ticket worker
	 * @return the ticket worker that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public TicketWorker updateTicketWorker(TicketWorker ticketWorker);

}