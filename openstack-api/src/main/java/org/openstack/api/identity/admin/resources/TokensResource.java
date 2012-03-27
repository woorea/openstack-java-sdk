package org.openstack.api.identity.admin.resources;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeystoneAccess;
import org.openstack.model.identity.KeystoneAuthentication;

public class TokensResource extends Resource {
	
	public TokensResource(Target target) {
		super(target);
	}

    public KeystoneAccess post(KeystoneAuthentication authentication) {	
    	return target.request(MediaType.APPLICATION_JSON).post(Entity.json(authentication), KeystoneAccess.class);
    }

}
