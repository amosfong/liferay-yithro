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
import com.liferay.yithro.ticket.model.TicketStatus;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketStatus in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketStatusCacheModel
	implements CacheModel<TicketStatus>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketStatusCacheModel)) {
			return false;
		}

		TicketStatusCacheModel ticketStatusCacheModel =
			(TicketStatusCacheModel)obj;

		if (ticketStatusId == ticketStatusCacheModel.ticketStatusId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketStatusId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ticketStatusId=");
		sb.append(ticketStatusId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", order=");
		sb.append(order);
		sb.append(", terminal=");
		sb.append(terminal);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketStatus toEntityModel() {
		TicketStatusImpl ticketStatusImpl = new TicketStatusImpl();

		ticketStatusImpl.setTicketStatusId(ticketStatusId);
		ticketStatusImpl.setCompanyId(companyId);
		ticketStatusImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			ticketStatusImpl.setCreateDate(null);
		}
		else {
			ticketStatusImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketStatusImpl.setModifiedDate(null);
		}
		else {
			ticketStatusImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			ticketStatusImpl.setName("");
		}
		else {
			ticketStatusImpl.setName(name);
		}

		if (description == null) {
			ticketStatusImpl.setDescription("");
		}
		else {
			ticketStatusImpl.setDescription(description);
		}

		ticketStatusImpl.setOrder(order);
		ticketStatusImpl.setTerminal(terminal);
		ticketStatusImpl.setStatus(status);

		ticketStatusImpl.resetOriginalValues();

		return ticketStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketStatusId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		order = objectInput.readInt();

		terminal = objectInput.readBoolean();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketStatusId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(order);

		objectOutput.writeBoolean(terminal);

		objectOutput.writeInt(status);
	}

	public long ticketStatusId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public int order;
	public boolean terminal;
	public int status;

}