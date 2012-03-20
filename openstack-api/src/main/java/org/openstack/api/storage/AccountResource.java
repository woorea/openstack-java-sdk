package org.openstack.api.storage;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.storage.SwiftAccount;

public class AccountResource extends Resource {
	
	public AccountResource(Target target) {
		super(target);
	}

	public SwiftAccount get() {
		return target.request(MediaType.APPLICATION_JSON).get(SwiftAccount.class);
	}

	public ContainersResource containers() {
		return path("/containers",ContainersResource.class);
	}

	public static AccountResource endpoint(Client client, String endpoint) {
		return new AccountResource(client.target(endpoint));
	}

}
