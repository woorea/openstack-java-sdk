package org.openstack.client.jersey2;

import java.util.Map;

import org.openstack.api.compute.TenantResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;

import com.google.common.collect.Maps;

public class OpenStackComputeClient {
	
	private OpenStackClient client;
	
	private KeystoneService service;
	
	private Map<String, KeystoneServiceEndpoint> regions = Maps.newHashMap();

	public OpenStackComputeClient(OpenStackClient client, KeystoneService service) {
		this.client = client;
		this.service = service;
		for(KeystoneServiceEndpoint region : service.getEndpoints()) {
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
