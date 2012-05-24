package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.floatingipdns.FloatingIpDns;
import org.openstack.model.compute.nova.floatingipdns.FloatingIpDnsForUpdate;

public class FloatingIpDnsResource extends Resource {

	public FloatingIpDnsResource(Target target, Properties properties) {
		super(target, properties);
	}

	public FloatingIpDns get() {
		return target.request(MediaType.APPLICATION_JSON).get(FloatingIpDns.class);
	}
	
	public String update(FloatingIpDnsForUpdate floatingIpDnsForUpdate) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(floatingIpDnsForUpdate), String.class);
	}
	
	public String delete() {
		return target.request(MediaType.APPLICATION_JSON).delete(String.class);
	}
	
}
