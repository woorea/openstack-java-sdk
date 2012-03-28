package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.Service;
import org.openstack.model.identity.keystone.KeystoneService;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateServiceActivity extends AbstractActivity implements CreateServiceView.Presenter {

	private static final CreateServiceView VIEW = new CreateServiceView();

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}

	@Override
	public void createService(String type, String name, String description) {
		KeystoneService service = new KeystoneService();
		service.setType(type);
		service.setName(name);
		service.setDescription(description);
		OpenStackClient.IDENTITY.createService(service, new DefaultAsyncCallback<Service>() {

			@Override
			public void onSuccess(Service result) {
				//refresh
				UI.MODAL.hide(true);
				
			}
		});
	}

}
