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

String url = ParamUtil.getString(request, "url");
int visibility = ParamUtil.getInteger(request, "visibility");

List<TicketLink> ticketLinks = TicketLinkLocalServiceUtil.getTicketLinks(ticketEntry.getTicketEntryId(), userVisibilities);
%>

<liferay-ui:error exception="<%= TicketLinkURLException.class %>" message="please-enter-a-valid-url" />
<liferay-ui:error exception="<%= TicketLinkVisibilityException.class %>" message="please-enter-a-valid-visibility" />

<div class="sheet">
	<div class="sheet-text">
		<liferay-ui:search-container
			emptyResultsMessage="there-are-no-links"
			headerNames="url,visibility"
			total="<%= ticketLinks.size() %>"
		>
			<liferay-ui:search-container-results
				results="<%= ticketLinks %>"
			/>

			<liferay-ui:search-container-row
				className="com.liferay.yithro.ticket.model.TicketLink"
				escapedModel="<%= true %>"
				keyProperty="ticketLinkId"
				modelVar="ticketLink"
			>
				<liferay-ui:search-container-column-text
					href="<%= ticketLink.getUrl() %>"
					name="url"
					target="_blank"
					value="<%= StringUtil.shorten(ticketLink.getUrl(), 115) %>"
				/>

				<c:if test="<%= userVisibilities.length > 1 %>">
					<liferay-ui:search-container-column-text
						href="<%= ticketLink.getUrl() %>"
						name="visibility"
						target="_blank"
						translate="<%= true %>"
						value="<%= ticketLink.getVisibilityLabel() %>"
					/>
				</c:if>

				<liferay-ui:search-container-column-jsp
					align="right"
					path="/common/ticket_link_action.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator
				markupView="lexicon"
				paginate="<%= false %>"
			/>
		</liferay-ui:search-container>

		<portlet:actionURL name="/edit_ticket_link" var="addTicketLinkURL" />

		<aui:form action="<%= addTicketLinkURL %>" method="post" name="fm2">
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
			<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />

			<aui:fieldset>
				<div class="sheet-title">
					<liferay-ui:message key="add-link" />
				</div>

				<aui:input name="url" type="url" value="<%= url %>" />

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
	</div>
</div>