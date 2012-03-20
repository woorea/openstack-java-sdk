package org.openstack.api.compute;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.NovaFlavor;

public class FlavorResource extends Resource {

	public FlavorResource(Target target) {
		super(target);
	}

	public NovaFlavor get(HashMap<String, Object> properties) {
		return target.request(MediaType.APPLICATION_JSON).get(NovaFlavor.class);
	}

	public NovaFlavor get() {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("detail",true);
		return get();
	}

	

}
