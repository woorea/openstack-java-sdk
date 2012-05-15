package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.usage.NovaSimpleTenantUsage;

/**
 * Simple tenant usage extension
 * 
 * @author sp
 *
 */
public class SimpleTenantUsageResource extends Resource {
	
	public SimpleTenantUsageResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public NovaSimpleTenantUsage get(String start, String end) {
		Target localTarget = target.queryParam("detailed",1);
		if(start != null) {
			localTarget = localTarget.queryParam("detailed",1);
		}
		if(end != null) {
			localTarget = localTarget.queryParam("detailed",1);
		}
		return localTarget.request(MediaType.APPLICATION_JSON).get(NovaSimpleTenantUsage.class);
	}

}
