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
import com.liferay.yithro.ticket.exception.NoSuchTicketCommentTemplateException;
import com.liferay.yithro.ticket.model.TicketCommentTemplate;
import com.liferay.yithro.ticket.model.impl.TicketCommentTemplateImpl;
import com.liferay.yithro.ticket.model.impl.TicketCommentTemplateModelImpl;
import com.liferay.yithro.ticket.service.persistence.TicketCommentTemplatePersistence;
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
 * The persistence implementation for the ticket comment template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TicketCommentTemplatePersistence.class)
@ProviderType
public class TicketCommentTemplatePersistenceImpl
	extends BasePersistenceImpl<TicketCommentTemplate>
	implements TicketCommentTemplatePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TicketCommentTemplateUtil</code> to access the ticket comment template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TicketCommentTemplateImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public TicketCommentTemplatePersistenceImpl() {
		setModelClass(TicketCommentTemplate.class);

		setModelImplClass(TicketCommentTemplateImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the ticket comment template in the entity cache if it is enabled.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 */
	@Override
	public void cacheResult(TicketCommentTemplate ticketCommentTemplate) {
		entityCache.putResult(
			entityCacheEnabled, TicketCommentTemplateImpl.class,
			ticketCommentTemplate.getPrimaryKey(), ticketCommentTemplate);

		ticketCommentTemplate.resetOriginalValues();
	}

	/**
	 * Caches the ticket comment templates in the entity cache if it is enabled.
	 *
	 * @param ticketCommentTemplates the ticket comment templates
	 */
	@Override
	public void cacheResult(
		List<TicketCommentTemplate> ticketCommentTemplates) {

		for (TicketCommentTemplate ticketCommentTemplate :
				ticketCommentTemplates) {

			if (entityCache.getResult(
					entityCacheEnabled, TicketCommentTemplateImpl.class,
					ticketCommentTemplate.getPrimaryKey()) == null) {

				cacheResult(ticketCommentTemplate);
			}
			else {
				ticketCommentTemplate.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all ticket comment templates.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TicketCommentTemplateImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ticket comment template.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TicketCommentTemplate ticketCommentTemplate) {
		entityCache.removeResult(
			entityCacheEnabled, TicketCommentTemplateImpl.class,
			ticketCommentTemplate.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TicketCommentTemplate> ticketCommentTemplates) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TicketCommentTemplate ticketCommentTemplate :
				ticketCommentTemplates) {

			entityCache.removeResult(
				entityCacheEnabled, TicketCommentTemplateImpl.class,
				ticketCommentTemplate.getPrimaryKey());
		}
	}

	/**
	 * Creates a new ticket comment template with the primary key. Does not add the ticket comment template to the database.
	 *
	 * @param ticketCommentTemplateId the primary key for the new ticket comment template
	 * @return the new ticket comment template
	 */
	@Override
	public TicketCommentTemplate create(long ticketCommentTemplateId) {
		TicketCommentTemplate ticketCommentTemplate =
			new TicketCommentTemplateImpl();

		ticketCommentTemplate.setNew(true);
		ticketCommentTemplate.setPrimaryKey(ticketCommentTemplateId);

		ticketCommentTemplate.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ticketCommentTemplate;
	}

	/**
	 * Removes the ticket comment template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template that was removed
	 * @throws NoSuchTicketCommentTemplateException if a ticket comment template with the primary key could not be found
	 */
	@Override
	public TicketCommentTemplate remove(long ticketCommentTemplateId)
		throws NoSuchTicketCommentTemplateException {

		return remove((Serializable)ticketCommentTemplateId);
	}

	/**
	 * Removes the ticket comment template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ticket comment template
	 * @return the ticket comment template that was removed
	 * @throws NoSuchTicketCommentTemplateException if a ticket comment template with the primary key could not be found
	 */
	@Override
	public TicketCommentTemplate remove(Serializable primaryKey)
		throws NoSuchTicketCommentTemplateException {

		Session session = null;

		try {
			session = openSession();

			TicketCommentTemplate ticketCommentTemplate =
				(TicketCommentTemplate)session.get(
					TicketCommentTemplateImpl.class, primaryKey);

			if (ticketCommentTemplate == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTicketCommentTemplateException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ticketCommentTemplate);
		}
		catch (NoSuchTicketCommentTemplateException nsee) {
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
	protected TicketCommentTemplate removeImpl(
		TicketCommentTemplate ticketCommentTemplate) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ticketCommentTemplate)) {
				ticketCommentTemplate = (TicketCommentTemplate)session.get(
					TicketCommentTemplateImpl.class,
					ticketCommentTemplate.getPrimaryKeyObj());
			}

			if (ticketCommentTemplate != null) {
				session.delete(ticketCommentTemplate);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ticketCommentTemplate != null) {
			clearCache(ticketCommentTemplate);
		}

		return ticketCommentTemplate;
	}

	@Override
	public TicketCommentTemplate updateImpl(
		TicketCommentTemplate ticketCommentTemplate) {

		boolean isNew = ticketCommentTemplate.isNew();

		if (!(ticketCommentTemplate instanceof
				TicketCommentTemplateModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ticketCommentTemplate.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					ticketCommentTemplate);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ticketCommentTemplate proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TicketCommentTemplate implementation " +
					ticketCommentTemplate.getClass());
		}

		TicketCommentTemplateModelImpl ticketCommentTemplateModelImpl =
			(TicketCommentTemplateModelImpl)ticketCommentTemplate;

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (ticketCommentTemplate.getCreateDate() == null)) {
			if (serviceContext == null) {
				ticketCommentTemplate.setCreateDate(now);
			}
			else {
				ticketCommentTemplate.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!ticketCommentTemplateModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ticketCommentTemplate.setModifiedDate(now);
			}
			else {
				ticketCommentTemplate.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (ticketCommentTemplate.isNew()) {
				session.save(ticketCommentTemplate);

				ticketCommentTemplate.setNew(false);
			}
			else {
				ticketCommentTemplate = (TicketCommentTemplate)session.merge(
					ticketCommentTemplate);
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
			entityCacheEnabled, TicketCommentTemplateImpl.class,
			ticketCommentTemplate.getPrimaryKey(), ticketCommentTemplate,
			false);

		ticketCommentTemplate.resetOriginalValues();

		return ticketCommentTemplate;
	}

	/**
	 * Returns the ticket comment template with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ticket comment template
	 * @return the ticket comment template
	 * @throws NoSuchTicketCommentTemplateException if a ticket comment template with the primary key could not be found
	 */
	@Override
	public TicketCommentTemplate findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTicketCommentTemplateException {

		TicketCommentTemplate ticketCommentTemplate = fetchByPrimaryKey(
			primaryKey);

		if (ticketCommentTemplate == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTicketCommentTemplateException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ticketCommentTemplate;
	}

	/**
	 * Returns the ticket comment template with the primary key or throws a <code>NoSuchTicketCommentTemplateException</code> if it could not be found.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template
	 * @throws NoSuchTicketCommentTemplateException if a ticket comment template with the primary key could not be found
	 */
	@Override
	public TicketCommentTemplate findByPrimaryKey(long ticketCommentTemplateId)
		throws NoSuchTicketCommentTemplateException {

		return findByPrimaryKey((Serializable)ticketCommentTemplateId);
	}

	/**
	 * Returns the ticket comment template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template, or <code>null</code> if a ticket comment template with the primary key could not be found
	 */
	@Override
	public TicketCommentTemplate fetchByPrimaryKey(
		long ticketCommentTemplateId) {

		return fetchByPrimaryKey((Serializable)ticketCommentTemplateId);
	}

	/**
	 * Returns all the ticket comment templates.
	 *
	 * @return the ticket comment templates
	 */
	@Override
	public List<TicketCommentTemplate> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ticket comment templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommentTemplateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comment templates
	 * @param end the upper bound of the range of ticket comment templates (not inclusive)
	 * @return the range of ticket comment templates
	 */
	@Override
	public List<TicketCommentTemplate> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ticket comment templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommentTemplateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comment templates
	 * @param end the upper bound of the range of ticket comment templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket comment templates
	 */
	@Override
	public List<TicketCommentTemplate> findAll(
		int start, int end,
		OrderByComparator<TicketCommentTemplate> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ticket comment templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>TicketCommentTemplateModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comment templates
	 * @param end the upper bound of the range of ticket comment templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket comment templates
	 */
	@Override
	public List<TicketCommentTemplate> findAll(
		int start, int end,
		OrderByComparator<TicketCommentTemplate> orderByComparator,
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

		List<TicketCommentTemplate> list = null;

		if (useFinderCache) {
			list = (List<TicketCommentTemplate>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_TICKETCOMMENTTEMPLATE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TICKETCOMMENTTEMPLATE;

				if (pagination) {
					sql = sql.concat(
						TicketCommentTemplateModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TicketCommentTemplate>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<TicketCommentTemplate>)QueryUtil.list(
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
	 * Removes all the ticket comment templates from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TicketCommentTemplate ticketCommentTemplate : findAll()) {
			remove(ticketCommentTemplate);
		}
	}

	/**
	 * Returns the number of ticket comment templates.
	 *
	 * @return the number of ticket comment templates
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TICKETCOMMENTTEMPLATE);

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
		return "ticketCommentTemplateId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TICKETCOMMENTTEMPLATE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TicketCommentTemplateModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ticket comment template persistence.
	 */
	@Activate
	public void activate() {
		TicketCommentTemplateModelImpl.setEntityCacheEnabled(
			entityCacheEnabled);
		TicketCommentTemplateModelImpl.setFinderCacheEnabled(
			finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TicketCommentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			TicketCommentTemplateImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TicketCommentTemplateImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.liferay.yithro.ticket.model.TicketCommentTemplate"),
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

	private static final String _SQL_SELECT_TICKETCOMMENTTEMPLATE =
		"SELECT ticketCommentTemplate FROM TicketCommentTemplate ticketCommentTemplate";

	private static final String _SQL_COUNT_TICKETCOMMENTTEMPLATE =
		"SELECT COUNT(ticketCommentTemplate) FROM TicketCommentTemplate ticketCommentTemplate";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"ticketCommentTemplate.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TicketCommentTemplate exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		TicketCommentTemplatePersistenceImpl.class);

}