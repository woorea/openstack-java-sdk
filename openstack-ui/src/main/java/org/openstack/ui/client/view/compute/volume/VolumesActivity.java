package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;

public class VolumesActivity extends AbstractActivity implements VolumesView.Presenter {
	
	private static final VolumesView VIEW = new VolumesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<Volume> dataProvider;

	private MultiSelectionModel<Volume> selectionModel = new MultiSelectionModel<Volume>();

	private DefaultSelectionEventManager<Volume> selectionManager = DefaultSelectionEventManager.<Volume> createCheckboxManager(0);

	public VolumesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<Volume>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<Volume> display) {
				OpenStackClient.COMPUTE.listVolumes(new DefaultAsyncCallback<VolumeList>() {

					@Override
					public void onSuccess(VolumeList result) {
						GWT.log(result.toString());
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
		VIEW.attach.setEnabled(false);
		VIEW.detach.setEnabled(false);
		VIEW.createSnapshot.setEnabled(false);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				switch(selectionModel.getSelectedSet().size()) {
					case 1:
						VIEW.delete.setEnabled(true);
						VIEW.attach.setEnabled(true);
						VIEW.detach.setEnabled(true);
						VIEW.createSnapshot.setEnabled(true);
						break;
					default:
						VIEW.delete.setEnabled(false);
						VIEW.attach.setEnabled(false);
						VIEW.detach.setEnabled(false);
						VIEW.createSnapshot.setEnabled(false);
				}
				
			}
		});
	}

	@Override
	public void refresh() {
		ui();
		dataProvider.refresh();
		
	}

	@Override
	public void onCreateVolume() {
		CreateVolumeActivity activity = new CreateVolumeActivity();
		activity.start(UI.MODAL, null);
	}

	@Override
	public void onDeleteVolume() {
		try {
			Volume vol = selectionModel.getSelectedSet().iterator().next();
			OpenStackClient.COMPUTE.deleteVolume(vol.getId(), new DefaultAsyncCallback<Void>() {

				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		} catch (Exception e) {
			GWT.log(e.getMessage());
		}
	}

	@Override
	public void onAttachVolume() {
		try {
			Volume vol = selectionModel.getSelectedSet().iterator().next();
			AttachVolumeActivity activity = new AttachVolumeActivity(vol);
			activity.start(UI.MODAL, null);
		} catch (Exception e) {
			GWT.log(e.getMessage());
		}		
	}

	@Override
	public void onDetachVolume() {
		try {
			Volume vol = selectionModel.getSelectedSet().iterator().next();
			//vol.getAttachments()
			OpenStackClient.COMPUTE.detachVolume("", vol.getId(), new DefaultAsyncCallback<Void>() {
	
				@Override
				public void onSuccess(Void result) {
					refresh();
					
				}
			});
		} catch (Exception e) {
			
		}
		
	}

}
