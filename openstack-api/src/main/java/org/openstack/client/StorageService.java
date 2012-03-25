package org.openstack.client;

import java.util.Map;

import org.openstack.api.storage.AccountResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;

import com.google.common.collect.Maps;

public class StorageService {
	
	private OpenStackClient client;
	
	private KeystoneService service;
	
	private Map<String, KeystoneServiceEndpoint> regions = Maps.newHashMap();

	public StorageService(OpenStackClient client, KeystoneService service) {
		this.client = client;
		this.service = service;
		for(KeystoneServiceEndpoint region : service.getEndpoints()) {
			this.regions.put(region.getRegion(), region);
		}
	}

	public AccountResource getPublicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getPublicEndpoint(defaultRegion);
	}
	
	public AccountResource getPublicEndpoint(String region) {
		return client.target(regions.get(region).getPublicURL(), AccountResource.class);
	}
	
	public AccountResource getInternalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getInternalEndpoint(defaultRegion);
	}
	
	public AccountResource getInternalEndpoint(String region) {
		return client.target(regions.get(region).getInternalURL(), AccountResource.class);
	}
	
	public AccountResource getAdministrationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getAdministrationEndpoint(defaultRegion);
	}
	
	public AccountResource getAdministrationEndpoint(String region) {
		return client.target(regions.get(region).getAdminURL(), AccountResource.class);
	}
	
}

