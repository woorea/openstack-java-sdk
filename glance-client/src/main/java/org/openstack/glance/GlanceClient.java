package org.openstack.glance;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.glance.api.ImagesResource;
import org.openstack.glance.api.SharedImagesResource;

public class GlanceClient extends OpenStackClient {
	
	private final ImagesResource IMAGES;
	
	private final SharedImagesResource SHARED_IMAGES;

	public GlanceClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		IMAGES = new ImagesResource(this);
		SHARED_IMAGES = new SharedImagesResource(this);
	}
	
	public GlanceClient(String endpoint) {
		this(endpoint, null);
	}
	
	public final ImagesResource images() {
		return IMAGES;
	}
	
	public final SharedImagesResource sharedImages() {
		return SHARED_IMAGES;
	}

}
