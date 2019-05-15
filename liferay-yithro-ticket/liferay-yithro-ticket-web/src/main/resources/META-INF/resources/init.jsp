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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/clay" prefix="clay" %><%@
taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %><%@
taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@ page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu" %><%@
page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.model.User" %><%@
page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %><%@
page import="com.liferay.portal.kernel.servlet.SessionErrors" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.taglib.search.ResultRow" %><%@
page import="com.liferay.yithro.constants.Visibilities" %><%@
page import="com.liferay.yithro.ticket.constants.TicketWebKeys" %><%@
page import="com.liferay.yithro.ticket.exception.NoSuchTicketStatusException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketEntryDescriptionException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketEntrySubjectException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketStatusNameException" %><%@
page import="com.liferay.yithro.ticket.model.TicketAttachment" %><%@
page import="com.liferay.yithro.ticket.model.TicketComment" %><%@
page import="com.liferay.yithro.ticket.model.TicketEntry" %><%@
page import="com.liferay.yithro.ticket.model.TicketLink" %><%@
page import="com.liferay.yithro.ticket.model.TicketStatus" %><%@
page import="com.liferay.yithro.ticket.service.TicketAttachmentLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketCommentLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketEntryLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketLinkLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketStatusLocalServiceUtil" %>

<%@ page import="java.text.DateFormat" %><%@
page import="java.text.Format" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.List" %>

<%@ page import="javax.portlet.PortletURL" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
Format fullDateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(DateFormat.FULL, DateFormat.FULL, locale, timeZone);
%>