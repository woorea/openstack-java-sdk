package org.openstack.ui.client.view.compute.snapshot;

import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotList;
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
	
	private RefreshableDataProvider<Snapshot> dataProvider;

	private MultiSelectionModel<Snapshot> selectionModel = new MultiSelectionModel<Snapshot>();

	private DefaultSelectionEventManager<Snapshot> selectionManager = DefaultSelectionEventManager
			.<Snapshot> createCheckboxManager(0);

	public SnapshotsActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<Snapshot>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<Snapshot> display) {
				OpenStackClient.COMPUTE.listSnapshots(new DefaultAsyncCallback<SnapshotList>() {

					@Override
					public void onSuccess(SnapshotList result) {
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
