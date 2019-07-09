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
TicketComment ticketComment = (TicketComment)request.getAttribute(TicketWebKeys.TICKET_COMMENT);
%>

<portlet:actionURL name="/edit_ticket_comment" var="editTicketCommentURL" />

<aui:form action="<%= editTicketCommentURL %>" cssClass="container-fluid-1280" method="post" name="commentFm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveComment();" %>'>
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="ticketCommentId" type="hidden" value="<%= ticketComment.getTicketCommentId() %>" />
	<aui:input name="body" type="hidden" value="" />

	<aui:fieldset>
		<liferay-ui:input-editor
			contents="<%= ticketComment.getBody() %>"
			cssClass="form-control"
			editorName="alloyeditor"
			name="bodyEditor"
			placeholder="compose-your-public-message-here"
		/>
	</aui:fieldset>

	<aui:button type="submit" value="update" />
</aui:form>

<aui:script>
	<portlet:namespace />saveComment = function() {
		Liferay.Util.postForm(
			document.<portlet:namespace />commentFm,
			{
				data: {
					body: window.<portlet:namespace />bodyEditor.getHTML(),
					format: '<%= TicketCommentFormat.HTML %>'
				}
			}
		);
	}
</aui:script>