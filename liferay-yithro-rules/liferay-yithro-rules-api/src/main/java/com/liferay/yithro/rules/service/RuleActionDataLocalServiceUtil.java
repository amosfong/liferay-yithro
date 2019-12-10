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
 * Provides the local service utility for RuleActionData. This utility wraps
 * <code>com.liferay.yithro.rules.service.impl.RuleActionDataLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see RuleActionDataLocalService
 * @generated
 */
public class RuleActionDataLocalServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.yithro.rules.service.impl.RuleActionDataLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the rule action data to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionData the rule action data
	 * @return the rule action data that was added
	 */
	public static com.liferay.yithro.rules.model.RuleActionData
		addRuleActionData(
			com.liferay.yithro.rules.model.RuleActionData ruleActionData) {

		return getService().addRuleActionData(ruleActionData);
	}

	/**
	 * Creates a new rule action data with the primary key. Does not add the rule action data to the database.
	 *
	 * @param ruleActionDataId the primary key for the new rule action data
	 * @return the new rule action data
	 */
	public static com.liferay.yithro.rules.model.RuleActionData
		createRuleActionData(long ruleActionDataId) {

		return getService().createRuleActionData(ruleActionDataId);
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
	 * Deletes the rule action data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data that was removed
	 * @throws PortalException if a rule action data with the primary key could not be found
	 */
	public static com.liferay.yithro.rules.model.RuleActionData
			deleteRuleActionData(long ruleActionDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteRuleActionData(ruleActionDataId);
	}

	/**
	 * Deletes the rule action data from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionData the rule action data
	 * @return the rule action data that was removed
	 */
	public static com.liferay.yithro.rules.model.RuleActionData
		deleteRuleActionData(
			com.liferay.yithro.rules.model.RuleActionData ruleActionData) {

		return getService().deleteRuleActionData(ruleActionData);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleActionDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.yithro.rules.model.impl.RuleActionDataModelImpl</code>.
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

	public static com.liferay.yithro.rules.model.RuleActionData
		fetchRuleActionData(long ruleActionDataId) {

		return getService().fetchRuleActionData(ruleActionDataId);
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
	 * Returns the rule action data with the primary key.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data
	 * @throws PortalException if a rule action data with the primary key could not be found
	 */
	public static com.liferay.yithro.rules.model.RuleActionData
			getRuleActionData(long ruleActionDataId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getRuleActionData(ruleActionDataId);
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
	public static java.util.List<com.liferay.yithro.rules.model.RuleActionData>
		getRuleActionDatas(int start, int end) {

		return getService().getRuleActionDatas(start, end);
	}

	/**
	 * Returns the number of rule action datas.
	 *
	 * @return the number of rule action datas
	 */
	public static int getRuleActionDatasCount() {
		return getService().getRuleActionDatasCount();
	}

	/**
	 * Updates the rule action data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionData the rule action data
	 * @return the rule action data that was updated
	 */
	public static com.liferay.yithro.rules.model.RuleActionData
		updateRuleActionData(
			com.liferay.yithro.rules.model.RuleActionData ruleActionData) {

		return getService().updateRuleActionData(ruleActionData);
	}

	public static RuleActionDataLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<RuleActionDataLocalService, RuleActionDataLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			RuleActionDataLocalService.class);

		ServiceTracker<RuleActionDataLocalService, RuleActionDataLocalService>
			serviceTracker =
				new ServiceTracker
					<RuleActionDataLocalService, RuleActionDataLocalService>(
						bundle.getBundleContext(),
						RuleActionDataLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}