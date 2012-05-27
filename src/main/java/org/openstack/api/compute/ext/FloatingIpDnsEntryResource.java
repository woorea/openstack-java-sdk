package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.floatingipdns.DnsEntry;

public class FloatingIpDnsEntryResource extends Resource {

	public FloatingIpDnsEntryResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	/**
	 * Return a list of dns entries for the specified domain and ip.
	 * 
	 * @return
	 */
	public String get() {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	public String put(DnsEntry dnsEntry) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(dnsEntry), String.class);
	}
	
	public String delete() {
		return target.request(MediaType.APPLICATION_JSON).delete(String.class);
	}
	
}
