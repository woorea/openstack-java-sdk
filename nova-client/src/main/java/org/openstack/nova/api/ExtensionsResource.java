package org.openstack.nova.api;

import org.openstack.base.client.HttpMethod;
import org.openstack.base.client.OpenStackClient;
import org.openstack.base.client.OpenStackRequest;
import org.openstack.nova.model.Extensions;

public class ExtensionsResource {
	
	private final OpenStackClient CLIENT;
	
	public ExtensionsResource(OpenStackClient client) {
		CLIENT = client;
	}
	
	public List list(boolean detail) {
		return new List(detail);
	}
	
	public class List extends OpenStackRequest<Extensions> {

	    public List(boolean detail) {
	    	super(CLIENT, HttpMethod.GET, detail ? "extensions/detail" : "extensions", null, Extensions.class);
	    }
	    
	 }
	
}

