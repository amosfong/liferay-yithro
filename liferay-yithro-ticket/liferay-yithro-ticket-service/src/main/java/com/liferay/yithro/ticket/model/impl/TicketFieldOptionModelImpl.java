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
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.ticket.model.TicketFieldOption;
import com.liferay.yithro.ticket.model.TicketFieldOptionModel;
import com.liferay.yithro.ticket.model.TicketFieldOptionSoap;

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
 * The base model implementation for the TicketFieldOption service. Represents a row in the &quot;Yithro_TicketFieldOption&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>TicketFieldOptionModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TicketFieldOptionImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldOptionImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class TicketFieldOptionModelImpl
	extends BaseModelImpl<TicketFieldOption> implements TicketFieldOptionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a ticket field option model instance should use the <code>TicketFieldOption</code> interface instead.
	 */
	public static final String TABLE_NAME = "Yithro_TicketFieldOption";

	public static final Object[][] TABLE_COLUMNS = {
		{"ticketFieldOptionId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"ticketFieldId", Types.BIGINT}, {"name", Types.VARCHAR},
		{"visibility", Types.INTEGER}, {"order_", Types.INTEGER},
		{"status", Types.INTEGER}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("ticketFieldOptionId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("ticketFieldId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("visibility", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("order_", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("status", Types.INTEGER);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Yithro_TicketFieldOption (ticketFieldOptionId LONG not null primary key,companyId LONG,createDate DATE null,modifiedDate DATE null,ticketFieldId LONG,name STRING null,visibility INTEGER,order_ INTEGER,status INTEGER)";

	public static final String TABLE_SQL_DROP =
		"drop table Yithro_TicketFieldOption";

	public static final String ORDER_BY_JPQL =
		" ORDER BY ticketFieldOption.order ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Yithro_TicketFieldOption.order_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long TICKETFIELDID_COLUMN_BITMASK = 1L;

	public static final long ORDER_COLUMN_BITMASK = 2L;

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
	public static TicketFieldOption toModel(TicketFieldOptionSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TicketFieldOption model = new TicketFieldOptionImpl();

		model.setTicketFieldOptionId(soapModel.getTicketFieldOptionId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setTicketFieldId(soapModel.getTicketFieldId());
		model.setName(soapModel.getName());
		model.setVisibility(soapModel.getVisibility());
		model.setOrder(soapModel.getOrder());
		model.setStatus(soapModel.getStatus());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<TicketFieldOption> toModels(
		TicketFieldOptionSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<TicketFieldOption> models = new ArrayList<TicketFieldOption>(
			soapModels.length);

		for (TicketFieldOptionSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TicketFieldOptionModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _ticketFieldOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTicketFieldOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _ticketFieldOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TicketFieldOption.class;
	}

	@Override
	public String getModelClassName() {
		return TicketFieldOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TicketFieldOption, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TicketFieldOption, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketFieldOption, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TicketFieldOption)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TicketFieldOption, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TicketFieldOption, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TicketFieldOption)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TicketFieldOption, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TicketFieldOption, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TicketFieldOption>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TicketFieldOption.class.getClassLoader(), TicketFieldOption.class,
			ModelWrapper.class);

		try {
			Constructor<TicketFieldOption> constructor =
				(Constructor<TicketFieldOption>)proxyClass.getConstructor(
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

	private static final Map<String, Function<TicketFieldOption, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TicketFieldOption, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TicketFieldOption, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<TicketFieldOption, Object>>();
		Map<String, BiConsumer<TicketFieldOption, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<TicketFieldOption, ?>>();

		attributeGetterFunctions.put(
			"ticketFieldOptionId", TicketFieldOption::getTicketFieldOptionId);
		attributeSetterBiConsumers.put(
			"ticketFieldOptionId",
			(BiConsumer<TicketFieldOption, Long>)
				TicketFieldOption::setTicketFieldOptionId);
		attributeGetterFunctions.put(
			"companyId", TicketFieldOption::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TicketFieldOption, Long>)
				TicketFieldOption::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", TicketFieldOption::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TicketFieldOption, Date>)
				TicketFieldOption::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TicketFieldOption::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TicketFieldOption, Date>)
				TicketFieldOption::setModifiedDate);
		attributeGetterFunctions.put(
			"ticketFieldId", TicketFieldOption::getTicketFieldId);
		attributeSetterBiConsumers.put(
			"ticketFieldId",
			(BiConsumer<TicketFieldOption, Long>)
				TicketFieldOption::setTicketFieldId);
		attributeGetterFunctions.put("name", TicketFieldOption::getName);
		attributeSetterBiConsumers.put(
			"name",
			(BiConsumer<TicketFieldOption, String>)TicketFieldOption::setName);
		attributeGetterFunctions.put(
			"visibility", TicketFieldOption::getVisibility);
		attributeSetterBiConsumers.put(
			"visibility",
			(BiConsumer<TicketFieldOption, Integer>)
				TicketFieldOption::setVisibility);
		attributeGetterFunctions.put("order", TicketFieldOption::getOrder);
		attributeSetterBiConsumers.put(
			"order",
			(BiConsumer<TicketFieldOption, Integer>)
				TicketFieldOption::setOrder);
		attributeGetterFunctions.put("status", TicketFieldOption::getStatus);
		attributeSetterBiConsumers.put(
			"status",
			(BiConsumer<TicketFieldOption, Integer>)
				TicketFieldOption::setStatus);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getTicketFieldOptionId() {
		return _ticketFieldOptionId;
	}

	@Override
	public void setTicketFieldOptionId(long ticketFieldOptionId) {
		_ticketFieldOptionId = ticketFieldOptionId;
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
	public long getTicketFieldId() {
		return _ticketFieldId;
	}

	@Override
	public void setTicketFieldId(long ticketFieldId) {
		_columnBitmask |= TICKETFIELDID_COLUMN_BITMASK;

		if (!_setOriginalTicketFieldId) {
			_setOriginalTicketFieldId = true;

			_originalTicketFieldId = _ticketFieldId;
		}

		_ticketFieldId = ticketFieldId;
	}

	public long getOriginalTicketFieldId() {
		return _originalTicketFieldId;
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
	public int getVisibility() {
		return _visibility;
	}

	@Override
	public void setVisibility(int visibility) {
		_visibility = visibility;
	}

	@JSON
	@Override
	public int getOrder() {
		return _order;
	}

	@Override
	public void setOrder(int order) {
		_columnBitmask = -1L;

		_order = order;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TicketFieldOption.class.getName(), getPrimaryKey());
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
			TicketFieldOption.class.getName(), getPrimaryKey(), defaultLocale,
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
	}

	@Override
	public TicketFieldOption toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TicketFieldOption>
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
		TicketFieldOptionImpl ticketFieldOptionImpl =
			new TicketFieldOptionImpl();

		ticketFieldOptionImpl.setTicketFieldOptionId(getTicketFieldOptionId());
		ticketFieldOptionImpl.setCompanyId(getCompanyId());
		ticketFieldOptionImpl.setCreateDate(getCreateDate());
		ticketFieldOptionImpl.setModifiedDate(getModifiedDate());
		ticketFieldOptionImpl.setTicketFieldId(getTicketFieldId());
		ticketFieldOptionImpl.setName(getName());
		ticketFieldOptionImpl.setVisibility(getVisibility());
		ticketFieldOptionImpl.setOrder(getOrder());
		ticketFieldOptionImpl.setStatus(getStatus());

		ticketFieldOptionImpl.resetOriginalValues();

		return ticketFieldOptionImpl;
	}

	@Override
	public int compareTo(TicketFieldOption ticketFieldOption) {
		int value = 0;

		if (getOrder() < ticketFieldOption.getOrder()) {
			value = -1;
		}
		else if (getOrder() > ticketFieldOption.getOrder()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof TicketFieldOption)) {
			return false;
		}

		TicketFieldOption ticketFieldOption = (TicketFieldOption)obj;

		long primaryKey = ticketFieldOption.getPrimaryKey();

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
		TicketFieldOptionModelImpl ticketFieldOptionModelImpl = this;

		ticketFieldOptionModelImpl._setModifiedDate = false;

		ticketFieldOptionModelImpl._originalTicketFieldId =
			ticketFieldOptionModelImpl._ticketFieldId;

		ticketFieldOptionModelImpl._setOriginalTicketFieldId = false;

		ticketFieldOptionModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TicketFieldOption> toCacheModel() {
		TicketFieldOptionCacheModel ticketFieldOptionCacheModel =
			new TicketFieldOptionCacheModel();

		ticketFieldOptionCacheModel.ticketFieldOptionId =
			getTicketFieldOptionId();

		ticketFieldOptionCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			ticketFieldOptionCacheModel.createDate = createDate.getTime();
		}
		else {
			ticketFieldOptionCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			ticketFieldOptionCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			ticketFieldOptionCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		ticketFieldOptionCacheModel.ticketFieldId = getTicketFieldId();

		ticketFieldOptionCacheModel.name = getName();

		String name = ticketFieldOptionCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			ticketFieldOptionCacheModel.name = null;
		}

		ticketFieldOptionCacheModel.visibility = getVisibility();

		ticketFieldOptionCacheModel.order = getOrder();

		ticketFieldOptionCacheModel.status = getStatus();

		return ticketFieldOptionCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TicketFieldOption, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TicketFieldOption, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketFieldOption, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TicketFieldOption)this));
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
		Map<String, Function<TicketFieldOption, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TicketFieldOption, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TicketFieldOption, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TicketFieldOption)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TicketFieldOption>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _ticketFieldOptionId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _ticketFieldId;
	private long _originalTicketFieldId;
	private boolean _setOriginalTicketFieldId;
	private String _name;
	private String _nameCurrentLanguageId;
	private int _visibility;
	private int _order;
	private int _status;
	private long _columnBitmask;
	private TicketFieldOption _escapedModel;

}