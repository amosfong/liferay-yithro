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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.support.exception.NoSuchSupportTeamException;
import com.liferay.yithro.support.model.SupportTeam;
import com.liferay.yithro.support.model.impl.SupportTeamImpl;
import com.liferay.yithro.support.model.impl.SupportTeamModelImpl;
import com.liferay.yithro.support.service.persistence.SupportTeamPersistence;
import com.liferay.yithro.support.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the support team service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SupportTeamPersistence.class)
@ProviderType
public class SupportTeamPersistenceImpl
	extends BasePersistenceImpl<SupportTeam> implements SupportTeamPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SupportTeamUtil</code> to access the support team persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SupportTeamImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByParentSupportTeamId;
	private FinderPath _finderPathWithoutPaginationFindByParentSupportTeamId;
	private FinderPath _finderPathCountByParentSupportTeamId;

	/**
	 * Returns all the support teams where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @return the matching support teams
	 */
	@Override
	public List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId) {

		return findByParentSupportTeamId(
			parentSupportTeamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of matching support teams
	 */
	@Override
	public List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end) {

		return findByParentSupportTeamId(parentSupportTeamId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support teams
	 */
	@Override
	public List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator) {

		return findByParentSupportTeamId(
			parentSupportTeamId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support teams where parentSupportTeamId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support teams
	 */
	@Override
	public List<SupportTeam> findByParentSupportTeamId(
		long parentSupportTeamId, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator,
		boolean retrieveFromCache) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByParentSupportTeamId;
			finderArgs = new Object[] {parentSupportTeamId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByParentSupportTeamId;
			finderArgs = new Object[] {
				parentSupportTeamId, start, end, orderByComparator
			};
		}

		List<SupportTeam> list = null;

		if (retrieveFromCache) {
			list = (List<SupportTeam>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SupportTeam supportTeam : list) {
					if ((parentSupportTeamId !=
							supportTeam.getParentSupportTeamId())) {

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

			query.append(_SQL_SELECT_SUPPORTTEAM_WHERE);

			query.append(
				_FINDER_COLUMN_PARENTSUPPORTTEAMID_PARENTSUPPORTTEAMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SupportTeamModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentSupportTeamId);

				if (!pagination) {
					list = (List<SupportTeam>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportTeam>)QueryUtil.list(
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
	 * Returns the first support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	@Override
	public SupportTeam findByParentSupportTeamId_First(
			long parentSupportTeamId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = fetchByParentSupportTeamId_First(
			parentSupportTeamId, orderByComparator);

		if (supportTeam != null) {
			return supportTeam;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentSupportTeamId=");
		msg.append(parentSupportTeamId);

		msg.append("}");

		throw new NoSuchSupportTeamException(msg.toString());
	}

	/**
	 * Returns the first support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team, or <code>null</code> if a matching support team could not be found
	 */
	@Override
	public SupportTeam fetchByParentSupportTeamId_First(
		long parentSupportTeamId,
		OrderByComparator<SupportTeam> orderByComparator) {

		List<SupportTeam> list = findByParentSupportTeamId(
			parentSupportTeamId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	@Override
	public SupportTeam findByParentSupportTeamId_Last(
			long parentSupportTeamId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = fetchByParentSupportTeamId_Last(
			parentSupportTeamId, orderByComparator);

		if (supportTeam != null) {
			return supportTeam;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("parentSupportTeamId=");
		msg.append(parentSupportTeamId);

		msg.append("}");

		throw new NoSuchSupportTeamException(msg.toString());
	}

	/**
	 * Returns the last support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team, or <code>null</code> if a matching support team could not be found
	 */
	@Override
	public SupportTeam fetchByParentSupportTeamId_Last(
		long parentSupportTeamId,
		OrderByComparator<SupportTeam> orderByComparator) {

		int count = countByParentSupportTeamId(parentSupportTeamId);

		if (count == 0) {
			return null;
		}

		List<SupportTeam> list = findByParentSupportTeamId(
			parentSupportTeamId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the support teams before and after the current support team in the ordered set where parentSupportTeamId = &#63;.
	 *
	 * @param supportTeamId the primary key of the current support team
	 * @param parentSupportTeamId the parent support team ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	@Override
	public SupportTeam[] findByParentSupportTeamId_PrevAndNext(
			long supportTeamId, long parentSupportTeamId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = findByPrimaryKey(supportTeamId);

		Session session = null;

		try {
			session = openSession();

			SupportTeam[] array = new SupportTeamImpl[3];

			array[0] = getByParentSupportTeamId_PrevAndNext(
				session, supportTeam, parentSupportTeamId, orderByComparator,
				true);

			array[1] = supportTeam;

			array[2] = getByParentSupportTeamId_PrevAndNext(
				session, supportTeam, parentSupportTeamId, orderByComparator,
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

	protected SupportTeam getByParentSupportTeamId_PrevAndNext(
		Session session, SupportTeam supportTeam, long parentSupportTeamId,
		OrderByComparator<SupportTeam> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPORTTEAM_WHERE);

		query.append(_FINDER_COLUMN_PARENTSUPPORTTEAMID_PARENTSUPPORTTEAMID_2);

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
			query.append(SupportTeamModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(parentSupportTeamId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(supportTeam)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SupportTeam> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the support teams where parentSupportTeamId = &#63; from the database.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 */
	@Override
	public void removeByParentSupportTeamId(long parentSupportTeamId) {
		for (SupportTeam supportTeam :
				findByParentSupportTeamId(
					parentSupportTeamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(supportTeam);
		}
	}

	/**
	 * Returns the number of support teams where parentSupportTeamId = &#63;.
	 *
	 * @param parentSupportTeamId the parent support team ID
	 * @return the number of matching support teams
	 */
	@Override
	public int countByParentSupportTeamId(long parentSupportTeamId) {
		FinderPath finderPath = _finderPathCountByParentSupportTeamId;

		Object[] finderArgs = new Object[] {parentSupportTeamId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPORTTEAM_WHERE);

			query.append(
				_FINDER_COLUMN_PARENTSUPPORTTEAMID_PARENTSUPPORTTEAMID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(parentSupportTeamId);

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

	private static final String
		_FINDER_COLUMN_PARENTSUPPORTTEAMID_PARENTSUPPORTTEAMID_2 =
			"supportTeam.parentSupportTeamId = ?";

	private FinderPath _finderPathWithPaginationFindBySupportLaborId;
	private FinderPath _finderPathWithoutPaginationFindBySupportLaborId;
	private FinderPath _finderPathCountBySupportLaborId;

	/**
	 * Returns all the support teams where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the matching support teams
	 */
	@Override
	public List<SupportTeam> findBySupportLaborId(long supportLaborId) {
		return findBySupportLaborId(
			supportLaborId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of matching support teams
	 */
	@Override
	public List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end) {

		return findBySupportLaborId(supportLaborId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching support teams
	 */
	@Override
	public List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator) {

		return findBySupportLaborId(
			supportLaborId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support teams where supportLaborId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param supportLaborId the support labor ID
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching support teams
	 */
	@Override
	public List<SupportTeam> findBySupportLaborId(
		long supportLaborId, int start, int end,
		OrderByComparator<SupportTeam> orderByComparator,
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

		List<SupportTeam> list = null;

		if (retrieveFromCache) {
			list = (List<SupportTeam>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SupportTeam supportTeam : list) {
					if ((supportLaborId != supportTeam.getSupportLaborId())) {
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

			query.append(_SQL_SELECT_SUPPORTTEAM_WHERE);

			query.append(_FINDER_COLUMN_SUPPORTLABORID_SUPPORTLABORID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(SupportTeamModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(supportLaborId);

				if (!pagination) {
					list = (List<SupportTeam>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportTeam>)QueryUtil.list(
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
	 * Returns the first support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	@Override
	public SupportTeam findBySupportLaborId_First(
			long supportLaborId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = fetchBySupportLaborId_First(
			supportLaborId, orderByComparator);

		if (supportTeam != null) {
			return supportTeam;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supportLaborId=");
		msg.append(supportLaborId);

		msg.append("}");

		throw new NoSuchSupportTeamException(msg.toString());
	}

	/**
	 * Returns the first support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching support team, or <code>null</code> if a matching support team could not be found
	 */
	@Override
	public SupportTeam fetchBySupportLaborId_First(
		long supportLaborId, OrderByComparator<SupportTeam> orderByComparator) {

		List<SupportTeam> list = findBySupportLaborId(
			supportLaborId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	@Override
	public SupportTeam findBySupportLaborId_Last(
			long supportLaborId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = fetchBySupportLaborId_Last(
			supportLaborId, orderByComparator);

		if (supportTeam != null) {
			return supportTeam;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("supportLaborId=");
		msg.append(supportLaborId);

		msg.append("}");

		throw new NoSuchSupportTeamException(msg.toString());
	}

	/**
	 * Returns the last support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching support team, or <code>null</code> if a matching support team could not be found
	 */
	@Override
	public SupportTeam fetchBySupportLaborId_Last(
		long supportLaborId, OrderByComparator<SupportTeam> orderByComparator) {

		int count = countBySupportLaborId(supportLaborId);

		if (count == 0) {
			return null;
		}

		List<SupportTeam> list = findBySupportLaborId(
			supportLaborId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the support teams before and after the current support team in the ordered set where supportLaborId = &#63;.
	 *
	 * @param supportTeamId the primary key of the current support team
	 * @param supportLaborId the support labor ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	@Override
	public SupportTeam[] findBySupportLaborId_PrevAndNext(
			long supportTeamId, long supportLaborId,
			OrderByComparator<SupportTeam> orderByComparator)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = findByPrimaryKey(supportTeamId);

		Session session = null;

		try {
			session = openSession();

			SupportTeam[] array = new SupportTeamImpl[3];

			array[0] = getBySupportLaborId_PrevAndNext(
				session, supportTeam, supportLaborId, orderByComparator, true);

			array[1] = supportTeam;

			array[2] = getBySupportLaborId_PrevAndNext(
				session, supportTeam, supportLaborId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected SupportTeam getBySupportLaborId_PrevAndNext(
		Session session, SupportTeam supportTeam, long supportLaborId,
		OrderByComparator<SupportTeam> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SUPPORTTEAM_WHERE);

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
			query.append(SupportTeamModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(supportLaborId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(supportTeam)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<SupportTeam> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the support teams where supportLaborId = &#63; from the database.
	 *
	 * @param supportLaborId the support labor ID
	 */
	@Override
	public void removeBySupportLaborId(long supportLaborId) {
		for (SupportTeam supportTeam :
				findBySupportLaborId(
					supportLaborId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(supportTeam);
		}
	}

	/**
	 * Returns the number of support teams where supportLaborId = &#63;.
	 *
	 * @param supportLaborId the support labor ID
	 * @return the number of matching support teams
	 */
	@Override
	public int countBySupportLaborId(long supportLaborId) {
		FinderPath finderPath = _finderPathCountBySupportLaborId;

		Object[] finderArgs = new Object[] {supportLaborId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPORTTEAM_WHERE);

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
		"supportTeam.supportLaborId = ?";

	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the support team where name = &#63; or throws a <code>NoSuchSupportTeamException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching support team
	 * @throws NoSuchSupportTeamException if a matching support team could not be found
	 */
	@Override
	public SupportTeam findByName(String name)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = fetchByName(name);

		if (supportTeam == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSupportTeamException(msg.toString());
		}

		return supportTeam;
	}

	/**
	 * Returns the support team where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching support team, or <code>null</code> if a matching support team could not be found
	 */
	@Override
	public SupportTeam fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the support team where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching support team, or <code>null</code> if a matching support team could not be found
	 */
	@Override
	public SupportTeam fetchByName(String name, boolean retrieveFromCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = new Object[] {name};

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof SupportTeam) {
			SupportTeam supportTeam = (SupportTeam)result;

			if (!Objects.equals(name, supportTeam.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SUPPORTTEAM_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<SupportTeam> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByName, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"SupportTeamPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SupportTeam supportTeam = list.get(0);

					result = supportTeam;

					cacheResult(supportTeam);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByName, finderArgs);

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
			return (SupportTeam)result;
		}
	}

	/**
	 * Removes the support team where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the support team that was removed
	 */
	@Override
	public SupportTeam removeByName(String name)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = findByName(name);

		return remove(supportTeam);
	}

	/**
	 * Returns the number of support teams where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching support teams
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPORTTEAM_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"supportTeam.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(supportTeam.name IS NULL OR supportTeam.name = '')";

	public SupportTeamPersistenceImpl() {
		setModelClass(SupportTeam.class);

		setModelImplClass(SupportTeamImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the support team in the entity cache if it is enabled.
	 *
	 * @param supportTeam the support team
	 */
	@Override
	public void cacheResult(SupportTeam supportTeam) {
		entityCache.putResult(
			entityCacheEnabled, SupportTeamImpl.class,
			supportTeam.getPrimaryKey(), supportTeam);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {supportTeam.getName()},
			supportTeam);

		supportTeam.resetOriginalValues();
	}

	/**
	 * Caches the support teams in the entity cache if it is enabled.
	 *
	 * @param supportTeams the support teams
	 */
	@Override
	public void cacheResult(List<SupportTeam> supportTeams) {
		for (SupportTeam supportTeam : supportTeams) {
			if (entityCache.getResult(
					entityCacheEnabled, SupportTeamImpl.class,
					supportTeam.getPrimaryKey()) == null) {

				cacheResult(supportTeam);
			}
			else {
				supportTeam.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all support teams.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SupportTeamImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the support team.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SupportTeam supportTeam) {
		entityCache.removeResult(
			entityCacheEnabled, SupportTeamImpl.class,
			supportTeam.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SupportTeamModelImpl)supportTeam, true);
	}

	@Override
	public void clearCache(List<SupportTeam> supportTeams) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SupportTeam supportTeam : supportTeams) {
			entityCache.removeResult(
				entityCacheEnabled, SupportTeamImpl.class,
				supportTeam.getPrimaryKey());

			clearUniqueFindersCache((SupportTeamModelImpl)supportTeam, true);
		}
	}

	protected void cacheUniqueFindersCache(
		SupportTeamModelImpl supportTeamModelImpl) {

		Object[] args = new Object[] {supportTeamModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, supportTeamModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		SupportTeamModelImpl supportTeamModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {supportTeamModelImpl.getName()};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(_finderPathFetchByName, args);
		}

		if ((supportTeamModelImpl.getColumnBitmask() &
			 _finderPathFetchByName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				supportTeamModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(_finderPathFetchByName, args);
		}
	}

	/**
	 * Creates a new support team with the primary key. Does not add the support team to the database.
	 *
	 * @param supportTeamId the primary key for the new support team
	 * @return the new support team
	 */
	@Override
	public SupportTeam create(long supportTeamId) {
		SupportTeam supportTeam = new SupportTeamImpl();

		supportTeam.setNew(true);
		supportTeam.setPrimaryKey(supportTeamId);

		supportTeam.setCompanyId(companyProvider.getCompanyId());

		return supportTeam;
	}

	/**
	 * Removes the support team with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team that was removed
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	@Override
	public SupportTeam remove(long supportTeamId)
		throws NoSuchSupportTeamException {

		return remove((Serializable)supportTeamId);
	}

	/**
	 * Removes the support team with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the support team
	 * @return the support team that was removed
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	@Override
	public SupportTeam remove(Serializable primaryKey)
		throws NoSuchSupportTeamException {

		Session session = null;

		try {
			session = openSession();

			SupportTeam supportTeam = (SupportTeam)session.get(
				SupportTeamImpl.class, primaryKey);

			if (supportTeam == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupportTeamException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(supportTeam);
		}
		catch (NoSuchSupportTeamException nsee) {
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
	protected SupportTeam removeImpl(SupportTeam supportTeam) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supportTeam)) {
				supportTeam = (SupportTeam)session.get(
					SupportTeamImpl.class, supportTeam.getPrimaryKeyObj());
			}

			if (supportTeam != null) {
				session.delete(supportTeam);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supportTeam != null) {
			clearCache(supportTeam);
		}

		return supportTeam;
	}

	@Override
	public SupportTeam updateImpl(SupportTeam supportTeam) {
		boolean isNew = supportTeam.isNew();

		if (!(supportTeam instanceof SupportTeamModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(supportTeam.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(supportTeam);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in supportTeam proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SupportTeam implementation " +
					supportTeam.getClass());
		}

		SupportTeamModelImpl supportTeamModelImpl =
			(SupportTeamModelImpl)supportTeam;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (supportTeam.getCreateDate() == null)) {
			if (serviceContext == null) {
				supportTeam.setCreateDate(now);
			}
			else {
				supportTeam.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!supportTeamModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				supportTeam.setModifiedDate(now);
			}
			else {
				supportTeam.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (supportTeam.isNew()) {
				session.save(supportTeam);

				supportTeam.setNew(false);
			}
			else {
				supportTeam = (SupportTeam)session.merge(supportTeam);
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
				supportTeamModelImpl.getParentSupportTeamId()
			};

			finderCache.removeResult(
				_finderPathCountByParentSupportTeamId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByParentSupportTeamId, args);

			args = new Object[] {supportTeamModelImpl.getSupportLaborId()};

			finderCache.removeResult(_finderPathCountBySupportLaborId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBySupportLaborId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((supportTeamModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByParentSupportTeamId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					supportTeamModelImpl.getOriginalParentSupportTeamId()
				};

				finderCache.removeResult(
					_finderPathCountByParentSupportTeamId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParentSupportTeamId,
					args);

				args = new Object[] {
					supportTeamModelImpl.getParentSupportTeamId()
				};

				finderCache.removeResult(
					_finderPathCountByParentSupportTeamId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByParentSupportTeamId,
					args);
			}

			if ((supportTeamModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBySupportLaborId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					supportTeamModelImpl.getOriginalSupportLaborId()
				};

				finderCache.removeResult(
					_finderPathCountBySupportLaborId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySupportLaborId, args);

				args = new Object[] {supportTeamModelImpl.getSupportLaborId()};

				finderCache.removeResult(
					_finderPathCountBySupportLaborId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBySupportLaborId, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, SupportTeamImpl.class,
			supportTeam.getPrimaryKey(), supportTeam, false);

		clearUniqueFindersCache(supportTeamModelImpl, false);
		cacheUniqueFindersCache(supportTeamModelImpl);

		supportTeam.resetOriginalValues();

		return supportTeam;
	}

	/**
	 * Returns the support team with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the support team
	 * @return the support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	@Override
	public SupportTeam findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupportTeamException {

		SupportTeam supportTeam = fetchByPrimaryKey(primaryKey);

		if (supportTeam == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupportTeamException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return supportTeam;
	}

	/**
	 * Returns the support team with the primary key or throws a <code>NoSuchSupportTeamException</code> if it could not be found.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team
	 * @throws NoSuchSupportTeamException if a support team with the primary key could not be found
	 */
	@Override
	public SupportTeam findByPrimaryKey(long supportTeamId)
		throws NoSuchSupportTeamException {

		return findByPrimaryKey((Serializable)supportTeamId);
	}

	/**
	 * Returns the support team with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportTeamId the primary key of the support team
	 * @return the support team, or <code>null</code> if a support team with the primary key could not be found
	 */
	@Override
	public SupportTeam fetchByPrimaryKey(long supportTeamId) {
		return fetchByPrimaryKey((Serializable)supportTeamId);
	}

	/**
	 * Returns all the support teams.
	 *
	 * @return the support teams
	 */
	@Override
	public List<SupportTeam> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @return the range of support teams
	 */
	@Override
	public List<SupportTeam> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support teams
	 */
	@Override
	public List<SupportTeam> findAll(
		int start, int end, OrderByComparator<SupportTeam> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support teams.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportTeamModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support teams
	 * @param end the upper bound of the range of support teams (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of support teams
	 */
	@Override
	public List<SupportTeam> findAll(
		int start, int end, OrderByComparator<SupportTeam> orderByComparator,
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

		List<SupportTeam> list = null;

		if (retrieveFromCache) {
			list = (List<SupportTeam>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUPPORTTEAM);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPORTTEAM;

				if (pagination) {
					sql = sql.concat(SupportTeamModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SupportTeam>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportTeam>)QueryUtil.list(
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
	 * Removes all the support teams from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SupportTeam supportTeam : findAll()) {
			remove(supportTeam);
		}
	}

	/**
	 * Returns the number of support teams.
	 *
	 * @return the number of support teams
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUPPORTTEAM);

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
		return "supportTeamId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUPPORTTEAM;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SupportTeamModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the support team persistence.
	 */
	@Activate
	public void activate() {
		SupportTeamModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		SupportTeamModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByParentSupportTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentSupportTeamId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByParentSupportTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByParentSupportTeamId", new String[] {Long.class.getName()},
			SupportTeamModelImpl.PARENTSUPPORTTEAMID_COLUMN_BITMASK |
			SupportTeamModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByParentSupportTeamId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByParentSupportTeamId", new String[] {Long.class.getName()});

		_finderPathWithPaginationFindBySupportLaborId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySupportLaborId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBySupportLaborId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportTeamImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySupportLaborId",
			new String[] {Long.class.getName()},
			SupportTeamModelImpl.SUPPORTLABORID_COLUMN_BITMASK |
			SupportTeamModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountBySupportLaborId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySupportLaborId",
			new String[] {Long.class.getName()});

		_finderPathFetchByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportTeamImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()},
			SupportTeamModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SupportTeamImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.support.model.SupportTeam"),
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

	private static final String _SQL_SELECT_SUPPORTTEAM =
		"SELECT supportTeam FROM SupportTeam supportTeam";

	private static final String _SQL_SELECT_SUPPORTTEAM_WHERE =
		"SELECT supportTeam FROM SupportTeam supportTeam WHERE ";

	private static final String _SQL_COUNT_SUPPORTTEAM =
		"SELECT COUNT(supportTeam) FROM SupportTeam supportTeam";

	private static final String _SQL_COUNT_SUPPORTTEAM_WHERE =
		"SELECT COUNT(supportTeam) FROM SupportTeam supportTeam WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "supportTeam.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SupportTeam exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SupportTeam exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SupportTeamPersistenceImpl.class);

}