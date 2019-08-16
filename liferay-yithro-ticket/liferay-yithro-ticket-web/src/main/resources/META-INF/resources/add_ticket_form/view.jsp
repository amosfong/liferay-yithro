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

<%
String summary = ParamUtil.getString(request, "summary");
String description = ParamUtil.getString(request, "description");
%>

<liferay-ui:error exception="<%= TicketEntryDescriptionException.class %>" message="please-enter-a-description-of-the-issue" />
<liferay-ui:error exception="<%= TicketEntrySummaryException.class %>" message="please-enter-a-summary-of-the-issue" />

<portlet:actionURL name="/edit_ticket_entry" var="editTicketEntryURL" />

<aui:form action="<%= editTicketEntryURL %>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />

	<c:choose>
		<c:when test='<%= displayStyle.equals("ticket-structure") %>'>
			<aui:input name="ticketStructureId" type="hidden" value="<%= ticketStructureId %>" />

			<%
			TicketStructure ticketStructure = TicketStructureLocalServiceUtil.getTicketStructure(ticketStructureId);

			List<TicketFormField> ticketFormFields = ticketStructure.getTicketFormFields();

			List<Long> ticketFieldIds = new ArrayList<>();

			for (TicketFormField ticketFormField : ticketFormFields) {
				TicketField ticketField = ticketFormField.getTicketField();

				ticketFieldIds.add(ticketField.getTicketFieldId());
			%>

				<aui:fieldset cssClass='<%= Validator.isNotNull(ticketFormField.getDisplayRules()) ? "hide" : "" %>' id='<%= renderResponse.getNamespace() + "ticketFieldId_" + ticketField.getTicketFieldId() %>'>
					<c:choose>
						<c:when test="<%= ticketField.getType() == TicketFieldType.SELECT %>">
							<aui:select label="<%= ticketField.getName(locale) %>" name='<%= "ticketFieldIdData_" + ticketField.getTicketFieldId() %>' onChange="Liferay.fire('checkDisplayRules');">
								<aui:option label="" />

								<%
								for (TicketFormFieldOption ticketFormFieldOption : ticketFormField.getTicketFormFieldOptions()) {
									TicketFieldOption ticketFieldOption = ticketFormFieldOption.getTicketFieldOption();
								%>

									<option <%= Validator.isNotNull(ticketFormFieldOption.getDisplayRules()) ? "hidden" : "" %> value="<%= ticketFieldOption.getTicketFieldOptionId() %>" id="<portlet:namespace />ticketFieldOptionId_<%= ticketFieldOption.getTicketFieldOptionId() %>"><%= HtmlUtil.escape(ticketFieldOption.getName(locale)) %></option>

									<c:if test="<%= Validator.isNotNull(ticketFormFieldOption.getDisplayRules()) %>">
										<aui:script>
											Liferay.on(
												'checkDisplayRules',
												function() {
													var A = AUI();

													if (<%= ticketFormFieldOption.getJavascriptDisplayRules(renderResponse) %>) {
														A.one('#<portlet:namespace />ticketFieldOptionId_<%= ticketFieldOption.getTicketFieldOptionId() %>').removeAttribute('hidden');
													}
													else {
														A.one('#<portlet:namespace />ticketFieldOptionId_<%= ticketFieldOption.getTicketFieldOptionId() %>').setAttribute('hidden', 'hidden');

														if (A.one('#<portlet:namespace />ticketFieldIdData_<%= ticketField.getTicketFieldId() %>').val() == <%= ticketFieldOption.getTicketFieldOptionId() %>) {
															A.one('#<portlet:namespace />ticketFieldIdData_<%= ticketField.getTicketFieldId() %>').val('');
														}
													}
												}
											);
										</aui:script>
									</c:if>

								<%
								}
								%>

							</aui:select>
						</c:when>
						<c:otherwise>
							<aui:input label="<%= ticketField.getName(locale) %>" name='<%= "ticketFieldIdData_" + ticketField.getTicketFieldId() %>' onInput="Liferay.fire('checkDisplayRules');" />
						</c:otherwise>
					</c:choose>
				</aui:fieldset>

				<c:if test="<%= Validator.isNotNull(ticketFormField.getDisplayRules()) %>">
					<aui:script>
						Liferay.on(
							'checkDisplayRules',
							function() {
								var A = AUI();

								if (<%= ticketFormField.getJavascriptDisplayRules(renderResponse) %>) {
									A.one('#<portlet:namespace />ticketFieldId_<%= ticketField.getTicketFieldId() %>').show();
								}
								else {
									A.one('#<portlet:namespace />ticketFieldId_<%= ticketField.getTicketFieldId() %>').hide();
								}
							}
						);
					</aui:script>
				</c:if>

			<%
			}
			%>

			<aui:input name="ticketFieldIds" type="hidden" value="<%= StringUtil.merge(ticketFieldIds) %>" />
		</c:when>
		<c:otherwise>
			<aui:input name="summary" required="<%= true %>" value="<%= summary %>" />

			<aui:input name="description" type="textarea" value="<%= description %>" wrapperCssClass="lfr-textarea-container" />
		</c:otherwise>
	</c:choose>

	<aui:button type="submit" value="create" />
</aui:form>