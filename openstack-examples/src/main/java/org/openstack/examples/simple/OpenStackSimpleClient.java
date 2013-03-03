package org.openstack.examples.simple;

import javax.ws.rs.client.Entity;

import org.openstack.common.client.AbstractOpenStackClient;
import org.openstack.examples.ExamplesConfiguration;
import org.openstack.keystone.model.Access;

public class OpenStackSimpleClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AbstractOpenStackClient client = new AbstractOpenStackClient(ExamplesConfiguration.KEYSTONE_AUTH_URL);
		Access access = client.request("/tokens").execute("POST", Entity.json("{\"auth\":{\"passwordCredentials\":{\"username\":\"\",\"password\":\"\"}}}"), Access.class);
		System.out.println(access);
	}

}
