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

package com.liferay.yithro.rules.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.yithro.rules.model.RuleActionData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RuleActionData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RuleActionDataCacheModel
	implements CacheModel<RuleActionData>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleActionDataCacheModel)) {
			return false;
		}

		RuleActionDataCacheModel ruleActionDataCacheModel =
			(RuleActionDataCacheModel)obj;

		if (ruleActionDataId == ruleActionDataCacheModel.ruleActionDataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ruleActionDataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ruleActionDataId=");
		sb.append(ruleActionDataId);
		sb.append(", ruleActionId=");
		sb.append(ruleActionId);
		sb.append(", field=");
		sb.append(field);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RuleActionData toEntityModel() {
		RuleActionDataImpl ruleActionDataImpl = new RuleActionDataImpl();

		ruleActionDataImpl.setRuleActionDataId(ruleActionDataId);
		ruleActionDataImpl.setRuleActionId(ruleActionId);

		if (field == null) {
			ruleActionDataImpl.setField("");
		}
		else {
			ruleActionDataImpl.setField(field);
		}

		if (value == null) {
			ruleActionDataImpl.setValue("");
		}
		else {
			ruleActionDataImpl.setValue(value);
		}

		ruleActionDataImpl.resetOriginalValues();

		return ruleActionDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ruleActionDataId = objectInput.readLong();

		ruleActionId = objectInput.readLong();
		field = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ruleActionDataId);

		objectOutput.writeLong(ruleActionId);

		if (field == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(field);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long ruleActionDataId;
	public long ruleActionId;
	public String field;
	public String value;

}