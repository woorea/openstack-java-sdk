package org.openstack.client.compute.ext;

import org.openstack.client.common.Resource;
import org.openstack.client.common.ResourceExtension;
import org.openstack.client.compute.notavailable.AccountsResource;
import org.openstack.client.compute.notavailable.CloudPipeResource;
import org.openstack.client.compute.notavailable.FloatingIpDnsResource;
import org.openstack.client.compute.notavailable.FloatingIpPoolsResource;
import org.openstack.client.compute.notavailable.NetworksResource;
import org.openstack.client.compute.notavailable.VirtualStorageArraysResource;

public enum ComputeExtension {
	
	/**
	 * All extensions should be unavailable as default,
	 * I put available until we decide how to implement this
	 */
	
	ZONES("zones", true, ZoneResource.class),
	OS_VOLUME_TYPES("os-volume-types", true, VolumeTypesResource.class),
	VOLUMES("os-volumes", true, VolumesResource.class),
	VIRTUAL_STORAGE_ARRAYS("vsa", true, VirtualStorageArraysResource.class),
	SIMPLE_TENANT_USAGE_RESOURCE("os-simple-tenant-usage", true, SimpleTenantUsageResource.class),
	QUOTA_SETS("os-quota-sets", true, QuotasResource.class),
	NETWORKS("os-networks", true, NetworksResource.class),
	FLOATING_IPS("os-floating-ips", true, FloatingIpsResource.class),
	FLOATING_IP_POOLS("os-floating-ip-pools", true, FloatingIpPoolsResource.class),
	FLOATING_IP_DNS("os-floating-ip-dns", true, FloatingIpDnsResource.class),
	CLOUDPIPE("os-cloudpipe", true, CloudPipeResource.class),
	ACCOUNTS("accounts", true, AccountsResource.class),
	KEYPAIRS("os-keypairs", true, KeyPairsResource.class),
    SECURITY_GROUPS("os-security-groups", true, SecurityGroupsResource.class),
    SECURITY_GROUP_RULES("os-security-group-rules", true, SecurityGroupRulesResource.class);
	
	private String path;
	private boolean available;
	private Class<? extends Resource> resourceClass;
	
	private <T extends Resource & ResourceExtension> ComputeExtension(String path, boolean available, Class<T> resourceClass) {
		this.path = path;
		this.available = available;
		this.resourceClass = resourceClass; 
	}
	
	public String getPath() {
		return this.path;
	}
	
	public boolean isAvailable() {
		return this.available;
	}
	
	public Class<? extends Resource> getResourceClass() {
		return this.resourceClass;
	}
}
