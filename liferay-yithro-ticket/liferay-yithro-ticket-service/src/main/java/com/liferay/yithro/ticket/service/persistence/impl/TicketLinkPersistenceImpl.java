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

import aQute.bnd.annotation.ProviderType;

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
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.ticket.exception.NoSuchTicketLinkException;
import com.liferay.yithro.ticket.model.TicketLink;
import com.liferay.yithro.ticket.model.impl.TicketLinkImpl;
import com.liferay.yithro.ticket.model.impl.TicketLinkModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketLinkPersistence;
import com.liferay.yithro.ticket.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Arrays;
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
 * The persistence implementation for the ticket link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketLinkPersistence.class)
@ProviderType
public class TicketLinkPersistenceImpl
	extends BasePersistenceImpl<TicketLink> implements TicketLinkPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketLinkUtil</code> to access the ticket link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketLinkImpl.class.getName();

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
	 * Returns all the ticket links where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket links
	 */
	@Override
	public List<TicketLink> findByTicketEntryId(long ticketEntryId) {
		return findByTicketEntryId(
			ticketEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket links where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTicketEntryId(
		long ticketEntryId, int start, int end) {

		return findByTicketEntryId(ticketEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketLink> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTicketEntryId;
			finderArgs = new Object[] {ticketEntryId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTicketEntryId;
			finderArgs = new Object[] {
				ticketEntryId, start, end, orderByComparator
			};
		}

		List<TicketLink> list = null;

		if (retrieveFromCache) {
			list = (List<TicketLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketLink ticketLink : list) {
					if ((ticketEntryId != ticketLink.getTicketEntryId())) {
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

			query.append(_SQL_SELECT_TICKETLINK_WHERE);

			query.append(_FINDER_COLUMN_TICKETENTRYID_TICKETENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				if (!pagination) {
					list = (List<TicketLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketLink>)QueryUtil.list(
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
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	@Override
	public TicketLink findByTicketEntryId_First(
			long ticketEntryId, OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = fetchByTicketEntryId_First(
			ticketEntryId, orderByComparator);

		if (ticketLink != null) {
			return ticketLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append("}");

		throw new NoSuchTicketLinkException(msg.toString());
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	@Override
	public TicketLink fetchByTicketEntryId_First(
		long ticketEntryId, OrderByComparator<TicketLink> orderByComparator) {

		List<TicketLink> list = findByTicketEntryId(
			ticketEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	@Override
	public TicketLink findByTicketEntryId_Last(
			long ticketEntryId, OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = fetchByTicketEntryId_Last(
			ticketEntryId, orderByComparator);

		if (ticketLink != null) {
			return ticketLink;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append("}");

		throw new NoSuchTicketLinkException(msg.toString());
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	@Override
	public TicketLink fetchByTicketEntryId_Last(
		long ticketEntryId, OrderByComparator<TicketLink> orderByComparator) {

		int count = countByTicketEntryId(ticketEntryId);

		if (count == 0) {
			return null;
		}

		List<TicketLink> list = findByTicketEntryId(
			ticketEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket links before and after the current ticket link in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketLinkId the primary key of the current ticket link
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	@Override
	public TicketLink[] findByTicketEntryId_PrevAndNext(
			long ticketLinkId, long ticketEntryId,
			OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = findByPrimaryKey(ticketLinkId);

		Session session = null;

		try {
			session = openSession();

			TicketLink[] array = new TicketLinkImpl[3];

			array[0] = getByTicketEntryId_PrevAndNext(
				session, ticketLink, ticketEntryId, orderByComparator, true);

			array[1] = ticketLink;

			array[2] = getByTicketEntryId_PrevAndNext(
				session, ticketLink, ticketEntryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketLink getByTicketEntryId_PrevAndNext(
		Session session, TicketLink ticketLink, long ticketEntryId,
		OrderByComparator<TicketLink> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TICKETLINK_WHERE);

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
			query.append(TicketLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketEntryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketLink)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket links where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	@Override
	public void removeByTicketEntryId(long ticketEntryId) {
		for (TicketLink ticketLink :
				findByTicketEntryId(
					ticketEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketLink);
		}
	}

	/**
	 * Returns the number of ticket links where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket links
	 */
	@Override
	public int countByTicketEntryId(long ticketEntryId) {
		FinderPath finderPath = _finderPathCountByTicketEntryId;

		Object[] finderArgs = new Object[] {ticketEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETLINK_WHERE);

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

	private static final String _FINDER_COLUMN_TICKETENTRYID_TICKETENTRYID_2 =
		"ticketLink.ticketEntryId = ?";

	private FinderPath _finderPathWithPaginationFindByTEI_TSI;
	private FinderPath _finderPathWithoutPaginationFindByTEI_TSI;
	private FinderPath _finderPathCountByTEI_TSI;

	/**
	 * Returns all the ticket links where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @return the matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_TSI(
		long ticketEntryId, long ticketSolutionId) {

		return findByTEI_TSI(
			ticketEntryId, ticketSolutionId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket links where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_TSI(
		long ticketEntryId, long ticketSolutionId, int start, int end) {

		return findByTEI_TSI(ticketEntryId, ticketSolutionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_TSI(
		long ticketEntryId, long ticketSolutionId, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return findByTEI_TSI(
			ticketEntryId, ticketSolutionId, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_TSI(
		long ticketEntryId, long ticketSolutionId, int start, int end,
		OrderByComparator<TicketLink> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTEI_TSI;
			finderArgs = new Object[] {ticketEntryId, ticketSolutionId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTEI_TSI;
			finderArgs = new Object[] {
				ticketEntryId, ticketSolutionId, start, end, orderByComparator
			};
		}

		List<TicketLink> list = null;

		if (retrieveFromCache) {
			list = (List<TicketLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketLink ticketLink : list) {
					if ((ticketEntryId != ticketLink.getTicketEntryId()) ||
						(ticketSolutionId !=
							ticketLink.getTicketSolutionId())) {

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

			query.append(_SQL_SELECT_TICKETLINK_WHERE);

			query.append(_FINDER_COLUMN_TEI_TSI_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_TSI_TICKETSOLUTIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(ticketSolutionId);

				if (!pagination) {
					list = (List<TicketLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketLink>)QueryUtil.list(
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
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	@Override
	public TicketLink findByTEI_TSI_First(
			long ticketEntryId, long ticketSolutionId,
			OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = fetchByTEI_TSI_First(
			ticketEntryId, ticketSolutionId, orderByComparator);

		if (ticketLink != null) {
			return ticketLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append(", ticketSolutionId=");
		msg.append(ticketSolutionId);

		msg.append("}");

		throw new NoSuchTicketLinkException(msg.toString());
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	@Override
	public TicketLink fetchByTEI_TSI_First(
		long ticketEntryId, long ticketSolutionId,
		OrderByComparator<TicketLink> orderByComparator) {

		List<TicketLink> list = findByTEI_TSI(
			ticketEntryId, ticketSolutionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	@Override
	public TicketLink findByTEI_TSI_Last(
			long ticketEntryId, long ticketSolutionId,
			OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = fetchByTEI_TSI_Last(
			ticketEntryId, ticketSolutionId, orderByComparator);

		if (ticketLink != null) {
			return ticketLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append(", ticketSolutionId=");
		msg.append(ticketSolutionId);

		msg.append("}");

		throw new NoSuchTicketLinkException(msg.toString());
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	@Override
	public TicketLink fetchByTEI_TSI_Last(
		long ticketEntryId, long ticketSolutionId,
		OrderByComparator<TicketLink> orderByComparator) {

		int count = countByTEI_TSI(ticketEntryId, ticketSolutionId);

		if (count == 0) {
			return null;
		}

		List<TicketLink> list = findByTEI_TSI(
			ticketEntryId, ticketSolutionId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket links before and after the current ticket link in the ordered set where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * @param ticketLinkId the primary key of the current ticket link
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	@Override
	public TicketLink[] findByTEI_TSI_PrevAndNext(
			long ticketLinkId, long ticketEntryId, long ticketSolutionId,
			OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = findByPrimaryKey(ticketLinkId);

		Session session = null;

		try {
			session = openSession();

			TicketLink[] array = new TicketLinkImpl[3];

			array[0] = getByTEI_TSI_PrevAndNext(
				session, ticketLink, ticketEntryId, ticketSolutionId,
				orderByComparator, true);

			array[1] = ticketLink;

			array[2] = getByTEI_TSI_PrevAndNext(
				session, ticketLink, ticketEntryId, ticketSolutionId,
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

	protected TicketLink getByTEI_TSI_PrevAndNext(
		Session session, TicketLink ticketLink, long ticketEntryId,
		long ticketSolutionId, OrderByComparator<TicketLink> orderByComparator,
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

		query.append(_SQL_SELECT_TICKETLINK_WHERE);

		query.append(_FINDER_COLUMN_TEI_TSI_TICKETENTRYID_2);

		query.append(_FINDER_COLUMN_TEI_TSI_TICKETSOLUTIONID_2);

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
			query.append(TicketLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketEntryId);

		qPos.add(ticketSolutionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketLink)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket links where ticketEntryId = &#63; and ticketSolutionId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 */
	@Override
	public void removeByTEI_TSI(long ticketEntryId, long ticketSolutionId) {
		for (TicketLink ticketLink :
				findByTEI_TSI(
					ticketEntryId, ticketSolutionId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(ticketLink);
		}
	}

	/**
	 * Returns the number of ticket links where ticketEntryId = &#63; and ticketSolutionId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param ticketSolutionId the ticket solution ID
	 * @return the number of matching ticket links
	 */
	@Override
	public int countByTEI_TSI(long ticketEntryId, long ticketSolutionId) {
		FinderPath finderPath = _finderPathCountByTEI_TSI;

		Object[] finderArgs = new Object[] {ticketEntryId, ticketSolutionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TICKETLINK_WHERE);

			query.append(_FINDER_COLUMN_TEI_TSI_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_TSI_TICKETSOLUTIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(ticketSolutionId);

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

	private static final String _FINDER_COLUMN_TEI_TSI_TICKETENTRYID_2 =
		"ticketLink.ticketEntryId = ? AND ";

	private static final String _FINDER_COLUMN_TEI_TSI_TICKETSOLUTIONID_2 =
		"ticketLink.ticketSolutionId = ?";

	private FinderPath _finderPathWithPaginationFindByTEI_V;
	private FinderPath _finderPathWithoutPaginationFindByTEI_V;
	private FinderPath _finderPathCountByTEI_V;
	private FinderPath _finderPathWithPaginationCountByTEI_V;

	/**
	 * Returns all the ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @return the matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_V(long ticketEntryId, int visibility) {
		return findByTEI_V(
			ticketEntryId, visibility, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end) {

		return findByTEI_V(ticketEntryId, visibility, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return findByTEI_V(
			ticketEntryId, visibility, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_V(
		long ticketEntryId, int visibility, int start, int end,
		OrderByComparator<TicketLink> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByTEI_V;
			finderArgs = new Object[] {ticketEntryId, visibility};
		}
		else {
			finderPath = _finderPathWithPaginationFindByTEI_V;
			finderArgs = new Object[] {
				ticketEntryId, visibility, start, end, orderByComparator
			};
		}

		List<TicketLink> list = null;

		if (retrieveFromCache) {
			list = (List<TicketLink>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketLink ticketLink : list) {
					if ((ticketEntryId != ticketLink.getTicketEntryId()) ||
						(visibility != ticketLink.getVisibility())) {

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

			query.append(_SQL_SELECT_TICKETLINK_WHERE);

			query.append(_FINDER_COLUMN_TEI_V_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_V_VISIBILITY_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(visibility);

				if (!pagination) {
					list = (List<TicketLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketLink>)QueryUtil.list(
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
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	@Override
	public TicketLink findByTEI_V_First(
			long ticketEntryId, int visibility,
			OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = fetchByTEI_V_First(
			ticketEntryId, visibility, orderByComparator);

		if (ticketLink != null) {
			return ticketLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append(", visibility=");
		msg.append(visibility);

		msg.append("}");

		throw new NoSuchTicketLinkException(msg.toString());
	}

	/**
	 * Returns the first ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	@Override
	public TicketLink fetchByTEI_V_First(
		long ticketEntryId, int visibility,
		OrderByComparator<TicketLink> orderByComparator) {

		List<TicketLink> list = findByTEI_V(
			ticketEntryId, visibility, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link
	 * @throws NoSuchTicketLinkException if a matching ticket link could not be found
	 */
	@Override
	public TicketLink findByTEI_V_Last(
			long ticketEntryId, int visibility,
			OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = fetchByTEI_V_Last(
			ticketEntryId, visibility, orderByComparator);

		if (ticketLink != null) {
			return ticketLink;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append(", visibility=");
		msg.append(visibility);

		msg.append("}");

		throw new NoSuchTicketLinkException(msg.toString());
	}

	/**
	 * Returns the last ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket link, or <code>null</code> if a matching ticket link could not be found
	 */
	@Override
	public TicketLink fetchByTEI_V_Last(
		long ticketEntryId, int visibility,
		OrderByComparator<TicketLink> orderByComparator) {

		int count = countByTEI_V(ticketEntryId, visibility);

		if (count == 0) {
			return null;
		}

		List<TicketLink> list = findByTEI_V(
			ticketEntryId, visibility, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket links before and after the current ticket link in the ordered set where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketLinkId the primary key of the current ticket link
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	@Override
	public TicketLink[] findByTEI_V_PrevAndNext(
			long ticketLinkId, long ticketEntryId, int visibility,
			OrderByComparator<TicketLink> orderByComparator)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = findByPrimaryKey(ticketLinkId);

		Session session = null;

		try {
			session = openSession();

			TicketLink[] array = new TicketLinkImpl[3];

			array[0] = getByTEI_V_PrevAndNext(
				session, ticketLink, ticketEntryId, visibility,
				orderByComparator, true);

			array[1] = ticketLink;

			array[2] = getByTEI_V_PrevAndNext(
				session, ticketLink, ticketEntryId, visibility,
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

	protected TicketLink getByTEI_V_PrevAndNext(
		Session session, TicketLink ticketLink, long ticketEntryId,
		int visibility, OrderByComparator<TicketLink> orderByComparator,
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

		query.append(_SQL_SELECT_TICKETLINK_WHERE);

		query.append(_FINDER_COLUMN_TEI_V_TICKETENTRYID_2);

		query.append(_FINDER_COLUMN_TEI_V_VISIBILITY_2);

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
			query.append(TicketLinkModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketEntryId);

		qPos.add(visibility);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketLink)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketLink> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the ticket links where ticketEntryId = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @return the matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_V(
		long ticketEntryId, int[] visibilities) {

		return findByTEI_V(
			ticketEntryId, visibilities, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the ticket links where ticketEntryId = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_V(
		long ticketEntryId, int[] visibilities, int start, int end) {

		return findByTEI_V(ticketEntryId, visibilities, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and visibility = any &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_V(
		long ticketEntryId, int[] visibilities, int start, int end,
		OrderByComparator<TicketLink> orderByComparator) {

		return findByTEI_V(
			ticketEntryId, visibilities, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket links where ticketEntryId = &#63; and visibility = &#63;, optionally using the finder cache.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket links
	 */
	@Override
	public List<TicketLink> findByTEI_V(
		long ticketEntryId, int[] visibilities, int start, int end,
		OrderByComparator<TicketLink> orderByComparator,
		boolean retrieveFromCache) {

		if (visibilities == null) {
			visibilities = new int[0];
		}
		else if (visibilities.length > 1) {
			visibilities = ArrayUtil.unique(visibilities);

			Arrays.sort(visibilities);
		}

		if (visibilities.length == 1) {
			return findByTEI_V(
				ticketEntryId, visibilities[0], start, end, orderByComparator);
		}

		boolean pagination = true;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderArgs = new Object[] {
				ticketEntryId, StringUtil.merge(visibilities)
			};
		}
		else {
			finderArgs = new Object[] {
				ticketEntryId, StringUtil.merge(visibilities), start, end,
				orderByComparator
			};
		}

		List<TicketLink> list = null;

		if (retrieveFromCache) {
			list = (List<TicketLink>)finderCache.getResult(
				_finderPathWithPaginationFindByTEI_V, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketLink ticketLink : list) {
					if ((ticketEntryId != ticketLink.getTicketEntryId()) ||
						!ArrayUtil.contains(
							visibilities, ticketLink.getVisibility())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_SELECT_TICKETLINK_WHERE);

			query.append(_FINDER_COLUMN_TEI_V_TICKETENTRYID_2);

			if (visibilities.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_TEI_V_VISIBILITY_7);

				query.append(StringUtil.merge(visibilities));

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
				query.append(TicketLinkModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				if (!pagination) {
					list = (List<TicketLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketLink>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(
					_finderPathWithPaginationFindByTEI_V, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationFindByTEI_V, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the ticket links where ticketEntryId = &#63; and visibility = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 */
	@Override
	public void removeByTEI_V(long ticketEntryId, int visibility) {
		for (TicketLink ticketLink :
				findByTEI_V(
					ticketEntryId, visibility, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(ticketLink);
		}
	}

	/**
	 * Returns the number of ticket links where ticketEntryId = &#63; and visibility = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibility the visibility
	 * @return the number of matching ticket links
	 */
	@Override
	public int countByTEI_V(long ticketEntryId, int visibility) {
		FinderPath finderPath = _finderPathCountByTEI_V;

		Object[] finderArgs = new Object[] {ticketEntryId, visibility};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TICKETLINK_WHERE);

			query.append(_FINDER_COLUMN_TEI_V_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_V_VISIBILITY_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(visibility);

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
	 * Returns the number of ticket links where ticketEntryId = &#63; and visibility = any &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param visibilities the visibilities
	 * @return the number of matching ticket links
	 */
	@Override
	public int countByTEI_V(long ticketEntryId, int[] visibilities) {
		if (visibilities == null) {
			visibilities = new int[0];
		}
		else if (visibilities.length > 1) {
			visibilities = ArrayUtil.unique(visibilities);

			Arrays.sort(visibilities);
		}

		Object[] finderArgs = new Object[] {
			ticketEntryId, StringUtil.merge(visibilities)
		};

		Long count = (Long)finderCache.getResult(
			_finderPathWithPaginationCountByTEI_V, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler();

			query.append(_SQL_COUNT_TICKETLINK_WHERE);

			query.append(_FINDER_COLUMN_TEI_V_TICKETENTRYID_2);

			if (visibilities.length > 0) {
				query.append("(");

				query.append(_FINDER_COLUMN_TEI_V_VISIBILITY_7);

				query.append(StringUtil.merge(visibilities));

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

				qPos.add(ticketEntryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathWithPaginationCountByTEI_V, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathWithPaginationCountByTEI_V, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TEI_V_TICKETENTRYID_2 =
		"ticketLink.ticketEntryId = ? AND ";

	private static final String _FINDER_COLUMN_TEI_V_VISIBILITY_2 =
		"ticketLink.visibility = ?";

	private static final String _FINDER_COLUMN_TEI_V_VISIBILITY_7 =
		"ticketLink.visibility IN (";

	public TicketLinkPersistenceImpl() {
		setModelClass(TicketLink.class);

		setModelImplClass(TicketLinkImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ticket link in the entity cache if it is enabled.
	 *
	 * @param ticketLink the ticket link
	 */
	@Override
	public void cacheResult(TicketLink ticketLink) {
		entityCache.putResult(
			entityCacheEnabled, TicketLinkImpl.class,
			ticketLink.getPrimaryKey(), ticketLink);

		ticketLink.resetOriginalValues();
	}

	/**
	 * Caches the ticket links in the entity cache if it is enabled.
	 *
	 * @param ticketLinks the ticket links
	 */
	@Override
	public void cacheResult(List<TicketLink> ticketLinks) {
		for (TicketLink ticketLink : ticketLinks) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketLinkImpl.class,
					ticketLink.getPrimaryKey()) == null) {

				cacheResult(ticketLink);
			}
			else {
				ticketLink.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketLinkImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket link.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketLink ticketLink) {
		entityCache.removeResult(
			entityCacheEnabled, TicketLinkImpl.class,
			ticketLink.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TicketLink> ticketLinks) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketLink ticketLink : ticketLinks) {
			entityCache.removeResult(
				entityCacheEnabled, TicketLinkImpl.class,
				ticketLink.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ticket link with the primary key. Does not add the ticket link to the database.
	 *
	 * @param ticketLinkId the primary key for the new ticket link
	 * @return the new ticket link
	 */
	@Override
	public TicketLink create(long ticketLinkId) {
		TicketLink ticketLink = new TicketLinkImpl();

		ticketLink.setNew(true);
		ticketLink.setPrimaryKey(ticketLinkId);

		return ticketLink;
	}

	/**
	 * Removes the ticket link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketLinkId the primary key of the ticket link
	 * @return the ticket link that was removed
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	@Override
	public TicketLink remove(long ticketLinkId)
		throws NoSuchTicketLinkException {

		return remove((Serializable)ticketLinkId);
	}

	/**
	 * Removes the ticket link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket link
	 * @return the ticket link that was removed
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	@Override
	public TicketLink remove(Serializable primaryKey)
		throws NoSuchTicketLinkException {

		Session session = null;

		try {
			session = openSession();

			TicketLink ticketLink = (TicketLink)session.get(
				TicketLinkImpl.class, primaryKey);

			if (ticketLink == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketLinkException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketLink);
		}
		catch (NoSuchTicketLinkException nsee) {
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
	protected TicketLink removeImpl(TicketLink ticketLink) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketLink)) {
				ticketLink = (TicketLink)session.get(
					TicketLinkImpl.class, ticketLink.getPrimaryKeyObj());
			}

			if (ticketLink != null) {
				session.delete(ticketLink);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketLink != null) {
			clearCache(ticketLink);
		}

		return ticketLink;
	}

	@Override
	public TicketLink updateImpl(TicketLink ticketLink) {
		boolean isNew = ticketLink.isNew();

		if (!(ticketLink instanceof TicketLinkModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketLink.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ticketLink);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketLink proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketLink implementation " +
					ticketLink.getClass());
		}

		TicketLinkModelImpl ticketLinkModelImpl =
			(TicketLinkModelImpl)ticketLink;

		Session session = null;

		try {
			session = openSession();

			if (ticketLink.isNew()) {
				session.save(ticketLink);

				ticketLink.setNew(false);
			}
			else {
				ticketLink = (TicketLink)session.merge(ticketLink);
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
				ticketLinkModelImpl.getTicketEntryId()
			};

			finderCache.removeResult(_finderPathCountByTicketEntryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTicketEntryId, args);

			args = new Object[] {
				ticketLinkModelImpl.getTicketEntryId(),
				ticketLinkModelImpl.getTicketSolutionId()
			};

			finderCache.removeResult(_finderPathCountByTEI_TSI, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTEI_TSI, args);

			args = new Object[] {
				ticketLinkModelImpl.getTicketEntryId(),
				ticketLinkModelImpl.getVisibility()
			};

			finderCache.removeResult(_finderPathCountByTEI_V, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTEI_V, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ticketLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTicketEntryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ticketLinkModelImpl.getOriginalTicketEntryId()
				};

				finderCache.removeResult(_finderPathCountByTicketEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketEntryId, args);

				args = new Object[] {ticketLinkModelImpl.getTicketEntryId()};

				finderCache.removeResult(_finderPathCountByTicketEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketEntryId, args);
			}

			if ((ticketLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTEI_TSI.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ticketLinkModelImpl.getOriginalTicketEntryId(),
					ticketLinkModelImpl.getOriginalTicketSolutionId()
				};

				finderCache.removeResult(_finderPathCountByTEI_TSI, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTEI_TSI, args);

				args = new Object[] {
					ticketLinkModelImpl.getTicketEntryId(),
					ticketLinkModelImpl.getTicketSolutionId()
				};

				finderCache.removeResult(_finderPathCountByTEI_TSI, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTEI_TSI, args);
			}

			if ((ticketLinkModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTEI_V.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ticketLinkModelImpl.getOriginalTicketEntryId(),
					ticketLinkModelImpl.getOriginalVisibility()
				};

				finderCache.removeResult(_finderPathCountByTEI_V, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTEI_V, args);

				args = new Object[] {
					ticketLinkModelImpl.getTicketEntryId(),
					ticketLinkModelImpl.getVisibility()
				};

				finderCache.removeResult(_finderPathCountByTEI_V, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTEI_V, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TicketLinkImpl.class,
			ticketLink.getPrimaryKey(), ticketLink, false);

		ticketLink.resetOriginalValues();

		return ticketLink;
	}

	/**
	 * Returns the ticket link with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket link
	 * @return the ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	@Override
	public TicketLink findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketLinkException {

		TicketLink ticketLink = fetchByPrimaryKey(primaryKey);

		if (ticketLink == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketLinkException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketLink;
	}

	/**
	 * Returns the ticket link with the primary key or throws a <code>NoSuchTicketLinkException</code> if it could not be found.
	 *
	 * @param ticketLinkId the primary key of the ticket link
	 * @return the ticket link
	 * @throws NoSuchTicketLinkException if a ticket link with the primary key could not be found
	 */
	@Override
	public TicketLink findByPrimaryKey(long ticketLinkId)
		throws NoSuchTicketLinkException {

		return findByPrimaryKey((Serializable)ticketLinkId);
	}

	/**
	 * Returns the ticket link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketLinkId the primary key of the ticket link
	 * @return the ticket link, or <code>null</code> if a ticket link with the primary key could not be found
	 */
	@Override
	public TicketLink fetchByPrimaryKey(long ticketLinkId) {
		return fetchByPrimaryKey((Serializable)ticketLinkId);
	}

	/**
	 * Returns all the ticket links.
	 *
	 * @return the ticket links
	 */
	@Override
	public List<TicketLink> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @return the range of ticket links
	 */
	@Override
	public List<TicketLink> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket links
	 */
	@Override
	public List<TicketLink> findAll(
		int start, int end, OrderByComparator<TicketLink> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket links
	 * @param end the upper bound of the range of ticket links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket links
	 */
	@Override
	public List<TicketLink> findAll(
		int start, int end, OrderByComparator<TicketLink> orderByComparator,
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

		List<TicketLink> list = null;

		if (retrieveFromCache) {
			list = (List<TicketLink>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETLINK);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETLINK;

				if (pagination) {
					sql = sql.concat(TicketLinkModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketLink>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketLink>)QueryUtil.list(
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
	 * Removes all the ticket links from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketLink ticketLink : findAll()) {
			remove(ticketLink);
		}
	}

	/**
	 * Returns the number of ticket links.
	 *
	 * @return the number of ticket links
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETLINK);

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
		return "ticketLinkId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETLINK;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketLinkModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket link persistence.
	 */
	@Activate
	public void activate() {
		TicketLinkModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketLinkModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTicketEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTicketEntryId",
			new String[] {Long.class.getName()},
			TicketLinkModelImpl.TICKETENTRYID_COLUMN_BITMASK);

		_finderPathCountByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketEntryId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTEI_TSI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTEI_TSI",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTEI_TSI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTEI_TSI",
			new String[] {Long.class.getName(), Long.class.getName()},
			TicketLinkModelImpl.TICKETENTRYID_COLUMN_BITMASK |
			TicketLinkModelImpl.TICKETSOLUTIONID_COLUMN_BITMASK);

		_finderPathCountByTEI_TSI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTEI_TSI",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByTEI_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTEI_V",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTEI_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketLinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTEI_V",
			new String[] {Long.class.getName(), Integer.class.getName()},
			TicketLinkModelImpl.TICKETENTRYID_COLUMN_BITMASK |
			TicketLinkModelImpl.VISIBILITY_COLUMN_BITMASK);

		_finderPathCountByTEI_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTEI_V",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationCountByTEI_V = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTEI_V",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketLinkImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketLink"),
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

	private static final String _SQL_SELECT_TICKETLINK =
		"SELECT ticketLink FROM TicketLink ticketLink";

	private static final String _SQL_SELECT_TICKETLINK_WHERE =
		"SELECT ticketLink FROM TicketLink ticketLink WHERE ";

	private static final String _SQL_COUNT_TICKETLINK =
		"SELECT COUNT(ticketLink) FROM TicketLink ticketLink";

	private static final String _SQL_COUNT_TICKETLINK_WHERE =
		"SELECT COUNT(ticketLink) FROM TicketLink ticketLink WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketLink.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketLink exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketLink exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketLinkPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

}