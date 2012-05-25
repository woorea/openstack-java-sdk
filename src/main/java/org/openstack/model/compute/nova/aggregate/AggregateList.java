package org.openstack.model.compute.nova.aggregate;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class AggregateList {

	@JsonProperty("aggregates")
	private List<Aggregate> list = new ArrayList<Aggregate>();

	public List<Aggregate> getList() {
		return list;
	}
	
}
