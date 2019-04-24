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

package com.liferay.yithro.audit.internal.render;

import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.yithro.audit.render.AuditEntryFieldRenderer;
import com.liferay.yithro.audit.render.AuditEntryFieldRendererRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Amos Fong
 */
@Component(immediate = true, service = AuditEntryFieldRendererRegistry.class)
public class AuditEntryFieldRendererRegistryImpl
	implements AuditEntryFieldRendererRegistry {

	public AuditEntryFieldRenderer getAuditEntryFieldRenderer(
		long fieldClassNameId, String field) {

		String key = getKey(fieldClassNameId, field);

		return _auditEntryFieldRendererMap.get(key);
	}

	protected String getKey(AuditEntryFieldRenderer auditEntryFieldRenderer) {
		long fieldClassNameId = _classNameLocalService.getClassNameId(
			auditEntryFieldRenderer.getFieldClassName());

		return getKey(fieldClassNameId, auditEntryFieldRenderer.getField());
	}

	protected String getKey(long fieldClassNameId, String field) {
		StringBundler sb = new StringBundler(3);

		sb.append(fieldClassNameId);
		sb.append(StringPool.POUND);
		sb.append(field);

		return sb.toString();
	}

	@Reference(
		cardinality = ReferenceCardinality.MULTIPLE,
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		unbind = "unregisterAuditEntryFieldRenderer"
	)
	protected synchronized void registerAuditEntryFieldRenderer(
		AuditEntryFieldRenderer auditEntryFieldRenderer) {

		String key = getKey(auditEntryFieldRenderer);

		_auditEntryFieldRendererMap.put(key, auditEntryFieldRenderer);
	}

	protected synchronized void unregisterAuditEntryFieldRenderer(
		AuditEntryFieldRenderer auditEntryFieldRenderer) {

		String key = getKey(auditEntryFieldRenderer);

		_auditEntryFieldRendererMap.remove(key);
	}

	private final Map<String, AuditEntryFieldRenderer>
		_auditEntryFieldRendererMap = new ConcurrentHashMap<>();

	@Reference
	private ClassNameLocalService _classNameLocalService;

}