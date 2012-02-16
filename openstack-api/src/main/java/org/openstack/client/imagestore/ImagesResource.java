package org.openstack.client.imagestore;

import org.openstack.model.image.Image;
import org.openstack.model.image.ImageList;

import com.sun.jersey.api.client.WebResource.Builder;

public class ImagesResource extends GlanceResourceBase {

    public PagingList<Image> list() {
        return list(true);
    }
    
    public PagingList<Image> list(boolean details) {
    	Builder imagesResource = details ? resource("detail") : resource();
    	
        ImageList list = imagesResource.get(ImageList.class);
        return new PagingList<Image>(client, list);
    }

//    public ImageResource image(String id) {
//    	String path = resource + "/" + id;
//    	
//        return new ImageResource(client, path);
//    }

}
