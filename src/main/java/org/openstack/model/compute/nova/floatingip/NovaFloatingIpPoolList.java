package org.openstack.model.compute.nova.floatingip;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NovaFloatingIpPoolList {

	@JsonProperty("floating_ip_pools")
	//@JsonDeserialize(as=List.class, contentAs=NovaFloatingIp.class)
	private List<NovaFloatingIpPool> list;

	public List<NovaFloatingIpPool> getList() {
		return list;
	}

	public void setList(List<NovaFloatingIpPool> list) {
		this.list = list;
	}
	
}
