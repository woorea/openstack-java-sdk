package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.keystone.KeystoneAccess;

public class TokensResource extends Resource {
	
	public TokensResource(Target target, Properties properties) {
		super(target, properties);
	}

	public Access post(Authentication authentication) {	
		return target.request(MediaType.APPLICATION_JSON).post(Entity.json(authentication), KeystoneAccess.class);
	}

	public TokenResource token(String id) {
		return new TokenResource(target.path("/{tokenId}").pathParam("tokenId", id), properties);
	}

}
