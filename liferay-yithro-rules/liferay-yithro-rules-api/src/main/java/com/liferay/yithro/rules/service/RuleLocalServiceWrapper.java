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
 * Provides a wrapper for {@link RuleLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RuleLocalService
 * @generated
 */
public class RuleLocalServiceWrapper
	implements RuleLocalService, ServiceWrapper<RuleLocalService> {

	public RuleLocalServiceWrapper(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	/**
	 * Adds the rule to the database. Also notifies the appropriate model listeners.
	 *
	 * @param rule the rule
	 * @return the rule that was added
	 */
	@Override
	public com.liferay.yithro.rules.model.Rule addRule(
		com.liferay.yithro.rules.model.Rule rule) {

		return _ruleLocalService.addRule(rule);
	}

	@Override
	public com.liferay.yithro.rules.model.Rule addRule(
			String name, String objectName, String objectEvent)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleLocalService.addRule(name, objectName, objectEvent);
	}

	/**
	 * Creates a new rule with the primary key. Does not add the rule to the database.
	 *
	 * @param ruleId the primary key for the new rule
	 * @return the new rule
	 */
	@Override
	public com.liferay.yithro.rules.model.Rule createRule(long ruleId) {
		return _ruleLocalService.createRule(ruleId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule that was removed
	 * @throws PortalException if a rule with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.rules.model.Rule deleteRule(long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleLocalService.deleteRule(ruleId);
	}

	/**
	 * Deletes the rule from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rule the rule
	 * @return the rule that was removed
	 */
	@Override
	public com.liferay.yithro.rules.model.Rule deleteRule(
		com.liferay.yithro.rules.model.Rule rule) {

		return _ruleLocalService.deleteRule(rule);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ruleLocalService.dynamicQuery();
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

		return _ruleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleModelImpl</code>.
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

		return _ruleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleModelImpl</code>.
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

		return _ruleLocalService.dynamicQuery(
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

		return _ruleLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ruleLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.rules.model.Rule fetchRule(long ruleId) {
		return _ruleLocalService.fetchRule(ruleId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ruleLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ruleLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ruleLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rule with the primary key.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule
	 * @throws PortalException if a rule with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.rules.model.Rule getRule(long ruleId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleLocalService.getRule(ruleId);
	}

	/**
	 * Returns a range of all the rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @return the range of rules
	 */
	@Override
	public java.util.List<com.liferay.yithro.rules.model.Rule> getRules(
		int start, int end) {

		return _ruleLocalService.getRules(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.rules.model.Rule> getRules(
		String objectName, String objectEvent) {

		return _ruleLocalService.getRules(objectName, objectEvent);
	}

	/**
	 * Returns the number of rules.
	 *
	 * @return the number of rules
	 */
	@Override
	public int getRulesCount() {
		return _ruleLocalService.getRulesCount();
	}

	/**
	 * Updates the rule in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param rule the rule
	 * @return the rule that was updated
	 */
	@Override
	public com.liferay.yithro.rules.model.Rule updateRule(
		com.liferay.yithro.rules.model.Rule rule) {

		return _ruleLocalService.updateRule(rule);
	}

	@Override
	public RuleLocalService getWrappedService() {
		return _ruleLocalService;
	}

	@Override
	public void setWrappedService(RuleLocalService ruleLocalService) {
		_ruleLocalService = ruleLocalService;
	}

	private RuleLocalService _ruleLocalService;

}