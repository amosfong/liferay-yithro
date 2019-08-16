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

<%@ page import="com.liferay.document.library.kernel.exception.FileNameException" %><%@
page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPCreationMenu" %><%@
page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPDropdownItemList" %><%@
page import="com.liferay.frontend.taglib.clay.servlet.taglib.util.JSPNavigationItemList" %><%@
page import="com.liferay.petra.string.StringPool" %><%@
page import="com.liferay.portal.kernel.bean.BeanParamUtil" %><%@
page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %><%@
page import="com.liferay.portal.kernel.json.JSONArray" %><%@
page import="com.liferay.portal.kernel.json.JSONObject" %><%@
page import="com.liferay.portal.kernel.language.LanguageUtil" %><%@
page import="com.liferay.portal.kernel.model.User" %><%@
page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %><%@
page import="com.liferay.portal.kernel.search.Hits" %><%@
page import="com.liferay.portal.kernel.servlet.SessionErrors" %><%@
page import="com.liferay.portal.kernel.util.ArrayUtil" %><%@
page import="com.liferay.portal.kernel.util.Constants" %><%@
page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %><%@
page import="com.liferay.portal.kernel.util.FileUtil" %><%@
page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
page import="com.liferay.portal.kernel.util.HtmlUtil" %><%@
page import="com.liferay.portal.kernel.util.KeyValuePair" %><%@
page import="com.liferay.portal.kernel.util.KeyValuePairComparator" %><%@
page import="com.liferay.portal.kernel.util.ListUtil" %><%@
page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %><%@
page import="com.liferay.portal.kernel.util.StringUtil" %><%@
page import="com.liferay.portal.kernel.util.TextFormatter" %><%@
page import="com.liferay.portal.kernel.util.Validator" %><%@
page import="com.liferay.portal.kernel.util.WebKeys" %><%@
page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %><%@
page import="com.liferay.taglib.search.ResultRow" %><%@
page import="com.liferay.yithro.constants.Visibilities" %><%@
page import="com.liferay.yithro.ticket.configuration.YithroTicketConfiguration" %><%@
page import="com.liferay.yithro.ticket.constants.TicketCommentFormat" %><%@
page import="com.liferay.yithro.ticket.constants.TicketFieldType" %><%@
page import="com.liferay.yithro.ticket.constants.TicketWebKeys" %><%@
page import="com.liferay.yithro.ticket.exception.DuplicateTicketAttachmentException" %><%@
page import="com.liferay.yithro.ticket.exception.NoSuchTicketStatusException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketAttachmentSizeException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketAttachmentVisibilityException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketEntryDescriptionException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketEntrySummaryException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketFieldNameException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketLinkURLException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketLinkVisibilityException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketStatusNameException" %><%@
page import="com.liferay.yithro.ticket.exception.TicketStructureNameException" %><%@
page import="com.liferay.yithro.ticket.model.TicketAttachment" %><%@
page import="com.liferay.yithro.ticket.model.TicketComment" %><%@
page import="com.liferay.yithro.ticket.model.TicketCommunication" %><%@
page import="com.liferay.yithro.ticket.model.TicketEntry" %><%@
page import="com.liferay.yithro.ticket.model.TicketField" %><%@
page import="com.liferay.yithro.ticket.model.TicketFieldData" %><%@
page import="com.liferay.yithro.ticket.model.TicketFieldOption" %><%@
page import="com.liferay.yithro.ticket.model.TicketFormField" %><%@
page import="com.liferay.yithro.ticket.model.TicketFormFieldOption" %><%@
page import="com.liferay.yithro.ticket.model.TicketLink" %><%@
page import="com.liferay.yithro.ticket.model.TicketStatus" %><%@
page import="com.liferay.yithro.ticket.model.TicketStructure" %><%@
page import="com.liferay.yithro.ticket.service.TicketAttachmentLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketCommunicationLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketEntryLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketFieldDataLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketFieldLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketFieldOptionLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketLinkLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketStatusLocalServiceUtil" %><%@
page import="com.liferay.yithro.ticket.service.TicketStructureLocalServiceUtil" %>

<%@ page import="java.text.DateFormat" %><%@
page import="java.text.Format" %>

<%@ page import="java.util.ArrayList" %><%@
page import="java.util.List" %>

<%@ page import="javax.portlet.ActionRequest" %><%@
page import="javax.portlet.PortletURL" %><%@
page import="javax.portlet.WindowState" %>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
YithroTicketConfiguration yithroTicketConfiguration = (YithroTicketConfiguration)request.getAttribute(YithroTicketConfiguration.class.getName());

Format fullDateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(DateFormat.FULL, DateFormat.FULL, locale, timeZone);

int[] userVisibilities = {Visibilities.PUBLIC, Visibilities.WORKER};
%>