package org.openstack.model.compute.nova.floatingipdns;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("dns_entry")
public class DnsEntry {

	private String ip;
	
	@JsonProperty("dns_type")
	private String type;
	
}
