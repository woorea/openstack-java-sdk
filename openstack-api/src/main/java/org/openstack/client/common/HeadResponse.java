package org.openstack.client.common;

import java.util.List;
import java.util.Map;

public class HeadResponse {
	final int httpStatus;
	final Map<String, List<String>> headers;

	public HeadResponse(int httpStatus, Map<String, List<String>> headers) {
		super();
		this.httpStatus = httpStatus;
		this.headers = headers;
	}

	public int getStatus() {
		return httpStatus;
	}

	public Map<String, List<String>> getHeaders() {
		return headers;
	}

}
