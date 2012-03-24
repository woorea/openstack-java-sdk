package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeystoneTenant;
import org.openstack.model.identity.KeystoneTenantList;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class TenantsActivity extends AbstractActivity implements TenantsView.Presenter {
	
	private static final TenantsView VIEW = new TenantsView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<KeystoneTenant> dataProvider;

	private MultiSelectionModel<KeystoneTenant> selectionModel = new MultiSelectionModel<KeystoneTenant>();

	private DefaultSelectionEventManager<KeystoneTenant> selectionManager = DefaultSelectionEventManager
			.<KeystoneTenant> createCheckboxManager(0);

	public TenantsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<KeystoneTenant>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<KeystoneTenant> display) {
				OpenStackClient.IDENTITY.listTenants(new DefaultAsyncCallback<KeystoneTenantList>() {

					@Override
					public void onSuccess(KeystoneTenantList result) {
						updateRowCount(result.getList().size(), true);
						updateRowData(0, result.getList());

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
