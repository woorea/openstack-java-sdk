package org.openstack.client.compute;

import java.util.HashMap;
import java.util.Map;

import org.openstack.client.common.OpenstackSession;
import org.openstack.client.common.Resource;
import org.openstack.client.common.ResourceExtension;
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
import org.openstack.client.compute.notavailable.NetworksResource;
import org.openstack.client.compute.notavailable.VirtualStorageArraysResource;

public class TenantResource extends Resource {
	
	private Map<Class<? extends ResourceExtension>, ResourceExtension> extensions;

	public TenantResource(OpenstackSession session, String resource) {
		initialize(session, resource);
		//TODO: study if this map can be a singleton
		extensions = new HashMap<Class<? extends ResourceExtension>, ResourceExtension>();
		extensions.put(ZonesResource.class, getChildResource("zones", ZonesResource.class));
		extensions.put(VolumeTypesResource.class, getChildResource("os-volume-types", VolumeTypesResource.class));
		extensions.put(VolumesResource.class, getChildResource("os-volumes", VolumesResource.class));
		extensions.put(VirtualStorageArraysResource.class, getChildResource("vsa", VirtualStorageArraysResource.class));
		extensions.put(SimpleTenantUsageResource.class, getChildResource("os-simple-tenant-usage", SimpleTenantUsageResource.class));
		extensions.put(QuotasResource.class, getChildResource("os-quota-sets", QuotasResource.class));
		extensions.put(NetworksResource.class, getChildResource("os-networks", NetworksResource.class));
		extensions.put(FloatingIpsResource.class, getChildResource("os-floating-ips", FloatingIpsResource.class));
		extensions.put(FloatingIpPoolsResource.class, getChildResource("os-floating-ip-pools", FloatingIpPoolsResource.class));
		extensions.put(FloatingIpDnsResource.class, getChildResource("os-floating-ip-dns", FloatingIpDnsResource.class));
		extensions.put(CloudPipeResource.class, getChildResource("os-cloudpipe", CloudPipeResource.class));
		extensions.put(AccountsResource.class, getChildResource("accounts", AccountsResource.class));
		extensions.put(KeyPairsResource.class, getChildResource("os-keypairs", AccountsResource.class));
		extensions.put(SecurityGroupsResource.class, getChildResource("os-security-groups", SecurityGroupsResource.class));
		extensions.put(SecurityGroupRulesResource.class, getChildResource("os-security-group-rules", SecurityGroupRulesResource.class));		
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
    
    public ExtensionsResource extensions() {
        return getChildResource("extensions", ExtensionsResource.class);
    }
    
    //TODO: I really want an enum parameter in this method, but i can't make it work yet.
    //The enum is already implemented in org.openstack.client.compute.ext.ComputeResource
	public <T extends Resource & ResourceExtension> T extension(Class<T> extensionClass) {
    	return extensionClass.cast(extensions.get(extensionClass));
    }

}
