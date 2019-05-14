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

package com.liferay.yithro.support.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SupportLabor service. Represents a row in the &quot;Yithro_SupportLabor&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SupportLaborModel
 * @generated
 */
@ImplementationClassName(
	"com.liferay.yithro.support.model.impl.SupportLaborImpl"
)
@ProviderType
public interface SupportLabor extends PersistedModel, SupportLaborModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.yithro.support.model.impl.SupportLaborImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SupportLabor, Long> SUPPORT_LABOR_ID_ACCESSOR =
		new Accessor<SupportLabor, Long>() {

			@Override
			public Long get(SupportLabor supportLabor) {
				return supportLabor.getSupportLaborId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SupportLabor> getTypeClass() {
				return SupportLabor.class;
			}

		};

	public int getCloseTime(int day);

	public int getOpenTime(int day);

}