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

import com.liferay.portal.kernel.util.StringUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.RenderResponse;

/**
 * @author Amos Fong
 */
public class TicketFormFieldOption {

	public String getDisplayRules() {
		return _displayRules;
	}

	public String getJavascriptDisplayRules(RenderResponse renderResponse) {
		Set<String> ticketFieldIds = new HashSet<>();

		Matcher matcher = _pattern.matcher(_displayRules);

		while (matcher.find()) {
			ticketFieldIds.add(matcher.group(1));
		}

		String javascriptDisplayRules = _displayRules;

		for (String ticketFieldId : ticketFieldIds) {
			javascriptDisplayRules = StringUtil.replace(
				javascriptDisplayRules, "${" + ticketFieldId + "}",
				"A.one('#" + renderResponse.getNamespace() +
					"ticketFieldIdData_" + ticketFieldId + "').val()");
		}

		return javascriptDisplayRules;
	}

	public TicketFieldOption getTicketFieldOption() {
		return _ticketFieldOption;
	}

	public void setDisplayRules(String displayRules) {
		_displayRules = displayRules;
	}

	public void setTicketFieldOption(TicketFieldOption ticketFieldOption) {
		_ticketFieldOption = ticketFieldOption;
	}

	private static final Pattern _pattern = Pattern.compile(
		"\\$\\{([0-9]+)\\}");

	private String _displayRules;
	private TicketFieldOption _ticketFieldOption;

}