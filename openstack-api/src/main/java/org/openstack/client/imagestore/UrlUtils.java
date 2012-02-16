package org.openstack.client.imagestore;

public class UrlUtils {
	public static String join(String base, String relativePath) {
		if (!base.endsWith("/"))
			return base + "/" + relativePath;
		else
			return base + relativePath;
	}
}
