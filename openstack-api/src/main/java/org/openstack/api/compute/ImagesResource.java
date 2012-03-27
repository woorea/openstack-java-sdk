package org.openstack.api.compute;

import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.compute.ImageList;
import org.openstack.model.compute.nova.NovaImageList;

public class ImagesResource extends Resource {
	
	public ImagesResource(Target target) {
		super(target);
	}

    public ImageList get() { 
		return target.path("/detail").request(MediaType.APPLICATION_JSON).get(NovaImageList.class);
	}

    public ImageResource image(String id) {
    	return new ImageResource(target.path("/{id}").pathParam("id", id));
    }

	

}
