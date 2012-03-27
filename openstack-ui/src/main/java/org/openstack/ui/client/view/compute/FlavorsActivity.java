package org.openstack.ui.client.view.compute;

import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;
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

public class FlavorsActivity extends AbstractActivity implements FlavorsView.Presenter {
	
	private static final FlavorsView VIEW = new FlavorsView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<Flavor> dataProvider;

	private MultiSelectionModel<Flavor> selectionModel = new MultiSelectionModel<Flavor>();

	private DefaultSelectionEventManager<Flavor> selectionManager = DefaultSelectionEventManager
			.<Flavor> createCheckboxManager(0);

	public FlavorsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<Flavor>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<Flavor> display) {
				OpenStackClient.COMPUTE.listFlavors(new DefaultAsyncCallback<FlavorList>() {

					@Override
					public void onSuccess(FlavorList result) {
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
