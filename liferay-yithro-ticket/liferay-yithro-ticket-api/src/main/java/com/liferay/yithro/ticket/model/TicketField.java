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
 * The extended model interface for the TicketField service. Represents a row in the &quot;Yithro_TicketField&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldModel
 * @generated
 */
@ImplementationClassName("com.liferay.yithro.ticket.model.impl.TicketFieldImpl")
@ProviderType
public interface TicketField extends PersistedModel, TicketFieldModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.yithro.ticket.model.impl.TicketFieldImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TicketField, Long> TICKET_FIELD_ID_ACCESSOR =
		new Accessor<TicketField, Long>() {

			@Override
			public Long get(TicketField ticketField) {
				return ticketField.getTicketFieldId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<TicketField> getTypeClass() {
				return TicketField.class;
			}

		};

	public java.util.List<TicketFieldOption> getTicketFieldOptions();

	public java.util.List<TicketFieldOption> getTicketFieldOptions(int status);

	public String getTypeLabel();

	public String getVisibilityLabel();

	public boolean isDescriptionField();

	public boolean isSummaryField();

}