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
%>

<aui:form method="post" name="fm">
	<aui:input name="ticketEntryId" type="hidden" value="<%= ticketEntry.getTicketEntryId() %>" />

	<div class="ticket-details">
		<div>
			<strong><liferay-ui:message key="created" /></strong>

			<div class="form-group">
				<div class="text-secondary">
					<%= fullDateFormatDateTime.format(ticketEntry.getCreateDate()) %>
				</div>
			</div>
		</div>

		<div>
			<strong><liferay-ui:message key="updated" /></strong>

			<div class="form-group">
				<div class="text-secondary">
					<%= fullDateFormatDateTime.format(ticketEntry.getModifiedDate()) %>
				</div>
			</div>
		</div>

		<div>
			<strong><liferay-ui:message key="reporter" /></strong>

			<span id="<portlet:namespace />ticketEntryReporterDisplayActions">
				<a href="javascript:;" onClick="<portlet:namespace />editTicketEntryReporter();">
					<aui:icon
						cssClass="icon-monospaced"
						image="pencil"
						markupView="lexicon"
					/>
				</a>
			</span>
			<span class="hide" id="<portlet:namespace />ticketEntryReporterEditActions">
				<a href="javascript:;" onClick="<portlet:namespace />updateTicketEntryReporter();">
					<aui:icon
						cssClass="icon-monospaced"
						image="check-circle"
						markupView="lexicon"
					/>
				</a>

				<a href="javascript:;" onClick="<portlet:namespace />cancelEditTicketEntryReporter();">
					<aui:icon
						cssClass="icon-monospaced"
						image="times-circle"
						markupView="lexicon"
					/>
				</a>
			</span>

			<div class="form-group">

				<%
				User reporterUser = UserLocalServiceUtil.getUser(ticketEntry.getUserId());
				%>

				<div class="text-secondary" id="<portlet:namespace />ticketEntryReporterDisplay">
					<%= HtmlUtil.escape(reporterUser.getFullName()) %>
				</div>

				<div class="hide" id="<portlet:namespace />ticketEntryReporterEdit">
					<aui:input name="reporterUserId" type="hidden" value="<%= reporterUser.getUserId() %>" />

					<span id="<portlet:namespace />ticketEntryReporterUserName"><%= HtmlUtil.escape(reporterUser.getFullName()) %></span>

					<aui:button onClick='<%= renderResponse.getNamespace() + "openUserSelector(" + renderResponse.getNamespace() + "selectTicketEntryReporter, 'reporterUserId');" %>' value="select" />
				</div>
			</div>
		</div>

		<div>
			<strong><liferay-ui:message key="assignee" /></strong>

			<span id="<portlet:namespace />ticketWorkersDisplayActions">
				<a href="javascript:;" onClick="<portlet:namespace />editTicketWorkers();">
					<aui:icon
						cssClass="icon-monospaced"
						image="pencil"
						markupView="lexicon"
					/>
				</a>
			</span>
			<span class="hide" id="<portlet:namespace />ticketWorkersEditActions">
				<a href="javascript:;" onClick="<portlet:namespace />updateTicketWorkers();">
					<aui:icon
						cssClass="icon-monospaced"
						image="check-circle"
						markupView="lexicon"
					/>
				</a>

				<a href="javascript:;" onClick="<portlet:namespace />cancelEditTicketWorkers();">
					<aui:icon
						cssClass="icon-monospaced"
						image="times-circle"
						markupView="lexicon"
					/>
				</a>
			</span>

			<div class="form-group">
				<div id="<portlet:namespace />ticketWorkers">
					<aui:row cssClass="hide ticker-worker-edit">
						<aui:col width="<%= 50 %>">
							<strong><liferay-ui:message key="user" /></strong>
						</aui:col>

						<aui:col width="<%= 30 %>">
							<strong><liferay-ui:message key="role" /></strong>
						</aui:col>

						<aui:col width="<%= 10 %>">
							<strong>P</strong>
						</aui:col>

						<aui:col width="<%= 10 %>">
						</aui:col>
					</aui:row>

					<%
					List<TicketWorker> ticketWorkers = TicketWorkerLocalServiceUtil.getTicketWorkers(ticketEntry.getTicketEntryId());
					%>

					<c:choose>
						<c:when test="<%= !ticketWorkers.isEmpty() %>">

							<%
							for (TicketWorker ticketWorker : ticketWorkers) {
								User curUser = UserLocalServiceUtil.getUser(ticketWorker.getUserId());
							%>

								<div class="text-secondary ticker-worker-display">
									<span class="lfr-portal-tooltip user-name" data-title="<%= LanguageUtil.get(request, TicketWorkerRoles.getLabel(ticketWorker.getRole())) %>"><%= HtmlUtil.escape(curUser.getFullName()) %></span>

									<c:if test="<%= ticketWorker.isPrimary() %>">
										<strong>(P)</strong>
									</c:if>
								</div>

								<div id="<portlet:namespace />ticketWorker_<%= curUser.getUserId() %>">
									<aui:input id='<%= "ticketWorkerUserIds_" + curUser.getUserId() %>' name="ticketWorkerUserIds" type="hidden" value="<%= curUser.getUserId() %>" />

									<aui:row cssClass="hide ticker-worker-edit">
										<aui:col width="<%= 50 %>">
											<span class="user-name"><%= HtmlUtil.escape(curUser.getFullName()) %></span>
										</aui:col>

										<aui:col width="<%= 30 %>">
											<aui:select label="" name='<%= "role_" + ticketWorker.getUserId() %>'>
												<aui:option value="" />

												<%
												for (int ticketWorkerRole : TicketWorkerRoles.VALUES) {
												%>

													<aui:option label="<%= TicketWorkerRoles.getLabel(ticketWorkerRole) %>" selected="<%= ticketWorker.getRole() == ticketWorkerRole %>" value="<%= ticketWorkerRole %>" />

												<%
												}
												%>

											</aui:select>
										</aui:col>

										<aui:col width="<%= 10 %>">
											<aui:input checked="<%= ticketWorker.isPrimary() %>" cssClass="align-bottom" label="" name="primary" type="radio" value="<%= user.getUserId() %>" />
										</aui:col>

										<aui:col width="<%= 10 %>">
											<a href="javascript:;" onClick="<portlet:namespace />removeTicketWorker('<%= curUser.getUserId() %>');">
												<aui:icon
													cssClass="icon-monospaced"
													image="trash"
													markupView="lexicon"
												/>
											</a>
										</aui:col>
									</aui:row>
								</div>

							<%
							}
							%>

						</c:when>
						<c:otherwise>
							<div class="text-secondary ticker-worker-display">
								N/A
							</div>
						</c:otherwise>
					</c:choose>
				</div>

				<div class="hide" id="<portlet:namespace />newRow">
					<aui:input cssClass="user-id" name="" type="hidden" />

					<aui:row cssClass="hide ticker-worker-edit">
						<aui:col width="<%= 50 %>">
							<span class="user-name"></span>
						</aui:col>

						<aui:col width="<%= 30 %>">
							<aui:select label="" name="">
								<aui:option value="" />

								<%
								for (int ticketWorkerRole : TicketWorkerRoles.VALUES) {
								%>

									<aui:option label="<%= TicketWorkerRoles.getLabel(ticketWorkerRole) %>" value="<%= ticketWorkerRole %>" />

								<%
								}
								%>

							</aui:select>
						</aui:col>

						<aui:col width="<%= 10 %>">
							<aui:input cssClass="align-bottom radio" label="" name="primary" type="radio" />
						</aui:col>

						<aui:col width="<%= 10 %>">
							<a class="delete" href="javascript:;">
								<aui:icon
									cssClass="icon-monospaced"
									image="trash"
									markupView="lexicon"
								/>
							</a>
						</aui:col>
					</aui:row>
				</div>

				<aui:button cssClass="hide ticker-worker-edit" onClick='<%= renderResponse.getNamespace() + "openUserSelector(" + renderResponse.getNamespace() + "selectTicketWorker, 'ticketWorkerUserIds');" %>' value="add-worker" />
			</div>
		</div>
	</div>
