package org.openstack.ui.client.view.compute.snapshot;

import org.openstack.model.compute.NovaSnapshot;
import org.openstack.model.compute.NovaSnapshotList;
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

public class SnapshotsActivity extends AbstractActivity implements SnapshotsView.Presenter {
	
	private static final SnapshotsView VIEW = new SnapshotsView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<NovaSnapshot> dataProvider;

	private MultiSelectionModel<NovaSnapshot> selectionModel = new MultiSelectionModel<NovaSnapshot>();

	private DefaultSelectionEventManager<NovaSnapshot> selectionManager = DefaultSelectionEventManager
			.<NovaSnapshot> createCheckboxManager(0);

	public SnapshotsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<NovaSnapshot>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<NovaSnapshot> display) {
				OpenStackClient.COMPUTE.listSnapshots(new DefaultAsyncCallback<NovaSnapshotList>() {

					@Override
					public void onSuccess(NovaSnapshotList result) {
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
