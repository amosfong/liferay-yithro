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
import com.liferay.yithro.ticket.exception.NoSuchTicketStructureException;
import com.liferay.yithro.ticket.model.TicketStructure;
import com.liferay.yithro.ticket.model.impl.TicketStructureImpl;
import com.liferay.yithro.ticket.model.impl.TicketStructureModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketStructurePersistence;
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
 * The persistence implementation for the ticket structure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketStructurePersistence.class)
@ProviderType
public class TicketStructurePersistenceImpl
	extends BasePersistenceImpl<TicketStructure>
	implements TicketStructurePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketStructureUtil</code> to access the ticket structure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketStructureImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TicketStructurePersistenceImpl() {
		setModelClass(TicketStructure.class);

		setModelImplClass(TicketStructureImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the ticket structure in the entity cache if it is enabled.
	 *
	 * @param ticketStructure the ticket structure
	 */
	@Override
	public void cacheResult(TicketStructure ticketStructure) {
		entityCache.putResult(
			entityCacheEnabled, TicketStructureImpl.class,
			ticketStructure.getPrimaryKey(), ticketStructure);

		ticketStructure.resetOriginalValues();
	}

	/**
	 * Caches the ticket structures in the entity cache if it is enabled.
	 *
	 * @param ticketStructures the ticket structures
	 */
	@Override
	public void cacheResult(List<TicketStructure> ticketStructures) {
		for (TicketStructure ticketStructure : ticketStructures) {
			if (entityCache.getResult(
					entityCacheEnabled, TicketStructureImpl.class,
					ticketStructure.getPrimaryKey()) == null) {

				cacheResult(ticketStructure);
			}
			else {
				ticketStructure.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket structures.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketStructureImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket structure.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketStructure ticketStructure) {
		entityCache.removeResult(
			entityCacheEnabled, TicketStructureImpl.class,
			ticketStructure.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TicketStructure> ticketStructures) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketStructure ticketStructure : ticketStructures) {
			entityCache.removeResult(
				entityCacheEnabled, TicketStructureImpl.class,
				ticketStructure.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ticket structure with the primary key. Does not add the ticket structure to the database.
	 *
	 * @param ticketStructureId the primary key for the new ticket structure
	 * @return the new ticket structure
	 */
	@Override
	public TicketStructure create(long ticketStructureId) {
		TicketStructure ticketStructure = new TicketStructureImpl();

		ticketStructure.setNew(true);
		ticketStructure.setPrimaryKey(ticketStructureId);

		ticketStructure.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ticketStructure;
	}

	/**
	 * Removes the ticket structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure that was removed
	 * @throws NoSuchTicketStructureException if a ticket structure with the primary key could not be found
	 */
	@Override
	public TicketStructure remove(long ticketStructureId)
		throws NoSuchTicketStructureException {

		return remove((Serializable)ticketStructureId);
	}

	/**
	 * Removes the ticket structure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket structure
	 * @return the ticket structure that was removed
	 * @throws NoSuchTicketStructureException if a ticket structure with the primary key could not be found
	 */
	@Override
	public TicketStructure remove(Serializable primaryKey)
		throws NoSuchTicketStructureException {

		Session session = null;

		try {
			session = openSession();

			TicketStructure ticketStructure = (TicketStructure)session.get(
				TicketStructureImpl.class, primaryKey);

			if (ticketStructure == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketStructureException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketStructure);
		}
		catch (NoSuchTicketStructureException nsee) {
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
	protected TicketStructure removeImpl(TicketStructure ticketStructure) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketStructure)) {
				ticketStructure = (TicketStructure)session.get(
					TicketStructureImpl.class,
					ticketStructure.getPrimaryKeyObj());
			}

			if (ticketStructure != null) {
				session.delete(ticketStructure);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketStructure != null) {
			clearCache(ticketStructure);
		}

		return ticketStructure;
	}

	@Override
	public TicketStructure updateImpl(TicketStructure ticketStructure) {
		boolean isNew = ticketStructure.isNew();

		if (!(ticketStructure instanceof TicketStructureModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketStructure.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ticketStructure);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketStructure proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketStructure implementation " +
					ticketStructure.getClass());
		}

		TicketStructureModelImpl ticketStructureModelImpl =
			(TicketStructureModelImpl)ticketStructure;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ticketStructure.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketStructure.setCreateDate(now);
			}
			else {
				ticketStructure.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!ticketStructureModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketStructure.setModifiedDate(now);
			}
			else {
				ticketStructure.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ticketStructure.isNew()) {
				session.save(ticketStructure);

				ticketStructure.setNew(false);
			}
			else {
				ticketStructure = (TicketStructure)session.merge(
					ticketStructure);
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
			entityCacheEnabled, TicketStructureImpl.class,
			ticketStructure.getPrimaryKey(), ticketStructure, false);

		ticketStructure.resetOriginalValues();

		return ticketStructure;
	}

	/**
	 * Returns the ticket structure with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket structure
	 * @return the ticket structure
	 * @throws NoSuchTicketStructureException if a ticket structure with the primary key could not be found
	 */
	@Override
	public TicketStructure findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketStructureException {

		TicketStructure ticketStructure = fetchByPrimaryKey(primaryKey);

		if (ticketStructure == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketStructureException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketStructure;
	}

	/**
	 * Returns the ticket structure with the primary key or throws a <code>NoSuchTicketStructureException</code> if it could not be found.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure
	 * @throws NoSuchTicketStructureException if a ticket structure with the primary key could not be found
	 */
	@Override
	public TicketStructure findByPrimaryKey(long ticketStructureId)
		throws NoSuchTicketStructureException {

		return findByPrimaryKey((Serializable)ticketStructureId);
	}

	/**
	 * Returns the ticket structure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketStructureId the primary key of the ticket structure
	 * @return the ticket structure, or <code>null</code> if a ticket structure with the primary key could not be found
	 */
	@Override
	public TicketStructure fetchByPrimaryKey(long ticketStructureId) {
		return fetchByPrimaryKey((Serializable)ticketStructureId);
	}

	/**
	 * Returns all the ticket structures.
	 *
	 * @return the ticket structures
	 */
	@Override
	public List<TicketStructure> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @return the range of ticket structures
	 */
	@Override
	public List<TicketStructure> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket structures
	 */
	@Override
	public List<TicketStructure> findAll(
		int start, int end,
		OrderByComparator<TicketStructure> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket structures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketStructureModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket structures
	 * @param end the upper bound of the range of ticket structures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket structures
	 */
	@Override
	public List<TicketStructure> findAll(
		int start, int end,
		OrderByComparator<TicketStructure> orderByComparator,
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

		List<TicketStructure> list = null;

		if (retrieveFromCache) {
			list = (List<TicketStructure>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETSTRUCTURE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETSTRUCTURE;

				if (pagination) {
					sql = sql.concat(TicketStructureModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketStructure>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketStructure>)QueryUtil.list(
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
	 * Removes all the ticket structures from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketStructure ticketStructure : findAll()) {
			remove(ticketStructure);
		}
	}

	/**
	 * Returns the number of ticket structures.
	 *
	 * @return the number of ticket structures
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETSTRUCTURE);

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
		return "ticketStructureId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETSTRUCTURE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketStructureModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket structure persistence.
	 */
	@Activate
	public void activate() {
		TicketStructureModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		TicketStructureModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, TicketStructureImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketStructureImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketStructure"),
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

	private static final String _SQL_SELECT_TICKETSTRUCTURE =
		"SELECT ticketStructure FROM TicketStructure ticketStructure";

	private static final String _SQL_COUNT_TICKETSTRUCTURE =
		"SELECT COUNT(ticketStructure) FROM TicketStructure ticketStructure";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketStructure.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketStructure exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketStructurePersistenceImpl.class);

}