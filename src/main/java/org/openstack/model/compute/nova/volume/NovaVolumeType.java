package org.openstack.model.compute.nova.volume;

import java.io.Serializable;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("volume_type")
public class NovaVolumeType implements Serializable {
	
	private String name;
	
	@JsonProperty("extra_specs")
	private Map<String, String> extraSpecs;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getExtraSpecs() {
		return extraSpecs;
	}

	public void setExtraSpecs(Map<String, String> extraSpecs) {
		this.extraSpecs = extraSpecs;
	}

}
