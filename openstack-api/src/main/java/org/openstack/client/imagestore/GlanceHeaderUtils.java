package org.openstack.client.imagestore;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.logging.Logger;

import javax.xml.bind.annotation.XmlAttribute;

import org.openstack.client.common.HeadResponse;
import org.openstack.client.common.RequestBuilder;
import org.openstack.model.image.Image;

import com.google.common.collect.Maps;

class GlanceHeaderUtils {
    static final Logger log = Logger.getLogger(GlanceHeaderUtils.class.getName());

    static RequestBuilder setHeadersForProperties(RequestBuilder builder, Map<String, Object> metadata) {
        for (Map.Entry<String, Object> tag : metadata.entrySet()) {
            builder.putHeader("x-image-meta-property-" + tag.getKey(), tag.getValue().toString());
        }
        return builder;
    }

    static RequestBuilder setHeaders(RequestBuilder builder, Image properties) {
        if (properties.getName() != null) {
            builder.putHeader("x-image-meta-name", properties.getName());
        } else {
            // throw new IllegalArgumentException("Name is required");
        }

        if (properties.getId() != null) {
            builder.putHeader("x-image-meta-id", properties.getName());
        }

        // x-image-meta-store
        // This header is optional. Valid values are one of file, s3, or swift
        // When present, Glance will attempt to store the disk image data in the backing store indicated by the value of the header. If the Glance node does not support the backing store, Glance will
        // return a 400 Bad Request.
        // When not present, Glance will store the disk image data in the backing store that is marked default. See the configuration option default_store for more information.

        if (properties.getDiskFormat() != null) {
            builder.putHeader("x-image-meta-disk-format", properties.getDiskFormat());
        }
        if (properties.getContainerFormat() != null) {
            builder.putHeader("x-image-meta-container-format", properties.getContainerFormat());
        }

        if (properties.getSize() != null) {
            builder.putHeader("x-image-meta-size", properties.getSize().toString());
        }

        if (properties.getChecksum() != null) {
            builder.putHeader("x-image-meta-checksum", properties.getChecksum());
        }

        if (properties.isPublic() != null) {
            builder.putHeader("x-image-meta-is-public", properties.isPublic().toString());
        }

        if (properties.getMinRam() != null) {
            builder.putHeader("x-image-meta-min-ram", properties.getMinRam().toString());
        }

        if (properties.getMinDisk() != null) {
            builder.putHeader("x-image-meta-min-disk", properties.getMinDisk().toString());
        }

        if (properties.getOwner() != null) {
            builder.putHeader("x-image-meta-owner", properties.getOwner());
        }

        return setHeadersForProperties(builder, properties.getProperties().asMap());
    }

    static Map<String, Field> imageFieldMap;

    static Map<String, Field> getImageFieldMap() {
        if (imageFieldMap == null) {
            Map<String, Field> map = Maps.newHashMap();
            for (Field field : Image.class.getDeclaredFields()) {
                XmlAttribute xmlAttribute = field.getAnnotation(XmlAttribute.class);
                if (xmlAttribute == null)
                    continue;

                String name = xmlAttribute.name();
                if ("##default".equals(name))
                    name = null;

                if (name == null)
                    name = field.getName();

                field.setAccessible(true);

                map.put(name, field);
            }
            imageFieldMap = map;
        }
        return imageFieldMap;
    }

    public static Image unmarshalHeaders(HeadResponse response) {
        Image image = new Image();
        for (Entry<String, List<String>> entry : response.getHeaders().entrySet()) {
            String key = entry.getKey();
            List<String> values = entry.getValue();
            if (values.size() != 1) {
                throw new IllegalStateException();
            }
            String value = values.get(0);
            key = key.toLowerCase();

            Map<String, Field> imageFieldMap = getImageFieldMap();

            String USER_PROPERTY_PREFIX = "x-image-meta-property-";
            String SYSTEM_PROPERTY_PREFIX = "x-image-meta-";
            if (key.startsWith(USER_PROPERTY_PREFIX)) {
                String name = key.substring(USER_PROPERTY_PREFIX.length());
                image.getProperties().addProperty(name, value);
            } else if (key.startsWith(SYSTEM_PROPERTY_PREFIX)) {
                String name = key.substring(SYSTEM_PROPERTY_PREFIX.length());
                Field field = imageFieldMap.get(name);
                if (field == null)
                    throw new IllegalStateException("Unknown header: " + key);

                setField(image, field, value);
            } else if (key.equals("location")) {
                if (image.getUri() != null)
                    throw new IllegalStateException();
                image.setUri(value);
            } else {
                log.fine("Ignoring unknown header " + key);
            }
            // if (key.equals("x-image-meta-min-ram")) {
            // image.setMinRam(Integer.parseInt(value));
            // } else if (key.equals("x-image-meta-checksum")) {
            // image.setChecksum(value);
            // } else if (key.equals("x-image-meta-owner")) {
            // image.setOwner(value);
            // } else if (key.equals("x-image-meta-deleted_at")) {
            // image.setOwner(value);
            // } else {
            // throw new IllegalStateException();
            // }
        }
        return image;
    }

    private static void setField(Object target, Field field, String value) {
        Object fieldValue = value;
        try {
            Class<?> fieldType = field.getType();
            if (value.isEmpty()) {
                // It's questionable as to whether we should map the empty string to null
                // https://bugs.launchpad.net/glance/+bug/933702
                fieldValue = null;
            } else if (fieldType == Date.class) {
                DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                format.setTimeZone(TimeZone.getTimeZone("UTC"));
                try {
                    fieldValue = format.parse(value);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Unable to parse date value: " + value);
                }
            } else if (fieldType == Integer.class) {
                fieldValue = Integer.valueOf(value);
            } else if (fieldType == Long.class) {
                fieldValue = Long.valueOf(value);
            } else if (fieldType == Boolean.class) {
                fieldValue = Boolean.valueOf(value);
            }
            field.set(target, fieldValue);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Error setting field: " + field, e);
        }
    }
}
