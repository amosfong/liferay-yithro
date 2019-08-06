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

<%@ include file="/add_ticket_form/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="preferences--ticketFieldIds--" type="hidden" value="" />

	<div class="portlet-configuration-body-content">
		<div class="container-fluid-1280">
			<aui:fieldset>
				<aui:select name="preferences--displayStyle--" onChange='<%= renderResponse.getNamespace() + "selectDisplayStyle(this.value);" %>'>
					<aui:option label="simple" selected='<%= displayStyle.equals("simple") %>' value="simple" />
					<aui:option label="ticket-structure" selected='<%= displayStyle.equals("ticket-structure") %>' value="ticket-structure" />
				</aui:select>
			</aui:fieldset>

			<aui:fieldset cssClass='<%= displayStyle.equals("ticket-structure") ? "" : "hide" %>' id='<%= renderResponse.getNamespace() + "ticketStructure" %>'>
				<aui:select label="ticket-structure" name="preferences--ticketStructureId--" onChange='<%= renderResponse.getNamespace() + "selectDisplayStyle(this.value);" %>'>

					<%
					List<TicketStructure> ticketStructures = TicketStructureLocalServiceUtil.getTicketStructures(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

					for (TicketStructure ticketStructure : ticketStructures) {
					%>

						<aui:option label="<%= ticketStructure.getName() %>" selected="<%= ticketStructureId == ticketStructure.getTicketStructureId() %>" value="<%= ticketStructure.getTicketStructureId() %>" />

					<%
					}
					%>

				</aui:select>
			</aui:fieldset>
		</div>
	</div>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />selectDisplayStyle(displayStyle) {
		var A = AUI();

		var ticketStructures = A.one('#<portlet:namespace />ticketStructure');

		if (displayStyle == 'ticket-structure') {
			ticketStructures.show();
		}
		else {
			ticketStructures.hide();
		}
	}
</aui:script>