package org.openstack.ui.client;

import org.openstack.model.identity.Access;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.keystone.KeystoneAuthentication;
import org.openstack.model.identity.keystone.KeystoneToken;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
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
		
		OpenStackClient.IDENTITY.getSessionData(new DefaultAsyncCallback<Access>() {

			@Override
			public void onSuccess(Access access) {
				
				OpenStackClient.access = access;
				
				OpenStackClient.IDENTITY.listTenants(new DefaultAsyncCallback<TenantList>() {

					@Override
					public void onSuccess(TenantList result) {
						OpenStackClient.tenants = result.getList();
						for(Tenant tenant : OpenStackClient.getTenants()) {
		                    ui.tenants.addItem(tenant.getName(), tenant.getId());
						}
						
						for(Service service : OpenStackClient.access.getServices()) {
		                    ui.services.addItem(service.getType());
						}

						RootLayoutPanel.get().add(ui);

						UIPlaceHistoryMapper historyMapper = GWT.create(UIPlaceHistoryMapper.class);
						PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
						historyHandler.register(PLACE_CONTROLLER, EVENT_BUS, new OpenStackPlace("identity","1",null));
						
						historyHandler.handleCurrentHistory();
					}
				});
			}

			@Override
			public void onFailure(Throwable caught) {
				Window.Location.replace("/login");
			}
		});
		
		
	}
	
	@Override
	public void onChangeTenant(String tenantId) {
		KeystoneAuthentication authentication = new KeystoneAuthentication();
		authentication.setToken((KeystoneToken) OpenStackClient.access.getToken());
		authentication.setTenantId(tenantId);
		OpenStackClient.IDENTITY.authenticate(authentication, new DefaultAsyncCallback<Access>() {

			@Override
			public void onSuccess(Access access) {
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
