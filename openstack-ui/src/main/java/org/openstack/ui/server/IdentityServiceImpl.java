package org.openstack.ui.server;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.ui.client.api.IdentityService;

public class IdentityServiceImpl implements IdentityService {

	@Override
	public KeyStoneAccess authenticate(String identityURL, KeyStoneAuthentication authentication) {
		
		System.out.println("AUTH : " + authentication);
		
		UriBuilder uriBuilder = UriBuilder.fromPath(identityURL).path("/tokens");
		
		System.out.println("AUTH : " + uriBuilder.toString());
		
		KeyStoneAccess access = Jersey.CLIENT.resource(uriBuilder.build())
			.type(MediaType.APPLICATION_XML)
			.accept(MediaType.APPLICATION_XML)
			.post(KeyStoneAccess.class, authentication);
		
		KeyStoneTenantList tenants = listTenants(identityURL, access.getToken().getId());
		
		KeyStoneTenant tenant = tenants.getList().get(0);
		
		authentication.setTenantId(tenant.getId());
		
		access = Jersey.CLIENT.resource(uriBuilder.build())
				.type(MediaType.APPLICATION_XML)
				.accept(MediaType.APPLICATION_XML)
				.post(KeyStoneAccess.class, authentication);
	
		return access;
	}

	@Override
	public KeyStoneTenantList listTenants(String identityURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(identityURL).path("/tenants");
		return Jersey.CLIENT.resource(uriBuilder.build())
			.accept(MediaType.APPLICATION_XML)
			.header("X-Auth-Token", token)
			.get(KeyStoneTenantList.class);
	}

	@Override
	public OpenStackSessionData getSession() {
		return null;
	}

}
