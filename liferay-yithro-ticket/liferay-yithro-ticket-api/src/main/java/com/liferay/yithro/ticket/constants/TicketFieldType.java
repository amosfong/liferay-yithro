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

import com.liferay.portal.kernel.util.StringPool;

/**
 * @author Amos Fong
 */
public class TicketFieldType {

	public static final int ATTACHMENT = 1;

	public static final int NUMBER = 2;

	public static final int SELECT = 3;

	public static final int TEXT = 4;

	public static final int[] VALUES = {ATTACHMENT, NUMBER, SELECT, TEXT};

	public static String getLabel(int type) {
		if (type == ATTACHMENT) {
			return "attachment";
		}
		else if (type == NUMBER) {
			return "number";
		}
		else if (type == SELECT) {
			return "select";
		}
		else if (type == TEXT) {
			return "text";
		}
		else {
			return StringPool.BLANK;
		}
	}

}