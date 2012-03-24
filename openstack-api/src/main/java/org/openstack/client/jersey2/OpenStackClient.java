package org.openstack.client.jersey2;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;
import javax.ws.rs.ext.ResponseFilter;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.IdentityResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;
import org.openstack.model.identity.KeystoneService;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class OpenStackClient {
	
	private Client client;
	
	private String authURL;
	
	private KeystoneAccess access;
	
	private OpenStackIdentityClient identity;
	
	private OpenStackComputeClient compute;
	
	private OpenStackImagesClient images;
	
	private OpenStackStorageClient storage;
	
	OpenStackClient(Client client, String authURL, KeystoneAccess access) {
		this.client = client;
		this.authURL = authURL;
		this.access = access;
	}
	
	public KeystoneAccess getAccess() {
		return access;
	}

	public synchronized void setAccess(KeystoneAccess access) {
		this.access = access;
		identity = null;
		compute = null;
	}
	
	public void exchangeTokenForTenant(String tenantId) {
		KeystoneAuthentication authentication = new KeystoneAuthentication().withTokenAndTenant(access.getToken().getId(), tenantId);
		KeystoneAccess access = target(authURL, IdentityResource.class).tokens().post(authentication);
		setAccess(access);
		
	}

	public OpenStackIdentityClient identity() {
		if(compute == null) {
			Preconditions.checkNotNull(access, "You must be authenticated before get a identity client");
			Preconditions.checkNotNull(access.getServices(), "Identity does not provide information about services, you can try openstack.target(<identityURL>, IdentityResource.class) method instead");
			try {
				this.identity = new OpenStackIdentityClient(this, Iterables.find(access.getServices(), new Predicate<KeystoneService>() {

					@Override
					public boolean apply(KeystoneService service) {
						return "identity".equals(service.getType());
					}
					
				}));
			} catch (NoSuchElementException e) {
				throw new OpenstackException("Compute service not found, you can try openstack.target(<identityURL>, IdentityResource.class) method instead", e);
			}
		}
		return this.identity;
	}
	
	public OpenStackComputeClient compute() {
		if(compute == null) {
			Preconditions.checkNotNull(access, "You must be authenticated before get a compute client");
			Preconditions.checkNotNull(access.getServices(), "Identity does not provide information about services, you can try openstack.target(<computeTenantURL>, TenantResource.class) method instead");
			try {
				this.compute = new OpenStackComputeClient(this, Iterables.find(access.getServices(), new Predicate<KeystoneService>() {

					@Override
					public boolean apply(KeystoneService service) {
						return "compute".equals(service.getType());
					}
					
				}));
			} catch (NoSuchElementException e) {
				throw new OpenstackException("Compute service not found, you can try openstack.target(<computeTenantURL>, TenantResource.class) method instead", e);
			}
		}
		return this.compute;
	}
	
	public OpenStackImagesClient images() {
		if(images == null) {
			Preconditions.checkNotNull(access, "You must be authenticated before get a compute client");
			Preconditions.checkNotNull(access.getServices(), "Identity does not provide information about services, you can try openstack.target(<computeTenantURL>, TenantResource.class) method instead");
			try {
				this.images = new OpenStackImagesClient(this, Iterables.find(access.getServices(), new Predicate<KeystoneService>() {

					@Override
					public boolean apply(KeystoneService service) {
						return "image".equals(service.getType());
					}
					
				}));
			} catch (NoSuchElementException e) {
				throw new OpenstackException("Compute service not found, you can try openstack.target(<computeTenantURL>, TenantResource.class) method instead", e);
			}
		}
		return this.images;
	}
	
	public OpenStackStorageClient storage() {
		if(storage == null) {
			Preconditions.checkNotNull(access, "You must be authenticated before get a compute client");
			Preconditions.checkNotNull(access.getServices(), "Identity does not provide information about services, you can try openstack.target(<computeTenantURL>, TenantResource.class) method instead");
			try {
				this.storage = new OpenStackStorageClient(this, Iterables.find(access.getServices(), new Predicate<KeystoneService>() {

					@Override
					public boolean apply(KeystoneService service) {
						return "object-store".equals(service.getType());
					}
					
				}));
			} catch (NoSuchElementException e) {
				throw new OpenstackException("Storage service not found, you can try target(<storaageURL>, AccountResource.class) method instead", e);
			}
		}
		return this.storage;
	}
	
	public <T extends Resource> T target(String absoluteURL, Class<T> clazz) {
		try {
			Target target = client.target(absoluteURL);
			if(access != null) {
				target.configuration().register(new RequestFilter() {
					
					@Override
					public void preFilter(FilterContext context) throws IOException {
						context.getRequestBuilder().header("X-Auth-Token", access.getToken().getId());
						
					}
					
				});
			}
			return clazz.getConstructor(Target.class).newInstance(target);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}

	

}
