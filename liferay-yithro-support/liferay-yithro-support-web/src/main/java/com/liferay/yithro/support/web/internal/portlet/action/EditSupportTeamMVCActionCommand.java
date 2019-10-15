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

package com.liferay.yithro.support.web.internal.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.yithro.support.constants.SupportPortletKeys;
import com.liferay.yithro.support.exception.SupportTeamNameException;
import com.liferay.yithro.support.service.SupportTeamLocalService;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	property = {
		"javax.portlet.name=" + SupportPortletKeys.TICKET_SUPPORT,
		"mvc.command.name=/ticket_support/edit_support_team"
	},
	service = MVCActionCommand.class
)
public class EditSupportTeamMVCActionCommand extends BaseMVCActionCommand {

	protected void deleteSupportTeam(ActionRequest actionRequest)
		throws PortalException {

		long supportTeamId = ParamUtil.getLong(actionRequest, "supportTeamId");

		_supportTeamLocalService.deleteSupportTeam(supportTeamId);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteSupportTeam(actionRequest);
			}
			else {
				updateSupportTeam(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof SupportTeamNameException) {
				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					"/ticket_support/edit_support_team");
			}
			else {
				_log.error(e, e);

				throw e;
			}
		}
	}

	protected void updateSupportTeam(ActionRequest actionRequest)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long supportTeamId = ParamUtil.getLong(actionRequest, "supportTeamId");

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");
		double maxWork = ParamUtil.getDouble(actionRequest, "maxWork");

		if (supportTeamId <= 0) {
			_supportTeamLocalService.addSupportTeam(
				themeDisplay.getUserId(), 0, 0, name, description, maxWork);
		}
		else {
			_supportTeamLocalService.updateSupportTeam(
				supportTeamId, 0, 0, name, description, maxWork);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditSupportTeamMVCActionCommand.class);

	@Reference
	private SupportTeamLocalService _supportTeamLocalService;

}