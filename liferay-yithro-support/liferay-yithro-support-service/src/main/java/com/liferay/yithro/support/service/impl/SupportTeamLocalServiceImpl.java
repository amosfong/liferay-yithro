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

package com.liferay.yithro.support.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.support.exception.DuplicateSupportTeamException;
import com.liferay.yithro.support.exception.RequiredSupportTeamException;
import com.liferay.yithro.support.exception.SupportTeamNameException;
import com.liferay.yithro.support.exception.SupportTeamSupportLaborException;
import com.liferay.yithro.support.model.SupportTeam;
import com.liferay.yithro.support.service.base.SupportTeamLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.support.model.SupportTeam",
	service = AopService.class
)
public class SupportTeamLocalServiceImpl
	extends SupportTeamLocalServiceBaseImpl {

	public SupportTeam addSupportTeam(
			long userId, long parentSupportTeamId, long supportLaborId,
			String name, String description)
		throws PortalException {

		User user = userLocalService.getUser(userId);
		Date now = new Date();

		validate(0, parentSupportTeamId, name, supportLaborId);

		long supportTeamId = counterLocalService.increment();

		SupportTeam supportTeam = supportTeamPersistence.create(supportTeamId);

		supportTeam.setCompanyId(user.getCompanyId());
		supportTeam.setUserId(user.getUserId());
		supportTeam.setUserName(user.getFullName());
		supportTeam.setCreateDate(now);
		supportTeam.setModifiedDate(now);
		supportTeam.setParentSupportTeamId(parentSupportTeamId);
		supportTeam.setSupportLaborId(supportLaborId);
		supportTeam.setName(name);
		supportTeam.setDescription(description);

		return supportTeamPersistence.update(supportTeam);
	}

	@Override
	public SupportTeam deleteSupportTeam(long supportTeamId)
		throws PortalException {

		if (supportTeamPersistence.countByParentSupportTeamId(supportTeamId) >
				0) {

			throw new RequiredSupportTeamException();
		}

		if (supportWorkerPersistence.countBySupportTeamId(supportTeamId) > 0) {
			throw new RequiredSupportTeamException();
		}

		return supportTeamPersistence.remove(supportTeamId);
	}

	public List<SupportTeam> getChildSupportTeams(
		long supportTeamId, boolean recursive) {

		List<SupportTeam> childSupportTeams =
			supportTeamPersistence.findByParentSupportTeamId(supportTeamId);

		if (!recursive) {
			return childSupportTeams;
		}

		List<SupportTeam> supportTeams = ListUtil.copy(childSupportTeams);

		for (SupportTeam childSupportTeam : childSupportTeams) {
			supportTeams.addAll(
				getChildSupportTeams(
					childSupportTeam.getSupportTeamId(), recursive));
		}

		return supportTeams;
	}

	public List<SupportTeam> getSupportLaborSupportTeams(long supportLaborId) {
		return supportTeamPersistence.findBySupportLaborId(supportLaborId);
	}

	public SupportTeam updateSupportTeam(
			long supportTeamId, long parentSupportTeamId, long supportLaborId,
			String name, String description)
		throws PortalException {

		validate(supportTeamId, parentSupportTeamId, name, supportLaborId);

		SupportTeam supportTeam = supportTeamPersistence.findByPrimaryKey(
			supportTeamId);

		supportTeam.setModifiedDate(new Date());
		supportTeam.setParentSupportTeamId(parentSupportTeamId);
		supportTeam.setSupportLaborId(supportLaborId);
		supportTeam.setName(name);
		supportTeam.setDescription(description);

		return supportTeamPersistence.update(supportTeam);
	}

	public void updateSupportTeamChildren(
			long parentSupportTeamId, long[] childSupportTeamIds)
		throws PortalException {

		Set<Long> childSupportTeamIdsSet = SetUtil.fromArray(
			childSupportTeamIds);

		List<SupportTeam> supportTeams =
			supportTeamPersistence.findByParentSupportTeamId(
				parentSupportTeamId, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (SupportTeam supportTeam : supportTeams) {
			if (!childSupportTeamIdsSet.remove(
					supportTeam.getSupportTeamId())) {

				supportTeam.setParentSupportTeamId(0);

				supportTeamPersistence.update(supportTeam);
			}
		}

		for (Long supportTeamId : childSupportTeamIdsSet) {
			SupportTeam supportTeam = getSupportTeam(supportTeamId);

			supportTeam.setParentSupportTeamId(parentSupportTeamId);

			supportTeamPersistence.update(supportTeam);
		}
	}

	public void updateSupportTeamLabor(
			long[] supportTeamIds, long supportLaborId)
		throws PortalException {

		for (long supportTeamId : supportTeamIds) {
			SupportTeam supportTeam = getSupportTeam(supportTeamId);

			if (supportTeam.getSupportLaborId() == supportLaborId) {
				continue;
			}

			supportTeam.setSupportLaborId(supportLaborId);

			supportTeamPersistence.update(supportTeam);
		}
	}

	protected void validate(
			long supportTeamId, long parentSupportTeamId, String name,
			long supportLaborId)
		throws PortalException {

		SupportTeam supportTeam = supportTeamPersistence.fetchByName(name);

		if ((supportTeam != null) &&
			(supportTeam.getSupportTeamId() != supportTeamId)) {

			throw new DuplicateSupportTeamException();
		}

		if (parentSupportTeamId > 0) {
			supportTeamPersistence.findByPrimaryKey(parentSupportTeamId);
		}

		if (Validator.isNull(name)) {
			throw new SupportTeamNameException();
		}

		if (supportLaborId <= 0) {
			throw new SupportTeamSupportLaborException();
		}
	}

}