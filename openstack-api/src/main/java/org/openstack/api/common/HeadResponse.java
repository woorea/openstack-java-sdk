package org.openstack.api.common;

import javax.ws.rs.core.ResponseHeaders;

public class HeadResponse {
	final int httpStatus;
	final ResponseHeaders headers;

	public HeadResponse(int httpStatus, ResponseHeaders headers) {
		super();
		this.httpStatus = httpStatus;
		this.headers = headers;
	}

	public int getStatus() {
		return httpStatus;
	}

	public ResponseHeaders getHeaders() {
		return headers;
	}

}
