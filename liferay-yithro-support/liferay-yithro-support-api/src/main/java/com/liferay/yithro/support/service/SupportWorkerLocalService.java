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

package com.liferay.yithro.support.service;

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
import com.liferay.yithro.support.model.SupportWorker;

import java.io.Serializable;

import java.util.LinkedHashMap;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SupportWorker. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SupportWorkerLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SupportWorkerLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupportWorkerLocalServiceUtil} to access the support worker local service. Add custom service methods to <code>com.liferay.yithro.support.service.impl.SupportWorkerLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the support worker to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SupportWorker addSupportWorker(SupportWorker supportWorker);

	public void addSupportWorkers(
			long[] userIds, long supportTeamId, double[] maxWork, int[] roles)
		throws PortalException;

	/**
	 * Creates a new support worker with the primary key. Does not add the support worker to the database.
	 *
	 * @param supportWorkerId the primary key for the new support worker
	 * @return the new support worker
	 */
	@Transactional(enabled = false)
	public SupportWorker createSupportWorker(long supportWorkerId);

	public void decreaseAssignedWork(long userId, double work)
		throws PortalException;

	public void decreaseTicketEntryAssignedWork(long ticketEntryId, double work)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the support worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker that was removed
	 * @throws PortalException if a support worker with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SupportWorker deleteSupportWorker(long supportWorkerId)
		throws PortalException;

	/**
	 * Deletes the support worker from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SupportWorker deleteSupportWorker(SupportWorker supportWorker);

	public void deleteSupportWorkers(long userId) throws PortalException;

	public void deleteSupportWorkers(long[] userIds, long supportTeamId)
		throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>.
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
	public SupportWorker fetchSupportWorker(long supportWorkerId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public double getAssignedWork(long userId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SupportWorker getAvailableSupportWorker(long ticketEntryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SupportWorker getLongestOpenSupportWorker(
			List<SupportWorker> supportWorkers, long ticketEntryId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SupportWorker getMostAvailableSupportWorker(
			long ticketEntryId, LinkedHashMap<String, Object> params)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SupportWorker getNextOpenSupportWorker(
			List<SupportWorker> supportWorkers, long ticketEntryId)
		throws PortalException;

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SupportWorker> getSupportTeamSupportWorkers(long supportTeamId);

	/**
	 * Returns the support worker with the primary key.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker
	 * @throws PortalException if a support worker with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SupportWorker getSupportWorker(long supportWorkerId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SupportWorker getSupportWorker(long userId, long supportTeamId)
		throws PortalException;

	/**
	 * Returns a range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportWorkerModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of support workers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SupportWorker> getSupportWorkers(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SupportWorker> getSupportWorkersBySupportLaborId(
			long supportLaborId)
		throws PortalException;

	/**
	 * Returns the number of support workers.
	 *
	 * @return the number of support workers
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSupportWorkersCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSupportWorkersCountBySupportLaborId(long supportLaborId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SupportWorker> getUserSupportWorkers(long userId);

	public void increaseAssignedWork(long userId, double work)
		throws PortalException;

	public void increaseTicketEntryAssignedWork(long ticketEntryId, double work)
		throws PortalException;

	public void recalculateUtilization();

	public SupportWorker updateSupportWorker(
			long supportWorkerId, long supportTeamId, double maxWork)
		throws PortalException;

	/**
	 * Updates the support worker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorker the support worker
	 * @return the support worker that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SupportWorker updateSupportWorker(SupportWorker supportWorker);

}