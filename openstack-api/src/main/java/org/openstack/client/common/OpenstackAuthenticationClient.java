package org.openstack.client.common;

import org.openstack.client.identity.IdentityResource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.model.identity.KeyStoneService;

import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

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
		String endpoint = session.getData().getBestEndpoint("identity");
		root = new IdentityResource(session, endpoint);
		return root;
	}

	public IdentityResource admin() {
		/*
		KeyStoneService service = Iterables.find(session.getData().getAccess().getServiceCatalog(), new Predicate<KeyStoneService>() {

			@Override
			public boolean apply(KeyStoneService service) {
				return "identity".equals(service.getType().equals("identity"));
			}
		
		});
		//String endpoint = service.getEndpoints().get(0).getAdminURL();
		*/
		String endpoint = "http://192.168.1.45:35357/v2.0";
		root = new IdentityResource(session, endpoint);
		return root;
	}

}
