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

<%
TicketEntry ticketEntry = (TicketEntry)request.getAttribute(TicketWebKeys.TICKET_ENTRY);
%>

<aui:form enctype="multipart/form-data" method="post" name="fm">
	<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />
	<aui:input name="ticketFieldId" type="hidden" value="" />

	<div class="ticket-fields">

		<%
		for (long ticketFieldId : ticketFieldIds) {
			TicketField ticketField = TicketFieldLocalServiceUtil.fetchTicketField(ticketFieldId);

			if ((ticketField == null) || (ticketField.getStatus() != WorkflowConstants.STATUS_APPROVED)) {
				continue;
			}
		%>

			<strong><%= HtmlUtil.escape(ticketField.getName(locale)) %></strong>

			<span id="<portlet:namespace />ticketFieldDisplayActions_<%= ticketFieldId %>">
				<a href="javascript:;" onClick="<portlet:namespace />editTicketField('<%= ticketFieldId %>');">
					<aui:icon
						cssClass="icon-monospaced"
						image="pencil"
						markupView="lexicon"
					/>
				</a>
			</span>
			<span class="hide" id="<portlet:namespace />ticketFieldEditActions_<%= ticketFieldId %>">
				<a href="javascript:;" onClick="<portlet:namespace />saveTicketField('<%= ticketFieldId %>');">
					<aui:icon
						cssClass="icon-monospaced"
						image="check-circle"
						markupView="lexicon"
					/>
				</a>

				<a href="javascript:;" onClick="<portlet:namespace />cancelEditTicketField('<%= ticketFieldId %>');">
					<aui:icon
						cssClass="icon-monospaced"
						image="times-circle"
						markupView="lexicon"
					/>
				</a>
			</span>

			<div class="form-group">

				<%
				String data = null;

				TicketFieldData ticketFieldData = TicketFieldDataLocalServiceUtil.fetchTicketFieldData(ticketEntry.getTicketEntryId(), ticketFieldId);

				if (ticketFieldData != null) {
					if (ticketField.getType() == TicketFieldType.SELECT) {
						long ticketFieldOptionId = GetterUtil.getLong(ticketFieldData.getData());

						if (ticketFieldOptionId > 0) {
							TicketFieldOption ticketFieldOption = TicketFieldOptionLocalServiceUtil.fetchTicketFieldOption(ticketFieldOptionId);

							data = ticketFieldOption.getName(locale);
						}
					}
					else {
						data = ticketFieldData.getData();
					}
				}
				%>

				<div class="text-secondary" id="<portlet:namespace />ticketFieldDisplay_<%= ticketFieldId %>">
					<c:choose>
						<c:when test="<%= ticketField.getType() == TicketFieldType.ATTACHMENT %>">

							<%
							TicketAttachment ticketAttachment = TicketAttachmentLocalServiceUtil.fetchTicketAttachment(ticketEntry.getTicketEntryId(), ticketFieldId);
							%>

							<c:choose>
								<c:when test="<%= ticketAttachment != null %>">
									<portlet:resourceURL id="/download_ticket_attachment" var="downloadAttachmentURL">
										<portlet:param name="ticketAttachmentId" value="<%= String.valueOf(ticketAttachment.getTicketAttachmentId()) %>" />
									</portlet:resourceURL>

									<a href="<%= downloadAttachmentURL %>"><%= ticketAttachment.getFileName() %></a> (<%= TextFormatter.formatStorageSize(ticketAttachment.getFileSize(), locale) %>)
								</c:when>
								<c:otherwise>
									N/A
								</c:otherwise>
							</c:choose>
						</c:when>
						<c:when test="<%= Validator.isNotNull(data) %>">
							<%= HtmlUtil.escape(data) %>
						</c:when>
						<c:otherwise>
							N/A
						</c:otherwise>
					</c:choose>
				</div>

				<div class="hide" id="<portlet:namespace />ticketFieldEdit_<%= ticketFieldId %>">
					<c:choose>
						<c:when test="<%= ticketField.getType() == TicketFieldType.ATTACHMENT %>">
							<aui:input inlineField="<%= true %>" label="" name='<%= "ticketFieldIdData_" + ticketFieldId %>' type="file" />
						</c:when>
						<c:when test="<%= ticketField.getType() == TicketFieldType.SELECT %>">
							<aui:select inlineField="<%= true %>" label="" name='<%= "ticketFieldIdData_" + ticketFieldId %>'>

								<%
								long ticketFieldOptionId = 0;

								if (ticketFieldData != null) {
									ticketFieldOptionId = GetterUtil.getLong(ticketFieldData.getData());
								}

								for (TicketFieldOption ticketFieldOption : ticketField.getTicketFieldOptions(WorkflowConstants.STATUS_APPROVED)) {
								%>

									<aui:option label="<%= ticketFieldOption.getName(locale) %>" selected="<%= ticketFieldOptionId == ticketFieldOption.getTicketFieldOptionId() %>" value="<%= ticketFieldOption.getTicketFieldOptionId() %>" />

								<%
								}
								%>

							</aui:select>
						</c:when>
						<c:otherwise>
							<aui:input inlineField="<%= true %>" label="" name='<%= "ticketFieldIdData_" + ticketFieldId %>' value="<%= (ticketFieldData != null) ? ticketFieldData.getData() : StringPool.BLANK %>" />
						</c:otherwise>
					</c:choose>
				</div>
			</div>

		<%
		}
		%>

	</div>
</aui:form>

<aui:script use="aui-io-request">
	<portlet:namespace />cancelEditTicketField = function(ticketFieldId) {
		A.one('#<portlet:namespace />ticketFieldDisplay_' + ticketFieldId).show();
		A.one('#<portlet:namespace />ticketFieldDisplayActions_' + ticketFieldId).show();

		A.one('#<portlet:namespace />ticketFieldEditActions_' + ticketFieldId).hide();
		A.one('#<portlet:namespace />ticketFieldEdit_' + ticketFieldId).hide();
	}

	<portlet:namespace />editTicketField = function(ticketFieldId) {
		A.one('#<portlet:namespace />ticketFieldDisplay_' + ticketFieldId).hide();
		A.one('#<portlet:namespace />ticketFieldDisplayActions_' + ticketFieldId).hide();

		A.one('#<portlet:namespace />ticketFieldEditActions_' + ticketFieldId).show();
		A.one('#<portlet:namespace />ticketFieldEdit_' + ticketFieldId).show();
	}

	<portlet:namespace />saveTicketField = function(ticketFieldId) {
		A.one('#<portlet:namespace />ticketFieldId').val(ticketFieldId);

		var data = Liferay.Util.ns(
			'<portlet:namespace />',
			{
				ticketEntryId: '<%= ticketEntry.getTicketEntryId() %>'
			}
		);

		A.io.request(
			'<portlet:actionURL name="/edit_ticket_field_data" />',
			{
				dataType: 'JSON',
				form: {
					id: '<portlet:namespace />fm',
					upload: true
				},
				method: 'POST',
				on: {
					complete: function(event, id, obj) {
						Liferay.Portlet.refresh('#p_p_id<portlet:namespace />', data);
					},
					success: function(event, id, obj) {
						Liferay.Portlet.refresh('#p_p_id<portlet:namespace />', data);
					}
				}
			}
		);
	}
</aui:script>