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

<%@ include file="/init.jsp" %>

<%
TicketEntry ticketEntry = (TicketEntry)request.getAttribute(TicketWebKeys.TICKET_ENTRY);
%>

<portlet:actionURL name="/edit_ticket_entry" var="editTicketEntryURL" />

<aui:form action="<%= editTicketEntryURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />

	<aui:fieldset>
		<aui:input label="summary" name="subject" required="<%= true %>" value="<%= ticketEntry.getSubject() %>" />

		<aui:input name="description" type="textarea" value="<%= ticketEntry.getDescription() %>" wrapperCssClass="lfr-textarea-container" />
	</aui:fieldset>

	<aui:button type="submit" value="save" />
</aui:form>