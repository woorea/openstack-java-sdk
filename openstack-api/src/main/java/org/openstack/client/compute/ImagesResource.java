package org.openstack.client.compute;

import org.openstack.client.common.RequestBuilder;
import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;

import com.sun.jersey.api.client.WebResource.Builder;

public class ImagesResource extends Resource {

    public Iterable<Image> list(boolean detail) {
    	RequestBuilder r = detail ? resource("detail") : resource();
    	ImageList page = r.get(ImageList.class);
    	
    	// Does this actually page?
        return new SimplePagingList<Image>(session, page);
    }

    public Iterable<Image> list() {
    	return list(true);
    }

    public ImageResource image(String id) {
        return buildChildResource(id, ImageResource.class);
    }

}