</aui:form>

<aui:script use="aui-base">
	<portlet:namespace />cancelEditTicketEntryReporter = function() {
		A.one('#<portlet:namespace />ticketEntryReporterDisplay').show();
		A.one('#<portlet:namespace />ticketEntryReporterDisplayActions').show();

		A.one('#<portlet:namespace />ticketEntryReporterEditActions').hide();
		A.one('#<portlet:namespace />ticketEntryReporterEdit').hide();
	}

	<portlet:namespace />cancelEditTicketWorkers = function() {
		A.one('#<portlet:namespace />ticketWorkersDisplayActions').show();

		A.all('.ticker-worker-display').each(
			function(item, index, collection) {
				item.show();
			}
		);

		A.one('#<portlet:namespace />ticketWorkersEditActions').hide();

		A.all('.ticker-worker-edit').each(
			function(item, index, collection) {
				item.hide();
			}
		);
	}

	<portlet:namespace />editTicketEntryReporter = function() {
		A.one('#<portlet:namespace />ticketEntryReporterDisplay').hide();
		A.one('#<portlet:namespace />ticketEntryReporterDisplayActions').hide();

		A.one('#<portlet:namespace />ticketEntryReporterEditActions').show();
		A.one('#<portlet:namespace />ticketEntryReporterEdit').show();
	}

	<portlet:namespace />editTicketWorkers = function() {
		A.one('#<portlet:namespace />ticketWorkersDisplayActions').hide();

		A.all('.ticker-worker-display').each(
			function(item, index, collection) {
				item.hide();
			}
		);

		A.one('#<portlet:namespace />ticketWorkersEditActions').show();

		A.all('.ticker-worker-edit').each(
			function(item, index, collection) {
				item.show();
			}
		);
	}

	<portlet:namespace />openUserSelector = function(callback, selectedDataInput) {
		var selectedData = [];

		A.all('input[name="<portlet:namespace />' + selectedDataInput + '"]').each(
			function(item) {
				selectedData.push(item.val());
			});

		Liferay.Util.selectEntity(
			{
				dialog: {
					constrain: true,
					modal: true
				},
				eventName: '<portlet:namespace />selectUser',
				selectedData: selectedData,
				title: '<%= UnicodeLanguageUtil.get(request, "users") %>',
				uri: '<portlet:renderURL windowState="<%= LiferayWindowState.POP_UP.toString() %>"><portlet:param name="mvcPath" value="/ticket_details_display/select_user.jsp" /><portlet:param name="ticketEntryId" value="<%= String.valueOf(ticketEntry.getTicketEntryId()) %>" /></portlet:renderURL>'
			},
			function(event) {
				callback(event.userid, event.username);
			}
		);
	}

	<portlet:namespace />removeTicketWorker = function(userId) {
		A.one('#<portlet:namespace />ticketWorker_' + userId).remove(true);
	}

	<portlet:namespace />selectTicketEntryReporter = function(userId, userName) {
		A.one('#<portlet:namespace />ticketEntryReporterUserName').html(userName);

		A.one('#<portlet:namespace />reporterUserId').val(userId);
	}

	<portlet:namespace />selectTicketWorker = function(userId, userName) {
		var newRow = A.one('#<portlet:namespace />newRow').clone();

		newRow.attr('id', '<portlet:namespace />ticketWorker_' + userId);

		newRow.one('select').attr('name', '<portlet:namespace />role_' + userId);

		newRow.one('.delete').attr('onClick', '<portlet:namespace />removeTicketWorker(' + userId + ');');

		newRow.one('.user-id').attr('name', '<portlet:namespace />ticketWorkerUserIds');
		newRow.one('.user-id').val(userId);

		newRow.one('.user-name').html(userName);

		newRow.one('.radio').attr('value', userId);

		A.one('#<portlet:namespace />ticketWorkers').appendChild(newRow);

		newRow.show();
	}

	<portlet:namespace />updateTicketEntryReporter = function() {
		var data = Liferay.Util.ns(
			'<portlet:namespace />',
			{
				ticketEntryId: '<%= ticketEntry.getTicketEntryId() %>'
			}
		);

		A.io.request(
			'<portlet:actionURL name="/edit_ticket_entry"><portlet:param name="<%= Constants.CMD %>" value="update_ticket_entry_reporter" /></portlet:actionURL>',
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

	<portlet:namespace />updateTicketWorkers = function() {
		var data = Liferay.Util.ns(
			'<portlet:namespace />',
			{
				ticketEntryId: '<%= ticketEntry.getTicketEntryId() %>'
			}
		);

		A.io.request(
			'<portlet:actionURL name="/edit_ticket_workers" />',
			{
				dataType: 'JSON',
				form: {
					id: '<portlet:namespace />fm'
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