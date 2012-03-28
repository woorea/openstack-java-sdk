package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.keystone.KeystoneTenant;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateTenantActivity extends AbstractActivity implements CreateTenantView.Presenter {
	
	private static final CreateTenantView VIEW = new CreateTenantView();

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}
	
	//@Override
		public void createTenant(String name, String description, Boolean enabled) {
			KeystoneTenant service = new KeystoneTenant();
			service.setName(name);
			service.setDescription(description);
			service.setEnabled(enabled);
			OpenStackClient.IDENTITY.createTenant(service, new DefaultAsyncCallback<Tenant>() {

				@Override
				public void onSuccess(Tenant result) {
					//refresh
					UI.MODAL.hide(true);
					
				}
			});
		}

}
