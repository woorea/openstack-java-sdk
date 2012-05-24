package org.openstack.model.compute.nova.usage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class NovaSimpleTenantUsages implements Serializable {
	
	@JsonProperty("tenant_usages")
	private List<NovaSimpleTenantUsage> list = new ArrayList<NovaSimpleTenantUsage>();

	public List<NovaSimpleTenantUsage> getList() {
		return list;
	}

	public void setList(List<NovaSimpleTenantUsage> list) {
		this.list = list;
	}
	
}
