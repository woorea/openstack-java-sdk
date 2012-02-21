package org.openstack.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openstack.client.common.OpenstackSession;
import org.openstack.utils.Io;

public class OpenstackTestContext {

	public OpenstackSession session;

	public OpenstackSession connect(String url, OpenstackCredentials credentials, boolean verbose) {
		session = new OpenstackSession();
		session.authenticate(url, credentials);
		if (verbose) {
			session.with(OpenstackSession.Feature.VERBOSE);
		}
		return session;
	}

	public static OpenstackTestContext buildFromProperties() {
		OpenstackTestContext context = new OpenstackTestContext();

		Properties properties = System.getProperties();

		String configPath = properties.getProperty("openstack.config", null);
		if (configPath != null) {
			if (configPath.startsWith("~/")) {
				String home = System.getProperty("user.home");
				configPath = home + File.separator + configPath.substring(2);
			}
			File configFile = new File(configPath);
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(configFile);
				properties.load(fis);
			} catch (IOException e) {
				throw new IllegalArgumentException("Error loading config file: " + configPath, e);
			} finally {
				Io.safeClose(fis);
			}
		}

		boolean verbose = Boolean.parseBoolean(properties.getProperty("openstack.debug", "false"));

		String url = properties.getProperty("openstack.auth.url", "http://127.0.0.1:5000/v2.0");
		String username = properties.getProperty("openstack.auth.user", "demo");
		String secret = properties.getProperty("openstack.auth.secret", "supersecret");
		String tenant = properties.getProperty("openstack.auth.tenant", "demo");

		OpenstackCredentials credentials = new OpenstackCredentials(username, secret, tenant);
		context.connect(url, credentials, verbose);
		return context;
	}
}
