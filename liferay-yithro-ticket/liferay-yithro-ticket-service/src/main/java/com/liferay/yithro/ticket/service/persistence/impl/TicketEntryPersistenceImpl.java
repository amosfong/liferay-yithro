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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.ticket.exception.NoSuchTicketEntryException;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.model.impl.TicketEntryImpl;
import com.liferay.yithro.ticket.model.impl.TicketEntryModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketEntryPersistence;
import com.liferay.yithro.ticket.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ticket entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketEntryPersistence.class)
public class TicketEntryPersistenceImpl
	extends BasePersistenceImpl<TicketEntry> implements TicketEntryPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketEntryUtil</code> to access the ticket entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketEntryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGtModifiedDate;
	private FinderPath _finderPathWithPaginationCountByGtModifiedDate;

	/**
	 * Returns all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @return the matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByGtModifiedDate(Date modifiedDate) {
		return findByGtModifiedDate(
			modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end) {

		return findByGtModifiedDate(modifiedDate, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator) {

		return findByGtModifiedDate(
			modifiedDate, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket entries where modifiedDate &ge; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param modifiedDate the modified date
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByGtModifiedDate(
		Date modifiedDate, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByGtModifiedDate;
		finderArgs = new Object[] {
			_getTime(modifiedDate), start, end, orderByComparator
		};

		List<TicketEntry> list = null;

		if (useFinderCache) {
			list = (List<TicketEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketEntry ticketEntry : list) {
					if ((modifiedDate.getTime() >
							ticketEntry.getModifiedDate().getTime())) {

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

			query.append(_SQL_SELECT_TICKETENTRY_WHERE);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_GTMODIFIEDDATE_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_GTMODIFIEDDATE_MODIFIEDDATE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModifiedDate) {
					qPos.add(new Timestamp(modifiedDate.getTime()));
				}

				if (!pagination) {
					list = (List<TicketEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketEntry>)QueryUtil.list(
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
	 * Returns the first ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	@Override
	public TicketEntry findByGtModifiedDate_First(
			Date modifiedDate, OrderByComparator<TicketEntry> orderByComparator)
		throws NoSuchTicketEntryException {

		TicketEntry ticketEntry = fetchByGtModifiedDate_First(
			modifiedDate, orderByComparator);

		if (ticketEntry != null) {
			return ticketEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("modifiedDate>=");
		msg.append(modifiedDate);

		msg.append("}");

		throw new NoSuchTicketEntryException(msg.toString());
	}

	/**
	 * Returns the first ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	@Override
	public TicketEntry fetchByGtModifiedDate_First(
		Date modifiedDate, OrderByComparator<TicketEntry> orderByComparator) {

		List<TicketEntry> list = findByGtModifiedDate(
			modifiedDate, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	@Override
	public TicketEntry findByGtModifiedDate_Last(
			Date modifiedDate, OrderByComparator<TicketEntry> orderByComparator)
		throws NoSuchTicketEntryException {

		TicketEntry ticketEntry = fetchByGtModifiedDate_Last(
			modifiedDate, orderByComparator);

		if (ticketEntry != null) {
			return ticketEntry;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("modifiedDate>=");
		msg.append(modifiedDate);

		msg.append("}");

		throw new NoSuchTicketEntryException(msg.toString());
	}

	/**
	 * Returns the last ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	@Override
	public TicketEntry fetchByGtModifiedDate_Last(
		Date modifiedDate, OrderByComparator<TicketEntry> orderByComparator) {

		int count = countByGtModifiedDate(modifiedDate);

		if (count == 0) {
			return null;
		}

		List<TicketEntry> list = findByGtModifiedDate(
			modifiedDate, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket entries before and after the current ticket entry in the ordered set where modifiedDate &ge; &#63;.
	 *
	 * @param ticketEntryId the primary key of the current ticket entry
	 * @param modifiedDate the modified date
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	@Override
	public TicketEntry[] findByGtModifiedDate_PrevAndNext(
			long ticketEntryId, Date modifiedDate,
			OrderByComparator<TicketEntry> orderByComparator)
		throws NoSuchTicketEntryException {

		TicketEntry ticketEntry = findByPrimaryKey(ticketEntryId);

		Session session = null;

		try {
			session = openSession();

			TicketEntry[] array = new TicketEntryImpl[3];

			array[0] = getByGtModifiedDate_PrevAndNext(
				session, ticketEntry, modifiedDate, orderByComparator, true);

			array[1] = ticketEntry;

			array[2] = getByGtModifiedDate_PrevAndNext(
				session, ticketEntry, modifiedDate, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketEntry getByGtModifiedDate_PrevAndNext(
		Session session, TicketEntry ticketEntry, Date modifiedDate,
		OrderByComparator<TicketEntry> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TICKETENTRY_WHERE);

		boolean bindModifiedDate = false;

		if (modifiedDate == null) {
			query.append(_FINDER_COLUMN_GTMODIFIEDDATE_MODIFIEDDATE_1);
		}
		else {
			bindModifiedDate = true;

			query.append(_FINDER_COLUMN_GTMODIFIEDDATE_MODIFIEDDATE_2);
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
			query.append(TicketEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindModifiedDate) {
			qPos.add(new Timestamp(modifiedDate.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket entries where modifiedDate &ge; &#63; from the database.
	 *
	 * @param modifiedDate the modified date
	 */
	@Override
	public void removeByGtModifiedDate(Date modifiedDate) {
		for (TicketEntry ticketEntry :
				findByGtModifiedDate(
					modifiedDate, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ticketEntry);
		}
	}

	/**
	 * Returns the number of ticket entries where modifiedDate &ge; &#63;.
	 *
	 * @param modifiedDate the modified date
	 * @return the number of matching ticket entries
	 */
	@Override
	public int countByGtModifiedDate(Date modifiedDate) {
		FinderPath finderPath = _finderPathWithPaginationCountByGtModifiedDate;

		Object[] finderArgs = new Object[] {_getTime(modifiedDate)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETENTRY_WHERE);

			boolean bindModifiedDate = false;

			if (modifiedDate == null) {
				query.append(_FINDER_COLUMN_GTMODIFIEDDATE_MODIFIEDDATE_1);
			}
			else {
				bindModifiedDate = true;

				query.append(_FINDER_COLUMN_GTMODIFIEDDATE_MODIFIEDDATE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindModifiedDate) {
					qPos.add(new Timestamp(modifiedDate.getTime()));
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

	private static final String _FINDER_COLUMN_GTMODIFIEDDATE_MODIFIEDDATE_1 =
		"ticketEntry.modifiedDate IS NULL";

	private static final String _FINDER_COLUMN_GTMODIFIEDDATE_MODIFIEDDATE_2 =
		"ticketEntry.modifiedDate >= ?";

	private FinderPath _finderPathWithPaginationFindByU_TSI;
	private FinderPath _finderPathWithoutPaginationFindByU_TSI;
	private FinderPath _finderPathCountByU_TSI;
	private FinderPath _finderPathWithPaginationCountByU_TSI;

	/**
	 * Returns all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @return the matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByU_TSI(long userId, long ticketStatusId) {
		return findByU_TSI(
			userId, ticketStatusId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end) {

		return findByU_TSI(userId, ticketStatusId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator) {

		return findByU_TSI(
			userId, ticketStatusId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByU_TSI(
		long userId, long ticketStatusId, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByU_TSI;
				finderArgs = new Object[] {userId, ticketStatusId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByU_TSI;
			finderArgs = new Object[] {
				userId, ticketStatusId, start, end, orderByComparator
			};
		}

		List<TicketEntry> list = null;

		if (useFinderCache) {
			list = (List<TicketEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketEntry ticketEntry : list) {
					if ((userId != ticketEntry.getUserId()) ||
						(ticketStatusId != ticketEntry.getTicketStatusId())) {

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

			query.append(_SQL_SELECT_TICKETENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_TSI_USERID_2);

			query.append(_FINDER_COLUMN_U_TSI_TICKETSTATUSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(ticketStatusId);

				if (!pagination) {
					list = (List<TicketEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketEntry>)QueryUtil.list(
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
	 * Returns the first ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	@Override
	public TicketEntry findByU_TSI_First(
			long userId, long ticketStatusId,
			OrderByComparator<TicketEntry> orderByComparator)
		throws NoSuchTicketEntryException {

		TicketEntry ticketEntry = fetchByU_TSI_First(
			userId, ticketStatusId, orderByComparator);

		if (ticketEntry != null) {
			return ticketEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", ticketStatusId=");
		msg.append(ticketStatusId);

		msg.append("}");

		throw new NoSuchTicketEntryException(msg.toString());
	}

	/**
	 * Returns the first ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	@Override
	public TicketEntry fetchByU_TSI_First(
		long userId, long ticketStatusId,
		OrderByComparator<TicketEntry> orderByComparator) {

		List<TicketEntry> list = findByU_TSI(
			userId, ticketStatusId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry
	 * @throws NoSuchTicketEntryException if a matching ticket entry could not be found
	 */
	@Override
	public TicketEntry findByU_TSI_Last(
			long userId, long ticketStatusId,
			OrderByComparator<TicketEntry> orderByComparator)
		throws NoSuchTicketEntryException {

		TicketEntry ticketEntry = fetchByU_TSI_Last(
			userId, ticketStatusId, orderByComparator);

		if (ticketEntry != null) {
			return ticketEntry;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", ticketStatusId=");
		msg.append(ticketStatusId);

		msg.append("}");

		throw new NoSuchTicketEntryException(msg.toString());
	}

	/**
	 * Returns the last ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket entry, or <code>null</code> if a matching ticket entry could not be found
	 */
	@Override
	public TicketEntry fetchByU_TSI_Last(
		long userId, long ticketStatusId,
		OrderByComparator<TicketEntry> orderByComparator) {

		int count = countByU_TSI(userId, ticketStatusId);

		if (count == 0) {
			return null;
		}

		List<TicketEntry> list = findByU_TSI(
			userId, ticketStatusId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket entries before and after the current ticket entry in the ordered set where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param ticketEntryId the primary key of the current ticket entry
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	@Override
	public TicketEntry[] findByU_TSI_PrevAndNext(
			long ticketEntryId, long userId, long ticketStatusId,
			OrderByComparator<TicketEntry> orderByComparator)
		throws NoSuchTicketEntryException {

		TicketEntry ticketEntry = findByPrimaryKey(ticketEntryId);

		Session session = null;

		try {
			session = openSession();

			TicketEntry[] array = new TicketEntryImpl[3];

			array[0] = getByU_TSI_PrevAndNext(
				session, ticketEntry, userId, ticketStatusId, orderByComparator,
				true);

			array[1] = ticketEntry;

			array[2] = getByU_TSI_PrevAndNext(
				session, ticketEntry, userId, ticketStatusId, orderByComparator,
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

	protected TicketEntry getByU_TSI_PrevAndNext(
		Session session, TicketEntry ticketEntry, long userId,
		long ticketStatusId, OrderByComparator<TicketEntry> orderByComparator,
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

		query.append(_SQL_SELECT_TICKETENTRY_WHERE);

		query.append(_FINDER_COLUMN_U_TSI_USERID_2);

		query.append(_FINDER_COLUMN_U_TSI_TICKETSTATUSID_2);

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
			query.append(TicketEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(ticketStatusId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketEntry)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketEntry> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @return the matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByU_TSI(long userId, long[] ticketStatusIds) {
		return findByU_TSI(
			userId, ticketStatusIds, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end) {

		return findByU_TSI(userId, ticketStatusIds, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator) {

		return findByU_TSI(
			userId, ticketStatusIds, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket entries where userId = &#63; and ticketStatusId = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket entries
	 */
	@Override
	public List<TicketEntry> findByU_TSI(
		long userId, long[] ticketStatusIds, int start, int end,
		OrderByComparator<TicketEntry> orderByComparator,
		boolean useFinderCache) {

		if (ticketStatusIds == null) {
			ticketStatusIds = new long[0];
		}
		else if (ticketStatusIds.length > 1) {
			ticketStatusIds = ArrayUtil.sortedUnique(ticketStatusIds);
		}

		if (ticketStatusIds.length == 1) {
			return findByU_TSI(
				userId, ticketStatusIds[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderArgs = new Object[] {
					userId, StringUtil.merge(ticketStatusIds)
				};
			}
		}
		else if (useFinderCache) {
			finderArgs = new Object[] {
				userId, StringUtil.merge(ticketStatusIds), start, end,
				orderByComparator
			};
		}

		List<TicketEntry> list = null;

		if (useFinderCache) {
			list = (List<TicketEntry>)finderCache.getResult(
				_finderPathWithPaginationFindByU_TSI, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketEntry ticketEntry : list) {
					if ((userId != ticketEntry.getUserId()) ||
						!ArrayUtil.contains(
							ticketStatusIds, ticketEntry.getTicketStatusId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TICKETENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_TSI_USERID_2);

			if (ticketStatusIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_U_TSI_TICKETSTATUSID_7);

				query.append(StringUtil.merge(ticketStatusIds));

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
				query.append(TicketEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				if (!pagination) {
					list = (List<TicketEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketEntry>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(
						_finderPathWithPaginationFindByU_TSI, finderArgs, list);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathWithPaginationFindByU_TSI, finderArgs);
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
	 * Removes all the ticket entries where userId = &#63; and ticketStatusId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 */
	@Override
	public void removeByU_TSI(long userId, long ticketStatusId) {
		for (TicketEntry ticketEntry :
				findByU_TSI(
					userId, ticketStatusId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(ticketEntry);
		}
	}

	/**
	 * Returns the number of ticket entries where userId = &#63; and ticketStatusId = &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusId the ticket status ID
	 * @return the number of matching ticket entries
	 */
	@Override
	public int countByU_TSI(long userId, long ticketStatusId) {
		FinderPath finderPath = _finderPathCountByU_TSI;

		Object[] finderArgs = new Object[] {userId, ticketStatusId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TICKETENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_TSI_USERID_2);

			query.append(_FINDER_COLUMN_U_TSI_TICKETSTATUSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(ticketStatusId);

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
	 * Returns the number of ticket entries where userId = &#63; and ticketStatusId = any &#63;.
	 *
	 * @param userId the user ID
	 * @param ticketStatusIds the ticket status IDs
	 * @return the number of matching ticket entries
	 */
	@Override
	public int countByU_TSI(long userId, long[] ticketStatusIds) {
		if (ticketStatusIds == null) {
			ticketStatusIds = new long[0];
		}
		else if (ticketStatusIds.length > 1) {
			ticketStatusIds = ArrayUtil.sortedUnique(ticketStatusIds);
		}

		Object[] finderArgs = new Object[] {
			userId, StringUtil.merge(ticketStatusIds)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByU_TSI, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TICKETENTRY_WHERE);

			query.append(_FINDER_COLUMN_U_TSI_USERID_2);

			if (ticketStatusIds.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_U_TSI_TICKETSTATUSID_7);

				query.append(StringUtil.merge(ticketStatusIds));

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

				qPos.add(userId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByU_TSI, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByU_TSI, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_U_TSI_USERID_2 =
		"ticketEntry.userId = ? AND ";

	private static final String _FINDER_COLUMN_U_TSI_TICKETSTATUSID_2 =
		"ticketEntry.ticketStatusId = ?";

	private static final String _FINDER_COLUMN_U_TSI_TICKETSTATUSID_7 =
		"ticketEntry.ticketStatusId IN (";

	public TicketEntryPersistenceImpl() {
		setModelClass(TicketEntry.class);

		setModelImplClass(TicketEntryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the ticket entry in the entity cache if it is enabled.
	 *
	 * @param ticketEntry the ticket entry
	 */
	@Override
	public void cacheResult(TicketEntry ticketEntry) {
		entityCache.putResult(
			entityCacheEnabled, TicketEntryImpl.class,
			ticketEntry.getPrimaryKey(), ticketEntry);

		ticketEntry.resetOriginalValues();
	}

	/**
	 * Caches the ticket entries in the entity cache if it is enabled.
	 *
	 * @param ticketEntries the ticket entries
	 */
	@Override
	public void cacheResult(List<TicketEntry> ticketEntries) {
		for (TicketEntry ticketEntry : ticketEntries) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketEntryImpl.class,
					ticketEntry.getPrimaryKey()) == null) {

				cacheResult(ticketEntry);
			}
			else {
				ticketEntry.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketEntryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketEntry ticketEntry) {
		entityCache.removeResult(
			entityCacheEnabled, TicketEntryImpl.class,
			ticketEntry.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TicketEntry> ticketEntries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketEntry ticketEntry : ticketEntries) {
			entityCache.removeResult(
				entityCacheEnabled, TicketEntryImpl.class,
				ticketEntry.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ticket entry with the primary key. Does not add the ticket entry to the database.
	 *
	 * @param ticketEntryId the primary key for the new ticket entry
	 * @return the new ticket entry
	 */
	@Override
	public TicketEntry create(long ticketEntryId) {
		TicketEntry ticketEntry = new TicketEntryImpl();

		ticketEntry.setNew(true);
		ticketEntry.setPrimaryKey(ticketEntryId);

		ticketEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ticketEntry;
	}

	/**
	 * Removes the ticket entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry that was removed
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	@Override
	public TicketEntry remove(long ticketEntryId)
		throws NoSuchTicketEntryException {

		return remove((Serializable)ticketEntryId);
	}

	/**
	 * Removes the ticket entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket entry
	 * @return the ticket entry that was removed
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	@Override
	public TicketEntry remove(Serializable primaryKey)
		throws NoSuchTicketEntryException {

		Session session = null;

		try {
			session = openSession();

			TicketEntry ticketEntry = (TicketEntry)session.get(
				TicketEntryImpl.class, primaryKey);

			if (ticketEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketEntry);
		}
		catch (NoSuchTicketEntryException nsee) {
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
	protected TicketEntry removeImpl(TicketEntry ticketEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketEntry)) {
				ticketEntry = (TicketEntry)session.get(
					TicketEntryImpl.class, ticketEntry.getPrimaryKeyObj());
			}

			if (ticketEntry != null) {
				session.delete(ticketEntry);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketEntry != null) {
			clearCache(ticketEntry);
		}

		return ticketEntry;
	}

	@Override
	public TicketEntry updateImpl(TicketEntry ticketEntry) {
		boolean isNew = ticketEntry.isNew();

		if (!(ticketEntry instanceof TicketEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ticketEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketEntry implementation " +
					ticketEntry.getClass());
		}

		TicketEntryModelImpl ticketEntryModelImpl =
			(TicketEntryModelImpl)ticketEntry;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ticketEntry.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketEntry.setCreateDate(now);
			}
			else {
				ticketEntry.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ticketEntryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketEntry.setModifiedDate(now);
			}
			else {
				ticketEntry.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ticketEntry.isNew()) {
				session.save(ticketEntry);

				ticketEntry.setNew(false);
			}
			else {
				ticketEntry = (TicketEntry)session.merge(ticketEntry);
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
				ticketEntryModelImpl.getUserId(),
				ticketEntryModelImpl.getTicketStatusId()
			};

			finderCache.removeResult(_finderPathCountByU_TSI, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByU_TSI, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ticketEntryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByU_TSI.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ticketEntryModelImpl.getOriginalUserId(),
					ticketEntryModelImpl.getOriginalTicketStatusId()
				};

				finderCache.removeResult(_finderPathCountByU_TSI, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_TSI, args);

				args = new Object[] {
					ticketEntryModelImpl.getUserId(),
					ticketEntryModelImpl.getTicketStatusId()
				};

				finderCache.removeResult(_finderPathCountByU_TSI, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByU_TSI, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TicketEntryImpl.class,
			ticketEntry.getPrimaryKey(), ticketEntry, false);

		ticketEntry.resetOriginalValues();

		return ticketEntry;
	}

	/**
	 * Returns the ticket entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket entry
	 * @return the ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	@Override
	public TicketEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketEntryException {

		TicketEntry ticketEntry = fetchByPrimaryKey(primaryKey);

		if (ticketEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketEntry;
	}

	/**
	 * Returns the ticket entry with the primary key or throws a <code>NoSuchTicketEntryException</code> if it could not be found.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry
	 * @throws NoSuchTicketEntryException if a ticket entry with the primary key could not be found
	 */
	@Override
	public TicketEntry findByPrimaryKey(long ticketEntryId)
		throws NoSuchTicketEntryException {

		return findByPrimaryKey((Serializable)ticketEntryId);
	}

	/**
	 * Returns the ticket entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketEntryId the primary key of the ticket entry
	 * @return the ticket entry, or <code>null</code> if a ticket entry with the primary key could not be found
	 */
	@Override
	public TicketEntry fetchByPrimaryKey(long ticketEntryId) {
		return fetchByPrimaryKey((Serializable)ticketEntryId);
	}

	/**
	 * Returns all the ticket entries.
	 *
	 * @return the ticket entries
	 */
	@Override
	public List<TicketEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @return the range of ticket entries
	 */
	@Override
	public List<TicketEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket entries
	 */
	@Override
	public List<TicketEntry> findAll(
		int start, int end, OrderByComparator<TicketEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketEntryModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket entries
	 * @param end the upper bound of the range of ticket entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket entries
	 */
	@Override
	public List<TicketEntry> findAll(
		int start, int end, OrderByComparator<TicketEntry> orderByComparator,
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

		List<TicketEntry> list = null;

		if (useFinderCache) {
			list = (List<TicketEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETENTRY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETENTRY;

				if (pagination) {
					sql = sql.concat(TicketEntryModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketEntry>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketEntry>)QueryUtil.list(
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
	 * Removes all the ticket entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketEntry ticketEntry : findAll()) {
			remove(ticketEntry);
		}
	}

	/**
	 * Returns the number of ticket entries.
	 *
	 * @return the number of ticket entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETENTRY);

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
		return "ticketEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket entry persistence.
	 */
	@Activate
	public void activate() {
		TicketEntryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketEntryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGtModifiedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGtModifiedDate",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByGtModifiedDate = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByGtModifiedDate",
			new String[] {Date.class.getName()});

		_finderPathWithPaginationFindByU_TSI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByU_TSI",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByU_TSI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketEntryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByU_TSI",
			new String[] {Long.class.getName(), Long.class.getName()},
			TicketEntryModelImpl.USERID_COLUMN_BITMASK |
			TicketEntryModelImpl.TICKETSTATUSID_COLUMN_BITMASK |
			TicketEntryModelImpl.MODIFIEDDATE_COLUMN_BITMASK);

		_finderPathCountByU_TSI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByU_TSI",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationCountByU_TSI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByU_TSI",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketEntryImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketEntry"),
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

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_TICKETENTRY =
		"SELECT ticketEntry FROM TicketEntry ticketEntry";

	private static final String _SQL_SELECT_TICKETENTRY_WHERE =
		"SELECT ticketEntry FROM TicketEntry ticketEntry WHERE ";

	private static final String _SQL_COUNT_TICKETENTRY =
		"SELECT COUNT(ticketEntry) FROM TicketEntry ticketEntry";

	private static final String _SQL_COUNT_TICKETENTRY_WHERE =
		"SELECT COUNT(ticketEntry) FROM TicketEntry ticketEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketEntryPersistenceImpl.class);

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}