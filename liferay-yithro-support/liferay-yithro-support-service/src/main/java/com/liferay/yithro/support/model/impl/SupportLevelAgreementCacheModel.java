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
import com.liferay.yithro.support.model.SupportLevelAgreement;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SupportLevelAgreement in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class SupportLevelAgreementCacheModel
	implements CacheModel<SupportLevelAgreement>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SupportLevelAgreementCacheModel)) {
			return false;
		}

		SupportLevelAgreementCacheModel supportLevelAgreementCacheModel =
			(SupportLevelAgreementCacheModel)obj;

		if (supportLevelAgreementId ==
				supportLevelAgreementCacheModel.supportLevelAgreementId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, supportLevelAgreementId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{supportLevelAgreementId=");
		sb.append(supportLevelAgreementId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SupportLevelAgreement toEntityModel() {
		SupportLevelAgreementImpl supportLevelAgreementImpl =
			new SupportLevelAgreementImpl();

		supportLevelAgreementImpl.setSupportLevelAgreementId(
			supportLevelAgreementId);
		supportLevelAgreementImpl.setCompanyId(companyId);
		supportLevelAgreementImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			supportLevelAgreementImpl.setCreateDate(null);
		}
		else {
			supportLevelAgreementImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			supportLevelAgreementImpl.setModifiedDate(null);
		}
		else {
			supportLevelAgreementImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			supportLevelAgreementImpl.setName("");
		}
		else {
			supportLevelAgreementImpl.setName(name);
		}

		if (description == null) {
			supportLevelAgreementImpl.setDescription("");
		}
		else {
			supportLevelAgreementImpl.setDescription(description);
		}

		supportLevelAgreementImpl.resetOriginalValues();

		return supportLevelAgreementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		supportLevelAgreementId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(supportLevelAgreementId);

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

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long supportLevelAgreementId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String description;

}