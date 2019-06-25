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
String tabs2 = ParamUtil.getString(request, "tabs2", "active");
%>

<clay:navigation-bar
	navigationItems="<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(tabs2.equals("active"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs2", "active");
						navigationItem.setLabel(LanguageUtil.get(request, "active"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs2.equals("inactive"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs2", "inactive");
						navigationItem.setLabel(LanguageUtil.get(request, "inactive"));
					});
			}
		}
	%>"
/>

<clay:management-toolbar
	creationMenu='<%=
		new JSPCreationMenu(pageContext) {
			{
				addDropdownItem(
					dropdownItem -> {
						dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/ticket_configuration/edit_ticket_field", "redirect", PortalUtil.getCurrentURL(request));
						dropdownItem.setLabel(LanguageUtil.get(request, "new-ticket-field"));
					});
			}
		}
	%>'
	selectable="<%= false %>"
	showSearch="<%= false %>"
/>

<div class="container-fluid-1280">

	<%
	int status = WorkflowConstants.STATUS_APPROVED;

	if (tabs2.equals("inactive")) {
		status = WorkflowConstants.STATUS_INACTIVE;
	}
	%>

	<liferay-ui:search-container
		emptyResultsMessage="no-ticket-fields-were-found"
		headerNames="name,description,type,visibility,status,"
		iteratorURL="<%= renderResponse.createRenderURL() %>"
		total="<%= TicketFieldLocalServiceUtil.getTicketFieldsCount(status) %>"
	>
		<liferay-ui:search-container-results
			results="<%= TicketFieldLocalServiceUtil.getTicketFields(status, searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.yithro.ticket.model.TicketField"
			escapedModel="<%= true %>"
			keyProperty="ticketFieldId"
			modelVar="ticketField"
		>
			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcRenderCommandName" value="/ticket_configuration/edit_ticket_field" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="ticketFieldId" value="<%= String.valueOf(ticketField.getTicketFieldId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="name"
				value="<%= ticketField.getName(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="description"
				value="<%= ticketField.getDescription(locale) %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="type"
				translate="<%= true %>"
				value="<%= ticketField.getTypeLabel() %>"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="visibility"
				translate="<%= true %>"
				value="<%= ticketField.getVisibilityLabel() %>"
			/>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/ticket_configuration/ticket_field_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>