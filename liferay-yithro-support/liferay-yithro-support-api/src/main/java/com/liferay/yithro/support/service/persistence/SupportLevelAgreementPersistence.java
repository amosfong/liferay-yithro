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

package com.liferay.yithro.support.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.yithro.support.exception.NoSuchSupportLevelAgreementException;
import com.liferay.yithro.support.model.SupportLevelAgreement;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the support level agreement service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SupportLevelAgreementUtil
 * @generated
 */
@ProviderType
public interface SupportLevelAgreementPersistence
	extends BasePersistence<SupportLevelAgreement> {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SupportLevelAgreementUtil} to access the support level agreement persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the support level agreement where name = &#63; or throws a <code>NoSuchSupportLevelAgreementException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching support level agreement
	 * @throws NoSuchSupportLevelAgreementException if a matching support level agreement could not be found
	 */
	public SupportLevelAgreement findByName(String name)
		throws NoSuchSupportLevelAgreementException;

	/**
	 * Returns the support level agreement where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching support level agreement, or <code>null</code> if a matching support level agreement could not be found
	 */
	public SupportLevelAgreement fetchByName(String name);

	/**
	 * Returns the support level agreement where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching support level agreement, or <code>null</code> if a matching support level agreement could not be found
	 */
	public SupportLevelAgreement fetchByName(
		String name, boolean useFinderCache);

	/**
	 * Removes the support level agreement where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the support level agreement that was removed
	 */
	public SupportLevelAgreement removeByName(String name)
		throws NoSuchSupportLevelAgreementException;

	/**
	 * Returns the number of support level agreements where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching support level agreements
	 */
	public int countByName(String name);

	/**
	 * Caches the support level agreement in the entity cache if it is enabled.
	 *
	 * @param supportLevelAgreement the support level agreement
	 */
	public void cacheResult(SupportLevelAgreement supportLevelAgreement);

	/**
	 * Caches the support level agreements in the entity cache if it is enabled.
	 *
	 * @param supportLevelAgreements the support level agreements
	 */
	public void cacheResult(
		java.util.List<SupportLevelAgreement> supportLevelAgreements);

	/**
	 * Creates a new support level agreement with the primary key. Does not add the support level agreement to the database.
	 *
	 * @param supportLevelAgreementId the primary key for the new support level agreement
	 * @return the new support level agreement
	 */
	public SupportLevelAgreement create(long supportLevelAgreementId);

	/**
	 * Removes the support level agreement with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement that was removed
	 * @throws NoSuchSupportLevelAgreementException if a support level agreement with the primary key could not be found
	 */
	public SupportLevelAgreement remove(long supportLevelAgreementId)
		throws NoSuchSupportLevelAgreementException;

	public SupportLevelAgreement updateImpl(
		SupportLevelAgreement supportLevelAgreement);

	/**
	 * Returns the support level agreement with the primary key or throws a <code>NoSuchSupportLevelAgreementException</code> if it could not be found.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement
	 * @throws NoSuchSupportLevelAgreementException if a support level agreement with the primary key could not be found
	 */
	public SupportLevelAgreement findByPrimaryKey(long supportLevelAgreementId)
		throws NoSuchSupportLevelAgreementException;

	/**
	 * Returns the support level agreement with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param supportLevelAgreementId the primary key of the support level agreement
	 * @return the support level agreement, or <code>null</code> if a support level agreement with the primary key could not be found
	 */
	public SupportLevelAgreement fetchByPrimaryKey(
		long supportLevelAgreementId);

	/**
	 * Returns all the support level agreements.
	 *
	 * @return the support level agreements
	 */
	public java.util.List<SupportLevelAgreement> findAll();

	/**
	 * Returns a range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @return the range of support level agreements
	 */
	public java.util.List<SupportLevelAgreement> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of support level agreements
	 */
	public java.util.List<SupportLevelAgreement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportLevelAgreement>
			orderByComparator);

	/**
	 * Returns an ordered range of all the support level agreements.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SupportLevelAgreementModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of support level agreements
	 * @param end the upper bound of the range of support level agreements (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of support level agreements
	 */
	public java.util.List<SupportLevelAgreement> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<SupportLevelAgreement>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the support level agreements from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of support level agreements.
	 *
	 * @return the number of support level agreements
	 */
	public int countAll();

}