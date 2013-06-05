package com.woorea.openstack.glance;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;

public class Glance extends OpenStackClient {
	
	private final ImagesResource IMAGES;
	
	private final SharedImagesResource SHARED_IMAGES;

	public Glance(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		IMAGES = new ImagesResource(this);
		SHARED_IMAGES = new SharedImagesResource(this);
	}
	
	public Glance(String endpoint) {
		this(endpoint, null);
	}
	
	public final ImagesResource images() {
		return IMAGES;
	}
	
	public final SharedImagesResource sharedImages() {
		return SHARED_IMAGES;
	}

}
