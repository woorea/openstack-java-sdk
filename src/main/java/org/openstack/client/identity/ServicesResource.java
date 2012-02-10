package org.openstack.client.identity;
import org.openstack.client.common.Resource;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceList;

import com.sun.jersey.api.client.Client;

public class ServicesResource extends Resource {
	
	public ServicesResource(Client client, String resource) {
		super(client, resource);
	}

	public ServicesRepresentation list() {
		ServiceList tenantList = client.resource(resource).get(ServiceList.class);
		return new ServicesRepresentation(client, tenantList);
	}
	
	public ServiceResource create(Service tenant) {
		return null;
	}
	
	public ServiceResource service(String id) {
		return new ServiceResource(client, new StringBuilder(resource).append("/").append(id).toString());
	}
	
}
