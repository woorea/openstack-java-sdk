package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.EndpointList;

public class KeystoneEndpointList implements EndpointList, Serializable {

	@JsonDeserialize(as=List.class, contentAs=KeystoneEndpoint.class)
	private List<Endpoint> endpoints = new ArrayList<Endpoint>();

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.EndpointList#getList()
	 */
	@Override
	public List<Endpoint> getList() {
		return endpoints;
	}

	public void setList(List<Endpoint> endpoints) {
		this.endpoints = endpoints;
	}
	
}
