package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.ui.client.OpenStackPlace;
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
	
	private RefreshableDataProvider<KeyStoneTenant> dataProvider;

	private MultiSelectionModel<KeyStoneTenant> selectionModel = new MultiSelectionModel<KeyStoneTenant>();

	private DefaultSelectionEventManager<KeyStoneTenant> selectionManager = DefaultSelectionEventManager
			.<KeyStoneTenant> createCheckboxManager(0);

	public TenantsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<KeyStoneTenant>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<KeyStoneTenant> display) {
				OpenStackClient.IDENTITY.listTenants(new DefaultAsyncCallback<KeyStoneTenantList>() {

					@Override
					public void onSuccess(KeyStoneTenantList result) {
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

}
