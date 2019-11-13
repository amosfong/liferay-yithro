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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.support.exception.NoSuchSupportLevelAgreementException;
import com.liferay.yithro.support.model.SupportLevelAgreement;
import com.liferay.yithro.support.model.impl.SupportLevelAgreementImpl;
import com.liferay.yithro.support.model.impl.SupportLevelAgreementModelImpl;
import com.liferay.yithro.support.service.persistence.SupportLevelAgreementPersistence;
import com.liferay.yithro.support.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the support level agreement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SupportLevelAgreementPersistence.class)
public class SupportLevelAgreementPersistenceImpl
	extends BasePersistenceImpl<SupportLevelAgreement>
	implements SupportLevelAgreementPersistence {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SupportLevelAgreementUtil</code> to access the support level agreement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SupportLevelAgreementImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the support level agreement where name = &#63; or throws a <code>NoSuchSupportLevelAgreementException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching support level agreement
	 * @throws NoSuchSupportLevelAgreementException if a matching support level agreement could not be found
	 */
	@Override
	public SupportLevelAgreement findByName(String name)
		throws NoSuchSupportLevelAgreementException {

		SupportLevelAgreement supportLevelAgreement = fetchByName(name);

		if (supportLevelAgreement == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSupportLevelAgreementException(msg.toString());
		}

		return supportLevelAgreement;
	}

	/**
	 * Returns the support level agreement where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching support level agreement, or <code>null</code> if a matching support level agreement could not be found
	 */
	@Override
	public SupportLevelAgreement fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the support level agreement where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching support level agreement, or <code>null</code> if a matching support level agreement could not be found
	 */
	@Override
	public SupportLevelAgreement fetchByName(
		String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof SupportLevelAgreement) {
			SupportLevelAgreement supportLevelAgreement =
				(SupportLevelAgreement)result;

			if (!Objects.equals(name, supportLevelAgreement.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SUPPORTLEVELAGREEMENT_WHERE);

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

				List<SupportLevelAgreement> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"SupportLevelAgreementPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SupportLevelAgreement supportLevelAgreement = list.get(0);

					result = supportLevelAgreement;

					cacheResult(supportLevelAgreement);
				}
			}
			catch (Exception e) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByName, finderArgs);
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
			return (SupportLevelAgreement)result;
		}
	}

	/**
	 * Removes the support level agreement where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the support level agreement that was removed
	 */
	@Override
	public SupportLevelAgreement removeByName(String name)
		throws NoSuchSupportLevelAgreementException {

		SupportLevelAgreement supportLevelAgreement = findByName(name);

		return remove(supportLevelAgreement);
	}

	/**
	 * Returns the number of support level agreements where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching support level agreements
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SUPPORTLEVELAGREEMENT_WHERE);

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
		"supportLevelAgreement.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(supportLevelAgreement.name IS NULL OR supportLevelAgreement.name = '')";

	public SupportLevelAgreementPersistenceImpl() {
		setModelClass(SupportLevelAgreement.class);

		setModelImplClass(SupportLevelAgreementImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the support level agreement in the entity cache if it is enabled.
	 *
	 * @param supportLevelAgreement the support level agreement
	 */
	@Override
	public void cacheResult(SupportLevelAgreement supportLevelAgreement) {
		entityCache.putResult(
			entityCacheEnabled, SupportLevelAgreementImpl.class,
			supportLevelAgreement.getPrimaryKey(), supportLevelAgreement);

		finderCache.putResult(
			_finderPathFetchByName,
			new Object[] {supportLevelAgreement.getName()},
			supportLevelAgreement);

		supportLevelAgreement.resetOriginalValues();
	}

	/**
	 * Caches the support level agreements in the entity cache if it is enabled.
	 *
	 * @param supportLevelAgreements the support level agreements
	 */
	@Override
	public void cacheResult(
		List<SupportLevelAgreement> supportLevelAgreements) {

		for (SupportLevelAgreement supportLevelAgreement :
				supportLevelAgreements) {

			if (entityCache.getResult(
					entityCacheEnabled, SupportLevelAgreementImpl.class,
					supportLevelAgreement.getPrimaryKey()) == null) {

				cacheResult(supportLevelAgreement);
			}
			else {
				supportLevelAgreement.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all support level agreements.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SupportLevelAgreementImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the support level agreement.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SupportLevelAgreement supportLevelAgreement) {
		entityCache.removeResult(
			entityCacheEnabled, SupportLevelAgreementImpl.class,
			supportLevelAgreement.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(SupportLevelAgreementModelImpl)supportLevelAgreement, true);
	}

	@Override
	public void clearCache(List<SupportLevelAgreement> supportLevelAgreements) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SupportLevelAgreement supportLevelAgreement :
				supportLevelAgreements) {

			entityCache.removeResult(
				entityCacheEnabled, SupportLevelAgreementImpl.class,
				supportLevelAgreement.getPrimaryKey());

			clearUniqueFindersCache(
				(SupportLevelAgreementModelImpl)supportLevelAgreement, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, SupportLevelAgreementImpl.class,
				primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SupportLevelAgreementModelImpl supportLevelAgreementModelImpl) {

		Object[] args = new Object[] {supportLevelAgreementModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByName, args, supportLevelAgreementModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		SupportLevelAgreementModelImpl supportLevelAgreementModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				supportLevelAgreementModelImpl.getName()
			};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(_finderPathFetchByName, args);
		}

		if ((supportLevelAgreementModelImpl.getColumnBitmask() &
			 _finderPathFetchByName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				supportLevelAgreementModelImpl.getOriginalName()
			};

			finderCache.removeResult(_finderPathCountByName, args);
			finderCache.removeResult(_finderPathFetchByName, args);
		}
	}

	/**
	 * Creates a new support level agreement with the primary key. Does not add the support level agreement to the database.
	 *
	 * @param supportLevelAgreementId the primary key for the new support level agreement
	 * @return the new support level agreement
	 */
	@Override
	public SupportLevelAgreement create(long supportLevelAgreementId) {
		SupportLevelAgreement supportLevelAgreement =
			new SupportLevelAgreementImpl();

		supportLevelAgreement.setNew(true);
		supportLevelAgreement.setPrimaryKey(supportLevelAgreementId);

		supportLevelAgreement.setCompanyId(CompanyThreadLocal.getCompanyId());

		return supportLevelAgreement;
	}

	/**
	 * Removes the support level agreement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement that was removed
	 * @throws NoSuchSupportLevelAgreementException if a support level agreement with the primary key could not be found
	 */
	@Override
	public SupportLevelAgreement remove(long supportLevelAgreementId)
		throws NoSuchSupportLevelAgreementException {

		return remove((Serializable)supportLevelAgreementId);
	}

	/**
	 * Removes the support level agreement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the support level agreement
	 * @return the support level agreement that was removed
	 * @throws NoSuchSupportLevelAgreementException if a support level agreement with the primary key could not be found
	 */
	@Override
	public SupportLevelAgreement remove(Serializable primaryKey)
		throws NoSuchSupportLevelAgreementException {

		Session session = null;

		try {
			session = openSession();

			SupportLevelAgreement supportLevelAgreement =
				(SupportLevelAgreement)session.get(
					SupportLevelAgreementImpl.class, primaryKey);

			if (supportLevelAgreement == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupportLevelAgreementException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(supportLevelAgreement);
		}
		catch (NoSuchSupportLevelAgreementException nsee) {
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
	protected SupportLevelAgreement removeImpl(
		SupportLevelAgreement supportLevelAgreement) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supportLevelAgreement)) {
				supportLevelAgreement = (SupportLevelAgreement)session.get(
					SupportLevelAgreementImpl.class,
					supportLevelAgreement.getPrimaryKeyObj());
			}

			if (supportLevelAgreement != null) {
				session.delete(supportLevelAgreement);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supportLevelAgreement != null) {
			clearCache(supportLevelAgreement);
		}

		return supportLevelAgreement;
	}

	@Override
	public SupportLevelAgreement updateImpl(
		SupportLevelAgreement supportLevelAgreement) {

		boolean isNew = supportLevelAgreement.isNew();

		if (!(supportLevelAgreement instanceof
				SupportLevelAgreementModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(supportLevelAgreement.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					supportLevelAgreement);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in supportLevelAgreement proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SupportLevelAgreement implementation " +
					supportLevelAgreement.getClass());
		}

		SupportLevelAgreementModelImpl supportLevelAgreementModelImpl =
			(SupportLevelAgreementModelImpl)supportLevelAgreement;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (supportLevelAgreement.getCreateDate() == null)) {
			if (serviceContext == null) {
				supportLevelAgreement.setCreateDate(now);
			}
			else {
				supportLevelAgreement.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!supportLevelAgreementModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				supportLevelAgreement.setModifiedDate(now);
			}
			else {
				supportLevelAgreement.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (supportLevelAgreement.isNew()) {
				session.save(supportLevelAgreement);

				supportLevelAgreement.setNew(false);
			}
			else {
				supportLevelAgreement = (SupportLevelAgreement)session.merge(
					supportLevelAgreement);
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
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, SupportLevelAgreementImpl.class,
			supportLevelAgreement.getPrimaryKey(), supportLevelAgreement,
			false);

		clearUniqueFindersCache(supportLevelAgreementModelImpl, false);
		cacheUniqueFindersCache(supportLevelAgreementModelImpl);

		supportLevelAgreement.resetOriginalValues();

		return supportLevelAgreement;
	}

	/**
	 * Returns the support level agreement with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the support level agreement
	 * @return the support level agreement
	 * @throws NoSuchSupportLevelAgreementException if a support level agreement with the primary key could not be found
	 */
	@Override
	public SupportLevelAgreement findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupportLevelAgreementException {

		SupportLevelAgreement supportLevelAgreement = fetchByPrimaryKey(
			primaryKey);

		if (supportLevelAgreement == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupportLevelAgreementException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return supportLevelAgreement;
	}

	/**
	 * Returns the support level agreement with the primary key or throws a <code>NoSuchSupportLevelAgreementException</code> if it could not be found.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement
	 * @throws NoSuchSupportLevelAgreementException if a support level agreement with the primary key could not be found
	 */
	@Override
	public SupportLevelAgreement findByPrimaryKey(long supportLevelAgreementId)
		throws NoSuchSupportLevelAgreementException {

		return findByPrimaryKey((Serializable)supportLevelAgreementId);
	}

	/**
	 * Returns the support level agreement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement, or <code>null</code> if a support level agreement with the primary key could not be found
	 */
	@Override
	public SupportLevelAgreement fetchByPrimaryKey(
		long supportLevelAgreementId) {

		return fetchByPrimaryKey((Serializable)supportLevelAgreementId);
	}

	/**
	 * Returns all the support level agreements.
	 *
	 * @return the support level agreements
	 */
	@Override
	public List<SupportLevelAgreement> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @return the range of support level agreements
	 */
	@Override
	public List<SupportLevelAgreement> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support level agreements
	 */
	@Override
	public List<SupportLevelAgreement> findAll(
		int start, int end,
		OrderByComparator<SupportLevelAgreement> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of support level agreements
	 */
	@Override
	public List<SupportLevelAgreement> findAll(
		int start, int end,
		OrderByComparator<SupportLevelAgreement> orderByComparator,
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

		List<SupportLevelAgreement> list = null;

		if (useFinderCache) {
			list = (List<SupportLevelAgreement>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUPPORTLEVELAGREEMENT);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPORTLEVELAGREEMENT;

				sql = sql.concat(SupportLevelAgreementModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<SupportLevelAgreement>)QueryUtil.list(
					q, getDialect(), start, end);

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
	 * Removes all the support level agreements from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SupportLevelAgreement supportLevelAgreement : findAll()) {
			remove(supportLevelAgreement);
		}
	}

	/**
	 * Returns the number of support level agreements.
	 *
	 * @return the number of support level agreements
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUPPORTLEVELAGREEMENT);

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
		return "supportLevelAgreementId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUPPORTLEVELAGREEMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SupportLevelAgreementModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the support level agreement persistence.
	 */
	@Activate
	public void activate() {
		SupportLevelAgreementModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		SupportLevelAgreementModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			SupportLevelAgreementImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			SupportLevelAgreementImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			SupportLevelAgreementImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByName", new String[] {String.class.getName()},
			SupportLevelAgreementModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SupportLevelAgreementImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.support.model.SupportLevelAgreement"),
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

	private static final String _SQL_SELECT_SUPPORTLEVELAGREEMENT =
		"SELECT supportLevelAgreement FROM SupportLevelAgreement supportLevelAgreement";

	private static final String _SQL_SELECT_SUPPORTLEVELAGREEMENT_WHERE =
		"SELECT supportLevelAgreement FROM SupportLevelAgreement supportLevelAgreement WHERE ";

	private static final String _SQL_COUNT_SUPPORTLEVELAGREEMENT =
		"SELECT COUNT(supportLevelAgreement) FROM SupportLevelAgreement supportLevelAgreement";

	private static final String _SQL_COUNT_SUPPORTLEVELAGREEMENT_WHERE =
		"SELECT COUNT(supportLevelAgreement) FROM SupportLevelAgreement supportLevelAgreement WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"supportLevelAgreement.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SupportLevelAgreement exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SupportLevelAgreement exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SupportLevelAgreementPersistenceImpl.class);

	static {
		try {
			Class.forName(YithroPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}