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
import com.liferay.yithro.ticket.model.TicketStructure;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketStructure in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TicketStructureCacheModel
	implements CacheModel<TicketStructure>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketStructureCacheModel)) {
			return false;
		}

		TicketStructureCacheModel ticketStructureCacheModel =
			(TicketStructureCacheModel)obj;

		if (ticketStructureId == ticketStructureCacheModel.ticketStructureId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketStructureId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ticketStructureId=");
		sb.append(ticketStructureId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", structure=");
		sb.append(structure);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketStructure toEntityModel() {
		TicketStructureImpl ticketStructureImpl = new TicketStructureImpl();

		ticketStructureImpl.setTicketStructureId(ticketStructureId);
		ticketStructureImpl.setCompanyId(companyId);
		ticketStructureImpl.setUserId(userId);

		if (userName == null) {
			ticketStructureImpl.setUserName("");
		}
		else {
			ticketStructureImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ticketStructureImpl.setCreateDate(null);
		}
		else {
			ticketStructureImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketStructureImpl.setModifiedDate(null);
		}
		else {
			ticketStructureImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			ticketStructureImpl.setName("");
		}
		else {
			ticketStructureImpl.setName(name);
		}

		if (description == null) {
			ticketStructureImpl.setDescription("");
		}
		else {
			ticketStructureImpl.setDescription(description);
		}

		if (structure == null) {
			ticketStructureImpl.setStructure("");
		}
		else {
			ticketStructureImpl.setStructure(structure);
		}

		ticketStructureImpl.resetOriginalValues();

		return ticketStructureImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketStructureId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		structure = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketStructureId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

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

		if (structure == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(structure);
		}
	}

	public long ticketStructureId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;
	public String structure;

}