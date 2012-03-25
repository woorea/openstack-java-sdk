package org.openstack.api.images;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.openstack.api.common.Resource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.images.Image;
import org.openstack.model.images.ImageList;
import org.openstack.model.images.ImageUploadResponse;
import org.openstack.model.images.glance.GlanceImageList;
import org.openstack.model.images.glance.GlanceImageUploadResponse;

public class ImagesResource extends Resource {
	
	public ImagesResource(Target target) {
		super(target);
	}
	
	public ImageList get() {
		return target.path("/detail").request(MediaType.APPLICATION_JSON).get(GlanceImageList.class);
	}

    public ImageResource image(String id) {
    	return new ImageResource(target.path("/{id}").pathParam("id", id));
    }

	public Image post(File imageFile, Image imageProperties) throws IOException, OpenstackException {
		FileInputStream fis = new FileInputStream(imageFile);
		try {

			return post(fis, imageFile.length(), imageProperties);
		} finally {
			IOUtils.closeQuietly(fis);
		}
	}

	public Image post(InputStream imageStream, long imageStreamLength, Image imageProperties) throws OpenstackException, IOException {
	
		Builder b = target.request(MediaType.APPLICATION_JSON);
		
		GlanceHeaderUtils.setHeaders(b, imageProperties);
		System.out.println("up to");
		byte[] bytes = IOUtils.toByteArray(imageStream);
		imageProperties.setSize((long) bytes.length);
		System.out.println(bytes.length);

		ImageUploadResponse response = b.post(Entity.entity(bytes, MediaType.APPLICATION_OCTET_STREAM_TYPE), GlanceImageUploadResponse.class);
		Image image = response.getImage();
		return image;
	}

	

}
