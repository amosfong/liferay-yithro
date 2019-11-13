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

List<NavigationItem> navigationItems = new ArrayList<>();

NavigationItem entriesNavigationItem = new NavigationItem();

entriesNavigationItem.setActive(true);
entriesNavigationItem.setHref(StringPool.BLANK);
entriesNavigationItem.setLabel(LanguageUtil.get(request, "workers"));

navigationItems.add(entriesNavigationItem);
%>

<clay:navigation-bar
	inverted="<%= true %>"
	navigationItems="<%= navigationItems %>"
/>

<%
EditSupportTeamWorkersManagementToolbarDisplayContext editSupportTeamWorkersManagementToolbarDisplayContext = new EditSupportTeamWorkersManagementToolbarDisplayContext(request, renderRequest, renderResponse, "/ticket_support/edit_support_team_workers");

SearchContainer searchContainer = editSupportTeamWorkersManagementToolbarDisplayContext.getSearchContainer();

PortletURL portletURL = editSupportTeamWorkersManagementToolbarDisplayContext.getPortletURL();
%>

<clay:management-toolbar
	actionDropdownItems="<%= editSupportTeamWorkersManagementToolbarDisplayContext.getActionDropdownItems() %>"
	clearResultsURL="<%= editSupportTeamWorkersManagementToolbarDisplayContext.getClearResultsURL() %>"
	componentId="editSupportTeamWorkersManagementToolbar"
	filterDropdownItems="<%= editSupportTeamWorkersManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= searchContainer.getTotal() %>"
	searchActionURL="<%= editSupportTeamWorkersManagementToolbarDisplayContext.getSearchActionURL() %>"
	searchContainerId="users"
	searchFormName="searchFm"
	selectable="<%= true %>"
	showCreationMenu="<%= true %>"
	showSearch="<%= true %>"
	sortingOrder="<%= searchContainer.getOrderByType() %>"
	sortingURL="<%= editSupportTeamWorkersManagementToolbarDisplayContext.getSortingURL() %>"
/>

<aui:form action="<%= portletURL.toString() %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="supportTeamId" type="hidden" value="<%= supportTeam.getSupportTeamId() %>" />
	<aui:input name="addUserIds" type="hidden" />
	<aui:input name="removeUserIds" type="hidden" />

	<div id="breadcrumb">
		<liferay-ui:breadcrumb
			showCurrentGroup="<%= false %>"
			showGuestGroup="<%= false %>"
			showLayout="<%= false %>"
			showPortletBreadcrumb="<%= true %>"
		/>
	</div>

	<liferay-ui:search-container
		id="users"
		searchContainer="<%= searchContainer %>"
		var="userSearchContainer"
	>
		<liferay-ui:search-container-row
			className="com.liferay.portal.kernel.model.User"
			escapedModel="<%= true %>"
			keyProperty="userId"
			modelVar="user2"
			rowIdProperty="screenName"
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
				<portlet:actionURL name="/ticket_support/edit_support_team_workers" var="deleteSupportTeamWorkersURL">
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="supportTeamId" value="<%= String.valueOf(supportTeamId) %>" />
					<portlet:param name="removeUserIds" value="<%= String.valueOf(user2.getUserId()) %>" />
				</portlet:actionURL>

				<liferay-ui:icon
					icon="minus-circle"
					linkCssClass="table-action-link"
					markupView="lexicon"
					message="remove"
					url="<%= deleteSupportTeamWorkersURL %>"
				/>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator
			markupView="lexicon"
		/>
	</liferay-ui:search-container>
</aui:form>

<aui:script use="liferay-item-selector-dialog">
	var form = document.<portlet:namespace />fm;

	<portlet:renderURL var="selectUsersURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
		<portlet:param name="mvcRenderCommandName" value="/ticket_support/select_support_team_workers" />
		<portlet:param name="supportTeamId" value="<%= String.valueOf(supportTeamId) %>" />
	</portlet:renderURL>

	function <portlet:namespace />addUsers(event) {
		var itemSelectorDialog = new A.LiferayItemSelectorDialog({
			eventName: '<portlet:namespace />selectUsers',
			on: {
				selectedItemChange: function(event) {
					var selectedItem = event.newVal;

					if (selectedItem) {
						Liferay.Util.postForm(form, {
							data: {
								addUserIds: selectedItem
							},
							url: '<portlet:actionURL name="/ticket_support/edit_support_team_workers" />'
						});
					}
				}
			},
			title: '<liferay-ui:message arguments="<%= HtmlUtil.escape(supportTeam.getName()) %>" key="add-users-to-x" />',
			url: '<%= selectUsersURL %>'
		});

		itemSelectorDialog.open();
	}

	function <portlet:namespace />removeUsers() {
		Liferay.Util.postForm(form, {
			data: {
				redirect: '<%= portletURL.toString() %>',
				removeUserIds: Liferay.Util.listCheckedExcept(
					form,
					'<portlet:namespace />allRowIds'
				)
			},
			url: '<portlet:actionURL name="/ticket_support/edit_support_team_workers" />'
		});
	}

	Liferay.componentReady('editSupportTeamWorkersManagementToolbar').then(
		function(managementToolbar) {
			managementToolbar.on(
				'actionItemClicked',
				<portlet:namespace />removeUsers
			);
			managementToolbar.on(
				'creationButtonClicked',
				<portlet:namespace />addUsers
			);
		}
	);
</aui:script>