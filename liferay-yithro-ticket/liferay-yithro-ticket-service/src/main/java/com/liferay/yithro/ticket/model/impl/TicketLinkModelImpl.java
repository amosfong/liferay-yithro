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
import com.liferay.yithro.ticket.model.TicketLink;
import com.liferay.yithro.ticket.model.TicketLinkModel;
import com.liferay.yithro.ticket.model.TicketLinkSoap;

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
 * The base model implementation for the TicketLink service. Represents a row in the &quot;Yithro_TicketLink&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketLinkModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketLinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketLinkImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TicketLinkModelImpl
	extends BaseModelImpl<TicketLink> implements TicketLinkModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket link model instance should use the <code>TicketLink</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketLink";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketLinkId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"ticketEntryId", Types.BIGINT},
		{"ticketSolutionId", Types.BIGINT}, {"url", Types.VARCHAR},
		{"type_", Types.INTEGER}, {"visibility", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketLinkId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ticketEntryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ticketSolutionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("url", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("visibility", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketLink (ticketLinkId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,ticketEntryId LONG,ticketSolutionId LONG,url STRING null,type_ INTEGER,visibility INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table Yithro_TicketLink";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketLink.ticketLinkId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketLink.ticketLinkId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long TICKETENTRYID_COLUMN_BITMASK = 1L;

	public static final long TICKETSOLUTIONID_COLUMN_BITMASK = 2L;

	public static final long VISIBILITY_COLUMN_BITMASK = 4L;

	public static final long TICKETLINKID_COLUMN_BITMASK = 8L;

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
	public static TicketLink toModel(TicketLinkSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TicketLink model = new TicketLinkImpl();

		model.setTicketLinkId(soapModel.getTicketLinkId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setTicketEntryId(soapModel.getTicketEntryId());
		model.setTicketSolutionId(soapModel.getTicketSolutionId());
		model.setUrl(soapModel.getUrl());
		model.setType(soapModel.getType());
		model.setVisibility(soapModel.getVisibility());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketLink> toModels(TicketLinkSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TicketLink> models = new ArrayList<TicketLink>(soapModels.length);

		for (TicketLinkSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketLinkModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketLinkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketLinkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketLinkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketLink.class;
	}

	@Override
	public String getModelClassName() {
		return TicketLink.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketLink, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((TicketLink)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketLink, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketLink, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketLink)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketLink, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketLink, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<TicketLink, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketLink, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketLink, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TicketLink, Object>>();
		Map<String, BiConsumer<TicketLink, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TicketLink, ?>>();

		attributeGetterFunctions.put(
			"ticketLinkId", TicketLink::getTicketLinkId);
		attributeSetterBiConsumers.put(
			"ticketLinkId",
			(BiConsumer<TicketLink, Long>)TicketLink::setTicketLinkId);
		attributeGetterFunctions.put("companyId", TicketLink::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TicketLink, Long>)TicketLink::setCompanyId);
		attributeGetterFunctions.put("userId", TicketLink::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TicketLink, Long>)TicketLink::setUserId);
		attributeGetterFunctions.put("userName", TicketLink::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TicketLink, String>)TicketLink::setUserName);
		attributeGetterFunctions.put("createDate", TicketLink::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TicketLink, Date>)TicketLink::setCreateDate);
		attributeGetterFunctions.put(
			"ticketEntryId", TicketLink::getTicketEntryId);
		attributeSetterBiConsumers.put(
			"ticketEntryId",
			(BiConsumer<TicketLink, Long>)TicketLink::setTicketEntryId);
		attributeGetterFunctions.put(
			"ticketSolutionId", TicketLink::getTicketSolutionId);
		attributeSetterBiConsumers.put(
			"ticketSolutionId",
			(BiConsumer<TicketLink, Long>)TicketLink::setTicketSolutionId);
		attributeGetterFunctions.put("url", TicketLink::getUrl);
		attributeSetterBiConsumers.put(
			"url", (BiConsumer<TicketLink, String>)TicketLink::setUrl);
		attributeGetterFunctions.put("type", TicketLink::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<TicketLink, Integer>)TicketLink::setType);
		attributeGetterFunctions.put("visibility", TicketLink::getVisibility);
		attributeSetterBiConsumers.put(
			"visibility",
			(BiConsumer<TicketLink, Integer>)TicketLink::setVisibility);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketLinkId() {
		return _ticketLinkId;
	}

	@Override
	public void setTicketLinkId(long ticketLinkId) {
		_ticketLinkId = ticketLinkId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
		_createDate = createDate;
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
	public long getTicketSolutionId() {
		return _ticketSolutionId;
	}

	@Override
	public void setTicketSolutionId(long ticketSolutionId) {
		_columnBitmask |= TICKETSOLUTIONID_COLUMN_BITMASK;

		if (!_setOriginalTicketSolutionId) {
			_setOriginalTicketSolutionId = true;

			_originalTicketSolutionId = _ticketSolutionId;
		}

		_ticketSolutionId = ticketSolutionId;
	}

	public long getOriginalTicketSolutionId() {
		return _originalTicketSolutionId;
	}

	@JSON
	@Override
	public String getUrl() {
		if (_url == null) {
			return "";
		}
		else {
			return _url;
		}
	}

	@Override
	public void setUrl(String url) {
		_url = url;
	}

	@JSON
	@Override
	public int getType() {
		return _type;
	}

	@Override
	public void setType(int type) {
		_type = type;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TicketLink.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TicketLink toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (TicketLink)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketLinkImpl ticketLinkImpl = new TicketLinkImpl();

		ticketLinkImpl.setTicketLinkId(getTicketLinkId());
		ticketLinkImpl.setCompanyId(getCompanyId());
		ticketLinkImpl.setUserId(getUserId());
		ticketLinkImpl.setUserName(getUserName());
		ticketLinkImpl.setCreateDate(getCreateDate());
		ticketLinkImpl.setTicketEntryId(getTicketEntryId());
		ticketLinkImpl.setTicketSolutionId(getTicketSolutionId());
		ticketLinkImpl.setUrl(getUrl());
		ticketLinkImpl.setType(getType());
		ticketLinkImpl.setVisibility(getVisibility());

		ticketLinkImpl.resetOriginalValues();

		return ticketLinkImpl;
	}

	@Override
	public int compareTo(TicketLink ticketLink) {
		long primaryKey = ticketLink.getPrimaryKey();

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

		if (!(obj instanceof TicketLink)) {
			return false;
		}

		TicketLink ticketLink = (TicketLink)obj;

		long primaryKey = ticketLink.getPrimaryKey();

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
		TicketLinkModelImpl ticketLinkModelImpl = this;

		ticketLinkModelImpl._originalTicketEntryId =
			ticketLinkModelImpl._ticketEntryId;

		ticketLinkModelImpl._setOriginalTicketEntryId = false;

		ticketLinkModelImpl._originalTicketSolutionId =
			ticketLinkModelImpl._ticketSolutionId;

		ticketLinkModelImpl._setOriginalTicketSolutionId = false;

		ticketLinkModelImpl._originalVisibility =
			ticketLinkModelImpl._visibility;

		ticketLinkModelImpl._setOriginalVisibility = false;

		ticketLinkModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TicketLink> toCacheModel() {
		TicketLinkCacheModel ticketLinkCacheModel = new TicketLinkCacheModel();

		ticketLinkCacheModel.ticketLinkId = getTicketLinkId();

		ticketLinkCacheModel.companyId = getCompanyId();

		ticketLinkCacheModel.userId = getUserId();

		ticketLinkCacheModel.userName = getUserName();

		String userName = ticketLinkCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			ticketLinkCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			ticketLinkCacheModel.createDate = createDate.getTime();
		}
		else {
			ticketLinkCacheModel.createDate = Long.MIN_VALUE;
		}

		ticketLinkCacheModel.ticketEntryId = getTicketEntryId();

		ticketLinkCacheModel.ticketSolutionId = getTicketSolutionId();

		ticketLinkCacheModel.url = getUrl();

		String url = ticketLinkCacheModel.url;

		if ((url != null) && (url.length() == 0)) {
			ticketLinkCacheModel.url = null;
		}

		ticketLinkCacheModel.type = getType();

		ticketLinkCacheModel.visibility = getVisibility();

		return ticketLinkCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TicketLink)this));
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
		Map<String, Function<TicketLink, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketLink, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketLink, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TicketLink)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		TicketLink.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		TicketLink.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketLinkId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private long _ticketEntryId;
	private long _originalTicketEntryId;
	private boolean _setOriginalTicketEntryId;
	private long _ticketSolutionId;
	private long _originalTicketSolutionId;
	private boolean _setOriginalTicketSolutionId;
	private String _url;
	private int _type;
	private int _visibility;
	private int _originalVisibility;
	private boolean _setOriginalVisibility;
	private long _columnBitmask;
	private TicketLink _escapedModel;

}