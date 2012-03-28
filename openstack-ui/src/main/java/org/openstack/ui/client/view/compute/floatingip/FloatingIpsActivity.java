package org.openstack.ui.client.view.compute.floatingip;

import org.openstack.model.compute.FloatingIp;
import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.User;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;
import org.openstack.ui.client.view.identity.tenant.CreateRoleActivity;
import org.openstack.ui.client.view.identity.tenant.RolesView;
import org.openstack.ui.client.view.identity.tenant.RolesView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
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
//				OpenStackClient.IDENTITY.listRoles(new DefaultAsyncCallback<FloatingIp>() {
//
//					@Override
//					public void onSuccess(FloatingIp result) {
//						updateRowCount(result.getList().size(), true);
//						updateRowData(0, result.getList());
//
//					}
//				});
			}

		};
	}

	@Override
	public void refresh() {
		dataProvider.refresh();
		
	}

	@Override
	public void onCreateFloatingIp() {
		CreateRoleActivity activity = new CreateRoleActivity();
		activity.start(UI.MODAL, null);
		UI.MODAL.center();
		
	}

	@Override
	public void onDeleteFloatingIp() {
		for(FloatingIp fip : selectionModel.getSelectedSet()) {
			OpenStackClient.IDENTITY.deleteRole(fip.getId(), new DefaultAsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		}
		
	}

}
