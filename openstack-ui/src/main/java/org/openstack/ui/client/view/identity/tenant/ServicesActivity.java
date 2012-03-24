package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceList;
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

public class ServicesActivity extends AbstractActivity implements ServicesView.Presenter {
	
	private static final ServicesView VIEW = new ServicesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<KeystoneService> dataProvider;

	private MultiSelectionModel<KeystoneService> selectionModel = new MultiSelectionModel<KeystoneService>();

	private DefaultSelectionEventManager<KeystoneService> selectionManager = DefaultSelectionEventManager
			.<KeystoneService> createCheckboxManager(0);

	public ServicesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<KeystoneService>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<KeystoneService> display) {
				OpenStackClient.IDENTITY.listServices(new DefaultAsyncCallback<KeystoneServiceList>() {

					@Override
					public void onSuccess(KeystoneServiceList result) {
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
	public void onCreateService() {
		CreateServiceActivity activity = new CreateServiceActivity();
		activity.start(UI.MODAL, null);
		UI.MODAL.center();
		
	}

	@Override
	public void onDeleteService() {
		// TODO Auto-generated method stub
		
	}

}
