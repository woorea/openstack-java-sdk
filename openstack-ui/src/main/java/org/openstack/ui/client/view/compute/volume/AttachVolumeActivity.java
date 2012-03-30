package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.Volume;
import org.openstack.model.compute.nova.volume.NovaVolumeAttachment;
import org.openstack.ui.client.UI;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class AttachVolumeActivity extends AbstractActivity implements AttachVolumeView.Presenter {
	
	private static final AttachVolumeView VIEW = new AttachVolumeView();
	
	private Volume volume;
	
	public AttachVolumeActivity(Volume volume) {
		this.volume = volume;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}

	@Override
	public void attachVolume(String serverId, NovaVolumeAttachment attachment) {
		attachment.setVolumeId(volume.getId());
		OpenStackClient.COMPUTE.attachVolume(serverId, attachment, new DefaultAsyncCallback<Void>() {
			@Override
			public void onSuccess(Void result) {
				//refresh
				UI.MODAL.hide(true);
				
			}
		});
		
	}

}
