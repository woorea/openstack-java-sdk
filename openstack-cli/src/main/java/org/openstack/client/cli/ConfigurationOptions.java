package org.openstack.client.cli;

import org.kohsuke.args4j.Option;
import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackComputeClient;
import org.openstack.client.common.OpenstackImageClient;
import org.openstack.client.common.OpenstackSession;

import com.fathomdb.cli.CliOptions;

public class ConfigurationOptions extends CliOptions {
	@Option(name = "-u", aliases = { "--username", "--user" }, usage = "login username")
	String username;

	@Option(name = "-t", aliases = "--tenant", usage = "login tenant")
	String tenantId;

	@Option(name = "-p", aliases = "--password", usage = "login password")
	String password;

	@Option(name = "-s", aliases = "--server", usage = "specify authentication server")
	String server;

	@Option(name = "-debug", usage = "enable debug output")
	boolean debug;

	public OpenstackComputeClient buildComputeClient() throws OpenstackException {
		return getOpenstackSession().getComputeClient();
	}

	public OpenstackImageClient buildImageClient() throws OpenstackException {
		return getOpenstackSession().getImageClient();
	}

	OpenstackSession session = null;

	static final SessionCache sessionCache = new SessionCache();

	public OpenstackSession getOpenstackSession() {
		if (session == null) {
			OpenstackSessionInfo sessionInfo = new OpenstackSessionInfo(server, username, password, tenantId, debug);

			session = sessionCache.get(sessionInfo);
		}

		return session;
	}
}
