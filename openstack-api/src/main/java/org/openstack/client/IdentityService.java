package org.openstack.client;

import java.util.Map;

import org.openstack.api.identity.IdentityAdministrationEndpoint;
import org.openstack.api.identity.IdentityInternalEndpoint;
import org.openstack.api.identity.IdentityPublicEndpoint;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;

import com.google.common.collect.Maps;

public class IdentityService {
	
	private OpenStackClient client;
	
	private KeystoneService service;
	
	private Map<String, KeystoneServiceEndpoint> regions = Maps.newHashMap();

	public IdentityService(OpenStackClient client, KeystoneService service) {
		this.client = client;
		this.service = service;
		for(KeystoneServiceEndpoint region : service.getEndpoints()) {
			this.regions.put(region.getRegion(), region);
		}
	}

	public IdentityPublicEndpoint getPublicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getPublicEndpoint(defaultRegion);
	}
	
	public IdentityPublicEndpoint getPublicEndpoint(String region) {
		return client.target(regions.get(region).getPublicURL(), IdentityPublicEndpoint.class);
	}
	
	public IdentityInternalEndpoint getInternalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getInternalEndpoint(defaultRegion);
	}
	
	public IdentityInternalEndpoint getInternalEndpoint(String region) {
		return client.target(regions.get(region).getInternalURL(), IdentityInternalEndpoint.class);
	}
	
	public IdentityAdministrationEndpoint getAdministationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getAdministationEndpoint(defaultRegion);
	}
	
	public IdentityAdministrationEndpoint getAdministationEndpoint(String region) {
		return client.target(regions.get(region).getAdminURL(), IdentityAdministrationEndpoint.class);
	}
	
}
