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

int visibility = ParamUtil.getInteger(request, "visibility");

List<TicketAttachment> ticketAttachments = TicketAttachmentLocalServiceUtil.getTicketAttachments(ticketEntry.getTicketEntryId(), userVisibilities, WorkflowConstants.STATUS_APPROVED);
%>

<liferay-ui:error exception="<%= DuplicateTicketAttachmentException.class %>" message="please-enter-a-unique-document-name" />
<liferay-ui:error exception="<%= FileNameException.class %>" message="please-enter-a-file-with-a-valid-file-name" />
<liferay-ui:error exception="<%= TicketAttachmentSizeException.MustNotBeEmpty.class %>" message="please-upload-a-file-that-contains-data" />
<liferay-ui:error exception="<%= TicketAttachmentSizeException.MustNotExceedMaximumSize.class %>" message="please-upload-a-file-less-than-100-mb" />
<liferay-ui:error exception="<%= TicketAttachmentVisibilityException.class %>" message="please-enter-a-valid-visibility" />

<liferay-ui:search-container
	emptyResultsMessage="there-are-no-attachments"
	total="<%= ticketAttachments.size() %>"
>
	<liferay-ui:search-container-results
		results="<%= ticketAttachments %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.yithro.ticket.model.TicketAttachment"
		escapedModel="<%= true %>"
		keyProperty="ticketAttachmentId"
		modelVar="ticketAttachment"
	>
		<portlet:resourceURL id="/download_ticket_attachment" var="rowURL">
			<portlet:param name="ticketAttachmentId" value="<%= String.valueOf(ticketAttachment.getTicketAttachmentId()) %>" />
		</portlet:resourceURL>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="file-name"
			value="<%= ticketAttachment.getFileName() %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="size"
			value="<%= TextFormatter.formatStorageSize((double)ticketAttachment.getFileSize(), locale) %>"
		/>

		<liferay-ui:search-container-column-text
			href="<%= rowURL %>"
			name="attached-by"
			value="<%= ticketAttachment.getUserName() %>"
		/>

		<liferay-ui:search-container-column-date
			href="<%= rowURL %>"
			name="attached-date"
			value="<%= ticketAttachment.getCreateDate() %>"
		/>

		<c:if test="<%= userVisibilities.length > 1 %>">
			<liferay-ui:search-container-column-text
				href="<%= rowURL %>"
				name="visibility"
				translate="<%= true %>"
				value="<%= ticketAttachment.getVisibilityLabel() %>"
			/>
		</c:if>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/common/ticket_attachment_action.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		markupView="lexicon"
		paginate="<%= false %>"
	/>
</liferay-ui:search-container>

<portlet:actionURL name="/edit_ticket_attachment" var="addTicketAttachmentURL" />

<aui:form action="<%= addTicketAttachmentURL %>" method="post" name="fm2">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
	<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />

	<aui:fieldset>
		<div class="sheet-title">
			<liferay-ui:message key="add-attachment" />
		</div>

		<aui:input name="file" type="file" />

		<aui:select name="visibility">

			<%
			for (int curVisibility : userVisibilities) {
			%>

				<aui:option label="<%= Visibilities.getLabel(curVisibility) %>" selected="<%= curVisibility == visibility %>" value="<%= curVisibility %>" />

			<%
			}
			%>

		</aui:select>
	</aui:fieldset>

	<aui:button type="submit" value="save" />
</aui:form>