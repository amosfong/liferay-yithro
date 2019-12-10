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
import com.liferay.yithro.rules.model.RuleAction;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing RuleAction in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class RuleActionCacheModel
	implements CacheModel<RuleAction>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RuleActionCacheModel)) {
			return false;
		}

		RuleActionCacheModel ruleActionCacheModel = (RuleActionCacheModel)obj;

		if (ruleActionId == ruleActionCacheModel.ruleActionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ruleActionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{ruleActionId=");
		sb.append(ruleActionId);
		sb.append(", ruleId=");
		sb.append(ruleId);
		sb.append(", actionClassName=");
		sb.append(actionClassName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RuleAction toEntityModel() {
		RuleActionImpl ruleActionImpl = new RuleActionImpl();

		ruleActionImpl.setRuleActionId(ruleActionId);
		ruleActionImpl.setRuleId(ruleId);

		if (actionClassName == null) {
			ruleActionImpl.setActionClassName("");
		}
		else {
			ruleActionImpl.setActionClassName(actionClassName);
		}

		ruleActionImpl.resetOriginalValues();

		return ruleActionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ruleActionId = objectInput.readLong();

		ruleId = objectInput.readLong();
		actionClassName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(ruleActionId);

		objectOutput.writeLong(ruleId);

		if (actionClassName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(actionClassName);
		}
	}

	public long ruleActionId;
	public long ruleId;
	public String actionClassName;

}