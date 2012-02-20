package org.openstack.client.identity;

import org.openstack.client.common.Resource;

public class IdentityResource extends Resource {

    public TokensResource tokens() {
        return getChildResource("tokens", TokensResource.class);
    }

    public TenantsResource tenants() {
        return getChildResource("tenants", TenantsResource.class);
    }

    public UsersResource users() {
        return getChildResource("users", UsersResource.class);
    }

    public RolesResource roles() {
        return getChildResource("OS-KSADM/roles", RolesResource.class);
    }

    public ServicesResource services() {
        return getChildResource("OS-KSADM/services", ServicesResource.class);
    }

    public EndpointTemplatesResource endpointTemplates() {
        return getChildResource("OS-KSCATALOG/endpointTemplates", EndpointTemplatesResource.class);
    }

}
