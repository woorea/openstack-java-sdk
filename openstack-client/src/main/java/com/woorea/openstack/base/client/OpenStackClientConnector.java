package com.woorea.openstack.base.client;


public interface OpenStackClientConnector {

	public <T> OpenStackResponse request(OpenStackRequest<T> request);

}
