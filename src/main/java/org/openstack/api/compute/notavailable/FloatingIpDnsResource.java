package org.openstack.api.compute.notavailable;

import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;

public class FloatingIpDnsResource extends Resource {

	public FloatingIpDnsResource(Target target, Properties properties) {
		super(target, properties);
	}

	public String get() {
		return target.request(MediaType.APPLICATION_JSON).get(String.class);
	}
	
}
