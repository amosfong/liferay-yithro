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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.yithro.support.model.SupportTeam;
import com.liferay.yithro.support.model.SupportTeamModel;
import com.liferay.yithro.support.model.SupportTeamSoap;

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
 * The base model implementation for the SupportTeam service. Represents a row in the &quot;Yithro_SupportTeam&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>SupportTeamModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SupportTeamImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportTeamImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class SupportTeamModelImpl
	extends BaseModelImpl<SupportTeam> implements SupportTeamModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a support team model instance should use the <code>SupportTeam</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_SupportTeam";

	public static final Object[][] TABLE_COLUMNS = {
		{"supportTeamId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"parentSupportTeamId", Types.BIGINT}, {"supportLaborId", Types.BIGINT},
		{"name", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"assignedWork", Types.DOUBLE}, {"maxWork", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("supportTeamId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("parentSupportTeamId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("supportLaborId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("assignedWork", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("maxWork", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_SupportTeam (supportTeamId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,parentSupportTeamId LONG,supportLaborId LONG,name VARCHAR(75) null,description STRING null,assignedWork DOUBLE,maxWork DOUBLE)";

	public static final String TABLE_SQL_DROP = "drop table Yithro_SupportTeam";

	public static final String ORDER_BY_JPQL = " ORDER BY supportTeam.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_SupportTeam.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long NAME_COLUMN_BITMASK = 1L;

	public static final long PARENTSUPPORTTEAMID_COLUMN_BITMASK = 2L;

	public static final long SUPPORTLABORID_COLUMN_BITMASK = 4L;

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
	public static SupportTeam toModel(SupportTeamSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SupportTeam model = new SupportTeamImpl();

		model.setSupportTeamId(soapModel.getSupportTeamId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setParentSupportTeamId(soapModel.getParentSupportTeamId());
		model.setSupportLaborId(soapModel.getSupportLaborId());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setAssignedWork(soapModel.getAssignedWork());
		model.setMaxWork(soapModel.getMaxWork());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SupportTeam> toModels(SupportTeamSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SupportTeam> models = new ArrayList<SupportTeam>(
			soapModels.length);

		for (SupportTeamSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public SupportTeamModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _supportTeamId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSupportTeamId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _supportTeamId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SupportTeam.class;
	}

	@Override
	public String getModelClassName() {
		return SupportTeam.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<SupportTeam, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<SupportTeam, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SupportTeam, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((SupportTeam)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<SupportTeam, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<SupportTeam, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(SupportTeam)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<SupportTeam, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<SupportTeam, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static final Map<String, Function<SupportTeam, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<SupportTeam, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<SupportTeam, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<SupportTeam, Object>>();
		Map<String, BiConsumer<SupportTeam, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<SupportTeam, ?>>();

		attributeGetterFunctions.put(
			"supportTeamId", SupportTeam::getSupportTeamId);
		attributeSetterBiConsumers.put(
			"supportTeamId",
			(BiConsumer<SupportTeam, Long>)SupportTeam::setSupportTeamId);
		attributeGetterFunctions.put("companyId", SupportTeam::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<SupportTeam, Long>)SupportTeam::setCompanyId);
		attributeGetterFunctions.put("userId", SupportTeam::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<SupportTeam, Long>)SupportTeam::setUserId);
		attributeGetterFunctions.put("userName", SupportTeam::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<SupportTeam, String>)SupportTeam::setUserName);
		attributeGetterFunctions.put("createDate", SupportTeam::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<SupportTeam, Date>)SupportTeam::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", SupportTeam::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<SupportTeam, Date>)SupportTeam::setModifiedDate);
		attributeGetterFunctions.put(
			"parentSupportTeamId", SupportTeam::getParentSupportTeamId);
		attributeSetterBiConsumers.put(
			"parentSupportTeamId",
			(BiConsumer<SupportTeam, Long>)SupportTeam::setParentSupportTeamId);
		attributeGetterFunctions.put(
			"supportLaborId", SupportTeam::getSupportLaborId);
		attributeSetterBiConsumers.put(
			"supportLaborId",
			(BiConsumer<SupportTeam, Long>)SupportTeam::setSupportLaborId);
		attributeGetterFunctions.put("name", SupportTeam::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<SupportTeam, String>)SupportTeam::setName);
		attributeGetterFunctions.put(
			"description", SupportTeam::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<SupportTeam, String>)SupportTeam::setDescription);
		attributeGetterFunctions.put(
			"assignedWork", SupportTeam::getAssignedWork);
		attributeSetterBiConsumers.put(
			"assignedWork",
			(BiConsumer<SupportTeam, Double>)SupportTeam::setAssignedWork);
		attributeGetterFunctions.put("maxWork", SupportTeam::getMaxWork);
		attributeSetterBiConsumers.put(
			"maxWork",
			(BiConsumer<SupportTeam, Double>)SupportTeam::setMaxWork);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getSupportTeamId() {
		return _supportTeamId;
	}

	@Override
	public void setSupportTeamId(long supportTeamId) {
		_supportTeamId = supportTeamId;
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
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public long getParentSupportTeamId() {
		return _parentSupportTeamId;
	}

	@Override
	public void setParentSupportTeamId(long parentSupportTeamId) {
		_columnBitmask |= PARENTSUPPORTTEAMID_COLUMN_BITMASK;

		if (!_setOriginalParentSupportTeamId) {
			_setOriginalParentSupportTeamId = true;

			_originalParentSupportTeamId = _parentSupportTeamId;
		}

		_parentSupportTeamId = parentSupportTeamId;
	}

	public long getOriginalParentSupportTeamId() {
		return _originalParentSupportTeamId;
	}

	@JSON
	@Override
	public long getSupportLaborId() {
		return _supportLaborId;
	}

	@Override
	public void setSupportLaborId(long supportLaborId) {
		_columnBitmask |= SUPPORTLABORID_COLUMN_BITMASK;

		if (!_setOriginalSupportLaborId) {
			_setOriginalSupportLaborId = true;

			_originalSupportLaborId = _supportLaborId;
		}

		_supportLaborId = supportLaborId;
	}

	public long getOriginalSupportLaborId() {
		return _originalSupportLaborId;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
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
	public double getAssignedWork() {
		return _assignedWork;
	}

	@Override
	public void setAssignedWork(double assignedWork) {
		_assignedWork = assignedWork;
	}

	@JSON
	@Override
	public double getMaxWork() {
		return _maxWork;
	}

	@Override
	public void setMaxWork(double maxWork) {
		_maxWork = maxWork;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), SupportTeam.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SupportTeam toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SupportTeam)ProxyUtil.newProxyInstance(
				_classLoader, _escapedModelInterfaces,
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SupportTeamImpl supportTeamImpl = new SupportTeamImpl();

		supportTeamImpl.setSupportTeamId(getSupportTeamId());
		supportTeamImpl.setCompanyId(getCompanyId());
		supportTeamImpl.setUserId(getUserId());
		supportTeamImpl.setUserName(getUserName());
		supportTeamImpl.setCreateDate(getCreateDate());
		supportTeamImpl.setModifiedDate(getModifiedDate());
		supportTeamImpl.setParentSupportTeamId(getParentSupportTeamId());
		supportTeamImpl.setSupportLaborId(getSupportLaborId());
		supportTeamImpl.setName(getName());
		supportTeamImpl.setDescription(getDescription());
		supportTeamImpl.setAssignedWork(getAssignedWork());
		supportTeamImpl.setMaxWork(getMaxWork());

		supportTeamImpl.resetOriginalValues();

		return supportTeamImpl;
	}

	@Override
	public int compareTo(SupportTeam supportTeam) {
		int value = 0;

		value = getName().compareToIgnoreCase(supportTeam.getName());

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

		if (!(obj instanceof SupportTeam)) {
			return false;
		}

		SupportTeam supportTeam = (SupportTeam)obj;

		long primaryKey = supportTeam.getPrimaryKey();

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
		SupportTeamModelImpl supportTeamModelImpl = this;

		supportTeamModelImpl._setModifiedDate = false;

		supportTeamModelImpl._originalParentSupportTeamId =
			supportTeamModelImpl._parentSupportTeamId;

		supportTeamModelImpl._setOriginalParentSupportTeamId = false;

		supportTeamModelImpl._originalSupportLaborId =
			supportTeamModelImpl._supportLaborId;

		supportTeamModelImpl._setOriginalSupportLaborId = false;

		supportTeamModelImpl._originalName = supportTeamModelImpl._name;

		supportTeamModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SupportTeam> toCacheModel() {
		SupportTeamCacheModel supportTeamCacheModel =
			new SupportTeamCacheModel();

		supportTeamCacheModel.supportTeamId = getSupportTeamId();

		supportTeamCacheModel.companyId = getCompanyId();

		supportTeamCacheModel.userId = getUserId();

		supportTeamCacheModel.userName = getUserName();

		String userName = supportTeamCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			supportTeamCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			supportTeamCacheModel.createDate = createDate.getTime();
		}
		else {
			supportTeamCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			supportTeamCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			supportTeamCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		supportTeamCacheModel.parentSupportTeamId = getParentSupportTeamId();

		supportTeamCacheModel.supportLaborId = getSupportLaborId();

		supportTeamCacheModel.name = getName();

		String name = supportTeamCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			supportTeamCacheModel.name = null;
		}

		supportTeamCacheModel.description = getDescription();

		String description = supportTeamCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			supportTeamCacheModel.description = null;
		}

		supportTeamCacheModel.assignedWork = getAssignedWork();

		supportTeamCacheModel.maxWork = getMaxWork();

		return supportTeamCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<SupportTeam, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<SupportTeam, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SupportTeam, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((SupportTeam)this));
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
		Map<String, Function<SupportTeam, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<SupportTeam, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<SupportTeam, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((SupportTeam)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader =
		SupportTeam.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
		SupportTeam.class, ModelWrapper.class
	};
	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _supportTeamId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _parentSupportTeamId;
	private long _originalParentSupportTeamId;
	private boolean _setOriginalParentSupportTeamId;
	private long _supportLaborId;
	private long _originalSupportLaborId;
	private boolean _setOriginalSupportLaborId;
	private String _name;
	private String _originalName;
	private String _description;
	private double _assignedWork;
	private double _maxWork;
	private long _columnBitmask;
	private SupportTeam _escapedModel;

}