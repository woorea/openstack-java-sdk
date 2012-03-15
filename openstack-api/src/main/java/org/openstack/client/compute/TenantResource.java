package org.openstack.client.compute;

import org.openstack.client.common.OpenStackSession;
import org.openstack.client.common.Resource;
import org.openstack.client.compute.ext.FloatingIpsResource;
import org.openstack.client.compute.ext.KeyPairsResource;
import org.openstack.client.compute.ext.QuotasResource;
import org.openstack.client.compute.ext.SecurityGroupRulesResource;
import org.openstack.client.compute.ext.SecurityGroupsResource;
import org.openstack.client.compute.ext.SimpleTenantUsageResource;
import org.openstack.client.compute.ext.VolumeTypesResource;
import org.openstack.client.compute.ext.VolumesResource;
import org.openstack.client.compute.notavailable.AccountsResource;
import org.openstack.client.compute.notavailable.CloudPipeResource;
import org.openstack.client.compute.notavailable.FloatingIpDnsResource;
import org.openstack.client.compute.notavailable.FloatingIpPoolsResource;
import org.openstack.client.compute.notavailable.NetworksResource;
import org.openstack.client.compute.notavailable.VirtualStorageArraysResource;

public class TenantResource extends Resource {

	public TenantResource(OpenStackSession session, String resource) {
		initialize(session, resource);
	}

	public ServersResource servers() {
        return getChildResource("servers", ServersResource.class);
    }

    public FlavorsResource flavors() {
        return getChildResource("flavors", FlavorsResource.class);
    }

    public ImagesResource images() {
        return getChildResource("images", ImagesResource.class);
    }

    public VolumeTypesResource volumeTypes() {
        return getChildResource("os-volume-types", VolumeTypesResource.class);
    }

    public VolumesResource volumes() {
        return getChildResource("os-volumes", VolumesResource.class);
    }

    public VirtualStorageArraysResource virtualStorageArrays() {
        return getChildResource("vsa", VirtualStorageArraysResource.class);
    }

    public SimpleTenantUsageResource usage() {
        return getChildResource("os-simple-tenant-usage", SimpleTenantUsageResource.class);
    }

    public QuotasResource quotas() {
        return getChildResource("os-quota-sets", QuotasResource.class);
    }

    public NetworksResource networks() {
        return getChildResource("os-networks", NetworksResource.class);
    }

    public FloatingIpsResource floatingIps() {
    	return getChildResource("os-floating-ips", FloatingIpsResource.class);
    }
    
	public FloatingIpPoolsResource floatingIpPools() {
		return getChildResource("os-floating-ip-pools", FloatingIpPoolsResource.class);
	}

	public FloatingIpDnsResource floatingIpDns() {
		return getChildResource("os-floating-ip-dns", FloatingIpDnsResource.class);
	}

	public CloudPipeResource cloudPipe() {
		return getChildResource("os-cloudpipe", CloudPipeResource.class);
	}

	public AccountsResource accounts() {
		return getChildResource("accounts", AccountsResource.class);
	}

    public KeyPairsResource keyPairs() {
    	return getChildResource("os-keypairs", KeyPairsResource.class);
    }

    public SecurityGroupsResource securityGroups() {
        return getChildResource("os-security-groups", SecurityGroupsResource.class);
    }

    public SecurityGroupRulesResource securityGroupRules() {
        return getChildResource("os-security-group-rules", SecurityGroupRulesResource.class);
    }

    public ExtensionsResource extensions() {
        return getChildResource("extensions", ExtensionsResource.class);
    }

}
