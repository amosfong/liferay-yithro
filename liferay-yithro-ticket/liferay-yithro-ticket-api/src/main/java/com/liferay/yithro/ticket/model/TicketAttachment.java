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

package com.liferay.yithro.ticket.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the TicketAttachment service. Represents a row in the &quot;Yithro_TicketAttachment&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TicketAttachmentModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.yithro.ticket.model.impl.TicketAttachmentImpl"
)
@ProviderType
public interface TicketAttachment
	extends PersistedModel, TicketAttachmentModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.yithro.ticket.model.impl.TicketAttachmentImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TicketAttachment, Long>
		TICKET_ATTACHMENT_ID_ACCESSOR = new Accessor<TicketAttachment, Long>() {

			@Override
			public Long get(TicketAttachment ticketAttachment) {
				return ticketAttachment.getTicketAttachmentId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TicketAttachment> getTypeClass() {
				return TicketAttachment.class;
			}

		};

	public java.io.File getFile();

	public String getFileDir();

	public String getFilePath();

	public void setFile(java.io.File file);

}