package org.openstack.swift.api;

import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;

public class AccountResource {
	
	private final OpenStackClient CLIENT;
	
	public AccountResource(OpenStackClient client) {
		CLIENT = client;
	}

	public class ShowAccount extends OpenStackRequest {

		public ShowAccount() {
//			return target.request(MediaType.APPLICATION_JSON).head();
		}

	}

}
