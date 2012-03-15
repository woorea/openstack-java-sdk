package org.openstack.ui.client.view.compute.widgets;

import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PopupPanel;

public abstract class PopupPicker<T> extends Composite implements LeafValueEditor<T>, HasClickHandlers {

	private static final String CARET = "<span class=\"caret\" style=\"float: right\"></span>";

	protected PopupPanel popup = new PopupPanel(true, true);

	protected T value;

	protected Button dropdown;

	public PopupPicker() {
		dropdown = new Button(CARET, new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				popup.showRelativeTo(dropdown);

			}
		});
		dropdown.setStyleName("btn");
		initWidget(dropdown);
		getElement().getStyle().setProperty("textAlign", "left");
	}

	protected void setText(String text) {
		dropdown.setHTML(text + " " + CARET);
	}

	@Override
	public HandlerRegistration addClickHandler(ClickHandler handler) {
		return dropdown.addClickHandler(handler);
	}
	
	@Override
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public T getValue() {
		return this.value;
	}

}
