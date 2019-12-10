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

package com.liferay.yithro.rules.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RuleActionDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionDataLocalService
 * @generated
 */
public class RuleActionDataLocalServiceWrapper
	implements RuleActionDataLocalService,
			   ServiceWrapper<RuleActionDataLocalService> {

	public RuleActionDataLocalServiceWrapper(
		RuleActionDataLocalService ruleActionDataLocalService) {

		_ruleActionDataLocalService = ruleActionDataLocalService;
	}

	/**
	 * Adds the rule action data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionData the rule action data
	 * @return the rule action data that was added
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleActionData addRuleActionData(
		com.liferay.yithro.rules.model.RuleActionData ruleActionData) {

		return _ruleActionDataLocalService.addRuleActionData(ruleActionData);
	}

	/**
	 * Creates a new rule action data with the primary key. Does not add the rule action data to the database.
	 *
	 * @param ruleActionDataId the primary key for the new rule action data
	 * @return the new rule action data
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleActionData createRuleActionData(
		long ruleActionDataId) {

		return _ruleActionDataLocalService.createRuleActionData(
			ruleActionDataId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionDataLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rule action data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data that was removed
	 * @throws PortalException if a rule action data with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleActionData deleteRuleActionData(
			long ruleActionDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionDataLocalService.deleteRuleActionData(
			ruleActionDataId);
	}

	/**
	 * Deletes the rule action data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionData the rule action data
	 * @return the rule action data that was removed
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleActionData deleteRuleActionData(
		com.liferay.yithro.rules.model.RuleActionData ruleActionData) {

		return _ruleActionDataLocalService.deleteRuleActionData(ruleActionData);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ruleActionDataLocalService.dynamicQuery();
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

		return _ruleActionDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleActionDataModelImpl</code>.
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

		return _ruleActionDataLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleActionDataModelImpl</code>.
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

		return _ruleActionDataLocalService.dynamicQuery(
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

		return _ruleActionDataLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ruleActionDataLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.rules.model.RuleActionData fetchRuleActionData(
		long ruleActionDataId) {

		return _ruleActionDataLocalService.fetchRuleActionData(
			ruleActionDataId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ruleActionDataLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ruleActionDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ruleActionDataLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rule action data with the primary key.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data
	 * @throws PortalException if a rule action data with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleActionData getRuleActionData(
			long ruleActionDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionDataLocalService.getRuleActionData(ruleActionDataId);
	}

	/**
	 * Returns a range of all the rule action datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @return the range of rule action datas
	 */
	@Override
	public java.util.List<com.liferay.yithro.rules.model.RuleActionData>
		getRuleActionDatas(int start, int end) {

		return _ruleActionDataLocalService.getRuleActionDatas(start, end);
	}

	/**
	 * Returns the number of rule action datas.
	 *
	 * @return the number of rule action datas
	 */
	@Override
	public int getRuleActionDatasCount() {
		return _ruleActionDataLocalService.getRuleActionDatasCount();
	}

	/**
	 * Updates the rule action data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionData the rule action data
	 * @return the rule action data that was updated
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleActionData updateRuleActionData(
		com.liferay.yithro.rules.model.RuleActionData ruleActionData) {

		return _ruleActionDataLocalService.updateRuleActionData(ruleActionData);
	}

	@Override
	public RuleActionDataLocalService getWrappedService() {
		return _ruleActionDataLocalService;
	}

	@Override
	public void setWrappedService(
		RuleActionDataLocalService ruleActionDataLocalService) {

		_ruleActionDataLocalService = ruleActionDataLocalService;
	}

	private RuleActionDataLocalService _ruleActionDataLocalService;

}