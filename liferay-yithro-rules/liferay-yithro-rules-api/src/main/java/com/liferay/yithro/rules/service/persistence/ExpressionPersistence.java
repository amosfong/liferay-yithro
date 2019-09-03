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

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.yithro.rules.exception.NoSuchExpressionException;
import com.liferay.yithro.rules.model.Expression;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the expression service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExpressionUtil
 * @generated
 */
@ProviderType
public interface ExpressionPersistence extends BasePersistence<Expression> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExpressionUtil} to access the expression persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the expressions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the matching expressions
	 */
	public java.util.List<Expression> findByR_T(long ruleId, String type);

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
	public java.util.List<Expression> findByR_T(
		long ruleId, String type, int start, int end);

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
	public java.util.List<Expression> findByR_T(
		long ruleId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expression>
			orderByComparator);

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
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching expressions
	 */
	public java.util.List<Expression> findByR_T(
		long ruleId, String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expression>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression
	 * @throws NoSuchExpressionException if a matching expression could not be found
	 */
	public Expression findByR_T_First(
			long ruleId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Expression>
				orderByComparator)
		throws NoSuchExpressionException;

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression, or <code>null</code> if a matching expression could not be found
	 */
	public Expression fetchByR_T_First(
		long ruleId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Expression>
			orderByComparator);

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression
	 * @throws NoSuchExpressionException if a matching expression could not be found
	 */
	public Expression findByR_T_Last(
			long ruleId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Expression>
				orderByComparator)
		throws NoSuchExpressionException;

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression, or <code>null</code> if a matching expression could not be found
	 */
	public Expression fetchByR_T_Last(
		long ruleId, String type,
		com.liferay.portal.kernel.util.OrderByComparator<Expression>
			orderByComparator);

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
	public Expression[] findByR_T_PrevAndNext(
			long expressionId, long ruleId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<Expression>
				orderByComparator)
		throws NoSuchExpressionException;

	/**
	 * Removes all the expressions where ruleId = &#63; and type = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 */
	public void removeByR_T(long ruleId, String type);

	/**
	 * Returns the number of expressions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the number of matching expressions
	 */
	public int countByR_T(long ruleId, String type);

	/**
	 * Caches the expression in the entity cache if it is enabled.
	 *
	 * @param expression the expression
	 */
	public void cacheResult(Expression expression);

	/**
	 * Caches the expressions in the entity cache if it is enabled.
	 *
	 * @param expressions the expressions
	 */
	public void cacheResult(java.util.List<Expression> expressions);

	/**
	 * Creates a new expression with the primary key. Does not add the expression to the database.
	 *
	 * @param expressionId the primary key for the new expression
	 * @return the new expression
	 */
	public Expression create(long expressionId);

	/**
	 * Removes the expression with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression that was removed
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	public Expression remove(long expressionId)
		throws NoSuchExpressionException;

	public Expression updateImpl(Expression expression);

	/**
	 * Returns the expression with the primary key or throws a <code>NoSuchExpressionException</code> if it could not be found.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	public Expression findByPrimaryKey(long expressionId)
		throws NoSuchExpressionException;

	/**
	 * Returns the expression with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression, or <code>null</code> if a expression with the primary key could not be found
	 */
	public Expression fetchByPrimaryKey(long expressionId);

	/**
	 * Returns all the expressions.
	 *
	 * @return the expressions
	 */
	public java.util.List<Expression> findAll();

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
	public java.util.List<Expression> findAll(int start, int end);

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
	public java.util.List<Expression> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expression>
			orderByComparator);

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
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of expressions
	 */
	public java.util.List<Expression> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Expression>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the expressions from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of expressions.
	 *
	 * @return the number of expressions
	 */
	public int countAll();

}