package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.Endpoint;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateEndpointActivity extends AbstractActivity implements CreateEndpointView.Presenter {

	private static final CreateEndpointView VIEW = new CreateEndpointView();
	
	

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}
	
	@Override
	public void createEndpoint(Endpoint endpoint) {
		OpenStackClient.IDENTITY.createEndpoint(endpoint, new DefaultAsyncCallback<Endpoint>() {

			@Override
			public void onSuccess(Endpoint result) {
				//refresh
				UI.MODAL.hide(true);
				
			}
		});
	}

}
