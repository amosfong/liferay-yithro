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

package com.liferay.yithro.support.web.internal.search;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.yithro.support.model.SupportTeam;
import com.liferay.yithro.support.service.SupportWorkerLocalServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Amos Fong
 */
public class SetWorkerSupportTeamChecker extends EmptyOnClickRowChecker {

	public SetWorkerSupportTeamChecker(
		RenderResponse renderResponse, SupportTeam supportTeam) {

		super(renderResponse);

		_supportTeam = supportTeam;
	}

	@Override
	public boolean isChecked(Object obj) {
		User user = (User)obj;

		try {
			return SupportWorkerLocalServiceUtil.hasSupportWorker(
				user.getUserId(), _supportTeam.getSupportTeamId());
		}
		catch (Exception e) {
			_log.error(e, e);

			return false;
		}
	}

	@Override
	public boolean isDisabled(Object obj) {
		User user = (User)obj;

		try {
			if (isChecked(user)) {
				return true;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return super.isDisabled(obj);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		SetWorkerSupportTeamChecker.class);

	private final SupportTeam _supportTeam;

}