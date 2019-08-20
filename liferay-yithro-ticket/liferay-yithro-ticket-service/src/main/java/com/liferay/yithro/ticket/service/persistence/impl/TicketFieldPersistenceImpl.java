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
import com.liferay.yithro.ticket.exception.NoSuchTicketFieldException;
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.model.impl.TicketFieldImpl;
import com.liferay.yithro.ticket.model.impl.TicketFieldModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketFieldPersistence;
import com.liferay.yithro.ticket.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the ticket field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketFieldPersistence.class)
@ProviderType
public class TicketFieldPersistenceImpl
	extends BasePersistenceImpl<TicketField> implements TicketFieldPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketFieldUtil</code> to access the ticket field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketFieldImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBySystemKey;
	private FinderPath _finderPathCountBySystemKey;

	/**
	 * Returns the ticket field where systemKey = &#63; or throws a <code>NoSuchTicketFieldException</code> if it could not be found.
	 *
	 * @param systemKey the system key
	 * @return the matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	@Override
	public TicketField findBySystemKey(String systemKey)
		throws NoSuchTicketFieldException {

		TicketField ticketField = fetchBySystemKey(systemKey);

		if (ticketField == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("systemKey=");
			msg.append(systemKey);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchTicketFieldException(msg.toString());
		}

		return ticketField;
	}

	/**
	 * Returns the ticket field where systemKey = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param systemKey the system key
	 * @return the matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	@Override
	public TicketField fetchBySystemKey(String systemKey) {
		return fetchBySystemKey(systemKey, true);
	}

	/**
	 * Returns the ticket field where systemKey = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param systemKey the system key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	@Override
	public TicketField fetchBySystemKey(
		String systemKey, boolean useFinderCache) {

		systemKey = Objects.toString(systemKey, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {systemKey};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySystemKey, finderArgs, this);
		}

		if (result instanceof TicketField) {
			TicketField ticketField = (TicketField)result;

			if (!Objects.equals(systemKey, ticketField.getSystemKey())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_TICKETFIELD_WHERE);

			boolean bindSystemKey = false;

			if (systemKey.isEmpty()) {
				query.append(_FINDER_COLUMN_SYSTEMKEY_SYSTEMKEY_3);
			}
			else {
				bindSystemKey = true;

				query.append(_FINDER_COLUMN_SYSTEMKEY_SYSTEMKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSystemKey) {
					qPos.add(systemKey);
				}

				List<TicketField> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySystemKey, finderArgs, list);
					}
				}
				else {
					TicketField ticketField = list.get(0);

					result = ticketField;

					cacheResult(ticketField);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBySystemKey, finderArgs);
				}

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
			return (TicketField)result;
		}
	}

	/**
	 * Removes the ticket field where systemKey = &#63; from the database.
	 *
	 * @param systemKey the system key
	 * @return the ticket field that was removed
	 */
	@Override
	public TicketField removeBySystemKey(String systemKey)
		throws NoSuchTicketFieldException {

		TicketField ticketField = findBySystemKey(systemKey);

		return remove(ticketField);
	}

	/**
	 * Returns the number of ticket fields where systemKey = &#63;.
	 *
	 * @param systemKey the system key
	 * @return the number of matching ticket fields
	 */
	@Override
	public int countBySystemKey(String systemKey) {
		systemKey = Objects.toString(systemKey, "");

		FinderPath finderPath = _finderPathCountBySystemKey;

		Object[] finderArgs = new Object[] {systemKey};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETFIELD_WHERE);

			boolean bindSystemKey = false;

			if (systemKey.isEmpty()) {
				query.append(_FINDER_COLUMN_SYSTEMKEY_SYSTEMKEY_3);
			}
			else {
				bindSystemKey = true;

				query.append(_FINDER_COLUMN_SYSTEMKEY_SYSTEMKEY_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSystemKey) {
					qPos.add(systemKey);
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

	private static final String _FINDER_COLUMN_SYSTEMKEY_SYSTEMKEY_2 =
		"ticketField.systemKey = ?";

	private static final String _FINDER_COLUMN_SYSTEMKEY_SYSTEMKEY_3 =
		"(ticketField.systemKey IS NULL OR ticketField.systemKey = '')";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the ticket fields where status = &#63;.
	 *
	 * @param status the status
	 * @return the matching ticket fields
	 */
	@Override
	public List<TicketField> findByStatus(int status) {
		return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @return the range of matching ticket fields
	 */
	@Override
	public List<TicketField> findByStatus(int status, int start, int end) {
		return findByStatus(status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ticket fields
	 */
	@Override
	public List<TicketField> findByStatus(
		int status, int start, int end,
		OrderByComparator<TicketField> orderByComparator) {

		return findByStatus(status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket fields where status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param status the status
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ticket fields
	 */
	@Override
	public List<TicketField> findByStatus(
		int status, int start, int end,
		OrderByComparator<TicketField> orderByComparator,
		boolean useFinderCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {status, start, end, orderByComparator};
		}

		List<TicketField> list = null;

		if (useFinderCache) {
			list = (List<TicketField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TicketField ticketField : list) {
					if ((status != ticketField.getStatus())) {
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

			query.append(_SQL_SELECT_TICKETFIELD_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(TicketFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				if (!pagination) {
					list = (List<TicketField>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketField>)QueryUtil.list(
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
	 * Returns the first ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	@Override
	public TicketField findByStatus_First(
			int status, OrderByComparator<TicketField> orderByComparator)
		throws NoSuchTicketFieldException {

		TicketField ticketField = fetchByStatus_First(
			status, orderByComparator);

		if (ticketField != null) {
			return ticketField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTicketFieldException(msg.toString());
	}

	/**
	 * Returns the first ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	@Override
	public TicketField fetchByStatus_First(
		int status, OrderByComparator<TicketField> orderByComparator) {

		List<TicketField> list = findByStatus(status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field
	 * @throws NoSuchTicketFieldException if a matching ticket field could not be found
	 */
	@Override
	public TicketField findByStatus_Last(
			int status, OrderByComparator<TicketField> orderByComparator)
		throws NoSuchTicketFieldException {

		TicketField ticketField = fetchByStatus_Last(status, orderByComparator);

		if (ticketField != null) {
			return ticketField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append("}");

		throw new NoSuchTicketFieldException(msg.toString());
	}

	/**
	 * Returns the last ticket field in the ordered set where status = &#63;.
	 *
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ticket field, or <code>null</code> if a matching ticket field could not be found
	 */
	@Override
	public TicketField fetchByStatus_Last(
		int status, OrderByComparator<TicketField> orderByComparator) {

		int count = countByStatus(status);

		if (count == 0) {
			return null;
		}

		List<TicketField> list = findByStatus(
			status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ticket fields before and after the current ticket field in the ordered set where status = &#63;.
	 *
	 * @param ticketFieldId the primary key of the current ticket field
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ticket field
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	@Override
	public TicketField[] findByStatus_PrevAndNext(
			long ticketFieldId, int status,
			OrderByComparator<TicketField> orderByComparator)
		throws NoSuchTicketFieldException {

		TicketField ticketField = findByPrimaryKey(ticketFieldId);

		Session session = null;

		try {
			session = openSession();

			TicketField[] array = new TicketFieldImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, ticketField, status, orderByComparator, true);

			array[1] = ticketField;

			array[2] = getByStatus_PrevAndNext(
				session, ticketField, status, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected TicketField getByStatus_PrevAndNext(
		Session session, TicketField ticketField, int status,
		OrderByComparator<TicketField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_TICKETFIELD_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			query.append(TicketFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ticketField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<TicketField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ticket fields where status = &#63; from the database.
	 *
	 * @param status the status
	 */
	@Override
	public void removeByStatus(int status) {
		for (TicketField ticketField :
				findByStatus(
					status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ticketField);
		}
	}

	/**
	 * Returns the number of ticket fields where status = &#63;.
	 *
	 * @param status the status
	 * @return the number of matching ticket fields
	 */
	@Override
	public int countByStatus(int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TICKETFIELD_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

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

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"ticketField.status = ?";

	public TicketFieldPersistenceImpl() {
		setModelClass(TicketField.class);

		setModelImplClass(TicketFieldImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the ticket field in the entity cache if it is enabled.
	 *
	 * @param ticketField the ticket field
	 */
	@Override
	public void cacheResult(TicketField ticketField) {
		entityCache.putResult(
			entityCacheEnabled, TicketFieldImpl.class,
			ticketField.getPrimaryKey(), ticketField);

		finderCache.putResult(
			_finderPathFetchBySystemKey,
			new Object[] {ticketField.getSystemKey()}, ticketField);

		ticketField.resetOriginalValues();
	}

	/**
	 * Caches the ticket fields in the entity cache if it is enabled.
	 *
	 * @param ticketFields the ticket fields
	 */
	@Override
	public void cacheResult(List<TicketField> ticketFields) {
		for (TicketField ticketField : ticketFields) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketFieldImpl.class,
					ticketField.getPrimaryKey()) == null) {

				cacheResult(ticketField);
			}
			else {
				ticketField.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket fields.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketFieldImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket field.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketField ticketField) {
		entityCache.removeResult(
			entityCacheEnabled, TicketFieldImpl.class,
			ticketField.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TicketFieldModelImpl)ticketField, true);
	}

	@Override
	public void clearCache(List<TicketField> ticketFields) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketField ticketField : ticketFields) {
			entityCache.removeResult(
				entityCacheEnabled, TicketFieldImpl.class,
				ticketField.getPrimaryKey());

			clearUniqueFindersCache((TicketFieldModelImpl)ticketField, true);
		}
	}

	protected void cacheUniqueFindersCache(
		TicketFieldModelImpl ticketFieldModelImpl) {

		Object[] args = new Object[] {ticketFieldModelImpl.getSystemKey()};

		finderCache.putResult(
			_finderPathCountBySystemKey, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySystemKey, args, ticketFieldModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TicketFieldModelImpl ticketFieldModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {ticketFieldModelImpl.getSystemKey()};

			finderCache.removeResult(_finderPathCountBySystemKey, args);
			finderCache.removeResult(_finderPathFetchBySystemKey, args);
		}

		if ((ticketFieldModelImpl.getColumnBitmask() &
			 _finderPathFetchBySystemKey.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				ticketFieldModelImpl.getOriginalSystemKey()
			};

			finderCache.removeResult(_finderPathCountBySystemKey, args);
			finderCache.removeResult(_finderPathFetchBySystemKey, args);
		}
	}

	/**
	 * Creates a new ticket field with the primary key. Does not add the ticket field to the database.
	 *
	 * @param ticketFieldId the primary key for the new ticket field
	 * @return the new ticket field
	 */
	@Override
	public TicketField create(long ticketFieldId) {
		TicketField ticketField = new TicketFieldImpl();

		ticketField.setNew(true);
		ticketField.setPrimaryKey(ticketFieldId);

		ticketField.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ticketField;
	}

	/**
	 * Removes the ticket field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field that was removed
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	@Override
	public TicketField remove(long ticketFieldId)
		throws NoSuchTicketFieldException {

		return remove((Serializable)ticketFieldId);
	}

	/**
	 * Removes the ticket field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket field
	 * @return the ticket field that was removed
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	@Override
	public TicketField remove(Serializable primaryKey)
		throws NoSuchTicketFieldException {

		Session session = null;

		try {
			session = openSession();

			TicketField ticketField = (TicketField)session.get(
				TicketFieldImpl.class, primaryKey);

			if (ticketField == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketFieldException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketField);
		}
		catch (NoSuchTicketFieldException nsee) {
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
	protected TicketField removeImpl(TicketField ticketField) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketField)) {
				ticketField = (TicketField)session.get(
					TicketFieldImpl.class, ticketField.getPrimaryKeyObj());
			}

			if (ticketField != null) {
				session.delete(ticketField);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketField != null) {
			clearCache(ticketField);
		}

		return ticketField;
	}

	@Override
	public TicketField updateImpl(TicketField ticketField) {
		boolean isNew = ticketField.isNew();

		if (!(ticketField instanceof TicketFieldModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketField.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ticketField);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketField proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketField implementation " +
					ticketField.getClass());
		}

		TicketFieldModelImpl ticketFieldModelImpl =
			(TicketFieldModelImpl)ticketField;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ticketField.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketField.setCreateDate(now);
			}
			else {
				ticketField.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!ticketFieldModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketField.setModifiedDate(now);
			}
			else {
				ticketField.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ticketField.isNew()) {
				session.save(ticketField);

				ticketField.setNew(false);
			}
			else {
				ticketField = (TicketField)session.merge(ticketField);
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
			Object[] args = new Object[] {ticketFieldModelImpl.getStatus()};

			finderCache.removeResult(_finderPathCountByStatus, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByStatus, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((ticketFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByStatus.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					ticketFieldModelImpl.getOriginalStatus()
				};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);

				args = new Object[] {ticketFieldModelImpl.getStatus()};

				finderCache.removeResult(_finderPathCountByStatus, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByStatus, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, TicketFieldImpl.class,
			ticketField.getPrimaryKey(), ticketField, false);

		clearUniqueFindersCache(ticketFieldModelImpl, false);
		cacheUniqueFindersCache(ticketFieldModelImpl);

		ticketField.resetOriginalValues();

		return ticketField;
	}

	/**
	 * Returns the ticket field with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket field
	 * @return the ticket field
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	@Override
	public TicketField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketFieldException {

		TicketField ticketField = fetchByPrimaryKey(primaryKey);

		if (ticketField == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketFieldException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketField;
	}

	/**
	 * Returns the ticket field with the primary key or throws a <code>NoSuchTicketFieldException</code> if it could not be found.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field
	 * @throws NoSuchTicketFieldException if a ticket field with the primary key could not be found
	 */
	@Override
	public TicketField findByPrimaryKey(long ticketFieldId)
		throws NoSuchTicketFieldException {

		return findByPrimaryKey((Serializable)ticketFieldId);
	}

	/**
	 * Returns the ticket field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketFieldId the primary key of the ticket field
	 * @return the ticket field, or <code>null</code> if a ticket field with the primary key could not be found
	 */
	@Override
	public TicketField fetchByPrimaryKey(long ticketFieldId) {
		return fetchByPrimaryKey((Serializable)ticketFieldId);
	}

	/**
	 * Returns all the ticket fields.
	 *
	 * @return the ticket fields
	 */
	@Override
	public List<TicketField> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @return the range of ticket fields
	 */
	@Override
	public List<TicketField> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket fields
	 */
	@Override
	public List<TicketField> findAll(
		int start, int end, OrderByComparator<TicketField> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketFieldModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket fields
	 * @param end the upper bound of the range of ticket fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket fields
	 */
	@Override
	public List<TicketField> findAll(
		int start, int end, OrderByComparator<TicketField> orderByComparator,
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

		List<TicketField> list = null;

		if (useFinderCache) {
			list = (List<TicketField>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETFIELD);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETFIELD;

				if (pagination) {
					sql = sql.concat(TicketFieldModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketField>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketField>)QueryUtil.list(
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
	 * Removes all the ticket fields from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketField ticketField : findAll()) {
			remove(ticketField);
		}
	}

	/**
	 * Returns the number of ticket fields.
	 *
	 * @return the number of ticket fields
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETFIELD);

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
		return "ticketFieldId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETFIELD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketFieldModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket field persistence.
	 */
	@Activate
	public void activate() {
		TicketFieldModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketFieldModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBySystemKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySystemKey",
			new String[] {String.class.getName()},
			TicketFieldModelImpl.SYSTEMKEY_COLUMN_BITMASK);

		_finderPathCountBySystemKey = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySystemKey",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Integer.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Integer.class.getName()},
			TicketFieldModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountByStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketFieldImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketField"),
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

	private static final String _SQL_SELECT_TICKETFIELD =
		"SELECT ticketField FROM TicketField ticketField";

	private static final String _SQL_SELECT_TICKETFIELD_WHERE =
		"SELECT ticketField FROM TicketField ticketField WHERE ";

	private static final String _SQL_COUNT_TICKETFIELD =
		"SELECT COUNT(ticketField) FROM TicketField ticketField";

	private static final String _SQL_COUNT_TICKETFIELD_WHERE =
		"SELECT COUNT(ticketField) FROM TicketField ticketField WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketField.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketField exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TicketField exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketFieldPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}