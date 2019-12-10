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
 * Provides a wrapper for {@link RuleActionLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionLocalService
 * @generated
 */
public class RuleActionLocalServiceWrapper
	implements RuleActionLocalService, ServiceWrapper<RuleActionLocalService> {

	public RuleActionLocalServiceWrapper(
		RuleActionLocalService ruleActionLocalService) {

		_ruleActionLocalService = ruleActionLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleActionLocalServiceUtil} to access the rule action local service. Add custom service methods to <code>com.liferay.yithro.rules.service.impl.RuleActionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleAction addRuleAction(
			long ruleId, String actionClassName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionLocalService.addRuleAction(ruleId, actionClassName);
	}

	/**
	 * Adds the rule action to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleAction the rule action
	 * @return the rule action that was added
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleAction addRuleAction(
		com.liferay.yithro.rules.model.RuleAction ruleAction) {

		return _ruleActionLocalService.addRuleAction(ruleAction);
	}

	/**
	 * Creates a new rule action with the primary key. Does not add the rule action to the database.
	 *
	 * @param ruleActionId the primary key for the new rule action
	 * @return the new rule action
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleAction createRuleAction(
		long ruleActionId) {

		return _ruleActionLocalService.createRuleAction(ruleActionId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rule action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action that was removed
	 * @throws PortalException if a rule action with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleAction deleteRuleAction(
			long ruleActionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionLocalService.deleteRuleAction(ruleActionId);
	}

	/**
	 * Deletes the rule action from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleAction the rule action
	 * @return the rule action that was removed
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleAction deleteRuleAction(
		com.liferay.yithro.rules.model.RuleAction ruleAction) {

		return _ruleActionLocalService.deleteRuleAction(ruleAction);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ruleActionLocalService.dynamicQuery();
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

		return _ruleActionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleActionModelImpl</code>.
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

		return _ruleActionLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleActionModelImpl</code>.
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

		return _ruleActionLocalService.dynamicQuery(
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

		return _ruleActionLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ruleActionLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.yithro.rules.model.RuleAction fetchRuleAction(
		long ruleActionId) {

		return _ruleActionLocalService.fetchRuleAction(ruleActionId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ruleActionLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ruleActionLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ruleActionLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rule action with the primary key.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action
	 * @throws PortalException if a rule action with the primary key could not be found
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleAction getRuleAction(
			long ruleActionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ruleActionLocalService.getRuleAction(ruleActionId);
	}

	/**
	 * Returns a range of all the rule actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @return the range of rule actions
	 */
	@Override
	public java.util.List<com.liferay.yithro.rules.model.RuleAction>
		getRuleActions(int start, int end) {

		return _ruleActionLocalService.getRuleActions(start, end);
	}

	@Override
	public java.util.List<com.liferay.yithro.rules.model.RuleAction>
		getRuleActions(long ruleId) {

		return _ruleActionLocalService.getRuleActions(ruleId);
	}

	/**
	 * Returns the number of rule actions.
	 *
	 * @return the number of rule actions
	 */
	@Override
	public int getRuleActionsCount() {
		return _ruleActionLocalService.getRuleActionsCount();
	}

	/**
	 * Updates the rule action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ruleAction the rule action
	 * @return the rule action that was updated
	 */
	@Override
	public com.liferay.yithro.rules.model.RuleAction updateRuleAction(
		com.liferay.yithro.rules.model.RuleAction ruleAction) {

		return _ruleActionLocalService.updateRuleAction(ruleAction);
	}

	@Override
	public RuleActionLocalService getWrappedService() {
		return _ruleActionLocalService;
	}

	@Override
	public void setWrappedService(
		RuleActionLocalService ruleActionLocalService) {

		_ruleActionLocalService = ruleActionLocalService;
	}

	private RuleActionLocalService _ruleActionLocalService;

}