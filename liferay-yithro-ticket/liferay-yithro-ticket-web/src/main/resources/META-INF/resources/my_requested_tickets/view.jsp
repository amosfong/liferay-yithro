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
String tabs1 = ParamUtil.getString(request, "tabs1");

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("tabs1", tabs1);
%>

<liferay-ui:tabs
	names="open,closed"
	url="<%= portletURL.toString() %>"
>

	<%
	long[] ticketStatusIds = null;

	if (tabs1.equals("closed")) {
		List<TicketStatus> ticketStatuses = TicketStatusLocalServiceUtil.getTicketStatuses(true, WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		ticketStatusIds = ListUtil.toLongArray(ticketStatuses, TicketStatus.TICKET_STATUS_ID_ACCESSOR);
	}
	else {
		List<TicketStatus> ticketStatuses = TicketStatusLocalServiceUtil.getTicketStatuses(false, WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		ticketStatusIds = ListUtil.toLongArray(ticketStatuses, TicketStatus.TICKET_STATUS_ID_ACCESSOR);
	}
	%>

	<liferay-ui:search-container
		emptyResultsMessage="no-tickets-were-found"
		headerNames="subject,description,status"
		iteratorURL="<%= renderResponse.createRenderURL() %>"
		total="<%= TicketEntryLocalServiceUtil.getTicketEntriesCount(themeDisplay.getUserId(), ticketStatusIds) %>"
	>
		<liferay-ui:search-container-results
			results="<%= TicketEntryLocalServiceUtil.getTicketEntries(themeDisplay.getUserId(), ticketStatusIds, searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.yithro.ticket.model.TicketEntry"
			escapedModel="<%= true %>"
			keyProperty="ticketEntryId"
			modelVar="ticketEntry"
		>
			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcRenderCommandName" value="/edit_ticket_entry" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="ticketEntryId" value="<%= String.valueOf(ticketEntry.getTicketEntryId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="ticket-number"
				value='<%= "TICKET-" + ticketEntry.getTicketNumber() %>'
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="subject"
				value="<%= ticketEntry.getSubject() %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="description"
				value="<%= ticketEntry.getDescription() %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="status"
			>

				<%
				TicketStatus ticketStatus = ticketEntry.getTicketStatus();
				%>

				<%= HtmlUtil.escape(ticketStatus.getName(locale)) %>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</liferay-ui:tabs>