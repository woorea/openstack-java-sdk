package org.openstack.client.common;

import java.util.List;

import org.openstack.client.OpenstackCredentials;
import org.openstack.client.OpenstackException;
import org.openstack.client.identity.IdentityResource;
import org.openstack.model.identity.Access;
import org.openstack.model.identity.Authentication;
import org.openstack.model.identity.Service;

import com.google.common.collect.Lists;
import com.sun.jersey.api.client.Client;

public class OpenstackAuthenticationClient {
    private final Client client;
    private final String url;
    private final OpenstackCredentials credentials;

    Access authenticationToken = null;

    OpenstackAuthenticationClient(Client client, String url, OpenstackCredentials credentials) {
        this.client = client;
        this.url = url;
        this.credentials = credentials;
    }

    public synchronized Access getAuthenticationToken() throws OpenstackException {
        if (authenticationToken == null)
            authenticationToken = authenticate();

        return authenticationToken;
    }

    private Access authenticate() throws OpenstackException {
        IdentityResource identity = new IdentityResource(client, url);
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

    public void reauthenticate() throws OpenstackException {
        this.authenticationToken = authenticate();
    }

    Client getClient() {
        return client;
    }

    public String getBestEndpoint(String serviceType) throws OpenstackException {
        Access access = getAuthenticationToken();
        List<Service> foundServices = Lists.newArrayList();
        for (Service service : access.getServiceCatalog()) {
            if (serviceType.equals(service.getType())) {
                foundServices.add(service);
            }
        }

        if (foundServices.isEmpty()) {
            throw new OpenstackException("Cannot find service");
        }

        if (foundServices.size() != 1) {
            throw new OpenstackException("Found multiple services of type: " + serviceType);
        }

        Service service = foundServices.get(0);

        if (service.getEndpoints().size() != 1) {
            throw new OpenstackException("Unhandled number of endpoints");
        }

        String bestUrl = service.getEndpoints().get(0).getPublicURL();

        if (bestUrl == null) {
            throw new OpenstackException("Cannot find endpoint URL for image service");
        }

        return bestUrl;
    }

}
