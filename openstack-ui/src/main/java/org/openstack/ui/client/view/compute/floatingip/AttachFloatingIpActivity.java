package org.openstack.ui.client.view.compute.floatingip;

import org.openstack.model.identity.Role;
import org.openstack.model.identity.keystone.KeystoneRole;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.view.identity.tenant.CreateRoleView;
import org.openstack.ui.client.view.identity.tenant.CreateRoleView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AttachFloatingIpActivity extends AbstractActivity implements CreateRoleView.Presenter {

	private static final CreateRoleView VIEW = new CreateRoleView();

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}
	
	@Override
	public void createRole(String name) {
		KeystoneRole service = new KeystoneRole();
		service.setName(name);
		OpenStackClient.IDENTITY.createRole(service, new DefaultAsyncCallback<Role>() {

			@Override
			public void onSuccess(Role result) {
				//refresh
				UI.MODAL.hide(true);
				
			}
		});
	}

}
