package org.openstack.api.identity.admin.resources;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.identity.Token;
import org.openstack.model.identity.keystone.KeystoneToken;

public class TokenResource extends Resource {

	public TokenResource(Target target, Properties properties) {
		super(target, properties);
	}

	public KeystoneToken get() {
		return target.request(MediaType.APPLICATION_JSON).get(KeystoneToken.class);
	}

	public Token update(Entity<Token> entity) {
		return target.request(MediaType.APPLICATION_JSON).put(entity, KeystoneToken.class);
	}

	public Response delete() {
		return target.request(MediaType.APPLICATION_JSON).delete();
	}

}
