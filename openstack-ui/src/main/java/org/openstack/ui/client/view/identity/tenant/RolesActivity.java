package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeystoneRole;
import org.openstack.model.identity.KeystoneRoleList;
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

public class RolesActivity extends AbstractActivity implements RolesView.Presenter {
	
	private static final RolesView VIEW = new RolesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<KeystoneRole> dataProvider;

	private MultiSelectionModel<KeystoneRole> selectionModel = new MultiSelectionModel<KeystoneRole>();

	private DefaultSelectionEventManager<KeystoneRole> selectionManager = DefaultSelectionEventManager
			.<KeystoneRole> createCheckboxManager(0);

	public RolesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<KeystoneRole>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<KeystoneRole> display) {
				OpenStackClient.IDENTITY.listRoles(new DefaultAsyncCallback<KeystoneRoleList>() {

					@Override
					public void onSuccess(KeystoneRoleList result) {
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
	public void onCreateRole() {
		CreateRoleActivity activity = new CreateRoleActivity();
		activity.start(UI.MODAL, null);
		UI.MODAL.center();
		
	}

	@Override
	public void onDeleteRole() {
		// TODO Auto-generated method stub
		
	}

}
