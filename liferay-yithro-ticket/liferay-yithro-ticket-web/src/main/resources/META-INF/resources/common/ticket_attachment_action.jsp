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
ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

TicketAttachment ticketAttachment = (TicketAttachment)row.getObject();
%>

<liferay-ui:icon-menu
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<liferay-portlet:resourceURL id="/download_ticket_attachment" varImpl="downloadURL">
		<portlet:param name="ticketAttachmentId" value="<%= String.valueOf(ticketAttachment.getTicketAttachmentId()) %>" />
	</liferay-portlet:resourceURL>

	<liferay-ui:icon
		message="download"
		url="<%= downloadURL.toString() %>"
	/>

	<c:if test="<%= ArrayUtil.contains(yithroTicketConfiguration.ticketAttachmentPreviewExtensions(), FileUtil.getExtension(ticketAttachment.getFileName())) %>">

		<%
		downloadURL.setParameter("preview", String.valueOf(Boolean.TRUE));
		%>

		<liferay-ui:icon
			message="preview"
			target="_blank"
			url="<%= downloadURL.toString() %>"
		/>
	</c:if>

	<portlet:actionURL name="/edit_ticket_attachment" var="deleteURL">
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
		<portlet:param name="ticketAttachmentId" value="<%= String.valueOf(ticketAttachment.getTicketAttachmentId()) %>" />
	</portlet:actionURL>

	<liferay-ui:icon-delete
		confirmation="are-you-sure-you-want-to-delete-this-attachment"
		url="<%= deleteURL %>"
	/>
</liferay-ui:icon-menu>