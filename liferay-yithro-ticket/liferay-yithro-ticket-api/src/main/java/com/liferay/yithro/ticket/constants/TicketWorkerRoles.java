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

package com.liferay.yithro.ticket.constants;

/**
 * @author Amos Fong
 */
public class TicketWorkerRoles {

	public static final int DEVELOPER = 2;

	public static final int ESCALATED_DEVELOPER = 3;

	public static final int MANAGER = 1;

	public static final int NONE = 0;

	public static String getLabel(int role) {
		if (role == DEVELOPER) {
			return "developer";
		}
		else if (role == ESCALATED_DEVELOPER) {
			return "escalated-developer";
		}
		else if (role == MANAGER) {
			return "manager";
		}
		else {
			return null;
		}
	}

}