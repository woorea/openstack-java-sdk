package org.openstack.client.common;

import org.openstack.client.OpenstackCredentials;
import org.openstack.client.OpenstackException;
import org.openstack.client.identity.IdentityResource;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;

public class OpenstackAuthenticationClient {

	private final OpenstackSession session;

	private IdentityResource root;

	OpenstackAuthenticationClient(OpenstackSession session) {
		this.session = session;
	}

	public Access authenticate(OpenstackCredentials credentials) throws OpenstackException {
		IdentityResource identity = new IdentityResource();
		identity.initialize(session, session.getIdentityConfig().getAuthenticationURL());

		Authentication authentication = new Authentication();
		Authentication.PasswordCredentials passwordCredentials = new Authentication.PasswordCredentials();
		passwordCredentials.setUsername(credentials.getUsername());
		passwordCredentials.setPassword(credentials.getPassword());
		authentication.tenantName = credentials.getTenant();
		// authentication.tenantId = credentials.getTenant();
		authentication.setPasswordCredentials(passwordCredentials);

		Access access = identity.tokens().authenticate(authentication);
		return access;
	}

	public synchronized IdentityResource root() throws OpenstackException {
		if (root == null) {
			String endpoint = session.getBestEndpoint("identity");
			root = new IdentityResource(session, endpoint);
		}
		return root;
	}

}
