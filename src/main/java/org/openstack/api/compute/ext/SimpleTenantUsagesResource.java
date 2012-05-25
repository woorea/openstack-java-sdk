package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.usage.NovaSimpleTenantUsage;
import org.openstack.model.compute.nova.usage.NovaSimpleTenantUsages;

/**
 * Simple tenant usage extension
 * 
 * @author sp
 *
 */
public class SimpleTenantUsagesResource extends Resource {
	
	public SimpleTenantUsagesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public NovaSimpleTenantUsages get(String start, String end) {
		Target localTarget = target.queryParam("detailed",1);
		if(start != null) {
			localTarget = localTarget.queryParam("start",start);
		}
		if(end != null) {
			localTarget = localTarget.queryParam("end",end);
		}
		return localTarget.request(MediaType.APPLICATION_JSON).get(NovaSimpleTenantUsages.class);
	}
	
	public SimpleTenantUsageResource tenant(String id) {
		return new SimpleTenantUsageResource(target.path("/{tenantId}").pathParam("tenantId", id), properties);
	}

}
