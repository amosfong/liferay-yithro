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
import com.liferay.yithro.rules.model.Action;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Action in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ActionCacheModel implements CacheModel<Action>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActionCacheModel)) {
			return false;
		}

		ActionCacheModel actionCacheModel = (ActionCacheModel)obj;

		if (actionId == actionCacheModel.actionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, actionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{actionId=");
		sb.append(actionId);
		sb.append(", ruleId=");
		sb.append(ruleId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Action toEntityModel() {
		ActionImpl actionImpl = new ActionImpl();

		actionImpl.setActionId(actionId);
		actionImpl.setRuleId(ruleId);

		if (name == null) {
			actionImpl.setName("");
		}
		else {
			actionImpl.setName(name);
		}

		if (value == null) {
			actionImpl.setValue("");
		}
		else {
			actionImpl.setValue(value);
		}

		actionImpl.resetOriginalValues();

		return actionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		actionId = objectInput.readLong();

		ruleId = objectInput.readLong();
		name = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(actionId);

		objectOutput.writeLong(ruleId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (value == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public long actionId;
	public long ruleId;
	public String name;
	public String value;

}