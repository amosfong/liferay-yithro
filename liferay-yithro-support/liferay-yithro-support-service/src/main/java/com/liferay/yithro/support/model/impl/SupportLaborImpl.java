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

import java.util.Calendar;

/**
 * @author Brent Krone-Schmidt
 */
@ProviderType
public class SupportLaborImpl extends SupportLaborBaseImpl {

	public SupportLaborImpl() {
	}

	public int getCloseTime(int day) {
		if (day == Calendar.SUNDAY) {
			return getSunClose();
		}
		else if (day == Calendar.MONDAY) {
			return getMonClose();
		}
		else if (day == Calendar.TUESDAY) {
			return getTueClose();
		}
		else if (day == Calendar.WEDNESDAY) {
			return getWedClose();
		}
		else if (day == Calendar.THURSDAY) {
			return getThuClose();
		}
		else if (day == Calendar.FRIDAY) {
			return getFriClose();
		}
		else if (day == Calendar.SATURDAY) {
			return getSatClose();
		}

		return 0;
	}

	public int getOpenTime(int day) {
		if (day == Calendar.SUNDAY) {
			return getSunOpen();
		}
		else if (day == Calendar.MONDAY) {
			return getMonOpen();
		}
		else if (day == Calendar.TUESDAY) {
			return getTueOpen();
		}
		else if (day == Calendar.WEDNESDAY) {
			return getWedOpen();
		}
		else if (day == Calendar.THURSDAY) {
			return getThuOpen();
		}
		else if (day == Calendar.FRIDAY) {
			return getFriOpen();
		}
		else if (day == Calendar.SATURDAY) {
			return getSatOpen();
		}

		return 0;
	}

}