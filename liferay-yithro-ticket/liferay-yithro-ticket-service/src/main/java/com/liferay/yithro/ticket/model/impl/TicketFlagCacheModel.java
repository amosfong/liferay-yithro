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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.yithro.ticket.model.TicketFlag;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketFlag in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketFlagCacheModel
	implements CacheModel<TicketFlag>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketFlagCacheModel)) {
			return false;
		}

		TicketFlagCacheModel ticketFlagCacheModel = (TicketFlagCacheModel)obj;

		if (ticketFlagId == ticketFlagCacheModel.ticketFlagId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketFlagId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{ticketFlagId=");
		sb.append(ticketFlagId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ticketEntryId=");
		sb.append(ticketEntryId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketFlag toEntityModel() {
		TicketFlagImpl ticketFlagImpl = new TicketFlagImpl();

		ticketFlagImpl.setTicketFlagId(ticketFlagId);
		ticketFlagImpl.setCompanyId(companyId);
		ticketFlagImpl.setUserId(userId);

		if (modifiedDate == Long.MIN_VALUE) {
			ticketFlagImpl.setModifiedDate(null);
		}
		else {
			ticketFlagImpl.setModifiedDate(new Date(modifiedDate));
		}

		ticketFlagImpl.setTicketEntryId(ticketEntryId);
		ticketFlagImpl.setType(type);
		ticketFlagImpl.setValue(value);

		ticketFlagImpl.resetOriginalValues();

		return ticketFlagImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketFlagId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		ticketEntryId = objectInput.readLong();

		type = objectInput.readInt();

		value = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketFlagId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(ticketEntryId);

		objectOutput.writeInt(type);

		objectOutput.writeInt(value);
	}

	public long ticketFlagId;
	public long companyId;
	public long userId;
	public long modifiedDate;
	public long ticketEntryId;
	public int type;
	public int value;

}