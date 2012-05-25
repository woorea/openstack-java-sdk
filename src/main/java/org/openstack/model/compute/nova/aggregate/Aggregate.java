package org.openstack.model.compute.nova.aggregate;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("aggregate")
public class Aggregate implements Serializable {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("availability_zone")
	private String availabiliyZone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAvailabiliyZone() {
		return availabiliyZone;
	}

	public void setAvailabiliyZone(String availabiliyZone) {
		this.availabiliyZone = availabiliyZone;
	}
	
}
