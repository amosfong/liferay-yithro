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

SupportTeam supportTeam = (SupportTeam)request.getAttribute(SupportWebKeys.SUPPORT_TEAM);

long supportTeamId = BeanParamUtil.getLong(supportTeam, request, "supportTeamId");

renderResponse.setTitle((supportTeam == null) ? LanguageUtil.get(request, "new-support-team") : supportTeam.getName());
%>

<portlet:actionURL name="/ticket_support/edit_support_team" var="editSupportTeamURL" />

<aui:form action="<%= editSupportTeamURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="supportTeamId" type="hidden" value="<%= supportTeamId %>" />

	<liferay-ui:error exception="<%= SupportTeamNameException.class %>" message="please-enter-a-valid-name" />

	<aui:model-context bean="<%= supportTeam %>" model="<%= SupportTeam.class %>" />

	<aui:fieldset-group>
		<aui:fieldset>
			<aui:input name="name" />

			<aui:input name="description" />

			<aui:input disabled="<%= true %>" name="assignedWork" />

			<aui:input name="maxWork" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>