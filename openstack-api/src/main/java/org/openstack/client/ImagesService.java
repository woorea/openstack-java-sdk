package org.openstack.client;

import java.util.Map;

import org.openstack.api.compute.TenantResource;
import org.openstack.api.images.ImagesResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;

import com.google.common.collect.Maps;

public class ImagesService {
	
	private OpenStackClient client;
	
	private KeystoneService service;
	
	private Map<String, KeystoneServiceEndpoint> regions = Maps.newHashMap();

	public ImagesService(OpenStackClient client, KeystoneService service) {
		this.client = client;
		this.service = service;
		for(KeystoneServiceEndpoint region : service.getEndpoints()) {
			this.regions.put(region.getRegion(), region);
		}
	}

	public ImagesResource getPublicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getPublicEndpoint(defaultRegion);
	}
	
	public ImagesResource getPublicEndpoint(String region) {
		return client.target(regions.get(region).getPublicURL().concat("/images"), ImagesResource.class);
	}
	
	public ImagesResource getInternalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getInternalEndpoint(defaultRegion);
	}
	
	public ImagesResource getInternalEndpoint(String region) {
		return client.target(regions.get(region).getInternalURL().concat("/images"), ImagesResource.class);
	}
	
	public ImagesResource getAdministrationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return getAdministrationEndpoint(defaultRegion);
	}
	
	public ImagesResource getAdministrationEndpoint(String region) {
		return client.target(regions.get(region).getAdminURL().concat("/images"), ImagesResource.class);
	}
	
}
