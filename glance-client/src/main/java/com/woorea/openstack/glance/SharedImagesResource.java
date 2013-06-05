package com.woorea.openstack.glance;


import com.woorea.openstack.base.client.HttpMethod;
import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;
import com.woorea.openstack.glance.model.Images;
import com.woorea.openstack.glance.model.SharedImages;

public class SharedImagesResource {

	private final OpenStackClient CLIENT;
	
	public SharedImagesResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list(String tenantId, boolean detail) {
		return new List(tenantId, detail);
	}

	public class List extends OpenStackRequest<SharedImages> {
		
		public List(String tenantId, boolean detail) {
			super(CLIENT, HttpMethod.GET, new StringBuffer(detail ? "/shared-images/detail" : "/shared-images/").append(tenantId).toString(), null, SharedImages.class);
		}

	}
	
}
