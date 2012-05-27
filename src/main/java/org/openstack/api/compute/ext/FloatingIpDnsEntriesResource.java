package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.floatingipdns.DnsEntry;

public class FloatingIpDnsEntriesResource extends Resource {

	public FloatingIpDnsEntriesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	/**
	 * Return a list of dns entries for the specified domain and ip.
	 * 
	 * @return
	 */
	public String get(String ip) {
		return target.queryParam("ip", ip).request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	public String put(DnsEntry dnsEntry) {
		return target.request(MediaType.APPLICATION_JSON).put(Entity.json(dnsEntry), String.class);
	}
	
	public FloatingIpDnsEntryResource entry(String name) {
		return new FloatingIpDnsEntryResource(target.path("/{name}").pathParam("name", name), properties);
	}
	
}
