package org.openstack.api.compute;

import java.util.Map;
import java.util.Properties;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.ImageList;
import org.openstack.model.compute.nova.NovaImageList;

public class ImagesResource extends Resource {
	
	public ImagesResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public ImageList get(Map<String, Object> filters) {
		Target target = this.target.path("/detail");
		if(filters != null) {
			if(filters.get("server") != null) {
				target = target.queryParam("server", filters.get("server"));
			}
			if(filters.get("name") != null) {
				target = target.queryParam("name", filters.get("name"));
			}
			if(filters.get("status") != null) {
				target = target.queryParam("status", filters.get("status"));
			}
			if(filters.get("marker") != null) {
				target = target.queryParam("marker", filters.get("marker"));
			}
			if(filters.get("limit") != null) {
				target = target.queryParam("limit", filters.get("marker"));
			}
			if(filters.get("changes-since") != null) {
				target = target.queryParam("changes-since", filters.get("changes-since"));
			}
			if(filters.get("type") != null) {
				target = target.queryParam("type", filters.get("type"));
			}
		}
		return target.request(MediaType.APPLICATION_JSON).get(NovaImageList.class);
	}

    public ImageList get() { 
		return get(null);
	}

    public ImageResource image(String id) {
    	return new ImageResource(target.path("/{id}").pathParam("id", id), properties);
    }

	

}
