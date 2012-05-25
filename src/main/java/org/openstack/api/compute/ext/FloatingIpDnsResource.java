package org.openstack.api.compute.ext;

import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.nova.floatingipdns.DomainEntry;

public class FloatingIpDnsResource extends Resource {

	public FloatingIpDnsResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public String get() {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
	public FloatingIpDnsDomainResource domain(String domain) {
		return new FloatingIpDnsDomainResource(target.path("/{domain}").pathParam("domain", domain), properties);
	}
	
}
