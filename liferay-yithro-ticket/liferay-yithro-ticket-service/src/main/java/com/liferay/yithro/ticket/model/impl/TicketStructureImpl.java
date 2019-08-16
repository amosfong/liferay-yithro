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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.model.TicketFieldOption;
import com.liferay.yithro.ticket.model.TicketFormField;
import com.liferay.yithro.ticket.model.TicketFormFieldOption;
import com.liferay.yithro.ticket.service.TicketFieldLocalServiceUtil;
import com.liferay.yithro.ticket.service.TicketFieldOptionLocalServiceUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Amos Fong
 */
@ProviderType
public class TicketStructureImpl extends TicketStructureBaseImpl {

	public TicketStructureImpl() {
	}

	public JSONObject getStructureJSONObject() {
		if (_jsonObject != null) {
			return _jsonObject;
		}

		try {
			_jsonObject = JSONFactoryUtil.createJSONObject(getStructure());
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return _jsonObject;
	}

	public List<TicketFormField> getTicketFormFields() throws PortalException {
		if (_ticketFormFields != null) {
			return _ticketFormFields;
		}

		_ticketFormFields = new ArrayList<>();

		JSONObject jsonObject = getStructureJSONObject();

		JSONArray jsonArray = jsonObject.getJSONArray("ticketFields");

		if (jsonArray != null) {
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject ticketFieldJSONObject = jsonArray.getJSONObject(i);

				long ticketFieldId = ticketFieldJSONObject.getLong(
					"ticketFieldId");

				TicketField ticketField =
					TicketFieldLocalServiceUtil.getTicketField(ticketFieldId);

				TicketFormField ticketFormField = new TicketFormField();

				ticketFormField.setDisplayRules(
					ticketFieldJSONObject.getString("displayRules"));
				ticketFormField.setTicketField(ticketField);

				JSONArray ticketFieldOptionsJSONArray =
					ticketFieldJSONObject.getJSONArray("ticketFieldOptions");

				if (ticketFieldOptionsJSONArray != null) {
					for (int j = 0; j < ticketFieldOptionsJSONArray.length();
						 j++) {

						JSONObject ticketFieldOptionJSONObject =
							ticketFieldOptionsJSONArray.getJSONObject(j);

						long ticketFieldOptionId =
							ticketFieldOptionJSONObject.getLong(
								"ticketFieldOptionId");

						TicketFieldOption ticketFieldOption =
							TicketFieldOptionLocalServiceUtil.
								getTicketFieldOption(ticketFieldOptionId);

						TicketFormFieldOption ticketFormFieldOption =
							new TicketFormFieldOption();

						ticketFormFieldOption.setDisplayRules(
							ticketFieldOptionJSONObject.getString(
								"displayRules"));
						ticketFormFieldOption.setTicketFieldOption(
							ticketFieldOption);

						ticketFormField.addTicketFormFieldOption(
							ticketFormFieldOption);
					}
				}

				_ticketFormFields.add(ticketFormField);
			}
		}

		return _ticketFormFields;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		TicketStructureImpl.class);

	private JSONObject _jsonObject;
	private List<TicketFormField> _ticketFormFields;

}