package org.openstack.ui.client.view.compute.widgets;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class ComputeNavigation extends Composite {

	private static ComputeNavigationUiBinder uiBinder = GWT
			.create(ComputeNavigationUiBinder.class);

	interface ComputeNavigationUiBinder extends
			UiBinder<Widget, ComputeNavigation> {
	}

	public ComputeNavigation() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
