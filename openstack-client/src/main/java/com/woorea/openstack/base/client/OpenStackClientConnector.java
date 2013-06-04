package com.woorea.openstack.base.client;


public interface OpenStackClientConnector {

	public <T> T execute(OpenStackRequest<T> request);

}
