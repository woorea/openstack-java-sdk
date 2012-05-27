package org.openstack.model.compute.nova.aggregate;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("aggregate")
public class AggregateForCreate {

	private String name;
	
	@JsonProperty("availability_zone")
	private String availabilityZone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public void setAvailabilityZone(String availabilityZone) {
		this.availabilityZone = availabilityZone;
	}
	
}
