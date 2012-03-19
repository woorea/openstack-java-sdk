package org.openstack.api.imagestore;

import java.io.InputStream;
import java.util.Map;

import org.openstack.api.common.HeadResponse;
import org.openstack.client.RequestBuilder;
import org.openstack.model.exceptions.OpenstackException;
import org.openstack.model.exceptions.OpenstackNotFoundException;
import org.openstack.model.image.GlanceImage;

public class ImageResource extends GlanceResourceBase {
    public void updateMetadata(Map<String, Object> metadata, boolean replace) {
    	RequestBuilder builder = resource();
        builder = GlanceHeaderUtils.setHeadersForProperties(builder, metadata);
        builder.put();
    }

    public GlanceImage show() throws OpenstackException {
        HeadResponse response = resource().head();
        int httpStatus = response.getStatus();
        if (httpStatus == 200) {
            GlanceImage image = GlanceHeaderUtils.unmarshalHeaders(response);
            return image;
        }

        if (httpStatus == 404) {
            throw new OpenstackNotFoundException("Image not found");
        }

        throw new OpenstackException("Unexpected HTTP status code: " + httpStatus);
    }

	public InputStream openStream() {
        return resource().get(InputStream.class);
    }

    public void delete() {
        resource().delete();
    }
}
