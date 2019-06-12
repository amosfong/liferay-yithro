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

import com.liferay.portal.kernel.util.UnicodeProperties;

/**
 * @author Amos Fong
 */
@ProviderType
public class TicketCommentImpl extends TicketCommentBaseImpl {

	public TicketCommentImpl() {
	}

	@Override
	public String getSettings() {
		if (_settingsProperties == null) {
			return super.getSettings();
		}

		return _settingsProperties.toString();
	}

	@Override
	public UnicodeProperties getSettingsProperties() {
		if (_settingsProperties == null) {
			_settingsProperties = new UnicodeProperties(true);

			_settingsProperties.fastLoad(super.getSettings());
		}

		return _settingsProperties;
	}

	@Override
	public String getSettingsProperty(String key) {
		UnicodeProperties settingsProperties = getSettingsProperties();

		return settingsProperties.getProperty(key);
	}

	@Override
	public void setSettingsProperties(UnicodeProperties settingsProperties) {
		_settingsProperties = settingsProperties;

		super.setSettings(_settingsProperties.toString());
	}

	@Override
	public void setSettingsProperty(String key, String value) {
		UnicodeProperties settingsProperties = getSettingsProperties();

		settingsProperties.put(key, value);

		setSettingsProperties(settingsProperties);
	}

	private UnicodeProperties _settingsProperties;

}