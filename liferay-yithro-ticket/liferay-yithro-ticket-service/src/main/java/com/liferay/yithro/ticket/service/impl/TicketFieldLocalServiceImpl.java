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

package com.liferay.yithro.ticket.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.yithro.ticket.exception.TicketFieldNameException;
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.service.base.TicketFieldLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketField",
	service = AopService.class
)
public class TicketFieldLocalServiceImpl
	extends TicketFieldLocalServiceBaseImpl {

	public TicketField addTicketField(
			long userId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, int type, int visibility)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		validate(nameMap);

		long ticketFieldId = counterLocalService.increment();

		TicketField ticketField = ticketFieldPersistence.create(ticketFieldId);

		ticketField.setCompanyId(user.getCompanyId());
		ticketField.setUserId(userId);
		ticketField.setCreateDate(now);
		ticketField.setModifiedDate(now);
		ticketField.setNameMap(nameMap);
		ticketField.setDescriptionMap(descriptionMap);
		ticketField.setType(type);
		ticketField.setVisibility(visibility);
		ticketField.setStatus(WorkflowConstants.STATUS_APPROVED);

		return ticketFieldPersistence.update(ticketField);
	}

	public List<TicketField> getTicketFields(int status, int start, int end) {
		return ticketFieldPersistence.findByStatus(status, start, end);
	}

	public int getTicketFieldsCount(int status) {
		return ticketFieldPersistence.countByStatus(status);
	}

	public void updateStatus(long ticketFieldId, int status)
		throws PortalException {

		TicketField ticketField = ticketFieldPersistence.findByPrimaryKey(
			ticketFieldId);

		ticketField.setStatus(status);

		ticketFieldPersistence.update(ticketField);
	}

	public TicketField updateTicketField(
			long ticketFieldId, Map<Locale, String> nameMap,
			Map<Locale, String> descriptionMap, int type, int visibility)
		throws PortalException {

		validate(nameMap);

		TicketField ticketField = ticketFieldPersistence.findByPrimaryKey(
			ticketFieldId);

		ticketField.setModifiedDate(new Date());
		ticketField.setNameMap(nameMap);
		ticketField.setDescriptionMap(descriptionMap);
		ticketField.setType(type);
		ticketField.setVisibility(visibility);

		return ticketFieldPersistence.update(ticketField);
	}

	protected void validate(Map<Locale, String> nameMap)
		throws PortalException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String name = nameMap.get(defaultLocale);

		if (Validator.isNull(name)) {
			throw new TicketFieldNameException(
				"Name is null for locale " + defaultLocale.getDisplayName());
		}
	}

}