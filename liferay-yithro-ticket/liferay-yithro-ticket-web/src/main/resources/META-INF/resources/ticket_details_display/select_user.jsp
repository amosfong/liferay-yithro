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

<%@ include file="/ticket_details_display/init.jsp" %>

<%
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("mvcPath", "/ticket_details_display/select_user.jsp");
portletURL.setParameter("ticketEntryId", ParamUtil.getString(request, "ticketEntryId"));

UserSearch userSearch = new UserSearch(renderRequest, portletURL);
%>

<clay:management-toolbar
	displayContext="<%= new SelectUserManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, userSearch) %>"
/>

<aui:form cssClass="container-fluid-1280" name="selectUserFm">
	<liferay-ui:search-container
		id="users"
		searchContainer="<%= userSearch %>"
	>
		<liferay-ui:user-search-container-results
			userParams="<%= new LinkedHashMap<String, Object>() %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.User"
			escapedModel="<%= true %>"
			keyProperty="userId"
			modelVar="user2"
		>
			<liferay-ui:search-container-column-text
				name="name"
				property="fullName"
			/>

			<liferay-ui:search-container-column-text
				name="screen-name"
				property="screenName"
			/>

			<liferay-ui:search-container-column-text
				name="email-address"
				property="emailAddress"
			/>

			<liferay-ui:search-container-column-text>

				<%
				Map<String, Object> data = new HashMap<String, Object>();

				data.put("entityid", user2.getUserId());
				data.put("userid", user2.getUserId());
				data.put("username", user2.getFullName());
				%>

				<aui:button cssClass="selector-button" data="<%= data %>" value="select" />
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script>
	Liferay.Util.selectEntityHandler('#<portlet:namespace />selectUserFm', '<portlet:namespace />selectUser');
</aui:script>