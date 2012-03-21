package org.openstack.client;

import java.util.Map;

import org.openstack.api.compute.TenantResource;
import org.openstack.api.storage.AccountResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeyStoneService;
import org.openstack.model.identity.KeyStoneServiceEndpoint;

import com.google.common.collect.Maps;

public class OpenStackStorageClient {
	
	private OpenStackClient client;
	
	private KeyStoneService service;
	
	private Map<String, KeyStoneServiceEndpoint> regions = Maps.newHashMap();

	public OpenStackStorageClient(OpenStackClient client, KeyStoneService service) {
		this.client = client;
		this.service = service;
		for(KeyStoneServiceEndpoint region : service.getEndpoints()) {
			this.regions.put(region.getRegion(), region);
		}
	}

	public AccountResource publicEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return publicEndpoint(defaultRegion);
	}
	
	public AccountResource publicEndpoint(String region) {
		return client.target(regions.get(region).getPublicURL(), AccountResource.class);
	}
	
	public AccountResource internalEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return internalEndpoint(defaultRegion);
	}
	
	public AccountResource internalEndpoint(String region) {
		return client.target(regions.get(region).getInternalURL(), AccountResource.class);
	}
	
	public AccountResource administrationEndpoint() throws OpenstackException {
		String defaultRegion = regions.keySet().iterator().next();
		return administrationEndpoint(defaultRegion);
	}
	
	public AccountResource administrationEndpoint(String region) {
		return client.target(regions.get(region).getAdminURL(), AccountResource.class);
	}
	
}

//public SwiftObjectProperties putObject(String containerName, String objectName, File file) throws OpenstackException, IOException {
//SwiftObjectProperties properties = new SwiftObjectProperties();
//properties.setName(objectName);
//return root().containers().id(containerName).objects().putObject(file, properties);
//}
//
//public SwiftObjectProperties putObject(String containerName, String objectName, InputStream objectData, long contentLength) throws OpenstackException, IOException {
//SwiftObjectProperties properties = new SwiftObjectProperties();
//properties.setName(objectName);
//return root().containers().id(containerName).objects().putObject(objectData, contentLength, properties);
//}
//
//public SwiftObjectProperties getObject(String containerName, String objectName, File destFile) throws IOException {
//ObjectResource objectResource = buildObjectResource(containerName, objectName);
//
//// TODO: It would be nicer to get this in one call
//SwiftObjectProperties metadata = objectResource.metadata();
//
//InputStream objectStream = objectResource.openStream();
//try {
//	Io.copyStreams(objectStream, destFile);
//} finally {
//	Io.safeClose(objectStream);
//}
//
//return metadata;
//}
//
//public void deleteObject(String containerName, String objectName) {
//ObjectResource objectResource = buildObjectResource(containerName, objectName);
//objectResource.delete();
//}
//
//public SwiftObjectProperties getObjectDetails(String containerName, String objectName) {
//ObjectResource objectResource = buildObjectResource(containerName, objectName);
//return objectResource.metadata();
//}
//
//public InputStream getDataInputStream(String containerName, String objectName) {
//ObjectResource objectResource = buildObjectResource(containerName, objectName);
//return objectResource.openStream();
//}
//
//private ObjectResource buildObjectResource(String containerName, String objectName) {
//ObjectResource objectResource = root().containers().id(containerName).objects().id(objectName);
//return objectResource;
//}
//
//public Iterable<SwiftStorageObject> listObjects(String containerName, String objectNamePrefix, String delimiter) {
//return root().containers().id(containerName).objects().list(objectNamePrefix, delimiter);
//}
