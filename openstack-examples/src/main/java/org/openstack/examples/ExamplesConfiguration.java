package org.openstack.examples;

import org.openstack.base.client.OpenStackSimpleTokenProvider;
import org.openstack.keystone.KeystoneClient;
import org.openstack.keystone.model.Tenant;

public class ExamplesConfiguration {

	public static final String KEYSTONE_AUTH_URL = "http://identity/v2.0";
	
	public static final String KEYSTONE_USERNAME = "admin";
	
	public static final String KEYSTONE_PASSWORD = "secret0";
	
	public static final String KEYSTONE_ENDPOINT = "http://keystone.stacksherpa.org/v2.0";
	
	public static final String TENANT_NAME = "admin";

	public static final String NOVA_ENDPOINT = "";
	
	public static final String CEILOMETER_ENDPOINT = "";
	
	public static void main(String[] args) {
		KeystoneClient client = new KeystoneClient(KEYSTONE_ENDPOINT);
		client.setTokenProvider(new OpenStackSimpleTokenProvider("secret0"));
		client.tenants().delete("36c481aec1d54fc49190c92c3ef6840a").execute();
		Tenant tenant = client.tenants().create(new Tenant("new_api")).execute();
		System.out.println(tenant);
		System.out.println(client.tenants().list().execute());
		client.tenants().delete(tenant.getId()).execute();
	}
	
}
