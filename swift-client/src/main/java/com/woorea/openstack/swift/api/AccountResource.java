package com.woorea.openstack.swift.api;

import com.woorea.openstack.base.client.OpenStackClient;
import com.woorea.openstack.base.client.OpenStackRequest;

public class AccountResource {
	
	private final OpenStackClient CLIENT;
	
	public AccountResource(OpenStackClient client) {
		CLIENT = client;
	}

	public class ShowAccount extends OpenStackRequest<Void> {

		public ShowAccount() {
//			return target.request(MediaType.APPLICATION_JSON).head();
		}

	}

}
