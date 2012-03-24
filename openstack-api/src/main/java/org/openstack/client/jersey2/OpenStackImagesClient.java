package org.openstack.client.jersey2;

import java.util.Map;

import org.openstack.api.compute.TenantResource;
import org.openstack.api.imagestore.ImagesResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneService;
import org.openstack.model.identity.KeystoneServiceEndpoint;

import com.google.common.collect.Maps;

public class OpenStackImagesClient {
	
	private OpenStackClient client;
	
	private KeystoneService service;
	
	private Map<String, KeystoneServiceEndpoint> regions = Maps.newHashMap();

	public OpenStackImagesClient(OpenStackClient client, KeystoneService service) {
		this.client = client;
		this.service = service;
		for(KeystoneServiceEndpoint region : service.getEndpoints()) {
			this.regions.put(region.getRegion(), region);
		}
	}

	public ImagesResource publicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return publicEndpoint(defaultRegion);
	}
	
	public ImagesResource publicEndpoint(String region) {
		return client.target(regions.get(region).getPublicURL().concat("/images"), ImagesResource.class);
	}
	
	public ImagesResource internalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return internalEndpoint(defaultRegion);
	}
	
	public ImagesResource internalEndpoint(String region) {
		return client.target(regions.get(region).getInternalURL().concat("/images"), ImagesResource.class);
	}
	
	public ImagesResource administrationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return administrationEndpoint(defaultRegion);
	}
	
	public ImagesResource administrationEndpoint(String region) {
		return client.target(regions.get(region).getAdminURL().concat("/images"), ImagesResource.class);
	}
	
}
