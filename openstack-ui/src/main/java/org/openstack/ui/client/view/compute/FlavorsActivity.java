package org.openstack.ui.client.view.compute;

import org.openstack.model.compute.NovaFlavor;
import org.openstack.model.compute.NovaFlavorList;
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
	
	private RefreshableDataProvider<NovaFlavor> dataProvider;

	private MultiSelectionModel<NovaFlavor> selectionModel = new MultiSelectionModel<NovaFlavor>();

	private DefaultSelectionEventManager<NovaFlavor> selectionManager = DefaultSelectionEventManager
			.<NovaFlavor> createCheckboxManager(0);

	public FlavorsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<NovaFlavor>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<NovaFlavor> display) {
				OpenStackClient.COMPUTE.listFlavors(new DefaultAsyncCallback<NovaFlavorList>() {

					@Override
					public void onSuccess(NovaFlavorList result) {
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
