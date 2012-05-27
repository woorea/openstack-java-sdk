package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.floatingipdns.DomainEntry;

public class FloatingIpDnsDomainResource extends Resource {

	public FloatingIpDnsDomainResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	/**
	 * Return a list of dns entries for the specified domain and ip.
	 * 
	 * @return
	 */
	
	public String put(DomainEntry domainEntry) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(domainEntry), String.class);
	}
	
	public String delete() {
		return target.request(MediaType.APPLICATION_JSON).delete(String.class);
	}
	
	public FloatingIpDnsEntriesResource entries() {
		return new FloatingIpDnsEntriesResource(target.path("/entries"), properties);
	}
	
}
