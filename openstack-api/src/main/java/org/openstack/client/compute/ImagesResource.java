package org.openstack.client.compute;

import org.openstack.client.common.RequestBuilder;
import org.openstack.client.common.Resource;
import org.openstack.client.common.SimplePagingList;
import org.openstack.model.compute.NovaImage;
import org.openstack.model.compute.NovaImageList;

public class ImagesResource extends Resource {

    public Iterable<NovaImage> list(boolean detail) {
    	RequestBuilder r = detail ? resource("detail") : resource();
    	NovaImageList page = r.get(NovaImageList.class);
    	
    	// Does this actually page?
        return new SimplePagingList<NovaImage>(session, page);
    }

    public Iterable<NovaImage> list() {
    	return list(true);
    }

    public ImageResource image(String id) {
        return buildChildResource(id, ImageResource.class);
    }

}
