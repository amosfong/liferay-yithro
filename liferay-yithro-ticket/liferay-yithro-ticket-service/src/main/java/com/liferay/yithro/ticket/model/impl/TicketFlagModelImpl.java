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

package com.liferay.yithro.ticket.model.impl;

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
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.yithro.ticket.model.TicketFlag;
import com.liferay.yithro.ticket.model.TicketFlagModel;
import com.liferay.yithro.ticket.model.TicketFlagSoap;

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
 * The base model implementation for the TicketFlag service. Represents a row in the &quot;Yithro_TicketFlag&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketFlagModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketFlagImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFlagImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TicketFlagModelImpl
	extends BaseModelImpl<TicketFlag> implements TicketFlagModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket flag model instance should use the <code>TicketFlag</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketFlag";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketFlagId", Types.BIGINT}, {"userId", Types.BIGINT},
		{"modifiedDate", Types.TIMESTAMP}, {"ticketEntryId", Types.BIGINT},
		{"type_", Types.INTEGER}, {"flag", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketFlagId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ticketEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("flag", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketFlag (ticketFlagId LONG not null primary key,userId LONG,modifiedDate DATE null,ticketEntryId LONG,type_ INTEGER,flag INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table Yithro_TicketFlag";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketFlag.ticketFlagId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketFlag.ticketFlagId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long FLAG_COLUMN_BITMASK = 1L;

	public static final long TICKETENTRYID_COLUMN_BITMASK = 2L;

	public static final long TYPE_COLUMN_BITMASK = 4L;

	public static final long TICKETFLAGID_COLUMN_BITMASK = 8L;

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
	public static TicketFlag toModel(TicketFlagSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TicketFlag model = new TicketFlagImpl();

		model.setTicketFlagId(soapModel.getTicketFlagId());
		model.setUserId(soapModel.getUserId());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTicketEntryId(soapModel.getTicketEntryId());
		model.setType(soapModel.getType());
		model.setFlag(soapModel.getFlag());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketFlag> toModels(TicketFlagSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TicketFlag> models = new ArrayList<TicketFlag>(soapModels.length);

		for (TicketFlagSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketFlagModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketFlagId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketFlagId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketFlagId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketFlag.class;
	}

	@Override
	public String getModelClassName() {
		return TicketFlag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketFlag, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketFlag, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketFlag, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((TicketFlag)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketFlag, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketFlag, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketFlag)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketFlag, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketFlag, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TicketFlag, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketFlag, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketFlag, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TicketFlag, Object>>();
		Map<String, BiConsumer<TicketFlag, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TicketFlag, ?>>();

		attributeGetterFunctions.put(
			"ticketFlagId", TicketFlag::getTicketFlagId);
		attributeSetterBiConsumers.put(
			"ticketFlagId",
			(BiConsumer<TicketFlag, Long>)TicketFlag::setTicketFlagId);
		attributeGetterFunctions.put("userId", TicketFlag::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TicketFlag, Long>)TicketFlag::setUserId);
		attributeGetterFunctions.put(
			"modifiedDate", TicketFlag::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TicketFlag, Date>)TicketFlag::setModifiedDate);
		attributeGetterFunctions.put(
			"ticketEntryId", TicketFlag::getTicketEntryId);
		attributeSetterBiConsumers.put(
			"ticketEntryId",
			(BiConsumer<TicketFlag, Long>)TicketFlag::setTicketEntryId);
		attributeGetterFunctions.put("type", TicketFlag::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<TicketFlag, Integer>)TicketFlag::setType);
		attributeGetterFunctions.put("flag", TicketFlag::getFlag);
		attributeSetterBiConsumers.put(
			"flag", (BiConsumer<TicketFlag, Integer>)TicketFlag::setFlag);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketFlagId() {
		return _ticketFlagId;
	}

	@Override
	public void setTicketFlagId(long ticketFlagId) {
		_ticketFlagId = ticketFlagId;
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
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getTicketEntryId() {
		return _ticketEntryId;
	}

	@Override
	public void setTicketEntryId(long ticketEntryId) {
		_columnBitmask |= TICKETENTRYID_COLUMN_BITMASK;

		if (!_setOriginalTicketEntryId) {
			_setOriginalTicketEntryId = true;

			_originalTicketEntryId = _ticketEntryId;
		}

		_ticketEntryId = ticketEntryId;
	}

	public long getOriginalTicketEntryId() {
		return _originalTicketEntryId;
	}

	@JSON
	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (!_setOriginalType) {
			_setOriginalType = true;

			_originalType = _type;
		}

		_type = type;
	}

	public int getOriginalType() {
		return _originalType;
	}

	@JSON
	@Override
	public int getFlag() {
		return _flag;
	}

	@Override
	public void setFlag(int flag) {
		_columnBitmask |= FLAG_COLUMN_BITMASK;

		if (!_setOriginalFlag) {
			_setOriginalFlag = true;

			_originalFlag = _flag;
		}

		_flag = flag;
	}

	public int getOriginalFlag() {
		return _originalFlag;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, TicketFlag.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TicketFlag toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TicketFlag)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketFlagImpl ticketFlagImpl = new TicketFlagImpl();

		ticketFlagImpl.setTicketFlagId(getTicketFlagId());
		ticketFlagImpl.setUserId(getUserId());
		ticketFlagImpl.setModifiedDate(getModifiedDate());
		ticketFlagImpl.setTicketEntryId(getTicketEntryId());
		ticketFlagImpl.setType(getType());
		ticketFlagImpl.setFlag(getFlag());

		ticketFlagImpl.resetOriginalValues();

		return ticketFlagImpl;
	}

	@Override
	public int compareTo(TicketFlag ticketFlag) {
		long primaryKey = ticketFlag.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TicketFlag)) {
			return false;
		}

		TicketFlag ticketFlag = (TicketFlag)obj;

		long primaryKey = ticketFlag.getPrimaryKey();

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
		TicketFlagModelImpl ticketFlagModelImpl = this;

		ticketFlagModelImpl._originalTicketEntryId =
			ticketFlagModelImpl._ticketEntryId;

		ticketFlagModelImpl._setOriginalTicketEntryId = false;

		ticketFlagModelImpl._originalType = ticketFlagModelImpl._type;

		ticketFlagModelImpl._setOriginalType = false;

		ticketFlagModelImpl._originalFlag = ticketFlagModelImpl._flag;

		ticketFlagModelImpl._setOriginalFlag = false;

		ticketFlagModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TicketFlag> toCacheModel() {
		TicketFlagCacheModel ticketFlagCacheModel = new TicketFlagCacheModel();

		ticketFlagCacheModel.ticketFlagId = getTicketFlagId();

		ticketFlagCacheModel.userId = getUserId();

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ticketFlagCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ticketFlagCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ticketFlagCacheModel.ticketEntryId = getTicketEntryId();

		ticketFlagCacheModel.type = getType();

		ticketFlagCacheModel.flag = getFlag();

		return ticketFlagCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketFlag, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketFlag, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketFlag, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TicketFlag)this));
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
		Map<String, Function<TicketFlag, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketFlag, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketFlag, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TicketFlag)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		TicketFlag.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		TicketFlag.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketFlagId;
	private long _userId;
	private Date _modifiedDate;
	private long _ticketEntryId;
	private long _originalTicketEntryId;
	private boolean _setOriginalTicketEntryId;
	private int _type;
	private int _originalType;
	private boolean _setOriginalType;
	private int _flag;
	private int _originalFlag;
	private boolean _setOriginalFlag;
	private long _columnBitmask;
	private TicketFlag _escapedModel;

}