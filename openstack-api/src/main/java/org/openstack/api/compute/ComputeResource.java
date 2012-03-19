package org.openstack.api.compute;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;
import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;

import org.openstack.api.OpenStackSession2;
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

public class ComputeResource extends Resource {
	
	private ComputeResource(Target target) {
		super(target);
	}
	
	public static ComputeResource endpoint(Client client, String tenantEndpoint) {
		return new ComputeResource(client.target(tenantEndpoint));
	}

	public ServersResource servers() {
        return target("/servers", ServersResource.class);
    }

    public FlavorsResource flavors() {
    	return target("/flavors", FlavorsResource.class);
    }

    public ImagesResource images() {
    	return target("/images", ImagesResource.class);
    }

    public VolumeTypesResource volumeTypes() {
    	return target("/os-volume-types", VolumeTypesResource.class);
    }

    public VolumesResource volumes() {
    	return target("/os-volumes", VolumesResource.class);
    }

    public VirtualStorageArraysResource virtualStorageArrays() {
    	return target("/vsa", VirtualStorageArraysResource.class);
    }

    public SimpleTenantUsageResource usage() {
    	return target("/os-simple-tenant-usage", SimpleTenantUsageResource.class);
    }

    public QuotasResource quotas() {
    	return target("/os-quota-sets", QuotasResource.class);
    }

    public NetworksResource networks() {
    	return target("/os-networks", NetworksResource.class);
    }

    public FloatingIpsResource floatingIps() {
    	return target("/os-floating-ips", FloatingIpsResource.class);
    }
    
	public FloatingIpPoolsResource floatingIpPools() {
		return target("/os-floating-ip-pools", FloatingIpPoolsResource.class);
	}

	public FloatingIpDnsResource floatingIpDns() {
		return target("/os-floating-ip-dns", FloatingIpDnsResource.class);
	}

	public CloudPipeResource cloudPipe() {
		return target("/os-cloudpipe", CloudPipeResource.class);
	}

	public AccountsResource accounts() {
		return target("/accounts", AccountsResource.class);
	}

    public KeyPairsResource keyPairs() {
    	return target("/os-keypairs", KeyPairsResource.class);
    }

    public SecurityGroupsResource securityGroups() {
    	return target("/os-security-groups", SecurityGroupsResource.class);
    }

    public SecurityGroupRulesResource securityGroupRules() {
    	return target("/os-security-group-rules", SecurityGroupRulesResource.class);
    }

    public ExtensionsResource extensions() {
    	return target("/extensions", ExtensionsResource.class);
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
