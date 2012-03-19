package org.openstack.api.imagestore;

import java.io.FilterInputStream;
import java.io.InputStream;

public class KnownLengthInputStream extends FilterInputStream {

	private final long length;

	public KnownLengthInputStream(InputStream in, long length) {
		super(in);
		this.length = length;
	}

	public long getLength() {
		return length;
	}
}
