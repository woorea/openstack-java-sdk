package org.openstack.ui.client.view.compute.securitygroup;

import org.openstack.model.compute.SecurityGroup;
import org.openstack.model.compute.SecurityGroupList;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroup;
import org.openstack.model.compute.nova.securitygroup.NovaSecurityGroupRule;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class SecurityGroupsActivity extends AbstractActivity implements SecurityGroupsView.Presenter {
	
	interface SecurityGroupDriver extends SimpleBeanEditorDriver<SecurityGroup, SecurityGroupEditor> {

	}
	
	private static final CreateSecurityGroupView CREATE_VIEW = new CreateSecurityGroupView();
	
	private static final SecurityGroupDriver driver = GWT.create(SecurityGroupDriver.class);
	
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
		dataProvider.refresh();
		
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

	@Override
	public void createSecurityGroup() {
		CREATE_VIEW.securityGroup.setPresenter(this);
		driver.initialize(CREATE_VIEW.securityGroup);
		SecurityGroup securityGroup = new NovaSecurityGroup();
		securityGroup.getRules().add(new NovaSecurityGroupRule());
		driver.edit(securityGroup);
		CREATE_VIEW.setPresenter(this);
		UI.MODAL.setWidget(CREATE_VIEW);
		UI.MODAL.center();
		
	}

	@Override
	public void deleteSecurityGroup() {
		try {
			SecurityGroup sg = selectionModel.getSelectedSet().iterator().next();
			//vol.getAttachments()
			OpenStackClient.COMPUTE.deleteSecurityGroup(sg.getId(), new DefaultAsyncCallback<Void>() {
	
				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
				
			});
		} catch (Exception e) {
			
		}
		
	}
	
	@Override
	public void createSecurityGroup(SecurityGroup securityGroup) {
		Window.alert("createSecurityGroup!!!");
	}

	@Override
	public void onSaveSecurityGroup() {
		OpenStackClient.COMPUTE.createSecurityGroup(driver.flush(), new DefaultAsyncCallback<SecurityGroup>() {

			@Override
			public void onSuccess(SecurityGroup result) {
				UI.MODAL.hide();
				
			}
		});
		
		
	}

}
