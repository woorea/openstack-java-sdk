package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeyStoneRole;
import org.openstack.model.identity.KeyStoneRoleList;
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

public class RolesActivity extends AbstractActivity implements RolesView.Presenter {
	
	private static final RolesView VIEW = new RolesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<KeyStoneRole> dataProvider;

	private MultiSelectionModel<KeyStoneRole> selectionModel = new MultiSelectionModel<KeyStoneRole>();

	private DefaultSelectionEventManager<KeyStoneRole> selectionManager = DefaultSelectionEventManager
			.<KeyStoneRole> createCheckboxManager(0);

	public RolesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<KeyStoneRole>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<KeyStoneRole> display) {
				OpenStackClient.IDENTITY.listRoles(new DefaultAsyncCallback<KeyStoneRoleList>() {

					@Override
					public void onSuccess(KeyStoneRoleList result) {
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
