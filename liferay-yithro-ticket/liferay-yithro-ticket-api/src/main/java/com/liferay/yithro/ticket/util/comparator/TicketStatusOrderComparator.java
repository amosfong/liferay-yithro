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

package com.liferay.yithro.ticket.util.comparator;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.yithro.ticket.model.TicketStatus;

/**
 * @author Amos Fong
 */
public class TicketStatusOrderComparator
	extends OrderByComparator<TicketStatus> {

	public static final String ORDER_BY_ASC = "Yithro_TicketStatus.order ASC";

	public static final String ORDER_BY_DESC = "Yithro_TicketStatus.order DESC";

	public static final String[] ORDER_BY_FIELDS = {"order"};

	public TicketStatusOrderComparator() {
		this(false);
	}

	public TicketStatusOrderComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(TicketStatus ticketStatus1, TicketStatus ticketStatus2) {
		int value = 0;

		if (ticketStatus1.getOrder() < ticketStatus2.getOrder()) {
			value = -1;
		}
		else if (ticketStatus1.getOrder() > ticketStatus2.getOrder()) {
			value = 1;
		}

		if (_ascending) {
			return value;
		}

		return -value;
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}

		return ORDER_BY_DESC;
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private final boolean _ascending;

}