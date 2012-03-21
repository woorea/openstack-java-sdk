package org.openstack.client.jersey2;

import java.util.Map;

import org.openstack.api.compute.TenantResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeyStoneService;
import org.openstack.model.identity.KeyStoneServiceEndpoint;

import com.google.common.collect.Maps;

public class OpenStackComputeClient {
	
	private OpenStackClient client;
	
	private KeyStoneService service;
	
	private Map<String, KeyStoneServiceEndpoint> regions = Maps.newHashMap();

	public OpenStackComputeClient(OpenStackClient client, KeyStoneService service) {
		this.client = client;
		this.service = service;
		for(KeyStoneServiceEndpoint region : service.getEndpoints()) {
			this.regions.put(region.getRegion(), region);
		}
	}

	public TenantResource publicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return publicEndpoint(defaultRegion);
	}
	
	public TenantResource publicEndpoint(String region) {
		return client.target(regions.get(region).getPublicURL(), TenantResource.class);
	}
	
	public TenantResource internalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return internalEndpoint(defaultRegion);
	}
	
	public TenantResource internalEndpoint(String region) {
		return client.target(regions.get(region).getInternalURL(), TenantResource.class);
	}
	
	public TenantResource administrationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return administrationEndpoint(defaultRegion);
	}
	
	public TenantResource administrationEndpoint(String region) {
		return client.target(regions.get(region).getAdminURL(), TenantResource.class);
	}
	
}
