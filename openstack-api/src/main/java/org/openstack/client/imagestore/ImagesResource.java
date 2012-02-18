package org.openstack.client.imagestore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.PagingList;
import org.openstack.model.image.Image;
import org.openstack.model.image.ImageList;
import org.openstack.model.image.ImageUploadResponse;
import org.openstack.utils.Io;

import com.sun.jersey.api.client.WebResource.Builder;

public class ImagesResource extends GlanceResourceBase {

	public Iterable<Image> list() {
		return list(true);
	}

	public Iterable<Image> list(boolean details) {
		Builder imagesResource = details ? resource("detail") : resource();

		ImageList imageList = imagesResource.get(ImageList.class);
		return PagingList.build(client, imageList);
	}

	public ImageResource image(String imageId) {
		return buildChildResource(imageId, ImageResource.class);
	}

	public Image addImage(File imageFile, Image properties) throws IOException, OpenstackException {
		FileInputStream fis = new FileInputStream(imageFile);
		try {

			return addImage(fis, imageFile.length(), properties);
		} finally {
			Io.safeClose(fis);
		}
	}

	public Image addImage(InputStream imageStream, long imageStreamLength, Image properties) throws OpenstackException,
			IOException {
		Builder builder = resource();

		builder = GlanceHeaderUtils.setHeaders(builder, properties);

		if (imageStreamLength != -1) {
			properties.setSize(imageStreamLength);

			imageStream = new KnownLengthInputStream(imageStream, imageStreamLength);
		}

		ImageUploadResponse response = builder.post(ImageUploadResponse.class, imageStream);
		Image image = response.getImage();
		return image;
	}

}
