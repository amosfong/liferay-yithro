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
import com.liferay.yithro.rules.exception.NoSuchRuleConditionException;
import com.liferay.yithro.rules.model.RuleCondition;
import com.liferay.yithro.rules.model.impl.RuleConditionImpl;
import com.liferay.yithro.rules.model.impl.RuleConditionModelImpl;
import com.liferay.yithro.rules.service.persistence.RuleConditionPersistence;
import com.liferay.yithro.rules.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the rule condition service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RuleConditionPersistence.class)
public class RuleConditionPersistenceImpl
	extends BasePersistenceImpl<RuleCondition>
	implements RuleConditionPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RuleConditionUtil</code> to access the rule condition persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RuleConditionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByR_T;
	private FinderPath _finderPathWithoutPaginationFindByR_T;
	private FinderPath _finderPathCountByR_T;

	/**
	 * Returns all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the matching rule conditions
	 */
	@Override
	public List<RuleCondition> findByR_T(long ruleId, String type) {
		return findByR_T(
			ruleId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @return the range of matching rule conditions
	 */
	@Override
	public List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end) {

		return findByR_T(ruleId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule conditions
	 */
	@Override
	public List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end,
		OrderByComparator<RuleCondition> orderByComparator) {

		return findByR_T(ruleId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rule conditions
	 */
	@Override
	public List<RuleCondition> findByR_T(
		long ruleId, String type, int start, int end,
		OrderByComparator<RuleCondition> orderByComparator,
		boolean useFinderCache) {

		type = Objects.toString(type, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByR_T;
				finderArgs = new Object[] {ruleId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByR_T;
			finderArgs = new Object[] {
				ruleId, type, start, end, orderByComparator
			};
		}

		List<RuleCondition> list = null;

		if (useFinderCache) {
			list = (List<RuleCondition>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RuleCondition ruleCondition : list) {
					if ((ruleId != ruleCondition.getRuleId()) ||
						!type.equals(ruleCondition.getType())) {

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

			query.append(_SQL_SELECT_RULECONDITION_WHERE);

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
			else {
				query.append(RuleConditionModelImpl.ORDER_BY_JPQL);
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

				list = (List<RuleCondition>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule condition
	 * @throws NoSuchRuleConditionException if a matching rule condition could not be found
	 */
	@Override
	public RuleCondition findByR_T_First(
			long ruleId, String type,
			OrderByComparator<RuleCondition> orderByComparator)
		throws NoSuchRuleConditionException {

		RuleCondition ruleCondition = fetchByR_T_First(
			ruleId, type, orderByComparator);

		if (ruleCondition != null) {
			return ruleCondition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchRuleConditionException(msg.toString());
	}

	/**
	 * Returns the first rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule condition, or <code>null</code> if a matching rule condition could not be found
	 */
	@Override
	public RuleCondition fetchByR_T_First(
		long ruleId, String type,
		OrderByComparator<RuleCondition> orderByComparator) {

		List<RuleCondition> list = findByR_T(
			ruleId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule condition
	 * @throws NoSuchRuleConditionException if a matching rule condition could not be found
	 */
	@Override
	public RuleCondition findByR_T_Last(
			long ruleId, String type,
			OrderByComparator<RuleCondition> orderByComparator)
		throws NoSuchRuleConditionException {

		RuleCondition ruleCondition = fetchByR_T_Last(
			ruleId, type, orderByComparator);

		if (ruleCondition != null) {
			return ruleCondition;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchRuleConditionException(msg.toString());
	}

	/**
	 * Returns the last rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule condition, or <code>null</code> if a matching rule condition could not be found
	 */
	@Override
	public RuleCondition fetchByR_T_Last(
		long ruleId, String type,
		OrderByComparator<RuleCondition> orderByComparator) {

		int count = countByR_T(ruleId, type);

		if (count == 0) {
			return null;
		}

		List<RuleCondition> list = findByR_T(
			ruleId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rule conditions before and after the current rule condition in the ordered set where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleConditionId the primary key of the current rule condition
	 * @param ruleId the rule ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule condition
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	@Override
	public RuleCondition[] findByR_T_PrevAndNext(
			long ruleConditionId, long ruleId, String type,
			OrderByComparator<RuleCondition> orderByComparator)
		throws NoSuchRuleConditionException {

		type = Objects.toString(type, "");

		RuleCondition ruleCondition = findByPrimaryKey(ruleConditionId);

		Session session = null;

		try {
			session = openSession();

			RuleCondition[] array = new RuleConditionImpl[3];

			array[0] = getByR_T_PrevAndNext(
				session, ruleCondition, ruleId, type, orderByComparator, true);

			array[1] = ruleCondition;

			array[2] = getByR_T_PrevAndNext(
				session, ruleCondition, ruleId, type, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RuleCondition getByR_T_PrevAndNext(
		Session session, RuleCondition ruleCondition, long ruleId, String type,
		OrderByComparator<RuleCondition> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RULECONDITION_WHERE);

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
			query.append(RuleConditionModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						ruleCondition)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RuleCondition> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule conditions where ruleId = &#63; and type = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 */
	@Override
	public void removeByR_T(long ruleId, String type) {
		for (RuleCondition ruleCondition :
				findByR_T(
					ruleId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ruleCondition);
		}
	}

	/**
	 * Returns the number of rule conditions where ruleId = &#63; and type = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param type the type
	 * @return the number of matching rule conditions
	 */
	@Override
	public int countByR_T(long ruleId, String type) {
		type = Objects.toString(type, "");

		FinderPath finderPath = _finderPathCountByR_T;

		Object[] finderArgs = new Object[] {ruleId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RULECONDITION_WHERE);

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
		"ruleCondition.ruleId = ? AND ";

	private static final String _FINDER_COLUMN_R_T_TYPE_2 =
		"ruleCondition.type = ?";

	private static final String _FINDER_COLUMN_R_T_TYPE_3 =
		"(ruleCondition.type IS NULL OR ruleCondition.type = '')";

	public RuleConditionPersistenceImpl() {
		setModelClass(RuleCondition.class);

		setModelImplClass(RuleConditionImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the rule condition in the entity cache if it is enabled.
	 *
	 * @param ruleCondition the rule condition
	 */
	@Override
	public void cacheResult(RuleCondition ruleCondition) {
		entityCache.putResult(
			entityCacheEnabled, RuleConditionImpl.class,
			ruleCondition.getPrimaryKey(), ruleCondition);

		ruleCondition.resetOriginalValues();
	}

	/**
	 * Caches the rule conditions in the entity cache if it is enabled.
	 *
	 * @param ruleConditions the rule conditions
	 */
	@Override
	public void cacheResult(List<RuleCondition> ruleConditions) {
		for (RuleCondition ruleCondition : ruleConditions) {
			if (entityCache.getResult(
					entityCacheEnabled, RuleConditionImpl.class,
					ruleCondition.getPrimaryKey()) == null) {

				cacheResult(ruleCondition);
			}
			else {
				ruleCondition.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rule conditions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RuleConditionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rule condition.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RuleCondition ruleCondition) {
		entityCache.removeResult(
			entityCacheEnabled, RuleConditionImpl.class,
			ruleCondition.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RuleCondition> ruleConditions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RuleCondition ruleCondition : ruleConditions) {
			entityCache.removeResult(
				entityCacheEnabled, RuleConditionImpl.class,
				ruleCondition.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, RuleConditionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rule condition with the primary key. Does not add the rule condition to the database.
	 *
	 * @param ruleConditionId the primary key for the new rule condition
	 * @return the new rule condition
	 */
	@Override
	public RuleCondition create(long ruleConditionId) {
		RuleCondition ruleCondition = new RuleConditionImpl();

		ruleCondition.setNew(true);
		ruleCondition.setPrimaryKey(ruleConditionId);

		return ruleCondition;
	}

	/**
	 * Removes the rule condition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition that was removed
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	@Override
	public RuleCondition remove(long ruleConditionId)
		throws NoSuchRuleConditionException {

		return remove((Serializable)ruleConditionId);
	}

	/**
	 * Removes the rule condition with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule condition
	 * @return the rule condition that was removed
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	@Override
	public RuleCondition remove(Serializable primaryKey)
		throws NoSuchRuleConditionException {

		Session session = null;

		try {
			session = openSession();

			RuleCondition ruleCondition = (RuleCondition)session.get(
				RuleConditionImpl.class, primaryKey);

			if (ruleCondition == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRuleConditionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ruleCondition);
		}
		catch (NoSuchRuleConditionException nsee) {
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
	protected RuleCondition removeImpl(RuleCondition ruleCondition) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ruleCondition)) {
				ruleCondition = (RuleCondition)session.get(
					RuleConditionImpl.class, ruleCondition.getPrimaryKeyObj());
			}

			if (ruleCondition != null) {
				session.delete(ruleCondition);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ruleCondition != null) {
			clearCache(ruleCondition);
		}

		return ruleCondition;
	}

	@Override
	public RuleCondition updateImpl(RuleCondition ruleCondition) {
		boolean isNew = ruleCondition.isNew();

		if (!(ruleCondition instanceof RuleConditionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ruleCondition.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ruleCondition);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ruleCondition proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RuleCondition implementation " +
					ruleCondition.getClass());
		}

		RuleConditionModelImpl ruleConditionModelImpl =
			(RuleConditionModelImpl)ruleCondition;

		Session session = null;

		try {
			session = openSession();

			if (ruleCondition.isNew()) {
				session.save(ruleCondition);

				ruleCondition.setNew(false);
			}
			else {
				ruleCondition = (RuleCondition)session.merge(ruleCondition);
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
			Object[] args = new Object[] {
				ruleConditionModelImpl.getRuleId(),
				ruleConditionModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByR_T, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByR_T, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ruleConditionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByR_T.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ruleConditionModelImpl.getOriginalRuleId(),
					ruleConditionModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByR_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByR_T, args);

				args = new Object[] {
					ruleConditionModelImpl.getRuleId(),
					ruleConditionModelImpl.getType()
				};

				finderCache.removeResult(_finderPathCountByR_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByR_T, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, RuleConditionImpl.class,
			ruleCondition.getPrimaryKey(), ruleCondition, false);

		ruleCondition.resetOriginalValues();

		return ruleCondition;
	}

	/**
	 * Returns the rule condition with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule condition
	 * @return the rule condition
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	@Override
	public RuleCondition findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuleConditionException {

		RuleCondition ruleCondition = fetchByPrimaryKey(primaryKey);

		if (ruleCondition == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRuleConditionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ruleCondition;
	}

	/**
	 * Returns the rule condition with the primary key or throws a <code>NoSuchRuleConditionException</code> if it could not be found.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition
	 * @throws NoSuchRuleConditionException if a rule condition with the primary key could not be found
	 */
	@Override
	public RuleCondition findByPrimaryKey(long ruleConditionId)
		throws NoSuchRuleConditionException {

		return findByPrimaryKey((Serializable)ruleConditionId);
	}

	/**
	 * Returns the rule condition with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleConditionId the primary key of the rule condition
	 * @return the rule condition, or <code>null</code> if a rule condition with the primary key could not be found
	 */
	@Override
	public RuleCondition fetchByPrimaryKey(long ruleConditionId) {
		return fetchByPrimaryKey((Serializable)ruleConditionId);
	}

	/**
	 * Returns all the rule conditions.
	 *
	 * @return the rule conditions
	 */
	@Override
	public List<RuleCondition> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule conditions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @return the range of rule conditions
	 */
	@Override
	public List<RuleCondition> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule conditions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rule conditions
	 */
	@Override
	public List<RuleCondition> findAll(
		int start, int end,
		OrderByComparator<RuleCondition> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rule conditions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleConditionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule conditions
	 * @param end the upper bound of the range of rule conditions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rule conditions
	 */
	@Override
	public List<RuleCondition> findAll(
		int start, int end, OrderByComparator<RuleCondition> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<RuleCondition> list = null;

		if (useFinderCache) {
			list = (List<RuleCondition>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RULECONDITION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RULECONDITION;

				sql = sql.concat(RuleConditionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<RuleCondition>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the rule conditions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RuleCondition ruleCondition : findAll()) {
			remove(ruleCondition);
		}
	}

	/**
	 * Returns the number of rule conditions.
	 *
	 * @return the number of rule conditions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RULECONDITION);

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
		return "ruleConditionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RULECONDITION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RuleConditionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rule condition persistence.
	 */
	@Activate
	public void activate() {
		RuleConditionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		RuleConditionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleConditionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleConditionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByR_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleConditionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByR_T",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByR_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleConditionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_T",
			new String[] {Long.class.getName(), String.class.getName()},
			RuleConditionModelImpl.RULEID_COLUMN_BITMASK |
			RuleConditionModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByR_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_T",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(RuleConditionImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = YithroPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.liferay.yithro.rules.model.RuleCondition"),
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

	private static final String _SQL_SELECT_RULECONDITION =
		"SELECT ruleCondition FROM RuleCondition ruleCondition";

	private static final String _SQL_SELECT_RULECONDITION_WHERE =
		"SELECT ruleCondition FROM RuleCondition ruleCondition WHERE ";

	private static final String _SQL_COUNT_RULECONDITION =
		"SELECT COUNT(ruleCondition) FROM RuleCondition ruleCondition";

	private static final String _SQL_COUNT_RULECONDITION_WHERE =
		"SELECT COUNT(ruleCondition) FROM RuleCondition ruleCondition WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ruleCondition.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RuleCondition exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RuleCondition exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RuleConditionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}