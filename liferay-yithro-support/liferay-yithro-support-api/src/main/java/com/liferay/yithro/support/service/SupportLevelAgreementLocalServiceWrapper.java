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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SupportLevelAgreementLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SupportLevelAgreementLocalService
 * @generated
 */
public class SupportLevelAgreementLocalServiceWrapper
	implements ServiceWrapper<SupportLevelAgreementLocalService>,
			   SupportLevelAgreementLocalService {

	public SupportLevelAgreementLocalServiceWrapper(
		SupportLevelAgreementLocalService supportLevelAgreementLocalService) {

		_supportLevelAgreementLocalService = supportLevelAgreementLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupportLevelAgreementLocalServiceUtil} to access the support level agreement local service. Add custom service methods to <code>com.liferay.yithro.support.service.impl.SupportLevelAgreementLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
			addSupportLevelAgreement(
				long userId, String name, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLevelAgreementLocalService.addSupportLevelAgreement(
			userId, name, description);
	}

	/**
	 * Adds the support level agreement to the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreement the support level agreement
	 * @return the support level agreement that was added
	 */
	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
		addSupportLevelAgreement(
			com.liferay.yithro.support.model.SupportLevelAgreement
				supportLevelAgreement) {

		return _supportLevelAgreementLocalService.addSupportLevelAgreement(
			supportLevelAgreement);
	}

	/**
	 * Creates a new support level agreement with the primary key. Does not add the support level agreement to the database.
	 *
	 * @param supportLevelAgreementId the primary key for the new support level agreement
	 * @return the new support level agreement
	 */
	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
		createSupportLevelAgreement(long supportLevelAgreementId) {

		return _supportLevelAgreementLocalService.createSupportLevelAgreement(
			supportLevelAgreementId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLevelAgreementLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the support level agreement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement that was removed
	 * @throws PortalException if a support level agreement with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
			deleteSupportLevelAgreement(long supportLevelAgreementId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLevelAgreementLocalService.deleteSupportLevelAgreement(
			supportLevelAgreementId);
	}

	/**
	 * Deletes the support level agreement from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreement the support level agreement
	 * @return the support level agreement that was removed
	 */
	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
		deleteSupportLevelAgreement(
			com.liferay.yithro.support.model.SupportLevelAgreement
				supportLevelAgreement) {

		return _supportLevelAgreementLocalService.deleteSupportLevelAgreement(
			supportLevelAgreement);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _supportLevelAgreementLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _supportLevelAgreementLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLevelAgreementModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _supportLevelAgreementLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLevelAgreementModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _supportLevelAgreementLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _supportLevelAgreementLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _supportLevelAgreementLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
		fetchSupportLevelAgreement(long supportLevelAgreementId) {

		return _supportLevelAgreementLocalService.fetchSupportLevelAgreement(
			supportLevelAgreementId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _supportLevelAgreementLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _supportLevelAgreementLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _supportLevelAgreementLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLevelAgreementLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns the support level agreement with the primary key.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement
	 * @throws PortalException if a support level agreement with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
			getSupportLevelAgreement(long supportLevelAgreementId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLevelAgreementLocalService.getSupportLevelAgreement(
			supportLevelAgreementId);
	}

	/**
	 * Returns a range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.liferay.yithro.support.model.impl.SupportLevelAgreementModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @return the range of support level agreements
	 */
	@Override
	public java.util.List
		<com.liferay.yithro.support.model.SupportLevelAgreement>
			getSupportLevelAgreements(int start, int end) {

		return _supportLevelAgreementLocalService.getSupportLevelAgreements(
			start, end);
	}

	/**
	 * Returns the number of support level agreements.
	 *
	 * @return the number of support level agreements
	 */
	@Override
	public int getSupportLevelAgreementsCount() {
		return _supportLevelAgreementLocalService.
			getSupportLevelAgreementsCount();
	}

	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
			updateSupportLevelAgreement(
				long supportLevelAgreementId, String name, String description)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _supportLevelAgreementLocalService.updateSupportLevelAgreement(
			supportLevelAgreementId, name, description);
	}

	/**
	 * Updates the support level agreement in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreement the support level agreement
	 * @return the support level agreement that was updated
	 */
	@Override
	public com.liferay.yithro.support.model.SupportLevelAgreement
		updateSupportLevelAgreement(
			com.liferay.yithro.support.model.SupportLevelAgreement
				supportLevelAgreement) {

		return _supportLevelAgreementLocalService.updateSupportLevelAgreement(
			supportLevelAgreement);
	}

	@Override
	public SupportLevelAgreementLocalService getWrappedService() {
		return _supportLevelAgreementLocalService;
	}

	@Override
	public void setWrappedService(
		SupportLevelAgreementLocalService supportLevelAgreementLocalService) {

		_supportLevelAgreementLocalService = supportLevelAgreementLocalService;
	}

	private SupportLevelAgreementLocalService
		_supportLevelAgreementLocalService;

}