package org.openstack.ui.client.view.compute.volume;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateVolumeActivity extends AbstractActivity implements CreateVolumeView.Presenter {
	
	private static final CreateVolumeView VIEW = new CreateVolumeView();

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}

}
