package org.openstack.model.image;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import com.google.common.collect.Maps;

@XmlAccessorType(XmlAccessType.NONE)
public class GlanceImageProperties implements Serializable {
    final Map<String, Object> properties = Maps.newHashMap();

    /**
     * This gets mapped to any unrecognized elements (i.e. all the key/value pairs)
     */
    //@JsonAnySetter
    //GSON?
    public void addProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Map<String, Object> asMap() {
        return properties;
    }
}
