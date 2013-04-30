package org.openstack.glance.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.glance.model.Images;

public class SharedImagesResource {

	private final OpenStackClient CLIENT;
	
	public SharedImagesResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list(String tenantId, boolean detail) {
		return new List(tenantId, detail);
	}

	public class List extends OpenStackRequest<Images> {
		
		public List(String tenantId, boolean detail) {
			super(CLIENT, HttpMethod.GET, new StringBuffer(detail ? "/shared-images/detail" : "/shared-images/").append(tenantId).toString(), null, Images.class);
		}

	}
	
}
