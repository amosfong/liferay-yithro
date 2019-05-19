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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.ticket.exception.NoSuchTicketCommunicationException;
import com.liferay.yithro.ticket.model.TicketCommunication;
import com.liferay.yithro.ticket.model.impl.TicketCommunicationImpl;
import com.liferay.yithro.ticket.model.impl.TicketCommunicationModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketCommunicationPersistence;
import com.liferay.yithro.ticket.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ticket communication service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketCommunicationPersistence.class)
@ProviderType
public class TicketCommunicationPersistenceImpl
	extends BasePersistenceImpl<TicketCommunication>
	implements TicketCommunicationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketCommunicationUtil</code> to access the ticket communication persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketCommunicationImpl.class.getName();

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
	 * Returns all the ticket communications where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the matching ticket communications
	 */
	@Override
	public List<TicketCommunication> findByTicketEntryId(long ticketEntryId) {
		return findByTicketEntryId(
			ticketEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket communications where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @return the range of matching ticket communications
	 */
	@Override
	public List<TicketCommunication> findByTicketEntryId(
		long ticketEntryId, int start, int end) {

		return findByTicketEntryId(ticketEntryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket communications where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket communications
	 */
	@Override
	public List<TicketCommunication> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator) {

		return findByTicketEntryId(
			ticketEntryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket communications where ticketEntryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching ticket communications
	 */
	@Override
	public List<TicketCommunication> findByTicketEntryId(
		long ticketEntryId, int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator,
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

		List<TicketCommunication> list = null;

		if (retrieveFromCache) {
			list = (List<TicketCommunication>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketCommunication ticketCommunication : list) {
					if ((ticketEntryId !=
							ticketCommunication.getTicketEntryId())) {

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

			query.append(_SQL_SELECT_TICKETCOMMUNICATION_WHERE);

			query.append(_FINDER_COLUMN_TICKETENTRYID_TICKETENTRYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketCommunicationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketEntryId);

				if (!pagination) {
					list = (List<TicketCommunication>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketCommunication>)QueryUtil.list(
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
	 * Returns the first ticket communication in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket communication
	 * @throws NoSuchTicketCommunicationException if a matching ticket communication could not be found
	 */
	@Override
	public TicketCommunication findByTicketEntryId_First(
			long ticketEntryId,
			OrderByComparator<TicketCommunication> orderByComparator)
		throws NoSuchTicketCommunicationException {

		TicketCommunication ticketCommunication = fetchByTicketEntryId_First(
			ticketEntryId, orderByComparator);

		if (ticketCommunication != null) {
			return ticketCommunication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append("}");

		throw new NoSuchTicketCommunicationException(msg.toString());
	}

	/**
	 * Returns the first ticket communication in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket communication, or <code>null</code> if a matching ticket communication could not be found
	 */
	@Override
	public TicketCommunication fetchByTicketEntryId_First(
		long ticketEntryId,
		OrderByComparator<TicketCommunication> orderByComparator) {

		List<TicketCommunication> list = findByTicketEntryId(
			ticketEntryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket communication in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket communication
	 * @throws NoSuchTicketCommunicationException if a matching ticket communication could not be found
	 */
	@Override
	public TicketCommunication findByTicketEntryId_Last(
			long ticketEntryId,
			OrderByComparator<TicketCommunication> orderByComparator)
		throws NoSuchTicketCommunicationException {

		TicketCommunication ticketCommunication = fetchByTicketEntryId_Last(
			ticketEntryId, orderByComparator);

		if (ticketCommunication != null) {
			return ticketCommunication;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketEntryId=");
		msg.append(ticketEntryId);

		msg.append("}");

		throw new NoSuchTicketCommunicationException(msg.toString());
	}

	/**
	 * Returns the last ticket communication in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket communication, or <code>null</code> if a matching ticket communication could not be found
	 */
	@Override
	public TicketCommunication fetchByTicketEntryId_Last(
		long ticketEntryId,
		OrderByComparator<TicketCommunication> orderByComparator) {

		int count = countByTicketEntryId(ticketEntryId);

		if (count == 0) {
			return null;
		}

		List<TicketCommunication> list = findByTicketEntryId(
			ticketEntryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket communications before and after the current ticket communication in the ordered set where ticketEntryId = &#63;.
	 *
	 * @param ticketCommunicationId the primary key of the current ticket communication
	 * @param ticketEntryId the ticket entry ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket communication
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	@Override
	public TicketCommunication[] findByTicketEntryId_PrevAndNext(
			long ticketCommunicationId, long ticketEntryId,
			OrderByComparator<TicketCommunication> orderByComparator)
		throws NoSuchTicketCommunicationException {

		TicketCommunication ticketCommunication = findByPrimaryKey(
			ticketCommunicationId);

		Session session = null;

		try {
			session = openSession();

			TicketCommunication[] array = new TicketCommunicationImpl[3];

			array[0] = getByTicketEntryId_PrevAndNext(
				session, ticketCommunication, ticketEntryId, orderByComparator,
				true);

			array[1] = ticketCommunication;

			array[2] = getByTicketEntryId_PrevAndNext(
				session, ticketCommunication, ticketEntryId, orderByComparator,
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

	protected TicketCommunication getByTicketEntryId_PrevAndNext(
		Session session, TicketCommunication ticketCommunication,
		long ticketEntryId,
		OrderByComparator<TicketCommunication> orderByComparator,
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

		query.append(_SQL_SELECT_TICKETCOMMUNICATION_WHERE);

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
			query.append(TicketCommunicationModelImpl.ORDER_BY_JPQL);
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
						ticketCommunication)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketCommunication> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket communications where ticketEntryId = &#63; from the database.
	 *
	 * @param ticketEntryId the ticket entry ID
	 */
	@Override
	public void removeByTicketEntryId(long ticketEntryId) {
		for (TicketCommunication ticketCommunication :
				findByTicketEntryId(
					ticketEntryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketCommunication);
		}
	}

	/**
	 * Returns the number of ticket communications where ticketEntryId = &#63;.
	 *
	 * @param ticketEntryId the ticket entry ID
	 * @return the number of matching ticket communications
	 */
	@Override
	public int countByTicketEntryId(long ticketEntryId) {
		FinderPath finderPath = _finderPathCountByTicketEntryId;

		Object[] finderArgs = new Object[] {ticketEntryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETCOMMUNICATION_WHERE);

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
		"ticketCommunication.ticketEntryId = ?";

	private FinderPath _finderPathFetchByC_C;
	private FinderPath _finderPathCountByC_C;

	/**
	 * Returns the ticket communication where classNameId = &#63; and classPK = &#63; or throws a <code>NoSuchTicketCommunicationException</code> if it could not be found.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching ticket communication
	 * @throws NoSuchTicketCommunicationException if a matching ticket communication could not be found
	 */
	@Override
	public TicketCommunication findByC_C(long classNameId, long classPK)
		throws NoSuchTicketCommunicationException {

		TicketCommunication ticketCommunication = fetchByC_C(
			classNameId, classPK);

		if (ticketCommunication == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("classNameId=");
			msg.append(classNameId);

			msg.append(", classPK=");
			msg.append(classPK);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTicketCommunicationException(msg.toString());
		}

		return ticketCommunication;
	}

	/**
	 * Returns the ticket communication where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the matching ticket communication, or <code>null</code> if a matching ticket communication could not be found
	 */
	@Override
	public TicketCommunication fetchByC_C(long classNameId, long classPK) {
		return fetchByC_C(classNameId, classPK, true);
	}

	/**
	 * Returns the ticket communication where classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching ticket communication, or <code>null</code> if a matching ticket communication could not be found
	 */
	@Override
	public TicketCommunication fetchByC_C(
		long classNameId, long classPK, boolean retrieveFromCache) {

		Object[] finderArgs = new Object[] {classNameId, classPK};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByC_C, finderArgs, this);
		}

		if (result instanceof TicketCommunication) {
			TicketCommunication ticketCommunication =
				(TicketCommunication)result;

			if ((classNameId != ticketCommunication.getClassNameId()) ||
				(classPK != ticketCommunication.getClassPK())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_TICKETCOMMUNICATION_WHERE);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

				List<TicketCommunication> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByC_C, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"TicketCommunicationPersistenceImpl.fetchByC_C(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TicketCommunication ticketCommunication = list.get(0);

					result = ticketCommunication;

					cacheResult(ticketCommunication);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByC_C, finderArgs);

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
			return (TicketCommunication)result;
		}
	}

	/**
	 * Removes the ticket communication where classNameId = &#63; and classPK = &#63; from the database.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the ticket communication that was removed
	 */
	@Override
	public TicketCommunication removeByC_C(long classNameId, long classPK)
		throws NoSuchTicketCommunicationException {

		TicketCommunication ticketCommunication = findByC_C(
			classNameId, classPK);

		return remove(ticketCommunication);
	}

	/**
	 * Returns the number of ticket communications where classNameId = &#63; and classPK = &#63;.
	 *
	 * @param classNameId the class name ID
	 * @param classPK the class pk
	 * @return the number of matching ticket communications
	 */
	@Override
	public int countByC_C(long classNameId, long classPK) {
		FinderPath finderPath = _finderPathCountByC_C;

		Object[] finderArgs = new Object[] {classNameId, classPK};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TICKETCOMMUNICATION_WHERE);

			query.append(_FINDER_COLUMN_C_C_CLASSNAMEID_2);

			query.append(_FINDER_COLUMN_C_C_CLASSPK_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(classNameId);

				qPos.add(classPK);

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

	private static final String _FINDER_COLUMN_C_C_CLASSNAMEID_2 =
		"ticketCommunication.classNameId = ? AND ";

	private static final String _FINDER_COLUMN_C_C_CLASSPK_2 =
		"ticketCommunication.classPK = ?";

	public TicketCommunicationPersistenceImpl() {
		setModelClass(TicketCommunication.class);

		setModelImplClass(TicketCommunicationImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the ticket communication in the entity cache if it is enabled.
	 *
	 * @param ticketCommunication the ticket communication
	 */
	@Override
	public void cacheResult(TicketCommunication ticketCommunication) {
		entityCache.putResult(
			entityCacheEnabled, TicketCommunicationImpl.class,
			ticketCommunication.getPrimaryKey(), ticketCommunication);

		finderCache.putResult(
			_finderPathFetchByC_C,
			new Object[] {
				ticketCommunication.getClassNameId(),
				ticketCommunication.getClassPK()
			},
			ticketCommunication);

		ticketCommunication.resetOriginalValues();
	}

	/**
	 * Caches the ticket communications in the entity cache if it is enabled.
	 *
	 * @param ticketCommunications the ticket communications
	 */
	@Override
	public void cacheResult(List<TicketCommunication> ticketCommunications) {
		for (TicketCommunication ticketCommunication : ticketCommunications) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketCommunicationImpl.class,
					ticketCommunication.getPrimaryKey()) == null) {

				cacheResult(ticketCommunication);
			}
			else {
				ticketCommunication.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket communications.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketCommunicationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket communication.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketCommunication ticketCommunication) {
		entityCache.removeResult(
			entityCacheEnabled, TicketCommunicationImpl.class,
			ticketCommunication.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(TicketCommunicationModelImpl)ticketCommunication, true);
	}

	@Override
	public void clearCache(List<TicketCommunication> ticketCommunications) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketCommunication ticketCommunication : ticketCommunications) {
			entityCache.removeResult(
				entityCacheEnabled, TicketCommunicationImpl.class,
				ticketCommunication.getPrimaryKey());

			clearUniqueFindersCache(
				(TicketCommunicationModelImpl)ticketCommunication, true);
		}
	}

	protected void cacheUniqueFindersCache(
		TicketCommunicationModelImpl ticketCommunicationModelImpl) {

		Object[] args = new Object[] {
			ticketCommunicationModelImpl.getClassNameId(),
			ticketCommunicationModelImpl.getClassPK()
		};

		finderCache.putResult(
			_finderPathCountByC_C, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByC_C, args, ticketCommunicationModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TicketCommunicationModelImpl ticketCommunicationModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				ticketCommunicationModelImpl.getClassNameId(),
				ticketCommunicationModelImpl.getClassPK()
			};

			finderCache.removeResult(_finderPathCountByC_C, args);
			finderCache.removeResult(_finderPathFetchByC_C, args);
		}

		if ((ticketCommunicationModelImpl.getColumnBitmask() &
			 _finderPathFetchByC_C.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ticketCommunicationModelImpl.getOriginalClassNameId(),
				ticketCommunicationModelImpl.getOriginalClassPK()
			};

			finderCache.removeResult(_finderPathCountByC_C, args);
			finderCache.removeResult(_finderPathFetchByC_C, args);
		}
	}

	/**
	 * Creates a new ticket communication with the primary key. Does not add the ticket communication to the database.
	 *
	 * @param ticketCommunicationId the primary key for the new ticket communication
	 * @return the new ticket communication
	 */
	@Override
	public TicketCommunication create(long ticketCommunicationId) {
		TicketCommunication ticketCommunication = new TicketCommunicationImpl();

		ticketCommunication.setNew(true);
		ticketCommunication.setPrimaryKey(ticketCommunicationId);

		ticketCommunication.setCompanyId(companyProvider.getCompanyId());

		return ticketCommunication;
	}

	/**
	 * Removes the ticket communication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication that was removed
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	@Override
	public TicketCommunication remove(long ticketCommunicationId)
		throws NoSuchTicketCommunicationException {

		return remove((Serializable)ticketCommunicationId);
	}

	/**
	 * Removes the ticket communication with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket communication
	 * @return the ticket communication that was removed
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	@Override
	public TicketCommunication remove(Serializable primaryKey)
		throws NoSuchTicketCommunicationException {

		Session session = null;

		try {
			session = openSession();

			TicketCommunication ticketCommunication =
				(TicketCommunication)session.get(
					TicketCommunicationImpl.class, primaryKey);

			if (ticketCommunication == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketCommunicationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketCommunication);
		}
		catch (NoSuchTicketCommunicationException nsee) {
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
	protected TicketCommunication removeImpl(
		TicketCommunication ticketCommunication) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketCommunication)) {
				ticketCommunication = (TicketCommunication)session.get(
					TicketCommunicationImpl.class,
					ticketCommunication.getPrimaryKeyObj());
			}

			if (ticketCommunication != null) {
				session.delete(ticketCommunication);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketCommunication != null) {
			clearCache(ticketCommunication);
		}

		return ticketCommunication;
	}

	@Override
	public TicketCommunication updateImpl(
		TicketCommunication ticketCommunication) {

		boolean isNew = ticketCommunication.isNew();

		if (!(ticketCommunication instanceof TicketCommunicationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketCommunication.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ticketCommunication);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketCommunication proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketCommunication implementation " +
					ticketCommunication.getClass());
		}

		TicketCommunicationModelImpl ticketCommunicationModelImpl =
			(TicketCommunicationModelImpl)ticketCommunication;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ticketCommunication.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketCommunication.setCreateDate(now);
			}
			else {
				ticketCommunication.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!ticketCommunicationModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketCommunication.setModifiedDate(now);
			}
			else {
				ticketCommunication.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ticketCommunication.isNew()) {
				session.save(ticketCommunication);

				ticketCommunication.setNew(false);
			}
			else {
				ticketCommunication = (TicketCommunication)session.merge(
					ticketCommunication);
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
				ticketCommunicationModelImpl.getTicketEntryId()
			};

			finderCache.removeResult(_finderPathCountByTicketEntryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTicketEntryId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ticketCommunicationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTicketEntryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ticketCommunicationModelImpl.getOriginalTicketEntryId()
				};

				finderCache.removeResult(_finderPathCountByTicketEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketEntryId, args);

				args = new Object[] {
					ticketCommunicationModelImpl.getTicketEntryId()
				};

				finderCache.removeResult(_finderPathCountByTicketEntryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketEntryId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TicketCommunicationImpl.class,
			ticketCommunication.getPrimaryKey(), ticketCommunication, false);

		clearUniqueFindersCache(ticketCommunicationModelImpl, false);
		cacheUniqueFindersCache(ticketCommunicationModelImpl);

		ticketCommunication.resetOriginalValues();

		return ticketCommunication;
	}

	/**
	 * Returns the ticket communication with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket communication
	 * @return the ticket communication
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	@Override
	public TicketCommunication findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketCommunicationException {

		TicketCommunication ticketCommunication = fetchByPrimaryKey(primaryKey);

		if (ticketCommunication == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketCommunicationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketCommunication;
	}

	/**
	 * Returns the ticket communication with the primary key or throws a <code>NoSuchTicketCommunicationException</code> if it could not be found.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication
	 * @throws NoSuchTicketCommunicationException if a ticket communication with the primary key could not be found
	 */
	@Override
	public TicketCommunication findByPrimaryKey(long ticketCommunicationId)
		throws NoSuchTicketCommunicationException {

		return findByPrimaryKey((Serializable)ticketCommunicationId);
	}

	/**
	 * Returns the ticket communication with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketCommunicationId the primary key of the ticket communication
	 * @return the ticket communication, or <code>null</code> if a ticket communication with the primary key could not be found
	 */
	@Override
	public TicketCommunication fetchByPrimaryKey(long ticketCommunicationId) {
		return fetchByPrimaryKey((Serializable)ticketCommunicationId);
	}

	/**
	 * Returns all the ticket communications.
	 *
	 * @return the ticket communications
	 */
	@Override
	public List<TicketCommunication> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @return the range of ticket communications
	 */
	@Override
	public List<TicketCommunication> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket communications
	 */
	@Override
	public List<TicketCommunication> findAll(
		int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket communications.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommunicationModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket communications
	 * @param end the upper bound of the range of ticket communications (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket communications
	 */
	@Override
	public List<TicketCommunication> findAll(
		int start, int end,
		OrderByComparator<TicketCommunication> orderByComparator,
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

		List<TicketCommunication> list = null;

		if (retrieveFromCache) {
			list = (List<TicketCommunication>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETCOMMUNICATION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETCOMMUNICATION;

				if (pagination) {
					sql = sql.concat(
						TicketCommunicationModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketCommunication>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketCommunication>)QueryUtil.list(
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
	 * Removes all the ticket communications from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketCommunication ticketCommunication : findAll()) {
			remove(ticketCommunication);
		}
	}

	/**
	 * Returns the number of ticket communications.
	 *
	 * @return the number of ticket communications
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETCOMMUNICATION);

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
		return "ticketCommunicationId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETCOMMUNICATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketCommunicationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket communication persistence.
	 */
	@Activate
	public void activate() {
		TicketCommunicationModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketCommunicationModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TicketCommunicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TicketCommunicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TicketCommunicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTicketEntryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TicketCommunicationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTicketEntryId",
			new String[] {Long.class.getName()},
			TicketCommunicationModelImpl.TICKETENTRYID_COLUMN_BITMASK |
			TicketCommunicationModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByTicketEntryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketEntryId",
			new String[] {Long.class.getName()});

		_finderPathFetchByC_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TicketCommunicationImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByC_C",
			new String[] {Long.class.getName(), Long.class.getName()},
			TicketCommunicationModelImpl.CLASSNAMEID_COLUMN_BITMASK |
			TicketCommunicationModelImpl.CLASSPK_COLUMN_BITMASK);

		_finderPathCountByC_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_C",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketCommunicationImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketCommunication"),
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

	private static final String _SQL_SELECT_TICKETCOMMUNICATION =
		"SELECT ticketCommunication FROM TicketCommunication ticketCommunication";

	private static final String _SQL_SELECT_TICKETCOMMUNICATION_WHERE =
		"SELECT ticketCommunication FROM TicketCommunication ticketCommunication WHERE ";

	private static final String _SQL_COUNT_TICKETCOMMUNICATION =
		"SELECT COUNT(ticketCommunication) FROM TicketCommunication ticketCommunication";

	private static final String _SQL_COUNT_TICKETCOMMUNICATION_WHERE =
		"SELECT COUNT(ticketCommunication) FROM TicketCommunication ticketCommunication WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketCommunication.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketCommunication exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketCommunication exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketCommunicationPersistenceImpl.class);

}