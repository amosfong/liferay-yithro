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
TicketEntry ticketEntry = (TicketEntry)request.getAttribute(TicketWebKeys.TICKET_ENTRY);
%>

<aui:form method="post" name="fm">
	<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />

	<div class="ticket-details">
		<div>
			<strong><liferay-ui:message key="created" /></strong>

			<div class="form-group">
				<div class="text-secondary">
					<%= fullDateFormatDateTime.format(ticketEntry.getCreateDate()) %>
				</div>
			</div>
		</div>

		<div>
			<strong><liferay-ui:message key="updated" /></strong>

			<div class="form-group">
				<div class="text-secondary">
					<%= fullDateFormatDateTime.format(ticketEntry.getModifiedDate()) %>
				</div>
			</div>
		</div>

		<div>
			<strong><liferay-ui:message key="reporter" /></strong>

			<span id="<portlet:namespace />ticketDetailDisplayActions_reporter">
				<a href="javascript:;" onClick="<portlet:namespace />editTicketDetail('reporter');">
					<aui:icon
						cssClass="icon-monospaced"
						image="pencil"
						markupView="lexicon"
					/>
				</a>
			</span>
			<span class="hide" id="<portlet:namespace />ticketDetailEditActions_reporter">
				<a href="javascript:;" onClick="<portlet:namespace />saveTicketDetail();">
					<aui:icon
						cssClass="icon-monospaced"
						image="check-circle"
						markupView="lexicon"
					/>
				</a>

				<a href="javascript:;" onClick="<portlet:namespace />cancelEditTicketDetail('reporter');">
					<aui:icon
						cssClass="icon-monospaced"
						image="times-circle"
						markupView="lexicon"
					/>
				</a>
			</span>

			<div class="form-group">

				<%
				User reporterUser = UserLocalServiceUtil.getUser(ticketEntry.getUserId());
				%>

				<div class="text-secondary" id="<portlet:namespace />ticketDetailDisplay_reporter">
					<%= HtmlUtil.escape(reporterUser.getFullName()) %>
				</div>

				<div class="hide" id="<portlet:namespace />ticketDetailEdit_reporter">
					<aui:input name="reporterUserId" type="hidden" value="<%= reporterUser.getUserId() %>" />

					<span id="<portlet:namespace />ticketDetailEdit_reporterUserName"><%= HtmlUtil.escape(reporterUser.getFullName()) %></span>

					<aui:button cssClass="mr-3" onClick='<%= renderResponse.getNamespace() + "openUserSelector('reporter');" %>' value="select" />
				</div>
			</div>
		</div>
	</div>
</aui:form>

<aui:script use="aui-base">
	<portlet:namespace />cancelEditTicketDetail = function(detail) {
		A.one('#<portlet:namespace />ticketDetailDisplay_' + detail).show();
		A.one('#<portlet:namespace />ticketDetailDisplayActions_' + detail).show();

		A.one('#<portlet:namespace />ticketDetailEditActions_' + detail).hide();
		A.one('#<portlet:namespace />ticketDetailEdit_' + detail).hide();
	}

	<portlet:namespace />editTicketDetail = function(detail) {
		A.one('#<portlet:namespace />ticketDetailDisplay_' + detail).hide();
		A.one('#<portlet:namespace />ticketDetailDisplayActions_' + detail).hide();

		A.one('#<portlet:namespace />ticketDetailEditActions_' + detail).show();
		A.one('#<portlet:namespace />ticketDetailEdit_' + detail).show();
	}

	<portlet:namespace />openUserSelector = function(detail) {
		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true
				},
				eventName: '<portlet:namespace />selectUser',
				title: '<%= UnicodeLanguageUtil.get(request, "users") %>',
				uri: '<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/ticket_details_display/select_user.jsp" /><portlet:param name="ticketEntryId" value="<%= String.valueOf(ticketEntry.getTicketEntryId()) %>" /></portlet:renderURL>'
			},
			function(event) {
				A.one('#<portlet:namespace />ticketDetailEdit_' + detail + 'UserName').html(event.username);

				A.one('#<portlet:namespace />' + detail + 'UserId').val(event.userid);
			}
		);
	}

	<portlet:namespace />saveTicketDetail = function() {
		var data = Liferay.Util.ns(
			'<portlet:namespace />',
			{
				ticketEntryId: '<%= ticketEntry.getTicketEntryId() %>'
			}
		);

		A.io.request(
			'<portlet:actionURL name="/edit_ticket_entry"><portlet:param name="<%= Constants.CMD %>" value="update_ticket_entry_reporter" /></portlet:actionURL>',
			{
				dataType: 'JSON',
				form: {
					id: '<portlet:namespace />fm',
					upload: true
				},
				method: 'POST',
				on: {
					complete: function(event, id, obj) {
						Liferay.Portlet.refresh('#p_p_id<portlet:namespace />', data);
					},
					success: function(event, id, obj) {
						Liferay.Portlet.refresh('#p_p_id<portlet:namespace />', data);
					}
				}
			}
		);
	}
</aui:script>