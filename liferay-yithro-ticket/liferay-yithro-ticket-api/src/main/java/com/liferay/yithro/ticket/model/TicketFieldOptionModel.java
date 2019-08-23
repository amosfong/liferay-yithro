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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.LocalizedModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TicketFieldOption service. Represents a row in the &quot;Yithro_TicketFieldOption&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.ticket.model.impl.TicketFieldOptionModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.ticket.model.impl.TicketFieldOptionImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketFieldOption
 * @generated
 */
@ProviderType
public interface TicketFieldOptionModel
	extends BaseModel<TicketFieldOption>, LocalizedModel, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ticket field option model instance should use the {@link TicketFieldOption} interface instead.
	 */

	/**
	 * Returns the primary key of this ticket field option.
	 *
	 * @return the primary key of this ticket field option
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket field option.
	 *
	 * @param primaryKey the primary key of this ticket field option
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ticket field option ID of this ticket field option.
	 *
	 * @return the ticket field option ID of this ticket field option
	 */
	public long getTicketFieldOptionId();

	/**
	 * Sets the ticket field option ID of this ticket field option.
	 *
	 * @param ticketFieldOptionId the ticket field option ID of this ticket field option
	 */
	public void setTicketFieldOptionId(long ticketFieldOptionId);

	/**
	 * Returns the company ID of this ticket field option.
	 *
	 * @return the company ID of this ticket field option
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ticket field option.
	 *
	 * @param companyId the company ID of this ticket field option
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this ticket field option.
	 *
	 * @return the create date of this ticket field option
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket field option.
	 *
	 * @param createDate the create date of this ticket field option
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ticket field option.
	 *
	 * @return the modified date of this ticket field option
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ticket field option.
	 *
	 * @param modifiedDate the modified date of this ticket field option
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the ticket field ID of this ticket field option.
	 *
	 * @return the ticket field ID of this ticket field option
	 */
	public long getTicketFieldId();

	/**
	 * Sets the ticket field ID of this ticket field option.
	 *
	 * @param ticketFieldId the ticket field ID of this ticket field option
	 */
	public void setTicketFieldId(long ticketFieldId);

	/**
	 * Returns the name of this ticket field option.
	 *
	 * @return the name of this ticket field option
	 */
	public String getName();

	/**
	 * Returns the localized name of this ticket field option in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized name of this ticket field option
	 */
	@AutoEscape
	public String getName(Locale locale);

	/**
	 * Returns the localized name of this ticket field option in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ticket field option. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@AutoEscape
	public String getName(Locale locale, boolean useDefault);

	/**
	 * Returns the localized name of this ticket field option in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized name of this ticket field option
	 */
	@AutoEscape
	public String getName(String languageId);

	/**
	 * Returns the localized name of this ticket field option in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized name of this ticket field option
	 */
	@AutoEscape
	public String getName(String languageId, boolean useDefault);

	@AutoEscape
	public String getNameCurrentLanguageId();

	@AutoEscape
	public String getNameCurrentValue();

	/**
	 * Returns a map of the locales and localized names of this ticket field option.
	 *
	 * @return the locales and localized names of this ticket field option
	 */
	public Map<Locale, String> getNameMap();

	/**
	 * Sets the name of this ticket field option.
	 *
	 * @param name the name of this ticket field option
	 */
	public void setName(String name);

	/**
	 * Sets the localized name of this ticket field option in the language.
	 *
	 * @param name the localized name of this ticket field option
	 * @param locale the locale of the language
	 */
	public void setName(String name, Locale locale);

	/**
	 * Sets the localized name of this ticket field option in the language, and sets the default locale.
	 *
	 * @param name the localized name of this ticket field option
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	public void setName(String name, Locale locale, Locale defaultLocale);

	public void setNameCurrentLanguageId(String languageId);

	/**
	 * Sets the localized names of this ticket field option from the map of locales and localized names.
	 *
	 * @param nameMap the locales and localized names of this ticket field option
	 */
	public void setNameMap(Map<Locale, String> nameMap);

	/**
	 * Sets the localized names of this ticket field option from the map of locales and localized names, and sets the default locale.
	 *
	 * @param nameMap the locales and localized names of this ticket field option
	 * @param defaultLocale the default locale
	 */
	public void setNameMap(Map<Locale, String> nameMap, Locale defaultLocale);

	/**
	 * Returns the visibility of this ticket field option.
	 *
	 * @return the visibility of this ticket field option
	 */
	public int getVisibility();

	/**
	 * Sets the visibility of this ticket field option.
	 *
	 * @param visibility the visibility of this ticket field option
	 */
	public void setVisibility(int visibility);

	/**
	 * Returns the order of this ticket field option.
	 *
	 * @return the order of this ticket field option
	 */
	public int getOrder();

	/**
	 * Sets the order of this ticket field option.
	 *
	 * @param order the order of this ticket field option
	 */
	public void setOrder(int order);

	/**
	 * Returns the status of this ticket field option.
	 *
	 * @return the status of this ticket field option
	 */
	public int getStatus();

	/**
	 * Sets the status of this ticket field option.
	 *
	 * @param status the status of this ticket field option
	 */
	public void setStatus(int status);

	@Override
	public String[] getAvailableLanguageIds();

	@Override
	public String getDefaultLanguageId();

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException;

	@Override
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException;

}