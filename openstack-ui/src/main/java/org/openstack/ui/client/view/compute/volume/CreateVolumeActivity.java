package org.openstack.ui.client.view.compute.volume;

import org.openstack.model.compute.Volume;
import org.openstack.model.compute.nova.volume.NovaVolumeForCreate;
import org.openstack.ui.client.api.DefaultAsyncCallback;
import org.openstack.ui.client.api.OpenStackClient;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class CreateVolumeActivity extends AbstractActivity implements CreateVolumeView.Presenter {
	
	private static final CreateVolumeView VIEW = new CreateVolumeView();
	
	public interface Presenter {
		
	}
	
	private Presenter presenter;
	
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		VIEW.setPresenter(this);
		panel.setWidget(VIEW);
	}

	@Override
	public void createVolume(NovaVolumeForCreate volume) {
		OpenStackClient.COMPUTE.createVolume(volume, new DefaultAsyncCallback<Volume>() {

			@Override
			public void onSuccess(Volume result) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

}
