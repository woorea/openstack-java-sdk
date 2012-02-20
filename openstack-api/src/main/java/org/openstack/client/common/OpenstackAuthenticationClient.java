package org.openstack.client.common;

import java.util.List;

import org.openstack.client.OpenstackCredentials;
import org.openstack.client.OpenstackException;
import org.openstack.client.identity.IdentityResource;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.Service;

import com.google.common.collect.Lists;

public class OpenstackAuthenticationClient {
	private final OpenstackSession session;
    private final String url;

    Access authenticationToken = null;

    OpenstackAuthenticationClient(OpenstackSession session, String url) {
        this.session = session;
		this.url = url;
    }

    public Access authenticate(OpenstackCredentials credentials) throws OpenstackException {
        IdentityResource identity = new IdentityResource();
        identity.initialize(session, url);
        
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

    
}
