package org.openstack.ui.client.view.compute.securitygroup;

import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class SecurityGroupsActivity extends AbstractActivity implements SecurityGroupsView.Presenter {
	
	private static final SecurityGroupsView VIEW = new SecurityGroupsView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<SecurityGroup> dataProvider;

	private MultiSelectionModel<SecurityGroup> selectionModel = new MultiSelectionModel<SecurityGroup>();

	private DefaultSelectionEventManager<SecurityGroup> selectionManager = DefaultSelectionEventManager
			.<SecurityGroup> createCheckboxManager(0);

	public SecurityGroupsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<SecurityGroup>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<SecurityGroup> display) {
				OpenStackClient.COMPUTE.listSecurityGroups(new DefaultAsyncCallback<SecurityGroupList>() {

					@Override
					public void onSuccess(SecurityGroupList result) {
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
	public void onShowSecurityGroup(Integer id) {
		OpenStackClient.COMPUTE.showSecurityGroup(id, new DefaultAsyncCallback<SecurityGroup>() {

			@Override
			public void onSuccess(SecurityGroup result) {
				VIEW.detail.setWidget(new Label(result.toString()));
				
			}
		});
		
	}

}
