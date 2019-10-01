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

package com.liferay.yithro.support.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.yithro.support.model.SupportLabor;
import com.liferay.yithro.support.model.SupportTeam;
import com.liferay.yithro.support.service.SupportLaborLocalServiceUtil;
import com.liferay.yithro.support.service.SupportTeamLocalServiceUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Amos Fong
 */
@ProviderType
public class SupportWorkerImpl extends SupportWorkerBaseImpl {

	public static final int END_OF_DAY_MINUTES = 1439;

	public SupportWorkerImpl() {
	}

	public SupportLabor getSupportLabor() throws PortalException {
		SupportLabor supportLabor =
			SupportLaborLocalServiceUtil.fetchSupportLabor(getSupportLaborId());

		if (supportLabor == null) {
			SupportTeam supportTeam = getSupportTeam();

			supportLabor = SupportLaborLocalServiceUtil.fetchSupportLabor(
				supportTeam.getSupportLaborId());
		}

		return supportLabor;
	}

	public SupportTeam getSupportTeam() throws PortalException {
		return SupportTeamLocalServiceUtil.getSupportTeam(getSupportTeamId());
	}

	public Long getTimeUntilClose() throws PortalException {
		SupportLabor supportLabor = getSupportLabor();

		Calendar now = Calendar.getInstance(
			TimeZone.getTimeZone(supportLabor.getTimeZoneId()));

		if (hasHoliday(now.getTime())) {
			return 0L;
		}

		Calendar openCal = (Calendar)now.clone();

		openCal.set(Calendar.HOUR, 0);
		openCal.set(Calendar.MINUTE, 0);
		openCal.set(Calendar.SECOND, 0);

		int openTime = supportLabor.getOpenTime(
			openCal.get(Calendar.DAY_OF_WEEK));

		openCal.add(Calendar.MINUTE, openTime);

		if (openCal.after(now)) {
			return 0L;
		}

		for (int i = 0; i < 7; i++) {
			Calendar closeCal = (Calendar)now.clone();

			closeCal.add(Calendar.DAY_OF_MONTH, i);

			closeCal.set(Calendar.HOUR, 0);
			closeCal.set(Calendar.MINUTE, 0);
			closeCal.set(Calendar.SECOND, 0);

			if (hasHoliday(closeCal.getTime())) {
				return closeCal.getTimeInMillis() - now.getTimeInMillis();
			}

			int closeTime = supportLabor.getCloseTime(
				closeCal.get(Calendar.DAY_OF_WEEK));

			closeCal.add(Calendar.MINUTE, closeTime);

			if (closeCal.before(now)) {
				return 0L;
			}

			if (closeTime == END_OF_DAY_MINUTES) {
				Calendar nextDayOpenCal = (Calendar)closeCal.clone();

				nextDayOpenCal.add(Calendar.DAY_OF_MONTH, 1);

				int nextDayOpenTime = supportLabor.getOpenTime(
					nextDayOpenCal.get(Calendar.DAY_OF_WEEK));

				if (nextDayOpenTime == 0) {
					continue;
				}
			}

			return closeCal.getTimeInMillis() - now.getTimeInMillis();
		}

		return null;
	}

	public Long getTimeUntilOpen() throws PortalException {
		SupportLabor supportLabor = getSupportLabor();

		Calendar now = Calendar.getInstance(
			TimeZone.getTimeZone(supportLabor.getTimeZoneId()));

		for (int i = 0; i < 7; i++) {
			Calendar openCal = (Calendar)now.clone();
			Calendar closeCal = (Calendar)now.clone();

			openCal.add(Calendar.DAY_OF_MONTH, i);
			closeCal.add(Calendar.DAY_OF_MONTH, i);

			int openTime = supportLabor.getOpenTime(
				openCal.get(Calendar.DAY_OF_WEEK));
			int closeTime = supportLabor.getCloseTime(
				closeCal.get(Calendar.DAY_OF_WEEK));

			if (openTime == closeTime) {
				continue;
			}

			openCal.set(Calendar.HOUR_OF_DAY, 0);
			openCal.set(Calendar.MINUTE, 0);
			openCal.set(Calendar.SECOND, 0);

			openCal.add(Calendar.MINUTE, openTime);

			closeCal.set(Calendar.HOUR_OF_DAY, 0);
			closeCal.set(Calendar.MINUTE, 0);
			closeCal.set(Calendar.SECOND, 0);

			closeCal.add(Calendar.MINUTE, closeTime);

			if (openCal.before(now)) {
				if (closeCal.after(now)) {
					return 0L;
				}

				continue;
			}

			if (hasHoliday(openCal.getTime())) {
				continue;
			}

			return openCal.getTimeInMillis() - now.getTimeInMillis();
		}

		return null;
	}

	public boolean isActive() {
		User user = UserLocalServiceUtil.fetchUser(getUserId());

		if (user == null) {
			return false;
		}

		if (!user.isActive()) {
			return false;
		}

		return true;
	}

	public boolean isAvailable() throws PortalException {
		Date now = new Date();

		if (hasHoliday(now)) {
			return false;
		}

		if (!isOpen(now)) {
			return false;
		}

		return true;
	}

	protected boolean hasHoliday(Date date) {

		// TODO

		return false;
	}

	protected boolean isOpen(Date date) throws PortalException {
		SupportLabor supportLabor = getSupportLabor();

		if (supportLabor == null) {
			return false;
		}

		Calendar calendar = Calendar.getInstance(
			TimeZone.getTimeZone(supportLabor.getTimeZoneId()));

		calendar.setTime(date);

		int openTime = supportLabor.getOpenTime(
			calendar.get(Calendar.DAY_OF_WEEK));
		int closeTime = supportLabor.getCloseTime(
			calendar.get(Calendar.DAY_OF_WEEK));

		if (openTime == closeTime) {
			return false;
		}

		int minuteOfDay =
			(calendar.get(Calendar.HOUR_OF_DAY) * 60) +
				calendar.get(Calendar.MINUTE);

		if ((minuteOfDay < closeTime) && (minuteOfDay > openTime)) {
			return true;
		}

		if ((openTime > closeTime) &&
			((minuteOfDay > openTime) || (minuteOfDay < closeTime))) {

			return true;
		}

		return false;
	}

}