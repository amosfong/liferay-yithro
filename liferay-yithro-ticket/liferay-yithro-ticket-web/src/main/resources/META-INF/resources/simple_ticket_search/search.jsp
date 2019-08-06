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
String keywords = ParamUtil.getString(request, "keywords");
%>

<liferay-ui:search-container
	emptyResultsMessage="no-tickets-were-found"
	iteratorURL="<%= renderResponse.createRenderURL() %>"
>

	<%
	Hits hits = TicketEntryLocalServiceUtil.search(themeDisplay.getCompanyId(), keywords, searchContainer.getStart(), searchContainer.getEnd(), null);

	searchContainer.setTotal(hits.getLength());
	searchContainer.setResults(hits.toList());
	%>

	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.search.Document"
		keyProperty="entryClassPK"
		modelVar="document"
	>

		<%
		long ticketEntryId = GetterUtil.getLong(document.get("ticketEntryId"));
		%>

		<portlet:renderURL var="rowURL">
			<portlet:param name="mvcRenderCommandName" value="/view_ticket_entry" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="ticketEntryId" value="<%= String.valueOf(ticketEntryId) %>" />
		</portlet:renderURL>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="ticket-number"
			value='<%= "TICKET-" + document.get("ticketNumber") %>'
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="summary"
			value='<%= document.get("summary") %>'
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="status"
		>

			<%
			long ticketStatusId = GetterUtil.getLong(document.get("ticketStatusId"));

			TicketStatus ticketStatus = TicketStatusLocalServiceUtil.getTicketStatus(ticketStatusId);
			%>

			<%= HtmlUtil.escape(ticketStatus.getName(locale)) %>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		markupView="lexicon"
	/>
</liferay-ui:search-container>