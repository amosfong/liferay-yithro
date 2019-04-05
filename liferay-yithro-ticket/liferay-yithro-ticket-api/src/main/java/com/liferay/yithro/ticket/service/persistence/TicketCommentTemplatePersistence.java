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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.yithro.ticket.exception.NoSuchTicketCommentTemplateException;
import com.liferay.yithro.ticket.model.TicketCommentTemplate;

/**
 * The persistence interface for the ticket comment template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentTemplateUtil
 * @generated
 */
@ProviderType
public interface TicketCommentTemplatePersistence
	extends BasePersistence<TicketCommentTemplate> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TicketCommentTemplateUtil} to access the ticket comment template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the ticket comment template in the entity cache if it is enabled.
	 *
	 * @param ticketCommentTemplate the ticket comment template
	 */
	public void cacheResult(TicketCommentTemplate ticketCommentTemplate);

	/**
	 * Caches the ticket comment templates in the entity cache if it is enabled.
	 *
	 * @param ticketCommentTemplates the ticket comment templates
	 */
	public void cacheResult(
		java.util.List<TicketCommentTemplate> ticketCommentTemplates);

	/**
	 * Creates a new ticket comment template with the primary key. Does not add the ticket comment template to the database.
	 *
	 * @param ticketCommentTemplateId the primary key for the new ticket comment template
	 * @return the new ticket comment template
	 */
	public TicketCommentTemplate create(long ticketCommentTemplateId);

	/**
	 * Removes the ticket comment template with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template that was removed
	 * @throws NoSuchTicketCommentTemplateException if a ticket comment template with the primary key could not be found
	 */
	public TicketCommentTemplate remove(long ticketCommentTemplateId)
		throws NoSuchTicketCommentTemplateException;

	public TicketCommentTemplate updateImpl(
		TicketCommentTemplate ticketCommentTemplate);

	/**
	 * Returns the ticket comment template with the primary key or throws a <code>NoSuchTicketCommentTemplateException</code> if it could not be found.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template
	 * @throws NoSuchTicketCommentTemplateException if a ticket comment template with the primary key could not be found
	 */
	public TicketCommentTemplate findByPrimaryKey(long ticketCommentTemplateId)
		throws NoSuchTicketCommentTemplateException;

	/**
	 * Returns the ticket comment template with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ticketCommentTemplateId the primary key of the ticket comment template
	 * @return the ticket comment template, or <code>null</code> if a ticket comment template with the primary key could not be found
	 */
	public TicketCommentTemplate fetchByPrimaryKey(
		long ticketCommentTemplateId);

	/**
	 * Returns all the ticket comment templates.
	 *
	 * @return the ticket comment templates
	 */
	public java.util.List<TicketCommentTemplate> findAll();

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
	public java.util.List<TicketCommentTemplate> findAll(int start, int end);

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
	public java.util.List<TicketCommentTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketCommentTemplate>
			orderByComparator);

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
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of ticket comment templates
	 */
	public java.util.List<TicketCommentTemplate> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TicketCommentTemplate>
			orderByComparator,
		boolean retrieveFromCache);

	/**
	 * Removes all the ticket comment templates from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ticket comment templates.
	 *
	 * @return the number of ticket comment templates
	 */
	public int countAll();

}