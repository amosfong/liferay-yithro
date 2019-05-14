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

package com.liferay.yithro.support.service.persistence.impl;

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
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.support.exception.NoSuchSupportWorkerException;
import com.liferay.yithro.support.model.SupportWorker;
import com.liferay.yithro.support.model.impl.SupportWorkerImpl;
import com.liferay.yithro.support.model.impl.SupportWorkerModelImpl;
import com.liferay.yithro.support.service.persistence.SupportWorkerPersistence;
import com.liferay.yithro.support.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the support worker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SupportWorkerPersistence.class)
@ProviderType
public class SupportWorkerPersistenceImpl
	extends BasePersistenceImpl<SupportWorker>
	implements SupportWorkerPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SupportWorkerUtil</code> to access the support worker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SupportWorkerImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the support workers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching support workers
	 */
	@Override
	public List<SupportWorker> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByUserId(
		long userId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUserId;
			finderArgs = new Object[] {userId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<SupportWorker> list = null;

		if (retrieveFromCache) {
			list = (List<SupportWorker>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SupportWorker supportWorker : list) {
					if ((userId != supportWorker.getUserId())) {
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

			query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<SupportWorker>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportWorker>)QueryUtil.list(
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
	 * Returns the first support worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findByUserId_First(
			long userId, OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchByUserId_First(
			userId, orderByComparator);

		if (supportWorker != null) {
			return supportWorker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchSupportWorkerException(msg.toString());
	}

	/**
	 * Returns the first support worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchByUserId_First(
		long userId, OrderByComparator<SupportWorker> orderByComparator) {

		List<SupportWorker> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last support worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findByUserId_Last(
			long userId, OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchByUserId_Last(
			userId, orderByComparator);

		if (supportWorker != null) {
			return supportWorker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchSupportWorkerException(msg.toString());
	}

	/**
	 * Returns the last support worker in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchByUserId_Last(
		long userId, OrderByComparator<SupportWorker> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<SupportWorker> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the support workers before and after the current support worker in the ordered set where userId = &#63;.
	 *
	 * @param supportWorkerId the primary key of the current support worker
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker[] findByUserId_PrevAndNext(
			long supportWorkerId, long userId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = findByPrimaryKey(supportWorkerId);

		Session session = null;

		try {
			session = openSession();

			SupportWorker[] array = new SupportWorkerImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, supportWorker, userId, orderByComparator, true);

			array[1] = supportWorker;

			array[2] = getByUserId_PrevAndNext(
				session, supportWorker, userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SupportWorker getByUserId_PrevAndNext(
		Session session, SupportWorker supportWorker, long userId,
		OrderByComparator<SupportWorker> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

		query.append(_FINDER_COLUMN_USERID_USERID_2);

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
			query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						supportWorker)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SupportWorker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the support workers where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (SupportWorker supportWorker :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(supportWorker);
		}
	}

	/**
	 * Returns the number of support workers where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching support workers
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"supportWorker.userId = ?";

	private FinderPath _finderPathWithPaginationFindBySupportTeamId;
	private FinderPath _finderPathWithoutPaginationFindBySupportTeamId;
	private FinderPath _finderPathCountBySupportTeamId;

	/**
	 * Returns all the support workers where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @return the matching support workers
	 */
	@Override
	public List<SupportWorker> findBySupportTeamId(long supportTeamId) {
		return findBySupportTeamId(
			supportTeamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support workers where supportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportTeamId the support team ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	@Override
	public List<SupportWorker> findBySupportTeamId(
		long supportTeamId, int start, int end) {

		return findBySupportTeamId(supportTeamId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the support workers where supportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportTeamId the support team ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findBySupportTeamId(
		long supportTeamId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return findBySupportTeamId(
			supportTeamId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support workers where supportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportTeamId the support team ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findBySupportTeamId(
		long supportTeamId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBySupportTeamId;
			finderArgs = new Object[] {supportTeamId};
		}
		else {
			finderPath = _finderPathWithPaginationFindBySupportTeamId;
			finderArgs = new Object[] {
				supportTeamId, start, end, orderByComparator
			};
		}

		List<SupportWorker> list = null;

		if (retrieveFromCache) {
			list = (List<SupportWorker>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SupportWorker supportWorker : list) {
					if ((supportTeamId != supportWorker.getSupportTeamId())) {
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

			query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_SUPPORTTEAMID_SUPPORTTEAMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supportTeamId);

				if (!pagination) {
					list = (List<SupportWorker>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportWorker>)QueryUtil.list(
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
	 * Returns the first support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findBySupportTeamId_First(
			long supportTeamId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchBySupportTeamId_First(
			supportTeamId, orderByComparator);

		if (supportWorker != null) {
			return supportWorker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supportTeamId=");
		msg.append(supportTeamId);

		msg.append("}");

		throw new NoSuchSupportWorkerException(msg.toString());
	}

	/**
	 * Returns the first support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchBySupportTeamId_First(
		long supportTeamId,
		OrderByComparator<SupportWorker> orderByComparator) {

		List<SupportWorker> list = findBySupportTeamId(
			supportTeamId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findBySupportTeamId_Last(
			long supportTeamId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchBySupportTeamId_Last(
			supportTeamId, orderByComparator);

		if (supportWorker != null) {
			return supportWorker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supportTeamId=");
		msg.append(supportTeamId);

		msg.append("}");

		throw new NoSuchSupportWorkerException(msg.toString());
	}

	/**
	 * Returns the last support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchBySupportTeamId_Last(
		long supportTeamId,
		OrderByComparator<SupportWorker> orderByComparator) {

		int count = countBySupportTeamId(supportTeamId);

		if (count == 0) {
			return null;
		}

		List<SupportWorker> list = findBySupportTeamId(
			supportTeamId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the support workers before and after the current support worker in the ordered set where supportTeamId = &#63;.
	 *
	 * @param supportWorkerId the primary key of the current support worker
	 * @param supportTeamId the support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker[] findBySupportTeamId_PrevAndNext(
			long supportWorkerId, long supportTeamId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = findByPrimaryKey(supportWorkerId);

		Session session = null;

		try {
			session = openSession();

			SupportWorker[] array = new SupportWorkerImpl[3];

			array[0] = getBySupportTeamId_PrevAndNext(
				session, supportWorker, supportTeamId, orderByComparator, true);

			array[1] = supportWorker;

			array[2] = getBySupportTeamId_PrevAndNext(
				session, supportWorker, supportTeamId, orderByComparator,
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

	protected SupportWorker getBySupportTeamId_PrevAndNext(
		Session session, SupportWorker supportWorker, long supportTeamId,
		OrderByComparator<SupportWorker> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

		query.append(_FINDER_COLUMN_SUPPORTTEAMID_SUPPORTTEAMID_2);

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
			query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(supportTeamId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						supportWorker)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SupportWorker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the support workers where supportTeamId = &#63; from the database.
	 *
	 * @param supportTeamId the support team ID
	 */
	@Override
	public void removeBySupportTeamId(long supportTeamId) {
		for (SupportWorker supportWorker :
				findBySupportTeamId(
					supportTeamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(supportWorker);
		}
	}

	/**
	 * Returns the number of support workers where supportTeamId = &#63;.
	 *
	 * @param supportTeamId the support team ID
	 * @return the number of matching support workers
	 */
	@Override
	public int countBySupportTeamId(long supportTeamId) {
		FinderPath finderPath = _finderPathCountBySupportTeamId;

		Object[] finderArgs = new Object[] {supportTeamId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_SUPPORTTEAMID_SUPPORTTEAMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supportTeamId);

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

	private static final String _FINDER_COLUMN_SUPPORTTEAMID_SUPPORTTEAMID_2 =
		"supportWorker.supportTeamId = ?";

	private FinderPath _finderPathWithPaginationFindBySupportLaborId;
	private FinderPath _finderPathWithoutPaginationFindBySupportLaborId;
	private FinderPath _finderPathCountBySupportLaborId;

	/**
	 * Returns all the support workers where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the matching support workers
	 */
	@Override
	public List<SupportWorker> findBySupportLaborId(long supportLaborId) {
		return findBySupportLaborId(
			supportLaborId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support workers where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	@Override
	public List<SupportWorker> findBySupportLaborId(
		long supportLaborId, int start, int end) {

		return findBySupportLaborId(supportLaborId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the support workers where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findBySupportLaborId(
		long supportLaborId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return findBySupportLaborId(
			supportLaborId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support workers where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findBySupportLaborId(
		long supportLaborId, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindBySupportLaborId;
			finderArgs = new Object[] {supportLaborId};
		}
		else {
			finderPath = _finderPathWithPaginationFindBySupportLaborId;
			finderArgs = new Object[] {
				supportLaborId, start, end, orderByComparator
			};
		}

		List<SupportWorker> list = null;

		if (retrieveFromCache) {
			list = (List<SupportWorker>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SupportWorker supportWorker : list) {
					if ((supportLaborId != supportWorker.getSupportLaborId())) {
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

			query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_SUPPORTLABORID_SUPPORTLABORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supportLaborId);

				if (!pagination) {
					list = (List<SupportWorker>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportWorker>)QueryUtil.list(
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
	 * Returns the first support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findBySupportLaborId_First(
			long supportLaborId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchBySupportLaborId_First(
			supportLaborId, orderByComparator);

		if (supportWorker != null) {
			return supportWorker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supportLaborId=");
		msg.append(supportLaborId);

		msg.append("}");

		throw new NoSuchSupportWorkerException(msg.toString());
	}

	/**
	 * Returns the first support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchBySupportLaborId_First(
		long supportLaborId,
		OrderByComparator<SupportWorker> orderByComparator) {

		List<SupportWorker> list = findBySupportLaborId(
			supportLaborId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findBySupportLaborId_Last(
			long supportLaborId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchBySupportLaborId_Last(
			supportLaborId, orderByComparator);

		if (supportWorker != null) {
			return supportWorker;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supportLaborId=");
		msg.append(supportLaborId);

		msg.append("}");

		throw new NoSuchSupportWorkerException(msg.toString());
	}

	/**
	 * Returns the last support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchBySupportLaborId_Last(
		long supportLaborId,
		OrderByComparator<SupportWorker> orderByComparator) {

		int count = countBySupportLaborId(supportLaborId);

		if (count == 0) {
			return null;
		}

		List<SupportWorker> list = findBySupportLaborId(
			supportLaborId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the support workers before and after the current support worker in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportWorkerId the primary key of the current support worker
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker[] findBySupportLaborId_PrevAndNext(
			long supportWorkerId, long supportLaborId,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = findByPrimaryKey(supportWorkerId);

		Session session = null;

		try {
			session = openSession();

			SupportWorker[] array = new SupportWorkerImpl[3];

			array[0] = getBySupportLaborId_PrevAndNext(
				session, supportWorker, supportLaborId, orderByComparator,
				true);

			array[1] = supportWorker;

			array[2] = getBySupportLaborId_PrevAndNext(
				session, supportWorker, supportLaborId, orderByComparator,
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

	protected SupportWorker getBySupportLaborId_PrevAndNext(
		Session session, SupportWorker supportWorker, long supportLaborId,
		OrderByComparator<SupportWorker> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

		query.append(_FINDER_COLUMN_SUPPORTLABORID_SUPPORTLABORID_2);

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
			query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(supportLaborId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						supportWorker)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SupportWorker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the support workers where supportLaborId = &#63; from the database.
	 *
	 * @param supportLaborId the support labor ID
	 */
	@Override
	public void removeBySupportLaborId(long supportLaborId) {
		for (SupportWorker supportWorker :
				findBySupportLaborId(
					supportLaborId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(supportWorker);
		}
	}

	/**
	 * Returns the number of support workers where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the number of matching support workers
	 */
	@Override
	public int countBySupportLaborId(long supportLaborId) {
		FinderPath finderPath = _finderPathCountBySupportLaborId;

		Object[] finderArgs = new Object[] {supportLaborId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_SUPPORTLABORID_SUPPORTLABORID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supportLaborId);

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

	private static final String _FINDER_COLUMN_SUPPORTLABORID_SUPPORTLABORID_2 =
		"supportWorker.supportLaborId = ?";

	private FinderPath _finderPathFetchByU_STI;
	private FinderPath _finderPathCountByU_STI;

	/**
	 * Returns the support worker where userId = &#63; and supportTeamId = &#63; or throws a <code>NoSuchSupportWorkerException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @return the matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findByU_STI(long userId, long supportTeamId)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchByU_STI(userId, supportTeamId);

		if (supportWorker == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", supportTeamId=");
			msg.append(supportTeamId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSupportWorkerException(msg.toString());
		}

		return supportWorker;
	}

	/**
	 * Returns the support worker where userId = &#63; and supportTeamId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @return the matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchByU_STI(long userId, long supportTeamId) {
		return fetchByU_STI(userId, supportTeamId, true);
	}

	/**
	 * Returns the support worker where userId = &#63; and supportTeamId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchByU_STI(
		long userId, long supportTeamId, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {userId, supportTeamId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByU_STI, finderArgs, this);
		}

		if (result instanceof SupportWorker) {
			SupportWorker supportWorker = (SupportWorker)result;

			if ((userId != supportWorker.getUserId()) ||
				(supportTeamId != supportWorker.getSupportTeamId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_U_STI_USERID_2);

			query.append(_FINDER_COLUMN_U_STI_SUPPORTTEAMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(supportTeamId);

				List<SupportWorker> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByU_STI, finderArgs, list);
				}
				else {
					SupportWorker supportWorker = list.get(0);

					result = supportWorker;

					cacheResult(supportWorker);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByU_STI, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (SupportWorker)result;
		}
	}

	/**
	 * Removes the support worker where userId = &#63; and supportTeamId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @return the support worker that was removed
	 */
	@Override
	public SupportWorker removeByU_STI(long userId, long supportTeamId)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = findByU_STI(userId, supportTeamId);

		return remove(supportWorker);
	}

	/**
	 * Returns the number of support workers where userId = &#63; and supportTeamId = &#63;.
	 *
	 * @param userId the user ID
	 * @param supportTeamId the support team ID
	 * @return the number of matching support workers
	 */
	@Override
	public int countByU_STI(long userId, long supportTeamId) {
		FinderPath finderPath = _finderPathCountByU_STI;

		Object[] finderArgs = new Object[] {userId, supportTeamId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_U_STI_USERID_2);

			query.append(_FINDER_COLUMN_U_STI_SUPPORTTEAMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(supportTeamId);

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

	private static final String _FINDER_COLUMN_U_STI_USERID_2 =
		"supportWorker.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_STI_SUPPORTTEAMID_2 =
		"supportWorker.supportTeamId = ?";

	private FinderPath _finderPathWithPaginationFindByU_MW_R;
	private FinderPath _finderPathWithPaginationCountByU_MW_R;

	/**
	 * Returns all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @return the matching support workers
	 */
	@Override
	public List<SupportWorker> findByU_MW_R(
		long userId, double maxWork, int role) {

		return findByU_MW_R(
			userId, maxWork, role, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByU_MW_R(
		long userId, double maxWork, int role, int start, int end) {

		return findByU_MW_R(userId, maxWork, role, start, end, null);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByU_MW_R(
		long userId, double maxWork, int role, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return findByU_MW_R(
			userId, maxWork, role, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByU_MW_R(
		long userId, double maxWork, int role, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByU_MW_R;
		finderArgs = new Object[] {
			userId, maxWork, role, start, end, orderByComparator
		};

		List<SupportWorker> list = null;

		if (retrieveFromCache) {
			list = (List<SupportWorker>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SupportWorker supportWorker : list) {
					if ((userId != supportWorker.getUserId()) ||
						(maxWork == supportWorker.getMaxWork()) ||
						(role != supportWorker.getRole())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_U_MW_R_USERID_2);

			query.append(_FINDER_COLUMN_U_MW_R_MAXWORK_2);

			query.append(_FINDER_COLUMN_U_MW_R_ROLE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(maxWork);

				qPos.add(role);

				if (!pagination) {
					list = (List<SupportWorker>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportWorker>)QueryUtil.list(
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
	 * Returns the first support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findByU_MW_R_First(
			long userId, double maxWork, int role,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchByU_MW_R_First(
			userId, maxWork, role, orderByComparator);

		if (supportWorker != null) {
			return supportWorker;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", maxWork=");
		msg.append(maxWork);

		msg.append(", role=");
		msg.append(role);

		msg.append("}");

		throw new NoSuchSupportWorkerException(msg.toString());
	}

	/**
	 * Returns the first support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchByU_MW_R_First(
		long userId, double maxWork, int role,
		OrderByComparator<SupportWorker> orderByComparator) {

		List<SupportWorker> list = findByU_MW_R(
			userId, maxWork, role, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker
	 * @throws NoSuchSupportWorkerException if a matching support worker could not be found
	 */
	@Override
	public SupportWorker findByU_MW_R_Last(
			long userId, double maxWork, int role,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchByU_MW_R_Last(
			userId, maxWork, role, orderByComparator);

		if (supportWorker != null) {
			return supportWorker;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", maxWork=");
		msg.append(maxWork);

		msg.append(", role=");
		msg.append(role);

		msg.append("}");

		throw new NoSuchSupportWorkerException(msg.toString());
	}

	/**
	 * Returns the last support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support worker, or <code>null</code> if a matching support worker could not be found
	 */
	@Override
	public SupportWorker fetchByU_MW_R_Last(
		long userId, double maxWork, int role,
		OrderByComparator<SupportWorker> orderByComparator) {

		int count = countByU_MW_R(userId, maxWork, role);

		if (count == 0) {
			return null;
		}

		List<SupportWorker> list = findByU_MW_R(
			userId, maxWork, role, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the support workers before and after the current support worker in the ordered set where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param supportWorkerId the primary key of the current support worker
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker[] findByU_MW_R_PrevAndNext(
			long supportWorkerId, long userId, double maxWork, int role,
			OrderByComparator<SupportWorker> orderByComparator)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = findByPrimaryKey(supportWorkerId);

		Session session = null;

		try {
			session = openSession();

			SupportWorker[] array = new SupportWorkerImpl[3];

			array[0] = getByU_MW_R_PrevAndNext(
				session, supportWorker, userId, maxWork, role,
				orderByComparator, true);

			array[1] = supportWorker;

			array[2] = getByU_MW_R_PrevAndNext(
				session, supportWorker, userId, maxWork, role,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SupportWorker getByU_MW_R_PrevAndNext(
		Session session, SupportWorker supportWorker, long userId,
		double maxWork, int role,
		OrderByComparator<SupportWorker> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

		query.append(_FINDER_COLUMN_U_MW_R_USERID_2);

		query.append(_FINDER_COLUMN_U_MW_R_MAXWORK_2);

		query.append(_FINDER_COLUMN_U_MW_R_ROLE_2);

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
			query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(maxWork);

		qPos.add(role);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						supportWorker)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SupportWorker> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the support workers where userId = any &#63; and maxWork &ne; &#63; and role = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIds the user IDs
	 * @param maxWork the max work
	 * @param roles the roles
	 * @return the matching support workers
	 */
	@Override
	public List<SupportWorker> findByU_MW_R(
		long[] userIds, double maxWork, int[] roles) {

		return findByU_MW_R(
			userIds, maxWork, roles, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the support workers where userId = any &#63; and maxWork &ne; &#63; and role = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIds the user IDs
	 * @param maxWork the max work
	 * @param roles the roles
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByU_MW_R(
		long[] userIds, double maxWork, int[] roles, int start, int end) {

		return findByU_MW_R(userIds, maxWork, roles, start, end, null);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = any &#63; and maxWork &ne; &#63; and role = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userIds the user IDs
	 * @param maxWork the max work
	 * @param roles the roles
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByU_MW_R(
		long[] userIds, double maxWork, int[] roles, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return findByU_MW_R(
			userIds, maxWork, roles, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support workers
	 */
	@Override
	public List<SupportWorker> findByU_MW_R(
		long[] userIds, double maxWork, int[] roles, int start, int end,
		OrderByComparator<SupportWorker> orderByComparator,
		boolean retrieveFromCache) {

		if (userIds == null) {
			userIds = new long[0];
		}
		else if (userIds.length > 1) {
			userIds = ArrayUtil.unique(userIds);

			Arrays.sort(userIds);
		}

		if (roles == null) {
			roles = new int[0];
		}
		else if (roles.length > 1) {
			roles = ArrayUtil.unique(roles);

			Arrays.sort(roles);
		}

		if (userIds.length == 1 && roles.length == 1) {
			return findByU_MW_R(
				userIds[0], maxWork, roles[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderArgs = new Object[] {
				StringUtil.merge(userIds), maxWork, StringUtil.merge(roles)
			};
		}
		else {
			finderArgs = new Object[] {
				StringUtil.merge(userIds), maxWork, StringUtil.merge(roles),
				start, end, orderByComparator
			};
		}

		List<SupportWorker> list = null;

		if (retrieveFromCache) {
			list = (List<SupportWorker>)finderCache.getResult(
				_finderPathWithPaginationFindByU_MW_R, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SupportWorker supportWorker : list) {
					if (!ArrayUtil.contains(
							userIds, supportWorker.getUserId()) ||
						(maxWork == supportWorker.getMaxWork()) ||
						!ArrayUtil.contains(roles, supportWorker.getRole())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_SUPPORTWORKER_WHERE);

			if (userIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_U_MW_R_USERID_7);

				query.append(StringUtil.merge(userIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_U_MW_R_MAXWORK_2);

			if (roles.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_U_MW_R_ROLE_7);

				query.append(StringUtil.merge(roles));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SupportWorkerModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(maxWork);

				if (!pagination) {
					list = (List<SupportWorker>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportWorker>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(
					_finderPathWithPaginationFindByU_MW_R, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationFindByU_MW_R, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 */
	@Override
	public void removeByU_MW_R(long userId, double maxWork, int role) {
		for (SupportWorker supportWorker :
				findByU_MW_R(
					userId, maxWork, role, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(supportWorker);
		}
	}

	/**
	 * Returns the number of support workers where userId = &#63; and maxWork &ne; &#63; and role = &#63;.
	 *
	 * @param userId the user ID
	 * @param maxWork the max work
	 * @param role the role
	 * @return the number of matching support workers
	 */
	@Override
	public int countByU_MW_R(long userId, double maxWork, int role) {
		FinderPath finderPath = _finderPathWithPaginationCountByU_MW_R;

		Object[] finderArgs = new Object[] {userId, maxWork, role};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_SUPPORTWORKER_WHERE);

			query.append(_FINDER_COLUMN_U_MW_R_USERID_2);

			query.append(_FINDER_COLUMN_U_MW_R_MAXWORK_2);

			query.append(_FINDER_COLUMN_U_MW_R_ROLE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(maxWork);

				qPos.add(role);

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

	/**
	 * Returns the number of support workers where userId = any &#63; and maxWork &ne; &#63; and role = any &#63;.
	 *
	 * @param userIds the user IDs
	 * @param maxWork the max work
	 * @param roles the roles
	 * @return the number of matching support workers
	 */
	@Override
	public int countByU_MW_R(long[] userIds, double maxWork, int[] roles) {
		if (userIds == null) {
			userIds = new long[0];
		}
		else if (userIds.length > 1) {
			userIds = ArrayUtil.unique(userIds);

			Arrays.sort(userIds);
		}

		if (roles == null) {
			roles = new int[0];
		}
		else if (roles.length > 1) {
			roles = ArrayUtil.unique(roles);

			Arrays.sort(roles);
		}

		Object[] finderArgs = new Object[] {
			StringUtil.merge(userIds), maxWork, StringUtil.merge(roles)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByU_MW_R, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_SUPPORTWORKER_WHERE);

			if (userIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_U_MW_R_USERID_7);

				query.append(StringUtil.merge(userIds));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_U_MW_R_MAXWORK_2);

			if (roles.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_U_MW_R_ROLE_7);

				query.append(StringUtil.merge(roles));

				query.append(")");

				query.append(")");
			}

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(maxWork);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByU_MW_R, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByU_MW_R, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_MW_R_USERID_2 =
		"supportWorker.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_MW_R_USERID_7 =
		"supportWorker.userId IN (";

	private static final String _FINDER_COLUMN_U_MW_R_MAXWORK_2 =
		"supportWorker.maxWork != ? AND ";

	private static final String _FINDER_COLUMN_U_MW_R_ROLE_2 =
		"supportWorker.role = ?";

	private static final String _FINDER_COLUMN_U_MW_R_ROLE_7 =
		"supportWorker.role IN (";

	public SupportWorkerPersistenceImpl() {
		setModelClass(SupportWorker.class);

		setModelImplClass(SupportWorkerImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("role", "role_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the support worker in the entity cache if it is enabled.
	 *
	 * @param supportWorker the support worker
	 */
	@Override
	public void cacheResult(SupportWorker supportWorker) {
		entityCache.putResult(
			entityCacheEnabled, SupportWorkerImpl.class,
			supportWorker.getPrimaryKey(), supportWorker);

		finderCache.putResult(
			_finderPathFetchByU_STI,
			new Object[] {
				supportWorker.getUserId(), supportWorker.getSupportTeamId()
			},
			supportWorker);

		supportWorker.resetOriginalValues();
	}

	/**
	 * Caches the support workers in the entity cache if it is enabled.
	 *
	 * @param supportWorkers the support workers
	 */
	@Override
	public void cacheResult(List<SupportWorker> supportWorkers) {
		for (SupportWorker supportWorker : supportWorkers) {
			if (entityCache.getResult(
					entityCacheEnabled, SupportWorkerImpl.class,
					supportWorker.getPrimaryKey()) == null) {

				cacheResult(supportWorker);
			}
			else {
				supportWorker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all support workers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SupportWorkerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the support worker.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SupportWorker supportWorker) {
		entityCache.removeResult(
			entityCacheEnabled, SupportWorkerImpl.class,
			supportWorker.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SupportWorkerModelImpl)supportWorker, true);
	}

	@Override
	public void clearCache(List<SupportWorker> supportWorkers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SupportWorker supportWorker : supportWorkers) {
			entityCache.removeResult(
				entityCacheEnabled, SupportWorkerImpl.class,
				supportWorker.getPrimaryKey());

			clearUniqueFindersCache(
				(SupportWorkerModelImpl)supportWorker, true);
		}
	}

	protected void cacheUniqueFindersCache(
		SupportWorkerModelImpl supportWorkerModelImpl) {

		Object[] args = new Object[] {
			supportWorkerModelImpl.getUserId(),
			supportWorkerModelImpl.getSupportTeamId()
		};

		finderCache.putResult(
			_finderPathCountByU_STI, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByU_STI, args, supportWorkerModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SupportWorkerModelImpl supportWorkerModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				supportWorkerModelImpl.getUserId(),
				supportWorkerModelImpl.getSupportTeamId()
			};

			finderCache.removeResult(_finderPathCountByU_STI, args);
			finderCache.removeResult(_finderPathFetchByU_STI, args);
		}

		if ((supportWorkerModelImpl.getColumnBitmask() &
			 _finderPathFetchByU_STI.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				supportWorkerModelImpl.getOriginalUserId(),
				supportWorkerModelImpl.getOriginalSupportTeamId()
			};

			finderCache.removeResult(_finderPathCountByU_STI, args);
			finderCache.removeResult(_finderPathFetchByU_STI, args);
		}
	}

	/**
	 * Creates a new support worker with the primary key. Does not add the support worker to the database.
	 *
	 * @param supportWorkerId the primary key for the new support worker
	 * @return the new support worker
	 */
	@Override
	public SupportWorker create(long supportWorkerId) {
		SupportWorker supportWorker = new SupportWorkerImpl();

		supportWorker.setNew(true);
		supportWorker.setPrimaryKey(supportWorkerId);

		supportWorker.setCompanyId(companyProvider.getCompanyId());

		return supportWorker;
	}

	/**
	 * Removes the support worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker that was removed
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker remove(long supportWorkerId)
		throws NoSuchSupportWorkerException {

		return remove((Serializable)supportWorkerId);
	}

	/**
	 * Removes the support worker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the support worker
	 * @return the support worker that was removed
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker remove(Serializable primaryKey)
		throws NoSuchSupportWorkerException {

		Session session = null;

		try {
			session = openSession();

			SupportWorker supportWorker = (SupportWorker)session.get(
				SupportWorkerImpl.class, primaryKey);

			if (supportWorker == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupportWorkerException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(supportWorker);
		}
		catch (NoSuchSupportWorkerException nsee) {
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
	protected SupportWorker removeImpl(SupportWorker supportWorker) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supportWorker)) {
				supportWorker = (SupportWorker)session.get(
					SupportWorkerImpl.class, supportWorker.getPrimaryKeyObj());
			}

			if (supportWorker != null) {
				session.delete(supportWorker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supportWorker != null) {
			clearCache(supportWorker);
		}

		return supportWorker;
	}

	@Override
	public SupportWorker updateImpl(SupportWorker supportWorker) {
		boolean isNew = supportWorker.isNew();

		if (!(supportWorker instanceof SupportWorkerModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(supportWorker.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					supportWorker);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in supportWorker proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SupportWorker implementation " +
					supportWorker.getClass());
		}

		SupportWorkerModelImpl supportWorkerModelImpl =
			(SupportWorkerModelImpl)supportWorker;

		Session session = null;

		try {
			session = openSession();

			if (supportWorker.isNew()) {
				session.save(supportWorker);

				supportWorker.setNew(false);
			}
			else {
				supportWorker = (SupportWorker)session.merge(supportWorker);
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
			Object[] args = new Object[] {supportWorkerModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUserId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUserId, args);

			args = new Object[] {supportWorkerModelImpl.getSupportTeamId()};

			finderCache.removeResult(_finderPathCountBySupportTeamId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySupportTeamId, args);

			args = new Object[] {supportWorkerModelImpl.getSupportLaborId()};

			finderCache.removeResult(_finderPathCountBySupportLaborId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySupportLaborId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((supportWorkerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUserId.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					supportWorkerModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);

				args = new Object[] {supportWorkerModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUserId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUserId, args);
			}

			if ((supportWorkerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySupportTeamId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					supportWorkerModelImpl.getOriginalSupportTeamId()
				};

				finderCache.removeResult(_finderPathCountBySupportTeamId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySupportTeamId, args);

				args = new Object[] {supportWorkerModelImpl.getSupportTeamId()};

				finderCache.removeResult(_finderPathCountBySupportTeamId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySupportTeamId, args);
			}

			if ((supportWorkerModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySupportLaborId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					supportWorkerModelImpl.getOriginalSupportLaborId()
				};

				finderCache.removeResult(
					_finderPathCountBySupportLaborId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySupportLaborId, args);

				args = new Object[] {
					supportWorkerModelImpl.getSupportLaborId()
				};

				finderCache.removeResult(
					_finderPathCountBySupportLaborId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySupportLaborId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, SupportWorkerImpl.class,
			supportWorker.getPrimaryKey(), supportWorker, false);

		clearUniqueFindersCache(supportWorkerModelImpl, false);
		cacheUniqueFindersCache(supportWorkerModelImpl);

		supportWorker.resetOriginalValues();

		return supportWorker;
	}

	/**
	 * Returns the support worker with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the support worker
	 * @return the support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupportWorkerException {

		SupportWorker supportWorker = fetchByPrimaryKey(primaryKey);

		if (supportWorker == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupportWorkerException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return supportWorker;
	}

	/**
	 * Returns the support worker with the primary key or throws a <code>NoSuchSupportWorkerException</code> if it could not be found.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker
	 * @throws NoSuchSupportWorkerException if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker findByPrimaryKey(long supportWorkerId)
		throws NoSuchSupportWorkerException {

		return findByPrimaryKey((Serializable)supportWorkerId);
	}

	/**
	 * Returns the support worker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportWorkerId the primary key of the support worker
	 * @return the support worker, or <code>null</code> if a support worker with the primary key could not be found
	 */
	@Override
	public SupportWorker fetchByPrimaryKey(long supportWorkerId) {
		return fetchByPrimaryKey((Serializable)supportWorkerId);
	}

	/**
	 * Returns all the support workers.
	 *
	 * @return the support workers
	 */
	@Override
	public List<SupportWorker> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @return the range of support workers
	 */
	@Override
	public List<SupportWorker> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support workers
	 */
	@Override
	public List<SupportWorker> findAll(
		int start, int end,
		OrderByComparator<SupportWorker> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support workers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportWorkerModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support workers
	 * @param end the upper bound of the range of support workers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of support workers
	 */
	@Override
	public List<SupportWorker> findAll(
		int start, int end, OrderByComparator<SupportWorker> orderByComparator,
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

		List<SupportWorker> list = null;

		if (retrieveFromCache) {
			list = (List<SupportWorker>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUPPORTWORKER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPORTWORKER;

				if (pagination) {
					sql = sql.concat(SupportWorkerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SupportWorker>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportWorker>)QueryUtil.list(
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
	 * Removes all the support workers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SupportWorker supportWorker : findAll()) {
			remove(supportWorker);
		}
	}

	/**
	 * Returns the number of support workers.
	 *
	 * @return the number of support workers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUPPORTWORKER);

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
		return "supportWorkerId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUPPORTWORKER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SupportWorkerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the support worker persistence.
	 */
	@Activate
	public void activate() {
		SupportWorkerModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		SupportWorkerModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()},
			SupportWorkerModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUserId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBySupportTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySupportTeamId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySupportTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySupportTeamId",
			new String[] {Long.class.getName()},
			SupportWorkerModelImpl.SUPPORTTEAMID_COLUMN_BITMASK);

		_finderPathCountBySupportTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySupportTeamId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBySupportLaborId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySupportLaborId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySupportLaborId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySupportLaborId",
			new String[] {Long.class.getName()},
			SupportWorkerModelImpl.SUPPORTLABORID_COLUMN_BITMASK);

		_finderPathCountBySupportLaborId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySupportLaborId",
			new String[] {Long.class.getName()});

		_finderPathFetchByU_STI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByU_STI",
			new String[] {Long.class.getName(), Long.class.getName()},
			SupportWorkerModelImpl.USERID_COLUMN_BITMASK |
			SupportWorkerModelImpl.SUPPORTTEAMID_COLUMN_BITMASK);

		_finderPathCountByU_STI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_STI",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByU_MW_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportWorkerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_MW_R",
			new String[] {
				Long.class.getName(), Double.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByU_MW_R = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_MW_R",
			new String[] {
				Long.class.getName(), Double.class.getName(),
				Integer.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SupportWorkerImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.support.model.SupportWorker"),
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

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_SUPPORTWORKER =
		"SELECT supportWorker FROM SupportWorker supportWorker";

	private static final String _SQL_SELECT_SUPPORTWORKER_WHERE =
		"SELECT supportWorker FROM SupportWorker supportWorker WHERE ";

	private static final String _SQL_COUNT_SUPPORTWORKER =
		"SELECT COUNT(supportWorker) FROM SupportWorker supportWorker";

	private static final String _SQL_COUNT_SUPPORTWORKER_WHERE =
		"SELECT COUNT(supportWorker) FROM SupportWorker supportWorker WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "supportWorker.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SupportWorker exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SupportWorker exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SupportWorkerPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"role"});

}