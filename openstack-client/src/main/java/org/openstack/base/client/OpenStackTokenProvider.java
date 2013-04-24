package org.openstack.base.client;

public interface OpenStackTokenProvider {

	String getToken();

	void expireToken();

}
