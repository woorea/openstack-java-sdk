package org.openstack.ui.server;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.JerseyClientFactory;
import org.openstack.model.common.OpenStackSessionData;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneTenant;
import org.openstack.model.identity.KeyStoneTenantList;
import org.openstack.ui.client.api.IdentityService;

public class IdentityServiceImpl implements IdentityService {

	@Override
	public KeyStoneAccess authenticate(String identityURL, KeyStoneAuthentication authentication) {
		
		UriBuilder uriBuilder = UriBuilder.fromPath(identityURL).path("/tokens");
		
		KeyStoneAccess access = JerseyClientFactory.clientBuilder().build().target(uriBuilder)
			.request(MediaType.APPLICATION_XML)
			.post(Entity.xml(authentication), KeyStoneAccess.class);
		
		/*
		KeyStoneAccess access = JerseyClient.CLIENT.resource(uriBuilder.build())
			.type(MediaType.APPLICATION_XML)
			.accept(MediaType.APPLICATION_XML)
			.post(KeyStoneAccess.class, authentication);
		*/
		KeyStoneTenantList tenants = listTenants(identityURL, access.getToken().getId());
		
		KeyStoneTenant tenant = tenants.getList().get(0);
		
		authentication.setTenantId(tenant.getId());
		
		/*
		access = JerseyClient.CLIENT.resource(uriBuilder.build())
				.type(MediaType.APPLICATION_XML)
				.accept(MediaType.APPLICATION_XML)
				.post(KeyStoneAccess.class, authentication);
		*/
		
		access = JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.post(Entity.xml(authentication), KeyStoneAccess.class);
	
		return access;
	}

	@Override
	public KeyStoneTenantList listTenants(String identityURL, String token) {
		UriBuilder uriBuilder = UriBuilder.fromPath(identityURL).path("/tenants");
		return JerseyClientFactory.newClient().target(uriBuilder)
				.request(MediaType.APPLICATION_XML)
				.get(KeyStoneTenantList.class);
		
		/*
		return JerseyClient.CLIENT.resource(uriBuilder.build())
			.accept(MediaType.APPLICATION_XML)
			.header("X-Auth-Token", token)
			.get(KeyStoneTenantList.class);
		*/
	}

	@Override
	public OpenStackSessionData getSession() {
		return null;
	}

}
