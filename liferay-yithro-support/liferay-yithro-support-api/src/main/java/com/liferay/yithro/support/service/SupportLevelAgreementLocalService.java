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
import com.liferay.yithro.support.model.SupportLevelAgreement;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SupportLevelAgreement. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see SupportLevelAgreementLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SupportLevelAgreementLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupportLevelAgreementLocalServiceUtil} to access the support level agreement local service. Add custom service methods to <code>com.liferay.yithro.support.service.impl.SupportLevelAgreementLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public SupportLevelAgreement addSupportLevelAgreement(
			long userId, String name, String description)
		throws PortalException;

	/**
	 * Adds the support level agreement to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreement the support level agreement
	 * @return the support level agreement that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SupportLevelAgreement addSupportLevelAgreement(
		SupportLevelAgreement supportLevelAgreement);

	/**
	 * Creates a new support level agreement with the primary key. Does not add the support level agreement to the database.
	 *
	 * @param supportLevelAgreementId the primary key for the new support level agreement
	 * @return the new support level agreement
	 */
	@Transactional(enabled = false)
	public SupportLevelAgreement createSupportLevelAgreement(
		long supportLevelAgreementId);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the support level agreement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement that was removed
	 * @throws PortalException if a support level agreement with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SupportLevelAgreement deleteSupportLevelAgreement(
			long supportLevelAgreementId)
		throws PortalException;

	/**
	 * Deletes the support level agreement from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreement the support level agreement
	 * @return the support level agreement that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SupportLevelAgreement deleteSupportLevelAgreement(
		SupportLevelAgreement supportLevelAgreement);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLevelAgreementModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLevelAgreementModelImpl</code>.
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
	public SupportLevelAgreement fetchSupportLevelAgreement(
		long supportLevelAgreementId);

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
	 * Returns the support level agreement with the primary key.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement
	 * @throws PortalException if a support level agreement with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SupportLevelAgreement getSupportLevelAgreement(
			long supportLevelAgreementId)
		throws PortalException;

	/**
	 * Returns a range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLevelAgreementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @return the range of support level agreements
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SupportLevelAgreement> getSupportLevelAgreements(
		int start, int end);

	/**
	 * Returns the number of support level agreements.
	 *
	 * @return the number of support level agreements
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSupportLevelAgreementsCount();

	public SupportLevelAgreement updateSupportLevelAgreement(
			long supportLevelAgreementId, String name, String description)
		throws PortalException;

	/**
	 * Updates the support level agreement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreement the support level agreement
	 * @return the support level agreement that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SupportLevelAgreement updateSupportLevelAgreement(
		SupportLevelAgreement supportLevelAgreement);

}