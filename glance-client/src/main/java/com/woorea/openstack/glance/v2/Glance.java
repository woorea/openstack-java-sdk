package com.woorea.openstack.glance.v2;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

public class Glance extends OpenStackClient {
	
	private final ImagesResource IMAGES;
	
	public Glance(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		IMAGES = new ImagesResource(this);
	}
	
	public Glance(String endpoint) {
		this(endpoint, null);
	}
	
	public final ImagesResource images() {
		return IMAGES;
	}
}
