package org.openstack.api.images;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.openstack.api.common.Resource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.images.Image;
import org.openstack.model.images.ImageList;
import org.openstack.model.images.glance.GlanceImage;
import org.openstack.model.images.glance.GlanceImageList;

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

	public Image post(InputStream imageStream, long size, Image imageProperties) throws OpenstackException, IOException {
	
		Builder b = target.request(MediaType.APPLICATION_JSON);
		
		GlanceHeaderUtils.setHeaders(b, imageProperties);
		byte[] bytes = IOUtils.toByteArray(imageStream);
		imageProperties.setSize((long) bytes.length);
		System.out.println(bytes.length);

		return b.post(Entity.entity(bytes, MediaType.APPLICATION_OCTET_STREAM_TYPE), GlanceImage.class);
	}

	

}
