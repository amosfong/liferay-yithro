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
String redirect = ParamUtil.getString(request, "redirect");

TicketStatus ticketStatus = (TicketStatus)request.getAttribute(TicketWebKeys.TICKET_STATUS);

long ticketStatusId = BeanParamUtil.getLong(ticketStatus, request, "ticketStatusId");

renderResponse.setTitle((ticketStatus == null) ? LanguageUtil.get(request, "new-ticket-status") : ticketStatus.getName(locale));
%>

<portlet:actionURL name="/ticket_configuration/edit_ticket_status" var="editTicketStatusURL" />

<aui:form action="<%= editTicketStatusURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="ticketStatusId" type="hidden" value="<%= ticketStatusId %>" />

	<liferay-ui:error exception="<%= TicketStatusNameException.class %>" message="please-enter-a-valid-name" />

	<aui:model-context bean="<%= ticketStatus %>" model="<%= TicketStatus.class %>" />

	<aui:fieldset-group>
		<aui:fieldset>
			<aui:input name="name" />

			<aui:input name="description" />

			<aui:input name="order" />

			<aui:input name="terminal" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>