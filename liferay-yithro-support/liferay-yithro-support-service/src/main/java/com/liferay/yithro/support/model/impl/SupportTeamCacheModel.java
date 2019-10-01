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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.yithro.support.model.SupportTeam;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SupportTeam in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SupportTeamCacheModel
	implements CacheModel<SupportTeam>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupportTeamCacheModel)) {
			return false;
		}

		SupportTeamCacheModel supportTeamCacheModel =
			(SupportTeamCacheModel)obj;

		if (supportTeamId == supportTeamCacheModel.supportTeamId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, supportTeamId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{supportTeamId=");
		sb.append(supportTeamId);
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
		sb.append(", parentSupportTeamId=");
		sb.append(parentSupportTeamId);
		sb.append(", supportLaborId=");
		sb.append(supportLaborId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", assignedWork=");
		sb.append(assignedWork);
		sb.append(", maxWork=");
		sb.append(maxWork);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SupportTeam toEntityModel() {
		SupportTeamImpl supportTeamImpl = new SupportTeamImpl();

		supportTeamImpl.setSupportTeamId(supportTeamId);
		supportTeamImpl.setCompanyId(companyId);
		supportTeamImpl.setUserId(userId);

		if (userName == null) {
			supportTeamImpl.setUserName("");
		}
		else {
			supportTeamImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			supportTeamImpl.setCreateDate(null);
		}
		else {
			supportTeamImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			supportTeamImpl.setModifiedDate(null);
		}
		else {
			supportTeamImpl.setModifiedDate(new Date(modifiedDate));
		}

		supportTeamImpl.setParentSupportTeamId(parentSupportTeamId);
		supportTeamImpl.setSupportLaborId(supportLaborId);

		if (name == null) {
			supportTeamImpl.setName("");
		}
		else {
			supportTeamImpl.setName(name);
		}

		if (description == null) {
			supportTeamImpl.setDescription("");
		}
		else {
			supportTeamImpl.setDescription(description);
		}

		supportTeamImpl.setAssignedWork(assignedWork);
		supportTeamImpl.setMaxWork(maxWork);

		supportTeamImpl.resetOriginalValues();

		return supportTeamImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supportTeamId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		parentSupportTeamId = objectInput.readLong();

		supportLaborId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();

		assignedWork = objectInput.readDouble();

		maxWork = objectInput.readDouble();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(supportTeamId);

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

		objectOutput.writeLong(parentSupportTeamId);

		objectOutput.writeLong(supportLaborId);

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

		objectOutput.writeDouble(assignedWork);

		objectOutput.writeDouble(maxWork);
	}

	public long supportTeamId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long parentSupportTeamId;
	public long supportLaborId;
	public String name;
	public String description;
	public double assignedWork;
	public double maxWork;

}