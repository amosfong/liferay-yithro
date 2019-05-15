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
String subject = ParamUtil.getString(request, "subject");
String description = ParamUtil.getString(request, "description");
%>

<liferay-ui:error exception="<%= TicketEntryDescriptionException.class %>" message="please-enter-a-description-of-the-issue" />
<liferay-ui:error exception="<%= TicketEntrySubjectException.class %>" message="please-enter-a-summary-of-the-issue" />

<portlet:actionURL name="/add_ticket_entry" var="addTicketEntryURL" />

<aui:form action="<%= addTicketEntryURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input label="summary" name="subject" required="<%= true %>" value="<%= subject %>" />

	<aui:input name="description" type="textarea" value="<%= description %>" wrapperCssClass="lfr-textarea-container" />

	<aui:button type="submit" value="create" />
</aui:form>