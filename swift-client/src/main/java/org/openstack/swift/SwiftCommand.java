package org.openstack.swift;

import javax.ws.rs.client.WebTarget;

public interface SwiftCommand<R> {
	
	static final String REQ_HEADER_AUTH_TOKEN = "X-Auth-Token";

	R execute(WebTarget target);
	R execute(WebTarget target, String token);
	
}
