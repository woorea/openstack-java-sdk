package org.openstack.api.compute;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.openstack.api.common.Resource;
import org.openstack.api.compute.ext.FloatingIpsResource;
import org.openstack.api.compute.ext.KeyPairsResource;
import org.openstack.api.compute.ext.QuotasResource;
import org.openstack.api.compute.ext.SecurityGroupRulesResource;
import org.openstack.api.compute.ext.SecurityGroupsResource;
import org.openstack.api.compute.ext.SimpleTenantUsageResource;
import org.openstack.api.compute.ext.SnapshotsResource;
import org.openstack.api.compute.ext.VolumeTypesResource;
import org.openstack.api.compute.ext.VolumesResource;
import org.openstack.api.compute.notavailable.AccountsResource;
import org.openstack.api.compute.notavailable.CloudPipeResource;
import org.openstack.api.compute.notavailable.FloatingIpDnsResource;
import org.openstack.api.compute.notavailable.FloatingIpPoolsResource;
import org.openstack.api.compute.notavailable.NetworksResource;

public class TenantResource extends Resource {
	
	public TenantResource(Target target) {
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

	public SnapshotsResource snapshots() {
		return path("/os-snapshots", SnapshotsResource.class);
	}

}
