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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.yithro.ticket.exception.NoSuchTicketStatusException;
import com.liferay.yithro.ticket.model.TicketStatus;
import com.liferay.yithro.ticket.model.impl.TicketStatusImpl;
import com.liferay.yithro.ticket.model.impl.TicketStatusModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketStatusPersistence;
import com.liferay.yithro.ticket.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the ticket status service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketStatusPersistence.class)
@ProviderType
public class TicketStatusPersistenceImpl
	extends BasePersistenceImpl<TicketStatus>
	implements TicketStatusPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketStatusUtil</code> to access the ticket status persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketStatusImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByS;
	private FinderPath _finderPathWithoutPaginationFindByS;
	private FinderPath _finderPathCountByS;

	/**
	 * Returns all the ticket statuses where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ticket statuses
	 */
	@Override
	public List<TicketStatus> findByS(int status) {
		return findByS(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of matching ticket statuses
	 */
	@Override
	public List<TicketStatus> findByS(int status, int start, int end) {
		return findByS(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket statuses
	 */
	@Override
	public List<TicketStatus> findByS(
		int status, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator) {

		return findByS(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket statuses where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket statuses
	 */
	@Override
	public List<TicketStatus> findByS(
		int status, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByS;
			finderArgs = new Object[] {status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByS;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<TicketStatus> list = null;

		if (retrieveFromCache) {
			list = (List<TicketStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketStatus ticketStatus : list) {
					if ((status != ticketStatus.getStatus())) {
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

			query.append(_SQL_SELECT_TICKETSTATUS_WHERE);

			query.append(_FINDER_COLUMN_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<TicketStatus>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketStatus>)QueryUtil.list(
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
	 * Returns the first ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	@Override
	public TicketStatus findByS_First(
			int status, OrderByComparator<TicketStatus> orderByComparator)
		throws NoSuchTicketStatusException {

		TicketStatus ticketStatus = fetchByS_First(status, orderByComparator);

		if (ticketStatus != null) {
			return ticketStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTicketStatusException(msg.toString());
	}

	/**
	 * Returns the first ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	@Override
	public TicketStatus fetchByS_First(
		int status, OrderByComparator<TicketStatus> orderByComparator) {

		List<TicketStatus> list = findByS(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	@Override
	public TicketStatus findByS_Last(
			int status, OrderByComparator<TicketStatus> orderByComparator)
		throws NoSuchTicketStatusException {

		TicketStatus ticketStatus = fetchByS_Last(status, orderByComparator);

		if (ticketStatus != null) {
			return ticketStatus;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTicketStatusException(msg.toString());
	}

	/**
	 * Returns the last ticket status in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	@Override
	public TicketStatus fetchByS_Last(
		int status, OrderByComparator<TicketStatus> orderByComparator) {

		int count = countByS(status);

		if (count == 0) {
			return null;
		}

		List<TicketStatus> list = findByS(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket statuses before and after the current ticket status in the ordered set where status = &#63;.
	 *
	 * @param ticketStatusId the primary key of the current ticket status
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	@Override
	public TicketStatus[] findByS_PrevAndNext(
			long ticketStatusId, int status,
			OrderByComparator<TicketStatus> orderByComparator)
		throws NoSuchTicketStatusException {

		TicketStatus ticketStatus = findByPrimaryKey(ticketStatusId);

		Session session = null;

		try {
			session = openSession();

			TicketStatus[] array = new TicketStatusImpl[3];

			array[0] = getByS_PrevAndNext(
				session, ticketStatus, status, orderByComparator, true);

			array[1] = ticketStatus;

			array[2] = getByS_PrevAndNext(
				session, ticketStatus, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketStatus getByS_PrevAndNext(
		Session session, TicketStatus ticketStatus, int status,
		OrderByComparator<TicketStatus> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TICKETSTATUS_WHERE);

		query.append(_FINDER_COLUMN_S_STATUS_2);

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
			query.append(TicketStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketStatus)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket statuses where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByS(int status) {
		for (TicketStatus ticketStatus :
				findByS(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ticketStatus);
		}
	}

	/**
	 * Returns the number of ticket statuses where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ticket statuses
	 */
	@Override
	public int countByS(int status) {
		FinderPath finderPath = _finderPathCountByS;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETSTATUS_WHERE);

			query.append(_FINDER_COLUMN_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_S_STATUS_2 =
		"ticketStatus.status = ?";

	private FinderPath _finderPathWithPaginationFindByT_S;
	private FinderPath _finderPathWithoutPaginationFindByT_S;
	private FinderPath _finderPathCountByT_S;

	/**
	 * Returns all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @return the matching ticket statuses
	 */
	@Override
	public List<TicketStatus> findByT_S(boolean terminal, int status) {
		return findByT_S(
			terminal, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of matching ticket statuses
	 */
	@Override
	public List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end) {

		return findByT_S(terminal, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket statuses
	 */
	@Override
	public List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator) {

		return findByT_S(terminal, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket statuses
	 */
	@Override
	public List<TicketStatus> findByT_S(
		boolean terminal, int status, int start, int end,
		OrderByComparator<TicketStatus> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByT_S;
			finderArgs = new Object[] {terminal, status};
		}
		else {
			finderPath = _finderPathWithPaginationFindByT_S;
			finderArgs = new Object[] {
				terminal, status, start, end, orderByComparator
			};
		}

		List<TicketStatus> list = null;

		if (retrieveFromCache) {
			list = (List<TicketStatus>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketStatus ticketStatus : list) {
					if ((terminal != ticketStatus.isTerminal()) ||
						(status != ticketStatus.getStatus())) {

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

			query.append(_SQL_SELECT_TICKETSTATUS_WHERE);

			query.append(_FINDER_COLUMN_T_S_TERMINAL_2);

			query.append(_FINDER_COLUMN_T_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketStatusModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(terminal);

				qPos.add(status);

				if (!pagination) {
					list = (List<TicketStatus>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketStatus>)QueryUtil.list(
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
	 * Returns the first ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	@Override
	public TicketStatus findByT_S_First(
			boolean terminal, int status,
			OrderByComparator<TicketStatus> orderByComparator)
		throws NoSuchTicketStatusException {

		TicketStatus ticketStatus = fetchByT_S_First(
			terminal, status, orderByComparator);

		if (ticketStatus != null) {
			return ticketStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("terminal=");
		msg.append(terminal);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTicketStatusException(msg.toString());
	}

	/**
	 * Returns the first ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	@Override
	public TicketStatus fetchByT_S_First(
		boolean terminal, int status,
		OrderByComparator<TicketStatus> orderByComparator) {

		List<TicketStatus> list = findByT_S(
			terminal, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status
	 * @throws NoSuchTicketStatusException if a matching ticket status could not be found
	 */
	@Override
	public TicketStatus findByT_S_Last(
			boolean terminal, int status,
			OrderByComparator<TicketStatus> orderByComparator)
		throws NoSuchTicketStatusException {

		TicketStatus ticketStatus = fetchByT_S_Last(
			terminal, status, orderByComparator);

		if (ticketStatus != null) {
			return ticketStatus;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("terminal=");
		msg.append(terminal);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTicketStatusException(msg.toString());
	}

	/**
	 * Returns the last ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket status, or <code>null</code> if a matching ticket status could not be found
	 */
	@Override
	public TicketStatus fetchByT_S_Last(
		boolean terminal, int status,
		OrderByComparator<TicketStatus> orderByComparator) {

		int count = countByT_S(terminal, status);

		if (count == 0) {
			return null;
		}

		List<TicketStatus> list = findByT_S(
			terminal, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket statuses before and after the current ticket status in the ordered set where terminal = &#63; and status = &#63;.
	 *
	 * @param ticketStatusId the primary key of the current ticket status
	 * @param terminal the terminal
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	@Override
	public TicketStatus[] findByT_S_PrevAndNext(
			long ticketStatusId, boolean terminal, int status,
			OrderByComparator<TicketStatus> orderByComparator)
		throws NoSuchTicketStatusException {

		TicketStatus ticketStatus = findByPrimaryKey(ticketStatusId);

		Session session = null;

		try {
			session = openSession();

			TicketStatus[] array = new TicketStatusImpl[3];

			array[0] = getByT_S_PrevAndNext(
				session, ticketStatus, terminal, status, orderByComparator,
				true);

			array[1] = ticketStatus;

			array[2] = getByT_S_PrevAndNext(
				session, ticketStatus, terminal, status, orderByComparator,
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

	protected TicketStatus getByT_S_PrevAndNext(
		Session session, TicketStatus ticketStatus, boolean terminal,
		int status, OrderByComparator<TicketStatus> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_TICKETSTATUS_WHERE);

		query.append(_FINDER_COLUMN_T_S_TERMINAL_2);

		query.append(_FINDER_COLUMN_T_S_STATUS_2);

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
			query.append(TicketStatusModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(terminal);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketStatus)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketStatus> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket statuses where terminal = &#63; and status = &#63; from the database.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 */
	@Override
	public void removeByT_S(boolean terminal, int status) {
		for (TicketStatus ticketStatus :
				findByT_S(
					terminal, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketStatus);
		}
	}

	/**
	 * Returns the number of ticket statuses where terminal = &#63; and status = &#63;.
	 *
	 * @param terminal the terminal
	 * @param status the status
	 * @return the number of matching ticket statuses
	 */
	@Override
	public int countByT_S(boolean terminal, int status) {
		FinderPath finderPath = _finderPathCountByT_S;

		Object[] finderArgs = new Object[] {terminal, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TICKETSTATUS_WHERE);

			query.append(_FINDER_COLUMN_T_S_TERMINAL_2);

			query.append(_FINDER_COLUMN_T_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(terminal);

				qPos.add(status);

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

	private static final String _FINDER_COLUMN_T_S_TERMINAL_2 =
		"ticketStatus.terminal = ? AND ";

	private static final String _FINDER_COLUMN_T_S_STATUS_2 =
		"ticketStatus.status = ?";

	public TicketStatusPersistenceImpl() {
		setModelClass(TicketStatus.class);

		setModelImplClass(TicketStatusImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ticket status in the entity cache if it is enabled.
	 *
	 * @param ticketStatus the ticket status
	 */
	@Override
	public void cacheResult(TicketStatus ticketStatus) {
		entityCache.putResult(
			entityCacheEnabled, TicketStatusImpl.class,
			ticketStatus.getPrimaryKey(), ticketStatus);

		ticketStatus.resetOriginalValues();
	}

	/**
	 * Caches the ticket statuses in the entity cache if it is enabled.
	 *
	 * @param ticketStatuses the ticket statuses
	 */
	@Override
	public void cacheResult(List<TicketStatus> ticketStatuses) {
		for (TicketStatus ticketStatus : ticketStatuses) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketStatusImpl.class,
					ticketStatus.getPrimaryKey()) == null) {

				cacheResult(ticketStatus);
			}
			else {
				ticketStatus.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket statuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketStatusImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket status.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketStatus ticketStatus) {
		entityCache.removeResult(
			entityCacheEnabled, TicketStatusImpl.class,
			ticketStatus.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TicketStatus> ticketStatuses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketStatus ticketStatus : ticketStatuses) {
			entityCache.removeResult(
				entityCacheEnabled, TicketStatusImpl.class,
				ticketStatus.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ticket status with the primary key. Does not add the ticket status to the database.
	 *
	 * @param ticketStatusId the primary key for the new ticket status
	 * @return the new ticket status
	 */
	@Override
	public TicketStatus create(long ticketStatusId) {
		TicketStatus ticketStatus = new TicketStatusImpl();

		ticketStatus.setNew(true);
		ticketStatus.setPrimaryKey(ticketStatusId);

		ticketStatus.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ticketStatus;
	}

	/**
	 * Removes the ticket status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status that was removed
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	@Override
	public TicketStatus remove(long ticketStatusId)
		throws NoSuchTicketStatusException {

		return remove((Serializable)ticketStatusId);
	}

	/**
	 * Removes the ticket status with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket status
	 * @return the ticket status that was removed
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	@Override
	public TicketStatus remove(Serializable primaryKey)
		throws NoSuchTicketStatusException {

		Session session = null;

		try {
			session = openSession();

			TicketStatus ticketStatus = (TicketStatus)session.get(
				TicketStatusImpl.class, primaryKey);

			if (ticketStatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketStatusException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketStatus);
		}
		catch (NoSuchTicketStatusException nsee) {
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
	protected TicketStatus removeImpl(TicketStatus ticketStatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketStatus)) {
				ticketStatus = (TicketStatus)session.get(
					TicketStatusImpl.class, ticketStatus.getPrimaryKeyObj());
			}

			if (ticketStatus != null) {
				session.delete(ticketStatus);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketStatus != null) {
			clearCache(ticketStatus);
		}

		return ticketStatus;
	}

	@Override
	public TicketStatus updateImpl(TicketStatus ticketStatus) {
		boolean isNew = ticketStatus.isNew();

		if (!(ticketStatus instanceof TicketStatusModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketStatus.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ticketStatus);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketStatus proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketStatus implementation " +
					ticketStatus.getClass());
		}

		TicketStatusModelImpl ticketStatusModelImpl =
			(TicketStatusModelImpl)ticketStatus;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ticketStatus.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketStatus.setCreateDate(now);
			}
			else {
				ticketStatus.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ticketStatusModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketStatus.setModifiedDate(now);
			}
			else {
				ticketStatus.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ticketStatus.isNew()) {
				session.save(ticketStatus);

				ticketStatus.setNew(false);
			}
			else {
				ticketStatus = (TicketStatus)session.merge(ticketStatus);
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
			Object[] args = new Object[] {ticketStatusModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByS, args);
			finderCache.removeResult(_finderPathWithoutPaginationFindByS, args);

			args = new Object[] {
				ticketStatusModelImpl.isTerminal(),
				ticketStatusModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByT_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByT_S, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ticketStatusModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByS.getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ticketStatusModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByS, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS, args);

				args = new Object[] {ticketStatusModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByS, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByS, args);
			}

			if ((ticketStatusModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByT_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ticketStatusModelImpl.getOriginalTerminal(),
					ticketStatusModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByT_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByT_S, args);

				args = new Object[] {
					ticketStatusModelImpl.isTerminal(),
					ticketStatusModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByT_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByT_S, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TicketStatusImpl.class,
			ticketStatus.getPrimaryKey(), ticketStatus, false);

		ticketStatus.resetOriginalValues();

		return ticketStatus;
	}

	/**
	 * Returns the ticket status with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket status
	 * @return the ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	@Override
	public TicketStatus findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketStatusException {

		TicketStatus ticketStatus = fetchByPrimaryKey(primaryKey);

		if (ticketStatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketStatusException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketStatus;
	}

	/**
	 * Returns the ticket status with the primary key or throws a <code>NoSuchTicketStatusException</code> if it could not be found.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status
	 * @throws NoSuchTicketStatusException if a ticket status with the primary key could not be found
	 */
	@Override
	public TicketStatus findByPrimaryKey(long ticketStatusId)
		throws NoSuchTicketStatusException {

		return findByPrimaryKey((Serializable)ticketStatusId);
	}

	/**
	 * Returns the ticket status with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketStatusId the primary key of the ticket status
	 * @return the ticket status, or <code>null</code> if a ticket status with the primary key could not be found
	 */
	@Override
	public TicketStatus fetchByPrimaryKey(long ticketStatusId) {
		return fetchByPrimaryKey((Serializable)ticketStatusId);
	}

	/**
	 * Returns all the ticket statuses.
	 *
	 * @return the ticket statuses
	 */
	@Override
	public List<TicketStatus> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @return the range of ticket statuses
	 */
	@Override
	public List<TicketStatus> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket statuses
	 */
	@Override
	public List<TicketStatus> findAll(
		int start, int end, OrderByComparator<TicketStatus> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket statuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStatusModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket statuses
	 * @param end the upper bound of the range of ticket statuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket statuses
	 */
	@Override
	public List<TicketStatus> findAll(
		int start, int end, OrderByComparator<TicketStatus> orderByComparator,
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

		List<TicketStatus> list = null;

		if (retrieveFromCache) {
			list = (List<TicketStatus>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETSTATUS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETSTATUS;

				if (pagination) {
					sql = sql.concat(TicketStatusModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketStatus>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketStatus>)QueryUtil.list(
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
	 * Removes all the ticket statuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketStatus ticketStatus : findAll()) {
			remove(ticketStatus);
		}
	}

	/**
	 * Returns the number of ticket statuses.
	 *
	 * @return the number of ticket statuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETSTATUS);

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
		return "ticketStatusId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketStatusModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket status persistence.
	 */
	@Activate
	public void activate() {
		TicketStatusModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketStatusModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByS",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByS",
			new String[] {Integer.class.getName()},
			TicketStatusModelImpl.STATUS_COLUMN_BITMASK |
			TicketStatusModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByS = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByS",
			new String[] {Integer.class.getName()});

		_finderPathWithPaginationFindByT_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByT_S",
			new String[] {
				Boolean.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByT_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketStatusImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByT_S",
			new String[] {Boolean.class.getName(), Integer.class.getName()},
			TicketStatusModelImpl.TERMINAL_COLUMN_BITMASK |
			TicketStatusModelImpl.STATUS_COLUMN_BITMASK |
			TicketStatusModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByT_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByT_S",
			new String[] {Boolean.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketStatusImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketStatus"),
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

	private static final String _SQL_SELECT_TICKETSTATUS =
		"SELECT ticketStatus FROM TicketStatus ticketStatus";

	private static final String _SQL_SELECT_TICKETSTATUS_WHERE =
		"SELECT ticketStatus FROM TicketStatus ticketStatus WHERE ";

	private static final String _SQL_COUNT_TICKETSTATUS =
		"SELECT COUNT(ticketStatus) FROM TicketStatus ticketStatus";

	private static final String _SQL_COUNT_TICKETSTATUS_WHERE =
		"SELECT COUNT(ticketStatus) FROM TicketStatus ticketStatus WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketStatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketStatus exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketStatus exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketStatusPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"order"});

}