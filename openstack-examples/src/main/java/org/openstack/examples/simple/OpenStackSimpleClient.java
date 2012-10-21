package org.openstack.examples.simple;

import javax.ws.rs.client.Entity;

import org.openstack.common.client.AbstractOpenStackClient;
import org.openstack.keystone.model.Access;

public class OpenStackSimpleClient {
	
	private static final String KEYSTONE_AUTH_URL = "";
	
	private static final String KEYSTONE_USERNAME = "";
	
	private static final String KEYSTONE_PASSWORD = "";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractOpenStackClient client = new AbstractOpenStackClient(KEYSTONE_AUTH_URL);
		Access access = client.request("/tokens").execute("POST", Entity.json("{\"auth\":{\"passwordCredentials\":{\"username\":\"admin\",\"password\":\"1n1est4\"}}}"), Access.class);
		System.out.println(access);
	}

}
