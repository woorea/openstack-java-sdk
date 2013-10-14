package com.woorea.openstack.nova.api.extensions;
import com.woorea.openstack.base.client.Entity;
import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.nova.model.AvailabilityZoneInfo;

public class AvailabilityZoneInfoExtension {

	private final OpenStackClient CLIENT;
	
	public AvailabilityZoneInfoExtension(OpenStackClient client) {
		CLIENT = client;
	}

	public Show show(boolean isDetail) {
		return new Show(isDetail);
	}

	public class Show extends OpenStackRequest<AvailabilityZoneInfo> {

		public Show(boolean isDetail) {
			super(CLIENT, HttpMethod.GET,
				  new StringBuffer(isDetail ? "/os-availability-zone/detail" : "os-availability-zone"), null, AvailabilityZoneInfo.class);
		}
	}
}
