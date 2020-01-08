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

package com.liferay.yithro.rules.web.internal.application.list;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Portlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.yithro.application.list.constants.YithroPanelCategoryKeys;
import com.liferay.yithro.rules.constants.RulesPortletKeys;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(
	immediate = true,
	property = {
		"panel.app.order:Integer=2",
		"panel.category.key=" + YithroPanelCategoryKeys.CONTROL_PANEL_YITHRO
	},
	service = PanelApp.class
)
public class BusinessRulesPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return RulesPortletKeys.BUSINESS_RULES;
	}

	@Override
	public boolean isShow(PermissionChecker permissionChecker, Group group)
		throws PortalException {

		return permissionChecker.isOmniadmin();
	}

	@Override
	@Reference(
		target = "(javax.portlet.name=" + RulesPortletKeys.BUSINESS_RULES + ")",
		unbind = "-"
	)
	public void setPortlet(Portlet portlet) {
		super.setPortlet(portlet);
	}

}