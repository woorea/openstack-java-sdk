package org.openstack.ui.client.view.compute.snapshot;

import org.openstack.model.compute.Snapshot;
import org.openstack.model.compute.Volume;
import org.openstack.model.compute.VolumeList;
import org.openstack.model.compute.nova.snapshot.NovaSnapshotForCreate;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateSnapshotActivity extends AbstractActivity implements CreateSnapshotView.Presenter {
	
	private static final CreateSnapshotView VIEW = new CreateSnapshotView();
	
	public interface Presenter {
		
	}
	
	private Presenter presenter;
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		OpenStackClient.COMPUTE.listVolumes(new DefaultAsyncCallback<VolumeList>() {
			
			@Override
			public void onSuccess(VolumeList result) {
				for(Volume s : result.getList()) {
					VIEW.volumeId.addItem(s.getName() + " " + s.getId(), s.getId().toString());
				}
				panel.setWidget(VIEW);
				UI.MODAL.center();
			}
			
		});
	}

	@Override
	public void createSnapshot(NovaSnapshotForCreate snapshot) {
		OpenStackClient.COMPUTE.createSnapshot(snapshot, new DefaultAsyncCallback<Snapshot>() {

			@Override
			public void onSuccess(Snapshot result) {
				UI.MODAL.hide();
			}
			
		});
	}

}
