package org.openstack.ui.client;

import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class UI implements EntryPoint, UIView.Presenter {
	
	public static final EventBus EVENT_BUS = new SimpleEventBus();
	
	public static final PlaceController PLACE_CONTROLLER = new PlaceController(EVENT_BUS);
	
	public static final PopupPanel MODAL = new PopupPanel(true, true);

	@Override
	public void onModuleLoad() {
		
		final UIView ui = new UIView();
		ui.setPresenter(UI.this);
		
		OpenStackClient.IDENTITY.getSessionData(new DefaultAsyncCallback<KeystoneAccess>() {

			@Override
			public void onSuccess(KeystoneAccess access) {
				
				OpenStackClient.access = access;
				
				OpenStackClient.IDENTITY.listTenants(new DefaultAsyncCallback<KeystoneTenantList>() {

					@Override
					public void onSuccess(KeystoneTenantList result) {
						OpenStackClient.tenants = result.getList();
						for(KeystoneTenant tenant : OpenStackClient.getTenants()) {
		                    ui.tenants.addItem(tenant.getName(), tenant.getId());
						}
						
						for(String service : new String[]{"compute","identity","images","storage"}) {
		                    ui.services.addItem(service);
						}

						RootLayoutPanel.get().add(ui);

						UIPlaceHistoryMapper historyMapper = GWT.create(UIPlaceHistoryMapper.class);
						PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
						historyHandler.register(PLACE_CONTROLLER, EVENT_BUS, new OpenStackPlace("compute","1",null));
						
						historyHandler.handleCurrentHistory();
					}
				});
			}
		});
		
		
	}
	
	@Override
	public void onChangeTenant(String tenantId) {
		KeystoneAuthentication authentication = new KeystoneAuthentication();
		authentication.setToken(OpenStackClient.access.getToken());
		authentication.setTenantId(tenantId);
		OpenStackClient.IDENTITY.authenticate(authentication, new DefaultAsyncCallback<KeystoneAccess>() {

			@Override
			public void onSuccess(KeystoneAccess access) {
				GWT.log(access.toString());
				OpenStackClient.access = access;
				GWT.log(OpenStackClient.getTenant());
				UI.PLACE_CONTROLLER.goTo(new OpenStackPlace("compute",OpenStackClient.getTenant(), "servers"));
			}

		});
	}

	@Override
	public void onChangeService(String service) {
		UI.PLACE_CONTROLLER.goTo(new OpenStackPlace(service, OpenStackClient.getTenant(), null));

	}

}
