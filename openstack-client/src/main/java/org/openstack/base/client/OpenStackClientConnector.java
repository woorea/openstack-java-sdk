package org.openstack.base.client;

public interface OpenStackClientConnector {

	public <T> T execute(OpenStackRequest request, Class<T> responseType);

	public void execute(OpenStackRequest request);

}
