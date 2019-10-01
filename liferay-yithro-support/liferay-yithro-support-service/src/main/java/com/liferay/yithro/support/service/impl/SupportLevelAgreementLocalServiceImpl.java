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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.support.exception.DuplicateSupportLevelAgreementException;
import com.liferay.yithro.support.exception.SupportLevelAgreementNameException;
import com.liferay.yithro.support.model.SupportLevelAgreement;
import com.liferay.yithro.support.service.base.SupportLevelAgreementLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Amos Fong
 */
@Component(
	property = "model.class.name=com.liferay.yithro.support.model.SupportLevelAgreement",
	service = AopService.class
)
public class SupportLevelAgreementLocalServiceImpl
	extends SupportLevelAgreementLocalServiceBaseImpl {

	@Override
	public SupportLevelAgreement addSupportLevelAgreement(
			long userId, String name, String description)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		validate(0, name);

		long supportLevelAgreementId = counterLocalService.increment();

		SupportLevelAgreement supportLevelAgreement =
			supportLevelAgreementPersistence.create(supportLevelAgreementId);

		supportLevelAgreement.setCompanyId(user.getCompanyId());
		supportLevelAgreement.setUserId(user.getUserId());
		supportLevelAgreement.setName(name);
		supportLevelAgreement.setDescription(description);

		return supportLevelAgreementPersistence.update(supportLevelAgreement);
	}

	@Override
	public SupportLevelAgreement deleteSupportLevelAgreement(
			long supportLevelAgreementId)
		throws PortalException {

		return supportLevelAgreementPersistence.remove(supportLevelAgreementId);
	}

	@Override
	public SupportLevelAgreement updateSupportLevelAgreement(
			long supportLevelAgreementId, String name, String description)
		throws PortalException {

		validate(supportLevelAgreementId, name);

		SupportLevelAgreement supportLevelAgreement =
			supportLevelAgreementPersistence.findByPrimaryKey(
				supportLevelAgreementId);

		supportLevelAgreement.setName(name);
		supportLevelAgreement.setDescription(description);

		return supportLevelAgreementPersistence.update(supportLevelAgreement);
	}

	protected void validate(long supportLevelAgreementId, String name)
		throws PortalException {

		if (Validator.isNull(name)) {
			throw new SupportLevelAgreementNameException();
		}

		SupportLevelAgreement supportLevelAgreement =
			supportLevelAgreementPersistence.fetchByName(name);

		if ((supportLevelAgreement != null) &&
			(supportLevelAgreement.getSupportLevelAgreementId() !=
				supportLevelAgreementId)) {

			throw new DuplicateSupportLevelAgreementException();
		}
	}

}