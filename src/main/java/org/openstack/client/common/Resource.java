package org.openstack.client.common;
import com.sun.jersey.api.client.Client;


public class Resource {

	protected Client client;
	
	protected String resource;
	
	public Resource(Client client, String resource) {
		this.client = client;
		this.resource = resource;
	}
	
}
