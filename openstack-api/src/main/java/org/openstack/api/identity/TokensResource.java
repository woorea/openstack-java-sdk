package org.openstack.api.identity;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;

public class TokensResource extends Resource {
	
	public TokensResource(Target target) {
		super(target);
	}

    public KeyStoneAccess authenticate(KeyStoneAuthentication authentication) {	
    	return target.request(MediaType.APPLICATION_JSON).post(Entity.json(authentication), KeyStoneAccess.class);
    }

}
