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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.support.exception.NoSuchSupportLaborException;
import com.liferay.yithro.support.model.SupportLabor;
import com.liferay.yithro.support.model.impl.SupportLaborImpl;
import com.liferay.yithro.support.model.impl.SupportLaborModelImpl;
import com.liferay.yithro.support.service.persistence.SupportLaborPersistence;
import com.liferay.yithro.support.service.persistence.impl.constants.YithroPersistenceConstants;

import java.io.Serializable;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the support labor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SupportLaborPersistence.class)
@ProviderType
public class SupportLaborPersistenceImpl
	extends BasePersistenceImpl<SupportLabor>
	implements SupportLaborPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SupportLaborUtil</code> to access the support labor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SupportLaborImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SupportLaborPersistenceImpl() {
		setModelClass(SupportLabor.class);

		setModelImplClass(SupportLaborImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the support labor in the entity cache if it is enabled.
	 *
	 * @param supportLabor the support labor
	 */
	@Override
	public void cacheResult(SupportLabor supportLabor) {
		entityCache.putResult(
			entityCacheEnabled, SupportLaborImpl.class,
			supportLabor.getPrimaryKey(), supportLabor);

		supportLabor.resetOriginalValues();
	}

	/**
	 * Caches the support labors in the entity cache if it is enabled.
	 *
	 * @param supportLabors the support labors
	 */
	@Override
	public void cacheResult(List<SupportLabor> supportLabors) {
		for (SupportLabor supportLabor : supportLabors) {
			if (entityCache.getResult(
					entityCacheEnabled, SupportLaborImpl.class,
					supportLabor.getPrimaryKey()) == null) {

				cacheResult(supportLabor);
			}
			else {
				supportLabor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all support labors.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SupportLaborImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the support labor.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SupportLabor supportLabor) {
		entityCache.removeResult(
			entityCacheEnabled, SupportLaborImpl.class,
			supportLabor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<SupportLabor> supportLabors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (SupportLabor supportLabor : supportLabors) {
			entityCache.removeResult(
				entityCacheEnabled, SupportLaborImpl.class,
				supportLabor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new support labor with the primary key. Does not add the support labor to the database.
	 *
	 * @param supportLaborId the primary key for the new support labor
	 * @return the new support labor
	 */
	@Override
	public SupportLabor create(long supportLaborId) {
		SupportLabor supportLabor = new SupportLaborImpl();

		supportLabor.setNew(true);
		supportLabor.setPrimaryKey(supportLaborId);

		supportLabor.setCompanyId(companyProvider.getCompanyId());

		return supportLabor;
	}

	/**
	 * Removes the support labor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor that was removed
	 * @throws NoSuchSupportLaborException if a support labor with the primary key could not be found
	 */
	@Override
	public SupportLabor remove(long supportLaborId)
		throws NoSuchSupportLaborException {

		return remove((Serializable)supportLaborId);
	}

	/**
	 * Removes the support labor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the support labor
	 * @return the support labor that was removed
	 * @throws NoSuchSupportLaborException if a support labor with the primary key could not be found
	 */
	@Override
	public SupportLabor remove(Serializable primaryKey)
		throws NoSuchSupportLaborException {

		Session session = null;

		try {
			session = openSession();

			SupportLabor supportLabor = (SupportLabor)session.get(
				SupportLaborImpl.class, primaryKey);

			if (supportLabor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSupportLaborException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(supportLabor);
		}
		catch (NoSuchSupportLaborException nsee) {
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
	protected SupportLabor removeImpl(SupportLabor supportLabor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(supportLabor)) {
				supportLabor = (SupportLabor)session.get(
					SupportLaborImpl.class, supportLabor.getPrimaryKeyObj());
			}

			if (supportLabor != null) {
				session.delete(supportLabor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (supportLabor != null) {
			clearCache(supportLabor);
		}

		return supportLabor;
	}

	@Override
	public SupportLabor updateImpl(SupportLabor supportLabor) {
		boolean isNew = supportLabor.isNew();

		Session session = null;

		try {
			session = openSession();

			if (supportLabor.isNew()) {
				session.save(supportLabor);

				supportLabor.setNew(false);
			}
			else {
				supportLabor = (SupportLabor)session.merge(supportLabor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, SupportLaborImpl.class,
			supportLabor.getPrimaryKey(), supportLabor, false);

		supportLabor.resetOriginalValues();

		return supportLabor;
	}

	/**
	 * Returns the support labor with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the support labor
	 * @return the support labor
	 * @throws NoSuchSupportLaborException if a support labor with the primary key could not be found
	 */
	@Override
	public SupportLabor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSupportLaborException {

		SupportLabor supportLabor = fetchByPrimaryKey(primaryKey);

		if (supportLabor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSupportLaborException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return supportLabor;
	}

	/**
	 * Returns the support labor with the primary key or throws a <code>NoSuchSupportLaborException</code> if it could not be found.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor
	 * @throws NoSuchSupportLaborException if a support labor with the primary key could not be found
	 */
	@Override
	public SupportLabor findByPrimaryKey(long supportLaborId)
		throws NoSuchSupportLaborException {

		return findByPrimaryKey((Serializable)supportLaborId);
	}

	/**
	 * Returns the support labor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportLaborId the primary key of the support labor
	 * @return the support labor, or <code>null</code> if a support labor with the primary key could not be found
	 */
	@Override
	public SupportLabor fetchByPrimaryKey(long supportLaborId) {
		return fetchByPrimaryKey((Serializable)supportLaborId);
	}

	/**
	 * Returns all the support labors.
	 *
	 * @return the support labors
	 */
	@Override
	public List<SupportLabor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the support labors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportLaborModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support labors
	 * @param end the upper bound of the range of support labors (not inclusive)
	 * @return the range of support labors
	 */
	@Override
	public List<SupportLabor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the support labors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportLaborModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support labors
	 * @param end the upper bound of the range of support labors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support labors
	 */
	@Override
	public List<SupportLabor> findAll(
		int start, int end, OrderByComparator<SupportLabor> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the support labors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>SupportLaborModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of support labors
	 * @param end the upper bound of the range of support labors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of support labors
	 */
	@Override
	public List<SupportLabor> findAll(
		int start, int end, OrderByComparator<SupportLabor> orderByComparator,
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

		List<SupportLabor> list = null;

		if (retrieveFromCache) {
			list = (List<SupportLabor>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SUPPORTLABOR);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SUPPORTLABOR;

				if (pagination) {
					sql = sql.concat(SupportLaborModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<SupportLabor>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<SupportLabor>)QueryUtil.list(
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
	 * Removes all the support labors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SupportLabor supportLabor : findAll()) {
			remove(supportLabor);
		}
	}

	/**
	 * Returns the number of support labors.
	 *
	 * @return the number of support labors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SUPPORTLABOR);

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
		return "supportLaborId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SUPPORTLABOR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SupportLaborModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the support labor persistence.
	 */
	@Activate
	public void activate() {
		SupportLaborModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		SupportLaborModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportLaborImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, SupportLaborImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(SupportLaborImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.support.model.SupportLabor"),
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

	private static final String _SQL_SELECT_SUPPORTLABOR =
		"SELECT supportLabor FROM SupportLabor supportLabor";

	private static final String _SQL_COUNT_SUPPORTLABOR =
		"SELECT COUNT(supportLabor) FROM SupportLabor supportLabor";

	private static final String _ORDER_BY_ENTITY_ALIAS = "supportLabor.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SupportLabor exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SupportLaborPersistenceImpl.class);

}