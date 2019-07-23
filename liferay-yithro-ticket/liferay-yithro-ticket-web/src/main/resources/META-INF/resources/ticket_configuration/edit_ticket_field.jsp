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

TicketField ticketField = (TicketField)request.getAttribute(TicketWebKeys.TICKET_FIELD);

long ticketFieldId = BeanParamUtil.getLong(ticketField, request, "ticketFieldId");
int type = BeanParamUtil.getInteger(ticketField, request, "type");
int visibility = BeanParamUtil.getInteger(ticketField, request, "visibility");

renderResponse.setTitle((ticketField == null) ? LanguageUtil.get(request, "new-ticket-field") : ticketField.getName(locale));
%>

<portlet:actionURL name="/ticket_configuration/edit_ticket_field" var="editTicketFieldURL" />

<aui:form action="<%= editTicketFieldURL %>" cssClass="container-fluid-1280" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="ticketFieldId" type="hidden" value="<%= ticketFieldId %>" />

	<liferay-ui:error exception="<%= TicketFieldNameException.class %>" message="please-enter-a-valid-name" />

	<aui:model-context bean="<%= ticketField %>" model="<%= TicketField.class %>" />

	<aui:fieldset-group>
		<aui:fieldset>
			<aui:input name="name" />

			<aui:input name="description" />

			<aui:select name="type" onChange='<%= renderResponse.getNamespace() + "toggleFieldOptions(this.value);" %>'>

				<%
				for (int curType : TicketFieldType.VALUES) {
				%>

					<aui:option label="<%= TicketFieldType.getLabel(curType) %>" selected="<%= curType == type %>" value="<%= curType %>" />

				<%
				}
				%>

			</aui:select>

			<aui:select name="visibility">

				<%
				for (int curVisibility : Visibilities.VALUES) {
				%>

					<aui:option label="<%= Visibilities.getLabel(curVisibility) %>" selected="<%= curVisibility == visibility %>" value="<%= curVisibility %>" />

				<%
				}
				%>

			</aui:select>
		</aui:fieldset>

		<div class="form-group <%= (ticketField == null) || (ticketField.getType() != TicketFieldType.SELECT) ? "hide" : "" %>" id="<portlet:namespace />fieldOptions">
			<h3 class="sheet-subtitle"><liferay-ui:message key="field-options" /></h3>

			<aui:fieldset id='<%= renderResponse.getNamespace() + "ticketFieldOptions" %>'>

				<%
				List<TicketFieldOption> ticketFieldOptions = new ArrayList<>();

				if (ticketField != null) {
					ticketFieldOptions.addAll(ticketField.getTicketFieldOptions());
				}

				if (ticketFieldOptions.isEmpty()) {
					ticketFieldOptions.add(TicketFieldOptionLocalServiceUtil.createTicketFieldOption(0));
				}

				int[] ticketFieldOptionIndexes = new int[ticketFieldOptions.size()];

				for (int i = 0; i < ticketFieldOptions.size(); i++) {
					TicketFieldOption ticketFieldOption = ticketFieldOptions.get(i);

					ticketFieldOptionIndexes[i] = i;
				%>

					<div class="lfr-form-row lfr-form-row-inline">
						<div class="row-fields">
							<aui:row>
								<aui:input label="name" name='<%= "ticketFieldOptionId_" + i %>' type="hidden" value="<%= ticketFieldOption.getTicketFieldOptionId() %>" />

								<aui:col md="5">
									<aui:input label="name" name='<%= "ticketFieldOptionName_" + i + "_en_US" %>' type="text" value='<%= ticketFieldOption.getName("en_US") %>' />
								</aui:col>

								<aui:col md="3">
									<aui:select label="visibility" name='<%= "ticketFieldOptionVisibility_" + i %>'>

										<%
										for (int curVisibility : Visibilities.VALUES) {
										%>

											<aui:option label="<%= Visibilities.getLabel(curVisibility) %>" selected="<%= curVisibility == ticketFieldOption.getVisibility() %>" value="<%= curVisibility %>" />

										<%
										}
										%>

									</aui:select>
								</aui:col>

								<aui:col md="2">
									<aui:input label="order" name='<%= "ticketFieldOptionOrder_" + i %>' type="text" value="<%= ticketFieldOption.getOrder() %>" />
								</aui:col>
							</aui:row>
						</div>
					</div>

				<%
				}
				%>

				<aui:input name="ticketFieldOptionIndexes" type="hidden" value="<%= StringUtil.merge(ticketFieldOptionIndexes) %>" />
			</aui:fieldset>
		</div>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script use="liferay-auto-fields">
	Liferay.provide(
		window,
		'<portlet:namespace />toggleFieldOptions',
		function(type) {
			var A = AUI();

			var fieldOptionsElement = A.one('#<portlet:namespace />fieldOptions');

			if (type == '<%= TicketFieldType.SELECT %>') {
				fieldOptionsElement.show();
			}
			else {
				fieldOptionsElement.hide();
			}
		},
		['aui-base']
	);

	var autoFields = new Liferay.AutoFields(
		{
			contentBox: 'fieldset#<portlet:namespace />ticketFieldOptions',
			fieldIndexes: '<portlet:namespace />ticketFieldOptionIndexes',
			namespace: '<portlet:namespace />'
		}
	).render();
</aui:script>