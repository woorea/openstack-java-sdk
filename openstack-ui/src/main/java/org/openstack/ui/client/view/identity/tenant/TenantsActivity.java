package org.openstack.ui.client.view.identity.tenant;

import java.util.List;

import org.openstack.model.identity.Tenant;
import org.openstack.model.identity.TenantList;
import org.openstack.model.identity.keystone.KeystoneTenant;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class TenantsActivity extends AbstractActivity implements TenantsView.Presenter {
	
	private static final TenantsView VIEW = new TenantsView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<? extends Tenant> dataProvider;

	private MultiSelectionModel<Tenant> selectionModel = new MultiSelectionModel<Tenant>();

	private DefaultSelectionEventManager<Tenant> selectionManager = DefaultSelectionEventManager.<Tenant> createCheckboxManager(0);

	public TenantsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<Tenant>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<Tenant> display) {
				OpenStackClient.IDENTITY.listTenants(new DefaultAsyncCallback<TenantList>() {

					@Override
					public void onSuccess(TenantList result) {
						updateRowCount(result.getList().size(), true);
						updateRowData(0, (List<Tenant>) result.getList());
					}
				});
			}

		};
	}

	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateTenant() {
		CreateTenantActivity activity = new CreateTenantActivity();
		activity.start(UI.MODAL, null);
		UI.MODAL.center();
	}

	@Override
	public void onDeleteTenant() {
		// TODO Auto-generated method stub
		
	}

}
