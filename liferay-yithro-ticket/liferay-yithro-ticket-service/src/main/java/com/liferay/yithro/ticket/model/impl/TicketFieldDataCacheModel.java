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

package com.liferay.yithro.ticket.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.yithro.ticket.model.TicketFieldData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketFieldData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketFieldDataCacheModel
	implements CacheModel<TicketFieldData>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketFieldDataCacheModel)) {
			return false;
		}

		TicketFieldDataCacheModel ticketFieldDataCacheModel =
			(TicketFieldDataCacheModel)obj;

		if (ticketFieldDataId == ticketFieldDataCacheModel.ticketFieldDataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketFieldDataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{ticketFieldDataId=");
		sb.append(ticketFieldDataId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ticketEntryId=");
		sb.append(ticketEntryId);
		sb.append(", ticketFieldId=");
		sb.append(ticketFieldId);
		sb.append(", data=");
		sb.append(data);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketFieldData toEntityModel() {
		TicketFieldDataImpl ticketFieldDataImpl = new TicketFieldDataImpl();

		ticketFieldDataImpl.setTicketFieldDataId(ticketFieldDataId);
		ticketFieldDataImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			ticketFieldDataImpl.setCreateDate(null);
		}
		else {
			ticketFieldDataImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketFieldDataImpl.setModifiedDate(null);
		}
		else {
			ticketFieldDataImpl.setModifiedDate(new Date(modifiedDate));
		}

		ticketFieldDataImpl.setTicketEntryId(ticketEntryId);
		ticketFieldDataImpl.setTicketFieldId(ticketFieldId);

		if (data == null) {
			ticketFieldDataImpl.setData("");
		}
		else {
			ticketFieldDataImpl.setData(data);
		}

		ticketFieldDataImpl.resetOriginalValues();

		return ticketFieldDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketFieldDataId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		ticketEntryId = objectInput.readLong();

		ticketFieldId = objectInput.readLong();
		data = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketFieldDataId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(ticketEntryId);

		objectOutput.writeLong(ticketFieldId);

		if (data == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(data);
		}
	}

	public long ticketFieldDataId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long ticketEntryId;
	public long ticketFieldId;
	public String data;

}