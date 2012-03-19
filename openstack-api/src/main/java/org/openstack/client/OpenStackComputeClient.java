package org.openstack.client;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.api.compute.TenantResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeyStoneService;
import org.openstack.model.identity.KeyStoneServiceEndpoint;
import org.openstack.model.identity.KeyStoneToken;

public class OpenStackComputeClient {
	
	private Client client;
	
	private KeyStoneToken token;
	
	private KeyStoneService service;
	
	private Map<String, KeyStoneServiceEndpoint> regions;

	public OpenStackComputeClient(KeyStoneToken token, KeyStoneService service) {
		for(KeyStoneServiceEndpoint region : service.getEndpoints()) {
			regions.put(region.getRegion(), region);
		}
	}

	public TenantResource publicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return publicEndpoint(defaultRegion);
	}
	
	public TenantResource publicEndpoint(String region) {
		return target(regions.get(region).getPublicURL(), TenantResource.class);
	}
	
	public TenantResource internalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return internalEndpoint(defaultRegion);
	}
	
	public TenantResource internalEndpoint(String region) {
		return target(regions.get(region).getInternalURL(), TenantResource.class);
	}
	
	public TenantResource administrationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return administrationEndpoint(defaultRegion);
	}
	
	public TenantResource administrationEndpoint(String region) {
		return target(regions.get(region).getAdminURL(), TenantResource.class);
	}
	
	public <T extends Resource> T target(String absoluteURL, Class<T> clazz) {
		try {
			T instance = (T) clazz.getConstructor(Target.class).newInstance(client.target(absoluteURL));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return null;
	}
	
}
