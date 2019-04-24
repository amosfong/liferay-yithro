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

package com.liferay.yithro.audit.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.yithro.audit.model.AuditEntry;
import com.liferay.yithro.audit.service.base.AuditEntryLocalServiceBaseImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alan Zhang
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.audit.model.AuditEntry",
	service = AopService.class
)
public class AuditEntryLocalServiceImpl extends AuditEntryLocalServiceBaseImpl {

	public AuditEntry addAuditEntry(
			long userId, Date createDate, Class<?> clazz, long classPK,
			long auditSetId, Class<?> fieldClass, long fieldClassPK, int action,
			String field, int visibility, String oldLabel, Object oldValue,
			String newLabel, Object newValue, String description)
		throws PortalException {

		long classNameId = classNameLocalService.getClassNameId(clazz);
		long fieldClassNameId = classNameLocalService.getClassNameId(
			fieldClass);

		return addAuditEntry(
			userId, createDate, classNameId, classPK, auditSetId,
			fieldClassNameId, fieldClassPK, action, field, visibility, oldLabel,
			oldValue, newLabel, newValue, description);
	}

	public AuditEntry addAuditEntry(
			long userId, Date createDate, long classNameId, long classPK,
			long auditSetId, long fieldClassNameId, long fieldClassPK,
			int action, String field, int visibility, String oldLabel,
			Object oldValue, String newLabel, Object newValue,
			String description)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		if (auditSetId <= 0) {
			auditSetId = getNextAuditSetId(classNameId, classPK);
		}

		long auditEntryId = counterLocalService.increment();

		AuditEntry auditEntry = auditEntryPersistence.create(auditEntryId);

		auditEntry.setCompanyId(user.getCompanyId());
		auditEntry.setUserId(userId);
		auditEntry.setUserName(user.getFullName());
		auditEntry.setCreateDate(createDate);
		auditEntry.setClassNameId(classNameId);
		auditEntry.setClassPK(classPK);
		auditEntry.setAuditSetId(auditSetId);
		auditEntry.setFieldClassNameId(fieldClassNameId);
		auditEntry.setFieldClassPK(fieldClassPK);
		auditEntry.setAction(action);
		auditEntry.setField(field);
		auditEntry.setDescription(description);
		auditEntry.setVisibility(visibility);
		auditEntry.setOldLabel(oldLabel);
		auditEntry.setOldValue(String.valueOf(oldValue));
		auditEntry.setNewLabel(newLabel);
		auditEntry.setNewValue(String.valueOf(newValue));

		return auditEntryPersistence.update(auditEntry);
	}

	public List<AuditEntry> getAuditEntries(Date createDate, long classNameId) {
		return auditEntryPersistence.findByGtCD_C(createDate, classNameId);
	}

	public List<AuditEntry> getAuditEntries(
		long classNameId, long classPK, int[] visibilities) {

		return auditEntryPersistence.findByC_C_V(
			classNameId, classPK, visibilities, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS);
	}

	public List<List<AuditEntry>> getAuditEntrySets(
		long classNameId, long classPK, int[] visibilities) {

		Map<Long, List<AuditEntry>> auditEntrySets = new LinkedHashMap<>();

		List<AuditEntry> auditEntries = getAuditEntries(
			classNameId, classPK, visibilities);

		for (AuditEntry auditEntry : auditEntries) {
			List<AuditEntry> auditEntrySet = auditEntrySets.get(
				auditEntry.getAuditSetId());

			if (auditEntrySet != null) {
				auditEntrySet.add(auditEntry);
			}
			else {
				auditEntrySet = new ArrayList<>();

				auditEntrySet.add(auditEntry);

				auditEntrySets.put(auditEntry.getAuditSetId(), auditEntrySet);
			}
		}

		return new ArrayList<>(auditEntrySets.values());
	}

	public AuditEntry getLastAuditEntry(
		long fieldClassNameId, long fieldClassPK, String field) {

		return auditEntryPersistence.fetchByFC_FC_F_Last(
			fieldClassNameId, fieldClassPK, field, null);
	}

	public AuditEntry getLastAuditEntry(
		long classNameId, long classPK, String field, int action) {

		return auditEntryPersistence.fetchByC_C_F_A_Last(
			classNameId, classPK, field, action, null);
	}

	public long getNextAuditSetId(long classNameId, long classPK) {
		StringBundler sb = new StringBundler(5);

		sb.append(AuditEntry.class.getName());
		sb.append(StringPool.POUND);
		sb.append(classNameId);
		sb.append(StringPool.POUND);
		sb.append(classPK);

		return counterLocalService.increment(sb.toString());
	}

	public long getNextAuditSetId(String className, long classPK) {
		long classNameId = classNameLocalService.getClassNameId(className);

		return getNextAuditSetId(classNameId, classPK);
	}

}