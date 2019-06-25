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

<clay:management-toolbar
	creationMenu='<%=
		new JSPCreationMenu(pageContext) {
			{
				addDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/ticket_configuration/edit_ticket_status", "redirect", PortalUtil.getCurrentURL(request));
						dropdownItem.setLabel(LanguageUtil.get(request, "new-ticket-status"));
					});
			}
		}
	%>'
	selectable="<%= false %>"
	showSearch="<%= false %>"
/>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		emptyResultsMessage="no-ticket-statuses-were-found"
		headerNames=",name,description,terminal,status,"
		iteratorURL="<%= renderResponse.createRenderURL() %>"
		total="<%= TicketStatusLocalServiceUtil.getTicketStatusesCount() %>"
	>
		<liferay-ui:search-container-results
			results="<%= TicketStatusLocalServiceUtil.getTicketStatuses(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.yithro.ticket.model.TicketStatus"
			escapedModel="<%= true %>"
			keyProperty="ticketStatusId"
			modelVar="ticketStatus"
		>
			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcRenderCommandName" value="/ticket_configuration/edit_ticket_status" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="ticketStatusId" value="<%= String.valueOf(ticketStatus.getTicketStatusId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				value="<%= String.valueOf(ticketStatus.getOrder()) %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="name"
				value="<%= ticketStatus.getName(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="description"
				value="<%= ticketStatus.getDescription(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="terminal"
			>
				<c:if test="<%= ticketStatus.isTerminal() %>">
					<liferay-ui:message key="yes" />
				</c:if>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-status
				href="<%= rowURL %>"
				name="status"
				status="<%= ticketStatus.getStatus() %>"
			/>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/ticket_configuration/ticket_status_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>