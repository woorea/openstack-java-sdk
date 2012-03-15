package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.NovaVolume;
import org.openstack.model.compute.NovaVolumeList;
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

public class VolumesActivity extends AbstractActivity implements VolumesView.Presenter {
	
	private static final VolumesView VIEW = new VolumesView();
	
	private OpenStackPlace place;
	
	private RefreshableDataProvider<NovaVolume> dataProvider;

	private MultiSelectionModel<NovaVolume> selectionModel = new MultiSelectionModel<NovaVolume>();

	private DefaultSelectionEventManager<NovaVolume> selectionManager = DefaultSelectionEventManager
			.<NovaVolume> createCheckboxManager(0);

	public VolumesActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
		VIEW.grid.setSelectionModel(selectionModel, selectionManager);
		dataProvider = new RefreshableDataProvider<NovaVolume>(VIEW.grid) {

			@Override
			protected void onRangeChanged(HasData<NovaVolume> display) {
				OpenStackClient.COMPUTE.listVolumes(OpenStackClient.getComputeURL(), OpenStackClient.getToken(), new DefaultAsyncCallback<NovaVolumeList>() {

					@Override
					public void onSuccess(NovaVolumeList result) {
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
