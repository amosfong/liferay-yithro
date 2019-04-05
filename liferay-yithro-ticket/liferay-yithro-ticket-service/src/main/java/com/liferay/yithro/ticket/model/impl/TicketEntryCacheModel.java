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
import com.liferay.yithro.ticket.model.TicketEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketEntry in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketEntryCacheModel
	implements CacheModel<TicketEntry>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketEntryCacheModel)) {
			return false;
		}

		TicketEntryCacheModel ticketEntryCacheModel =
			(TicketEntryCacheModel)obj;

		if (ticketEntryId == ticketEntryCacheModel.ticketEntryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketEntryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{ticketEntryId=");
		sb.append(ticketEntryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", ticketNumber=");
		sb.append(ticketNumber);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", description=");
		sb.append(description);
		sb.append(", severity=");
		sb.append(severity);
		sb.append(", status=");
		sb.append(status);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", escalationLevel=");
		sb.append(escalationLevel);
		sb.append(", resolution=");
		sb.append(resolution);
		sb.append(", holdDate=");
		sb.append(holdDate);
		sb.append(", closedDate=");
		sb.append(closedDate);
		sb.append(", dueDate=");
		sb.append(dueDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketEntry toEntityModel() {
		TicketEntryImpl ticketEntryImpl = new TicketEntryImpl();

		ticketEntryImpl.setTicketEntryId(ticketEntryId);
		ticketEntryImpl.setUserId(userId);

		if (userName == null) {
			ticketEntryImpl.setUserName("");
		}
		else {
			ticketEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ticketEntryImpl.setCreateDate(null);
		}
		else {
			ticketEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketEntryImpl.setModifiedDate(null);
		}
		else {
			ticketEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (languageId == null) {
			ticketEntryImpl.setLanguageId("");
		}
		else {
			ticketEntryImpl.setLanguageId(languageId);
		}

		ticketEntryImpl.setTicketNumber(ticketNumber);

		if (subject == null) {
			ticketEntryImpl.setSubject("");
		}
		else {
			ticketEntryImpl.setSubject(subject);
		}

		if (description == null) {
			ticketEntryImpl.setDescription("");
		}
		else {
			ticketEntryImpl.setDescription(description);
		}

		ticketEntryImpl.setSeverity(severity);
		ticketEntryImpl.setStatus(status);
		ticketEntryImpl.setWeight(weight);
		ticketEntryImpl.setEscalationLevel(escalationLevel);
		ticketEntryImpl.setResolution(resolution);

		if (holdDate == Long.MIN_VALUE) {
			ticketEntryImpl.setHoldDate(null);
		}
		else {
			ticketEntryImpl.setHoldDate(new Date(holdDate));
		}

		if (closedDate == Long.MIN_VALUE) {
			ticketEntryImpl.setClosedDate(null);
		}
		else {
			ticketEntryImpl.setClosedDate(new Date(closedDate));
		}

		if (dueDate == Long.MIN_VALUE) {
			ticketEntryImpl.setDueDate(null);
		}
		else {
			ticketEntryImpl.setDueDate(new Date(dueDate));
		}

		ticketEntryImpl.resetOriginalValues();

		return ticketEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketEntryId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		languageId = objectInput.readUTF();

		ticketNumber = objectInput.readLong();
		subject = objectInput.readUTF();
		description = objectInput.readUTF();

		severity = objectInput.readInt();

		status = objectInput.readInt();

		weight = objectInput.readInt();

		escalationLevel = objectInput.readInt();

		resolution = objectInput.readInt();
		holdDate = objectInput.readLong();
		closedDate = objectInput.readLong();
		dueDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketEntryId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (languageId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		objectOutput.writeLong(ticketNumber);

		if (subject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeInt(severity);

		objectOutput.writeInt(status);

		objectOutput.writeInt(weight);

		objectOutput.writeInt(escalationLevel);

		objectOutput.writeInt(resolution);
		objectOutput.writeLong(holdDate);
		objectOutput.writeLong(closedDate);
		objectOutput.writeLong(dueDate);
	}

	public long ticketEntryId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String languageId;
	public long ticketNumber;
	public String subject;
	public String description;
	public int severity;
	public int status;
	public int weight;
	public int escalationLevel;
	public int resolution;
	public long holdDate;
	public long closedDate;
	public long dueDate;

}