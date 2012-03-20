package org.openstack.api.imagestore;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;

import org.openstack.api.common.Resource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.image.GlanceImage;
import org.openstack.model.image.GlanceImageList;
import org.openstack.model.image.GlanceImageUploadResponse;
import org.openstack.utils.Io;

public class ImagesResource extends Resource {
	
	public ImagesResource(Target target) {
		super(target);
	}
	
	public GlanceImageList get() {
		HashMap<String, Object> properties = new HashMap<String, Object>();
		properties.put("detail", true);
		return get(properties);
	}
	
	public GlanceImageList get(Map<String,Object> properties) {
		if(properties.get("detail") != null) {
			target =  target.path("/detail");
		} 
		return target.request(MediaType.APPLICATION_JSON).header("X-Auth-Token", properties.get("X-Auth-Token")).get(GlanceImageList.class);
	}

    public ImageResource image(String id) {
    	return new ImageResource(target.path("/{id}").pathParam("id", id));
    }

	public GlanceImage post(Map<String, Object> properties, File imageFile, GlanceImage imageProperties) throws IOException, OpenstackException {
		FileInputStream fis = new FileInputStream(imageFile);
		try {

			return post(properties, fis, imageFile.length(), imageProperties);
		} finally {
			Io.safeClose(fis);
		}
	}

	public GlanceImage post(Map<String, Object> properties, InputStream imageStream, long imageStreamLength, GlanceImage imageProperties) throws OpenstackException,
			IOException {
		

		Builder b = target.request();
		
		GlanceHeaderUtils.setHeaders(b, imageProperties);

		if (imageStreamLength != -1) {
			imageProperties.setSize(imageStreamLength);

			imageStream = new KnownLengthInputStream(imageStream, imageStreamLength);
		}

		GlanceImageUploadResponse response = b.post(Entity.entity(imageStream, MediaType.APPLICATION_OCTET_STREAM_TYPE), GlanceImageUploadResponse.class);
		GlanceImage image = response.getImage();
		return image;
	}

	

}
