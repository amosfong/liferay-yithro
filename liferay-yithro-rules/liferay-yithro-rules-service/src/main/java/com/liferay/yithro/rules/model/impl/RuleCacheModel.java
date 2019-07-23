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
import com.liferay.yithro.rules.model.Rule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Rule in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class RuleCacheModel implements CacheModel<Rule>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleCacheModel)) {
			return false;
		}

		RuleCacheModel ruleCacheModel = (RuleCacheModel)obj;

		if (ruleId == ruleCacheModel.ruleId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ruleId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{ruleId=");
		sb.append(ruleId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", triggerAction=");
		sb.append(triggerAction);
		sb.append(", triggerObject=");
		sb.append(triggerObject);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Rule toEntityModel() {
		RuleImpl ruleImpl = new RuleImpl();

		ruleImpl.setRuleId(ruleId);

		if (name == null) {
			ruleImpl.setName("");
		}
		else {
			ruleImpl.setName(name);
		}

		if (triggerAction == null) {
			ruleImpl.setTriggerAction("");
		}
		else {
			ruleImpl.setTriggerAction(triggerAction);
		}

		if (triggerObject == null) {
			ruleImpl.setTriggerObject("");
		}
		else {
			ruleImpl.setTriggerObject(triggerObject);
		}

		ruleImpl.resetOriginalValues();

		return ruleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ruleId = objectInput.readLong();
		name = objectInput.readUTF();
		triggerAction = objectInput.readUTF();
		triggerObject = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ruleId);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (triggerAction == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(triggerAction);
		}

		if (triggerObject == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(triggerObject);
		}
	}

	public long ruleId;
	public String name;
	public String triggerAction;
	public String triggerObject;

}