package org.openstack.ui.client.view.compute;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class ComputeView extends Composite {

	private static Binder uiBinder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, ComputeView> {
	}
	
	@UiField ComputeNavigation navigation;
	@UiField SimpleLayoutPanel content;

	public ComputeView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
