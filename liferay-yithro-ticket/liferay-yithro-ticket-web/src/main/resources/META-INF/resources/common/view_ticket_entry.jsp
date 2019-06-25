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

TicketStatus ticketStatus = ticketEntry.getTicketStatus();

TicketStatus nextTicketStatus = TicketStatusLocalServiceUtil.getNextTicketStatus(ticketStatus.getTicketStatusId(), WorkflowConstants.STATUS_APPROVED);

List<TicketAttachment> ticketAttachments = TicketAttachmentLocalServiceUtil.getTicketAttachments(ticketEntry.getTicketEntryId(), userVisibilities, WorkflowConstants.STATUS_APPROVED);
List<TicketLink> ticketLinks = TicketLinkLocalServiceUtil.getTicketLinks(ticketEntry.getTicketEntryId(), userVisibilities);
%>

<liferay-ui:header
	backURL="<%= redirect %>"
	title='<%= "TICKET-" + ticketEntry.getTicketNumber() %>'
/>

<div class="widget-mode-simple">
	<div class="autofit-row">
		<div class="autofit-col autofit-col-expand">
			<h1>
				<%= HtmlUtil.escape(ticketEntry.getSubject()) %>
			</h1>
		</div>

		<div class="autofit-col">
			<clay:dropdown-actions
				dropdownItems="<%=
					new JSPDropdownItemList(pageContext) {
						{
							PortletURL editTicketEntryURL = renderResponse.createRenderURL();

							editTicketEntryURL.setParameter("mvcRenderCommandName", "/edit_ticket_entry");
							editTicketEntryURL.setParameter("redirect", PortalUtil.getCurrentURL(request));
							editTicketEntryURL.setParameter("ticketEntryId", String.valueOf(ticketEntry.getTicketEntryId()));
							editTicketEntryURL.setWindowState(LiferayWindowState.POP_UP);

							add(
								dropdownItem -> {
									dropdownItem.setHref("javascript:" + renderResponse.getNamespace() + "openDialog('" + LanguageUtil.get(request, "edit-ticket") + "', '" + editTicketEntryURL.toString() + "');");
									dropdownItem.setLabel(LanguageUtil.get(request, "edit"));
								});
						}
					}
				%>"
			/>
		</div>
	</div>

	<div class="widget-metadata">
		<div class="text-secondary">
			<label><liferay-ui:message key="created" />:</label>

			<%= fullDateFormatDateTime.format(ticketEntry.getCreateDate()) %>

			<label><liferay-ui:message key="status" />:</label>

			<span class="<%= Validator.isNotNull(ticketStatus.getDescription(locale)) ? "lfr-portal-tooltip" : "" %>" data-title="<%= HtmlUtil.escape(ticketStatus.getDescription(locale)) %>">
				<%= HtmlUtil.escape(ticketStatus.getName(locale)) %>
			</span>

			<c:if test="<%= !ticketStatus.isTerminal() %>">
				<a href="javascript:;" onClick="<portlet:namespace />progressStatus();">
					<aui:icon image="caret-right" markupView="lexicon" message="<%= nextTicketStatus.getName(locale) %>" />
				</a>
			</c:if>
		</div>
	</div>

	<liferay-ui:tabs
		names='<%= "description," + LanguageUtil.format(request, "attachments-x", ticketAttachments.size()) + "," + LanguageUtil.format(request, "links-x", ticketLinks.size()) %>'
		refresh="<%= false %>"
	>
		<liferay-ui:section>
			<div class="sheet">
				<div class="sheet-text">
					<%= HtmlUtil.escape(ticketEntry.getDescription()) %>
				</div>
			</div>
		</liferay-ui:section>

		<liferay-ui:section>
			<div class="sheet">
				<div class="sheet-text">
					<liferay-util:include page="/common/edit_ticket_entry_attachments.jsp" servletContext="<%= application %>" />
				</div>
			</div>
		</liferay-ui:section>

		<liferay-ui:section>
			<div class="sheet">
				<div class="sheet-text">
					<liferay-util:include page="/common/edit_ticket_entry_links.jsp" servletContext="<%= application %>" />
				</div>
			</div>
		</liferay-ui:section>
	</liferay-ui:tabs>

	<liferay-ui:tabs
		names="conversation"
		refresh="<%= false %>"
	>
		<liferay-ui:section>
			<portlet:actionURL name="/edit_ticket_comment" var="addTicketCommentURL" />

			<aui:form action="<%= addTicketCommentURL %>" cssClass="widget-mode-simple-entry" name="commentFm">
				<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
				<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />
				<aui:input name="visibility" type="hidden" value="<%= Visibilities.PUBLIC %>" />

				<aui:input label="" name="body" placeholder="compose-your-public-message-here" type="textarea" />

				<aui:button type="submit" value="post" />
			</aui:form>

			<%
			List<TicketCommunication> ticketCommunications = TicketCommunicationLocalServiceUtil.getTicketCommunications(ticketEntry.getTicketEntryId(), Visibilities.PUBLIC, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

			for (TicketCommunication ticketCommunication : ticketCommunications) {
				request.setAttribute("view_ticket_entry.jsp-ticketCommunication", ticketCommunication);

				String channel = ticketCommunication.getChannel();
			%>

				<c:choose>
					<c:when test="<%= channel.equals(TicketAttachment.class.getName()) %>">
						<liferay-util:include page="/common/ticket_communication/render_ticket_attachment.jsp" servletContext="<%= application %>" />
					</c:when>
					<c:when test="<%= channel.equals(TicketComment.class.getName()) %>">
						<liferay-util:include page="/common/ticket_communication/render_ticket_comment.jsp" servletContext="<%= application %>" />
					</c:when>
					<c:when test="<%= channel.equals(TicketLink.class.getName()) %>">
						<liferay-util:include page="/common/ticket_communication/render_ticket_link.jsp" servletContext="<%= application %>" />
					</c:when>
					<c:otherwise>
						N/A
					</c:otherwise>
				</c:choose>

			<%
			}
			%>

		</liferay-ui:section>
	</liferay-ui:tabs>
</div>

<aui:script use="aui-modal">
	<portlet:namespace />openDialog = function(title, uri) {
		Liferay.Util.openWindow(
			{
				dialog: {
					destroyOnHide: true,
					modal: true
				},
				dialogIframe: {
					bodyCssClass: 'dialog-with-footer'
				},
				title: title,
				uri: uri
			}
		);
	}

	<c:if test="<%= !ticketStatus.isTerminal() %>">
		<portlet:namespace />progressStatus = function() {
			var modal = new A.Modal(
				{
					bodyContent: '<liferay-ui:message arguments="<%= new Object[] {ticketStatus.getName(locale), nextTicketStatus.getName(locale)} %>" key="progress-ticket-status-from-x-to-x" />',
					centered: true,
					destroyOnHide: true,
					headerContent: '<liferay-ui:message key="workflow-ticket" />',
					modal: true,
					zIndex: Liferay.zIndex.OVERLAY
				}
			).render();

			modal.addToolbar(
				[
					{
						label: '<liferay-ui:message key="cancel" />',
						on: {
							click: function() {
								modal.hide();
							}
						}
					},
					{
						cssClass: 'btn-primary',
						label: '<liferay-ui:message key="update" />',
						on: {
							click: function() {
								<portlet:actionURL name="/edit_ticket_entry" var="editTicketEntryStatusURL">
									<portlet:param name="<%= Constants.CMD %>" value="update_ticket_status" />
									<portlet:param name="redirect" value="<%= currentURL %>" />
									<portlet:param name="ticketEntryId" value="<%= String.valueOf(ticketEntry.getTicketEntryId()) %>" />
									<portlet:param name="ticketStatusId" value="<%= String.valueOf(nextTicketStatus.getTicketStatusId()) %>" />
								</portlet:actionURL>

								submitForm(document.hrefFm, '<%= editTicketEntryStatusURL.toString() %>');

								modal.hide();
							}
						}
					}
				]);

			modal.show();
		}
	</c:if>
</aui:script>