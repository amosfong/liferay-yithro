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
import com.liferay.yithro.ticket.model.TicketFieldOption;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketFieldOption in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketFieldOptionCacheModel
	implements CacheModel<TicketFieldOption>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketFieldOptionCacheModel)) {
			return false;
		}

		TicketFieldOptionCacheModel ticketFieldOptionCacheModel =
			(TicketFieldOptionCacheModel)obj;

		if (ticketFieldOptionId ==
				ticketFieldOptionCacheModel.ticketFieldOptionId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketFieldOptionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ticketFieldOptionId=");
		sb.append(ticketFieldOptionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ticketFieldId=");
		sb.append(ticketFieldId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", visibility=");
		sb.append(visibility);
		sb.append(", order=");
		sb.append(order);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketFieldOption toEntityModel() {
		TicketFieldOptionImpl ticketFieldOptionImpl =
			new TicketFieldOptionImpl();

		ticketFieldOptionImpl.setTicketFieldOptionId(ticketFieldOptionId);
		ticketFieldOptionImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			ticketFieldOptionImpl.setCreateDate(null);
		}
		else {
			ticketFieldOptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketFieldOptionImpl.setModifiedDate(null);
		}
		else {
			ticketFieldOptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		ticketFieldOptionImpl.setTicketFieldId(ticketFieldId);

		if (name == null) {
			ticketFieldOptionImpl.setName("");
		}
		else {
			ticketFieldOptionImpl.setName(name);
		}

		ticketFieldOptionImpl.setVisibility(visibility);
		ticketFieldOptionImpl.setOrder(order);
		ticketFieldOptionImpl.setStatus(status);

		ticketFieldOptionImpl.resetOriginalValues();

		return ticketFieldOptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketFieldOptionId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		ticketFieldId = objectInput.readLong();
		name = objectInput.readUTF();

		visibility = objectInput.readInt();

		order = objectInput.readInt();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketFieldOptionId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(ticketFieldId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(visibility);

		objectOutput.writeInt(order);

		objectOutput.writeInt(status);
	}

	public long ticketFieldOptionId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long ticketFieldId;
	public String name;
	public int visibility;
	public int order;
	public int status;

}