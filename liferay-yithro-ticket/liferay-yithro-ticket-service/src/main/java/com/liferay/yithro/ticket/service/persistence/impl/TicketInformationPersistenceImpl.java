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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.ticket.exception.NoSuchTicketInformationException;
import com.liferay.yithro.ticket.model.TicketInformation;
import com.liferay.yithro.ticket.model.impl.TicketInformationImpl;
import com.liferay.yithro.ticket.model.impl.TicketInformationModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketInformationPersistence;
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

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ticket information service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketInformationPersistence.class)
@ProviderType
public class TicketInformationPersistenceImpl
	extends BasePersistenceImpl<TicketInformation>
	implements TicketInformationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketInformationUtil</code> to access the ticket information persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketInformationImpl.class.getName();

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
	 * Returns all the ticket informations where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket informations
	 */
	@Override
	public List<TicketInformation> findByTicketEntryId(long ticketEntryId) {
		return findByTicketEntryId(
			ticketEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket informations where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketInformationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket informations
	 * @param end the upper bound of the range of ticket informations (not inclusive)
	 * @return the range of matching ticket informations
	 */
	@Override
	public List<TicketInformation> findByTicketEntryId(
		long ticketEntryId, int start, int end) {

		return findByTicketEntryId(ticketEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket informations where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketInformationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket informations
	 * @param end the upper bound of the range of ticket informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket informations
	 */
	@Override
	public List<TicketInformation> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketInformation> orderByComparator) {

		return findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket informations where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketInformationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket informations
	 * @param end the upper bound of the range of ticket informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket informations
	 */
	@Override
	public List<TicketInformation> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketInformation> orderByComparator,
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

		List<TicketInformation> list = null;

		if (retrieveFromCache) {
			list = (List<TicketInformation>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketInformation ticketInformation : list) {
					if ((ticketEntryId !=
							ticketInformation.getTicketEntryId())) {

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

			query.append(_SQL_SELECT_TICKETINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_TICKETENTRYID_TICKETENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketInformationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				if (!pagination) {
					list = (List<TicketInformation>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketInformation>)QueryUtil.list(
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
	 * Returns the first ticket information in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket information
	 * @throws NoSuchTicketInformationException if a matching ticket information could not be found
	 */
	@Override
	public TicketInformation findByTicketEntryId_First(
			long ticketEntryId,
			OrderByComparator<TicketInformation> orderByComparator)
		throws NoSuchTicketInformationException {

		TicketInformation ticketInformation = fetchByTicketEntryId_First(
			ticketEntryId, orderByComparator);

		if (ticketInformation != null) {
			return ticketInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append("}");

		throw new NoSuchTicketInformationException(msg.toString());
	}

	/**
	 * Returns the first ticket information in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket information, or <code>null</code> if a matching ticket information could not be found
	 */
	@Override
	public TicketInformation fetchByTicketEntryId_First(
		long ticketEntryId,
		OrderByComparator<TicketInformation> orderByComparator) {

		List<TicketInformation> list = findByTicketEntryId(
			ticketEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket information in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket information
	 * @throws NoSuchTicketInformationException if a matching ticket information could not be found
	 */
	@Override
	public TicketInformation findByTicketEntryId_Last(
			long ticketEntryId,
			OrderByComparator<TicketInformation> orderByComparator)
		throws NoSuchTicketInformationException {

		TicketInformation ticketInformation = fetchByTicketEntryId_Last(
			ticketEntryId, orderByComparator);

		if (ticketInformation != null) {
			return ticketInformation;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append("}");

		throw new NoSuchTicketInformationException(msg.toString());
	}

	/**
	 * Returns the last ticket information in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket information, or <code>null</code> if a matching ticket information could not be found
	 */
	@Override
	public TicketInformation fetchByTicketEntryId_Last(
		long ticketEntryId,
		OrderByComparator<TicketInformation> orderByComparator) {

		int count = countByTicketEntryId(ticketEntryId);

		if (count == 0) {
			return null;
		}

		List<TicketInformation> list = findByTicketEntryId(
			ticketEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket informations before and after the current ticket information in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketInformationId the primary key of the current ticket information
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket information
	 * @throws NoSuchTicketInformationException if a ticket information with the primary key could not be found
	 */
	@Override
	public TicketInformation[] findByTicketEntryId_PrevAndNext(
			long ticketInformationId, long ticketEntryId,
			OrderByComparator<TicketInformation> orderByComparator)
		throws NoSuchTicketInformationException {

		TicketInformation ticketInformation = findByPrimaryKey(
			ticketInformationId);

		Session session = null;

		try {
			session = openSession();

			TicketInformation[] array = new TicketInformationImpl[3];

			array[0] = getByTicketEntryId_PrevAndNext(
				session, ticketInformation, ticketEntryId, orderByComparator,
				true);

			array[1] = ticketInformation;

			array[2] = getByTicketEntryId_PrevAndNext(
				session, ticketInformation, ticketEntryId, orderByComparator,
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

	protected TicketInformation getByTicketEntryId_PrevAndNext(
		Session session, TicketInformation ticketInformation,
		long ticketEntryId,
		OrderByComparator<TicketInformation> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TICKETINFORMATION_WHERE);

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
			query.append(TicketInformationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketEntryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ticketInformation)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketInformation> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket informations where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	@Override
	public void removeByTicketEntryId(long ticketEntryId) {
		for (TicketInformation ticketInformation :
				findByTicketEntryId(
					ticketEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketInformation);
		}
	}

	/**
	 * Returns the number of ticket informations where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket informations
	 */
	@Override
	public int countByTicketEntryId(long ticketEntryId) {
		FinderPath finderPath = _finderPathCountByTicketEntryId;

		Object[] finderArgs = new Object[] {ticketEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETINFORMATION_WHERE);

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
		"ticketInformation.ticketEntryId = ?";

	private FinderPath _finderPathFetchByTEI_FI;
	private FinderPath _finderPathCountByTEI_FI;

	/**
	 * Returns the ticket information where ticketEntryId = &#63; and fieldId = &#63; or throws a <code>NoSuchTicketInformationException</code> if it could not be found.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fieldId the field ID
	 * @return the matching ticket information
	 * @throws NoSuchTicketInformationException if a matching ticket information could not be found
	 */
	@Override
	public TicketInformation findByTEI_FI(long ticketEntryId, long fieldId)
		throws NoSuchTicketInformationException {

		TicketInformation ticketInformation = fetchByTEI_FI(
			ticketEntryId, fieldId);

		if (ticketInformation == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ticketEntryId=");
			msg.append(ticketEntryId);

			msg.append(", fieldId=");
			msg.append(fieldId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTicketInformationException(msg.toString());
		}

		return ticketInformation;
	}

	/**
	 * Returns the ticket information where ticketEntryId = &#63; and fieldId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fieldId the field ID
	 * @return the matching ticket information, or <code>null</code> if a matching ticket information could not be found
	 */
	@Override
	public TicketInformation fetchByTEI_FI(long ticketEntryId, long fieldId) {
		return fetchByTEI_FI(ticketEntryId, fieldId, true);
	}

	/**
	 * Returns the ticket information where ticketEntryId = &#63; and fieldId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fieldId the field ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ticket information, or <code>null</code> if a matching ticket information could not be found
	 */
	@Override
	public TicketInformation fetchByTEI_FI(
		long ticketEntryId, long fieldId, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {ticketEntryId, fieldId};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByTEI_FI, finderArgs, this);
		}

		if (result instanceof TicketInformation) {
			TicketInformation ticketInformation = (TicketInformation)result;

			if ((ticketEntryId != ticketInformation.getTicketEntryId()) ||
				(fieldId != ticketInformation.getFieldId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TICKETINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_TEI_FI_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_FI_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(fieldId);

				List<TicketInformation> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByTEI_FI, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TicketInformationPersistenceImpl.fetchByTEI_FI(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TicketInformation ticketInformation = list.get(0);

					result = ticketInformation;

					cacheResult(ticketInformation);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByTEI_FI, finderArgs);

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
			return (TicketInformation)result;
		}
	}

	/**
	 * Removes the ticket information where ticketEntryId = &#63; and fieldId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fieldId the field ID
	 * @return the ticket information that was removed
	 */
	@Override
	public TicketInformation removeByTEI_FI(long ticketEntryId, long fieldId)
		throws NoSuchTicketInformationException {

		TicketInformation ticketInformation = findByTEI_FI(
			ticketEntryId, fieldId);

		return remove(ticketInformation);
	}

	/**
	 * Returns the number of ticket informations where ticketEntryId = &#63; and fieldId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param fieldId the field ID
	 * @return the number of matching ticket informations
	 */
	@Override
	public int countByTEI_FI(long ticketEntryId, long fieldId) {
		FinderPath finderPath = _finderPathCountByTEI_FI;

		Object[] finderArgs = new Object[] {ticketEntryId, fieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TICKETINFORMATION_WHERE);

			query.append(_FINDER_COLUMN_TEI_FI_TICKETENTRYID_2);

			query.append(_FINDER_COLUMN_TEI_FI_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				qPos.add(fieldId);

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

	private static final String _FINDER_COLUMN_TEI_FI_TICKETENTRYID_2 =
		"ticketInformation.ticketEntryId = ? AND ";

	private static final String _FINDER_COLUMN_TEI_FI_FIELDID_2 =
		"ticketInformation.fieldId = ?";

	public TicketInformationPersistenceImpl() {
		setModelClass(TicketInformation.class);

		setModelImplClass(TicketInformationImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("data", "data_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ticket information in the entity cache if it is enabled.
	 *
	 * @param ticketInformation the ticket information
	 */
	@Override
	public void cacheResult(TicketInformation ticketInformation) {
		entityCache.putResult(
			entityCacheEnabled, TicketInformationImpl.class,
			ticketInformation.getPrimaryKey(), ticketInformation);

		finderCache.putResult(
			_finderPathFetchByTEI_FI,
			new Object[] {
				ticketInformation.getTicketEntryId(),
				ticketInformation.getFieldId()
			},
			ticketInformation);

		ticketInformation.resetOriginalValues();
	}

	/**
	 * Caches the ticket informations in the entity cache if it is enabled.
	 *
	 * @param ticketInformations the ticket informations
	 */
	@Override
	public void cacheResult(List<TicketInformation> ticketInformations) {
		for (TicketInformation ticketInformation : ticketInformations) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketInformationImpl.class,
					ticketInformation.getPrimaryKey()) == null) {

				cacheResult(ticketInformation);
			}
			else {
				ticketInformation.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket informations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketInformationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket information.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketInformation ticketInformation) {
		entityCache.removeResult(
			entityCacheEnabled, TicketInformationImpl.class,
			ticketInformation.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(TicketInformationModelImpl)ticketInformation, true);
	}

	@Override
	public void clearCache(List<TicketInformation> ticketInformations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketInformation ticketInformation : ticketInformations) {
			entityCache.removeResult(
				entityCacheEnabled, TicketInformationImpl.class,
				ticketInformation.getPrimaryKey());

			clearUniqueFindersCache(
				(TicketInformationModelImpl)ticketInformation, true);
		}
	}

	protected void cacheUniqueFindersCache(
		TicketInformationModelImpl ticketInformationModelImpl) {

		Object[] args = new Object[] {
			ticketInformationModelImpl.getTicketEntryId(),
			ticketInformationModelImpl.getFieldId()
		};

		finderCache.putResult(
			_finderPathCountByTEI_FI, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByTEI_FI, args, ticketInformationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TicketInformationModelImpl ticketInformationModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				ticketInformationModelImpl.getTicketEntryId(),
				ticketInformationModelImpl.getFieldId()
			};

			finderCache.removeResult(_finderPathCountByTEI_FI, args);
			finderCache.removeResult(_finderPathFetchByTEI_FI, args);
		}

		if ((ticketInformationModelImpl.getColumnBitmask() &
			 _finderPathFetchByTEI_FI.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ticketInformationModelImpl.getOriginalTicketEntryId(),
				ticketInformationModelImpl.getOriginalFieldId()
			};

			finderCache.removeResult(_finderPathCountByTEI_FI, args);
			finderCache.removeResult(_finderPathFetchByTEI_FI, args);
		}
	}

	/**
	 * Creates a new ticket information with the primary key. Does not add the ticket information to the database.
	 *
	 * @param ticketInformationId the primary key for the new ticket information
	 * @return the new ticket information
	 */
	@Override
	public TicketInformation create(long ticketInformationId) {
		TicketInformation ticketInformation = new TicketInformationImpl();

		ticketInformation.setNew(true);
		ticketInformation.setPrimaryKey(ticketInformationId);

		return ticketInformation;
	}

	/**
	 * Removes the ticket information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketInformationId the primary key of the ticket information
	 * @return the ticket information that was removed
	 * @throws NoSuchTicketInformationException if a ticket information with the primary key could not be found
	 */
	@Override
	public TicketInformation remove(long ticketInformationId)
		throws NoSuchTicketInformationException {

		return remove((Serializable)ticketInformationId);
	}

	/**
	 * Removes the ticket information with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket information
	 * @return the ticket information that was removed
	 * @throws NoSuchTicketInformationException if a ticket information with the primary key could not be found
	 */
	@Override
	public TicketInformation remove(Serializable primaryKey)
		throws NoSuchTicketInformationException {

		Session session = null;

		try {
			session = openSession();

			TicketInformation ticketInformation =
				(TicketInformation)session.get(
					TicketInformationImpl.class, primaryKey);

			if (ticketInformation == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketInformationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketInformation);
		}
		catch (NoSuchTicketInformationException nsee) {
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
	protected TicketInformation removeImpl(
		TicketInformation ticketInformation) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketInformation)) {
				ticketInformation = (TicketInformation)session.get(
					TicketInformationImpl.class,
					ticketInformation.getPrimaryKeyObj());
			}

			if (ticketInformation != null) {
				session.delete(ticketInformation);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketInformation != null) {
			clearCache(ticketInformation);
		}

		return ticketInformation;
	}

	@Override
	public TicketInformation updateImpl(TicketInformation ticketInformation) {
		boolean isNew = ticketInformation.isNew();

		if (!(ticketInformation instanceof TicketInformationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketInformation.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ticketInformation);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketInformation proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketInformation implementation " +
					ticketInformation.getClass());
		}

		TicketInformationModelImpl ticketInformationModelImpl =
			(TicketInformationModelImpl)ticketInformation;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ticketInformation.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketInformation.setCreateDate(now);
			}
			else {
				ticketInformation.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!ticketInformationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketInformation.setModifiedDate(now);
			}
			else {
				ticketInformation.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ticketInformation.isNew()) {
				session.save(ticketInformation);

				ticketInformation.setNew(false);
			}
			else {
				ticketInformation = (TicketInformation)session.merge(
					ticketInformation);
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
				ticketInformationModelImpl.getTicketEntryId()
			};

			finderCache.removeResult(_finderPathCountByTicketEntryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTicketEntryId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ticketInformationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTicketEntryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ticketInformationModelImpl.getOriginalTicketEntryId()
				};

				finderCache.removeResult(_finderPathCountByTicketEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketEntryId, args);

				args = new Object[] {
					ticketInformationModelImpl.getTicketEntryId()
				};

				finderCache.removeResult(_finderPathCountByTicketEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketEntryId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TicketInformationImpl.class,
			ticketInformation.getPrimaryKey(), ticketInformation, false);

		clearUniqueFindersCache(ticketInformationModelImpl, false);
		cacheUniqueFindersCache(ticketInformationModelImpl);

		ticketInformation.resetOriginalValues();

		return ticketInformation;
	}

	/**
	 * Returns the ticket information with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket information
	 * @return the ticket information
	 * @throws NoSuchTicketInformationException if a ticket information with the primary key could not be found
	 */
	@Override
	public TicketInformation findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketInformationException {

		TicketInformation ticketInformation = fetchByPrimaryKey(primaryKey);

		if (ticketInformation == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketInformationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketInformation;
	}

	/**
	 * Returns the ticket information with the primary key or throws a <code>NoSuchTicketInformationException</code> if it could not be found.
	 *
	 * @param ticketInformationId the primary key of the ticket information
	 * @return the ticket information
	 * @throws NoSuchTicketInformationException if a ticket information with the primary key could not be found
	 */
	@Override
	public TicketInformation findByPrimaryKey(long ticketInformationId)
		throws NoSuchTicketInformationException {

		return findByPrimaryKey((Serializable)ticketInformationId);
	}

	/**
	 * Returns the ticket information with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketInformationId the primary key of the ticket information
	 * @return the ticket information, or <code>null</code> if a ticket information with the primary key could not be found
	 */
	@Override
	public TicketInformation fetchByPrimaryKey(long ticketInformationId) {
		return fetchByPrimaryKey((Serializable)ticketInformationId);
	}

	/**
	 * Returns all the ticket informations.
	 *
	 * @return the ticket informations
	 */
	@Override
	public List<TicketInformation> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketInformationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket informations
	 * @param end the upper bound of the range of ticket informations (not inclusive)
	 * @return the range of ticket informations
	 */
	@Override
	public List<TicketInformation> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketInformationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket informations
	 * @param end the upper bound of the range of ticket informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket informations
	 */
	@Override
	public List<TicketInformation> findAll(
		int start, int end,
		OrderByComparator<TicketInformation> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket informations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketInformationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket informations
	 * @param end the upper bound of the range of ticket informations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket informations
	 */
	@Override
	public List<TicketInformation> findAll(
		int start, int end,
		OrderByComparator<TicketInformation> orderByComparator,
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

		List<TicketInformation> list = null;

		if (retrieveFromCache) {
			list = (List<TicketInformation>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETINFORMATION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETINFORMATION;

				if (pagination) {
					sql = sql.concat(TicketInformationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketInformation>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketInformation>)QueryUtil.list(
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
	 * Removes all the ticket informations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketInformation ticketInformation : findAll()) {
			remove(ticketInformation);
		}
	}

	/**
	 * Returns the number of ticket informations.
	 *
	 * @return the number of ticket informations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETINFORMATION);

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
		return "ticketInformationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETINFORMATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketInformationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket information persistence.
	 */
	@Activate
	public void activate() {
		TicketInformationModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketInformationModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTicketEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketInformationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTicketEntryId",
			new String[] {Long.class.getName()},
			TicketInformationModelImpl.TICKETENTRYID_COLUMN_BITMASK);

		_finderPathCountByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketEntryId",
			new String[] {Long.class.getName()});

		_finderPathFetchByTEI_FI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketInformationImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByTEI_FI",
			new String[] {Long.class.getName(), Long.class.getName()},
			TicketInformationModelImpl.TICKETENTRYID_COLUMN_BITMASK |
			TicketInformationModelImpl.FIELDID_COLUMN_BITMASK);

		_finderPathCountByTEI_FI = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTEI_FI",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketInformationImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketInformation"),
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

	private static final String _SQL_SELECT_TICKETINFORMATION =
		"SELECT ticketInformation FROM TicketInformation ticketInformation";

	private static final String _SQL_SELECT_TICKETINFORMATION_WHERE =
		"SELECT ticketInformation FROM TicketInformation ticketInformation WHERE ";

	private static final String _SQL_COUNT_TICKETINFORMATION =
		"SELECT COUNT(ticketInformation) FROM TicketInformation ticketInformation";

	private static final String _SQL_COUNT_TICKETINFORMATION_WHERE =
		"SELECT COUNT(ticketInformation) FROM TicketInformation ticketInformation WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketInformation.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketInformation exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketInformation exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketInformationPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"data"});

}