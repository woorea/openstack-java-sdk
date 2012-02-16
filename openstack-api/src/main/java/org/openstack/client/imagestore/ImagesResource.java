package org.openstack.client.imagestore;

import org.openstack.client.common.PagingList;
import org.openstack.model.image.Image;
import org.openstack.model.image.ImageList;

import com.sun.jersey.api.client.WebResource.Builder;

public class ImagesResource extends GlanceResourceBase {

    public Iterable<Image> list() {
        return list(true);
    }

    public Iterable<Image> list(boolean details) {
        Builder imagesResource = details ? resource("detail") : resource();

        ImageList imageList = imagesResource.get(ImageList.class);
        return new PagingList<Image>(client, imageList);
    }

    public ImageResource image(String imageId) {
        return buildChildResource(imageId, ImageResource.class);
    }

}
