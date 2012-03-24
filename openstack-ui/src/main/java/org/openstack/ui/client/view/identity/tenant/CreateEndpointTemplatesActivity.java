package org.openstack.ui.client.view.identity.tenant;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateEndpointTemplatesActivity extends AbstractActivity {

	private static final CreateEndpointTemplatesView VIEW = new CreateEndpointTemplatesView();

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(VIEW);
	}

}
