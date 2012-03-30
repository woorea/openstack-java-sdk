package org.openstack.ui.client.view.compute.floatingip;

import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AttachFloatingIpActivity extends AbstractActivity implements AttachFloatingIpView.Presenter {

	private static final AttachFloatingIpView VIEW = new AttachFloatingIpView();
	
	private FloatingIp floatingIp;
	
	public AttachFloatingIpActivity(FloatingIp floatingIp) {
		this.floatingIp = floatingIp;
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		OpenStackClient.COMPUTE.listServers(new DefaultAsyncCallback<ServerList>() {
			
			@Override
			public void onSuccess(ServerList result) {
				for(Server s : result.getList()) {
					VIEW.serverId.addItem(s.getName() + " " + s.getId(), s.getId());
				}
				panel.setWidget(VIEW);
			}
			
		});
		
	}

	@Override
	public void attachFloatingIp(String serverId) {
		OpenStackClient.COMPUTE.associateFloatingIp(serverId, floatingIp.getIp(), new DefaultAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				//refresh
				UI.MODAL.hide(true);
				
			}
		});
	}

}
