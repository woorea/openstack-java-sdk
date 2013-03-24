package org.openstack.examples;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.connector.JaxRs20Connector;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.ListTenants;

public class ExamplesConfiguration {

	public static final String KEYSTONE_AUTH_URL = "http://identity/v2.0";
	
	public static final String KEYSTONE_USERNAME = "admin";
	
	public static final String KEYSTONE_PASSWORD = "secret0";
	
	public static final String KEYSTONE_ENDPOINT = "";
	
	public static final String NOVA_ENDPOINT = "";
	
	public static final String CEILOMETER_ENDPOINT = "";
	
	public static void main(String[] args) {
		OpenStackClientConnector connector = new JaxRs20Connector();
		KeystoneClient client = new KeystoneClient(KEYSTONE_ENDPOINT, connector);
		client.token("secret0");
		System.out.println(client.execute(new ListTenants()));
	}
	
}
