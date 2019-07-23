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

package com.liferay.yithro.rules.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.yithro.rules.exception.NoSuchExpressionException;
import com.liferay.yithro.rules.model.Expression;
import com.liferay.yithro.rules.model.impl.ExpressionImpl;
import com.liferay.yithro.rules.model.impl.ExpressionModelImpl;
import com.liferay.yithro.rules.service.persistence.ExpressionPersistence;
import com.liferay.yithro.rules.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the expression service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ExpressionPersistence.class)
@ProviderType
public class ExpressionPersistenceImpl
	extends BasePersistenceImpl<Expression> implements ExpressionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExpressionUtil</code> to access the expression persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExpressionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByRuleId;
	private FinderPath _finderPathWithoutPaginationFindByRuleId;
	private FinderPath _finderPathCountByRuleId;

	/**
	 * Returns all the expressions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching expressions
	 */
	@Override
	public List<Expression> findByRuleId(long ruleId) {
		return findByRuleId(ruleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Expression> findByRuleId(long ruleId, int start, int end) {
		return findByRuleId(ruleId, start, end, null);
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
	@Override
	public List<Expression> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<Expression> orderByComparator) {

		return findByRuleId(ruleId, start, end, orderByComparator, true);
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
	@Override
	public List<Expression> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<Expression> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByRuleId;
			finderArgs = new Object[] {ruleId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByRuleId;
			finderArgs = new Object[] {ruleId, start, end, orderByComparator};
		}

		List<Expression> list = null;

		if (retrieveFromCache) {
			list = (List<Expression>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Expression expression : list) {
					if ((ruleId != expression.getRuleId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_EXPRESSION_WHERE);

			query.append(_FINDER_COLUMN_RULEID_RULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ExpressionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				if (!pagination) {
					list = (List<Expression>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Expression>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression
	 * @throws NoSuchExpressionException if a matching expression could not be found
	 */
	@Override
	public Expression findByRuleId_First(
			long ruleId, OrderByComparator<Expression> orderByComparator)
		throws NoSuchExpressionException {

		Expression expression = fetchByRuleId_First(ruleId, orderByComparator);

		if (expression != null) {
			return expression;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append("}");

		throw new NoSuchExpressionException(msg.toString());
	}

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression, or <code>null</code> if a matching expression could not be found
	 */
	@Override
	public Expression fetchByRuleId_First(
		long ruleId, OrderByComparator<Expression> orderByComparator) {

		List<Expression> list = findByRuleId(ruleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression
	 * @throws NoSuchExpressionException if a matching expression could not be found
	 */
	@Override
	public Expression findByRuleId_Last(
			long ruleId, OrderByComparator<Expression> orderByComparator)
		throws NoSuchExpressionException {

		Expression expression = fetchByRuleId_Last(ruleId, orderByComparator);

		if (expression != null) {
			return expression;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append("}");

		throw new NoSuchExpressionException(msg.toString());
	}

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression, or <code>null</code> if a matching expression could not be found
	 */
	@Override
	public Expression fetchByRuleId_Last(
		long ruleId, OrderByComparator<Expression> orderByComparator) {

		int count = countByRuleId(ruleId);

		if (count == 0) {
			return null;
		}

		List<Expression> list = findByRuleId(
			ruleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Expression[] findByRuleId_PrevAndNext(
			long expressionId, long ruleId,
			OrderByComparator<Expression> orderByComparator)
		throws NoSuchExpressionException {

		Expression expression = findByPrimaryKey(expressionId);

		Session session = null;

		try {
			session = openSession();

			Expression[] array = new ExpressionImpl[3];

			array[0] = getByRuleId_PrevAndNext(
				session, expression, ruleId, orderByComparator, true);

			array[1] = expression;

			array[2] = getByRuleId_PrevAndNext(
				session, expression, ruleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Expression getByRuleId_PrevAndNext(
		Session session, Expression expression, long ruleId,
		OrderByComparator<Expression> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EXPRESSION_WHERE);

		query.append(_FINDER_COLUMN_RULEID_RULEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ExpressionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ruleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(expression)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Expression> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expressions where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 */
	@Override
	public void removeByRuleId(long ruleId) {
		for (Expression expression :
				findByRuleId(
					ruleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(expression);
		}
	}

	/**
	 * Returns the number of expressions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching expressions
	 */
	@Override
	public int countByRuleId(long ruleId) {
		FinderPath finderPath = _finderPathCountByRuleId;

		Object[] finderArgs = new Object[] {ruleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EXPRESSION_WHERE);

			query.append(_FINDER_COLUMN_RULEID_RULEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_RULEID_RULEID_2 =
		"expression.ruleId = ?";

	private FinderPath _finderPathWithPaginationFindByR_T;
	private FinderPath _finderPathWithoutPaginationFindByR_T;
	private FinderPath _finderPathCountByR_T;

	/**
	 * Returns all the expressions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the matching expressions
	 */
	@Override
	public List<Expression> findByR_T(long ruleId, String type) {
		return findByR_T(
			ruleId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Expression> findByR_T(
		long ruleId, String type, int start, int end) {

		return findByR_T(ruleId, type, start, end, null);
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
	@Override
	public List<Expression> findByR_T(
		long ruleId, String type, int start, int end,
		OrderByComparator<Expression> orderByComparator) {

		return findByR_T(ruleId, type, start, end, orderByComparator, true);
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
	@Override
	public List<Expression> findByR_T(
		long ruleId, String type, int start, int end,
		OrderByComparator<Expression> orderByComparator,
		boolean retrieveFromCache) {

		type = Objects.toString(type, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByR_T;
			finderArgs = new Object[] {ruleId, type};
		}
		else {
			finderPath = _finderPathWithPaginationFindByR_T;
			finderArgs = new Object[] {
				ruleId, type, start, end, orderByComparator
			};
		}

		List<Expression> list = null;

		if (retrieveFromCache) {
			list = (List<Expression>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Expression expression : list) {
					if ((ruleId != expression.getRuleId()) ||
						!type.equals(expression.getType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_EXPRESSION_WHERE);

			query.append(_FINDER_COLUMN_R_T_RULEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_R_T_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_R_T_TYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ExpressionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				if (bindType) {
					qPos.add(type);
				}

				if (!pagination) {
					list = (List<Expression>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Expression>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Expression findByR_T_First(
			long ruleId, String type,
			OrderByComparator<Expression> orderByComparator)
		throws NoSuchExpressionException {

		Expression expression = fetchByR_T_First(
			ruleId, type, orderByComparator);

		if (expression != null) {
			return expression;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchExpressionException(msg.toString());
	}

	/**
	 * Returns the first expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching expression, or <code>null</code> if a matching expression could not be found
	 */
	@Override
	public Expression fetchByR_T_First(
		long ruleId, String type,
		OrderByComparator<Expression> orderByComparator) {

		List<Expression> list = findByR_T(
			ruleId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Expression findByR_T_Last(
			long ruleId, String type,
			OrderByComparator<Expression> orderByComparator)
		throws NoSuchExpressionException {

		Expression expression = fetchByR_T_Last(
			ruleId, type, orderByComparator);

		if (expression != null) {
			return expression;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchExpressionException(msg.toString());
	}

	/**
	 * Returns the last expression in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching expression, or <code>null</code> if a matching expression could not be found
	 */
	@Override
	public Expression fetchByR_T_Last(
		long ruleId, String type,
		OrderByComparator<Expression> orderByComparator) {

		int count = countByR_T(ruleId, type);

		if (count == 0) {
			return null;
		}

		List<Expression> list = findByR_T(
			ruleId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Expression[] findByR_T_PrevAndNext(
			long expressionId, long ruleId, String type,
			OrderByComparator<Expression> orderByComparator)
		throws NoSuchExpressionException {

		type = Objects.toString(type, "");

		Expression expression = findByPrimaryKey(expressionId);

		Session session = null;

		try {
			session = openSession();

			Expression[] array = new ExpressionImpl[3];

			array[0] = getByR_T_PrevAndNext(
				session, expression, ruleId, type, orderByComparator, true);

			array[1] = expression;

			array[2] = getByR_T_PrevAndNext(
				session, expression, ruleId, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Expression getByR_T_PrevAndNext(
		Session session, Expression expression, long ruleId, String type,
		OrderByComparator<Expression> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EXPRESSION_WHERE);

		query.append(_FINDER_COLUMN_R_T_RULEID_2);

		boolean bindType = false;

		if (type.isEmpty()) {
			query.append(_FINDER_COLUMN_R_T_TYPE_3);
		}
		else {
			bindType = true;

			query.append(_FINDER_COLUMN_R_T_TYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ExpressionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ruleId);

		if (bindType) {
			qPos.add(type);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(expression)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Expression> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the expressions where ruleId = &#63; and type = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 */
	@Override
	public void removeByR_T(long ruleId, String type) {
		for (Expression expression :
				findByR_T(
					ruleId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(expression);
		}
	}

	/**
	 * Returns the number of expressions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the number of matching expressions
	 */
	@Override
	public int countByR_T(long ruleId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByR_T;

		Object[] finderArgs = new Object[] {ruleId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EXPRESSION_WHERE);

			query.append(_FINDER_COLUMN_R_T_RULEID_2);

			boolean bindType = false;

			if (type.isEmpty()) {
				query.append(_FINDER_COLUMN_R_T_TYPE_3);
			}
			else {
				bindType = true;

				query.append(_FINDER_COLUMN_R_T_TYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				if (bindType) {
					qPos.add(type);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_R_T_RULEID_2 =
		"expression.ruleId = ? AND ";

	private static final String _FINDER_COLUMN_R_T_TYPE_2 =
		"expression.type = ?";

	private static final String _FINDER_COLUMN_R_T_TYPE_3 =
		"(expression.type IS NULL OR expression.type = '')";

	public ExpressionPersistenceImpl() {
		setModelClass(Expression.class);

		setModelImplClass(ExpressionImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the expression in the entity cache if it is enabled.
	 *
	 * @param expression the expression
	 */
	@Override
	public void cacheResult(Expression expression) {
		entityCache.putResult(
			entityCacheEnabled, ExpressionImpl.class,
			expression.getPrimaryKey(), expression);

		expression.resetOriginalValues();
	}

	/**
	 * Caches the expressions in the entity cache if it is enabled.
	 *
	 * @param expressions the expressions
	 */
	@Override
	public void cacheResult(List<Expression> expressions) {
		for (Expression expression : expressions) {
			if (entityCache.getResult(
					entityCacheEnabled, ExpressionImpl.class,
					expression.getPrimaryKey()) == null) {

				cacheResult(expression);
			}
			else {
				expression.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all expressions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExpressionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the expression.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Expression expression) {
		entityCache.removeResult(
			entityCacheEnabled, ExpressionImpl.class,
			expression.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Expression> expressions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Expression expression : expressions) {
			entityCache.removeResult(
				entityCacheEnabled, ExpressionImpl.class,
				expression.getPrimaryKey());
		}
	}

	/**
	 * Creates a new expression with the primary key. Does not add the expression to the database.
	 *
	 * @param expressionId the primary key for the new expression
	 * @return the new expression
	 */
	@Override
	public Expression create(long expressionId) {
		Expression expression = new ExpressionImpl();

		expression.setNew(true);
		expression.setPrimaryKey(expressionId);

		return expression;
	}

	/**
	 * Removes the expression with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression that was removed
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	@Override
	public Expression remove(long expressionId)
		throws NoSuchExpressionException {

		return remove((Serializable)expressionId);
	}

	/**
	 * Removes the expression with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the expression
	 * @return the expression that was removed
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	@Override
	public Expression remove(Serializable primaryKey)
		throws NoSuchExpressionException {

		Session session = null;

		try {
			session = openSession();

			Expression expression = (Expression)session.get(
				ExpressionImpl.class, primaryKey);

			if (expression == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchExpressionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(expression);
		}
		catch (NoSuchExpressionException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Expression removeImpl(Expression expression) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(expression)) {
				expression = (Expression)session.get(
					ExpressionImpl.class, expression.getPrimaryKeyObj());
			}

			if (expression != null) {
				session.delete(expression);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (expression != null) {
			clearCache(expression);
		}

		return expression;
	}

	@Override
	public Expression updateImpl(Expression expression) {
		boolean isNew = expression.isNew();

		if (!(expression instanceof ExpressionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(expression.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(expression);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in expression proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Expression implementation " +
					expression.getClass());
		}

		ExpressionModelImpl expressionModelImpl =
			(ExpressionModelImpl)expression;

		Session session = null;

		try {
			session = openSession();

			if (expression.isNew()) {
				session.save(expression);

				expression.setNew(false);
			}
			else {
				expression = (Expression)session.merge(expression);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {expressionModelImpl.getRuleId()};

			finderCache.removeResult(_finderPathCountByRuleId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRuleId, args);

			args = new Object[] {
				expressionModelImpl.getRuleId(), expressionModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByR_T, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByR_T, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((expressionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRuleId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					expressionModelImpl.getOriginalRuleId()
				};

				finderCache.removeResult(_finderPathCountByRuleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRuleId, args);

				args = new Object[] {expressionModelImpl.getRuleId()};

				finderCache.removeResult(_finderPathCountByRuleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRuleId, args);
			}

			if ((expressionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByR_T.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					expressionModelImpl.getOriginalRuleId(),
					expressionModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByR_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByR_T, args);

				args = new Object[] {
					expressionModelImpl.getRuleId(),
					expressionModelImpl.getType()
				};

				finderCache.removeResult(_finderPathCountByR_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByR_T, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ExpressionImpl.class,
			expression.getPrimaryKey(), expression, false);

		expression.resetOriginalValues();

		return expression;
	}

	/**
	 * Returns the expression with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the expression
	 * @return the expression
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	@Override
	public Expression findByPrimaryKey(Serializable primaryKey)
		throws NoSuchExpressionException {

		Expression expression = fetchByPrimaryKey(primaryKey);

		if (expression == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchExpressionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return expression;
	}

	/**
	 * Returns the expression with the primary key or throws a <code>NoSuchExpressionException</code> if it could not be found.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression
	 * @throws NoSuchExpressionException if a expression with the primary key could not be found
	 */
	@Override
	public Expression findByPrimaryKey(long expressionId)
		throws NoSuchExpressionException {

		return findByPrimaryKey((Serializable)expressionId);
	}

	/**
	 * Returns the expression with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param expressionId the primary key of the expression
	 * @return the expression, or <code>null</code> if a expression with the primary key could not be found
	 */
	@Override
	public Expression fetchByPrimaryKey(long expressionId) {
		return fetchByPrimaryKey((Serializable)expressionId);
	}

	/**
	 * Returns all the expressions.
	 *
	 * @return the expressions
	 */
	@Override
	public List<Expression> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Expression> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Expression> findAll(
		int start, int end, OrderByComparator<Expression> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Expression> findAll(
		int start, int end, OrderByComparator<Expression> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Expression> list = null;

		if (retrieveFromCache) {
			list = (List<Expression>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EXPRESSION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EXPRESSION;

				if (pagination) {
					sql = sql.concat(ExpressionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Expression>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Expression>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the expressions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Expression expression : findAll()) {
			remove(expression);
		}
	}

	/**
	 * Returns the number of expressions.
	 *
	 * @return the number of expressions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EXPRESSION);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "expressionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXPRESSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExpressionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the expression persistence.
	 */
	@Activate
	public void activate() {
		ExpressionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ExpressionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExpressionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExpressionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExpressionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRuleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExpressionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuleId",
			new String[] {Long.class.getName()},
			ExpressionModelImpl.RULEID_COLUMN_BITMASK);

		_finderPathCountByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByR_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExpressionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByR_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ExpressionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_T",
			new String[] {Long.class.getName(), String.class.getName()},
			ExpressionModelImpl.RULEID_COLUMN_BITMASK |
			ExpressionModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByR_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_T",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ExpressionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = YithroPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.yithro.rules.model.Expression"),
			true);
	}

	@Override
	@Reference(
		target = YithroPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = YithroPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EXPRESSION =
		"SELECT expression FROM Expression expression";

	private static final String _SQL_SELECT_EXPRESSION_WHERE =
		"SELECT expression FROM Expression expression WHERE ";

	private static final String _SQL_COUNT_EXPRESSION =
		"SELECT COUNT(expression) FROM Expression expression";

	private static final String _SQL_COUNT_EXPRESSION_WHERE =
		"SELECT COUNT(expression) FROM Expression expression WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "expression.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Expression exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Expression exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ExpressionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

}