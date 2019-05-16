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

package com.liferay.yithro.ticket.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Amos Fong
 */
@ExtendedObjectClassDefinition(category = "yithro")
@Meta.OCD(
	id = "com.liferay.yithro.ticket.configuration.YithroTicketConfiguration",
	localization = "content/Language", name = "Yithro Ticket"
)
public interface YithroTicketConfiguration {

	@Meta.AD(
		deflt = "1024",
		description = "ticket-attachment-indexing-max-size-help",
		name = "ticket-attachment-indexing-max-size", required = false
	)
	public int ticketAttachmentIndexingMaxSize();

	@Meta.AD(
		deflt = "doc|docx|log|out|rtf|txt",
		name = "ticket-attachment-indexing-extensions", required = false
	)
	public String[] ticketAttachmentIndexingExtensions();

	@Meta.AD(
		deflt = "flv|gif|jpg|log|pdf|png|swf|txt|wmv",
		name = "ticket-attachment-preview-extensions", required = false
	)
	public String[] ticketAttachmentPreviewExtensions();

}