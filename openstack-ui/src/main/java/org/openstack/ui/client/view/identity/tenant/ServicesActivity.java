package org.openstack.ui.client.view.identity.tenant;

import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;
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
	
	private RefreshableDataProvider<Service> dataProvider;

	private MultiSelectionModel<Service> selectionModel = new MultiSelectionModel<Service>();

	private DefaultSelectionEventManager<Service> selectionManager = DefaultSelectionEventManager
			.<Service> createCheckboxManager(0);

	public ServicesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<Service>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<Service> display) {
				OpenStackClient.IDENTITY.listServices(new DefaultAsyncCallback<ServiceList>() {

					@Override
					public void onSuccess(ServiceList result) {
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
