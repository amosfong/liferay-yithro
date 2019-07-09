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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.yithro.audit.constants.Actions;
import com.liferay.yithro.audit.constants.Fields;
import com.liferay.yithro.audit.service.AuditEntryLocalService;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.model.TicketFieldData;
import com.liferay.yithro.ticket.service.TicketFieldLocalService;
import com.liferay.yithro.ticket.service.base.TicketFieldDataLocalServiceBaseImpl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brent Krone-Schmidt
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.ticket.model.TicketFieldData",
	service = AopService.class
)
public class TicketFieldDataLocalServiceImpl
	extends TicketFieldDataLocalServiceBaseImpl {

	public TicketFieldData addTicketFieldData(
			long ticketEntryId, long ticketFieldId, String data)
		throws PortalException {

		Date now = new Date();

		long ticketFieldDataId = counterLocalService.increment();

		TicketFieldData ticketFieldData = ticketFieldDataPersistence.create(
			ticketFieldDataId);

		ticketFieldData.setCreateDate(now);
		ticketFieldData.setModifiedDate(now);
		ticketFieldData.setTicketEntryId(ticketEntryId);
		ticketFieldData.setTicketFieldId(ticketFieldId);
		ticketFieldData.setData(data);

		return ticketFieldDataPersistence.update(ticketFieldData);
	}

	public void addTicketFieldData(
			long ticketEntryId, Map<Long, String> ticketFieldsMap)
		throws PortalException {

		for (Map.Entry<Long, String> entry : ticketFieldsMap.entrySet()) {
			long ticketFieldId = entry.getKey();
			String data = entry.getValue();

			addTicketFieldData(ticketEntryId, ticketFieldId, data);
		}
	}

	public TicketFieldData fetchTicketFieldData(
			long ticketEntryId, long ticketFieldId)
		throws PortalException {

		return ticketFieldDataPersistence.fetchByTEI_TFI(
			ticketEntryId, ticketFieldId);
	}

	public String getData(long ticketEntryId, long ticketFieldId)
		throws PortalException {

		TicketFieldData ticketFieldData =
			ticketFieldDataPersistence.findByTEI_TFI(
				ticketEntryId, ticketFieldId);

		return ticketFieldData.getData();
	}

	public List<TicketFieldData> getTicketEntryFieldData(long ticketEntryId) {
		return ticketFieldDataPersistence.findByTicketEntryId(ticketEntryId);
	}

	public Map<Long, String> getTicketFieldsMap(long ticketEntryId) {
		List<TicketFieldData> ticketFieldDataList =
			ticketFieldDataPersistence.findByTicketEntryId(ticketEntryId);

		HashMap<Long, String> ticketFieldsMap = new HashMap<>();

		for (TicketFieldData ticketFieldData : ticketFieldDataList) {
			ticketFieldsMap.put(
				ticketFieldData.getTicketFieldId(), ticketFieldData.getData());
		}

		return ticketFieldsMap;
	}

	public void updateTicketFieldData(
			long userId, long ticketEntryId, Map<Long, String> ticketFieldsMap,
			ServiceContext serviceContext)
		throws PortalException {

		Date now = serviceContext.getCreateDate(new Date());

		Map<Long, String> oldTicketFieldsMap = getTicketFieldsMap(
			ticketEntryId);

		for (Map.Entry<Long, String> entry : ticketFieldsMap.entrySet()) {
			long ticketFieldId = entry.getKey();
			String data = entry.getValue();

			TicketFieldData ticketFieldData =
				ticketFieldDataPersistence.fetchByTEI_TFI(
					ticketEntryId, ticketFieldId);

			if (ticketFieldData == null) {
				addTicketFieldData(ticketEntryId, ticketFieldId, data);
			}
			else {
				ticketFieldData.setModifiedDate(now);
				ticketFieldData.setData(data);

				ticketFieldDataPersistence.update(ticketFieldData);
			}
		}

		// Audit Entry

		updateAuditEntry(
			userId, ticketEntryId, now, oldTicketFieldsMap, ticketFieldsMap,
			serviceContext);
	}

	protected void updateAuditEntry(
			long userId, long ticketEntryId, Date createDate,
			Map<Long, String> oldTicketFieldsMap,
			Map<Long, String> newTicketFieldsMap, ServiceContext serviceContext)
		throws PortalException {

		long auditSetId = GetterUtil.getLong(
			serviceContext.getAttribute("auditSetId"));

		for (Map.Entry<Long, String> entry : newTicketFieldsMap.entrySet()) {
			long ticketFieldId = entry.getKey();
			String newData = entry.getValue();

			String oldData = oldTicketFieldsMap.get(ticketFieldId);

			if (newData.equals(oldData)) {
				continue;
			}

			TicketField ticketField = ticketFieldLocalService.getTicketField(
				ticketFieldId);

			auditEntryLocalService.addAuditEntry(
				userId, createDate, TicketEntry.class, ticketEntryId,
				auditSetId, TicketField.class, ticketFieldId, Actions.UPDATE,
				Fields.DATA, ticketField.getVisibility(), StringPool.BLANK,
				oldData, StringPool.BLANK, newData, StringPool.BLANK);
		}
	}

	@Reference
	protected AuditEntryLocalService auditEntryLocalService;

	@Reference
	protected TicketFieldLocalService ticketFieldLocalService;

}