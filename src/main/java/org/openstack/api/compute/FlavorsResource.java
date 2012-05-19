package org.openstack.api.compute;

import java.util.Map;
import java.util.Properties;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;
import org.openstack.model.compute.ServerList;
import org.openstack.model.compute.nova.NovaFlavorList;
import org.openstack.model.compute.nova.NovaServerList;

public class FlavorsResource extends Resource {
	
	public FlavorsResource(Target target, Properties properties) {
		super(target, properties);
	}
	
	public FlavorList get(Map<String, Object> filters) {
		Target target = this.target.path("/detail");
		if(filters != null) {
			if(filters.get("minDisk") != null) {
				target = target.queryParam("minDisk", filters.get("minDisk"));
			}
			if(filters.get("minRam") != null) {
				target = target.queryParam("minRam", filters.get("minRam"));
			}
			if(filters.get("marker") != null) {
				target = target.queryParam("marker", filters.get("marker"));
			}
			if(filters.get("limit") != null) {
				target = target.queryParam("limit", filters.get("marker"));
			}
		}
		return target.request(MediaType.APPLICATION_JSON).get(NovaFlavorList.class);
	}

    public FlavorList get() {
		return get(null);
    }
    
    public Flavor post(Flavor flavor) {
		return target.request(MediaType.APPLICATION_JSON).post(Entity.entity(flavor, MediaType.APPLICATION_JSON), Flavor.class);
	}

    public FlavorResource flavor(String id) {
    	return new FlavorResource(target.path("/{id}").pathParam("id", id), properties);
    }

	

}
