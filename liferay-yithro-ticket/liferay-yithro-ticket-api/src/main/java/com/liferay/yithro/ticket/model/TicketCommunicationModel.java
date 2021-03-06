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

package com.liferay.yithro.ticket.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.ShardedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the TicketCommunication service. Represents a row in the &quot;Yithro_TicketCommunication&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.yithro.ticket.model.impl.TicketCommunicationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.yithro.ticket.model.impl.TicketCommunicationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TicketCommunication
 * @generated
 */
@ProviderType
public interface TicketCommunicationModel
	extends BaseModel<TicketCommunication>, ShardedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a ticket communication model instance should use the {@link TicketCommunication} interface instead.
	 */

	/**
	 * Returns the primary key of this ticket communication.
	 *
	 * @return the primary key of this ticket communication
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this ticket communication.
	 *
	 * @param primaryKey the primary key of this ticket communication
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ticket communication ID of this ticket communication.
	 *
	 * @return the ticket communication ID of this ticket communication
	 */
	public long getTicketCommunicationId();

	/**
	 * Sets the ticket communication ID of this ticket communication.
	 *
	 * @param ticketCommunicationId the ticket communication ID of this ticket communication
	 */
	public void setTicketCommunicationId(long ticketCommunicationId);

	/**
	 * Returns the company ID of this ticket communication.
	 *
	 * @return the company ID of this ticket communication
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this ticket communication.
	 *
	 * @param companyId the company ID of this ticket communication
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this ticket communication.
	 *
	 * @return the user ID of this ticket communication
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this ticket communication.
	 *
	 * @param userId the user ID of this ticket communication
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this ticket communication.
	 *
	 * @return the user uuid of this ticket communication
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this ticket communication.
	 *
	 * @param userUuid the user uuid of this ticket communication
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the create date of this ticket communication.
	 *
	 * @return the create date of this ticket communication
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this ticket communication.
	 *
	 * @param createDate the create date of this ticket communication
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this ticket communication.
	 *
	 * @return the modified date of this ticket communication
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this ticket communication.
	 *
	 * @param modifiedDate the modified date of this ticket communication
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the ticket entry ID of this ticket communication.
	 *
	 * @return the ticket entry ID of this ticket communication
	 */
	public long getTicketEntryId();

	/**
	 * Sets the ticket entry ID of this ticket communication.
	 *
	 * @param ticketEntryId the ticket entry ID of this ticket communication
	 */
	public void setTicketEntryId(long ticketEntryId);

	/**
	 * Returns the channel of this ticket communication.
	 *
	 * @return the channel of this ticket communication
	 */
	@AutoEscape
	public String getChannel();

	/**
	 * Sets the channel of this ticket communication.
	 *
	 * @param channel the channel of this ticket communication
	 */
	public void setChannel(String channel);

	/**
	 * Returns the data of this ticket communication.
	 *
	 * @return the data of this ticket communication
	 */
	@AutoEscape
	public String getData();

	/**
	 * Sets the data of this ticket communication.
	 *
	 * @param data the data of this ticket communication
	 */
	public void setData(String data);

	/**
	 * Returns the visibility of this ticket communication.
	 *
	 * @return the visibility of this ticket communication
	 */
	public int getVisibility();

	/**
	 * Sets the visibility of this ticket communication.
	 *
	 * @param visibility the visibility of this ticket communication
	 */
	public void setVisibility(int visibility);

}