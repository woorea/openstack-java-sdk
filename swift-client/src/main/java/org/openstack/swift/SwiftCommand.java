package org.openstack.swift;

import javax.ws.rs.client.WebTarget;

public interface SwiftCommand<R> {

	R execute(WebTarget endpoint);
	
}
