package org.openstack.client;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;

import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneToken;

class OpenstackAuthenticationFilter implements RequestFilter {
	
	static final Logger log = Logger.getLogger(OpenstackAuthenticationFilter.class.getName());

	final KeyStoneAccess access;

	public OpenstackAuthenticationFilter(KeyStoneAccess access) {
		this.access = access;
	}

	@Override
	public void preFilter(FilterContext context) throws IOException {
		KeyStoneToken token = null;
		if (access != null) {
			token = access.getToken();
		}

		String authTokenId = null;
		if (token != null) {
			authTokenId = token.getId();
		}

		if (authTokenId != null && !authTokenId.isEmpty()) {
			context.getRequest().getHeaders().asMap().putSingle("X-Auth-Token", authTokenId);
		}
		
	}
}
