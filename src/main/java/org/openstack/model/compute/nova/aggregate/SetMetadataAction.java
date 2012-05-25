package org.openstack.model.compute.nova.aggregate;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("set_metadata")
public class SetMetadataAction implements AggregateAction {

	@JsonProperty
	Map<String,String> metadata = new HashMap<String, String>();

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}
	
	
}
