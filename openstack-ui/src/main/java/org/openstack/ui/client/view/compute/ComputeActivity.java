package org.openstack.ui.client.view.compute;

import org.openstack.ui.client.OpenStackPlace;
import org.openstack.ui.client.view.compute.keypair.KeyPairsActivity;
import org.openstack.ui.client.view.compute.securitygroup.SecurityGroupsActivity;
import org.openstack.ui.client.view.compute.snapshot.SnapshotsActivity;
import org.openstack.ui.client.view.compute.volume.VolumesActivity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Label;

public class ComputeActivity extends AbstractActivity {

	private static final ComputeView VIEW = new ComputeView();

	private OpenStackPlace place;

	public ComputeActivity(OpenStackPlace place) {
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		if (place.getPlace() == null || place.getPlace().length() == 0 || "servers".equals(place.getPlace())) {
			ServersActivity activity = new ServersActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("images".equals(place.getPlace())) {
			ImagesActivity activity = new ImagesActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("flavors".equals(place.getPlace())) {
			FlavorsActivity activity = new FlavorsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("volumes".equals(place.getPlace())) {
			VolumesActivity activity = new VolumesActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("snapshots".equals(place.getPlace())) {
			SnapshotsActivity activity = new SnapshotsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("keypairs".equals(place.getPlace())) {
			KeyPairsActivity activity = new KeyPairsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else if ("firewall".equals(place.getPlace())) {
			SecurityGroupsActivity activity = new SecurityGroupsActivity(place);
			activity.start(VIEW.content, eventBus);
		} else {
			VIEW.content.setWidget(new Label(place.getPlace()));
		}
		panel.setWidget(VIEW);
	}

}
