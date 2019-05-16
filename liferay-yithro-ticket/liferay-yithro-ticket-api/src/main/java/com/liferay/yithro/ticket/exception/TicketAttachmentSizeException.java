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

package com.liferay.yithro.ticket.exception;

import com.liferay.portal.kernel.exception.PortalException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Amos Fong
 */
@ProviderType
public class TicketAttachmentSizeException extends PortalException {

	public TicketAttachmentSizeException() {
	}

	public TicketAttachmentSizeException(String msg) {
		super(msg);
	}

	public TicketAttachmentSizeException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public TicketAttachmentSizeException(Throwable cause) {
		super(cause);
	}

	public static class MustNotBeEmpty extends TicketAttachmentSizeException {

		public MustNotBeEmpty(String fileName) {
			super(String.format("%s contains no data", fileName));
		}

	}

	public static class MustNotExceedMaximumSize
		extends TicketAttachmentSizeException {

		public MustNotExceedMaximumSize(String fileName, long fileSize) {
			super(
				String.format(
					"%s with size %s exceeds the maximum file upload size",
					fileName, fileSize));
		}

	}

}