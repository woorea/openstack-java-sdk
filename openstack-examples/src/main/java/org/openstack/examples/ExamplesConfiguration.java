package org.openstack.examples;

import org.openstack.base.client.OpenStackClientConnector;
import org.openstack.connector.JaxRs20Connector;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.api.CreateTenant;
import org.openstack.keystone.api.DeleteTenant;
import org.openstack.keystone.api.ListTenants;
import org.openstack.keystone.model.Tenant;

public class ExamplesConfiguration {

	public static final String KEYSTONE_AUTH_URL = "http://identity/v2.0";
	
	public static final String KEYSTONE_USERNAME = "admin";
	
	public static final String KEYSTONE_PASSWORD = "secret0";
	
	public static final String KEYSTONE_ENDPOINT = "http://keystone.stacksherpa.org/v2.0";
	
	public static final String NOVA_ENDPOINT = "";
	
	public static final String CEILOMETER_ENDPOINT = "";
	
	public static void main(String[] args) {
		OpenStackClientConnector connector = new JaxRs20Connector();
		KeystoneClient client = new KeystoneClient(KEYSTONE_ENDPOINT, connector);
		client.token("secret0");
		client.execute(new DeleteTenant("36c481aec1d54fc49190c92c3ef6840a"));
		Tenant tenant = client.execute(new CreateTenant(new Tenant("new_api")));
		System.out.println(tenant);
		System.out.println(client.execute(new ListTenants()));
		client.execute(new DeleteTenant(tenant.getId()));
	}
	
}
