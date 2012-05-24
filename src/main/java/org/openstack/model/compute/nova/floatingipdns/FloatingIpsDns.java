package org.openstack.model.compute.nova.floatingipdns;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class FloatingIpsDns {

	@JsonProperty("domain_entries")
	private List<FloatingIpDns> list = new ArrayList<FloatingIpDns>();
	
}
