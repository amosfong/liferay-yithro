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
						dropdownItem.setHref(renderResponse.createRenderURL(), "mvcRenderCommandName", "/ticket_support/edit_support_level_agreement", "redirect", PortalUtil.getCurrentURL(request));
						dropdownItem.setLabel(LanguageUtil.get(request, "new-service-level-agreement"));
					});
			}
		}
	%>'
	selectable="<%= false %>"
	showSearch="<%= false %>"
/>

<div class="container-fluid-1280">
	<liferay-ui:search-container
		emptyResultsMessage="no-service-level-agreements-were-found"
		headerNames="name,description,"
		iteratorURL="<%= renderResponse.createRenderURL() %>"
		total="<%= SupportLevelAgreementLocalServiceUtil.getSupportLevelAgreementsCount() %>"
	>
		<liferay-ui:search-container-results
			results="<%= SupportLevelAgreementLocalServiceUtil.getSupportLevelAgreements(searchContainer.getStart(), searchContainer.getEnd()) %>"
		/>

		<liferay-ui:search-container-row
			className="com.liferay.yithro.support.model.SupportLevelAgreement"
			escapedModel="<%= true %>"
			keyProperty="supportLevelAgreementId"
			modelVar="supportLevelAgreement"
		>
			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcRenderCommandName" value="/ticket_support/edit_support_level_agreement" />
				<portlet:param name="redirect" value="<%= currentURL %>" />
				<portlet:param name="supportLevelAgreementId" value="<%= String.valueOf(supportLevelAgreement.getSupportLevelAgreementId()) %>" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				property="name"
			/>

			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				property="description"
			/>

			<liferay-ui:search-container-column-jsp
				align="right"
				path="/ticket_support/support_level_agreement_action.jsp"
			/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</div>