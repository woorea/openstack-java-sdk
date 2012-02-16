package org.openstack.client.imagestore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.openstack.client.common.PagingList;
import org.openstack.model.image.Image;
import org.openstack.model.image.ImageList;
import org.openstack.model.image.JsonImage;
import org.openstack.utils.Io;

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

    public Image addImage(File imageFile, Image properties) throws IOException {
        FileInputStream fis = new FileInputStream(imageFile);
        try {
            properties.setSize(imageFile.length());

            return addImage(fis, properties);
        } finally {
            Io.safeClose(fis);
        }
    }

    public Image addImage(InputStream imageStream, Image properties) throws IOException {
        Builder builder = resource();

        builder = GlanceHeaderUtils.setHeaders(builder, properties);

        JsonImage uploaded = builder.post(JsonImage.class, imageStream);
        return uploaded.image;
    }

}
