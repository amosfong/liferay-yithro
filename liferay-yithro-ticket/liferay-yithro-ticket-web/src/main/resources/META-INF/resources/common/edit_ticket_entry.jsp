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
	<h1>
		<%= HtmlUtil.escape(ticketEntry.getSubject()) %>
	</h1>

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
			<portlet:actionURL name="/add_ticket_comment" var="addTicketCommentURL" />

			<aui:form action="<%= addTicketCommentURL %>" cssClass="widget-mode-simple-entry" name="commentFm">
				<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
				<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />
				<aui:input name="visibility" type="hidden" value="<%= Visibilities.PUBLIC %>" />

				<aui:input label="" name="body" placeholder="compose-your-public-message-here" type="textarea" />

				<aui:button type="submit" value="post" />
			</aui:form>

			<%
			List<TicketCommunication> ticketCommunications = TicketCommunicationLocalServiceUtil.getTicketCommunications(ticketEntry.getTicketEntryId());

			for (TicketCommunication ticketCommunication : ticketCommunications) {
				User ticketCommunicationUser = UserLocalServiceUtil.getUser(ticketCommunication.getUserId());
			%>

				<div class="widget-mode-simple-entry">
					<div class="autofit-row widget-metadata">
						<div class="autofit-col inline-item-before">
							<liferay-ui:user-portrait
								user="<%= ticketCommunicationUser %>"
							/>
						</div>

						<div class="autofit-col autofit-col-expand">
							<div class="autofit-row">
								<div class="autofit-col autofit-col-expand">
									<div class="text-truncate-inline">
										<%= HtmlUtil.escape(ticketCommunicationUser.getFullName()) %>
									</div>

									<div class="text-secondary">
										<%= fullDateFormatDateTime.format(ticketCommunication.getCreateDate()) %>
									</div>
								</div>
							</div>
						</div>

						<div class="autofit-col">
							<liferay-ui:icon
								cssClass="icon-monospaced"
								image="../journal/link_to_page"
								message="permalink"
								url='<%= "javascript:;" %>'
							/>
						</div>

						<div class="autofit-col">
							<liferay-ui:icon-menu
								direction="left-side"
								icon="<%= StringPool.BLANK %>"
								markupView="lexicon"
								message="actions"
								showWhenSingleIcon="<%= true %>"
							>
								<liferay-ui:icon
									message="edit"
									url='<%= "#" %>'
								/>

								<liferay-ui:icon-delete
									label="<%= true %>"
									url='<%= "#" %>'
								/>
							</liferay-ui:icon-menu>
						</div>
					</div>

					<div class="widget-content">
						<c:choose>
							<c:when test="<%= ticketCommunication.getClassNameId() == PortalUtil.getClassNameId(TicketAttachment.class) %>">

								<%
								JSONObject jsonObjectProperties = JSONFactoryUtil.createJSONObject(ticketCommunication.getProperties());

								JSONArray jsonArray = jsonObjectProperties.getJSONArray("ticketAttachments");

								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject jsonObject = jsonArray.getJSONObject(i);
								%>

									<portlet:resourceURL id="/download_ticket_attachment" var="downloadAttachmentURL">
										<portlet:param name="ticketAttachmentId" value='<%= jsonObject.getString("ticketAttachmentId") %>' />
									</portlet:resourceURL>

									<liferay-ui:icon
										cssClass="icon-monospaced"
										image="../common/clip"
										message="attachment"
									/>

									<a href="<%= downloadAttachmentURL %>"><%= jsonObject.getString("fileName") %></a> (<%= TextFormatter.formatStorageSize(jsonObject.getDouble("fileSize"), locale) %>)

								<%
								}
								%>

							</c:when>
							<c:when test="<%= ticketCommunication.getClassNameId() == PortalUtil.getClassNameId(TicketLink.class) %>">

								<%
								JSONObject jsonObjectProperties = JSONFactoryUtil.createJSONObject(ticketCommunication.getProperties());

								JSONArray jsonArray = jsonObjectProperties.getJSONArray("ticketLinks");

								for (int i = 0; i < jsonArray.length(); i++) {
									JSONObject jsonObject = jsonArray.getJSONObject(i);
								%>

									<liferay-ui:icon
										cssClass="icon-monospaced"
										image="../journal/link_to_page"
										message="link"
									/>

									<a href="<%= jsonObject.getString("url") %>"><%= jsonObject.getString("url") %></a>

								<%
								}
								%>

							</c:when>
							<c:otherwise>
								<%= ticketCommunication.getContent() %>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

			<%
			}
			%>

		</liferay-ui:section>
	</liferay-ui:tabs>
</div>

<aui:script use="aui-modal">
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