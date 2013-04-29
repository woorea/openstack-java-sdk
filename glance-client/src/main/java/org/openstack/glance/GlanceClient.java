package org.openstack.glance;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.glance.api.ImagesResource;

public class GlanceClient extends OpenStackClient {
	
	private final ImagesResource IMAGES;

	public GlanceClient(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		IMAGES = new ImagesResource(this);
		
	}
	
	public GlanceClient(String endpoint) {
		this(endpoint, null);
	}
	
	public final ImagesResource images() {
		return IMAGES;
	}

}
