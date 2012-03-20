package org.openstack.client.cli;

import java.util.Map;

import com.google.common.collect.Maps;

public class SessionCache {

	final Map<OpenstackSessionInfo, OpenStackSession> sessions = Maps.newHashMap();

	public OpenStackSession get(OpenstackSessionInfo key) {
		OpenStackSession session = sessions.get(key);
		if (session == null) {
			session = key.buildSession();
			sessions.put(key, session);
		}
		return session;
	}

}
