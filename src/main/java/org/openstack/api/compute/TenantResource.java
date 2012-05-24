package org.openstack.api.compute;

import java.util.Properties;
import java.util.logging.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Target;

import org.glassfish.jersey.filter.LoggingFilter;
import org.openstack.api.common.Resource;
import org.openstack.api.compute.ext.CloudPipesResource;
import org.openstack.api.compute.ext.FloatingIpDnsResource;
import org.openstack.api.compute.ext.FloatingIpPoolsResource;
import org.openstack.api.compute.ext.FloatingIpsResource;
import org.openstack.api.compute.ext.KeyPairsResource;
import org.openstack.api.compute.ext.NetworksResource;
import org.openstack.api.compute.ext.QuotasResource;
import org.openstack.api.compute.ext.SecurityGroupRulesResource;
import org.openstack.api.compute.ext.SecurityGroupsResource;
import org.openstack.api.compute.ext.SimpleTenantUsageResource;
import org.openstack.api.compute.ext.SnapshotsResource;
import org.openstack.api.compute.ext.VolumeTypesResource;
import org.openstack.api.compute.ext.VolumesResource;
import org.openstack.api.compute.notavailable.AccountsResource;

public class TenantResource extends Resource {
	
	private LoggingFilter loggingFilter = new LoggingFilter(Logger.getLogger(TenantResource.class.getPackage().getName()),true);
	
	public TenantResource(Target target, Properties properties) {
		super(target, properties);
		if(Boolean.parseBoolean(properties.getProperty("verbose"))) {
			target.configuration().register(loggingFilter);
		}
	}
	
	public static TenantResource endpoint(Client client, String tenantEndpoint, Properties properties) {
		return new TenantResource(client.target(tenantEndpoint), properties);
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

    public SimpleTenantUsageResource usage(String id) {
    	return new SimpleTenantUsageResource(target.path("/os-simple-tenant-usage/{id}").pathParam("id", id), properties);
    }

    public QuotasResource quotas(String id) {
    	return new QuotasResource(target.path("/os-quota-sets/{id}").pathParam("id", id), properties);
    	//return path(""+id, QuotasResource.class);
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

	public CloudPipesResource cloudPipe() {
		return path("/os-cloudpipe", CloudPipesResource.class);
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
