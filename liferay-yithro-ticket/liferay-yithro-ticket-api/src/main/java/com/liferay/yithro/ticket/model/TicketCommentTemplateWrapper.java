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

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TicketCommentTemplate}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommentTemplate
 * @generated
 */
@ProviderType
public class TicketCommentTemplateWrapper
	extends BaseModelWrapper<TicketCommentTemplate>
	implements TicketCommentTemplate, ModelWrapper<TicketCommentTemplate> {

	public TicketCommentTemplateWrapper(
		TicketCommentTemplate ticketCommentTemplate) {

		super(ticketCommentTemplate);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("ticketCommentTemplateId", getTicketCommentTemplateId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("content", getContent());
		attributes.put("useCount", getUseCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long ticketCommentTemplateId = (Long)attributes.get(
			"ticketCommentTemplateId");

		if (ticketCommentTemplateId != null) {
			setTicketCommentTemplateId(ticketCommentTemplateId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Integer useCount = (Integer)attributes.get("useCount");

		if (useCount != null) {
			setUseCount(useCount);
		}
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the content of this ticket comment template.
	 *
	 * @return the content of this ticket comment template
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the localized content of this ticket comment template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized content of this ticket comment template
	 */
	@Override
	public String getContent(java.util.Locale locale) {
		return model.getContent(locale);
	}

	/**
	 * Returns the localized content of this ticket comment template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content of this ticket comment template. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getContent(java.util.Locale locale, boolean useDefault) {
		return model.getContent(locale, useDefault);
	}

	/**
	 * Returns the localized content of this ticket comment template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized content of this ticket comment template
	 */
	@Override
	public String getContent(String languageId) {
		return model.getContent(languageId);
	}

	/**
	 * Returns the localized content of this ticket comment template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content of this ticket comment template
	 */
	@Override
	public String getContent(String languageId, boolean useDefault) {
		return model.getContent(languageId, useDefault);
	}

	@Override
	public String getContentCurrentLanguageId() {
		return model.getContentCurrentLanguageId();
	}

	@Override
	public String getContentCurrentValue() {
		return model.getContentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized contents of this ticket comment template.
	 *
	 * @return the locales and localized contents of this ticket comment template
	 */
	@Override
	public Map<java.util.Locale, String> getContentMap() {
		return model.getContentMap();
	}

	/**
	 * Returns the create date of this ticket comment template.
	 *
	 * @return the create date of this ticket comment template
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
	 * Returns the modified date of this ticket comment template.
	 *
	 * @return the modified date of this ticket comment template
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this ticket comment template.
	 *
	 * @return the name of this ticket comment template
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the localized name of this ticket comment template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this ticket comment template
	 */
	@Override
	public String getName(java.util.Locale locale) {
		return model.getName(locale);
	}

	/**
	 * Returns the localized name of this ticket comment template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ticket comment template. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getName(java.util.Locale locale, boolean useDefault) {
		return model.getName(locale, useDefault);
	}

	/**
	 * Returns the localized name of this ticket comment template in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this ticket comment template
	 */
	@Override
	public String getName(String languageId) {
		return model.getName(languageId);
	}

	/**
	 * Returns the localized name of this ticket comment template in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ticket comment template
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
	 * Returns a map of the locales and localized names of this ticket comment template.
	 *
	 * @return the locales and localized names of this ticket comment template
	 */
	@Override
	public Map<java.util.Locale, String> getNameMap() {
		return model.getNameMap();
	}

	/**
	 * Returns the primary key of this ticket comment template.
	 *
	 * @return the primary key of this ticket comment template
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ticket comment template ID of this ticket comment template.
	 *
	 * @return the ticket comment template ID of this ticket comment template
	 */
	@Override
	public long getTicketCommentTemplateId() {
		return model.getTicketCommentTemplateId();
	}

	/**
	 * Returns the use count of this ticket comment template.
	 *
	 * @return the use count of this ticket comment template
	 */
	@Override
	public int getUseCount() {
		return model.getUseCount();
	}

	/**
	 * Returns the user ID of this ticket comment template.
	 *
	 * @return the user ID of this ticket comment template
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this ticket comment template.
	 *
	 * @return the user name of this ticket comment template
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this ticket comment template.
	 *
	 * @return the user uuid of this ticket comment template
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
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
	 * Sets the content of this ticket comment template.
	 *
	 * @param content the content of this ticket comment template
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the localized content of this ticket comment template in the language.
	 *
	 * @param content the localized content of this ticket comment template
	 * @param locale the locale of the language
	 */
	@Override
	public void setContent(String content, java.util.Locale locale) {
		model.setContent(content, locale);
	}

	/**
	 * Sets the localized content of this ticket comment template in the language, and sets the default locale.
	 *
	 * @param content the localized content of this ticket comment template
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContent(
		String content, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setContent(content, locale, defaultLocale);
	}

	@Override
	public void setContentCurrentLanguageId(String languageId) {
		model.setContentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized contents of this ticket comment template from the map of locales and localized contents.
	 *
	 * @param contentMap the locales and localized contents of this ticket comment template
	 */
	@Override
	public void setContentMap(Map<java.util.Locale, String> contentMap) {
		model.setContentMap(contentMap);
	}

	/**
	 * Sets the localized contents of this ticket comment template from the map of locales and localized contents, and sets the default locale.
	 *
	 * @param contentMap the locales and localized contents of this ticket comment template
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContentMap(
		Map<java.util.Locale, String> contentMap,
		java.util.Locale defaultLocale) {

		model.setContentMap(contentMap, defaultLocale);
	}

	/**
	 * Sets the create date of this ticket comment template.
	 *
	 * @param createDate the create date of this ticket comment template
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the modified date of this ticket comment template.
	 *
	 * @param modifiedDate the modified date of this ticket comment template
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this ticket comment template.
	 *
	 * @param name the name of this ticket comment template
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the localized name of this ticket comment template in the language.
	 *
	 * @param name the localized name of this ticket comment template
	 * @param locale the locale of the language
	 */
	@Override
	public void setName(String name, java.util.Locale locale) {
		model.setName(name, locale);
	}

	/**
	 * Sets the localized name of this ticket comment template in the language, and sets the default locale.
	 *
	 * @param name the localized name of this ticket comment template
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
	 * Sets the localized names of this ticket comment template from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this ticket comment template
	 */
	@Override
	public void setNameMap(Map<java.util.Locale, String> nameMap) {
		model.setNameMap(nameMap);
	}

	/**
	 * Sets the localized names of this ticket comment template from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this ticket comment template
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setNameMap(
		Map<java.util.Locale, String> nameMap, java.util.Locale defaultLocale) {

		model.setNameMap(nameMap, defaultLocale);
	}

	/**
	 * Sets the primary key of this ticket comment template.
	 *
	 * @param primaryKey the primary key of this ticket comment template
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ticket comment template ID of this ticket comment template.
	 *
	 * @param ticketCommentTemplateId the ticket comment template ID of this ticket comment template
	 */
	@Override
	public void setTicketCommentTemplateId(long ticketCommentTemplateId) {
		model.setTicketCommentTemplateId(ticketCommentTemplateId);
	}

	/**
	 * Sets the use count of this ticket comment template.
	 *
	 * @param useCount the use count of this ticket comment template
	 */
	@Override
	public void setUseCount(int useCount) {
		model.setUseCount(useCount);
	}

	/**
	 * Sets the user ID of this ticket comment template.
	 *
	 * @param userId the user ID of this ticket comment template
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this ticket comment template.
	 *
	 * @param userName the user name of this ticket comment template
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this ticket comment template.
	 *
	 * @param userUuid the user uuid of this ticket comment template
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	@Override
	protected TicketCommentTemplateWrapper wrap(
		TicketCommentTemplate ticketCommentTemplate) {

		return new TicketCommentTemplateWrapper(ticketCommentTemplate);
	}

}