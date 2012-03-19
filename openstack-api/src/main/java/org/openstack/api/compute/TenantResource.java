package org.openstack.api.compute;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;

import org.openstack.api.common.Resource;
import org.openstack.api.compute.ext.FloatingIpsResource;
import org.openstack.api.compute.ext.KeyPairsResource;
import org.openstack.api.compute.ext.QuotasResource;
import org.openstack.api.compute.ext.SecurityGroupRulesResource;
import org.openstack.api.compute.ext.SecurityGroupsResource;
import org.openstack.api.compute.ext.SimpleTenantUsageResource;
import org.openstack.api.compute.ext.VolumeTypesResource;
import org.openstack.api.compute.ext.VolumesResource;
import org.openstack.api.compute.notavailable.AccountsResource;
import org.openstack.api.compute.notavailable.CloudPipeResource;
import org.openstack.api.compute.notavailable.FloatingIpDnsResource;
import org.openstack.api.compute.notavailable.FloatingIpPoolsResource;
import org.openstack.api.compute.notavailable.NetworksResource;
import org.openstack.api.compute.notavailable.VirtualStorageArraysResource;
import org.openstack.model.common.OpenStackSession2;

public class TenantResource extends Resource {
	
	private TenantResource(Target target) {
		super(target);
	}
	
	public static TenantResource endpoint(Client client, String tenantEndpoint) {
		return new TenantResource(client.target(tenantEndpoint));
	}

	public ServersResource servers() {
        return path("/servers", ServersResource.class);
    }

    public FlavorsResource flavors() {
    	return path("/flavors", FlavorsResource.class);
    }

    public ImagesResource images() {
    	return path("/images", ImagesResource.class);
    }

    public VolumeTypesResource volumeTypes() {
    	return path("/os-volume-types", VolumeTypesResource.class);
    }

    public VolumesResource volumes() {
    	return path("/os-volumes", VolumesResource.class);
    }

    public VirtualStorageArraysResource virtualStorageArrays() {
    	return path("/vsa", VirtualStorageArraysResource.class);
    }

    public SimpleTenantUsageResource usage() {
    	return path("/os-simple-tenant-usage", SimpleTenantUsageResource.class);
    }

    public QuotasResource quotas() {
    	return path("/os-quota-sets", QuotasResource.class);
    }

    public NetworksResource networks() {
    	return path("/os-networks", NetworksResource.class);
    }

    public FloatingIpsResource floatingIps() {
    	return path("/os-floating-ips", FloatingIpsResource.class);
    }
    
	public FloatingIpPoolsResource floatingIpPools() {
		return path("/os-floating-ip-pools", FloatingIpPoolsResource.class);
	}

	public FloatingIpDnsResource floatingIpDns() {
		return path("/os-floating-ip-dns", FloatingIpDnsResource.class);
	}

	public CloudPipeResource cloudPipe() {
		return path("/os-cloudpipe", CloudPipeResource.class);
	}

	public AccountsResource accounts() {
		return path("/accounts", AccountsResource.class);
	}

    public KeyPairsResource keyPairs() {
    	return path("/os-keypairs", KeyPairsResource.class);
    }

    public SecurityGroupsResource securityGroups() {
    	return path("/os-security-groups", SecurityGroupsResource.class);
    }

    public SecurityGroupRulesResource securityGroupRules() {
    	return path("/os-security-group-rules", SecurityGroupRulesResource.class);
    }

    public ExtensionsResource extensions() {
    	return path("/extensions", ExtensionsResource.class);
    }

    public void setSession(final OpenStackSession2 session) {
		target.configuration().register(new RequestFilter() {
			
			@Override
			public void preFilter(FilterContext context) throws IOException {
				context.getRequestBuilder().header("X-Auth-Token", session.getAccess().getToken().getId());
				
			}
		});
	}

}
