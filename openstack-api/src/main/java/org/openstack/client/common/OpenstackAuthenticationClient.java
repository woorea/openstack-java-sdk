package org.openstack.client.common;

import org.openstack.client.identity.IdentityResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;

import com.google.common.base.Strings;

public class OpenstackAuthenticationClient {

	private final OpenStackSession session;

	private IdentityResource root;

	OpenstackAuthenticationClient(OpenStackSession session) {
		this.session = session;
	}

	public KeyStoneAccess authenticate(OpenstackCredentials credentials) throws OpenstackException {
		IdentityResource identity = new IdentityResource();
		String authUrl = credentials.getAuthUrl();
		if (Strings.isNullOrEmpty(authUrl)) {
			throw new IllegalArgumentException("AuthUrl is required");
		}
		identity.initialize(session, authUrl);

		KeyStoneAuthentication authentication = new KeyStoneAuthentication();
		KeyStoneAuthentication.PasswordCredentials passwordCredentials = new KeyStoneAuthentication.PasswordCredentials();
		passwordCredentials.setUsername(credentials.getUsername());
		passwordCredentials.setPassword(credentials.getPassword());
		if (!Strings.isNullOrEmpty(credentials.getTenant())) {
			authentication.setTenantName(credentials.getTenant());
		} else {
			authentication.setTenantName(null);
		}
		// authentication.tenantId = credentials.getTenant();
		authentication.setPasswordCredentials(passwordCredentials);

		KeyStoneAccess access = identity.tokens().authenticate(authentication);
		return access;
	}

	public synchronized IdentityResource root() throws OpenstackException {
		if (root == null) {
			String endpoint = session.getData().getBestEndpoint("identity");
			root = new IdentityResource(session, endpoint);
		}
		return root;
	}

}
