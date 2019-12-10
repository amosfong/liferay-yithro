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
import com.liferay.yithro.rules.model.RuleCondition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RuleCondition in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RuleConditionCacheModel
	implements CacheModel<RuleCondition>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleConditionCacheModel)) {
			return false;
		}

		RuleConditionCacheModel ruleConditionCacheModel =
			(RuleConditionCacheModel)obj;

		if (ruleConditionId == ruleConditionCacheModel.ruleConditionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ruleConditionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{ruleConditionId=");
		sb.append(ruleConditionId);
		sb.append(", ruleId=");
		sb.append(ruleId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", field=");
		sb.append(field);
		sb.append(", operation=");
		sb.append(operation);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RuleCondition toEntityModel() {
		RuleConditionImpl ruleConditionImpl = new RuleConditionImpl();

		ruleConditionImpl.setRuleConditionId(ruleConditionId);
		ruleConditionImpl.setRuleId(ruleId);

		if (type == null) {
			ruleConditionImpl.setType("");
		}
		else {
			ruleConditionImpl.setType(type);
		}

		if (field == null) {
			ruleConditionImpl.setField("");
		}
		else {
			ruleConditionImpl.setField(field);
		}

		if (operation == null) {
			ruleConditionImpl.setOperation("");
		}
		else {
			ruleConditionImpl.setOperation(operation);
		}

		if (value == null) {
			ruleConditionImpl.setValue("");
		}
		else {
			ruleConditionImpl.setValue(value);
		}

		ruleConditionImpl.resetOriginalValues();

		return ruleConditionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ruleConditionId = objectInput.readLong();

		ruleId = objectInput.readLong();
		type = objectInput.readUTF();
		field = objectInput.readUTF();
		operation = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ruleConditionId);

		objectOutput.writeLong(ruleId);

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (field == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(field);
		}

		if (operation == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(operation);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long ruleConditionId;
	public long ruleId;
	public String type;
	public String field;
	public String operation;
	public String value;

}