package org.openstack.ui.client.view.compute.snapshot;

import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.SnapshotList;
import org.openstack.model.compute.Volume;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;
import org.openstack.ui.client.view.compute.volume.CreateVolumeActivity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;

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
		ui();
		panel.setWidget(VIEW);
	}
	
	private void ui() {
		VIEW.delete.setEnabled(false);
		VIEW.createVolume.setEnabled(false);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				switch(selectionModel.getSelectedSet().size()) {
					case 1:
						VIEW.delete.setEnabled(true);
						VIEW.createVolume.setEnabled(true);
						break;
					default:
						VIEW.delete.setEnabled(false);
						VIEW.createVolume.setEnabled(false);
				}
				
			}
		});
	}

	public void refresh() {
		dataProvider.refresh();
		
	}

	@Override
	public void onCreateSnapshot() {
		CreateSnapshotActivity activity = new CreateSnapshotActivity();
		activity.start(UI.MODAL, null);
	}

	@Override
	public void onDeleteSnapshot() {
		try {
			Snapshot snapshot = selectionModel.getSelectedSet().iterator().next();
			//vol.getAttachments()
			OpenStackClient.COMPUTE.deleteSnapshot(snapshot.getId(), new DefaultAsyncCallback<Void>() {
	
				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		} catch (Exception e) {
			
		}
	}
	
	@Override
	public void onCreateVolume() {
		try {
			Snapshot snapshot = selectionModel.getSelectedSet().iterator().next();
			CreateVolumeActivity activity = new CreateVolumeActivity(snapshot);
			activity.start(UI.MODAL, null);
			
		} catch (Exception e) {
			
		}
		
		
	}

}
