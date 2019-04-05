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

package com.liferay.yithro.audit.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.audit.model.AuditEntry;
import com.liferay.yithro.audit.model.AuditEntryModel;
import com.liferay.yithro.audit.model.AuditEntrySoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the AuditEntry service. Represents a row in the &quot;Yithro_AuditEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>AuditEntryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AuditEntryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuditEntryImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class AuditEntryModelImpl
	extends BaseModelImpl<AuditEntry> implements AuditEntryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a audit entry model instance should use the <code>AuditEntry</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_AuditEntry";

	public static final Object[][] TABLE_COLUMNS = {
		{"auditEntryId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"userName", Types.VARCHAR}, {"createDate", Types.TIMESTAMP},
		{"classNameId", Types.BIGINT}, {"classPK", Types.BIGINT},
		{"auditSetId", Types.BIGINT}, {"fieldClassNameId", Types.BIGINT},
		{"fieldClassPK", Types.BIGINT}, {"action", Types.INTEGER},
		{"field", Types.VARCHAR}, {"visibility", Types.INTEGER},
		{"oldLabel", Types.VARCHAR}, {"oldValue", Types.VARCHAR},
		{"newLabel", Types.VARCHAR}, {"newValue", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"i18n", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("auditEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("classNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("classPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("auditSetId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fieldClassNameId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("fieldClassPK", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("action", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("field", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("visibility", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("oldLabel", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("oldValue", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("newLabel", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("newValue", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("i18n", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_AuditEntry (auditEntryId LONG not null primary key,userId LONG,userName VARCHAR(75) null,createDate DATE null,classNameId LONG,classPK LONG,auditSetId LONG,fieldClassNameId LONG,fieldClassPK LONG,action INTEGER,field VARCHAR(75) null,visibility INTEGER,oldLabel VARCHAR(255) null,oldValue STRING null,newLabel VARCHAR(255) null,newValue STRING null,description STRING null,i18n BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table Yithro_AuditEntry";

	public static final String ORDER_BY_JPQL =
		" ORDER BY auditEntry.createDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_AuditEntry.createDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long ACTION_COLUMN_BITMASK = 1L;

	public static final long CLASSNAMEID_COLUMN_BITMASK = 2L;

	public static final long CLASSPK_COLUMN_BITMASK = 4L;

	public static final long CREATEDATE_COLUMN_BITMASK = 8L;

	public static final long FIELD_COLUMN_BITMASK = 16L;

	public static final long FIELDCLASSNAMEID_COLUMN_BITMASK = 32L;

	public static final long FIELDCLASSPK_COLUMN_BITMASK = 64L;

	public static final long VISIBILITY_COLUMN_BITMASK = 128L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AuditEntry toModel(AuditEntrySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AuditEntry model = new AuditEntryImpl();

		model.setAuditEntryId(soapModel.getAuditEntryId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setClassNameId(soapModel.getClassNameId());
		model.setClassPK(soapModel.getClassPK());
		model.setAuditSetId(soapModel.getAuditSetId());
		model.setFieldClassNameId(soapModel.getFieldClassNameId());
		model.setFieldClassPK(soapModel.getFieldClassPK());
		model.setAction(soapModel.getAction());
		model.setField(soapModel.getField());
		model.setVisibility(soapModel.getVisibility());
		model.setOldLabel(soapModel.getOldLabel());
		model.setOldValue(soapModel.getOldValue());
		model.setNewLabel(soapModel.getNewLabel());
		model.setNewValue(soapModel.getNewValue());
		model.setDescription(soapModel.getDescription());
		model.setI18n(soapModel.isI18n());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AuditEntry> toModels(AuditEntrySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AuditEntry> models = new ArrayList<AuditEntry>(soapModels.length);

		for (AuditEntrySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public AuditEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _auditEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAuditEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _auditEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AuditEntry.class;
	}

	@Override
	public String getModelClassName() {
		return AuditEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AuditEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AuditEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AuditEntry, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((AuditEntry)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AuditEntry, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AuditEntry, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AuditEntry)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AuditEntry, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AuditEntry, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<AuditEntry, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AuditEntry, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AuditEntry, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AuditEntry, Object>>();
		Map<String, BiConsumer<AuditEntry, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AuditEntry, ?>>();

		attributeGetterFunctions.put(
			"auditEntryId", AuditEntry::getAuditEntryId);
		attributeSetterBiConsumers.put(
			"auditEntryId",
			(BiConsumer<AuditEntry, Long>)AuditEntry::setAuditEntryId);
		attributeGetterFunctions.put("userId", AuditEntry::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<AuditEntry, Long>)AuditEntry::setUserId);
		attributeGetterFunctions.put("userName", AuditEntry::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<AuditEntry, String>)AuditEntry::setUserName);
		attributeGetterFunctions.put("createDate", AuditEntry::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AuditEntry, Date>)AuditEntry::setCreateDate);
		attributeGetterFunctions.put("classNameId", AuditEntry::getClassNameId);
		attributeSetterBiConsumers.put(
			"classNameId",
			(BiConsumer<AuditEntry, Long>)AuditEntry::setClassNameId);
		attributeGetterFunctions.put("classPK", AuditEntry::getClassPK);
		attributeSetterBiConsumers.put(
			"classPK", (BiConsumer<AuditEntry, Long>)AuditEntry::setClassPK);
		attributeGetterFunctions.put("auditSetId", AuditEntry::getAuditSetId);
		attributeSetterBiConsumers.put(
			"auditSetId",
			(BiConsumer<AuditEntry, Long>)AuditEntry::setAuditSetId);
		attributeGetterFunctions.put(
			"fieldClassNameId", AuditEntry::getFieldClassNameId);
		attributeSetterBiConsumers.put(
			"fieldClassNameId",
			(BiConsumer<AuditEntry, Long>)AuditEntry::setFieldClassNameId);
		attributeGetterFunctions.put(
			"fieldClassPK", AuditEntry::getFieldClassPK);
		attributeSetterBiConsumers.put(
			"fieldClassPK",
			(BiConsumer<AuditEntry, Long>)AuditEntry::setFieldClassPK);
		attributeGetterFunctions.put("action", AuditEntry::getAction);
		attributeSetterBiConsumers.put(
			"action", (BiConsumer<AuditEntry, Integer>)AuditEntry::setAction);
		attributeGetterFunctions.put("field", AuditEntry::getField);
		attributeSetterBiConsumers.put(
			"field", (BiConsumer<AuditEntry, String>)AuditEntry::setField);
		attributeGetterFunctions.put("visibility", AuditEntry::getVisibility);
		attributeSetterBiConsumers.put(
			"visibility",
			(BiConsumer<AuditEntry, Integer>)AuditEntry::setVisibility);
		attributeGetterFunctions.put("oldLabel", AuditEntry::getOldLabel);
		attributeSetterBiConsumers.put(
			"oldLabel",
			(BiConsumer<AuditEntry, String>)AuditEntry::setOldLabel);
		attributeGetterFunctions.put("oldValue", AuditEntry::getOldValue);
		attributeSetterBiConsumers.put(
			"oldValue",
			(BiConsumer<AuditEntry, String>)AuditEntry::setOldValue);
		attributeGetterFunctions.put("newLabel", AuditEntry::getNewLabel);
		attributeSetterBiConsumers.put(
			"newLabel",
			(BiConsumer<AuditEntry, String>)AuditEntry::setNewLabel);
		attributeGetterFunctions.put("newValue", AuditEntry::getNewValue);
		attributeSetterBiConsumers.put(
			"newValue",
			(BiConsumer<AuditEntry, String>)AuditEntry::setNewValue);
		attributeGetterFunctions.put("description", AuditEntry::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<AuditEntry, String>)AuditEntry::setDescription);
		attributeGetterFunctions.put("i18n", AuditEntry::getI18n);
		attributeSetterBiConsumers.put(
			"i18n", (BiConsumer<AuditEntry, Boolean>)AuditEntry::setI18n);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getAuditEntryId() {
		return _auditEntryId;
	}

	@Override
	public void setAuditEntryId(long auditEntryId) {
		_auditEntryId = auditEntryId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		if (_originalCreateDate == null) {
			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public Date getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@Override
	public String getClassName() {
		if (getClassNameId() <= 0) {
			return "";
		}

		return PortalUtil.getClassName(getClassNameId());
	}

	@Override
	public void setClassName(String className) {
		long classNameId = 0;

		if (Validator.isNotNull(className)) {
			classNameId = PortalUtil.getClassNameId(className);
		}

		setClassNameId(classNameId);
	}

	@JSON
	@Override
	public long getClassNameId() {
		return _classNameId;
	}

	@Override
	public void setClassNameId(long classNameId) {
		_columnBitmask |= CLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalClassNameId) {
			_setOriginalClassNameId = true;

			_originalClassNameId = _classNameId;
		}

		_classNameId = classNameId;
	}

	public long getOriginalClassNameId() {
		return _originalClassNameId;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_columnBitmask |= CLASSPK_COLUMN_BITMASK;

		if (!_setOriginalClassPK) {
			_setOriginalClassPK = true;

			_originalClassPK = _classPK;
		}

		_classPK = classPK;
	}

	public long getOriginalClassPK() {
		return _originalClassPK;
	}

	@JSON
	@Override
	public long getAuditSetId() {
		return _auditSetId;
	}

	@Override
	public void setAuditSetId(long auditSetId) {
		_auditSetId = auditSetId;
	}

	@JSON
	@Override
	public long getFieldClassNameId() {
		return _fieldClassNameId;
	}

	@Override
	public void setFieldClassNameId(long fieldClassNameId) {
		_columnBitmask |= FIELDCLASSNAMEID_COLUMN_BITMASK;

		if (!_setOriginalFieldClassNameId) {
			_setOriginalFieldClassNameId = true;

			_originalFieldClassNameId = _fieldClassNameId;
		}

		_fieldClassNameId = fieldClassNameId;
	}

	public long getOriginalFieldClassNameId() {
		return _originalFieldClassNameId;
	}

	@JSON
	@Override
	public long getFieldClassPK() {
		return _fieldClassPK;
	}

	@Override
	public void setFieldClassPK(long fieldClassPK) {
		_columnBitmask |= FIELDCLASSPK_COLUMN_BITMASK;

		if (!_setOriginalFieldClassPK) {
			_setOriginalFieldClassPK = true;

			_originalFieldClassPK = _fieldClassPK;
		}

		_fieldClassPK = fieldClassPK;
	}

	public long getOriginalFieldClassPK() {
		return _originalFieldClassPK;
	}

	@JSON
	@Override
	public int getAction() {
		return _action;
	}

	@Override
	public void setAction(int action) {
		_columnBitmask |= ACTION_COLUMN_BITMASK;

		if (!_setOriginalAction) {
			_setOriginalAction = true;

			_originalAction = _action;
		}

		_action = action;
	}

	public int getOriginalAction() {
		return _originalAction;
	}

	@JSON
	@Override
	public String getField() {
		if (_field == null) {
			return "";
		}
		else {
			return _field;
		}
	}

	@Override
	public void setField(String field) {
		_columnBitmask |= FIELD_COLUMN_BITMASK;

		if (_originalField == null) {
			_originalField = _field;
		}

		_field = field;
	}

	public String getOriginalField() {
		return GetterUtil.getString(_originalField);
	}

	@JSON
	@Override
	public int getVisibility() {
		return _visibility;
	}

	@Override
	public void setVisibility(int visibility) {
		_columnBitmask |= VISIBILITY_COLUMN_BITMASK;

		if (!_setOriginalVisibility) {
			_setOriginalVisibility = true;

			_originalVisibility = _visibility;
		}

		_visibility = visibility;
	}

	public int getOriginalVisibility() {
		return _originalVisibility;
	}

	@JSON
	@Override
	public String getOldLabel() {
		if (_oldLabel == null) {
			return "";
		}
		else {
			return _oldLabel;
		}
	}

	@Override
	public void setOldLabel(String oldLabel) {
		_oldLabel = oldLabel;
	}

	@JSON
	@Override
	public String getOldValue() {
		if (_oldValue == null) {
			return "";
		}
		else {
			return _oldValue;
		}
	}

	@Override
	public void setOldValue(String oldValue) {
		_oldValue = oldValue;
	}

	@JSON
	@Override
	public String getNewLabel() {
		if (_newLabel == null) {
			return "";
		}
		else {
			return _newLabel;
		}
	}

	@Override
	public void setNewLabel(String newLabel) {
		_newLabel = newLabel;
	}

	@JSON
	@Override
	public String getNewValue() {
		if (_newValue == null) {
			return "";
		}
		else {
			return _newValue;
		}
	}

	@Override
	public void setNewValue(String newValue) {
		_newValue = newValue;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public boolean getI18n() {
		return _i18n;
	}

	@JSON
	@Override
	public boolean isI18n() {
		return _i18n;
	}

	@Override
	public void setI18n(boolean i18n) {
		_i18n = i18n;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, AuditEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AuditEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AuditEntry)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AuditEntryImpl auditEntryImpl = new AuditEntryImpl();

		auditEntryImpl.setAuditEntryId(getAuditEntryId());
		auditEntryImpl.setUserId(getUserId());
		auditEntryImpl.setUserName(getUserName());
		auditEntryImpl.setCreateDate(getCreateDate());
		auditEntryImpl.setClassNameId(getClassNameId());
		auditEntryImpl.setClassPK(getClassPK());
		auditEntryImpl.setAuditSetId(getAuditSetId());
		auditEntryImpl.setFieldClassNameId(getFieldClassNameId());
		auditEntryImpl.setFieldClassPK(getFieldClassPK());
		auditEntryImpl.setAction(getAction());
		auditEntryImpl.setField(getField());
		auditEntryImpl.setVisibility(getVisibility());
		auditEntryImpl.setOldLabel(getOldLabel());
		auditEntryImpl.setOldValue(getOldValue());
		auditEntryImpl.setNewLabel(getNewLabel());
		auditEntryImpl.setNewValue(getNewValue());
		auditEntryImpl.setDescription(getDescription());
		auditEntryImpl.setI18n(isI18n());

		auditEntryImpl.resetOriginalValues();

		return auditEntryImpl;
	}

	@Override
	public int compareTo(AuditEntry auditEntry) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), auditEntry.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuditEntry)) {
			return false;
		}

		AuditEntry auditEntry = (AuditEntry)obj;

		long primaryKey = auditEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		AuditEntryModelImpl auditEntryModelImpl = this;

		auditEntryModelImpl._originalCreateDate =
			auditEntryModelImpl._createDate;

		auditEntryModelImpl._originalClassNameId =
			auditEntryModelImpl._classNameId;

		auditEntryModelImpl._setOriginalClassNameId = false;

		auditEntryModelImpl._originalClassPK = auditEntryModelImpl._classPK;

		auditEntryModelImpl._setOriginalClassPK = false;

		auditEntryModelImpl._originalFieldClassNameId =
			auditEntryModelImpl._fieldClassNameId;

		auditEntryModelImpl._setOriginalFieldClassNameId = false;

		auditEntryModelImpl._originalFieldClassPK =
			auditEntryModelImpl._fieldClassPK;

		auditEntryModelImpl._setOriginalFieldClassPK = false;

		auditEntryModelImpl._originalAction = auditEntryModelImpl._action;

		auditEntryModelImpl._setOriginalAction = false;

		auditEntryModelImpl._originalField = auditEntryModelImpl._field;

		auditEntryModelImpl._originalVisibility =
			auditEntryModelImpl._visibility;

		auditEntryModelImpl._setOriginalVisibility = false;

		auditEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AuditEntry> toCacheModel() {
		AuditEntryCacheModel auditEntryCacheModel = new AuditEntryCacheModel();

		auditEntryCacheModel.auditEntryId = getAuditEntryId();

		auditEntryCacheModel.userId = getUserId();

		auditEntryCacheModel.userName = getUserName();

		String userName = auditEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			auditEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			auditEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			auditEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		auditEntryCacheModel.classNameId = getClassNameId();

		auditEntryCacheModel.classPK = getClassPK();

		auditEntryCacheModel.auditSetId = getAuditSetId();

		auditEntryCacheModel.fieldClassNameId = getFieldClassNameId();

		auditEntryCacheModel.fieldClassPK = getFieldClassPK();

		auditEntryCacheModel.action = getAction();

		auditEntryCacheModel.field = getField();

		String field = auditEntryCacheModel.field;

		if ((field != null) && (field.length() == 0)) {
			auditEntryCacheModel.field = null;
		}

		auditEntryCacheModel.visibility = getVisibility();

		auditEntryCacheModel.oldLabel = getOldLabel();

		String oldLabel = auditEntryCacheModel.oldLabel;

		if ((oldLabel != null) && (oldLabel.length() == 0)) {
			auditEntryCacheModel.oldLabel = null;
		}

		auditEntryCacheModel.oldValue = getOldValue();

		String oldValue = auditEntryCacheModel.oldValue;

		if ((oldValue != null) && (oldValue.length() == 0)) {
			auditEntryCacheModel.oldValue = null;
		}

		auditEntryCacheModel.newLabel = getNewLabel();

		String newLabel = auditEntryCacheModel.newLabel;

		if ((newLabel != null) && (newLabel.length() == 0)) {
			auditEntryCacheModel.newLabel = null;
		}

		auditEntryCacheModel.newValue = getNewValue();

		String newValue = auditEntryCacheModel.newValue;

		if ((newValue != null) && (newValue.length() == 0)) {
			auditEntryCacheModel.newValue = null;
		}

		auditEntryCacheModel.description = getDescription();

		String description = auditEntryCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			auditEntryCacheModel.description = null;
		}

		auditEntryCacheModel.i18n = isI18n();

		return auditEntryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AuditEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AuditEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AuditEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AuditEntry)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<AuditEntry, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AuditEntry, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AuditEntry, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AuditEntry)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		AuditEntry.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		AuditEntry.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _auditEntryId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _originalCreateDate;
	private long _classNameId;
	private long _originalClassNameId;
	private boolean _setOriginalClassNameId;
	private long _classPK;
	private long _originalClassPK;
	private boolean _setOriginalClassPK;
	private long _auditSetId;
	private long _fieldClassNameId;
	private long _originalFieldClassNameId;
	private boolean _setOriginalFieldClassNameId;
	private long _fieldClassPK;
	private long _originalFieldClassPK;
	private boolean _setOriginalFieldClassPK;
	private int _action;
	private int _originalAction;
	private boolean _setOriginalAction;
	private String _field;
	private String _originalField;
	private int _visibility;
	private int _originalVisibility;
	private boolean _setOriginalVisibility;
	private String _oldLabel;
	private String _oldValue;
	private String _newLabel;
	private String _newValue;
	private String _description;
	private boolean _i18n;
	private long _columnBitmask;
	private AuditEntry _escapedModel;

}