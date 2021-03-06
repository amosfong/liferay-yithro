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

package com.liferay.yithro.ticket.service.persistence.impl;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.ticket.exception.NoSuchTicketFlagException;
import com.liferay.yithro.ticket.model.TicketFlag;
import com.liferay.yithro.ticket.model.impl.TicketFlagImpl;
import com.liferay.yithro.ticket.model.impl.TicketFlagModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketFlagPersistence;
import com.liferay.yithro.ticket.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ticket flag service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketFlagPersistence.class)
public class TicketFlagPersistenceImpl
	extends BasePersistenceImpl<TicketFlag> implements TicketFlagPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketFlagUtil</code> to access the ticket flag persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketFlagImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTicketEntryId;
	private FinderPath _finderPathWithoutPaginationFindByTicketEntryId;
	private FinderPath _finderPathCountByTicketEntryId;

	/**
	 * Returns all the ticket flags where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTicketEntryId(long ticketEntryId) {
		return findByTicketEntryId(
			ticketEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket flags where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTicketEntryId(
		long ticketEntryId, int start, int end) {

		return findByTicketEntryId(ticketEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTicketEntryId;
				finderArgs = new Object[] {ticketEntryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTicketEntryId;
			finderArgs = new Object[] {
				ticketEntryId, start, end, orderByComparator
			};
		}

		List<TicketFlag> list = null;

		if (useFinderCache) {
			list = (List<TicketFlag>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketFlag ticketFlag : list) {
					if (ticketEntryId != ticketFlag.getTicketEntryId()) {
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

			query.append(_SQL_SELECT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_TICKETENTRYID_TICKETENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TicketFlagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				list = (List<TicketFlag>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag findByTicketEntryId_First(
			long ticketEntryId, OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = fetchByTicketEntryId_First(
			ticketEntryId, orderByComparator);

		if (ticketFlag != null) {
			return ticketFlag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append("}");

		throw new NoSuchTicketFlagException(msg.toString());
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag fetchByTicketEntryId_First(
		long ticketEntryId, OrderByComparator<TicketFlag> orderByComparator) {

		List<TicketFlag> list = findByTicketEntryId(
			ticketEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag findByTicketEntryId_Last(
			long ticketEntryId, OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = fetchByTicketEntryId_Last(
			ticketEntryId, orderByComparator);

		if (ticketFlag != null) {
			return ticketFlag;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append("}");

		throw new NoSuchTicketFlagException(msg.toString());
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag fetchByTicketEntryId_Last(
		long ticketEntryId, OrderByComparator<TicketFlag> orderByComparator) {

		int count = countByTicketEntryId(ticketEntryId);

		if (count == 0) {
			return null;
		}

		List<TicketFlag> list = findByTicketEntryId(
			ticketEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket flags before and after the current ticket flag in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketFlagId the primary key of the current ticket flag
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	@Override
	public TicketFlag[] findByTicketEntryId_PrevAndNext(
			long ticketFlagId, long ticketEntryId,
			OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = findByPrimaryKey(ticketFlagId);

		Session session = null;

		try {
			session = openSession();

			TicketFlag[] array = new TicketFlagImpl[3];

			array[0] = getByTicketEntryId_PrevAndNext(
				session, ticketFlag, ticketEntryId, orderByComparator, true);

			array[1] = ticketFlag;

			array[2] = getByTicketEntryId_PrevAndNext(
				session, ticketFlag, ticketEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketFlag getByTicketEntryId_PrevAndNext(
		Session session, TicketFlag ticketFlag, long ticketEntryId,
		OrderByComparator<TicketFlag> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TICKETFLAG_WHERE);

		query.append(_FINDER_COLUMN_TICKETENTRYID_TICKETENTRYID_2);

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
			query.append(TicketFlagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketEntryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketFlag)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketFlag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket flags where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	@Override
	public void removeByTicketEntryId(long ticketEntryId) {
		for (TicketFlag ticketFlag :
				findByTicketEntryId(
					ticketEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketFlag);
		}
	}

	/**
	 * Returns the number of ticket flags where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket flags
	 */
	@Override
	public int countByTicketEntryId(long ticketEntryId) {
		FinderPath finderPath = _finderPathCountByTicketEntryId;

		Object[] finderArgs = new Object[] {ticketEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_TICKETENTRYID_TICKETENTRYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TICKETENTRYID_TICKETENTRYID_2 =
		"ticketFlag.ticketEntryId = ?";

	private FinderPath _finderPathWithPaginationFindByTEI_T;
	private FinderPath _finderPathWithoutPaginationFindByTEI_T;
	private FinderPath _finderPathCountByTEI_T;

	/**
	 * Returns all the ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T(long ticketEntryId, int type) {
		return findByTEI_T(
			ticketEntryId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T(
		long ticketEntryId, int type, int start, int end) {

		return findByTEI_T(ticketEntryId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T(
		long ticketEntryId, int type, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return findByTEI_T(
			ticketEntryId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T(
		long ticketEntryId, int type, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTEI_T;
				finderArgs = new Object[] {ticketEntryId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTEI_T;
			finderArgs = new Object[] {
				ticketEntryId, type, start, end, orderByComparator
			};
		}

		List<TicketFlag> list = null;

		if (useFinderCache) {
			list = (List<TicketFlag>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketFlag ticketFlag : list) {
					if ((ticketEntryId != ticketFlag.getTicketEntryId()) ||
						(type != ticketFlag.getType())) {

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

			query.append(_SQL_SELECT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_TEI_T_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_T_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TicketFlagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(type);

				list = (List<TicketFlag>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag findByTEI_T_First(
			long ticketEntryId, int type,
			OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = fetchByTEI_T_First(
			ticketEntryId, type, orderByComparator);

		if (ticketFlag != null) {
			return ticketFlag;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchTicketFlagException(msg.toString());
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag fetchByTEI_T_First(
		long ticketEntryId, int type,
		OrderByComparator<TicketFlag> orderByComparator) {

		List<TicketFlag> list = findByTEI_T(
			ticketEntryId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag findByTEI_T_Last(
			long ticketEntryId, int type,
			OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = fetchByTEI_T_Last(
			ticketEntryId, type, orderByComparator);

		if (ticketFlag != null) {
			return ticketFlag;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append(", type=");
		msg.append(type);

		msg.append("}");

		throw new NoSuchTicketFlagException(msg.toString());
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag fetchByTEI_T_Last(
		long ticketEntryId, int type,
		OrderByComparator<TicketFlag> orderByComparator) {

		int count = countByTEI_T(ticketEntryId, type);

		if (count == 0) {
			return null;
		}

		List<TicketFlag> list = findByTEI_T(
			ticketEntryId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket flags before and after the current ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketFlagId the primary key of the current ticket flag
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	@Override
	public TicketFlag[] findByTEI_T_PrevAndNext(
			long ticketFlagId, long ticketEntryId, int type,
			OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = findByPrimaryKey(ticketFlagId);

		Session session = null;

		try {
			session = openSession();

			TicketFlag[] array = new TicketFlagImpl[3];

			array[0] = getByTEI_T_PrevAndNext(
				session, ticketFlag, ticketEntryId, type, orderByComparator,
				true);

			array[1] = ticketFlag;

			array[2] = getByTEI_T_PrevAndNext(
				session, ticketFlag, ticketEntryId, type, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketFlag getByTEI_T_PrevAndNext(
		Session session, TicketFlag ticketFlag, long ticketEntryId, int type,
		OrderByComparator<TicketFlag> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TICKETFLAG_WHERE);

		query.append(_FINDER_COLUMN_TEI_T_TICKETENTRYID_2);

		query.append(_FINDER_COLUMN_TEI_T_TYPE_2);

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
			query.append(TicketFlagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketEntryId);

		qPos.add(type);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketFlag)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketFlag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket flags where ticketEntryId = &#63; and type = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 */
	@Override
	public void removeByTEI_T(long ticketEntryId, int type) {
		for (TicketFlag ticketFlag :
				findByTEI_T(
					ticketEntryId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketFlag);
		}
	}

	/**
	 * Returns the number of ticket flags where ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the number of matching ticket flags
	 */
	@Override
	public int countByTEI_T(long ticketEntryId, int type) {
		FinderPath finderPath = _finderPathCountByTEI_T;

		Object[] finderArgs = new Object[] {ticketEntryId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_TEI_T_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(type);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TEI_T_TICKETENTRYID_2 =
		"ticketFlag.ticketEntryId = ? AND ";

	private static final String _FINDER_COLUMN_TEI_T_TYPE_2 =
		"ticketFlag.type = ?";

	private FinderPath _finderPathFetchByU_TEI_T;
	private FinderPath _finderPathCountByU_TEI_T;

	/**
	 * Returns the ticket flag where userId = &#63; and ticketEntryId = &#63; and type = &#63; or throws a <code>NoSuchTicketFlagException</code> if it could not be found.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag findByU_TEI_T(long userId, long ticketEntryId, int type)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = fetchByU_TEI_T(userId, ticketEntryId, type);

		if (ticketFlag == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("userId=");
			msg.append(userId);

			msg.append(", ticketEntryId=");
			msg.append(ticketEntryId);

			msg.append(", type=");
			msg.append(type);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTicketFlagException(msg.toString());
		}

		return ticketFlag;
	}

	/**
	 * Returns the ticket flag where userId = &#63; and ticketEntryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag fetchByU_TEI_T(
		long userId, long ticketEntryId, int type) {

		return fetchByU_TEI_T(userId, ticketEntryId, type, true);
	}

	/**
	 * Returns the ticket flag where userId = &#63; and ticketEntryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag fetchByU_TEI_T(
		long userId, long ticketEntryId, int type, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {userId, ticketEntryId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByU_TEI_T, finderArgs, this);
		}

		if (result instanceof TicketFlag) {
			TicketFlag ticketFlag = (TicketFlag)result;

			if ((userId != ticketFlag.getUserId()) ||
				(ticketEntryId != ticketFlag.getTicketEntryId()) ||
				(type != ticketFlag.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_U_TEI_T_USERID_2);

			query.append(_FINDER_COLUMN_U_TEI_T_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_U_TEI_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(ticketEntryId);

				qPos.add(type);

				List<TicketFlag> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByU_TEI_T, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									userId, ticketEntryId, type
								};
							}

							_log.warn(
								"TicketFlagPersistenceImpl.fetchByU_TEI_T(long, long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TicketFlag ticketFlag = list.get(0);

					result = ticketFlag;

					cacheResult(ticketFlag);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByU_TEI_T, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (TicketFlag)result;
		}
	}

	/**
	 * Removes the ticket flag where userId = &#63; and ticketEntryId = &#63; and type = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the ticket flag that was removed
	 */
	@Override
	public TicketFlag removeByU_TEI_T(long userId, long ticketEntryId, int type)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = findByU_TEI_T(userId, ticketEntryId, type);

		return remove(ticketFlag);
	}

	/**
	 * Returns the number of ticket flags where userId = &#63; and ticketEntryId = &#63; and type = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @return the number of matching ticket flags
	 */
	@Override
	public int countByU_TEI_T(long userId, long ticketEntryId, int type) {
		FinderPath finderPath = _finderPathCountByU_TEI_T;

		Object[] finderArgs = new Object[] {userId, ticketEntryId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_U_TEI_T_USERID_2);

			query.append(_FINDER_COLUMN_U_TEI_T_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_U_TEI_T_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(ticketEntryId);

				qPos.add(type);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_TEI_T_USERID_2 =
		"ticketFlag.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_TEI_T_TICKETENTRYID_2 =
		"ticketFlag.ticketEntryId = ? AND ";

	private static final String _FINDER_COLUMN_U_TEI_T_TYPE_2 =
		"ticketFlag.type = ?";

	private FinderPath _finderPathWithPaginationFindByTEI_T_V;
	private FinderPath _finderPathWithoutPaginationFindByTEI_T_V;
	private FinderPath _finderPathCountByTEI_T_V;
	private FinderPath _finderPathWithPaginationCountByTEI_T_V;

	/**
	 * Returns all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @return the matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int type, int value) {

		return findByTEI_T_V(
			ticketEntryId, type, value, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int type, int value, int start, int end) {

		return findByTEI_T_V(ticketEntryId, type, value, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int type, int value, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return findByTEI_T_V(
			ticketEntryId, type, value, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int type, int value, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTEI_T_V;
				finderArgs = new Object[] {ticketEntryId, type, value};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTEI_T_V;
			finderArgs = new Object[] {
				ticketEntryId, type, value, start, end, orderByComparator
			};
		}

		List<TicketFlag> list = null;

		if (useFinderCache) {
			list = (List<TicketFlag>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketFlag ticketFlag : list) {
					if ((ticketEntryId != ticketFlag.getTicketEntryId()) ||
						(type != ticketFlag.getType()) ||
						(value != ticketFlag.getValue())) {

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

			query.append(_SQL_SELECT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_TEI_T_V_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_T_V_TYPE_2);

			query.append(_FINDER_COLUMN_TEI_T_V_VALUE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TicketFlagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(type);

				qPos.add(value);

				list = (List<TicketFlag>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag findByTEI_T_V_First(
			long ticketEntryId, int type, int value,
			OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = fetchByTEI_T_V_First(
			ticketEntryId, type, value, orderByComparator);

		if (ticketFlag != null) {
			return ticketFlag;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append(", type=");
		msg.append(type);

		msg.append(", value=");
		msg.append(value);

		msg.append("}");

		throw new NoSuchTicketFlagException(msg.toString());
	}

	/**
	 * Returns the first ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag fetchByTEI_T_V_First(
		long ticketEntryId, int type, int value,
		OrderByComparator<TicketFlag> orderByComparator) {

		List<TicketFlag> list = findByTEI_T_V(
			ticketEntryId, type, value, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag
	 * @throws NoSuchTicketFlagException if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag findByTEI_T_V_Last(
			long ticketEntryId, int type, int value,
			OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = fetchByTEI_T_V_Last(
			ticketEntryId, type, value, orderByComparator);

		if (ticketFlag != null) {
			return ticketFlag;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append(", type=");
		msg.append(type);

		msg.append(", value=");
		msg.append(value);

		msg.append("}");

		throw new NoSuchTicketFlagException(msg.toString());
	}

	/**
	 * Returns the last ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket flag, or <code>null</code> if a matching ticket flag could not be found
	 */
	@Override
	public TicketFlag fetchByTEI_T_V_Last(
		long ticketEntryId, int type, int value,
		OrderByComparator<TicketFlag> orderByComparator) {

		int count = countByTEI_T_V(ticketEntryId, type, value);

		if (count == 0) {
			return null;
		}

		List<TicketFlag> list = findByTEI_T_V(
			ticketEntryId, type, value, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket flags before and after the current ticket flag in the ordered set where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketFlagId the primary key of the current ticket flag
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	@Override
	public TicketFlag[] findByTEI_T_V_PrevAndNext(
			long ticketFlagId, long ticketEntryId, int type, int value,
			OrderByComparator<TicketFlag> orderByComparator)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = findByPrimaryKey(ticketFlagId);

		Session session = null;

		try {
			session = openSession();

			TicketFlag[] array = new TicketFlagImpl[3];

			array[0] = getByTEI_T_V_PrevAndNext(
				session, ticketFlag, ticketEntryId, type, value,
				orderByComparator, true);

			array[1] = ticketFlag;

			array[2] = getByTEI_T_V_PrevAndNext(
				session, ticketFlag, ticketEntryId, type, value,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketFlag getByTEI_T_V_PrevAndNext(
		Session session, TicketFlag ticketFlag, long ticketEntryId, int type,
		int value, OrderByComparator<TicketFlag> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_TICKETFLAG_WHERE);

		query.append(_FINDER_COLUMN_TEI_T_V_TICKETENTRYID_2);

		query.append(_FINDER_COLUMN_TEI_T_V_TYPE_2);

		query.append(_FINDER_COLUMN_TEI_T_V_VALUE_2);

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
			query.append(TicketFlagModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketEntryId);

		qPos.add(type);

		qPos.add(value);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketFlag)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketFlag> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ticket flags where ticketEntryId = &#63; and type = any &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param types the types
	 * @param value the value
	 * @return the matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int[] types, int value) {

		return findByTEI_T_V(
			ticketEntryId, types, value, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ticket flags where ticketEntryId = &#63; and type = any &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param types the types
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int[] types, int value, int start, int end) {

		return findByTEI_T_V(ticketEntryId, types, value, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = any &#63; and value = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param types the types
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int[] types, int value, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator) {

		return findByTEI_T_V(
			ticketEntryId, types, value, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket flags
	 */
	@Override
	public List<TicketFlag> findByTEI_T_V(
		long ticketEntryId, int[] types, int value, int start, int end,
		OrderByComparator<TicketFlag> orderByComparator,
		boolean useFinderCache) {

		if (types == null) {
			types = new int[0];
		}
		else if (types.length > 1) {
			types = ArrayUtil.sortedUnique(types);
		}

		if (types.length == 1) {
			return findByTEI_T_V(
				ticketEntryId, types[0], value, start, end, orderByComparator);
		}

		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderArgs = new Object[] {
					ticketEntryId, StringUtil.merge(types), value
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				ticketEntryId, StringUtil.merge(types), value, start, end,
				orderByComparator
			};
		}

		List<TicketFlag> list = null;

		if (useFinderCache) {
			list = (List<TicketFlag>)finderCache.getResult(
				_finderPathWithPaginationFindByTEI_T_V, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketFlag ticketFlag : list) {
					if ((ticketEntryId != ticketFlag.getTicketEntryId()) ||
						!ArrayUtil.contains(types, ticketFlag.getType()) ||
						(value != ticketFlag.getValue())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_TEI_T_V_TICKETENTRYID_2);

			if (types.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_TEI_T_V_TYPE_7);

				query.append(StringUtil.merge(types));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_TEI_T_V_VALUE_2);

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(TicketFlagModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(value);

				list = (List<TicketFlag>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByTEI_T_V, finderArgs,
						list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByTEI_T_V, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 */
	@Override
	public void removeByTEI_T_V(long ticketEntryId, int type, int value) {
		for (TicketFlag ticketFlag :
				findByTEI_T_V(
					ticketEntryId, type, value, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(ticketFlag);
		}
	}

	/**
	 * Returns the number of ticket flags where ticketEntryId = &#63; and type = &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param type the type
	 * @param value the value
	 * @return the number of matching ticket flags
	 */
	@Override
	public int countByTEI_T_V(long ticketEntryId, int type, int value) {
		FinderPath finderPath = _finderPathCountByTEI_T_V;

		Object[] finderArgs = new Object[] {ticketEntryId, type, value};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_TEI_T_V_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_T_V_TYPE_2);

			query.append(_FINDER_COLUMN_TEI_T_V_VALUE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(type);

				qPos.add(value);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of ticket flags where ticketEntryId = &#63; and type = any &#63; and value = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param types the types
	 * @param value the value
	 * @return the number of matching ticket flags
	 */
	@Override
	public int countByTEI_T_V(long ticketEntryId, int[] types, int value) {
		if (types == null) {
			types = new int[0];
		}
		else if (types.length > 1) {
			types = ArrayUtil.sortedUnique(types);
		}

		Object[] finderArgs = new Object[] {
			ticketEntryId, StringUtil.merge(types), value
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByTEI_T_V, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TICKETFLAG_WHERE);

			query.append(_FINDER_COLUMN_TEI_T_V_TICKETENTRYID_2);

			if (types.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_TEI_T_V_TYPE_7);

				query.append(StringUtil.merge(types));

				query.append(")");

				query.append(")");

				query.append(WHERE_AND);
			}

			query.append(_FINDER_COLUMN_TEI_T_V_VALUE_2);

			query.setStringAt(
				removeConjunction(query.stringAt(query.index() - 1)),
				query.index() - 1);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(value);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByTEI_T_V, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByTEI_T_V, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TEI_T_V_TICKETENTRYID_2 =
		"ticketFlag.ticketEntryId = ? AND ";

	private static final String _FINDER_COLUMN_TEI_T_V_TYPE_2 =
		"ticketFlag.type = ? AND ";

	private static final String _FINDER_COLUMN_TEI_T_V_TYPE_7 =
		"ticketFlag.type IN (";

	private static final String _FINDER_COLUMN_TEI_T_V_VALUE_2 =
		"ticketFlag.value = ?";

	public TicketFlagPersistenceImpl() {
		setModelClass(TicketFlag.class);

		setModelImplClass(TicketFlagImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ticket flag in the entity cache if it is enabled.
	 *
	 * @param ticketFlag the ticket flag
	 */
	@Override
	public void cacheResult(TicketFlag ticketFlag) {
		entityCache.putResult(
			entityCacheEnabled, TicketFlagImpl.class,
			ticketFlag.getPrimaryKey(), ticketFlag);

		finderCache.putResult(
			_finderPathFetchByU_TEI_T,
			new Object[] {
				ticketFlag.getUserId(), ticketFlag.getTicketEntryId(),
				ticketFlag.getType()
			},
			ticketFlag);

		ticketFlag.resetOriginalValues();
	}

	/**
	 * Caches the ticket flags in the entity cache if it is enabled.
	 *
	 * @param ticketFlags the ticket flags
	 */
	@Override
	public void cacheResult(List<TicketFlag> ticketFlags) {
		for (TicketFlag ticketFlag : ticketFlags) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketFlagImpl.class,
					ticketFlag.getPrimaryKey()) == null) {

				cacheResult(ticketFlag);
			}
			else {
				ticketFlag.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket flags.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketFlagImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket flag.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketFlag ticketFlag) {
		entityCache.removeResult(
			entityCacheEnabled, TicketFlagImpl.class,
			ticketFlag.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TicketFlagModelImpl)ticketFlag, true);
	}

	@Override
	public void clearCache(List<TicketFlag> ticketFlags) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketFlag ticketFlag : ticketFlags) {
			entityCache.removeResult(
				entityCacheEnabled, TicketFlagImpl.class,
				ticketFlag.getPrimaryKey());

			clearUniqueFindersCache((TicketFlagModelImpl)ticketFlag, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, TicketFlagImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TicketFlagModelImpl ticketFlagModelImpl) {

		Object[] args = new Object[] {
			ticketFlagModelImpl.getUserId(),
			ticketFlagModelImpl.getTicketEntryId(),
			ticketFlagModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountByU_TEI_T, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByU_TEI_T, args, ticketFlagModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TicketFlagModelImpl ticketFlagModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				ticketFlagModelImpl.getUserId(),
				ticketFlagModelImpl.getTicketEntryId(),
				ticketFlagModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByU_TEI_T, args);
			finderCache.removeResult(_finderPathFetchByU_TEI_T, args);
		}

		if ((ticketFlagModelImpl.getColumnBitmask() &
			 _finderPathFetchByU_TEI_T.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ticketFlagModelImpl.getOriginalUserId(),
				ticketFlagModelImpl.getOriginalTicketEntryId(),
				ticketFlagModelImpl.getOriginalType()
			};

			finderCache.removeResult(_finderPathCountByU_TEI_T, args);
			finderCache.removeResult(_finderPathFetchByU_TEI_T, args);
		}
	}

	/**
	 * Creates a new ticket flag with the primary key. Does not add the ticket flag to the database.
	 *
	 * @param ticketFlagId the primary key for the new ticket flag
	 * @return the new ticket flag
	 */
	@Override
	public TicketFlag create(long ticketFlagId) {
		TicketFlag ticketFlag = new TicketFlagImpl();

		ticketFlag.setNew(true);
		ticketFlag.setPrimaryKey(ticketFlagId);

		ticketFlag.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ticketFlag;
	}

	/**
	 * Removes the ticket flag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFlagId the primary key of the ticket flag
	 * @return the ticket flag that was removed
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	@Override
	public TicketFlag remove(long ticketFlagId)
		throws NoSuchTicketFlagException {

		return remove((Serializable)ticketFlagId);
	}

	/**
	 * Removes the ticket flag with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket flag
	 * @return the ticket flag that was removed
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	@Override
	public TicketFlag remove(Serializable primaryKey)
		throws NoSuchTicketFlagException {

		Session session = null;

		try {
			session = openSession();

			TicketFlag ticketFlag = (TicketFlag)session.get(
				TicketFlagImpl.class, primaryKey);

			if (ticketFlag == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketFlagException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketFlag);
		}
		catch (NoSuchTicketFlagException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TicketFlag removeImpl(TicketFlag ticketFlag) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketFlag)) {
				ticketFlag = (TicketFlag)session.get(
					TicketFlagImpl.class, ticketFlag.getPrimaryKeyObj());
			}

			if (ticketFlag != null) {
				session.delete(ticketFlag);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ticketFlag != null) {
			clearCache(ticketFlag);
		}

		return ticketFlag;
	}

	@Override
	public TicketFlag updateImpl(TicketFlag ticketFlag) {
		boolean isNew = ticketFlag.isNew();

		if (!(ticketFlag instanceof TicketFlagModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketFlag.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ticketFlag);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketFlag proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketFlag implementation " +
					ticketFlag.getClass());
		}

		TicketFlagModelImpl ticketFlagModelImpl =
			(TicketFlagModelImpl)ticketFlag;

		Session session = null;

		try {
			session = openSession();

			if (ticketFlag.isNew()) {
				session.save(ticketFlag);

				ticketFlag.setNew(false);
			}
			else {
				ticketFlag = (TicketFlag)session.merge(ticketFlag);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
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
				ticketFlagModelImpl.getTicketEntryId()
			};

			finderCache.removeResult(_finderPathCountByTicketEntryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTicketEntryId, args);

			args = new Object[] {
				ticketFlagModelImpl.getTicketEntryId(),
				ticketFlagModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByTEI_T, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTEI_T, args);

			args = new Object[] {
				ticketFlagModelImpl.getTicketEntryId(),
				ticketFlagModelImpl.getType(), ticketFlagModelImpl.getValue()
			};

			finderCache.removeResult(_finderPathCountByTEI_T_V, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTEI_T_V, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ticketFlagModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTicketEntryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ticketFlagModelImpl.getOriginalTicketEntryId()
				};

				finderCache.removeResult(_finderPathCountByTicketEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketEntryId, args);

				args = new Object[] {ticketFlagModelImpl.getTicketEntryId()};

				finderCache.removeResult(_finderPathCountByTicketEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketEntryId, args);
			}

			if ((ticketFlagModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTEI_T.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ticketFlagModelImpl.getOriginalTicketEntryId(),
					ticketFlagModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByTEI_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTEI_T, args);

				args = new Object[] {
					ticketFlagModelImpl.getTicketEntryId(),
					ticketFlagModelImpl.getType()
				};

				finderCache.removeResult(_finderPathCountByTEI_T, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTEI_T, args);
			}

			if ((ticketFlagModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTEI_T_V.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ticketFlagModelImpl.getOriginalTicketEntryId(),
					ticketFlagModelImpl.getOriginalType(),
					ticketFlagModelImpl.getOriginalValue()
				};

				finderCache.removeResult(_finderPathCountByTEI_T_V, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTEI_T_V, args);

				args = new Object[] {
					ticketFlagModelImpl.getTicketEntryId(),
					ticketFlagModelImpl.getType(),
					ticketFlagModelImpl.getValue()
				};

				finderCache.removeResult(_finderPathCountByTEI_T_V, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTEI_T_V, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TicketFlagImpl.class,
			ticketFlag.getPrimaryKey(), ticketFlag, false);

		clearUniqueFindersCache(ticketFlagModelImpl, false);
		cacheUniqueFindersCache(ticketFlagModelImpl);

		ticketFlag.resetOriginalValues();

		return ticketFlag;
	}

	/**
	 * Returns the ticket flag with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket flag
	 * @return the ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	@Override
	public TicketFlag findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketFlagException {

		TicketFlag ticketFlag = fetchByPrimaryKey(primaryKey);

		if (ticketFlag == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketFlagException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketFlag;
	}

	/**
	 * Returns the ticket flag with the primary key or throws a <code>NoSuchTicketFlagException</code> if it could not be found.
	 *
	 * @param ticketFlagId the primary key of the ticket flag
	 * @return the ticket flag
	 * @throws NoSuchTicketFlagException if a ticket flag with the primary key could not be found
	 */
	@Override
	public TicketFlag findByPrimaryKey(long ticketFlagId)
		throws NoSuchTicketFlagException {

		return findByPrimaryKey((Serializable)ticketFlagId);
	}

	/**
	 * Returns the ticket flag with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFlagId the primary key of the ticket flag
	 * @return the ticket flag, or <code>null</code> if a ticket flag with the primary key could not be found
	 */
	@Override
	public TicketFlag fetchByPrimaryKey(long ticketFlagId) {
		return fetchByPrimaryKey((Serializable)ticketFlagId);
	}

	/**
	 * Returns all the ticket flags.
	 *
	 * @return the ticket flags
	 */
	@Override
	public List<TicketFlag> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket flags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @return the range of ticket flags
	 */
	@Override
	public List<TicketFlag> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket flags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket flags
	 */
	@Override
	public List<TicketFlag> findAll(
		int start, int end, OrderByComparator<TicketFlag> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket flags.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketFlagModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket flags
	 * @param end the upper bound of the range of ticket flags (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket flags
	 */
	@Override
	public List<TicketFlag> findAll(
		int start, int end, OrderByComparator<TicketFlag> orderByComparator,
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

		List<TicketFlag> list = null;

		if (useFinderCache) {
			list = (List<TicketFlag>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETFLAG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETFLAG;

				sql = sql.concat(TicketFlagModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<TicketFlag>)QueryUtil.list(
					q, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ticket flags from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketFlag ticketFlag : findAll()) {
			remove(ticketFlag);
		}
	}

	/**
	 * Returns the number of ticket flags.
	 *
	 * @return the number of ticket flags
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETFLAG);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
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
		return "ticketFlagId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETFLAG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketFlagModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket flag persistence.
	 */
	@Activate
	public void activate() {
		TicketFlagModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketFlagModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTicketEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTicketEntryId",
			new String[] {Long.class.getName()},
			TicketFlagModelImpl.TICKETENTRYID_COLUMN_BITMASK);

		_finderPathCountByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketEntryId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTEI_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTEI_T",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTEI_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTEI_T",
			new String[] {Long.class.getName(), Integer.class.getName()},
			TicketFlagModelImpl.TICKETENTRYID_COLUMN_BITMASK |
			TicketFlagModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByTEI_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTEI_T",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathFetchByU_TEI_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByU_TEI_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			TicketFlagModelImpl.USERID_COLUMN_BITMASK |
			TicketFlagModelImpl.TICKETENTRYID_COLUMN_BITMASK |
			TicketFlagModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByU_TEI_T = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_TEI_T",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationFindByTEI_T_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTEI_T_V",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTEI_T_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFlagImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTEI_T_V",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			},
			TicketFlagModelImpl.TICKETENTRYID_COLUMN_BITMASK |
			TicketFlagModelImpl.TYPE_COLUMN_BITMASK |
			TicketFlagModelImpl.VALUE_COLUMN_BITMASK);

		_finderPathCountByTEI_T_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTEI_T_V",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});

		_finderPathWithPaginationCountByTEI_T_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTEI_T_V",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName()
			});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketFlagImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketFlag"),
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

	private static final String _SQL_SELECT_TICKETFLAG =
		"SELECT ticketFlag FROM TicketFlag ticketFlag";

	private static final String _SQL_SELECT_TICKETFLAG_WHERE =
		"SELECT ticketFlag FROM TicketFlag ticketFlag WHERE ";

	private static final String _SQL_COUNT_TICKETFLAG =
		"SELECT COUNT(ticketFlag) FROM TicketFlag ticketFlag";

	private static final String _SQL_COUNT_TICKETFLAG_WHERE =
		"SELECT COUNT(ticketFlag) FROM TicketFlag ticketFlag WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketFlag.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketFlag exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketFlag exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketFlagPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}