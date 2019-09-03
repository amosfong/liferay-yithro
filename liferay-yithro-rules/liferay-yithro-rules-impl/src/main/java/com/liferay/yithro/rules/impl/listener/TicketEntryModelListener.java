/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.yithro.rules.impl.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.yithro.rules.model.Action;
import com.liferay.yithro.rules.model.Rule;
import com.liferay.yithro.rules.service.ActionLocalService;
import com.liferay.yithro.rules.service.RuleLocalService;
import com.liferay.yithro.ticket.model.TicketEntry;
import com.liferay.yithro.ticket.service.TicketEntryLocalService;

import java.lang.reflect.Field;

import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = ModelListener.class)
public class TicketEntryModelListener extends BaseModelListener<TicketEntry> {

	@Override
	public void onAfterCreate(TicketEntry ticketEntry)
		throws ModelListenerException {

		Map<String, ?> map = ticketEntry.getModelAttributes();

		List<Rule> rules = _ruleLocalService.findByTA_TO(
			"create", "TicketEntry");

		for (Rule rule : rules) {
			if (rule.evaluate(map)) {
				List<Action> actions = _actionLocalService.getActions(
					rule.getRuleId());

				for (Action action : actions) {
					String entity = action.getEntity();

					if (entity.equals("TicketEntry")) {
						try {
							setField(action, ticketEntry);
						}
						catch (Exception e) {
							throw new ModelListenerException(e);
						}
					}
				}
			}
		}
	}

	@Override
	public void onAfterUpdate(TicketEntry ticketEntry)
		throws ModelListenerException {

		Map<String, ?> map = ticketEntry.getModelAttributes();

		List<Rule> rules = _ruleLocalService.findByTA_TO(
			"update", "TicketEntry");

		for (Rule rule : rules) {
			if (rule.evaluate(map)) {
				List<Action> actions = _actionLocalService.getActions(
					rule.getRuleId());

				for (Action action : actions) {
					String entity = action.getEntity();

					if (entity.equals("TicketEntry")) {
						try {
							setField(action, ticketEntry);
						}
						catch (Exception e) {
							throw new ModelListenerException(e);
						}
					}
				}
			}
		}
	}

	protected void setField(Action action, TicketEntry ticketEntry)
		throws Exception {

		try {
			Class<?> clazz = ticketEntry.getClass();

			Field field = clazz.getDeclaredField(action.getName());

			field.setAccessible(true);
			field.set(ticketEntry, action.getValue());
		}
		catch (Exception e) {
			throw new Exception(e);
		}

		_ticketEntryLocalService.updateTicketEntry(ticketEntry);
	}

	@Reference
	private ActionLocalService _actionLocalService;

	@Reference
	private RuleLocalService _ruleLocalService;

	@Reference
	private TicketEntryLocalService _ticketEntryLocalService;

}