package com.woorea.openstack.base.client;

public class OpenStackSimpleTokenProvider implements OpenStackTokenProvider {

	String token;

	public OpenStackSimpleTokenProvider(String token) {
		this.token = token;
	}

	@Override
	public String getToken() {
		return this.token;
	}

	@Override
	public void expireToken() {
	}

}
