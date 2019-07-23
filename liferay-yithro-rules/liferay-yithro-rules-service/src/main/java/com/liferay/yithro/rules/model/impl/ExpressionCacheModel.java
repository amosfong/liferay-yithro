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
import com.liferay.yithro.rules.model.Expression;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing Expression in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ExpressionCacheModel
	implements CacheModel<Expression>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExpressionCacheModel)) {
			return false;
		}

		ExpressionCacheModel expressionCacheModel = (ExpressionCacheModel)obj;

		if (expressionId == expressionCacheModel.expressionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, expressionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{expressionId=");
		sb.append(expressionId);
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
	public Expression toEntityModel() {
		ExpressionImpl expressionImpl = new ExpressionImpl();

		expressionImpl.setExpressionId(expressionId);
		expressionImpl.setRuleId(ruleId);

		if (type == null) {
			expressionImpl.setType("");
		}
		else {
			expressionImpl.setType(type);
		}

		if (field == null) {
			expressionImpl.setField("");
		}
		else {
			expressionImpl.setField(field);
		}

		if (operation == null) {
			expressionImpl.setOperation("");
		}
		else {
			expressionImpl.setOperation(operation);
		}

		if (value == null) {
			expressionImpl.setValue("");
		}
		else {
			expressionImpl.setValue(value);
		}

		expressionImpl.resetOriginalValues();

		return expressionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		expressionId = objectInput.readLong();

		ruleId = objectInput.readLong();
		type = objectInput.readUTF();
		field = objectInput.readUTF();
		operation = objectInput.readUTF();
		value = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(expressionId);

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

	public long expressionId;
	public long ruleId;
	public String type;
	public String field;
	public String operation;
	public String value;

}