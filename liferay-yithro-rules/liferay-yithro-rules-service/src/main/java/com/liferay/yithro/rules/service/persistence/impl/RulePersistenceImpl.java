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
import com.liferay.yithro.rules.exception.NoSuchRuleException;
import com.liferay.yithro.rules.model.Rule;
import com.liferay.yithro.rules.model.impl.RuleImpl;
import com.liferay.yithro.rules.model.impl.RuleModelImpl;
import com.liferay.yithro.rules.service.persistence.RulePersistence;
import com.liferay.yithro.rules.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RulePersistence.class)
public class RulePersistenceImpl
	extends BasePersistenceImpl<Rule> implements RulePersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RuleUtil</code> to access the rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RuleImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByON_OE;
	private FinderPath _finderPathWithoutPaginationFindByON_OE;
	private FinderPath _finderPathCountByON_OE;

	/**
	 * Returns all the rules where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @return the matching rules
	 */
	@Override
	public List<Rule> findByON_OE(String objectName, String objectEvent) {
		return findByON_OE(
			objectName, objectEvent, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Rule> findByON_OE(
		String objectName, String objectEvent, int start, int end) {

		return findByON_OE(objectName, objectEvent, start, end, null);
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
	@Override
	public List<Rule> findByON_OE(
		String objectName, String objectEvent, int start, int end,
		OrderByComparator<Rule> orderByComparator) {

		return findByON_OE(
			objectName, objectEvent, start, end, orderByComparator, true);
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
	@Override
	public List<Rule> findByON_OE(
		String objectName, String objectEvent, int start, int end,
		OrderByComparator<Rule> orderByComparator, boolean useFinderCache) {

		objectName = Objects.toString(objectName, "");
		objectEvent = Objects.toString(objectEvent, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByON_OE;
				finderArgs = new Object[] {objectName, objectEvent};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByON_OE;
			finderArgs = new Object[] {
				objectName, objectEvent, start, end, orderByComparator
			};
		}

		List<Rule> list = null;

		if (useFinderCache) {
			list = (List<Rule>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Rule rule : list) {
					if (!objectName.equals(rule.getObjectName()) ||
						!objectEvent.equals(rule.getObjectEvent())) {

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

			query.append(_SQL_SELECT_RULE_WHERE);

			boolean bindObjectName = false;

			if (objectName.isEmpty()) {
				query.append(_FINDER_COLUMN_ON_OE_OBJECTNAME_3);
			}
			else {
				bindObjectName = true;

				query.append(_FINDER_COLUMN_ON_OE_OBJECTNAME_2);
			}

			boolean bindObjectEvent = false;

			if (objectEvent.isEmpty()) {
				query.append(_FINDER_COLUMN_ON_OE_OBJECTEVENT_3);
			}
			else {
				bindObjectEvent = true;

				query.append(_FINDER_COLUMN_ON_OE_OBJECTEVENT_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(RuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectName) {
					qPos.add(objectName);
				}

				if (bindObjectEvent) {
					qPos.add(objectEvent);
				}

				list = (List<Rule>)QueryUtil.list(q, getDialect(), start, end);

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
	 * Returns the first rule in the ordered set where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule
	 * @throws NoSuchRuleException if a matching rule could not be found
	 */
	@Override
	public Rule findByON_OE_First(
			String objectName, String objectEvent,
			OrderByComparator<Rule> orderByComparator)
		throws NoSuchRuleException {

		Rule rule = fetchByON_OE_First(
			objectName, objectEvent, orderByComparator);

		if (rule != null) {
			return rule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectName=");
		msg.append(objectName);

		msg.append(", objectEvent=");
		msg.append(objectEvent);

		msg.append("}");

		throw new NoSuchRuleException(msg.toString());
	}

	/**
	 * Returns the first rule in the ordered set where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule, or <code>null</code> if a matching rule could not be found
	 */
	@Override
	public Rule fetchByON_OE_First(
		String objectName, String objectEvent,
		OrderByComparator<Rule> orderByComparator) {

		List<Rule> list = findByON_OE(
			objectName, objectEvent, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Rule findByON_OE_Last(
			String objectName, String objectEvent,
			OrderByComparator<Rule> orderByComparator)
		throws NoSuchRuleException {

		Rule rule = fetchByON_OE_Last(
			objectName, objectEvent, orderByComparator);

		if (rule != null) {
			return rule;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("objectName=");
		msg.append(objectName);

		msg.append(", objectEvent=");
		msg.append(objectEvent);

		msg.append("}");

		throw new NoSuchRuleException(msg.toString());
	}

	/**
	 * Returns the last rule in the ordered set where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule, or <code>null</code> if a matching rule could not be found
	 */
	@Override
	public Rule fetchByON_OE_Last(
		String objectName, String objectEvent,
		OrderByComparator<Rule> orderByComparator) {

		int count = countByON_OE(objectName, objectEvent);

		if (count == 0) {
			return null;
		}

		List<Rule> list = findByON_OE(
			objectName, objectEvent, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Rule[] findByON_OE_PrevAndNext(
			long ruleId, String objectName, String objectEvent,
			OrderByComparator<Rule> orderByComparator)
		throws NoSuchRuleException {

		objectName = Objects.toString(objectName, "");
		objectEvent = Objects.toString(objectEvent, "");

		Rule rule = findByPrimaryKey(ruleId);

		Session session = null;

		try {
			session = openSession();

			Rule[] array = new RuleImpl[3];

			array[0] = getByON_OE_PrevAndNext(
				session, rule, objectName, objectEvent, orderByComparator,
				true);

			array[1] = rule;

			array[2] = getByON_OE_PrevAndNext(
				session, rule, objectName, objectEvent, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Rule getByON_OE_PrevAndNext(
		Session session, Rule rule, String objectName, String objectEvent,
		OrderByComparator<Rule> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_RULE_WHERE);

		boolean bindObjectName = false;

		if (objectName.isEmpty()) {
			query.append(_FINDER_COLUMN_ON_OE_OBJECTNAME_3);
		}
		else {
			bindObjectName = true;

			query.append(_FINDER_COLUMN_ON_OE_OBJECTNAME_2);
		}

		boolean bindObjectEvent = false;

		if (objectEvent.isEmpty()) {
			query.append(_FINDER_COLUMN_ON_OE_OBJECTEVENT_3);
		}
		else {
			bindObjectEvent = true;

			query.append(_FINDER_COLUMN_ON_OE_OBJECTEVENT_2);
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
			query.append(RuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindObjectName) {
			qPos.add(objectName);
		}

		if (bindObjectEvent) {
			qPos.add(objectEvent);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(rule)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Rule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rules where objectName = &#63; and objectEvent = &#63; from the database.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 */
	@Override
	public void removeByON_OE(String objectName, String objectEvent) {
		for (Rule rule :
				findByON_OE(
					objectName, objectEvent, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(rule);
		}
	}

	/**
	 * Returns the number of rules where objectName = &#63; and objectEvent = &#63;.
	 *
	 * @param objectName the object name
	 * @param objectEvent the object event
	 * @return the number of matching rules
	 */
	@Override
	public int countByON_OE(String objectName, String objectEvent) {
		objectName = Objects.toString(objectName, "");
		objectEvent = Objects.toString(objectEvent, "");

		FinderPath finderPath = _finderPathCountByON_OE;

		Object[] finderArgs = new Object[] {objectName, objectEvent};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_RULE_WHERE);

			boolean bindObjectName = false;

			if (objectName.isEmpty()) {
				query.append(_FINDER_COLUMN_ON_OE_OBJECTNAME_3);
			}
			else {
				bindObjectName = true;

				query.append(_FINDER_COLUMN_ON_OE_OBJECTNAME_2);
			}

			boolean bindObjectEvent = false;

			if (objectEvent.isEmpty()) {
				query.append(_FINDER_COLUMN_ON_OE_OBJECTEVENT_3);
			}
			else {
				bindObjectEvent = true;

				query.append(_FINDER_COLUMN_ON_OE_OBJECTEVENT_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindObjectName) {
					qPos.add(objectName);
				}

				if (bindObjectEvent) {
					qPos.add(objectEvent);
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

	private static final String _FINDER_COLUMN_ON_OE_OBJECTNAME_2 =
		"rule.objectName = ? AND ";

	private static final String _FINDER_COLUMN_ON_OE_OBJECTNAME_3 =
		"(rule.objectName IS NULL OR rule.objectName = '') AND ";

	private static final String _FINDER_COLUMN_ON_OE_OBJECTEVENT_2 =
		"rule.objectEvent = ?";

	private static final String _FINDER_COLUMN_ON_OE_OBJECTEVENT_3 =
		"(rule.objectEvent IS NULL OR rule.objectEvent = '')";

	public RulePersistenceImpl() {
		setModelClass(Rule.class);

		setModelImplClass(RuleImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the rule in the entity cache if it is enabled.
	 *
	 * @param rule the rule
	 */
	@Override
	public void cacheResult(Rule rule) {
		entityCache.putResult(
			entityCacheEnabled, RuleImpl.class, rule.getPrimaryKey(), rule);

		rule.resetOriginalValues();
	}

	/**
	 * Caches the rules in the entity cache if it is enabled.
	 *
	 * @param rules the rules
	 */
	@Override
	public void cacheResult(List<Rule> rules) {
		for (Rule rule : rules) {
			if (entityCache.getResult(
					entityCacheEnabled, RuleImpl.class, rule.getPrimaryKey()) ==
						null) {

				cacheResult(rule);
			}
			else {
				rule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rules.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RuleImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rule.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Rule rule) {
		entityCache.removeResult(
			entityCacheEnabled, RuleImpl.class, rule.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Rule> rules) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Rule rule : rules) {
			entityCache.removeResult(
				entityCacheEnabled, RuleImpl.class, rule.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, RuleImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rule with the primary key. Does not add the rule to the database.
	 *
	 * @param ruleId the primary key for the new rule
	 * @return the new rule
	 */
	@Override
	public Rule create(long ruleId) {
		Rule rule = new RuleImpl();

		rule.setNew(true);
		rule.setPrimaryKey(ruleId);

		return rule;
	}

	/**
	 * Removes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule that was removed
	 * @throws NoSuchRuleException if a rule with the primary key could not be found
	 */
	@Override
	public Rule remove(long ruleId) throws NoSuchRuleException {
		return remove((Serializable)ruleId);
	}

	/**
	 * Removes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule
	 * @return the rule that was removed
	 * @throws NoSuchRuleException if a rule with the primary key could not be found
	 */
	@Override
	public Rule remove(Serializable primaryKey) throws NoSuchRuleException {
		Session session = null;

		try {
			session = openSession();

			Rule rule = (Rule)session.get(RuleImpl.class, primaryKey);

			if (rule == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRuleException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rule);
		}
		catch (NoSuchRuleException nsee) {
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
	protected Rule removeImpl(Rule rule) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rule)) {
				rule = (Rule)session.get(
					RuleImpl.class, rule.getPrimaryKeyObj());
			}

			if (rule != null) {
				session.delete(rule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rule != null) {
			clearCache(rule);
		}

		return rule;
	}

	@Override
	public Rule updateImpl(Rule rule) {
		boolean isNew = rule.isNew();

		if (!(rule instanceof RuleModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(rule.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(rule);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rule proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Rule implementation " +
					rule.getClass());
		}

		RuleModelImpl ruleModelImpl = (RuleModelImpl)rule;

		Session session = null;

		try {
			session = openSession();

			if (rule.isNew()) {
				session.save(rule);

				rule.setNew(false);
			}
			else {
				rule = (Rule)session.merge(rule);
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
				ruleModelImpl.getObjectName(), ruleModelImpl.getObjectEvent()
			};

			finderCache.removeResult(_finderPathCountByON_OE, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByON_OE, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ruleModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByON_OE.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ruleModelImpl.getOriginalObjectName(),
					ruleModelImpl.getOriginalObjectEvent()
				};

				finderCache.removeResult(_finderPathCountByON_OE, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByON_OE, args);

				args = new Object[] {
					ruleModelImpl.getObjectName(),
					ruleModelImpl.getObjectEvent()
				};

				finderCache.removeResult(_finderPathCountByON_OE, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByON_OE, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, RuleImpl.class, rule.getPrimaryKey(), rule,
			false);

		rule.resetOriginalValues();

		return rule;
	}

	/**
	 * Returns the rule with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule
	 * @return the rule
	 * @throws NoSuchRuleException if a rule with the primary key could not be found
	 */
	@Override
	public Rule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuleException {

		Rule rule = fetchByPrimaryKey(primaryKey);

		if (rule == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRuleException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rule;
	}

	/**
	 * Returns the rule with the primary key or throws a <code>NoSuchRuleException</code> if it could not be found.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule
	 * @throws NoSuchRuleException if a rule with the primary key could not be found
	 */
	@Override
	public Rule findByPrimaryKey(long ruleId) throws NoSuchRuleException {
		return findByPrimaryKey((Serializable)ruleId);
	}

	/**
	 * Returns the rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule, or <code>null</code> if a rule with the primary key could not be found
	 */
	@Override
	public Rule fetchByPrimaryKey(long ruleId) {
		return fetchByPrimaryKey((Serializable)ruleId);
	}

	/**
	 * Returns all the rules.
	 *
	 * @return the rules
	 */
	@Override
	public List<Rule> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Rule> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Rule> findAll(
		int start, int end, OrderByComparator<Rule> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Rule> findAll(
		int start, int end, OrderByComparator<Rule> orderByComparator,
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

		List<Rule> list = null;

		if (useFinderCache) {
			list = (List<Rule>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RULE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RULE;

				sql = sql.concat(RuleModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<Rule>)QueryUtil.list(q, getDialect(), start, end);

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
	 * Removes all the rules from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Rule rule : findAll()) {
			remove(rule);
		}
	}

	/**
	 * Returns the number of rules.
	 *
	 * @return the number of rules
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RULE);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ruleId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RULE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RuleModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rule persistence.
	 */
	@Activate
	public void activate() {
		RuleModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		RuleModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByON_OE = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByON_OE",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByON_OE = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByON_OE",
			new String[] {String.class.getName(), String.class.getName()},
			RuleModelImpl.OBJECTNAME_COLUMN_BITMASK |
			RuleModelImpl.OBJECTEVENT_COLUMN_BITMASK);

		_finderPathCountByON_OE = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByON_OE",
			new String[] {String.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(RuleImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.rules.model.Rule"),
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

	private static final String _SQL_SELECT_RULE = "SELECT rule FROM Rule rule";

	private static final String _SQL_SELECT_RULE_WHERE =
		"SELECT rule FROM Rule rule WHERE ";

	private static final String _SQL_COUNT_RULE =
		"SELECT COUNT(rule) FROM Rule rule";

	private static final String _SQL_COUNT_RULE_WHERE =
		"SELECT COUNT(rule) FROM Rule rule WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "rule.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Rule exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Rule exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RulePersistenceImpl.class);

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}