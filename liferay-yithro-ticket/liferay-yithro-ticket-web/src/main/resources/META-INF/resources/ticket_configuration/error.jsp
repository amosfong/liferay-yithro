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

<c:if test="<%= !SessionErrors.isEmpty(renderRequest) %>">
	<div class="alert alert-danger">
		<liferay-ui:icon
			icon="exclamation-full"
			markupView="lexicon"
		/>

		<c:choose>
			<c:when test="<%= SessionErrors.contains(renderRequest, NoSuchTicketStatusException.class.getName()) %>">
				<liferay-ui:message key="the-ticket-status-could-not-be-found" />
			</c:when>
		</c:choose>
	</div>
</c:if>