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
String tabs1 = ParamUtil.getString(request, "tabs1", "ticket-statuses");
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%=
		new JSPNavigationItemList(pageContext) {
			{
				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("ticket-statuses"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "ticket-statuses");
						navigationItem.setLabel(LanguageUtil.get(request, "ticket-statuses"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("ticket-fields"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "ticket-fields");
						navigationItem.setLabel(LanguageUtil.get(request, "ticket-fields"));
					});

				add(
					navigationItem -> {
						navigationItem.setActive(tabs1.equals("ticket-structures"));
						navigationItem.setHref(renderResponse.createRenderURL(), "tabs1", "ticket-structures");
						navigationItem.setLabel(LanguageUtil.get(request, "ticket-structures"));
					});
			}
		}
	%>"
/>

<c:choose>
	<c:when test='<%= tabs1.equals("ticket-statuses") %>'>
		<liferay-util:include page="/ticket_configuration/view_ticket_statuses.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= tabs1.equals("ticket-structures") %>'>
		<liferay-util:include page="/ticket_configuration/view_ticket_structures.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:otherwise>
		<liferay-util:include page="/ticket_configuration/view_ticket_fields.jsp" servletContext="<%= application %>" />
	</c:otherwise>
</c:choose>