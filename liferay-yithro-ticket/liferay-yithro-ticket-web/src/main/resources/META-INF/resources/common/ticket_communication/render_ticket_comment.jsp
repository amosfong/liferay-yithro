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
TicketCommunication ticketCommunication = (TicketCommunication)request.getAttribute("view_ticket_entry.jsp-ticketCommunication");

User ticketCommunicationUser = ticketCommunication.getUser();
JSONObject dataJSONObject = ticketCommunication.getDataJSONObject();
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
			<clay:dropdown-actions
				dropdownItems="<%=
					new JSPDropdownItemList(pageContext) {
						{
							PortletURL editTicketCommentURL = renderResponse.createRenderURL();

							editTicketCommentURL.setParameter("mvcRenderCommandName", "/edit_ticket_comment");
							editTicketCommentURL.setParameter("redirect", PortalUtil.getCurrentURL(request));
							editTicketCommentURL.setParameter("ticketCommentId", dataJSONObject.getString("ticketCommentId"));
							editTicketCommentURL.setWindowState(LiferayWindowState.POP_UP);

							add(
								dropdownItem -> {
									dropdownItem.setHref("javascript:" + renderResponse.getNamespace() + "openDialog('" + LanguageUtil.get(request, "edit-comment") + "', '" + editTicketCommentURL.toString() + "');");
									dropdownItem.setLabel(LanguageUtil.get(request, "edit"));
								});

							PortletURL deleteURL = renderResponse.createActionURL();

							deleteURL.setParameter(ActionRequest.ACTION_NAME, "/edit_ticket_comment");
							deleteURL.setParameter(Constants.CMD, Constants.DELETE);
							deleteURL.setParameter("redirect", PortalUtil.getCurrentURL(request));
							deleteURL.setParameter("ticketCommentId", dataJSONObject.getString("ticketCommentId"));

							add(
								dropdownItem -> {
									dropdownItem.putData("action", "deleteTicketComment");
									dropdownItem.setHref(deleteURL.toString());
									dropdownItem.setLabel(LanguageUtil.get(request, "delete"));
								});
						}
					}
				%>"
			/>
		</div>
	</div>

	<div class="widget-content">
		<%= dataJSONObject.getString("content") %>
	</div>
</div>