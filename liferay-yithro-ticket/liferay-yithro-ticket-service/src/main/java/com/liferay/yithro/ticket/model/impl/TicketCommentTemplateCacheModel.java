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
import com.liferay.yithro.ticket.model.TicketCommentTemplate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TicketCommentTemplate in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketCommentTemplateCacheModel
	implements CacheModel<TicketCommentTemplate>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketCommentTemplateCacheModel)) {
			return false;
		}

		TicketCommentTemplateCacheModel ticketCommentTemplateCacheModel =
			(TicketCommentTemplateCacheModel)obj;

		if (ticketCommentTemplateId ==
				ticketCommentTemplateCacheModel.ticketCommentTemplateId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketCommentTemplateId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ticketCommentTemplateId=");
		sb.append(ticketCommentTemplateId);
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
		sb.append(", content=");
		sb.append(content);
		sb.append(", useCount=");
		sb.append(useCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketCommentTemplate toEntityModel() {
		TicketCommentTemplateImpl ticketCommentTemplateImpl =
			new TicketCommentTemplateImpl();

		ticketCommentTemplateImpl.setTicketCommentTemplateId(
			ticketCommentTemplateId);
		ticketCommentTemplateImpl.setCompanyId(companyId);
		ticketCommentTemplateImpl.setUserId(userId);

		if (userName == null) {
			ticketCommentTemplateImpl.setUserName("");
		}
		else {
			ticketCommentTemplateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ticketCommentTemplateImpl.setCreateDate(null);
		}
		else {
			ticketCommentTemplateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ticketCommentTemplateImpl.setModifiedDate(null);
		}
		else {
			ticketCommentTemplateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			ticketCommentTemplateImpl.setName("");
		}
		else {
			ticketCommentTemplateImpl.setName(name);
		}

		if (content == null) {
			ticketCommentTemplateImpl.setContent("");
		}
		else {
			ticketCommentTemplateImpl.setContent(content);
		}

		ticketCommentTemplateImpl.setUseCount(useCount);

		ticketCommentTemplateImpl.resetOriginalValues();

		return ticketCommentTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketCommentTemplateId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		content = objectInput.readUTF();

		useCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketCommentTemplateId);

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

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeInt(useCount);
	}

	public long ticketCommentTemplateId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String content;
	public int useCount;

}