package org.openstack.client;

import java.util.Map;

import org.openstack.api.compute.TenantResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;

import com.google.common.collect.Maps;

public class ComputeService {
	
	private OpenStackClient client;
	
	private KeystoneService service;
	
	private Map<String, KeystoneServiceEndpoint> regions = Maps.newHashMap();

	public ComputeService(OpenStackClient client, KeystoneService service) {
		this.client = client;
		this.service = service;
		for(KeystoneServiceEndpoint region : service.getEndpoints()) {
			this.regions.put(region.getRegion(), region);
		}
	}

	public TenantResource getPublicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getPublicEndpoint(defaultRegion);
	}
	
	public TenantResource getPublicEndpoint(String region) {
		return client.target(regions.get(region).getPublicURL(), TenantResource.class);
	}
	
	public TenantResource getInternalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getInternalEndpoint(defaultRegion);
	}
	
	public TenantResource getInternalEndpoint(String region) {
		return client.target(regions.get(region).getInternalURL(), TenantResource.class);
	}
	
	public TenantResource getAdministrationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getAdministrationEndpoint(defaultRegion);
	}
	
	public TenantResource getAdministrationEndpoint(String region) {
		return client.target(regions.get(region).getAdminURL(), TenantResource.class);
	}
	
}
