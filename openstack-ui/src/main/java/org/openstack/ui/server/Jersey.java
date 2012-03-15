package org.openstack.ui.server;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class Jersey {

	public static final Client CLIENT;
	
	static {
		CLIENT = Client.create();
		CLIENT.addFilter(new LoggingFilter(System.out));
	}
	
}
