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
import com.liferay.yithro.ticket.exception.NoSuchTicketFieldOptionException;
import com.liferay.yithro.ticket.model.TicketFieldOption;
import com.liferay.yithro.ticket.model.impl.TicketFieldOptionImpl;
import com.liferay.yithro.ticket.model.impl.TicketFieldOptionModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketFieldOptionPersistence;
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
 * The persistence implementation for the ticket field option service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketFieldOptionPersistence.class)
public class TicketFieldOptionPersistenceImpl
	extends BasePersistenceImpl<TicketFieldOption>
	implements TicketFieldOptionPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketFieldOptionUtil</code> to access the ticket field option persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketFieldOptionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByTicketFieldId;
	private FinderPath _finderPathWithoutPaginationFindByTicketFieldId;
	private FinderPath _finderPathCountByTicketFieldId;

	/**
	 * Returns all the ticket field options where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @return the matching ticket field options
	 */
	@Override
	public List<TicketFieldOption> findByTicketFieldId(long ticketFieldId) {
		return findByTicketFieldId(
			ticketFieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of matching ticket field options
	 */
	@Override
	public List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end) {

		return findByTicketFieldId(ticketFieldId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket field options
	 */
	@Override
	public List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return findByTicketFieldId(
			ticketFieldId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket field options
	 */
	@Override
	public List<TicketFieldOption> findByTicketFieldId(
		long ticketFieldId, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTicketFieldId;
				finderArgs = new Object[] {ticketFieldId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTicketFieldId;
			finderArgs = new Object[] {
				ticketFieldId, start, end, orderByComparator
			};
		}

		List<TicketFieldOption> list = null;

		if (useFinderCache) {
			list = (List<TicketFieldOption>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketFieldOption ticketFieldOption : list) {
					if ((ticketFieldId !=
							ticketFieldOption.getTicketFieldId())) {

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

			query.append(_SQL_SELECT_TICKETFIELDOPTION_WHERE);

			query.append(_FINDER_COLUMN_TICKETFIELDID_TICKETFIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketFieldOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketFieldId);

				if (!pagination) {
					list = (List<TicketFieldOption>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketFieldOption>)QueryUtil.list(
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
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	@Override
	public TicketFieldOption findByTicketFieldId_First(
			long ticketFieldId,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws NoSuchTicketFieldOptionException {

		TicketFieldOption ticketFieldOption = fetchByTicketFieldId_First(
			ticketFieldId, orderByComparator);

		if (ticketFieldOption != null) {
			return ticketFieldOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketFieldId=");
		msg.append(ticketFieldId);

		msg.append("}");

		throw new NoSuchTicketFieldOptionException(msg.toString());
	}

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	@Override
	public TicketFieldOption fetchByTicketFieldId_First(
		long ticketFieldId,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		List<TicketFieldOption> list = findByTicketFieldId(
			ticketFieldId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	@Override
	public TicketFieldOption findByTicketFieldId_Last(
			long ticketFieldId,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws NoSuchTicketFieldOptionException {

		TicketFieldOption ticketFieldOption = fetchByTicketFieldId_Last(
			ticketFieldId, orderByComparator);

		if (ticketFieldOption != null) {
			return ticketFieldOption;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketFieldId=");
		msg.append(ticketFieldId);

		msg.append("}");

		throw new NoSuchTicketFieldOptionException(msg.toString());
	}

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	@Override
	public TicketFieldOption fetchByTicketFieldId_Last(
		long ticketFieldId,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		int count = countByTicketFieldId(ticketFieldId);

		if (count == 0) {
			return null;
		}

		List<TicketFieldOption> list = findByTicketFieldId(
			ticketFieldId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket field options before and after the current ticket field option in the ordered set where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldOptionId the primary key of the current ticket field option
	 * @param ticketFieldId the ticket field ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	@Override
	public TicketFieldOption[] findByTicketFieldId_PrevAndNext(
			long ticketFieldOptionId, long ticketFieldId,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws NoSuchTicketFieldOptionException {

		TicketFieldOption ticketFieldOption = findByPrimaryKey(
			ticketFieldOptionId);

		Session session = null;

		try {
			session = openSession();

			TicketFieldOption[] array = new TicketFieldOptionImpl[3];

			array[0] = getByTicketFieldId_PrevAndNext(
				session, ticketFieldOption, ticketFieldId, orderByComparator,
				true);

			array[1] = ticketFieldOption;

			array[2] = getByTicketFieldId_PrevAndNext(
				session, ticketFieldOption, ticketFieldId, orderByComparator,
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

	protected TicketFieldOption getByTicketFieldId_PrevAndNext(
		Session session, TicketFieldOption ticketFieldOption,
		long ticketFieldId,
		OrderByComparator<TicketFieldOption> orderByComparator,
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

		query.append(_SQL_SELECT_TICKETFIELDOPTION_WHERE);

		query.append(_FINDER_COLUMN_TICKETFIELDID_TICKETFIELDID_2);

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
			query.append(TicketFieldOptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketFieldId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ticketFieldOption)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketFieldOption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket field options where ticketFieldId = &#63; from the database.
	 *
	 * @param ticketFieldId the ticket field ID
	 */
	@Override
	public void removeByTicketFieldId(long ticketFieldId) {
		for (TicketFieldOption ticketFieldOption :
				findByTicketFieldId(
					ticketFieldId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketFieldOption);
		}
	}

	/**
	 * Returns the number of ticket field options where ticketFieldId = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @return the number of matching ticket field options
	 */
	@Override
	public int countByTicketFieldId(long ticketFieldId) {
		FinderPath finderPath = _finderPathCountByTicketFieldId;

		Object[] finderArgs = new Object[] {ticketFieldId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETFIELDOPTION_WHERE);

			query.append(_FINDER_COLUMN_TICKETFIELDID_TICKETFIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketFieldId);

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

	private static final String _FINDER_COLUMN_TICKETFIELDID_TICKETFIELDID_2 =
		"ticketFieldOption.ticketFieldId = ?";

	private FinderPath _finderPathWithPaginationFindByTFI_S;
	private FinderPath _finderPathWithoutPaginationFindByTFI_S;
	private FinderPath _finderPathCountByTFI_S;

	/**
	 * Returns all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @return the matching ticket field options
	 */
	@Override
	public List<TicketFieldOption> findByTFI_S(long ticketFieldId, int status) {
		return findByTFI_S(
			ticketFieldId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of matching ticket field options
	 */
	@Override
	public List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end) {

		return findByTFI_S(ticketFieldId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket field options
	 */
	@Override
	public List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return findByTFI_S(
			ticketFieldId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket field options
	 */
	@Override
	public List<TicketFieldOption> findByTFI_S(
		long ticketFieldId, int status, int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTFI_S;
				finderArgs = new Object[] {ticketFieldId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTFI_S;
			finderArgs = new Object[] {
				ticketFieldId, status, start, end, orderByComparator
			};
		}

		List<TicketFieldOption> list = null;

		if (useFinderCache) {
			list = (List<TicketFieldOption>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketFieldOption ticketFieldOption : list) {
					if ((ticketFieldId !=
							ticketFieldOption.getTicketFieldId()) ||
						(status != ticketFieldOption.getStatus())) {

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

			query.append(_SQL_SELECT_TICKETFIELDOPTION_WHERE);

			query.append(_FINDER_COLUMN_TFI_S_TICKETFIELDID_2);

			query.append(_FINDER_COLUMN_TFI_S_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketFieldOptionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketFieldId);

				qPos.add(status);

				if (!pagination) {
					list = (List<TicketFieldOption>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketFieldOption>)QueryUtil.list(
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
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	@Override
	public TicketFieldOption findByTFI_S_First(
			long ticketFieldId, int status,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws NoSuchTicketFieldOptionException {

		TicketFieldOption ticketFieldOption = fetchByTFI_S_First(
			ticketFieldId, status, orderByComparator);

		if (ticketFieldOption != null) {
			return ticketFieldOption;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketFieldId=");
		msg.append(ticketFieldId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTicketFieldOptionException(msg.toString());
	}

	/**
	 * Returns the first ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	@Override
	public TicketFieldOption fetchByTFI_S_First(
		long ticketFieldId, int status,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		List<TicketFieldOption> list = findByTFI_S(
			ticketFieldId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option
	 * @throws NoSuchTicketFieldOptionException if a matching ticket field option could not be found
	 */
	@Override
	public TicketFieldOption findByTFI_S_Last(
			long ticketFieldId, int status,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws NoSuchTicketFieldOptionException {

		TicketFieldOption ticketFieldOption = fetchByTFI_S_Last(
			ticketFieldId, status, orderByComparator);

		if (ticketFieldOption != null) {
			return ticketFieldOption;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ticketFieldId=");
		msg.append(ticketFieldId);

		msg.append(", status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTicketFieldOptionException(msg.toString());
	}

	/**
	 * Returns the last ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field option, or <code>null</code> if a matching ticket field option could not be found
	 */
	@Override
	public TicketFieldOption fetchByTFI_S_Last(
		long ticketFieldId, int status,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		int count = countByTFI_S(ticketFieldId, status);

		if (count == 0) {
			return null;
		}

		List<TicketFieldOption> list = findByTFI_S(
			ticketFieldId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket field options before and after the current ticket field option in the ordered set where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldOptionId the primary key of the current ticket field option
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	@Override
	public TicketFieldOption[] findByTFI_S_PrevAndNext(
			long ticketFieldOptionId, long ticketFieldId, int status,
			OrderByComparator<TicketFieldOption> orderByComparator)
		throws NoSuchTicketFieldOptionException {

		TicketFieldOption ticketFieldOption = findByPrimaryKey(
			ticketFieldOptionId);

		Session session = null;

		try {
			session = openSession();

			TicketFieldOption[] array = new TicketFieldOptionImpl[3];

			array[0] = getByTFI_S_PrevAndNext(
				session, ticketFieldOption, ticketFieldId, status,
				orderByComparator, true);

			array[1] = ticketFieldOption;

			array[2] = getByTFI_S_PrevAndNext(
				session, ticketFieldOption, ticketFieldId, status,
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

	protected TicketFieldOption getByTFI_S_PrevAndNext(
		Session session, TicketFieldOption ticketFieldOption,
		long ticketFieldId, int status,
		OrderByComparator<TicketFieldOption> orderByComparator,
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

		query.append(_SQL_SELECT_TICKETFIELDOPTION_WHERE);

		query.append(_FINDER_COLUMN_TFI_S_TICKETFIELDID_2);

		query.append(_FINDER_COLUMN_TFI_S_STATUS_2);

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
			query.append(TicketFieldOptionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ticketFieldId);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						ticketFieldOption)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketFieldOption> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket field options where ticketFieldId = &#63; and status = &#63; from the database.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 */
	@Override
	public void removeByTFI_S(long ticketFieldId, int status) {
		for (TicketFieldOption ticketFieldOption :
				findByTFI_S(
					ticketFieldId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ticketFieldOption);
		}
	}

	/**
	 * Returns the number of ticket field options where ticketFieldId = &#63; and status = &#63;.
	 *
	 * @param ticketFieldId the ticket field ID
	 * @param status the status
	 * @return the number of matching ticket field options
	 */
	@Override
	public int countByTFI_S(long ticketFieldId, int status) {
		FinderPath finderPath = _finderPathCountByTFI_S;

		Object[] finderArgs = new Object[] {ticketFieldId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_TICKETFIELDOPTION_WHERE);

			query.append(_FINDER_COLUMN_TFI_S_TICKETFIELDID_2);

			query.append(_FINDER_COLUMN_TFI_S_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ticketFieldId);

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

	private static final String _FINDER_COLUMN_TFI_S_TICKETFIELDID_2 =
		"ticketFieldOption.ticketFieldId = ? AND ";

	private static final String _FINDER_COLUMN_TFI_S_STATUS_2 =
		"ticketFieldOption.status = ?";

	public TicketFieldOptionPersistenceImpl() {
		setModelClass(TicketFieldOption.class);

		setModelImplClass(TicketFieldOptionImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("order", "order_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ticket field option in the entity cache if it is enabled.
	 *
	 * @param ticketFieldOption the ticket field option
	 */
	@Override
	public void cacheResult(TicketFieldOption ticketFieldOption) {
		entityCache.putResult(
			entityCacheEnabled, TicketFieldOptionImpl.class,
			ticketFieldOption.getPrimaryKey(), ticketFieldOption);

		ticketFieldOption.resetOriginalValues();
	}

	/**
	 * Caches the ticket field options in the entity cache if it is enabled.
	 *
	 * @param ticketFieldOptions the ticket field options
	 */
	@Override
	public void cacheResult(List<TicketFieldOption> ticketFieldOptions) {
		for (TicketFieldOption ticketFieldOption : ticketFieldOptions) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketFieldOptionImpl.class,
					ticketFieldOption.getPrimaryKey()) == null) {

				cacheResult(ticketFieldOption);
			}
			else {
				ticketFieldOption.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket field options.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketFieldOptionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket field option.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketFieldOption ticketFieldOption) {
		entityCache.removeResult(
			entityCacheEnabled, TicketFieldOptionImpl.class,
			ticketFieldOption.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TicketFieldOption> ticketFieldOptions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketFieldOption ticketFieldOption : ticketFieldOptions) {
			entityCache.removeResult(
				entityCacheEnabled, TicketFieldOptionImpl.class,
				ticketFieldOption.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ticket field option with the primary key. Does not add the ticket field option to the database.
	 *
	 * @param ticketFieldOptionId the primary key for the new ticket field option
	 * @return the new ticket field option
	 */
	@Override
	public TicketFieldOption create(long ticketFieldOptionId) {
		TicketFieldOption ticketFieldOption = new TicketFieldOptionImpl();

		ticketFieldOption.setNew(true);
		ticketFieldOption.setPrimaryKey(ticketFieldOptionId);

		ticketFieldOption.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ticketFieldOption;
	}

	/**
	 * Removes the ticket field option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option that was removed
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	@Override
	public TicketFieldOption remove(long ticketFieldOptionId)
		throws NoSuchTicketFieldOptionException {

		return remove((Serializable)ticketFieldOptionId);
	}

	/**
	 * Removes the ticket field option with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket field option
	 * @return the ticket field option that was removed
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	@Override
	public TicketFieldOption remove(Serializable primaryKey)
		throws NoSuchTicketFieldOptionException {

		Session session = null;

		try {
			session = openSession();

			TicketFieldOption ticketFieldOption =
				(TicketFieldOption)session.get(
					TicketFieldOptionImpl.class, primaryKey);

			if (ticketFieldOption == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketFieldOptionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketFieldOption);
		}
		catch (NoSuchTicketFieldOptionException nsee) {
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
	protected TicketFieldOption removeImpl(
		TicketFieldOption ticketFieldOption) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketFieldOption)) {
				ticketFieldOption = (TicketFieldOption)session.get(
					TicketFieldOptionImpl.class,
					ticketFieldOption.getPrimaryKeyObj());
			}

			if (ticketFieldOption != null) {
				session.delete(ticketFieldOption);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketFieldOption != null) {
			clearCache(ticketFieldOption);
		}

		return ticketFieldOption;
	}

	@Override
	public TicketFieldOption updateImpl(TicketFieldOption ticketFieldOption) {
		boolean isNew = ticketFieldOption.isNew();

		if (!(ticketFieldOption instanceof TicketFieldOptionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketFieldOption.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ticketFieldOption);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketFieldOption proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketFieldOption implementation " +
					ticketFieldOption.getClass());
		}

		TicketFieldOptionModelImpl ticketFieldOptionModelImpl =
			(TicketFieldOptionModelImpl)ticketFieldOption;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ticketFieldOption.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketFieldOption.setCreateDate(now);
			}
			else {
				ticketFieldOption.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!ticketFieldOptionModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketFieldOption.setModifiedDate(now);
			}
			else {
				ticketFieldOption.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ticketFieldOption.isNew()) {
				session.save(ticketFieldOption);

				ticketFieldOption.setNew(false);
			}
			else {
				ticketFieldOption = (TicketFieldOption)session.merge(
					ticketFieldOption);
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
				ticketFieldOptionModelImpl.getTicketFieldId()
			};

			finderCache.removeResult(_finderPathCountByTicketFieldId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTicketFieldId, args);

			args = new Object[] {
				ticketFieldOptionModelImpl.getTicketFieldId(),
				ticketFieldOptionModelImpl.getStatus()
			};

			finderCache.removeResult(_finderPathCountByTFI_S, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTFI_S, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ticketFieldOptionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTicketFieldId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					ticketFieldOptionModelImpl.getOriginalTicketFieldId()
				};

				finderCache.removeResult(_finderPathCountByTicketFieldId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketFieldId, args);

				args = new Object[] {
					ticketFieldOptionModelImpl.getTicketFieldId()
				};

				finderCache.removeResult(_finderPathCountByTicketFieldId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTicketFieldId, args);
			}

			if ((ticketFieldOptionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTFI_S.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ticketFieldOptionModelImpl.getOriginalTicketFieldId(),
					ticketFieldOptionModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByTFI_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTFI_S, args);

				args = new Object[] {
					ticketFieldOptionModelImpl.getTicketFieldId(),
					ticketFieldOptionModelImpl.getStatus()
				};

				finderCache.removeResult(_finderPathCountByTFI_S, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTFI_S, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TicketFieldOptionImpl.class,
			ticketFieldOption.getPrimaryKey(), ticketFieldOption, false);

		ticketFieldOption.resetOriginalValues();

		return ticketFieldOption;
	}

	/**
	 * Returns the ticket field option with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket field option
	 * @return the ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	@Override
	public TicketFieldOption findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketFieldOptionException {

		TicketFieldOption ticketFieldOption = fetchByPrimaryKey(primaryKey);

		if (ticketFieldOption == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketFieldOptionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketFieldOption;
	}

	/**
	 * Returns the ticket field option with the primary key or throws a <code>NoSuchTicketFieldOptionException</code> if it could not be found.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option
	 * @throws NoSuchTicketFieldOptionException if a ticket field option with the primary key could not be found
	 */
	@Override
	public TicketFieldOption findByPrimaryKey(long ticketFieldOptionId)
		throws NoSuchTicketFieldOptionException {

		return findByPrimaryKey((Serializable)ticketFieldOptionId);
	}

	/**
	 * Returns the ticket field option with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFieldOptionId the primary key of the ticket field option
	 * @return the ticket field option, or <code>null</code> if a ticket field option with the primary key could not be found
	 */
	@Override
	public TicketFieldOption fetchByPrimaryKey(long ticketFieldOptionId) {
		return fetchByPrimaryKey((Serializable)ticketFieldOptionId);
	}

	/**
	 * Returns all the ticket field options.
	 *
	 * @return the ticket field options
	 */
	@Override
	public List<TicketFieldOption> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @return the range of ticket field options
	 */
	@Override
	public List<TicketFieldOption> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket field options
	 */
	@Override
	public List<TicketFieldOption> findAll(
		int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket field options.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldOptionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket field options
	 * @param end the upper bound of the range of ticket field options (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket field options
	 */
	@Override
	public List<TicketFieldOption> findAll(
		int start, int end,
		OrderByComparator<TicketFieldOption> orderByComparator,
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

		List<TicketFieldOption> list = null;

		if (useFinderCache) {
			list = (List<TicketFieldOption>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETFIELDOPTION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETFIELDOPTION;

				if (pagination) {
					sql = sql.concat(TicketFieldOptionModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketFieldOption>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketFieldOption>)QueryUtil.list(
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
	 * Removes all the ticket field options from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketFieldOption ticketFieldOption : findAll()) {
			remove(ticketFieldOption);
		}
	}

	/**
	 * Returns the number of ticket field options.
	 *
	 * @return the number of ticket field options
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETFIELDOPTION);

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
		return "ticketFieldOptionId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETFIELDOPTION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketFieldOptionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket field option persistence.
	 */
	@Activate
	public void activate() {
		TicketFieldOptionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketFieldOptionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByTicketFieldId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTicketFieldId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTicketFieldId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTicketFieldId",
			new String[] {Long.class.getName()},
			TicketFieldOptionModelImpl.TICKETFIELDID_COLUMN_BITMASK |
			TicketFieldOptionModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByTicketFieldId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTicketFieldId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByTFI_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTFI_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTFI_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldOptionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTFI_S",
			new String[] {Long.class.getName(), Integer.class.getName()},
			TicketFieldOptionModelImpl.TICKETFIELDID_COLUMN_BITMASK |
			TicketFieldOptionModelImpl.STATUS_COLUMN_BITMASK |
			TicketFieldOptionModelImpl.ORDER_COLUMN_BITMASK);

		_finderPathCountByTFI_S = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTFI_S",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketFieldOptionImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketFieldOption"),
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

	private static final String _SQL_SELECT_TICKETFIELDOPTION =
		"SELECT ticketFieldOption FROM TicketFieldOption ticketFieldOption";

	private static final String _SQL_SELECT_TICKETFIELDOPTION_WHERE =
		"SELECT ticketFieldOption FROM TicketFieldOption ticketFieldOption WHERE ";

	private static final String _SQL_COUNT_TICKETFIELDOPTION =
		"SELECT COUNT(ticketFieldOption) FROM TicketFieldOption ticketFieldOption";

	private static final String _SQL_COUNT_TICKETFIELDOPTION_WHERE =
		"SELECT COUNT(ticketFieldOption) FROM TicketFieldOption ticketFieldOption WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketFieldOption.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketFieldOption exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketFieldOption exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketFieldOptionPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"order"});

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}