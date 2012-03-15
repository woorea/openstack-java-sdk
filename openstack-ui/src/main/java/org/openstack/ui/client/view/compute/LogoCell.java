package org.openstack.ui.client.view.compute;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

public class LogoCell extends AbstractCell<String> {

	interface Templates extends SafeHtmlTemplates {
		@SafeHtmlTemplates.Template("<img src=\"{0}\" width=\"60\" />")
		SafeHtml cell(String value);
	}

	private static Templates templates = GWT.create(Templates.class);

	@Override
	public void render(Context context, String value, SafeHtmlBuilder sb) {
		if (value == null) {
			return;
		}

		// Use the template to create the Cell's html.
		SafeHtml rendered = templates.cell("img/logos/debian.png");
		sb.append(rendered);
	}

}