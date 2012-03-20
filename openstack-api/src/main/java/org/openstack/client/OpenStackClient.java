package org.openstack.client;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;

import org.openstack.api.common.Resource;
import org.openstack.api.identity.IdentityResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneService;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class OpenStackClient {
	
	private Client client;
	
	private String authURL;
	
	private KeyStoneAccess access;
	
	private OpenStackIdentityClient identity;
	
	private OpenStackComputeClient compute;
	
	OpenStackClient(Client client, String authURL, KeyStoneAccess access) {
		this.client = client;
		this.authURL = authURL;
		this.access = access;
	}
	
	public KeyStoneAccess getAccess() {
		return access;
	}

	public synchronized void setAccess(KeyStoneAccess access) {
		this.access = access;
		identity = null;
		compute = null;
	}
	
	public void exchangeTokenForTenant(String tenantId) {
		KeyStoneAuthentication authentication = new KeyStoneAuthentication().withTokenAndTenant(access.getToken().getId(), tenantId);
		KeyStoneAccess access = target(authURL, IdentityResource.class).tokens().authenticate(authentication);
		setAccess(access);
		
	}

	public OpenStackIdentityClient identity() {
		if(compute == null) {
			Preconditions.checkNotNull(access, "You must be authenticated before get a identity client");
			Preconditions.checkNotNull(access.getServices(), "Identity does not provide information about services, you can try openstack.target(<identityURL>, IdentityResource.class) method instead");
			try {
				this.identity = new OpenStackIdentityClient(this, Iterables.find(access.getServices(), new Predicate<KeyStoneService>() {

					@Override
					public boolean apply(KeyStoneService service) {
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
				this.compute = new OpenStackComputeClient(this, Iterables.find(access.getServices(), new Predicate<KeyStoneService>() {

					@Override
					public boolean apply(KeyStoneService service) {
						return "compute".equals(service.getType());
					}
					
				}));
			} catch (NoSuchElementException e) {
				throw new OpenstackException("Compute service not found, you can try openstack.target(<computeTenantURL>, TenantResource.class) method instead", e);
			}
		}
		return this.compute;
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
