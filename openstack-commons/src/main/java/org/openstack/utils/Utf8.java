package org.openstack.utils;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/**
 * Helper class that does String <-> UTF8 encoding
 * 
 */
public class Utf8 {
	static final Charset CHARSET = Charset.forName("UTF-8");

	private Utf8() {
	}

	public static String toString(ByteArrayOutputStream baos) {
		return toString(baos.toByteArray());
	}

	private static String toString(byte[] bytes) {
		return new String(bytes, CHARSET);
	}

	public static byte[] getBytes(String s) {
		return s.getBytes(CHARSET);
	}

}
