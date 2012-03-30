package org.openstack.ui.client.view.compute.floatingip;

import org.openstack.model.compute.FloatingIp;
import org.openstack.model.compute.FloatingIpList;
import org.openstack.model.compute.ServerList;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;
import org.openstack.ui.client.view.identity.tenant.CreateRoleActivity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class FloatingIpsActivity extends AbstractActivity implements FloatingIpsView.Presenter {
	
	private static final FloatingIpsView VIEW = new FloatingIpsView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<FloatingIp> dataProvider;

	private MultiSelectionModel<FloatingIp> selectionModel = new MultiSelectionModel<FloatingIp>();

	private DefaultSelectionEventManager<FloatingIp> selectionManager = DefaultSelectionEventManager.<FloatingIp> createCheckboxManager(0);

	public FloatingIpsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<FloatingIp>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<FloatingIp> display) {
				OpenStackClient.COMPUTE.listFloatingIps(new DefaultAsyncCallback<FloatingIpList>() {

					@Override
					public void onSuccess(FloatingIpList result) {
						updateRowCount(result.getList().size(), true);
						updateRowData(0, result.getList());

					}
				});
			}

		};
	}

	@Override
	public void refresh() {
		dataProvider.refresh();
		
	}

	@Override
	public void onCreateFloatingIp() {
		OpenStackClient.COMPUTE.createFloatingIp(null, new DefaultAsyncCallback<FloatingIp>() {

			@Override
			public void onSuccess(FloatingIp result) {
				refresh();
				
			}
		});
		
	}

	@Override
	public void onDeleteFloatingIp() {
		for(FloatingIp fip : selectionModel.getSelectedSet()) {
			OpenStackClient.COMPUTE.deleteFloatingIp(fip.getId(), new DefaultAsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		}
		
	}

	@Override
	public void onDisassociateFloatingIp() {
		try {
			FloatingIp fip = selectionModel.getSelectedSet().iterator().next();
			OpenStackClient.COMPUTE.disassociateFloatingIp(fip.getInstanceId(), fip.getIp(), new DefaultAsyncCallback<Void>() {
	
				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		} catch (Exception e) {
			
		}
	}

	@Override
	public void onAssociateFloatingIp() {
		try {
			FloatingIp fip = selectionModel.getSelectedSet().iterator().next();
			AttachFloatingIpActivity activity = new AttachFloatingIpActivity(fip);
			activity.start(UI.MODAL, null);
			UI.MODAL.center();
		} catch (Exception e) {
			GWT.log(e.getMessage());
		}
		
		
		
		
	}

}
