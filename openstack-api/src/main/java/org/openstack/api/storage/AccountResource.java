package org.openstack.api.storage;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;

import org.openstack.api.OpenStackSession2;
import org.openstack.api.common.Resource;
import org.openstack.client.OpenStackSession;
import org.openstack.model.storage.SwiftAccount;

public class AccountResource extends Resource {
	
	private AccountResource(Target target) {
		super(target);
	}

	public AccountResource(OpenStackSession session, String resource) {
		initialize(session, resource);
	}

	public SwiftAccount get() {
		return target.request().get(SwiftAccount.class);
	}

	public ContainersResource containers() {
		return target("/containers",ContainersResource.class);
	}

	public String getBaseUrl() {
		return resource;
	}

	public static AccountResource endpoint(Client client, String endpoint) {
		return new AccountResource(client.target(endpoint));
	}
	
	public void setSession(final OpenStackSession2 session) {
		target.configuration().register(new RequestFilter() {
			
			@Override
			public void preFilter(FilterContext context) throws IOException {
				context.getRequestBuilder().header("X-Auth-Token", session.getAccess().getToken().getId());
				
			}
		});
	}

}
