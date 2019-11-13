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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.yithro.support.constants.SupportPortletKeys;
import com.liferay.yithro.support.exception.SupportTeamNameException;
import com.liferay.yithro.support.service.SupportWorkerLocalService;

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
		"mvc.command.name=/ticket_support/edit_support_team_workers"
	},
	service = MVCActionCommand.class
)
public class EditSupportTeamWorkersMVCActionCommand
	extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		try {
			long supportTeamId = ParamUtil.getLong(
				actionRequest, "supportTeamId");

			long[] addUserIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "addUserIds"), 0L);
			long[] removeUserIds = StringUtil.split(
				ParamUtil.getString(actionRequest, "removeUserIds"), 0L);

			_supportWorkerLocalService.addSupportWorkers(
				addUserIds, supportTeamId, new double[addUserIds.length],
				new int[addUserIds.length]);
			_supportWorkerLocalService.deleteSupportWorkers(
				removeUserIds, supportTeamId);

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

	private static final Log _log = LogFactoryUtil.getLog(
		EditSupportTeamMVCActionCommand.class);

	@Reference
	private SupportWorkerLocalService _supportWorkerLocalService;

}