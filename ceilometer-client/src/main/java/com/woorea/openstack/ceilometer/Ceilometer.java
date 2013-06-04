package com.woorea.openstack.ceilometer;


import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackClientConnector;
import com.woorea.openstack.ceilometer.v2.api.MetersResource;
import com.woorea.openstack.ceilometer.v2.api.ResourcesResource;

public class Ceilometer extends OpenStackClient {
	
	private final MetersResource METERS;
	
	private final ResourcesResource RESOURCES;
	
	public Ceilometer(String endpoint, OpenStackClientConnector connector) {
		super(endpoint, connector);
		METERS = new MetersResource(this);
		RESOURCES = new ResourcesResource(this);
	}
	
	public Ceilometer(String endpoint) {
		this(endpoint, null);
		
	}
	
	public ResourcesResource resources() {
		return RESOURCES;
	}
	
	public MetersResource meters() {
		return METERS;
	}
	
}
