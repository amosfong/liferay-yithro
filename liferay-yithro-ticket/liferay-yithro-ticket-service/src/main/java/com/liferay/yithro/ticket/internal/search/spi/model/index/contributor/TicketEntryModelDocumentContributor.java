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

package com.liferay.yithro.ticket.internal.search.spi.model.index.contributor;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;
import com.liferay.subscription.model.Subscription;
import com.liferay.subscription.service.SubscriptionLocalService;
import com.liferay.yithro.constants.Visibilities;
import com.liferay.yithro.ticket.configuration.YithroTicketConfiguration;
import com.liferay.yithro.ticket.constants.TicketFlagType;
import com.liferay.yithro.ticket.constants.TicketFlagValue;
import com.liferay.yithro.ticket.model.TicketAttachment;
import com.liferay.yithro.ticket.model.TicketComment;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.model.TicketWorker;
import com.liferay.yithro.ticket.service.TicketAttachmentLocalService;
import com.liferay.yithro.ticket.service.TicketCommentLocalService;
import com.liferay.yithro.ticket.service.TicketFlagLocalService;
import com.liferay.yithro.ticket.service.TicketWorkerLocalService;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Amos Fong
 */
@Component(
	immediate = true,
	property = "indexer.class.name=com.liferay.yithro.ticket.model.TicketEntry",
	service = ModelDocumentContributor.class
)
public class TicketEntryModelDocumentContributor
	implements ModelDocumentContributor<TicketEntry> {

	@Override
	public void contribute(Document document, TicketEntry ticketEntry) {
		document.addDate("closedDate", ticketEntry.getClosedDate());
		document.addDate("createDate", ticketEntry.getCreateDate());
		document.addText("description", ticketEntry.getDescription());
		document.addDate("dueDate", ticketEntry.getDueDate());

		int[] pendingTypes = ticketFlagLocalService.getTicketFlagTypes(
			ticketEntry.getTicketEntryId(), TicketFlagType.PENDING_VALUES,
			TicketFlagValue.PENDING_TRUE);

		document.addKeyword("pendingTypes", pendingTypes);

		TicketWorker primaryTicketWorker =
			ticketWorkerLocalService.fetchPrimaryTicketWorker(
				ticketEntry.getTicketEntryId());

		if (primaryTicketWorker != null) {
			document.addKeyword(
				"primaryTicketWorker", primaryTicketWorker.getUserId());
		}

		document.addText("subject", ticketEntry.getSubject());

		List<Subscription> subscriptions =
			subscriptionLocalService.getSubscriptions(
				ticketEntry.getCompanyId(), TicketEntry.class.getName(),
				ticketEntry.getTicketEntryId());

		long[] subscriptionUserIds = new long[subscriptions.size()];

		for (int i = 0; i < subscriptions.size(); i++) {
			Subscription subscription = subscriptions.get(i);

			subscriptionUserIds[i] = subscription.getUserId();
		}

		document.addKeyword("subscriptions", subscriptionUserIds);

		document.addNumber("ticketEntryId", ticketEntry.getTicketEntryId());
		document.addNumber("ticketNumber", ticketEntry.getTicketNumber());
		document.addKeyword("ticketStatusId", ticketEntry.getTicketStatusId());
		document.addKeyword("userId", ticketEntry.getUserId());

		String assignee = StringPool.BLANK;

		if (primaryTicketWorker != null) {
			User assigneeUser = userLocalService.fetchUserById(
				primaryTicketWorker.getUserId());

			if (assigneeUser != null) {
				assignee = assigneeUser.getFullName();
			}
		}

		document.addTextSortable("assignee", assignee);

		document.addDateSortable("createDate", ticketEntry.getCreateDate());
		document.addDateSortable("ducDate", ticketEntry.getDueDate());
		document.addDateSortable("modifiedDate", ticketEntry.getModifiedDate());
		document.addTextSortable("subject", ticketEntry.getSubject());

		contributeTicketAttachments(document, ticketEntry.getTicketEntryId());
		contributeTicketComments(document, ticketEntry.getTicketEntryId());
		contributeTicketWorkers(document, ticketEntry.getTicketEntryId());
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		yithroTicketConfiguration = ConfigurableUtil.createConfigurable(
			YithroTicketConfiguration.class, properties);
	}

	protected void contributeTicketAttachments(
		Document document, long ticketEntryId) {

		List<TicketAttachment> ticketAttachments =
			ticketAttachmentLocalService.getTicketAttachments(
				ticketEntryId, WorkflowConstants.STATUS_APPROVED);

		List<String> ticketAttachmentContents = new ArrayList<>();
		List<String> ticketAttachmentFileNames = new ArrayList<>();

		long indexMaxSize =
			yithroTicketConfiguration.ticketAttachmentIndexingMaxSize();

		for (TicketAttachment ticketAttachment : ticketAttachments) {
			ticketAttachmentFileNames.add(ticketAttachment.getFileName());

			if ((indexMaxSize != -1) &&
				(ticketAttachment.getFileSize() > indexMaxSize)) {

				continue;
			}

			if (!ArrayUtil.contains(
					yithroTicketConfiguration.
						ticketAttachmentIndexingExtensions(),
					FileUtil.getExtension(ticketAttachment.getFileName()))) {

				continue;
			}

			try (InputStream is = ticketAttachmentLocalService.getFileAsStream(
					ticketAttachment)) {

				ticketAttachmentContents.add(
					FileUtil.extractText(is, ticketAttachment.getFileName()));
			}
			catch (Exception e) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to index " + ticketAttachment.getFileName(), e);
				}
			}
		}

		document.addText(
			"ticketAttachmentContents",
			ArrayUtil.toStringArray(ticketAttachmentContents.toArray()));
		document.addText(
			"ticketAttachmentFileNames",
			ArrayUtil.toStringArray(ticketAttachmentFileNames.toArray()));
	}

	protected void contributeTicketComments(
		Document document, long ticketEntryId) {

		for (int visibility : Visibilities.VALUES) {
			List<TicketComment> ticketComments =
				ticketCommentLocalService.getTicketComments(
					ticketEntryId, new int[] {visibility},
					new int[] {WorkflowConstants.STATUS_APPROVED});

			String[] ticketEntryComments = new String[ticketComments.size()];

			for (int i = 0; i < ticketComments.size(); i++) {
				TicketComment ticketComment = ticketComments.get(i);

				ticketEntryComments[i] = ticketComment.getBody();
			}

			document.addText(
				Visibilities.getLabel(visibility) + "_ticketEntryComments",
				ticketEntryComments);
		}
	}

	protected void contributeTicketWorkers(
		Document document, long ticketEntryId) {

		List<TicketWorker> ticketWorkers =
			ticketWorkerLocalService.getTicketWorkers(ticketEntryId);

		List<Long> ticketWorkerUserIds = new ArrayList<>();

		for (TicketWorker ticketWorker : ticketWorkers) {
			ticketWorkerUserIds.add(ticketWorker.getUserId());
		}

		document.addKeyword(
			"ticketWorkerUserIds",
			ArrayUtil.toArray(ticketWorkerUserIds.toArray(new Long[0])));
	}

	@Reference
	protected SubscriptionLocalService subscriptionLocalService;

	@Reference
	protected TicketAttachmentLocalService ticketAttachmentLocalService;

	@Reference
	protected TicketCommentLocalService ticketCommentLocalService;

	@Reference
	protected TicketFlagLocalService ticketFlagLocalService;

	@Reference
	protected TicketWorkerLocalService ticketWorkerLocalService;

	@Reference
	protected UserLocalService userLocalService;

	protected volatile YithroTicketConfiguration yithroTicketConfiguration;

	private static final Log _log = LogFactoryUtil.getLog(
		TicketEntryModelDocumentContributor.class);

}