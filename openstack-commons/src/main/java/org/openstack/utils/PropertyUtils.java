package org.openstack.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class PropertyUtils {
    public static Properties loadProperties(File file) throws IOException {
        Properties properties = new Properties();
        FileInputStream is = new FileInputStream(file);
        try {
            properties.load(is);
        } finally {
            Io.safeClose(is);
        }
        return properties;
    }

    public static Properties getChildProperties(Properties base, String prefix) {
        Properties children = new Properties();

        for (Map.Entry<Object, Object> entry : base.entrySet()) {
            Object keyObject = entry.getKey();
            if (!(keyObject instanceof String))
                continue;

            String key = (String) keyObject;
            if (!key.startsWith(prefix))
                continue;

            String suffix = key.substring(prefix.length());
            children.put(suffix, entry.getValue());
        }

        return children;
    }

	public static void copyToMap(Properties properties, Map<String, String> dest) {
		for (Entry<Object, Object> entry : properties.entrySet()) {
			dest.put((String) entry.getKey(), (String) entry.getValue());
		}
	}
}
