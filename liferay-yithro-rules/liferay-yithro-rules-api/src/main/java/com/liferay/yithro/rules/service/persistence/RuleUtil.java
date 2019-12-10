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

package com.liferay.yithro.rules.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.rules.model.Rule;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the rule service. This utility wraps <code>com.liferay.yithro.rules.service.persistence.impl.RulePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RulePersistence
 * @generated
 */
public class RuleUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Rule rule) {
		getPersistence().clearCache(rule);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Rule> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Rule> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Rule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Rule> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Rule> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Rule update(Rule rule) {
		return getPersistence().update(rule);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Rule update(Rule rule, ServiceContext serviceContext) {
		return getPersistence().update(rule, serviceContext);
	}

	/**
	 * Returns all the rules where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @return the matching rules
	 */
	public static List<Rule> findByON_OE(
		String objectName, String objectEvent) {

		return getPersistence().findByON_OE(objectName, objectEvent);
	}

	/**
	 * Returns a range of all the rules where objectName = &#63; and objectEvent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleModelImpl</code>.
	 * </p>
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @return the range of matching rules
	 */
	public static List<Rule> findByON_OE(
		String objectName, String objectEvent, int start, int end) {

		return getPersistence().findByON_OE(
			objectName, objectEvent, start, end);
	}

	/**
	 * Returns an ordered range of all the rules where objectName = &#63; and objectEvent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleModelImpl</code>.
	 * </p>
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rules
	 */
	public static List<Rule> findByON_OE(
		String objectName, String objectEvent, int start, int end,
		OrderByComparator<Rule> orderByComparator) {

		return getPersistence().findByON_OE(
			objectName, objectEvent, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rules where objectName = &#63; and objectEvent = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleModelImpl</code>.
	 * </p>
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rules
	 */
	public static List<Rule> findByON_OE(
		String objectName, String objectEvent, int start, int end,
		OrderByComparator<Rule> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByON_OE(
			objectName, objectEvent, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first rule in the ordered set where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule
	 * @throws NoSuchRuleException if a matching rule could not be found
	 */
	public static Rule findByON_OE_First(
			String objectName, String objectEvent,
			OrderByComparator<Rule> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleException {

		return getPersistence().findByON_OE_First(
			objectName, objectEvent, orderByComparator);
	}

	/**
	 * Returns the first rule in the ordered set where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule, or <code>null</code> if a matching rule could not be found
	 */
	public static Rule fetchByON_OE_First(
		String objectName, String objectEvent,
		OrderByComparator<Rule> orderByComparator) {

		return getPersistence().fetchByON_OE_First(
			objectName, objectEvent, orderByComparator);
	}

	/**
	 * Returns the last rule in the ordered set where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule
	 * @throws NoSuchRuleException if a matching rule could not be found
	 */
	public static Rule findByON_OE_Last(
			String objectName, String objectEvent,
			OrderByComparator<Rule> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleException {

		return getPersistence().findByON_OE_Last(
			objectName, objectEvent, orderByComparator);
	}

	/**
	 * Returns the last rule in the ordered set where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule, or <code>null</code> if a matching rule could not be found
	 */
	public static Rule fetchByON_OE_Last(
		String objectName, String objectEvent,
		OrderByComparator<Rule> orderByComparator) {

		return getPersistence().fetchByON_OE_Last(
			objectName, objectEvent, orderByComparator);
	}

	/**
	 * Returns the rules before and after the current rule in the ordered set where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param ruleId the primary key of the current rule
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule
	 * @throws NoSuchRuleException if a rule with the primary key could not be found
	 */
	public static Rule[] findByON_OE_PrevAndNext(
			long ruleId, String objectName, String objectEvent,
			OrderByComparator<Rule> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchRuleException {

		return getPersistence().findByON_OE_PrevAndNext(
			ruleId, objectName, objectEvent, orderByComparator);
	}

	/**
	 * Removes all the rules where objectName = &#63; and objectEvent = &#63; from the database.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 */
	public static void removeByON_OE(String objectName, String objectEvent) {
		getPersistence().removeByON_OE(objectName, objectEvent);
	}

	/**
	 * Returns the number of rules where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @return the number of matching rules
	 */
	public static int countByON_OE(String objectName, String objectEvent) {
		return getPersistence().countByON_OE(objectName, objectEvent);
	}

	/**
	 * Caches the rule in the entity cache if it is enabled.
	 *
	 * @param rule the rule
	 */
	public static void cacheResult(Rule rule) {
		getPersistence().cacheResult(rule);
	}

	/**
	 * Caches the rules in the entity cache if it is enabled.
	 *
	 * @param rules the rules
	 */
	public static void cacheResult(List<Rule> rules) {
		getPersistence().cacheResult(rules);
	}

	/**
	 * Creates a new rule with the primary key. Does not add the rule to the database.
	 *
	 * @param ruleId the primary key for the new rule
	 * @return the new rule
	 */
	public static Rule create(long ruleId) {
		return getPersistence().create(ruleId);
	}

	/**
	 * Removes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule that was removed
	 * @throws NoSuchRuleException if a rule with the primary key could not be found
	 */
	public static Rule remove(long ruleId)
		throws com.liferay.yithro.rules.exception.NoSuchRuleException {

		return getPersistence().remove(ruleId);
	}

	public static Rule updateImpl(Rule rule) {
		return getPersistence().updateImpl(rule);
	}

	/**
	 * Returns the rule with the primary key or throws a <code>NoSuchRuleException</code> if it could not be found.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule
	 * @throws NoSuchRuleException if a rule with the primary key could not be found
	 */
	public static Rule findByPrimaryKey(long ruleId)
		throws com.liferay.yithro.rules.exception.NoSuchRuleException {

		return getPersistence().findByPrimaryKey(ruleId);
	}

	/**
	 * Returns the rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule, or <code>null</code> if a rule with the primary key could not be found
	 */
	public static Rule fetchByPrimaryKey(long ruleId) {
		return getPersistence().fetchByPrimaryKey(ruleId);
	}

	/**
	 * Returns all the rules.
	 *
	 * @return the rules
	 */
	public static List<Rule> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @return the range of rules
	 */
	public static List<Rule> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rules
	 */
	public static List<Rule> findAll(
		int start, int end, OrderByComparator<Rule> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rules
	 */
	public static List<Rule> findAll(
		int start, int end, OrderByComparator<Rule> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the rules from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of rules.
	 *
	 * @return the number of rules
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static RulePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RulePersistence, RulePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(RulePersistence.class);

		ServiceTracker<RulePersistence, RulePersistence> serviceTracker =
			new ServiceTracker<RulePersistence, RulePersistence>(
				bundle.getBundleContext(), RulePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}