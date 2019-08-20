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
import com.liferay.yithro.ticket.model.TicketAttachment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing TicketAttachment in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketAttachmentCacheModel
	implements CacheModel<TicketAttachment>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketAttachmentCacheModel)) {
			return false;
		}

		TicketAttachmentCacheModel ticketAttachmentCacheModel =
			(TicketAttachmentCacheModel)obj;

		if (ticketAttachmentId ==
				ticketAttachmentCacheModel.ticketAttachmentId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketAttachmentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{ticketAttachmentId=");
		sb.append(ticketAttachmentId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", ticketEntryId=");
		sb.append(ticketEntryId);
		sb.append(", ticketFieldId=");
		sb.append(ticketFieldId);
		sb.append(", ticketCommunicationId=");
		sb.append(ticketCommunicationId);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", fileSize=");
		sb.append(fileSize);
		sb.append(", visibility=");
		sb.append(visibility);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketAttachment toEntityModel() {
		TicketAttachmentImpl ticketAttachmentImpl = new TicketAttachmentImpl();

		ticketAttachmentImpl.setTicketAttachmentId(ticketAttachmentId);
		ticketAttachmentImpl.setCompanyId(companyId);
		ticketAttachmentImpl.setUserId(userId);

		if (userName == null) {
			ticketAttachmentImpl.setUserName("");
		}
		else {
			ticketAttachmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ticketAttachmentImpl.setCreateDate(null);
		}
		else {
			ticketAttachmentImpl.setCreateDate(new Date(createDate));
		}

		ticketAttachmentImpl.setTicketEntryId(ticketEntryId);
		ticketAttachmentImpl.setTicketFieldId(ticketFieldId);
		ticketAttachmentImpl.setTicketCommunicationId(ticketCommunicationId);

		if (fileName == null) {
			ticketAttachmentImpl.setFileName("");
		}
		else {
			ticketAttachmentImpl.setFileName(fileName);
		}

		ticketAttachmentImpl.setFileSize(fileSize);
		ticketAttachmentImpl.setVisibility(visibility);
		ticketAttachmentImpl.setStatus(status);

		ticketAttachmentImpl.resetOriginalValues();

		return ticketAttachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketAttachmentId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();

		ticketEntryId = objectInput.readLong();

		ticketFieldId = objectInput.readLong();

		ticketCommunicationId = objectInput.readLong();
		fileName = objectInput.readUTF();

		fileSize = objectInput.readLong();

		visibility = objectInput.readInt();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketAttachmentId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(ticketEntryId);

		objectOutput.writeLong(ticketFieldId);

		objectOutput.writeLong(ticketCommunicationId);

		if (fileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		objectOutput.writeLong(fileSize);

		objectOutput.writeInt(visibility);

		objectOutput.writeInt(status);
	}

	public long ticketAttachmentId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long ticketEntryId;
	public long ticketFieldId;
	public long ticketCommunicationId;
	public String fileName;
	public long fileSize;
	public int visibility;
	public int status;

}