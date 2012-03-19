package org.openstack.api.imagestore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.MediaType;

import org.openstack.client.RequestBuilder;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.image.GlanceImage;
import org.openstack.model.image.GlanceImageList;
import org.openstack.model.image.GlanceImageUploadResponse;
import org.openstack.utils.Io;

public class ImagesResource extends GlanceResourceBase {

    public GlanceImageList list() {
        return list(true);
    }

    public GlanceImageList list(boolean details) {
        RequestBuilder imagesResource = details ? resource("detail") : resource();
        return imagesResource.get(GlanceImageList.class);
    }

	public ImageResource image(String imageId) {
		return buildChildResource(imageId, ImageResource.class);
	}

	public GlanceImage addImage(File imageFile, GlanceImage properties) throws IOException, OpenstackException {
		FileInputStream fis = new FileInputStream(imageFile);
		try {

			return addImage(fis, imageFile.length(), properties);
		} finally {
			Io.safeClose(fis);
		}
	}

	public GlanceImage addImage(InputStream imageStream, long imageStreamLength, GlanceImage properties) throws OpenstackException,
			IOException {
		RequestBuilder builder = resource(null, MediaType.APPLICATION_OCTET_STREAM_TYPE);

		builder = GlanceHeaderUtils.setHeaders(builder, properties);

		if (imageStreamLength != -1) {
			properties.setSize(imageStreamLength);

			imageStream = new KnownLengthInputStream(imageStream, imageStreamLength);
		}

		GlanceImageUploadResponse response = builder.post(GlanceImageUploadResponse.class, imageStream);
		GlanceImage image = response.getImage();
		return image;
	}

}
