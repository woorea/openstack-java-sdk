package org.openstack.api.images;

import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.Target;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.openstack.api.common.Resource;
import org.openstack.model.exceptions.OpenStackException;
import org.openstack.model.images.Image;

public class ImageResource extends Resource {
	
	public ImageResource(Target target, Properties properties) {
		super(target, properties);
	}
	
    public void put(Map<String, Object> properties, Map<String, Object> metadata) {
    	Builder b = target.request(MediaType.APPLICATION_JSON);
        b = GlanceHeaderUtils.setHeadersForProperties(b, metadata);
        b.method("PUT");
    }

    public Image head() throws OpenStackException {
        Response response = target.request().head();
        Image image = GlanceHeaderUtils.unmarshalHeaders(response.getHeaders());
        return image;
    }

	public InputStream openStream() {
        return target.request().get(InputStream.class);
    }

    public Response delete() {
        return target.request().delete();
    }
	
}
