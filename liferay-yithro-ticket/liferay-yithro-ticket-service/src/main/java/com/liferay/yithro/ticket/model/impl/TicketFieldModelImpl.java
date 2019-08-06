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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.model.TicketFieldModel;
import com.liferay.yithro.ticket.model.TicketFieldSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model implementation for the TicketField service. Represents a row in the &quot;Yithro_TicketField&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketFieldModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketFieldImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TicketFieldModelImpl
	extends BaseModelImpl<TicketField> implements TicketFieldModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket field model instance should use the <code>TicketField</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketField";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketFieldId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"name", Types.VARCHAR},
		{"description", Types.VARCHAR}, {"type_", Types.INTEGER},
		{"visibility", Types.INTEGER}, {"systemKey", Types.VARCHAR},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketFieldId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("type_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("visibility", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("systemKey", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketField (ticketFieldId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,name STRING null,description STRING null,type_ INTEGER,visibility INTEGER,systemKey VARCHAR(75) null,status INTEGER)";

	public static final String TABLE_SQL_DROP = "drop table Yithro_TicketField";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketField.ticketFieldId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketField.ticketFieldId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long STATUS_COLUMN_BITMASK = 1L;

	public static final long SYSTEMKEY_COLUMN_BITMASK = 2L;

	public static final long TICKETFIELDID_COLUMN_BITMASK = 4L;

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
	public static TicketField toModel(TicketFieldSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TicketField model = new TicketFieldImpl();

		model.setTicketFieldId(soapModel.getTicketFieldId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDescription(soapModel.getDescription());
		model.setType(soapModel.getType());
		model.setVisibility(soapModel.getVisibility());
		model.setSystemKey(soapModel.getSystemKey());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketField> toModels(TicketFieldSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TicketField> models = new ArrayList<TicketField>(
			soapModels.length);

		for (TicketFieldSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketFieldModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketFieldId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketFieldId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketFieldId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketField.class;
	}

	@Override
	public String getModelClassName() {
		return TicketField.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketField, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketField, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketField, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TicketField)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketField, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketField, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketField)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketField, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketField, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TicketField>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TicketField.class.getClassLoader(), TicketField.class,
			ModelWrapper.class);

		try {
			Constructor<TicketField> constructor =
				(Constructor<TicketField>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<TicketField, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketField, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketField, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TicketField, Object>>();
		Map<String, BiConsumer<TicketField, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TicketField, ?>>();

		attributeGetterFunctions.put(
			"ticketFieldId", TicketField::getTicketFieldId);
		attributeSetterBiConsumers.put(
			"ticketFieldId",
			(BiConsumer<TicketField, Long>)TicketField::setTicketFieldId);
		attributeGetterFunctions.put("companyId", TicketField::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TicketField, Long>)TicketField::setCompanyId);
		attributeGetterFunctions.put("userId", TicketField::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TicketField, Long>)TicketField::setUserId);
		attributeGetterFunctions.put("createDate", TicketField::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TicketField, Date>)TicketField::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TicketField::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TicketField, Date>)TicketField::setModifiedDate);
		attributeGetterFunctions.put("name", TicketField::getName);
		attributeSetterBiConsumers.put(
			"name", (BiConsumer<TicketField, String>)TicketField::setName);
		attributeGetterFunctions.put(
			"description", TicketField::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<TicketField, String>)TicketField::setDescription);
		attributeGetterFunctions.put("type", TicketField::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<TicketField, Integer>)TicketField::setType);
		attributeGetterFunctions.put("visibility", TicketField::getVisibility);
		attributeSetterBiConsumers.put(
			"visibility",
			(BiConsumer<TicketField, Integer>)TicketField::setVisibility);
		attributeGetterFunctions.put("systemKey", TicketField::getSystemKey);
		attributeSetterBiConsumers.put(
			"systemKey",
			(BiConsumer<TicketField, String>)TicketField::setSystemKey);
		attributeGetterFunctions.put("status", TicketField::getStatus);
		attributeSetterBiConsumers.put(
			"status", (BiConsumer<TicketField, Integer>)TicketField::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketFieldId() {
		return _ticketFieldId;
	}

	@Override
	public void setTicketFieldId(long ticketFieldId) {
		_ticketFieldId = ticketFieldId;
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
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public String getName(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId);
	}

	@Override
	public String getName(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getName(languageId, useDefault);
	}

	@Override
	public String getName(String languageId) {
		return LocalizationUtil.getLocalization(getName(), languageId);
	}

	@Override
	public String getName(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getName(), languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return _nameCurrentLanguageId;
	}

	@JSON
	@Override
	public String getNameCurrentValue() {
		Locale locale = getLocale(_nameCurrentLanguageId);

		return getName(locale);
	}

	@Override
	public Map<Locale, String> getNameMap() {
		return LocalizationUtil.getLocalizationMap(getName());
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public void setName(String name, Locale locale) {
		setName(name, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setName(String name, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(name)) {
			setName(
				LocalizationUtil.updateLocalization(
					getName(), "Name", name, languageId, defaultLanguageId));
		}
		else {
			setName(
				LocalizationUtil.removeLocalization(
					getName(), "Name", languageId));
		}
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		_nameCurrentLanguageId = languageId;
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap) {
		setNameMap(nameMap, LocaleUtil.getDefault());
	}

	@Override
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale) {
		if (nameMap == null) {
			return;
		}

		setName(
			LocalizationUtil.updateLocalization(
				nameMap, getName(), "Name",
				LocaleUtil.toLanguageId(defaultLocale)));
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
	public String getDescription(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId);
	}

	@Override
	public String getDescription(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getDescription(languageId, useDefault);
	}

	@Override
	public String getDescription(String languageId) {
		return LocalizationUtil.getLocalization(getDescription(), languageId);
	}

	@Override
	public String getDescription(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getDescription(), languageId, useDefault);
	}

	@Override
	public String getDescriptionCurrentLanguageId() {
		return _descriptionCurrentLanguageId;
	}

	@JSON
	@Override
	public String getDescriptionCurrentValue() {
		Locale locale = getLocale(_descriptionCurrentLanguageId);

		return getDescription(locale);
	}

	@Override
	public Map<Locale, String> getDescriptionMap() {
		return LocalizationUtil.getLocalizationMap(getDescription());
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public void setDescription(String description, Locale locale) {
		setDescription(description, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setDescription(
		String description, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(description)) {
			setDescription(
				LocalizationUtil.updateLocalization(
					getDescription(), "Description", description, languageId,
					defaultLanguageId));
		}
		else {
			setDescription(
				LocalizationUtil.removeLocalization(
					getDescription(), "Description", languageId));
		}
	}

	@Override
	public void setDescriptionCurrentLanguageId(String languageId) {
		_descriptionCurrentLanguageId = languageId;
	}

	@Override
	public void setDescriptionMap(Map<Locale, String> descriptionMap) {
		setDescriptionMap(descriptionMap, LocaleUtil.getDefault());
	}

	@Override
	public void setDescriptionMap(
		Map<Locale, String> descriptionMap, Locale defaultLocale) {

		if (descriptionMap == null) {
			return;
		}

		setDescription(
			LocalizationUtil.updateLocalization(
				descriptionMap, getDescription(), "Description",
				LocaleUtil.toLanguageId(defaultLocale)));
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
		_visibility = visibility;
	}

	@JSON
	@Override
	public String getSystemKey() {
		if (_systemKey == null) {
			return "";
		}
		else {
			return _systemKey;
		}
	}

	@Override
	public void setSystemKey(String systemKey) {
		_columnBitmask |= SYSTEMKEY_COLUMN_BITMASK;

		if (_originalSystemKey == null) {
			_originalSystemKey = _systemKey;
		}

		_systemKey = systemKey;
	}

	public String getOriginalSystemKey() {
		return GetterUtil.getString(_originalSystemKey);
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TicketField.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> nameMap = getNameMap();

		for (Map.Entry<Locale, String> entry : nameMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		Map<Locale, String> descriptionMap = getDescriptionMap();

		for (Map.Entry<Locale, String> entry : descriptionMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getName();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			TicketField.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String name = getName(defaultLocale);

		if (Validator.isNull(name)) {
			setName(getName(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setName(getName(defaultLocale), defaultLocale, defaultLocale);
		}

		String description = getDescription(defaultLocale);

		if (Validator.isNull(description)) {
			setDescription(
				getDescription(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setDescription(
				getDescription(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public TicketField toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TicketField>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TicketFieldImpl ticketFieldImpl = new TicketFieldImpl();

		ticketFieldImpl.setTicketFieldId(getTicketFieldId());
		ticketFieldImpl.setCompanyId(getCompanyId());
		ticketFieldImpl.setUserId(getUserId());
		ticketFieldImpl.setCreateDate(getCreateDate());
		ticketFieldImpl.setModifiedDate(getModifiedDate());
		ticketFieldImpl.setName(getName());
		ticketFieldImpl.setDescription(getDescription());
		ticketFieldImpl.setType(getType());
		ticketFieldImpl.setVisibility(getVisibility());
		ticketFieldImpl.setSystemKey(getSystemKey());
		ticketFieldImpl.setStatus(getStatus());

		ticketFieldImpl.resetOriginalValues();

		return ticketFieldImpl;
	}

	@Override
	public int compareTo(TicketField ticketField) {
		long primaryKey = ticketField.getPrimaryKey();

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

		if (!(obj instanceof TicketField)) {
			return false;
		}

		TicketField ticketField = (TicketField)obj;

		long primaryKey = ticketField.getPrimaryKey();

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
		TicketFieldModelImpl ticketFieldModelImpl = this;

		ticketFieldModelImpl._setModifiedDate = false;

		ticketFieldModelImpl._originalSystemKey =
			ticketFieldModelImpl._systemKey;

		ticketFieldModelImpl._originalStatus = ticketFieldModelImpl._status;

		ticketFieldModelImpl._setOriginalStatus = false;

		ticketFieldModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TicketField> toCacheModel() {
		TicketFieldCacheModel ticketFieldCacheModel =
			new TicketFieldCacheModel();

		ticketFieldCacheModel.ticketFieldId = getTicketFieldId();

		ticketFieldCacheModel.companyId = getCompanyId();

		ticketFieldCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			ticketFieldCacheModel.createDate = createDate.getTime();
		}
		else {
			ticketFieldCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ticketFieldCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ticketFieldCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ticketFieldCacheModel.name = getName();

		String name = ticketFieldCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			ticketFieldCacheModel.name = null;
		}

		ticketFieldCacheModel.description = getDescription();

		String description = ticketFieldCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			ticketFieldCacheModel.description = null;
		}

		ticketFieldCacheModel.type = getType();

		ticketFieldCacheModel.visibility = getVisibility();

		ticketFieldCacheModel.systemKey = getSystemKey();

		String systemKey = ticketFieldCacheModel.systemKey;

		if ((systemKey != null) && (systemKey.length() == 0)) {
			ticketFieldCacheModel.systemKey = null;
		}

		ticketFieldCacheModel.status = getStatus();

		return ticketFieldCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketField, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketField, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketField, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TicketField)this));
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
		Map<String, Function<TicketField, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketField, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketField, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TicketField)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TicketField>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketFieldId;
	private long _companyId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private String _nameCurrentLanguageId;
	private String _description;
	private String _descriptionCurrentLanguageId;
	private int _type;
	private int _visibility;
	private String _systemKey;
	private String _originalSystemKey;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _columnBitmask;
	private TicketField _escapedModel;

}