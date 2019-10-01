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
import com.liferay.yithro.support.exception.SupportLevelAgreementNameException;
import com.liferay.yithro.support.service.SupportLevelAgreementLocalService;

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
		"mvc.command.name=/ticket_support/edit_support_level_agreement"
	},
	service = MVCActionCommand.class
)
public class EditSupportLevelAgreementMVCActionCommand
	extends BaseMVCActionCommand {

	protected void deleteSupportLevelAgreement(ActionRequest actionRequest)
		throws PortalException {

		long supportLevelAgreementId = ParamUtil.getLong(
			actionRequest, "supportLevelAgreementId");

		_supportLevelAgreementLocalService.deleteSupportLevelAgreement(
			supportLevelAgreementId);
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (cmd.equals(Constants.DELETE)) {
				deleteSupportLevelAgreement(actionRequest);
			}
			else {
				updateSupportLevelAgreement(actionRequest);
			}

			sendRedirect(actionRequest, actionResponse);
		}
		catch (Exception e) {
			if (e instanceof SupportLevelAgreementNameException) {
				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcRenderCommandName",
					"/ticket_support/edit_support_level_agreement");
			}
			else {
				_log.error(e, e);

				throw e;
			}
		}
	}

	protected void updateSupportLevelAgreement(ActionRequest actionRequest)
		throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		long supportLevelAgreementId = ParamUtil.getLong(
			actionRequest, "supportLevelAgreementId");

		String name = ParamUtil.getString(actionRequest, "name");
		String description = ParamUtil.getString(actionRequest, "description");

		if (supportLevelAgreementId <= 0) {
			_supportLevelAgreementLocalService.addSupportLevelAgreement(
				themeDisplay.getUserId(), name, description);
		}
		else {
			_supportLevelAgreementLocalService.updateSupportLevelAgreement(
				supportLevelAgreementId, name, description);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		EditSupportLevelAgreementMVCActionCommand.class);

	@Reference
	private SupportLevelAgreementLocalService
		_supportLevelAgreementLocalService;

}