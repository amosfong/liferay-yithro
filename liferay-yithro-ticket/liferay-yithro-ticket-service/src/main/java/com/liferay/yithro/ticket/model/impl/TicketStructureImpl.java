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
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.yithro.ticket.constants.TicketFieldType;
import com.liferay.yithro.ticket.model.TicketField;
import com.liferay.yithro.ticket.model.TicketFieldOption;
import com.liferay.yithro.ticket.model.TicketFormField;
import com.liferay.yithro.ticket.model.TicketFormFieldOption;
import com.liferay.yithro.ticket.service.TicketFieldLocalServiceUtil;

import java.util.ArrayList;
import java.util.Collections;
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

				List<TicketFormFieldOption> ticketFormFieldOptions =
					_getTicketFormFieldOptions(
						ticketField,
						ticketFieldJSONObject.getJSONObject(
							"ticketFieldOptions"));

				ticketFormField.setTicketFormFieldOptions(
					ticketFormFieldOptions);

				_ticketFormFields.add(ticketFormField);
			}
		}

		return _ticketFormFields;
	}

	private List<TicketFormFieldOption> _getTicketFormFieldOptions(
		TicketField ticketField, JSONObject ticketFieldOptionsJSONObject) {

		if (ticketField.getType() != TicketFieldType.SELECT) {
			return Collections.emptyList();
		}

		List<TicketFormFieldOption> ticketFormFieldOptions = new ArrayList<>();

		List<TicketFieldOption> ticketFieldOptions =
			ticketField.getTicketFieldOptions(
				WorkflowConstants.STATUS_APPROVED);

		for (TicketFieldOption ticketFieldOption : ticketFieldOptions) {
			TicketFormFieldOption ticketFormFieldOption =
				new TicketFormFieldOption();

			ticketFormFieldOption.setTicketFieldOption(ticketFieldOption);

			if (ticketFieldOptionsJSONObject != null) {
				JSONObject ticketFieldOptionJSONObject =
					ticketFieldOptionsJSONObject.getJSONObject(
						String.valueOf(
							ticketFieldOption.getTicketFieldOptionId()));

				if (ticketFieldOptionJSONObject != null) {
					String displayRules = ticketFieldOptionJSONObject.getString(
						"displayRules");

					if (!displayRules.equals("never")) {
						ticketFormFieldOption.setDisplayRules(displayRules);
					}
				}
			}

			ticketFormFieldOptions.add(ticketFormFieldOption);
		}

		return ticketFormFieldOptions;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		TicketStructureImpl.class);

	private JSONObject _jsonObject;
	private List<TicketFormField> _ticketFormFields;

}