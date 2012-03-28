package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.compute.Server;
import org.openstack.model.identity.User;
import org.openstack.model.identity.UserList;
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

public class UsersActivity extends AbstractActivity implements UsersView.Presenter {
	
	private static final UsersView VIEW = new UsersView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<User> dataProvider;

	private MultiSelectionModel<User> selectionModel = new MultiSelectionModel<User>();

	private DefaultSelectionEventManager<User> selectionManager = DefaultSelectionEventManager
			.<User> createCheckboxManager(0);

	public UsersActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<User>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<User> display) {
				OpenStackClient.IDENTITY.listUsers(new DefaultAsyncCallback<UserList>() {

					@Override
					public void onSuccess(UserList result) {
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
	public void onCreateUser() {
		CreateUserActivity activity = new CreateUserActivity();
		activity.start(UI.MODAL, null);
		UI.MODAL.center();
		
	}

	@Override
	public void onDeleteUser() {
		for(User u : selectionModel.getSelectedSet()) {
			OpenStackClient.IDENTITY.deleteUser(u.getId(), new DefaultAsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		}
	}

}
