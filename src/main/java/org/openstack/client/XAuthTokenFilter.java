package org.openstack.client;

import java.io.IOException;

import javax.ws.rs.ext.FilterContext;
import javax.ws.rs.ext.RequestFilter;

public class XAuthTokenFilter implements RequestFilter {
	
	private String token;
	
	public XAuthTokenFilter(String token) {
		this.token = token;
	}

	@Override
	public void preFilter(FilterContext context) throws IOException {
		context.getRequestBuilder().header("X-Auth-Token", token);
	}

}
