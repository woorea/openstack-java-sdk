package org.openstack.client.cli;

import java.util.Map;

import org.openstack.api.common.OpenStackSession;

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
