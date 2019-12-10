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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for RuleCondition. This utility wraps
 * <code>com.liferay.yithro.rules.service.impl.RuleConditionLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RuleConditionLocalService
 * @generated
 */
public class RuleConditionLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.rules.service.impl.RuleConditionLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RuleConditionLocalServiceUtil} to access the rule condition local service. Add custom service methods to <code>com.liferay.yithro.rules.service.impl.RuleConditionLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static com.liferay.yithro.rules.model.RuleCondition addRuleCondition(
			long ruleId, String type, String field, String operation,
			String value)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().addRuleCondition(
			ruleId, type, field, operation, value);
	}

	/**
	 * Adds the rule condition to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleCondition the rule condition
	 * @return the rule condition that was added
	 */
	public static com.liferay.yithro.rules.model.RuleCondition addRuleCondition(
		com.liferay.yithro.rules.model.RuleCondition ruleCondition) {

		return getService().addRuleCondition(ruleCondition);
	}

	/**
	 * Creates a new rule condition with the primary key. Does not add the rule condition to the database.
	 *
	 * @param ruleConditionId the primary key for the new rule condition
	 * @return the new rule condition
	 */
	public static com.liferay.yithro.rules.model.RuleCondition
		createRuleCondition(long ruleConditionId) {

		return getService().createRuleCondition(ruleConditionId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the rule condition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition that was removed
	 * @throws PortalException if a rule condition with the primary key could not be found
	 */
	public static com.liferay.yithro.rules.model.RuleCondition
			deleteRuleCondition(long ruleConditionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRuleCondition(ruleConditionId);
	}

	/**
	 * Deletes the rule condition from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleCondition the rule condition
	 * @return the rule condition that was removed
	 */
	public static com.liferay.yithro.rules.model.RuleCondition
		deleteRuleCondition(
			com.liferay.yithro.rules.model.RuleCondition ruleCondition) {

		return getService().deleteRuleCondition(ruleCondition);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.yithro.rules.model.RuleCondition
		fetchRuleCondition(long ruleConditionId) {

		return getService().fetchRuleCondition(ruleConditionId);
	}

	public static java.util.List<com.liferay.yithro.rules.model.RuleCondition>
		findByR_T(long ruleId, String type) {

		return getService().findByR_T(ruleId, type);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the rule condition with the primary key.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition
	 * @throws PortalException if a rule condition with the primary key could not be found
	 */
	public static com.liferay.yithro.rules.model.RuleCondition getRuleCondition(
			long ruleConditionId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRuleCondition(ruleConditionId);
	}

	/**
	 * Returns a range of all the rule conditions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @return the range of rule conditions
	 */
	public static java.util.List<com.liferay.yithro.rules.model.RuleCondition>
		getRuleConditions(int start, int end) {

		return getService().getRuleConditions(start, end);
	}

	/**
	 * Returns the number of rule conditions.
	 *
	 * @return the number of rule conditions
	 */
	public static int getRuleConditionsCount() {
		return getService().getRuleConditionsCount();
	}

	/**
	 * Updates the rule condition in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ruleCondition the rule condition
	 * @return the rule condition that was updated
	 */
	public static com.liferay.yithro.rules.model.RuleCondition
		updateRuleCondition(
			com.liferay.yithro.rules.model.RuleCondition ruleCondition) {

		return getService().updateRuleCondition(ruleCondition);
	}

	public static RuleConditionLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RuleConditionLocalService, RuleConditionLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RuleConditionLocalService.class);

		ServiceTracker<RuleConditionLocalService, RuleConditionLocalService>
			serviceTracker =
				new ServiceTracker
					<RuleConditionLocalService, RuleConditionLocalService>(
						bundle.getBundleContext(),
						RuleConditionLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}