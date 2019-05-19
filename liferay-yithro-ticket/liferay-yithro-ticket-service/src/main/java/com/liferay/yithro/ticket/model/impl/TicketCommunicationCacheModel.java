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
import com.liferay.yithro.ticket.model.TicketCommunication;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing TicketCommunication in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketCommunicationCacheModel
	implements CacheModel<TicketCommunication>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketCommunicationCacheModel)) {
			return false;
		}

		TicketCommunicationCacheModel ticketCommunicationCacheModel =
			(TicketCommunicationCacheModel)obj;

		if (ticketCommunicationId ==
				ticketCommunicationCacheModel.ticketCommunicationId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketCommunicationId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{ticketCommunicationId=");
		sb.append(ticketCommunicationId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", ticketEntryId=");
		sb.append(ticketEntryId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", content=");
		sb.append(content);
		sb.append(", properties=");
		sb.append(properties);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketCommunication toEntityModel() {
		TicketCommunicationImpl ticketCommunicationImpl =
			new TicketCommunicationImpl();

		ticketCommunicationImpl.setTicketCommunicationId(ticketCommunicationId);
		ticketCommunicationImpl.setCompanyId(companyId);
		ticketCommunicationImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			ticketCommunicationImpl.setCreateDate(null);
		}
		else {
			ticketCommunicationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketCommunicationImpl.setModifiedDate(null);
		}
		else {
			ticketCommunicationImpl.setModifiedDate(new Date(modifiedDate));
		}

		ticketCommunicationImpl.setTicketEntryId(ticketEntryId);
		ticketCommunicationImpl.setClassNameId(classNameId);
		ticketCommunicationImpl.setClassPK(classPK);

		if (content == null) {
			ticketCommunicationImpl.setContent("");
		}
		else {
			ticketCommunicationImpl.setContent(content);
		}

		if (properties == null) {
			ticketCommunicationImpl.setProperties("");
		}
		else {
			ticketCommunicationImpl.setProperties(properties);
		}

		ticketCommunicationImpl.resetOriginalValues();

		return ticketCommunicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketCommunicationId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		ticketEntryId = objectInput.readLong();

		classNameId = objectInput.readLong();

		classPK = objectInput.readLong();
		content = objectInput.readUTF();
		properties = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketCommunicationId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(ticketEntryId);

		objectOutput.writeLong(classNameId);

		objectOutput.writeLong(classPK);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (properties == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(properties);
		}
	}

	public long ticketCommunicationId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public long ticketEntryId;
	public long classNameId;
	public long classPK;
	public String content;
	public String properties;

}