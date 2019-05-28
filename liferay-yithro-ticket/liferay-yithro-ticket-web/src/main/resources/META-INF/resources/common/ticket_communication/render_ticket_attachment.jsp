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
TicketCommunication ticketCommunication = (TicketCommunication)request.getAttribute("edit_ticket_entry.jsp-ticketCommunication");

User ticketCommunicationUser = ticketCommunication.getUser();
JSONObject dataJSONObject = ticketCommunication.getDataJSONObject();

JSONArray jsonArray = dataJSONObject.getJSONArray("ticketAttachments");
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
			<span class="lfr-portal-tooltip" data-title="<liferay-ui:message key="permalink" />">
				<aui:icon
					cssClass="icon-monospaced"
					image="link"
					markupView="lexicon"
					url='<%= "javascript:;" %>'
				/>
			</span>
		</div>

		<div class="autofit-col">

			<%
			long[] ticketAttachmentIds = new long[jsonArray.length()];

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);

				ticketAttachmentIds[i] = jsonObject.getLong("ticketAttachmentId");
			}
			%>

			<clay:dropdown-actions
				dropdownItems="<%=
					new JSPDropdownItemList(pageContext) {
						{
							PortletURL deleteURL = renderResponse.createActionURL();

							deleteURL.setParameter(ActionRequest.ACTION_NAME, "/edit_ticket_attachment");
							deleteURL.setParameter(Constants.CMD, Constants.DELETE);
							deleteURL.setParameter("redirect", PortalUtil.getCurrentURL(request));
							deleteURL.setParameter("ticketAttachmentId", StringUtil.merge(ticketAttachmentIds));

							add(
								dropdownItem -> {
									dropdownItem.putData("action", "deleteTicketAttachment");
									dropdownItem.setHref(deleteURL);

									if (ticketAttachmentIds.length == 1) {
										dropdownItem.setLabel(LanguageUtil.get(request, "delete-attachment"));
									}
									else {
										dropdownItem.setLabel(LanguageUtil.get(request, "delete-attachments"));
									}
								});
						}
					}
				%>"
			/>
		</div>
	</div>

	<div class="widget-content">

		<%
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
		%>

			<div>
				<span class="lfr-portal-tooltip" data-title="<liferay-ui:message key="attachment" />">
					<aui:icon
						cssClass="icon-monospaced"
						image="paperclip"
						markupView="lexicon"
					/>
				</span>

				<portlet:resourceURL id="/download_ticket_attachment" var="downloadAttachmentURL">
					<portlet:param name="ticketAttachmentId" value='<%= jsonObject.getString("ticketAttachmentId") %>' />
				</portlet:resourceURL>

				<a href="<%= downloadAttachmentURL %>"><%= jsonObject.getString("fileName") %></a> (<%= TextFormatter.formatStorageSize(jsonObject.getDouble("fileSize"), locale) %>)
			</div>

		<%
		}
		%>

	</div>
</div>