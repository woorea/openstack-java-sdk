package org.openstack.nova;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.nova.api.ExtensionsResource;
import org.openstack.nova.api.FlavorsResource;
import org.openstack.nova.api.ImagesResource;
import org.openstack.nova.api.ServersResource;

public class Nova extends OpenStackClient {
	
	private final ExtensionsResource EXTENSIONS;
	
	private final ServersResource SERVERS;
	
	private final ImagesResource IMAGES;
	
	private final FlavorsResource FLAVORS;
	
	public Nova(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		EXTENSIONS = new ExtensionsResource(this);
		SERVERS = new ServersResource(this);
		IMAGES = new ImagesResource(this);
		FLAVORS = new FlavorsResource(this);
	}
	
	public Nova(String endpoint) {
		this(endpoint, null);
	}
	
	public ExtensionsResource extensions() {
		return EXTENSIONS;
	}
	
	public ServersResource servers() {
		return SERVERS;
	}
	
	public ImagesResource images() {
		return IMAGES;
	}
	
	public FlavorsResource flavors() {
		return FLAVORS;
	}

}
