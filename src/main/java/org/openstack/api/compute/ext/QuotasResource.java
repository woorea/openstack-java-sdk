package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.quota.NovaQuotaSet;

/**
 * Quotas management support
 * 
 * @author sp
 *
 */
public class QuotasResource extends Resource {

	public QuotasResource(Target target, Properties properties) {
		super(target, properties);
	}

	public NovaQuotaSet get() {
		return target.request(MediaType.APPLICATION_JSON).get(NovaQuotaSet.class);
	}
	
	public NovaQuotaSet put(NovaQuotaSet quotaSet) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(quotaSet),NovaQuotaSet.class);
	}

}
