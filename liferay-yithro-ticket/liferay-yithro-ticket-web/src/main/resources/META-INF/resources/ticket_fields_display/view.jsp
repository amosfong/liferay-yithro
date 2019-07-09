<%--
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
--%>

<%@ include file="/ticket_fields_display/init.jsp" %>

<%
TicketEntry ticketEntry = (TicketEntry)request.getAttribute(TicketWebKeys.TICKET_ENTRY);
%>

<div class="ticket-fields">

	<%
	for (long ticketFieldId : ticketFieldIds) {
		TicketField ticketField = TicketFieldLocalServiceUtil.fetchTicketField(ticketFieldId);

		if ((ticketField == null) || (ticketField.getStatus() != WorkflowConstants.STATUS_APPROVED)) {
			continue;
		}
	%>

		<h4>
			<%= HtmlUtil.escape(ticketField.getName(locale)) %>
		</h4>

		<div class="form-group">

			<%
			TicketFieldData ticketFieldData = TicketFieldDataLocalServiceUtil.fetchTicketFieldData(ticketEntry.getTicketEntryId(), ticketFieldId);
			%>

			<c:choose>
				<c:when test="<%= ticketFieldData != null %>">
					<%= HtmlUtil.escape(ticketFieldData.getData()) %>
				</c:when>
				<c:otherwise>
					N/A
				</c:otherwise>
			</c:choose>
		</div>

	<%
	}
	%>

</div>