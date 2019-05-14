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

package com.liferay.yithro.support.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link SupportLabor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportLabor
 * @generated
 */
@ProviderType
public class SupportLaborWrapper
	extends BaseModelWrapper<SupportLabor>
	implements SupportLabor, ModelWrapper<SupportLabor> {

	public SupportLaborWrapper(SupportLabor supportLabor) {
		super(supportLabor);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("supportLaborId", getSupportLaborId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("name", getName());
		attributes.put("description", getDescription());
		attributes.put("timeZoneId", getTimeZoneId());
		attributes.put("sunOpen", getSunOpen());
		attributes.put("sunClose", getSunClose());
		attributes.put("monOpen", getMonOpen());
		attributes.put("monClose", getMonClose());
		attributes.put("tueOpen", getTueOpen());
		attributes.put("tueClose", getTueClose());
		attributes.put("wedOpen", getWedOpen());
		attributes.put("wedClose", getWedClose());
		attributes.put("thuOpen", getThuOpen());
		attributes.put("thuClose", getThuClose());
		attributes.put("friOpen", getFriOpen());
		attributes.put("friClose", getFriClose());
		attributes.put("satOpen", getSatOpen());
		attributes.put("satClose", getSatClose());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long supportLaborId = (Long)attributes.get("supportLaborId");

		if (supportLaborId != null) {
			setSupportLaborId(supportLaborId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String timeZoneId = (String)attributes.get("timeZoneId");

		if (timeZoneId != null) {
			setTimeZoneId(timeZoneId);
		}

		Integer sunOpen = (Integer)attributes.get("sunOpen");

		if (sunOpen != null) {
			setSunOpen(sunOpen);
		}

		Integer sunClose = (Integer)attributes.get("sunClose");

		if (sunClose != null) {
			setSunClose(sunClose);
		}

		Integer monOpen = (Integer)attributes.get("monOpen");

		if (monOpen != null) {
			setMonOpen(monOpen);
		}

		Integer monClose = (Integer)attributes.get("monClose");

		if (monClose != null) {
			setMonClose(monClose);
		}

		Integer tueOpen = (Integer)attributes.get("tueOpen");

		if (tueOpen != null) {
			setTueOpen(tueOpen);
		}

		Integer tueClose = (Integer)attributes.get("tueClose");

		if (tueClose != null) {
			setTueClose(tueClose);
		}

		Integer wedOpen = (Integer)attributes.get("wedOpen");

		if (wedOpen != null) {
			setWedOpen(wedOpen);
		}

		Integer wedClose = (Integer)attributes.get("wedClose");

		if (wedClose != null) {
			setWedClose(wedClose);
		}

		Integer thuOpen = (Integer)attributes.get("thuOpen");

		if (thuOpen != null) {
			setThuOpen(thuOpen);
		}

		Integer thuClose = (Integer)attributes.get("thuClose");

		if (thuClose != null) {
			setThuClose(thuClose);
		}

		Integer friOpen = (Integer)attributes.get("friOpen");

		if (friOpen != null) {
			setFriOpen(friOpen);
		}

		Integer friClose = (Integer)attributes.get("friClose");

		if (friClose != null) {
			setFriClose(friClose);
		}

		Integer satOpen = (Integer)attributes.get("satOpen");

		if (satOpen != null) {
			setSatOpen(satOpen);
		}

		Integer satClose = (Integer)attributes.get("satClose");

		if (satClose != null) {
			setSatClose(satClose);
		}
	}

	@Override
	public int getCloseTime(int day) {
		return model.getCloseTime(day);
	}

	/**
	 * Returns the company ID of this support labor.
	 *
	 * @return the company ID of this support labor
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the description of this support labor.
	 *
	 * @return the description of this support labor
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the fri close of this support labor.
	 *
	 * @return the fri close of this support labor
	 */
	@Override
	public int getFriClose() {
		return model.getFriClose();
	}

	/**
	 * Returns the fri open of this support labor.
	 *
	 * @return the fri open of this support labor
	 */
	@Override
	public int getFriOpen() {
		return model.getFriOpen();
	}

	/**
	 * Returns the mon close of this support labor.
	 *
	 * @return the mon close of this support labor
	 */
	@Override
	public int getMonClose() {
		return model.getMonClose();
	}

	/**
	 * Returns the mon open of this support labor.
	 *
	 * @return the mon open of this support labor
	 */
	@Override
	public int getMonOpen() {
		return model.getMonOpen();
	}

	/**
	 * Returns the name of this support labor.
	 *
	 * @return the name of this support labor
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	@Override
	public int getOpenTime(int day) {
		return model.getOpenTime(day);
	}

	/**
	 * Returns the primary key of this support labor.
	 *
	 * @return the primary key of this support labor
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sat close of this support labor.
	 *
	 * @return the sat close of this support labor
	 */
	@Override
	public int getSatClose() {
		return model.getSatClose();
	}

	/**
	 * Returns the sat open of this support labor.
	 *
	 * @return the sat open of this support labor
	 */
	@Override
	public int getSatOpen() {
		return model.getSatOpen();
	}

	/**
	 * Returns the sun close of this support labor.
	 *
	 * @return the sun close of this support labor
	 */
	@Override
	public int getSunClose() {
		return model.getSunClose();
	}

	/**
	 * Returns the sun open of this support labor.
	 *
	 * @return the sun open of this support labor
	 */
	@Override
	public int getSunOpen() {
		return model.getSunOpen();
	}

	/**
	 * Returns the support labor ID of this support labor.
	 *
	 * @return the support labor ID of this support labor
	 */
	@Override
	public long getSupportLaborId() {
		return model.getSupportLaborId();
	}

	/**
	 * Returns the thu close of this support labor.
	 *
	 * @return the thu close of this support labor
	 */
	@Override
	public int getThuClose() {
		return model.getThuClose();
	}

	/**
	 * Returns the thu open of this support labor.
	 *
	 * @return the thu open of this support labor
	 */
	@Override
	public int getThuOpen() {
		return model.getThuOpen();
	}

	/**
	 * Returns the time zone ID of this support labor.
	 *
	 * @return the time zone ID of this support labor
	 */
	@Override
	public String getTimeZoneId() {
		return model.getTimeZoneId();
	}

	/**
	 * Returns the tue close of this support labor.
	 *
	 * @return the tue close of this support labor
	 */
	@Override
	public int getTueClose() {
		return model.getTueClose();
	}

	/**
	 * Returns the tue open of this support labor.
	 *
	 * @return the tue open of this support labor
	 */
	@Override
	public int getTueOpen() {
		return model.getTueOpen();
	}

	/**
	 * Returns the user ID of this support labor.
	 *
	 * @return the user ID of this support labor
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this support labor.
	 *
	 * @return the user name of this support labor
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this support labor.
	 *
	 * @return the user uuid of this support labor
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the wed close of this support labor.
	 *
	 * @return the wed close of this support labor
	 */
	@Override
	public int getWedClose() {
		return model.getWedClose();
	}

	/**
	 * Returns the wed open of this support labor.
	 *
	 * @return the wed open of this support labor
	 */
	@Override
	public int getWedOpen() {
		return model.getWedOpen();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this support labor.
	 *
	 * @param companyId the company ID of this support labor
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the description of this support labor.
	 *
	 * @param description the description of this support labor
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the fri close of this support labor.
	 *
	 * @param friClose the fri close of this support labor
	 */
	@Override
	public void setFriClose(int friClose) {
		model.setFriClose(friClose);
	}

	/**
	 * Sets the fri open of this support labor.
	 *
	 * @param friOpen the fri open of this support labor
	 */
	@Override
	public void setFriOpen(int friOpen) {
		model.setFriOpen(friOpen);
	}

	/**
	 * Sets the mon close of this support labor.
	 *
	 * @param monClose the mon close of this support labor
	 */
	@Override
	public void setMonClose(int monClose) {
		model.setMonClose(monClose);
	}

	/**
	 * Sets the mon open of this support labor.
	 *
	 * @param monOpen the mon open of this support labor
	 */
	@Override
	public void setMonOpen(int monOpen) {
		model.setMonOpen(monOpen);
	}

	/**
	 * Sets the name of this support labor.
	 *
	 * @param name the name of this support labor
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this support labor.
	 *
	 * @param primaryKey the primary key of this support labor
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sat close of this support labor.
	 *
	 * @param satClose the sat close of this support labor
	 */
	@Override
	public void setSatClose(int satClose) {
		model.setSatClose(satClose);
	}

	/**
	 * Sets the sat open of this support labor.
	 *
	 * @param satOpen the sat open of this support labor
	 */
	@Override
	public void setSatOpen(int satOpen) {
		model.setSatOpen(satOpen);
	}

	/**
	 * Sets the sun close of this support labor.
	 *
	 * @param sunClose the sun close of this support labor
	 */
	@Override
	public void setSunClose(int sunClose) {
		model.setSunClose(sunClose);
	}

	/**
	 * Sets the sun open of this support labor.
	 *
	 * @param sunOpen the sun open of this support labor
	 */
	@Override
	public void setSunOpen(int sunOpen) {
		model.setSunOpen(sunOpen);
	}

	/**
	 * Sets the support labor ID of this support labor.
	 *
	 * @param supportLaborId the support labor ID of this support labor
	 */
	@Override
	public void setSupportLaborId(long supportLaborId) {
		model.setSupportLaborId(supportLaborId);
	}

	/**
	 * Sets the thu close of this support labor.
	 *
	 * @param thuClose the thu close of this support labor
	 */
	@Override
	public void setThuClose(int thuClose) {
		model.setThuClose(thuClose);
	}

	/**
	 * Sets the thu open of this support labor.
	 *
	 * @param thuOpen the thu open of this support labor
	 */
	@Override
	public void setThuOpen(int thuOpen) {
		model.setThuOpen(thuOpen);
	}

	/**
	 * Sets the time zone ID of this support labor.
	 *
	 * @param timeZoneId the time zone ID of this support labor
	 */
	@Override
	public void setTimeZoneId(String timeZoneId) {
		model.setTimeZoneId(timeZoneId);
	}

	/**
	 * Sets the tue close of this support labor.
	 *
	 * @param tueClose the tue close of this support labor
	 */
	@Override
	public void setTueClose(int tueClose) {
		model.setTueClose(tueClose);
	}

	/**
	 * Sets the tue open of this support labor.
	 *
	 * @param tueOpen the tue open of this support labor
	 */
	@Override
	public void setTueOpen(int tueOpen) {
		model.setTueOpen(tueOpen);
	}

	/**
	 * Sets the user ID of this support labor.
	 *
	 * @param userId the user ID of this support labor
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this support labor.
	 *
	 * @param userName the user name of this support labor
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this support labor.
	 *
	 * @param userUuid the user uuid of this support labor
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the wed close of this support labor.
	 *
	 * @param wedClose the wed close of this support labor
	 */
	@Override
	public void setWedClose(int wedClose) {
		model.setWedClose(wedClose);
	}

	/**
	 * Sets the wed open of this support labor.
	 *
	 * @param wedOpen the wed open of this support labor
	 */
	@Override
	public void setWedOpen(int wedOpen) {
		model.setWedOpen(wedOpen);
	}

	@Override
	protected SupportLaborWrapper wrap(SupportLabor supportLabor) {
		return new SupportLaborWrapper(supportLabor);
	}

}