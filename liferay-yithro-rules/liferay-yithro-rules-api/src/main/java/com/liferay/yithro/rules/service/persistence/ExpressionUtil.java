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
import com.liferay.yithro.rules.model.Expression;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the expression service. This utility wraps <code>com.liferay.yithro.rules.service.persistence.impl.ExpressionPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpressionPersistence
 * @generated
 */
@ProviderType
public class ExpressionUtil {

	/*
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
	public static void clearCache(Expression expression) {
		getPersistence().clearCache(expression);
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
	public static Map<Serializable, Expression> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Expression> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Expression> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Expression> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Expression> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Expression update(Expression expression) {
		return getPersistence().update(expression);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Expression update(
		Expression expression, ServiceContext serviceContext) {

		return getPersistence().update(expression, serviceContext);
	}

	/**
	 * Returns all the expressions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching expressions
	 */
	public static List<Expression> findByRuleId(long ruleId) {
		return getPersistence().findByRuleId(ruleId);
	}

	/**
	 * Returns a range of all the expressions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @return the range of matching expressions
	 */
	public static List<Expression> findByRuleId(
		long ruleId, int start, int end) {

		return getPersistence().findByRuleId(ruleId, start, end);
	}

	/**
	 * Returns an ordered range of all the expressions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expressions
	 */
	public static List<Expression> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<Expression> orderByComparator) {

		return getPersistence().findByRuleId(
			ruleId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expressions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching expressions
	 */
	public static List<Expression> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<Expression> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByRuleId(
			ruleId, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression
	 * @throws NoSuchExpressionException if a matching expression could not be found
	 */
	public static Expression findByRuleId_First(
			long ruleId, OrderByComparator<Expression> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchExpressionException {

		return getPersistence().findByRuleId_First(ruleId, orderByComparator);
	}

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression, or <code>null</code> if a matching expression could not be found
	 */
	public static Expression fetchByRuleId_First(
		long ruleId, OrderByComparator<Expression> orderByComparator) {

		return getPersistence().fetchByRuleId_First(ruleId, orderByComparator);
	}

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression
	 * @throws NoSuchExpressionException if a matching expression could not be found
	 */
	public static Expression findByRuleId_Last(
			long ruleId, OrderByComparator<Expression> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchExpressionException {

		return getPersistence().findByRuleId_Last(ruleId, orderByComparator);
	}

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression, or <code>null</code> if a matching expression could not be found
	 */
	public static Expression fetchByRuleId_Last(
		long ruleId, OrderByComparator<Expression> orderByComparator) {

		return getPersistence().fetchByRuleId_Last(ruleId, orderByComparator);
	}

	/**
	 * Returns the expressions before and after the current expression in the ordered set where ruleId = &#63;.
	 *
	 * @param expressionId the primary key of the current expression
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expression
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	public static Expression[] findByRuleId_PrevAndNext(
			long expressionId, long ruleId,
			OrderByComparator<Expression> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchExpressionException {

		return getPersistence().findByRuleId_PrevAndNext(
			expressionId, ruleId, orderByComparator);
	}

	/**
	 * Removes all the expressions where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 */
	public static void removeByRuleId(long ruleId) {
		getPersistence().removeByRuleId(ruleId);
	}

	/**
	 * Returns the number of expressions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching expressions
	 */
	public static int countByRuleId(long ruleId) {
		return getPersistence().countByRuleId(ruleId);
	}

	/**
	 * Returns all the expressions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the matching expressions
	 */
	public static List<Expression> findByR_T(long ruleId, String type) {
		return getPersistence().findByR_T(ruleId, type);
	}

	/**
	 * Returns a range of all the expressions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @return the range of matching expressions
	 */
	public static List<Expression> findByR_T(
		long ruleId, String type, int start, int end) {

		return getPersistence().findByR_T(ruleId, type, start, end);
	}

	/**
	 * Returns an ordered range of all the expressions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching expressions
	 */
	public static List<Expression> findByR_T(
		long ruleId, String type, int start, int end,
		OrderByComparator<Expression> orderByComparator) {

		return getPersistence().findByR_T(
			ruleId, type, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expressions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching expressions
	 */
	public static List<Expression> findByR_T(
		long ruleId, String type, int start, int end,
		OrderByComparator<Expression> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findByR_T(
			ruleId, type, start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression
	 * @throws NoSuchExpressionException if a matching expression could not be found
	 */
	public static Expression findByR_T_First(
			long ruleId, String type,
			OrderByComparator<Expression> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchExpressionException {

		return getPersistence().findByR_T_First(
			ruleId, type, orderByComparator);
	}

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression, or <code>null</code> if a matching expression could not be found
	 */
	public static Expression fetchByR_T_First(
		long ruleId, String type,
		OrderByComparator<Expression> orderByComparator) {

		return getPersistence().fetchByR_T_First(
			ruleId, type, orderByComparator);
	}

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression
	 * @throws NoSuchExpressionException if a matching expression could not be found
	 */
	public static Expression findByR_T_Last(
			long ruleId, String type,
			OrderByComparator<Expression> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchExpressionException {

		return getPersistence().findByR_T_Last(ruleId, type, orderByComparator);
	}

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression, or <code>null</code> if a matching expression could not be found
	 */
	public static Expression fetchByR_T_Last(
		long ruleId, String type,
		OrderByComparator<Expression> orderByComparator) {

		return getPersistence().fetchByR_T_Last(
			ruleId, type, orderByComparator);
	}

	/**
	 * Returns the expressions before and after the current expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param expressionId the primary key of the current expression
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next expression
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	public static Expression[] findByR_T_PrevAndNext(
			long expressionId, long ruleId, String type,
			OrderByComparator<Expression> orderByComparator)
		throws com.liferay.yithro.rules.exception.NoSuchExpressionException {

		return getPersistence().findByR_T_PrevAndNext(
			expressionId, ruleId, type, orderByComparator);
	}

	/**
	 * Removes all the expressions where ruleId = &#63; and type = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 */
	public static void removeByR_T(long ruleId, String type) {
		getPersistence().removeByR_T(ruleId, type);
	}

	/**
	 * Returns the number of expressions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the number of matching expressions
	 */
	public static int countByR_T(long ruleId, String type) {
		return getPersistence().countByR_T(ruleId, type);
	}

	/**
	 * Caches the expression in the entity cache if it is enabled.
	 *
	 * @param expression the expression
	 */
	public static void cacheResult(Expression expression) {
		getPersistence().cacheResult(expression);
	}

	/**
	 * Caches the expressions in the entity cache if it is enabled.
	 *
	 * @param expressions the expressions
	 */
	public static void cacheResult(List<Expression> expressions) {
		getPersistence().cacheResult(expressions);
	}

	/**
	 * Creates a new expression with the primary key. Does not add the expression to the database.
	 *
	 * @param expressionId the primary key for the new expression
	 * @return the new expression
	 */
	public static Expression create(long expressionId) {
		return getPersistence().create(expressionId);
	}

	/**
	 * Removes the expression with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression that was removed
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	public static Expression remove(long expressionId)
		throws com.liferay.yithro.rules.exception.NoSuchExpressionException {

		return getPersistence().remove(expressionId);
	}

	public static Expression updateImpl(Expression expression) {
		return getPersistence().updateImpl(expression);
	}

	/**
	 * Returns the expression with the primary key or throws a <code>NoSuchExpressionException</code> if it could not be found.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	public static Expression findByPrimaryKey(long expressionId)
		throws com.liferay.yithro.rules.exception.NoSuchExpressionException {

		return getPersistence().findByPrimaryKey(expressionId);
	}

	/**
	 * Returns the expression with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression, or <code>null</code> if a expression with the primary key could not be found
	 */
	public static Expression fetchByPrimaryKey(long expressionId) {
		return getPersistence().fetchByPrimaryKey(expressionId);
	}

	/**
	 * Returns all the expressions.
	 *
	 * @return the expressions
	 */
	public static List<Expression> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the expressions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @return the range of expressions
	 */
	public static List<Expression> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the expressions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of expressions
	 */
	public static List<Expression> findAll(
		int start, int end, OrderByComparator<Expression> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the expressions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ExpressionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of expressions
	 * @param end the upper bound of the range of expressions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of expressions
	 */
	public static List<Expression> findAll(
		int start, int end, OrderByComparator<Expression> orderByComparator,
		boolean retrieveFromCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, retrieveFromCache);
	}

	/**
	 * Removes all the expressions from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of expressions.
	 *
	 * @return the number of expressions
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ExpressionPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ExpressionPersistence, ExpressionPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ExpressionPersistence.class);

		ServiceTracker<ExpressionPersistence, ExpressionPersistence>
			serviceTracker =
				new ServiceTracker
					<ExpressionPersistence, ExpressionPersistence>(
						bundle.getBundleContext(), ExpressionPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}