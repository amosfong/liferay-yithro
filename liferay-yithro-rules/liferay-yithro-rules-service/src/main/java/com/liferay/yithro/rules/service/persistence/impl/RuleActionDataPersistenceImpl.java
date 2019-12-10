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
import com.liferay.yithro.rules.exception.NoSuchRuleActionDataException;
import com.liferay.yithro.rules.model.RuleActionData;
import com.liferay.yithro.rules.model.impl.RuleActionDataImpl;
import com.liferay.yithro.rules.model.impl.RuleActionDataModelImpl;
import com.liferay.yithro.rules.service.persistence.RuleActionDataPersistence;
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
 * The persistence implementation for the rule action data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RuleActionDataPersistence.class)
public class RuleActionDataPersistenceImpl
	extends BasePersistenceImpl<RuleActionData>
	implements RuleActionDataPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RuleActionDataUtil</code> to access the rule action data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RuleActionDataImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByRuleActionId;
	private FinderPath _finderPathWithoutPaginationFindByRuleActionId;
	private FinderPath _finderPathCountByRuleActionId;

	/**
	 * Returns all the rule action datas where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @return the matching rule action datas
	 */
	@Override
	public List<RuleActionData> findByRuleActionId(long ruleActionId) {
		return findByRuleActionId(
			ruleActionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule action datas where ruleActionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param ruleActionId the rule action ID
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @return the range of matching rule action datas
	 */
	@Override
	public List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end) {

		return findByRuleActionId(ruleActionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule action datas where ruleActionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param ruleActionId the rule action ID
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rule action datas
	 */
	@Override
	public List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end,
		OrderByComparator<RuleActionData> orderByComparator) {

		return findByRuleActionId(
			ruleActionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rule action datas where ruleActionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param ruleActionId the rule action ID
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rule action datas
	 */
	@Override
	public List<RuleActionData> findByRuleActionId(
		long ruleActionId, int start, int end,
		OrderByComparator<RuleActionData> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRuleActionId;
				finderArgs = new Object[] {ruleActionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRuleActionId;
			finderArgs = new Object[] {
				ruleActionId, start, end, orderByComparator
			};
		}

		List<RuleActionData> list = null;

		if (useFinderCache) {
			list = (List<RuleActionData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RuleActionData ruleActionData : list) {
					if (ruleActionId != ruleActionData.getRuleActionId()) {
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

			query.append(_SQL_SELECT_RULEACTIONDATA_WHERE);

			query.append(_FINDER_COLUMN_RULEACTIONID_RULEACTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(RuleActionDataModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleActionId);

				list = (List<RuleActionData>)QueryUtil.list(
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
	 * Returns the first rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action data
	 * @throws NoSuchRuleActionDataException if a matching rule action data could not be found
	 */
	@Override
	public RuleActionData findByRuleActionId_First(
			long ruleActionId,
			OrderByComparator<RuleActionData> orderByComparator)
		throws NoSuchRuleActionDataException {

		RuleActionData ruleActionData = fetchByRuleActionId_First(
			ruleActionId, orderByComparator);

		if (ruleActionData != null) {
			return ruleActionData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleActionId=");
		msg.append(ruleActionId);

		msg.append("}");

		throw new NoSuchRuleActionDataException(msg.toString());
	}

	/**
	 * Returns the first rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule action data, or <code>null</code> if a matching rule action data could not be found
	 */
	@Override
	public RuleActionData fetchByRuleActionId_First(
		long ruleActionId,
		OrderByComparator<RuleActionData> orderByComparator) {

		List<RuleActionData> list = findByRuleActionId(
			ruleActionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action data
	 * @throws NoSuchRuleActionDataException if a matching rule action data could not be found
	 */
	@Override
	public RuleActionData findByRuleActionId_Last(
			long ruleActionId,
			OrderByComparator<RuleActionData> orderByComparator)
		throws NoSuchRuleActionDataException {

		RuleActionData ruleActionData = fetchByRuleActionId_Last(
			ruleActionId, orderByComparator);

		if (ruleActionData != null) {
			return ruleActionData;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleActionId=");
		msg.append(ruleActionId);

		msg.append("}");

		throw new NoSuchRuleActionDataException(msg.toString());
	}

	/**
	 * Returns the last rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule action data, or <code>null</code> if a matching rule action data could not be found
	 */
	@Override
	public RuleActionData fetchByRuleActionId_Last(
		long ruleActionId,
		OrderByComparator<RuleActionData> orderByComparator) {

		int count = countByRuleActionId(ruleActionId);

		if (count == 0) {
			return null;
		}

		List<RuleActionData> list = findByRuleActionId(
			ruleActionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rule action datas before and after the current rule action data in the ordered set where ruleActionId = &#63;.
	 *
	 * @param ruleActionDataId the primary key of the current rule action data
	 * @param ruleActionId the rule action ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule action data
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	@Override
	public RuleActionData[] findByRuleActionId_PrevAndNext(
			long ruleActionDataId, long ruleActionId,
			OrderByComparator<RuleActionData> orderByComparator)
		throws NoSuchRuleActionDataException {

		RuleActionData ruleActionData = findByPrimaryKey(ruleActionDataId);

		Session session = null;

		try {
			session = openSession();

			RuleActionData[] array = new RuleActionDataImpl[3];

			array[0] = getByRuleActionId_PrevAndNext(
				session, ruleActionData, ruleActionId, orderByComparator, true);

			array[1] = ruleActionData;

			array[2] = getByRuleActionId_PrevAndNext(
				session, ruleActionData, ruleActionId, orderByComparator,
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

	protected RuleActionData getByRuleActionId_PrevAndNext(
		Session session, RuleActionData ruleActionData, long ruleActionId,
		OrderByComparator<RuleActionData> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULEACTIONDATA_WHERE);

		query.append(_FINDER_COLUMN_RULEACTIONID_RULEACTIONID_2);

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
			query.append(RuleActionDataModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ruleActionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ruleActionData)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<RuleActionData> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rule action datas where ruleActionId = &#63; from the database.
	 *
	 * @param ruleActionId the rule action ID
	 */
	@Override
	public void removeByRuleActionId(long ruleActionId) {
		for (RuleActionData ruleActionData :
				findByRuleActionId(
					ruleActionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ruleActionData);
		}
	}

	/**
	 * Returns the number of rule action datas where ruleActionId = &#63;.
	 *
	 * @param ruleActionId the rule action ID
	 * @return the number of matching rule action datas
	 */
	@Override
	public int countByRuleActionId(long ruleActionId) {
		FinderPath finderPath = _finderPathCountByRuleActionId;

		Object[] finderArgs = new Object[] {ruleActionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULEACTIONDATA_WHERE);

			query.append(_FINDER_COLUMN_RULEACTIONID_RULEACTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleActionId);

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

	private static final String _FINDER_COLUMN_RULEACTIONID_RULEACTIONID_2 =
		"ruleActionData.ruleActionId = ?";

	public RuleActionDataPersistenceImpl() {
		setModelClass(RuleActionData.class);

		setModelImplClass(RuleActionDataImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the rule action data in the entity cache if it is enabled.
	 *
	 * @param ruleActionData the rule action data
	 */
	@Override
	public void cacheResult(RuleActionData ruleActionData) {
		entityCache.putResult(
			entityCacheEnabled, RuleActionDataImpl.class,
			ruleActionData.getPrimaryKey(), ruleActionData);

		ruleActionData.resetOriginalValues();
	}

	/**
	 * Caches the rule action datas in the entity cache if it is enabled.
	 *
	 * @param ruleActionDatas the rule action datas
	 */
	@Override
	public void cacheResult(List<RuleActionData> ruleActionDatas) {
		for (RuleActionData ruleActionData : ruleActionDatas) {
			if (entityCache.getResult(
					entityCacheEnabled, RuleActionDataImpl.class,
					ruleActionData.getPrimaryKey()) == null) {

				cacheResult(ruleActionData);
			}
			else {
				ruleActionData.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rule action datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RuleActionDataImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rule action data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RuleActionData ruleActionData) {
		entityCache.removeResult(
			entityCacheEnabled, RuleActionDataImpl.class,
			ruleActionData.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<RuleActionData> ruleActionDatas) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (RuleActionData ruleActionData : ruleActionDatas) {
			entityCache.removeResult(
				entityCacheEnabled, RuleActionDataImpl.class,
				ruleActionData.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, RuleActionDataImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new rule action data with the primary key. Does not add the rule action data to the database.
	 *
	 * @param ruleActionDataId the primary key for the new rule action data
	 * @return the new rule action data
	 */
	@Override
	public RuleActionData create(long ruleActionDataId) {
		RuleActionData ruleActionData = new RuleActionDataImpl();

		ruleActionData.setNew(true);
		ruleActionData.setPrimaryKey(ruleActionDataId);

		return ruleActionData;
	}

	/**
	 * Removes the rule action data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data that was removed
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	@Override
	public RuleActionData remove(long ruleActionDataId)
		throws NoSuchRuleActionDataException {

		return remove((Serializable)ruleActionDataId);
	}

	/**
	 * Removes the rule action data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule action data
	 * @return the rule action data that was removed
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	@Override
	public RuleActionData remove(Serializable primaryKey)
		throws NoSuchRuleActionDataException {

		Session session = null;

		try {
			session = openSession();

			RuleActionData ruleActionData = (RuleActionData)session.get(
				RuleActionDataImpl.class, primaryKey);

			if (ruleActionData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRuleActionDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ruleActionData);
		}
		catch (NoSuchRuleActionDataException nsee) {
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
	protected RuleActionData removeImpl(RuleActionData ruleActionData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ruleActionData)) {
				ruleActionData = (RuleActionData)session.get(
					RuleActionDataImpl.class,
					ruleActionData.getPrimaryKeyObj());
			}

			if (ruleActionData != null) {
				session.delete(ruleActionData);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ruleActionData != null) {
			clearCache(ruleActionData);
		}

		return ruleActionData;
	}

	@Override
	public RuleActionData updateImpl(RuleActionData ruleActionData) {
		boolean isNew = ruleActionData.isNew();

		if (!(ruleActionData instanceof RuleActionDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ruleActionData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ruleActionData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ruleActionData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RuleActionData implementation " +
					ruleActionData.getClass());
		}

		RuleActionDataModelImpl ruleActionDataModelImpl =
			(RuleActionDataModelImpl)ruleActionData;

		Session session = null;

		try {
			session = openSession();

			if (ruleActionData.isNew()) {
				session.save(ruleActionData);

				ruleActionData.setNew(false);
			}
			else {
				ruleActionData = (RuleActionData)session.merge(ruleActionData);
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
				ruleActionDataModelImpl.getRuleActionId()
			};

			finderCache.removeResult(_finderPathCountByRuleActionId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByRuleActionId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ruleActionDataModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByRuleActionId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ruleActionDataModelImpl.getOriginalRuleActionId()
				};

				finderCache.removeResult(_finderPathCountByRuleActionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRuleActionId, args);

				args = new Object[] {ruleActionDataModelImpl.getRuleActionId()};

				finderCache.removeResult(_finderPathCountByRuleActionId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByRuleActionId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, RuleActionDataImpl.class,
			ruleActionData.getPrimaryKey(), ruleActionData, false);

		ruleActionData.resetOriginalValues();

		return ruleActionData;
	}

	/**
	 * Returns the rule action data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule action data
	 * @return the rule action data
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	@Override
	public RuleActionData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuleActionDataException {

		RuleActionData ruleActionData = fetchByPrimaryKey(primaryKey);

		if (ruleActionData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRuleActionDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ruleActionData;
	}

	/**
	 * Returns the rule action data with the primary key or throws a <code>NoSuchRuleActionDataException</code> if it could not be found.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data
	 * @throws NoSuchRuleActionDataException if a rule action data with the primary key could not be found
	 */
	@Override
	public RuleActionData findByPrimaryKey(long ruleActionDataId)
		throws NoSuchRuleActionDataException {

		return findByPrimaryKey((Serializable)ruleActionDataId);
	}

	/**
	 * Returns the rule action data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleActionDataId the primary key of the rule action data
	 * @return the rule action data, or <code>null</code> if a rule action data with the primary key could not be found
	 */
	@Override
	public RuleActionData fetchByPrimaryKey(long ruleActionDataId) {
		return fetchByPrimaryKey((Serializable)ruleActionDataId);
	}

	/**
	 * Returns all the rule action datas.
	 *
	 * @return the rule action datas
	 */
	@Override
	public List<RuleActionData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rule action datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @return the range of rule action datas
	 */
	@Override
	public List<RuleActionData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rule action datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rule action datas
	 */
	@Override
	public List<RuleActionData> findAll(
		int start, int end,
		OrderByComparator<RuleActionData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rule action datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RuleActionDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rule action datas
	 * @param end the upper bound of the range of rule action datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rule action datas
	 */
	@Override
	public List<RuleActionData> findAll(
		int start, int end, OrderByComparator<RuleActionData> orderByComparator,
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

		List<RuleActionData> list = null;

		if (useFinderCache) {
			list = (List<RuleActionData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_RULEACTIONDATA);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RULEACTIONDATA;

				sql = sql.concat(RuleActionDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<RuleActionData>)QueryUtil.list(
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
	 * Removes all the rule action datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RuleActionData ruleActionData : findAll()) {
			remove(ruleActionData);
		}
	}

	/**
	 * Returns the number of rule action datas.
	 *
	 * @return the number of rule action datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_RULEACTIONDATA);

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
		return "ruleActionDataId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RULEACTIONDATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RuleActionDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rule action data persistence.
	 */
	@Activate
	public void activate() {
		RuleActionDataModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		RuleActionDataModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleActionDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleActionDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByRuleActionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleActionDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRuleActionId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByRuleActionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, RuleActionDataImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuleActionId",
			new String[] {Long.class.getName()},
			RuleActionDataModelImpl.RULEACTIONID_COLUMN_BITMASK);

		_finderPathCountByRuleActionId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleActionId",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(RuleActionDataImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.rules.model.RuleActionData"),
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

	private static final String _SQL_SELECT_RULEACTIONDATA =
		"SELECT ruleActionData FROM RuleActionData ruleActionData";

	private static final String _SQL_SELECT_RULEACTIONDATA_WHERE =
		"SELECT ruleActionData FROM RuleActionData ruleActionData WHERE ";

	private static final String _SQL_COUNT_RULEACTIONDATA =
		"SELECT COUNT(ruleActionData) FROM RuleActionData ruleActionData";

	private static final String _SQL_COUNT_RULEACTIONDATA_WHERE =
		"SELECT COUNT(ruleActionData) FROM RuleActionData ruleActionData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ruleActionData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RuleActionData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RuleActionData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RuleActionDataPersistenceImpl.class);

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}