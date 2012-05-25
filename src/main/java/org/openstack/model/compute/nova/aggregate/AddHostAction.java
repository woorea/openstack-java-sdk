package org.openstack.model.compute.nova.aggregate;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("add_host")
public class AddHostAction implements AggregateAction {

	private String host;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
}
