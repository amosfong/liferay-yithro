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
import com.liferay.yithro.rules.exception.NoSuchActionException;
import com.liferay.yithro.rules.model.Action;
import com.liferay.yithro.rules.model.impl.ActionImpl;
import com.liferay.yithro.rules.model.impl.ActionModelImpl;
import com.liferay.yithro.rules.service.persistence.ActionPersistence;
import com.liferay.yithro.rules.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the action service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ActionPersistence.class)
@ProviderType
public class ActionPersistenceImpl
	extends BasePersistenceImpl<Action> implements ActionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ActionUtil</code> to access the action persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ActionImpl.class.getName();

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
	 * Returns all the actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching actions
	 */
	@Override
	public List<Action> findByRuleId(long ruleId) {
		return findByRuleId(ruleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @return the range of matching actions
	 */
	@Override
	public List<Action> findByRuleId(long ruleId, int start, int end) {
		return findByRuleId(ruleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching actions
	 */
	@Override
	public List<Action> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<Action> orderByComparator) {

		return findByRuleId(ruleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the actions where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching actions
	 */
	@Override
	public List<Action> findByRuleId(
		long ruleId, int start, int end,
		OrderByComparator<Action> orderByComparator, boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRuleId;
				finderArgs = new Object[] {ruleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRuleId;
			finderArgs = new Object[] {ruleId, start, end, orderByComparator};
		}

		List<Action> list = null;

		if (useFinderCache) {
			list = (List<Action>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Action action : list) {
					if ((ruleId != action.getRuleId())) {
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

			query.append(_SQL_SELECT_ACTION_WHERE);

			query.append(_FINDER_COLUMN_RULEID_RULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ActionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				if (!pagination) {
					list = (List<Action>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Action>)QueryUtil.list(
						q, getDialect(), start, end);
				}

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
	 * Returns the first action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action
	 * @throws NoSuchActionException if a matching action could not be found
	 */
	@Override
	public Action findByRuleId_First(
			long ruleId, OrderByComparator<Action> orderByComparator)
		throws NoSuchActionException {

		Action action = fetchByRuleId_First(ruleId, orderByComparator);

		if (action != null) {
			return action;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append("}");

		throw new NoSuchActionException(msg.toString());
	}

	/**
	 * Returns the first action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching action, or <code>null</code> if a matching action could not be found
	 */
	@Override
	public Action fetchByRuleId_First(
		long ruleId, OrderByComparator<Action> orderByComparator) {

		List<Action> list = findByRuleId(ruleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action
	 * @throws NoSuchActionException if a matching action could not be found
	 */
	@Override
	public Action findByRuleId_Last(
			long ruleId, OrderByComparator<Action> orderByComparator)
		throws NoSuchActionException {

		Action action = fetchByRuleId_Last(ruleId, orderByComparator);

		if (action != null) {
			return action;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append("}");

		throw new NoSuchActionException(msg.toString());
	}

	/**
	 * Returns the last action in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching action, or <code>null</code> if a matching action could not be found
	 */
	@Override
	public Action fetchByRuleId_Last(
		long ruleId, OrderByComparator<Action> orderByComparator) {

		int count = countByRuleId(ruleId);

		if (count == 0) {
			return null;
		}

		List<Action> list = findByRuleId(
			ruleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the actions before and after the current action in the ordered set where ruleId = &#63;.
	 *
	 * @param actionId the primary key of the current action
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next action
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	@Override
	public Action[] findByRuleId_PrevAndNext(
			long actionId, long ruleId,
			OrderByComparator<Action> orderByComparator)
		throws NoSuchActionException {

		Action action = findByPrimaryKey(actionId);

		Session session = null;

		try {
			session = openSession();

			Action[] array = new ActionImpl[3];

			array[0] = getByRuleId_PrevAndNext(
				session, action, ruleId, orderByComparator, true);

			array[1] = action;

			array[2] = getByRuleId_PrevAndNext(
				session, action, ruleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Action getByRuleId_PrevAndNext(
		Session session, Action action, long ruleId,
		OrderByComparator<Action> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTION_WHERE);

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
			query.append(ActionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ruleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(action)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Action> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the actions where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 */
	@Override
	public void removeByRuleId(long ruleId) {
		for (Action action :
				findByRuleId(
					ruleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(action);
		}
	}

	/**
	 * Returns the number of actions where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching actions
	 */
	@Override
	public int countByRuleId(long ruleId) {
		FinderPath finderPath = _finderPathCountByRuleId;

		Object[] finderArgs = new Object[] {ruleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTION_WHERE);

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
		"action.ruleId = ?";

	public ActionPersistenceImpl() {
		setModelClass(Action.class);

		setModelImplClass(ActionImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the action in the entity cache if it is enabled.
	 *
	 * @param action the action
	 */
	@Override
	public void cacheResult(Action action) {
		entityCache.putResult(
			entityCacheEnabled, ActionImpl.class, action.getPrimaryKey(),
			action);

		action.resetOriginalValues();
	}

	/**
	 * Caches the actions in the entity cache if it is enabled.
	 *
	 * @param actions the actions
	 */
	@Override
	public void cacheResult(List<Action> actions) {
		for (Action action : actions) {
			if (entityCache.getResult(
					entityCacheEnabled, ActionImpl.class,
					action.getPrimaryKey()) == null) {

				cacheResult(action);
			}
			else {
				action.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all actions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ActionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the action.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Action action) {
		entityCache.removeResult(
			entityCacheEnabled, ActionImpl.class, action.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Action> actions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Action action : actions) {
			entityCache.removeResult(
				entityCacheEnabled, ActionImpl.class, action.getPrimaryKey());
		}
	}

	/**
	 * Creates a new action with the primary key. Does not add the action to the database.
	 *
	 * @param actionId the primary key for the new action
	 * @return the new action
	 */
	@Override
	public Action create(long actionId) {
		Action action = new ActionImpl();

		action.setNew(true);
		action.setPrimaryKey(actionId);

		return action;
	}

	/**
	 * Removes the action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param actionId the primary key of the action
	 * @return the action that was removed
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	@Override
	public Action remove(long actionId) throws NoSuchActionException {
		return remove((Serializable)actionId);
	}

	/**
	 * Removes the action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the action
	 * @return the action that was removed
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	@Override
	public Action remove(Serializable primaryKey) throws NoSuchActionException {
		Session session = null;

		try {
			session = openSession();

			Action action = (Action)session.get(ActionImpl.class, primaryKey);

			if (action == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(action);
		}
		catch (NoSuchActionException nsee) {
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
	protected Action removeImpl(Action action) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(action)) {
				action = (Action)session.get(
					ActionImpl.class, action.getPrimaryKeyObj());
			}

			if (action != null) {
				session.delete(action);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (action != null) {
			clearCache(action);
		}

		return action;
	}

	@Override
	public Action updateImpl(Action action) {
		boolean isNew = action.isNew();

		if (!(action instanceof ActionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(action.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(action);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in action proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Action implementation " +
					action.getClass());
		}

		ActionModelImpl actionModelImpl = (ActionModelImpl)action;

		Session session = null;

		try {
			session = openSession();

			if (action.isNew()) {
				session.save(action);

				action.setNew(false);
			}
			else {
				action = (Action)session.merge(action);
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
			Object[] args = new Object[] {actionModelImpl.getRuleId()};

			finderCache.removeResult(_finderPathCountByRuleId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRuleId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((actionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRuleId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					actionModelImpl.getOriginalRuleId()
				};

				finderCache.removeResult(_finderPathCountByRuleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRuleId, args);

				args = new Object[] {actionModelImpl.getRuleId()};

				finderCache.removeResult(_finderPathCountByRuleId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRuleId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ActionImpl.class, action.getPrimaryKey(),
			action, false);

		action.resetOriginalValues();

		return action;
	}

	/**
	 * Returns the action with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the action
	 * @return the action
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	@Override
	public Action findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActionException {

		Action action = fetchByPrimaryKey(primaryKey);

		if (action == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return action;
	}

	/**
	 * Returns the action with the primary key or throws a <code>NoSuchActionException</code> if it could not be found.
	 *
	 * @param actionId the primary key of the action
	 * @return the action
	 * @throws NoSuchActionException if a action with the primary key could not be found
	 */
	@Override
	public Action findByPrimaryKey(long actionId) throws NoSuchActionException {
		return findByPrimaryKey((Serializable)actionId);
	}

	/**
	 * Returns the action with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param actionId the primary key of the action
	 * @return the action, or <code>null</code> if a action with the primary key could not be found
	 */
	@Override
	public Action fetchByPrimaryKey(long actionId) {
		return fetchByPrimaryKey((Serializable)actionId);
	}

	/**
	 * Returns all the actions.
	 *
	 * @return the actions
	 */
	@Override
	public List<Action> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @return the range of actions
	 */
	@Override
	public List<Action> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of actions
	 */
	@Override
	public List<Action> findAll(
		int start, int end, OrderByComparator<Action> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ActionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of actions
	 * @param end the upper bound of the range of actions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of actions
	 */
	@Override
	public List<Action> findAll(
		int start, int end, OrderByComparator<Action> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Action> list = null;

		if (useFinderCache) {
			list = (List<Action>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ACTION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACTION;

				if (pagination) {
					sql = sql.concat(ActionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Action>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Action>)QueryUtil.list(
						q, getDialect(), start, end);
				}

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
	 * Removes all the actions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Action action : findAll()) {
			remove(action);
		}
	}

	/**
	 * Returns the number of actions.
	 *
	 * @return the number of actions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ACTION);

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
		return "actionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ACTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ActionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the action persistence.
	 */
	@Activate
	public void activate() {
		ActionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ActionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRuleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ActionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuleId",
			new String[] {Long.class.getName()},
			ActionModelImpl.RULEID_COLUMN_BITMASK);

		_finderPathCountByRuleId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ActionImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.rules.model.Action"),
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

	private static final String _SQL_SELECT_ACTION =
		"SELECT action FROM Action action";

	private static final String _SQL_SELECT_ACTION_WHERE =
		"SELECT action FROM Action action WHERE ";

	private static final String _SQL_COUNT_ACTION =
		"SELECT COUNT(action) FROM Action action";

	private static final String _SQL_COUNT_ACTION_WHERE =
		"SELECT COUNT(action) FROM Action action WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "action.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Action exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Action exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ActionPersistenceImpl.class);

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}