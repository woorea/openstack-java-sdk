package org.openstack.client.imagestore;

import java.util.Map;

import com.sun.jersey.api.client.WebResource.Builder;

public class ImageResource extends GlanceResourceBase {
    public void updateMetadata(Map<String, String> metadata, boolean replace) {
        Builder builder = resource();
        for (Map.Entry<String, String> tag : metadata.entrySet()) {
            builder = builder.header("X-Image-Meta-" + tag.getKey(), tag.getValue());
        }
        builder.put();
    }
}
