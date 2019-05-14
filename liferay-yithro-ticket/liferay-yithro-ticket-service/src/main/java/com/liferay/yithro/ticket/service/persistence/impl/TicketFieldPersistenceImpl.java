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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
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
	}

	@Override
	public void clearCache(List<TicketField> ticketFields) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketField ticketField : ticketFields) {
			entityCache.removeResult(
				entityCacheEnabled, TicketFieldImpl.class,
				ticketField.getPrimaryKey());
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

		ticketField.setCompanyId(companyProvider.getCompanyId());

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

		if (isNew) {
			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(
			entityCacheEnabled, TicketFieldImpl.class,
			ticketField.getPrimaryKey(), ticketField, false);

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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket fields
	 */
	@Override
	public List<TicketField> findAll(
		int start, int end, OrderByComparator<TicketField> orderByComparator,
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

		List<TicketField> list = null;

		if (retrieveFromCache) {
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

	@Reference(service = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_TICKETFIELD =
		"SELECT ticketField FROM TicketField ticketField";

	private static final String _SQL_COUNT_TICKETFIELD =
		"SELECT COUNT(ticketField) FROM TicketField ticketField";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ticketField.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketField exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketFieldPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"type"});

}