package com.woorea.openstack.base.client;

public interface OpenStackTokenProvider {

	String getToken();

	void expireToken();

}
