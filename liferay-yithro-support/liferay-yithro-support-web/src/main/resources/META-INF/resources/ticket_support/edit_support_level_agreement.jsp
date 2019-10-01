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

SupportLevelAgreement supportLevelAgreement = (SupportLevelAgreement)request.getAttribute(SupportWebKeys.SUPPORT_LEVEL_AGREEMENT);

long supportLevelAgreementId = BeanParamUtil.getLong(supportLevelAgreement, request, "supportLevelAgreementId");

renderResponse.setTitle((supportLevelAgreement == null) ? LanguageUtil.get(request, "new-service-level-agreement") : supportLevelAgreement.getName());
%>

<portlet:actionURL name="/ticket_support/edit_support_level_agreement" var="editSupportLevelAgreementURL" />

<aui:form action="<%= editSupportLevelAgreementURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="supportLevelAgreementId" type="hidden" value="<%= supportLevelAgreementId %>" />

	<liferay-ui:error exception="<%= SupportLevelAgreementNameException.class %>" message="please-enter-a-valid-name" />

	<aui:model-context bean="<%= supportLevelAgreement %>" model="<%= SupportLevelAgreement.class %>" />

	<aui:fieldset-group>
		<aui:fieldset>
			<aui:input name="name" />

			<aui:input name="description" />
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>