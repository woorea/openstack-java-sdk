package org.openstack.client.compute;

import org.openstack.client.common.Resource;
import org.openstack.client.compute.ext.FloatingIpsResource;
import org.openstack.client.compute.ext.KeyPairsResource;
import org.openstack.client.compute.ext.QuotasResource;
import org.openstack.client.compute.ext.SecurityGroupRulesResource;
import org.openstack.client.compute.ext.SecurityGroupsResource;
import org.openstack.client.compute.ext.SimpleTenantUsageResource;
import org.openstack.client.compute.ext.VolumeTypesResource;
import org.openstack.client.compute.ext.VolumesResource;
import org.openstack.client.compute.ext.ZonesResource;
import org.openstack.client.compute.notavailable.AccountsResource;
import org.openstack.client.compute.notavailable.CloudPipeResource;
import org.openstack.client.compute.notavailable.FloatingIpDnsResource;
import org.openstack.client.compute.notavailable.FloatingIpPoolsResource;
import org.openstack.client.compute.notavailable.HostsResource;
import org.openstack.client.compute.notavailable.NetworksResource;
import org.openstack.client.compute.notavailable.UsersResource;
import org.openstack.client.compute.notavailable.VirtualStorageArraysResource;

import com.sun.jersey.api.client.Client;

public class TenantResource extends Resource {

    private FlavorsResource flavors;

    private ImagesResource images;

    private ConsolesResource consoles;

    private ZonesResource zones;

    private VolumeTypesResource volumeTypes;

    private VolumesResource volumes;

    private VirtualStorageArraysResource virtualStorageArrays;

    private UsersResource users;

    private SimpleTenantUsageResource usage;

    private QuotasResource quotasResource;

    private NetworksResource networks;

    private KeyPairsResource keyPairs;

    private HostsResource hosts;

    private FloatingIpsResource floatingIps;

    private FloatingIpPoolsResource floatingIpPools;

    private FloatingIpDnsResource floatingIpDns;

    private CloudPipeResource cloudPipe;

    private AccountsResource accounts;

    public TenantResource(Client client, String resource) {
        super(client, resource);
    }

    public ServersResource servers() {
        return getChildResource("servers", ServersResource.class);
    }

    public FlavorsResource flavors() {
        if (flavors == null) {
            flavors = new FlavorsResource(client, new StringBuilder(resource).append("/flavors").toString());
        }
        return flavors;
    }

    public ImagesResource images() {
        if (images == null) {
            images = new ImagesResource(client, new StringBuilder(resource).append("/images").toString());
        }
        return images;
    }

    public ZonesResource zones() {
        if (zones == null) {
            zones = new ZonesResource(client, new StringBuilder(resource).append("/zones").toString());
        }
        return zones;
    }

    public VolumeTypesResource volumeTypes() {
        if (volumeTypes == null) {
            volumeTypes = new VolumeTypesResource(client, new StringBuilder(resource).append("/os-volume-types").toString());
        }
        return volumeTypes;
    }

    public VolumesResource volumes() {
        if (volumes == null) {
            volumes = new VolumesResource(client, new StringBuilder(resource).append("/os-volumes").toString());
        }
        return volumes;
    }

    public VirtualStorageArraysResource virtualStorageArrays() {
        if (virtualStorageArrays == null) {
            virtualStorageArrays = new VirtualStorageArraysResource(client, new StringBuilder(resource).append("/vsa").toString());
        }
        return virtualStorageArrays;
    }

    public SimpleTenantUsageResource usage() {
        if (usage == null) {
            usage = new SimpleTenantUsageResource(client, new StringBuilder(resource).append("/os-simple-tenant-usage").toString());
        }
        return usage;
    }

    public QuotasResource quotas() {
        if (quotasResource == null) {
            quotasResource = new QuotasResource(client, new StringBuilder(resource).append("/os-quota-sets").toString());
        }
        return quotasResource;
    }

    public NetworksResource networks() {
        if (networks == null) {
            networks = new NetworksResource(client, new StringBuilder(resource).append("/os-networks").toString());
        }
        return networks;
    }

    public FloatingIpPoolsResource floatingIpPools() {
        if (floatingIpPools == null) {
            floatingIpPools = new FloatingIpPoolsResource(client, new StringBuilder(resource).append("/os-floating-ip-pools").toString());
        }
        return floatingIpPools;
    }

    public FloatingIpDnsResource floatingIpDns() {
        if (floatingIpDns == null) {
            floatingIpDns = new FloatingIpDnsResource(client, new StringBuilder(resource).append("/os-floating-ip-pools").toString());
        }
        return floatingIpDns;
    }

    public CloudPipeResource cloudPipe() {
        if (cloudPipe == null) {
            cloudPipe = new CloudPipeResource(client, new StringBuilder(resource).append("/os-cloudpipe").toString());
        }
        return cloudPipe;
    }

    public AccountsResource accounts() {
        if (accounts == null) {
            accounts = new AccountsResource(client, new StringBuilder(resource).append("/accounts").toString());
        }
        return accounts;
    }

    public KeyPairsResource keyPairs() {
        if (keyPairs == null) {
            keyPairs = new KeyPairsResource(client, new StringBuilder(resource).append("/os-keypairs").toString());
        }
        return keyPairs;
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
