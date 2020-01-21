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

package com.liferay.yithro.ticket.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TicketFieldOption}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldOption
 * @generated
 */
public class TicketFieldOptionWrapper
	extends BaseModelWrapper<TicketFieldOption>
	implements ModelWrapper<TicketFieldOption>, TicketFieldOption {

	public TicketFieldOptionWrapper(TicketFieldOption ticketFieldOption) {
		super(ticketFieldOption);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketFieldOptionId", getTicketFieldOptionId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ticketFieldId", getTicketFieldId());
		attributes.put("name", getName());
		attributes.put("visibility", getVisibility());
		attributes.put("order", getOrder());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketFieldOptionId = (Long)attributes.get("ticketFieldOptionId");

		if (ticketFieldOptionId != null) {
			setTicketFieldOptionId(ticketFieldOptionId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long ticketFieldId = (Long)attributes.get("ticketFieldId");

		if (ticketFieldId != null) {
			setTicketFieldId(ticketFieldId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer visibility = (Integer)attributes.get("visibility");

		if (visibility != null) {
			setVisibility(visibility);
		}

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the company ID of this ticket field option.
	 *
	 * @return the company ID of this ticket field option
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this ticket field option.
	 *
	 * @return the create date of this ticket field option
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Returns the modified date of this ticket field option.
	 *
	 * @return the modified date of this ticket field option
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this ticket field option.
	 *
	 * @return the name of this ticket field option
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this ticket field option in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this ticket field option
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this ticket field option in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ticket field option. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this ticket field option in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this ticket field option
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this ticket field option in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ticket field option
	 */
	@Override
	public String getName(String languageId, boolean useDefault) {
		return model.getName(languageId, useDefault);
	}

	@Override
	public String getNameCurrentLanguageId() {
		return model.getNameCurrentLanguageId();
	}

	@Override
	public String getNameCurrentValue() {
		return model.getNameCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized names of this ticket field option.
	 *
	 * @return the locales and localized names of this ticket field option
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the order of this ticket field option.
	 *
	 * @return the order of this ticket field option
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this ticket field option.
	 *
	 * @return the primary key of this ticket field option
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this ticket field option.
	 *
	 * @return the status of this ticket field option
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the ticket field ID of this ticket field option.
	 *
	 * @return the ticket field ID of this ticket field option
	 */
	@Override
	public long getTicketFieldId() {
		return model.getTicketFieldId();
	}

	/**
	 * Returns the ticket field option ID of this ticket field option.
	 *
	 * @return the ticket field option ID of this ticket field option
	 */
	@Override
	public long getTicketFieldOptionId() {
		return model.getTicketFieldOptionId();
	}

	/**
	 * Returns the visibility of this ticket field option.
	 *
	 * @return the visibility of this ticket field option
	 */
	@Override
	public int getVisibility() {
		return model.getVisibility();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the company ID of this ticket field option.
	 *
	 * @param companyId the company ID of this ticket field option
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this ticket field option.
	 *
	 * @param createDate the create date of this ticket field option
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this ticket field option.
	 *
	 * @param modifiedDate the modified date of this ticket field option
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this ticket field option.
	 *
	 * @param name the name of this ticket field option
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this ticket field option in the language.
	 *
	 * @param name the localized name of this ticket field option
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this ticket field option in the language, and sets the default locale.
	 *
	 * @param name the localized name of this ticket field option
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setName(
		String name, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setName(name, locale, defaultLocale);
	}

	@Override
	public void setNameCurrentLanguageId(String languageId) {
		model.setNameCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized names of this ticket field option from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this ticket field option
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this ticket field option from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this ticket field option
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the order of this ticket field option.
	 *
	 * @param order the order of this ticket field option
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this ticket field option.
	 *
	 * @param primaryKey the primary key of this ticket field option
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this ticket field option.
	 *
	 * @param status the status of this ticket field option
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the ticket field ID of this ticket field option.
	 *
	 * @param ticketFieldId the ticket field ID of this ticket field option
	 */
	@Override
	public void setTicketFieldId(long ticketFieldId) {
		model.setTicketFieldId(ticketFieldId);
	}

	/**
	 * Sets the ticket field option ID of this ticket field option.
	 *
	 * @param ticketFieldOptionId the ticket field option ID of this ticket field option
	 */
	@Override
	public void setTicketFieldOptionId(long ticketFieldOptionId) {
		model.setTicketFieldOptionId(ticketFieldOptionId);
	}

	/**
	 * Sets the visibility of this ticket field option.
	 *
	 * @param visibility the visibility of this ticket field option
	 */
	@Override
	public void setVisibility(int visibility) {
		model.setVisibility(visibility);
	}

	@Override
	protected TicketFieldOptionWrapper wrap(
		TicketFieldOption ticketFieldOption) {

		return new TicketFieldOptionWrapper(ticketFieldOption);
	}

}