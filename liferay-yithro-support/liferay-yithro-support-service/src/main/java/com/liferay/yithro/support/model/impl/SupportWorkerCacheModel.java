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

package com.liferay.yithro.support.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.yithro.support.model.SupportWorker;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SupportWorker in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SupportWorkerCacheModel
	implements CacheModel<SupportWorker>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupportWorkerCacheModel)) {
			return false;
		}

		SupportWorkerCacheModel supportWorkerCacheModel =
			(SupportWorkerCacheModel)obj;

		if (supportWorkerId == supportWorkerCacheModel.supportWorkerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, supportWorkerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{supportWorkerId=");
		sb.append(supportWorkerId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", supportTeamId=");
		sb.append(supportTeamId);
		sb.append(", supportLaborId=");
		sb.append(supportLaborId);
		sb.append(", assignedWork=");
		sb.append(assignedWork);
		sb.append(", maxWork=");
		sb.append(maxWork);
		sb.append(", role=");
		sb.append(role);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SupportWorker toEntityModel() {
		SupportWorkerImpl supportWorkerImpl = new SupportWorkerImpl();

		supportWorkerImpl.setSupportWorkerId(supportWorkerId);
		supportWorkerImpl.setCompanyId(companyId);
		supportWorkerImpl.setUserId(userId);
		supportWorkerImpl.setSupportTeamId(supportTeamId);
		supportWorkerImpl.setSupportLaborId(supportLaborId);
		supportWorkerImpl.setAssignedWork(assignedWork);
		supportWorkerImpl.setMaxWork(maxWork);
		supportWorkerImpl.setRole(role);

		supportWorkerImpl.resetOriginalValues();

		return supportWorkerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supportWorkerId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();

		supportTeamId = objectInput.readLong();

		supportLaborId = objectInput.readLong();

		assignedWork = objectInput.readDouble();

		maxWork = objectInput.readDouble();

		role = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(supportWorkerId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(supportTeamId);

		objectOutput.writeLong(supportLaborId);

		objectOutput.writeDouble(assignedWork);

		objectOutput.writeDouble(maxWork);

		objectOutput.writeInt(role);
	}

	public long supportWorkerId;
	public long companyId;
	public long userId;
	public long supportTeamId;
	public long supportLaborId;
	public double assignedWork;
	public double maxWork;
	public int role;

}