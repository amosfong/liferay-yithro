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
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.ticket.exception.TicketCommentTemplateContentException;
import com.liferay.yithro.ticket.exception.TicketCommentTemplateNameException;
import com.liferay.yithro.ticket.model.TicketCommentTemplate;
import com.liferay.yithro.ticket.service.base.TicketCommentTemplateLocalServiceBaseImpl;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketCommentTemplate",
	service = AopService.class
)
public class TicketCommentTemplateLocalServiceImpl
	extends TicketCommentTemplateLocalServiceBaseImpl {

	public TicketCommentTemplate addTicketCommentTemplate(
			long userId, String defaultLanguageId, String name, String content)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		validate(0, name, content);

		String nameXml = LocalizationUtil.updateLocalization(
			StringPool.BLANK, "static-content", name, defaultLanguageId,
			defaultLanguageId, true, true);

		String contentXml = LocalizationUtil.updateLocalization(
			StringPool.BLANK, "static-content", content, defaultLanguageId,
			defaultLanguageId, true, true);

		long ticketCommentTemplateId = counterLocalService.increment();

		TicketCommentTemplate ticketCommentTemplate =
			ticketCommentTemplatePersistence.create(ticketCommentTemplateId);

		ticketCommentTemplate.setUserId(user.getUserId());
		ticketCommentTemplate.setUserName(user.getFullName());
		ticketCommentTemplate.setCreateDate(now);
		ticketCommentTemplate.setModifiedDate(now);
		ticketCommentTemplate.setName(nameXml);
		ticketCommentTemplate.setContent(contentXml);

		return ticketCommentTemplatePersistence.update(ticketCommentTemplate);
	}

	public void removeCommentTemplateLocale(
			long ticketCommentTemplateId, String languageId)
		throws PortalException {

		TicketCommentTemplate ticketCommentTemplate =
			ticketCommentTemplatePersistence.findByPrimaryKey(
				ticketCommentTemplateId);

		String defaultLanguageId = ticketCommentTemplate.getDefaultLocale();

		if (languageId.equalsIgnoreCase(defaultLanguageId)) {
			throw new TicketCommentTemplateNameException();
		}

		String nameXml = ticketCommentTemplate.getName();
		String contentXml = ticketCommentTemplate.getContent();

		nameXml = LocalizationUtil.removeLocalization(
			nameXml, "static-content", languageId);
		contentXml = LocalizationUtil.removeLocalization(
			contentXml, "static-content", languageId);

		ticketCommentTemplate.setModifiedDate(new Date());
		ticketCommentTemplate.setName(nameXml);
		ticketCommentTemplate.setContent(contentXml);

		ticketCommentTemplatePersistence.update(ticketCommentTemplate);
	}

	public TicketCommentTemplate updateTicketCommentTemplate(
			long ticketCommentTemplateId, String defaultLanguageId,
			String languageId, String name, String content)
		throws PortalException {

		if (Validator.isNull(defaultLanguageId)) {
			defaultLanguageId = languageId;
		}

		validate(ticketCommentTemplateId, name, content);

		TicketCommentTemplate ticketCommentTemplate =
			ticketCommentTemplatePersistence.findByPrimaryKey(
				ticketCommentTemplateId);

		String nameXml = LocalizationUtil.updateLocalization(
			ticketCommentTemplate.getName(), "static-content", name, languageId,
			defaultLanguageId, true, true);

		String contentXml = LocalizationUtil.updateLocalization(
			ticketCommentTemplate.getContent(), "static-content", content,
			languageId, defaultLanguageId, true, true);

		ticketCommentTemplate.setModifiedDate(new Date());
		ticketCommentTemplate.setName(nameXml);
		ticketCommentTemplate.setContent(contentXml);

		return ticketCommentTemplatePersistence.update(ticketCommentTemplate);
	}

	protected void validate(
			long ticketCommentTemplateId, String name, String content)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new TicketCommentTemplateNameException();
		}

		if (Validator.isNull(content)) {
			throw new TicketCommentTemplateContentException();
		}
	}

}