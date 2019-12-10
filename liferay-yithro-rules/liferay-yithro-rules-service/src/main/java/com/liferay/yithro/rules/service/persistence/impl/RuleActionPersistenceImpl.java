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
import com.liferay.yithro.rules.exception.NoSuchRuleActionException;
import com.liferay.yithro.rules.model.RuleAction;
import com.liferay.yithro.rules.model.impl.RuleActionImpl;
import com.liferay.yithro.rules.model.impl.RuleActionModelImpl;
import com.liferay.yithro.rules.service.persistence.RuleActionPersistence;
import com.liferay.yithro.rules.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the rule action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RuleActionPersistence.class)
public class RuleActionPersistenceImpl
	extends BasePersistenceImpl<RuleAction> implements RuleActionPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RuleActionUtil</code> to access the rule action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RuleActionImpl.class.getName();

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
	 * Returns all the rule actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching rule actions
	 */
	@Override
	public List<RuleAction> findByRuleId(long ruleId) {
		return findByRuleId(ruleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @return the range of matching rule actions
	 */
	@Override
	public List<RuleAction> findByRuleId(long ruleId, int start, int end) {
		return findByRuleId(ruleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule actions
	 */
	@Override
	public List<RuleAction> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<RuleAction> orderByComparator) {

		return findByRuleId(ruleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rule actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rule actions
	 */
	@Override
	public List<RuleAction> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<RuleAction> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRuleId;
				finderArgs = new Object[] {ruleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRuleId;
			finderArgs = new Object[] {ruleId, start, end, orderByComparator};
		}

		List<RuleAction> list = null;

		if (useFinderCache) {
			list = (List<RuleAction>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RuleAction ruleAction : list) {
					if (ruleId != ruleAction.getRuleId()) {
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

			query.append(_SQL_SELECT_RULEACTION_WHERE);

			query.append(_FINDER_COLUMN_RULEID_RULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(RuleActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				list = (List<RuleAction>)QueryUtil.list(
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
	 * Returns the first rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action
	 * @throws NoSuchRuleActionException if a matching rule action could not be found
	 */
	@Override
	public RuleAction findByRuleId_First(
			long ruleId, OrderByComparator<RuleAction> orderByComparator)
		throws NoSuchRuleActionException {

		RuleAction ruleAction = fetchByRuleId_First(ruleId, orderByComparator);

		if (ruleAction != null) {
			return ruleAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append("}");

		throw new NoSuchRuleActionException(msg.toString());
	}

	/**
	 * Returns the first rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action, or <code>null</code> if a matching rule action could not be found
	 */
	@Override
	public RuleAction fetchByRuleId_First(
		long ruleId, OrderByComparator<RuleAction> orderByComparator) {

		List<RuleAction> list = findByRuleId(ruleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action
	 * @throws NoSuchRuleActionException if a matching rule action could not be found
	 */
	@Override
	public RuleAction findByRuleId_Last(
			long ruleId, OrderByComparator<RuleAction> orderByComparator)
		throws NoSuchRuleActionException {

		RuleAction ruleAction = fetchByRuleId_Last(ruleId, orderByComparator);

		if (ruleAction != null) {
			return ruleAction;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append("}");

		throw new NoSuchRuleActionException(msg.toString());
	}

	/**
	 * Returns the last rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action, or <code>null</code> if a matching rule action could not be found
	 */
	@Override
	public RuleAction fetchByRuleId_Last(
		long ruleId, OrderByComparator<RuleAction> orderByComparator) {

		int count = countByRuleId(ruleId);

		if (count == 0) {
			return null;
		}

		List<RuleAction> list = findByRuleId(
			ruleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rule actions before and after the current rule action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleActionId the primary key of the current rule action
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule action
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	@Override
	public RuleAction[] findByRuleId_PrevAndNext(
			long ruleActionId, long ruleId,
			OrderByComparator<RuleAction> orderByComparator)
		throws NoSuchRuleActionException {

		RuleAction ruleAction = findByPrimaryKey(ruleActionId);

		Session session = null;

		try {
			session = openSession();

			RuleAction[] array = new RuleActionImpl[3];

			array[0] = getByRuleId_PrevAndNext(
				session, ruleAction, ruleId, orderByComparator, true);

			array[1] = ruleAction;

			array[2] = getByRuleId_PrevAndNext(
				session, ruleAction, ruleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected RuleAction getByRuleId_PrevAndNext(
		Session session, RuleAction ruleAction, long ruleId,
		OrderByComparator<RuleAction> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULEACTION_WHERE);

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
			query.append(RuleActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ruleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ruleAction)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RuleAction> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule actions where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 */
	@Override
	public void removeByRuleId(long ruleId) {
		for (RuleAction ruleAction :
				findByRuleId(
					ruleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ruleAction);
		}
	}

	/**
	 * Returns the number of rule actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching rule actions
	 */
	@Override
	public int countByRuleId(long ruleId) {
		FinderPath finderPath = _finderPathCountByRuleId;

		Object[] finderArgs = new Object[] {ruleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULEACTION_WHERE);

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
		"ruleAction.ruleId = ?";

	public RuleActionPersistenceImpl() {
		setModelClass(RuleAction.class);

		setModelImplClass(RuleActionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the rule action in the entity cache if it is enabled.
	 *
	 * @param ruleAction the rule action
	 */
	@Override
	public void cacheResult(RuleAction ruleAction) {
		entityCache.putResult(
			entityCacheEnabled, RuleActionImpl.class,
			ruleAction.getPrimaryKey(), ruleAction);

		ruleAction.resetOriginalValues();
	}

	/**
	 * Caches the rule actions in the entity cache if it is enabled.
	 *
	 * @param ruleActions the rule actions
	 */
	@Override
	public void cacheResult(List<RuleAction> ruleActions) {
		for (RuleAction ruleAction : ruleActions) {
			if (entityCache.getResult(
					entityCacheEnabled, RuleActionImpl.class,
					ruleAction.getPrimaryKey()) == null) {

				cacheResult(ruleAction);
			}
			else {
				ruleAction.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rule actions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RuleActionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rule action.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RuleAction ruleAction) {
		entityCache.removeResult(
			entityCacheEnabled, RuleActionImpl.class,
			ruleAction.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RuleAction> ruleActions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RuleAction ruleAction : ruleActions) {
			entityCache.removeResult(
				entityCacheEnabled, RuleActionImpl.class,
				ruleAction.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, RuleActionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rule action with the primary key. Does not add the rule action to the database.
	 *
	 * @param ruleActionId the primary key for the new rule action
	 * @return the new rule action
	 */
	@Override
	public RuleAction create(long ruleActionId) {
		RuleAction ruleAction = new RuleActionImpl();

		ruleAction.setNew(true);
		ruleAction.setPrimaryKey(ruleActionId);

		return ruleAction;
	}

	/**
	 * Removes the rule action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action that was removed
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	@Override
	public RuleAction remove(long ruleActionId)
		throws NoSuchRuleActionException {

		return remove((Serializable)ruleActionId);
	}

	/**
	 * Removes the rule action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule action
	 * @return the rule action that was removed
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	@Override
	public RuleAction remove(Serializable primaryKey)
		throws NoSuchRuleActionException {

		Session session = null;

		try {
			session = openSession();

			RuleAction ruleAction = (RuleAction)session.get(
				RuleActionImpl.class, primaryKey);

			if (ruleAction == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRuleActionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ruleAction);
		}
		catch (NoSuchRuleActionException nsee) {
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
	protected RuleAction removeImpl(RuleAction ruleAction) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ruleAction)) {
				ruleAction = (RuleAction)session.get(
					RuleActionImpl.class, ruleAction.getPrimaryKeyObj());
			}

			if (ruleAction != null) {
				session.delete(ruleAction);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ruleAction != null) {
			clearCache(ruleAction);
		}

		return ruleAction;
	}

	@Override
	public RuleAction updateImpl(RuleAction ruleAction) {
		boolean isNew = ruleAction.isNew();

		if (!(ruleAction instanceof RuleActionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ruleAction.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ruleAction);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ruleAction proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RuleAction implementation " +
					ruleAction.getClass());
		}

		RuleActionModelImpl ruleActionModelImpl =
			(RuleActionModelImpl)ruleAction;

		Session session = null;

		try {
			session = openSession();

			if (ruleAction.isNew()) {
				session.save(ruleAction);

				ruleAction.setNew(false);
			}
			else {
				ruleAction = (RuleAction)session.merge(ruleAction);
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
			Object[] args = new Object[] {ruleActionModelImpl.getRuleId()};

			finderCache.removeResult(_finderPathCountByRuleId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRuleId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ruleActionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRuleId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ruleActionModelImpl.getOriginalRuleId()
				};

				finderCache.removeResult(_finderPathCountByRuleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRuleId, args);

				args = new Object[] {ruleActionModelImpl.getRuleId()};

				finderCache.removeResult(_finderPathCountByRuleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRuleId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, RuleActionImpl.class,
			ruleAction.getPrimaryKey(), ruleAction, false);

		ruleAction.resetOriginalValues();

		return ruleAction;
	}

	/**
	 * Returns the rule action with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule action
	 * @return the rule action
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	@Override
	public RuleAction findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuleActionException {

		RuleAction ruleAction = fetchByPrimaryKey(primaryKey);

		if (ruleAction == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRuleActionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ruleAction;
	}

	/**
	 * Returns the rule action with the primary key or throws a <code>NoSuchRuleActionException</code> if it could not be found.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action
	 * @throws NoSuchRuleActionException if a rule action with the primary key could not be found
	 */
	@Override
	public RuleAction findByPrimaryKey(long ruleActionId)
		throws NoSuchRuleActionException {

		return findByPrimaryKey((Serializable)ruleActionId);
	}

	/**
	 * Returns the rule action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleActionId the primary key of the rule action
	 * @return the rule action, or <code>null</code> if a rule action with the primary key could not be found
	 */
	@Override
	public RuleAction fetchByPrimaryKey(long ruleActionId) {
		return fetchByPrimaryKey((Serializable)ruleActionId);
	}

	/**
	 * Returns all the rule actions.
	 *
	 * @return the rule actions
	 */
	@Override
	public List<RuleAction> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @return the range of rule actions
	 */
	@Override
	public List<RuleAction> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rule actions
	 */
	@Override
	public List<RuleAction> findAll(
		int start, int end, OrderByComparator<RuleAction> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rule actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule actions
	 * @param end the upper bound of the range of rule actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rule actions
	 */
	@Override
	public List<RuleAction> findAll(
		int start, int end, OrderByComparator<RuleAction> orderByComparator,
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

		List<RuleAction> list = null;

		if (useFinderCache) {
			list = (List<RuleAction>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RULEACTION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RULEACTION;

				sql = sql.concat(RuleActionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<RuleAction>)QueryUtil.list(
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
	 * Removes all the rule actions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RuleAction ruleAction : findAll()) {
			remove(ruleAction);
		}
	}

	/**
	 * Returns the number of rule actions.
	 *
	 * @return the number of rule actions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RULEACTION);

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
		return "ruleActionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RULEACTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RuleActionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rule action persistence.
	 */
	@Activate
	public void activate() {
		RuleActionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		RuleActionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRuleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuleId",
			new String[] {Long.class.getName()},
			RuleActionModelImpl.RULEID_COLUMN_BITMASK);

		_finderPathCountByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(RuleActionImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.rules.model.RuleAction"),
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

	private static final String _SQL_SELECT_RULEACTION =
		"SELECT ruleAction FROM RuleAction ruleAction";

	private static final String _SQL_SELECT_RULEACTION_WHERE =
		"SELECT ruleAction FROM RuleAction ruleAction WHERE ";

	private static final String _SQL_COUNT_RULEACTION =
		"SELECT COUNT(ruleAction) FROM RuleAction ruleAction";

	private static final String _SQL_COUNT_RULEACTION_WHERE =
		"SELECT COUNT(ruleAction) FROM RuleAction ruleAction WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ruleAction.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RuleAction exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RuleAction exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RuleActionPersistenceImpl.class);

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}