package org.openstack.ui.client;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.web.bindery.event.shared.EventBus;

public class UI implements EntryPoint, UIView.Presenter {
	
	public static final EventBus EVENT_BUS = new SimpleEventBus();
	
	public static final PlaceController PLACE_CONTROLLER = new PlaceController(EVENT_BUS);

	@Override
	public void onModuleLoad() {
		
		final UIView ui = new UIView();
		ui.setPresenter(UI.this);
		
		OpenStackClient.IDENTITY.getSessionData(new DefaultAsyncCallback<OpenStackSessionData>() {

			@Override
			public void onSuccess(OpenStackSessionData session) {
				
				GWT.log("SESSION :" + session.getAccess());
				
				OpenStackClient.session = session;
				
				OpenStackClient.IDENTITY.listTenants(new DefaultAsyncCallback<KeyStoneTenantList>() {

					@Override
					public void onSuccess(KeyStoneTenantList result) {
						OpenStackClient.tenants = result.getList();
						for(KeyStoneTenant tenant : OpenStackClient.getTenants()) {
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
		KeyStoneAuthentication authentication = new KeyStoneAuthentication();
		authentication.setToken(OpenStackClient.session.getAccess().getToken());
		authentication.setTenantId(tenantId);
		OpenStackClient.IDENTITY.authenticate(authentication, new DefaultAsyncCallback<KeyStoneAccess>() {

			@Override
			public void onSuccess(KeyStoneAccess access) {
				GWT.log(access.toString());
				OpenStackClient.session.setAccess(access);
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
