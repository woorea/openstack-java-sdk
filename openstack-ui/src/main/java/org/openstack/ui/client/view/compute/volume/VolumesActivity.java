package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;
import org.openstack.ui.client.api.RefreshableDataProvider;
import org.openstack.ui.client.view.identity.tenant.CreateUserActivity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.view.client.DefaultSelectionEventManager;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.MultiSelectionModel;

public class VolumesActivity extends AbstractActivity implements VolumesView.Presenter {
	
	private static final VolumesView VIEW = new VolumesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<Volume> dataProvider;

	private MultiSelectionModel<Volume> selectionModel = new MultiSelectionModel<Volume>();

	private DefaultSelectionEventManager<Volume> selectionManager = DefaultSelectionEventManager
			.<Volume> createCheckboxManager(0);

	public VolumesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<Volume>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<Volume> display) {
				OpenStackClient.COMPUTE.listVolumes(new DefaultAsyncCallback<VolumeList>() {

					@Override
					public void onSuccess(VolumeList result) {
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
	public void onCreateVolume() {
		CreateVolumeActivity activity = new CreateVolumeActivity();
		activity.start(UI.MODAL, null);
		UI.MODAL.center();
		
	}

	@Override
	public void onDeleteVolume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAttachVolume() {
		AttachVolumeActivity activity = new AttachVolumeActivity();
		activity.start(UI.MODAL, null);
		UI.MODAL.center();
		
	}

	@Override
	public void onDetachVolume() {
		// TODO Auto-generated method stub
		
	}

}
