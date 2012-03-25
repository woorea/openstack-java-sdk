package org.openstack.api.images;

import java.io.InputStream;
import java.util.Map;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.openstack.model.images.Image;

public class ImageResource extends Resource {
	
	public ImageResource(Target target) {
		super(target);
	}
	
    public void put(Map<String, Object> properties, Map<String, Object> metadata) {
    	Builder b = target.request(MediaType.APPLICATION_JSON);
        b = GlanceHeaderUtils.setHeadersForProperties(b, metadata);
        b.method("PUT");
    }

    public Image head() throws OpenstackException {
        Response response = target.request().head();
        int httpStatus = response.getStatus();
        if (httpStatus == 200) {
            Image image = GlanceHeaderUtils.unmarshalHeaders(response.getHeaders());
            return image;
        }

        if (httpStatus == 404) {
            throw new OpenstackNotFoundException("Image not found");
        }

        throw new OpenstackException("Unexpected HTTP status code: " + httpStatus);
    }

	public InputStream openStream() {
        return target.request().get(InputStream.class);
    }

    public Response delete() {
        return target.request().delete();
    }
	
}
