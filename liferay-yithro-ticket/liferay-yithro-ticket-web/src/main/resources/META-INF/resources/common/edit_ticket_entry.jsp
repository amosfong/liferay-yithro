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

TicketEntry ticketEntry = (TicketEntry)request.getAttribute(TicketWebKeys.TICKET_ENTRY);

int[] userVisibilities = {Visibilities.PUBLIC, Visibilities.WORKER};

List<TicketAttachment> ticketAttachments = TicketAttachmentLocalServiceUtil.getTicketAttachments(ticketEntry.getTicketEntryId(), userVisibilities, WorkflowConstants.STATUS_APPROVED);
List<TicketLink> ticketLinks = TicketLinkLocalServiceUtil.getTicketLinks(ticketEntry.getTicketEntryId(), userVisibilities);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= "TICKET-" + ticketEntry.getTicketNumber() %>'
/>

<h1>
	<%= HtmlUtil.escape(ticketEntry.getSubject()) %>
</h1>

<liferay-ui:tabs
	names='<%= "description," + LanguageUtil.format(request, "attachments-x", ticketAttachments.size()) + "," + LanguageUtil.format(request, "links-x", ticketLinks.size()) %>'
	refresh="<%= false %>"
>
	<liferay-ui:section>
		<div>
			<%= HtmlUtil.escape(ticketEntry.getDescription()) %>
		</div>
	</liferay-ui:section>

	<liferay-ui:section>
		attachments
	</liferay-ui:section>

	<liferay-ui:section>
		links
	</liferay-ui:section>
</liferay-ui:tabs>

<liferay-ui:tabs
	names="public"
	refresh="<%= false %>"
>
	<liferay-ui:section>
		<portlet:actionURL name="/add_ticket_comment" var="addTicketCommentURL" />

		<aui:form action="<%= addTicketCommentURL %>" name="commentFm">
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
			<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />
			<aui:input name="visibility" type="hidden" value="<%= Visibilities.PUBLIC %>" />

			<aui:input label="" name="body" placeholder="compose-your-public-message-here" type="textarea" />

			<aui:button type="submit" value="post" />
		</aui:form>

		<%
		List<TicketComment> ticketComments = TicketCommentLocalServiceUtil.getTicketComments(ticketEntry.getTicketEntryId(), new int[] {Visibilities.PUBLIC}, new int[] {WorkflowConstants.STATUS_APPROVED});

		for (TicketComment ticketComment : ticketComments) {
		%>

			<div>
				<div class="user-name">
					<%= ticketComment.getUserName() %>
				</div>

				<div class="post-date">
					<%= fullDateFormatDateTime.format(ticketComment.getCreateDate()) %>
				</div>

				<p>
					<%= ticketComment.getBody() %>
				</p>
			</div>

		<%
		}
		%>

	</liferay-ui:section>
</liferay-ui:tabs>