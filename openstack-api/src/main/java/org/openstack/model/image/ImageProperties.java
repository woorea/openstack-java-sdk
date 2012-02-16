package org.openstack.model.image;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import org.codehaus.jackson.annotate.JsonAnySetter;
import org.testng.collections.Maps;

@XmlAccessorType(XmlAccessType.NONE)
public class ImageProperties {
    final Map<String, Object> properties = Maps.newHashMap();

    @JsonAnySetter
    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }
}
