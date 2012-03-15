package org.openstack.client.common;

import java.util.logging.Logger;

import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneToken;

import com.sun.jersey.api.client.ClientRequest;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.filter.ClientFilter;

class OpenstackAuthenticationFilter extends ClientFilter {
	static final Logger log = Logger.getLogger(OpenstackAuthenticationFilter.class.getName());

	final KeyStoneAccess access;

	public OpenstackAuthenticationFilter(KeyStoneAccess access) {
		this.access = access;
	}

	public ClientResponse handle(ClientRequest request) {
		KeyStoneToken token = null;
		if (access != null) {
			token = access.getToken();
		}

		String authTokenId = null;
		if (token != null) {
			authTokenId = token.getId();
		}

		if (authTokenId != null && !authTokenId.isEmpty()) {
			request.getHeaders().putSingle("X-Auth-Token", authTokenId);
		}

		ClientResponse response = getNext().handle(request);

		return response;
	}
}
