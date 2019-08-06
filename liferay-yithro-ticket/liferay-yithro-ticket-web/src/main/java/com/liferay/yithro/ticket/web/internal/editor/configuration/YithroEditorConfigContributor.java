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

package com.liferay.yithro.ticket.web.internal.editor.configuration;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.parsers.bbcode.BBCodeTranslatorUtil;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.AggregateResourceBundleLoader;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ResourceBundleLoader;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.yithro.ticket.constants.TicketPortletKeys;

import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * @author Amos Fong
 */
@Component(
	immediate = true,
	property = {
		"editor.name=alloyeditor",
		"javax.portlet.name=" + TicketPortletKeys.MY_REQUESTED_TICKETS,
		"javax.portlet.name=" + TicketPortletKeys.SIMPLE_TICKET_SEARCH
	},
	service = EditorConfigContributor.class
)
public class YithroEditorConfigContributor extends BaseEditorConfigContributor {

	@Override
	public void populateConfigJSONObject(
		JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
		ThemeDisplay themeDisplay,
		RequestBackedPortletURLFactory requestBackedPortletURLFactory) {

		jsonObject.put(
			"allowedContent", Boolean.TRUE
		).put(
			"enterMode", 1
		).put(
			"forceEnterMode", Boolean.TRUE
		).put(
			"format_tags", "p;pre"
		).put(
			"lang", getLangJSONObject(inputEditorTaglibAttributes)
		);

		String removePlugins = jsonObject.getString("removePlugins");

		StringBundler sb = new StringBundler(3);

		sb.append("bidi,div,flash,font,forms,indentblock,keystrokes,maximize,");
		sb.append("newpage,pagebreak,preview,print,save,showblocks,smiley,");
		sb.append("stylescombo,templates,video");

		jsonObject.put(
			"removePlugins",
			removePlugins.concat(
				","
			).concat(
				sb.toString()
			)
		).put(
			"smiley_images",
			toJSONArray(BBCodeTranslatorUtil.getEmoticonFiles())
		).put(
			"smiley_path",
			HtmlUtil.escape(themeDisplay.getPathThemeImages()) + "/emoticons/"
		).put(
			"smiley_symbols",
			toJSONArray(BBCodeTranslatorUtil.getEmoticonSymbols())
		).put(
			"toolbars", getToolbarsJSONObject(themeDisplay.getLocale())
		);
	}

	@Activate
	protected void activate() {
		_aggregateResourceBundleLoader = new AggregateResourceBundleLoader(
			_resourceBundleLoader,
			ResourceBundleLoaderUtil.getPortalResourceBundleLoader());
	}

	protected JSONObject getLangJSONObject(
		Map<String, Object> inputEditorTaglibAttributes) {

		return JSONUtil.put(
			"code",
			LanguageUtil.get(
				getContentsLocale(inputEditorTaglibAttributes), "code"));
	}

	protected JSONArray getSelectionsJSONArray(Locale locale) {
		return JSONUtil.put(
			JSONUtil.put(
				"buttons",
				JSONUtil.put(
					getStyleFormatsJSONObject(locale), "bold", "italic",
					"underline", "ol", "ul", "linkBrowse", "quote")
			).put(
				"name", "text"
			).put(
				"test", "AlloyEditor.SelectionTest.text"
			));
	}

	protected JSONObject getStyleFormatJSONObject(
		String styleFormatName, String element, String cssClass, int type) {

		return JSONUtil.put(
			"name", styleFormatName
		).put(
			"style", getStyleJSONObject(element, cssClass, type)
		);
	}

	protected JSONArray getStyleFormatsJSONArray(Locale locale) {
		ResourceBundle resourceBundle = null;

		try {
			resourceBundle = _aggregateResourceBundleLoader.loadResourceBundle(
				locale);
		}
		catch (MissingResourceException mre) {
			resourceBundle = ResourceBundleUtil.EMPTY_RESOURCE_BUNDLE;
		}

		return JSONUtil.put(
			getStyleFormatJSONObject(
				LanguageUtil.get(resourceBundle, "normal"), "p", null,
				_CKEDITOR_STYLE_BLOCK),
			getStyleFormatJSONObject(
				LanguageUtil.format(resourceBundle, "heading-x", "1"), "h1",
				null, _CKEDITOR_STYLE_BLOCK),
			getStyleFormatJSONObject(
				LanguageUtil.format(resourceBundle, "heading-x", "2"), "h2",
				null, _CKEDITOR_STYLE_BLOCK),
			getStyleFormatJSONObject(
				LanguageUtil.format(resourceBundle, "heading-x", "3"), "h3",
				null, _CKEDITOR_STYLE_BLOCK),
			getStyleFormatJSONObject(
				LanguageUtil.format(resourceBundle, "heading-x", "4"), "h4",
				null, _CKEDITOR_STYLE_BLOCK),
			getStyleFormatJSONObject(
				LanguageUtil.get(resourceBundle, "preformatted-text"), "pre",
				null, _CKEDITOR_STYLE_BLOCK),
			getStyleFormatJSONObject(
				LanguageUtil.get(resourceBundle, "cited-work"), "cite", null,
				_CKEDITOR_STYLE_INLINE),
			getStyleFormatJSONObject(
				LanguageUtil.get(resourceBundle, "computer-code"), "code", null,
				_CKEDITOR_STYLE_INLINE),
			getStyleFormatJSONObject(
				LanguageUtil.get(resourceBundle, "info-message"), "div",
				"portlet-msg-info", _CKEDITOR_STYLE_BLOCK),
			getStyleFormatJSONObject(
				LanguageUtil.get(resourceBundle, "alert-message"), "div",
				"portlet-msg-alert", _CKEDITOR_STYLE_BLOCK),
			getStyleFormatJSONObject(
				LanguageUtil.get(resourceBundle, "error-message"), "div",
				"portlet-msg-error", _CKEDITOR_STYLE_BLOCK));
	}

	protected JSONObject getStyleFormatsJSONObject(Locale locale) {
		JSONObject stylesJSONObject = JSONUtil.put(
			"styles", getStyleFormatsJSONArray(locale));

		return JSONUtil.put(
			"cfg", stylesJSONObject
		).put(
			"name", "styles"
		);
	}

	protected JSONObject getStyleJSONObject(
		String element, String cssClass, int type) {

		JSONObject styleJSONObject = JSONFactoryUtil.createJSONObject();

		if (Validator.isNotNull(cssClass)) {
			JSONObject attributesJSONObject = JSONUtil.put("class", cssClass);

			styleJSONObject.put("attributes", attributesJSONObject);
		}

		styleJSONObject.put(
			"element", element
		).put(
			"type", type
		);

		return styleJSONObject;
	}

	protected JSONObject getToolbarsJSONObject(Locale locale) {
		return JSONUtil.put(
			"styles",
			JSONUtil.put(
				"selections", getSelectionsJSONArray(locale)
			).put(
				"tabIndex", 1
			));
	}

	private static final int _CKEDITOR_STYLE_BLOCK = 1;

	private static final int _CKEDITOR_STYLE_INLINE = 2;

	private ResourceBundleLoader _aggregateResourceBundleLoader;

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(bundle.symbolic.name=com.liferay.frontend.editor.lang)"
	)
	private volatile ResourceBundleLoader _resourceBundleLoader;

}