package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("quota_set")
public class VolumeQuotaDefaults implements Serializable {
	@JsonProperty("gigabytes")
	String gigabytes;
	@JsonProperty("volumes")
	String volumes;
	@JsonProperty("id")
	String id;
	@JsonProperty("snapshots")
	String snapshots;

	public String getGigabytes() {
		return gigabytes;
	}

	public void setGigabytes(String gigabytes) {
		this.gigabytes = gigabytes;
	}

	public String getVolumes() {
		return volumes;
	}

	public void setVolumes(String volumes) {
		this.volumes = volumes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSnapshots() {
		return snapshots;
	}

	public void setSnapshots(String snapshots) {
		this.snapshots = snapshots;
	}

}
