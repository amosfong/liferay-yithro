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
import com.liferay.yithro.ticket.model.TicketWorker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TicketWorker in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class TicketWorkerCacheModel
	implements CacheModel<TicketWorker>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketWorkerCacheModel)) {
			return false;
		}

		TicketWorkerCacheModel ticketWorkerCacheModel =
			(TicketWorkerCacheModel)obj;

		if (ticketWorkerId == ticketWorkerCacheModel.ticketWorkerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ticketWorkerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{ticketWorkerId=");
		sb.append(ticketWorkerId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", ticketEntryId=");
		sb.append(ticketEntryId);
		sb.append(", sourceClassNameId=");
		sb.append(sourceClassNameId);
		sb.append(", sourceClassPK=");
		sb.append(sourceClassPK);
		sb.append(", role=");
		sb.append(role);
		sb.append(", primary=");
		sb.append(primary);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TicketWorker toEntityModel() {
		TicketWorkerImpl ticketWorkerImpl = new TicketWorkerImpl();

		ticketWorkerImpl.setTicketWorkerId(ticketWorkerId);
		ticketWorkerImpl.setCompanyId(companyId);
		ticketWorkerImpl.setUserId(userId);

		if (userName == null) {
			ticketWorkerImpl.setUserName("");
		}
		else {
			ticketWorkerImpl.setUserName(userName);
		}

		ticketWorkerImpl.setTicketEntryId(ticketEntryId);
		ticketWorkerImpl.setSourceClassNameId(sourceClassNameId);
		ticketWorkerImpl.setSourceClassPK(sourceClassPK);
		ticketWorkerImpl.setRole(role);
		ticketWorkerImpl.setPrimary(primary);

		ticketWorkerImpl.resetOriginalValues();

		return ticketWorkerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ticketWorkerId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();

		ticketEntryId = objectInput.readLong();

		sourceClassNameId = objectInput.readLong();

		sourceClassPK = objectInput.readLong();

		role = objectInput.readInt();

		primary = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ticketWorkerId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(ticketEntryId);

		objectOutput.writeLong(sourceClassNameId);

		objectOutput.writeLong(sourceClassPK);

		objectOutput.writeInt(role);

		objectOutput.writeBoolean(primary);
	}

	public long ticketWorkerId;
	public long companyId;
	public long userId;
	public String userName;
	public long ticketEntryId;
	public long sourceClassNameId;
	public long sourceClassPK;
	public int role;
	public boolean primary;

}