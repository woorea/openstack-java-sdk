package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.Role;
import org.openstack.model.identity.RoleList;
import org.openstack.model.identity.User;
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
	
	private RefreshableDataProvider<Role> dataProvider;

	private MultiSelectionModel<Role> selectionModel = new MultiSelectionModel<Role>();

	private DefaultSelectionEventManager<Role> selectionManager = DefaultSelectionEventManager.<Role> createCheckboxManager(0);

	public RolesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<Role>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<Role> display) {
				OpenStackClient.IDENTITY.listRoles(new DefaultAsyncCallback<RoleList>() {

					@Override
					public void onSuccess(RoleList result) {
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
	public void onCreateRole() {
		CreateRoleActivity activity = new CreateRoleActivity();
		activity.start(UI.MODAL, null);
		UI.MODAL.center();
		
	}

	@Override
	public void onDeleteRole() {
		for(Role u : selectionModel.getSelectedSet()) {
			OpenStackClient.IDENTITY.deleteRole(u.getId(), new DefaultAsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		}
		
	}

}
