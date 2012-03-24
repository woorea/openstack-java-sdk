package org.openstack.ui.client;

import org.openstack.ui.client.view.compute.ComputeActivity;
import org.openstack.ui.client.view.identity.IdentityActivity;
import org.openstack.ui.client.view.image.GlanceActivity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class UIActivityMapper implements ActivityMapper {

	@Override
	public Activity getActivity(Place place) {
		OpenStackPlace cPlace = (OpenStackPlace) place;
		if("compute".equals(cPlace.getService())) {
			return new ComputeActivity(cPlace);
		} else if("identity".equals(cPlace.getService())) {
			return new IdentityActivity(cPlace);
		} else if("images".equals(cPlace.getService())) {
			return new GlanceActivity(cPlace);
		} else if("storage".equals(cPlace.getService())) {
			
		}
		return null;
	}

}
