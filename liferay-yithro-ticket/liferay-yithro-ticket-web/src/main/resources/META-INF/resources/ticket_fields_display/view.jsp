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

<%@ include file="/ticket_fields_display/init.jsp" %>

<%
TicketEntry ticketEntry = (TicketEntry)request.getAttribute(TicketWebKeys.TICKET_ENTRY);
%>

<div class="ticket-fields">

	<%
	for (long ticketFieldId : ticketFieldIds) {
		TicketField ticketField = TicketFieldLocalServiceUtil.fetchTicketField(ticketFieldId);

		if ((ticketField == null) || (ticketField.getStatus() != WorkflowConstants.STATUS_APPROVED)) {
			continue;
		}
	%>

		<h4>
			<%= HtmlUtil.escape(ticketField.getName(locale)) %>

			<a href="javascript:;" onClick="<portlet:namespace />editTicketField('<%= ticketFieldId %>');">
				<aui:icon
					image="pencil"
					markupView="lexicon"
				/>
			</a>
		</h4>

		<div class="form-group">

			<%
			TicketFieldData ticketFieldData = TicketFieldDataLocalServiceUtil.fetchTicketFieldData(ticketEntry.getTicketEntryId(), ticketFieldId);
			%>

			<div class="text-secondary" id="<portlet:namespace />ticketFieldDisplay_<%= ticketFieldId %>">
				<c:choose>
					<c:when test="<%= ticketFieldData != null %>">
						<%= HtmlUtil.escape(ticketFieldData.getData()) %>
					</c:when>
					<c:otherwise>
						N/A
					</c:otherwise>
				</c:choose>
			</div>

			<div class="hide" id="<portlet:namespace />ticketFieldEdit_<%= ticketFieldId %>">
				<aui:input inlineField="<%= true %>" label="" name='<%= "ticketFieldIdData_" + ticketFieldId %>' value="<%= (ticketFieldData != null) ? ticketFieldData.getData() : StringPool.BLANK %>" />

				<a href="javascript:;" onClick="<portlet:namespace />saveTicketField('<%= ticketFieldId %>');">
					<aui:icon
						cssClass="icon-monospaced"
						image="check-circle"
						markupView="lexicon"
					/>
				</a>

				<a href="javascript:;" onClick="<portlet:namespace />cancelEditTicketField('<%= ticketFieldId %>');">
					<aui:icon
						cssClass="icon-monospaced"
						image="times-circle"
						markupView="lexicon"
					/>
				</a>
			</div>
		</div>

	<%
	}
	%>

</div>

<aui:script use="aui-io-request">
	<portlet:namespace />cancelEditTicketField = function(ticketFieldId) {
		A.one('#<portlet:namespace />ticketFieldDisplay_' + ticketFieldId).show();

		A.one('#<portlet:namespace />ticketFieldEdit_' + ticketFieldId).hide();
	}

	<portlet:namespace />editTicketField = function(ticketFieldId) {
		A.one('#<portlet:namespace />ticketFieldDisplay_' + ticketFieldId).hide();

		A.one('#<portlet:namespace />ticketFieldEdit_' + ticketFieldId).show();
	}

	<portlet:namespace />saveTicketField = function(ticketFieldId) {
		var ticketFieldDataElement = A.one('#<portlet:namespace />ticketFieldIdData_' + ticketFieldId);

		A.io.request(
			'<portlet:actionURL name="/edit_ticket_field_data" />',
			{
				dataType: 'JSON',
				data: Liferay.Util.ns(
					'<portlet:namespace />',
					{
						ticketEntryId: '<%= ticketEntry.getTicketEntryId() %>',
						ticketFieldId: ticketFieldId,
						data: ticketFieldDataElement.val()
					}
				),
				on: {
					success: function(event, id, obj) {
						A.one('#<portlet:namespace />ticketFieldDisplay_' + ticketFieldId).html(ticketFieldDataElement.val());

						<portlet:namespace />cancelEditTicketField(ticketFieldId);
					}
				}
			}
		);
	}
</aui:script>