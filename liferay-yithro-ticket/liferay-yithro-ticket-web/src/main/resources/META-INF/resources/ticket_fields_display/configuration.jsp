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

<%@ include file="/ticket_fields_display/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="preferences--ticketFieldIds--" type="hidden" value="" />

	<div class="portlet-configuration-body-content">
		<div class="container-fluid-1280">
			<aui:fieldset>
				<h2><liferay-ui:message key="ticket-fields" /></h2>

				<%
				List leftList = new ArrayList();

				for (long ticketFieldId : ticketFieldIds) {
					TicketField ticketField = TicketFieldLocalServiceUtil.fetchTicketField(ticketFieldId);

					if ((ticketField == null) || (ticketField.getStatus() != WorkflowConstants.STATUS_APPROVED)) {
						continue;
					}

					leftList.add(new KeyValuePair(String.valueOf(ticketField.getTicketFieldId()), ticketField.getName(locale)));
				}

				List rightList = new ArrayList();

				List<TicketField> ticketFields = TicketFieldLocalServiceUtil.getTicketFields(WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS, QueryUtil.ALL_POS);

				for (TicketField ticketField : ticketFields) {
					if (ArrayUtil.contains(ticketFieldIds, ticketField.getTicketFieldId())) {
						continue;
					}

					rightList.add(new KeyValuePair(String.valueOf(ticketField.getTicketFieldId()), ticketField.getName(locale)));
				}

				rightList = ListUtil.sort(rightList, new KeyValuePairComparator(false, true));
				%>

				<liferay-ui:input-move-boxes
					leftBoxName="currentTicketFieldIds"
					leftList="<%= leftList %>"
					leftReorder="<%= Boolean.TRUE.toString() %>"
					leftTitle="current"
					rightBoxName="availableTicketFieldIds"
					rightList="<%= rightList %>"
					rightTitle="available"
				/>
			</aui:fieldset>
		</div>
	</div>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />saveConfiguration() {
		var form = document.<portlet:namespace />fm;

		var currentTicketFieldIdsElement = Liferay.Util.getFormElement(form, 'currentTicketFieldIds');

		if (currentTicketFieldIdsElement) {
			Liferay.Util.setFormValues(
				form,
				{
					'preferences--ticketFieldIds--': Liferay.Util.listSelect(currentTicketFieldIdsElement)
				}
			);
		}

		Liferay.Util.postForm(form);
	}
</aui:script>