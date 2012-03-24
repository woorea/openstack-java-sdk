package org.openstack.client.jersey2;

import java.util.Map;

import org.openstack.api.identity.IdentityResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;

import com.google.common.collect.Maps;

public class OpenStackIdentityClient {
	
	private OpenStackClient client;
	
	private KeystoneService service;
	
	private Map<String, KeystoneServiceEndpoint> regions = Maps.newHashMap();

	public OpenStackIdentityClient(OpenStackClient client, KeystoneService service) {
		this.client = client;
		this.service = service;
		for(KeystoneServiceEndpoint region : service.getEndpoints()) {
			this.regions.put(region.getRegion(), region);
		}
	}

	public IdentityResource publicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return publicEndpoint(defaultRegion);
	}
	
	public IdentityResource publicEndpoint(String region) {
		return client.target(regions.get(region).getPublicURL(), IdentityResource.class);
	}
	
	public IdentityResource internalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return internalEndpoint(defaultRegion);
	}
	
	public IdentityResource internalEndpoint(String region) {
		return client.target(regions.get(region).getInternalURL(), IdentityResource.class);
	}
	
	public IdentityResource administrationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return administrationEndpoint(defaultRegion);
	}
	
	public IdentityResource administrationEndpoint(String region) {
		return client.target(regions.get(region).getAdminURL(), IdentityResource.class);
	}
	
}
