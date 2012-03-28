package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.openstack.model.identity.Endpoint;
import org.openstack.model.identity.EndpointList;

public class KeystoneEndpointList implements EndpointList, Serializable {

	private List<KeystoneEndpoint> endpoints = new ArrayList<KeystoneEndpoint>();

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.EndpointList#getList()
	 */
	@Override
	public List<Endpoint> getList() {
		return (List<Endpoint>) (List<?>) endpoints;
	}

	public void setList(List<KeystoneEndpoint> endpoints) {
		this.endpoints = endpoints;
	}
	
}
