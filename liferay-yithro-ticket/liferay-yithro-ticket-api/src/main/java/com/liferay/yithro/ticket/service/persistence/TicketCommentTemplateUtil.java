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

package com.liferay.yithro.ticket.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.ticket.model.TicketCommentTemplate;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the ticket comment template service. This utility wraps <code>com.liferay.yithro.ticket.service.persistence.impl.TicketCommentTemplatePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentTemplatePersistence
 * @generated
 */
public class TicketCommentTemplateUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(TicketCommentTemplate ticketCommentTemplate) {
		getPersistence().clearCache(ticketCommentTemplate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, TicketCommentTemplate> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TicketCommentTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TicketCommentTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TicketCommentTemplate> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TicketCommentTemplate> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TicketCommentTemplate update(
		TicketCommentTemplate ticketCommentTemplate) {

		return getPersistence().update(ticketCommentTemplate);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TicketCommentTemplate update(
		TicketCommentTemplate ticketCommentTemplate,
		ServiceContext serviceContext) {

		return getPersistence().update(ticketCommentTemplate, serviceContext);
	}

	/**
	 * Caches the ticket comment template in the entity cache if it is enabled.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 */
	public static void cacheResult(
		TicketCommentTemplate ticketCommentTemplate) {

		getPersistence().cacheResult(ticketCommentTemplate);
	}

	/**
	 * Caches the ticket comment templates in the entity cache if it is enabled.
	 *
	 * @param ticketCommentTemplates the ticket comment templates
	 */
	public static void cacheResult(
		List<TicketCommentTemplate> ticketCommentTemplates) {

		getPersistence().cacheResult(ticketCommentTemplates);
	}

	/**
	 * Creates a new ticket comment template with the primary key. Does not add the ticket comment template to the database.
	 *
	 * @param ticketCommentTemplateId the primary key for the new ticket comment template
	 * @return the new ticket comment template
	 */
	public static TicketCommentTemplate create(long ticketCommentTemplateId) {
		return getPersistence().create(ticketCommentTemplateId);
	}

	/**
	 * Removes the ticket comment template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template that was removed
	 * @throws NoSuchTicketCommentTemplateException if a ticket comment template with the primary key could not be found
	 */
	public static TicketCommentTemplate remove(long ticketCommentTemplateId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketCommentTemplateException {

		return getPersistence().remove(ticketCommentTemplateId);
	}

	public static TicketCommentTemplate updateImpl(
		TicketCommentTemplate ticketCommentTemplate) {

		return getPersistence().updateImpl(ticketCommentTemplate);
	}

	/**
	 * Returns the ticket comment template with the primary key or throws a <code>NoSuchTicketCommentTemplateException</code> if it could not be found.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template
	 * @throws NoSuchTicketCommentTemplateException if a ticket comment template with the primary key could not be found
	 */
	public static TicketCommentTemplate findByPrimaryKey(
			long ticketCommentTemplateId)
		throws com.liferay.yithro.ticket.exception.
			NoSuchTicketCommentTemplateException {

		return getPersistence().findByPrimaryKey(ticketCommentTemplateId);
	}

	/**
	 * Returns the ticket comment template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template, or <code>null</code> if a ticket comment template with the primary key could not be found
	 */
	public static TicketCommentTemplate fetchByPrimaryKey(
		long ticketCommentTemplateId) {

		return getPersistence().fetchByPrimaryKey(ticketCommentTemplateId);
	}

	/**
	 * Returns all the ticket comment templates.
	 *
	 * @return the ticket comment templates
	 */
	public static List<TicketCommentTemplate> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the ticket comment templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommentTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comment templates
	 * @param end the upper bound of the range of ticket comment templates (not inclusive)
	 * @return the range of ticket comment templates
	 */
	public static List<TicketCommentTemplate> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the ticket comment templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommentTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comment templates
	 * @param end the upper bound of the range of ticket comment templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ticket comment templates
	 */
	public static List<TicketCommentTemplate> findAll(
		int start, int end,
		OrderByComparator<TicketCommentTemplate> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the ticket comment templates.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TicketCommentTemplateModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ticket comment templates
	 * @param end the upper bound of the range of ticket comment templates (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ticket comment templates
	 */
	public static List<TicketCommentTemplate> findAll(
		int start, int end,
		OrderByComparator<TicketCommentTemplate> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ticket comment templates from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ticket comment templates.
	 *
	 * @return the number of ticket comment templates
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TicketCommentTemplatePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TicketCommentTemplatePersistence, TicketCommentTemplatePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			TicketCommentTemplatePersistence.class);

		ServiceTracker
			<TicketCommentTemplatePersistence, TicketCommentTemplatePersistence>
				serviceTracker =
					new ServiceTracker
						<TicketCommentTemplatePersistence,
						 TicketCommentTemplatePersistence>(
							 bundle.getBundleContext(),
							 TicketCommentTemplatePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}