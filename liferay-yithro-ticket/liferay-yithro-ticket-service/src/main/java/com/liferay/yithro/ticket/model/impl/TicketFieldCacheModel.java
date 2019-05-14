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
import com.liferay.yithro.ticket.model.TicketField;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing TicketField in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketFieldCacheModel
	implements CacheModel<TicketField>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketFieldCacheModel)) {
			return false;
		}

		TicketFieldCacheModel ticketFieldCacheModel =
			(TicketFieldCacheModel)obj;

		if (ticketFieldId == ticketFieldCacheModel.ticketFieldId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketFieldId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{ticketFieldId=");
		sb.append(ticketFieldId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", visibility=");
		sb.append(visibility);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketField toEntityModel() {
		TicketFieldImpl ticketFieldImpl = new TicketFieldImpl();

		ticketFieldImpl.setTicketFieldId(ticketFieldId);
		ticketFieldImpl.setCompanyId(companyId);
		ticketFieldImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			ticketFieldImpl.setCreateDate(null);
		}
		else {
			ticketFieldImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketFieldImpl.setModifiedDate(null);
		}
		else {
			ticketFieldImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			ticketFieldImpl.setName("");
		}
		else {
			ticketFieldImpl.setName(name);
		}

		ticketFieldImpl.setType(type);
		ticketFieldImpl.setVisibility(visibility);

		ticketFieldImpl.resetOriginalValues();

		return ticketFieldImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketFieldId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		type = objectInput.readInt();

		visibility = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketFieldId);

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

		objectOutput.writeInt(type);

		objectOutput.writeInt(visibility);
	}

	public long ticketFieldId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public int type;
	public int visibility;

}