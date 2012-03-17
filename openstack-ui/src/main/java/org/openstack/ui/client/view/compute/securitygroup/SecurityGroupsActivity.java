package org.openstack.ui.client.view.compute.securitygroup;

import java.util.List;

import org.openstack.model.compute.NovaSecurityGroup;
import org.openstack.model.compute.NovaSecurityGroupList;
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
	
	private RefreshableDataProvider<NovaSecurityGroup> dataProvider;

	private MultiSelectionModel<NovaSecurityGroup> selectionModel = new MultiSelectionModel<NovaSecurityGroup>();

	private DefaultSelectionEventManager<NovaSecurityGroup> selectionManager = DefaultSelectionEventManager
			.<NovaSecurityGroup> createCheckboxManager(0);

	public SecurityGroupsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<NovaSecurityGroup>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<NovaSecurityGroup> display) {
				OpenStackClient.COMPUTE.listSecurityGroups(new DefaultAsyncCallback<NovaSecurityGroupList>() {

					@Override
					public void onSuccess(NovaSecurityGroupList result) {
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
		OpenStackClient.COMPUTE.showSecurityGroup(id, new DefaultAsyncCallback<NovaSecurityGroup>() {

			@Override
			public void onSuccess(NovaSecurityGroup result) {
				VIEW.detail.setWidget(new Label(result.toString()));
				
			}
		});
		
	}

}
