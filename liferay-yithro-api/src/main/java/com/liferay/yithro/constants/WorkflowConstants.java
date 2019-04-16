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

package com.liferay.yithro.constants;

/**
 * @author Amos Fong
 */
public class WorkflowConstants
	extends com.liferay.portal.kernel.workflow.WorkflowConstants {

	public static final int STATUS_CLOSED = 100;

	public static String getStatusLabel(int status) {
		if (status == STATUS_CLOSED) {
			return "closed";
		}
		else {
			return com.liferay.portal.kernel.workflow.WorkflowConstants.
				getStatusLabel(status);
		}
	}

}