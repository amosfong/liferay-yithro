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

package com.liferay.yithro.ticket.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.document.library.kernel.store.Store;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.File;

/**
 * @author Amos Fong
 */
@ProviderType
public class TicketAttachmentImpl extends TicketAttachmentBaseImpl {

	public TicketAttachmentImpl() {
	}

	public File getFile() {
		return _file;
	}

	public String getFileDir() {
		StringBundler sb = new StringBundler(4);

		sb.append("yithro/ticket/");
		sb.append(getTicketEntryId());
		sb.append(StringPool.SLASH);
		sb.append(getTicketAttachmentId());

		return sb.toString();
	}

	public String getFilePath() {
		StringBundler sb = new StringBundler(3);

		sb.append(getFileDir());
		sb.append(StringPool.SLASH);
		sb.append(Store.VERSION_DEFAULT);

		return sb.toString();
	}

	public void setFile(File file) {
		_file = file;
	}

	private File _file;

}