package org.openstack.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.client.Client;

import org.openstack.api.common.RestClient;
import org.openstack.api.identity.IdentityResource;
import org.openstack.model.identity.KeyStoneAccess;
import org.openstack.model.identity.KeyStoneAuthentication;
import org.openstack.utils.Io;

public class OpenstackTestContext {

	private KeyStoneAccess access;
	
	private boolean verbose;
	
	private boolean glanceEnabled;
	private boolean swiftEnabled;
	
	private String format;
/*
	public KeyStoneAccess connect(OpenstackCredentials credentials, String format, boolean verbose) {
		
		
		
		session = OpenStackSession.create();
		if (verbose) {
			session.with(OpenStackSession.Feature.VERBOSE);
		}

		if (format != null) {
			if (format.equals("json")) {
				session.with(OpenStackSession.Feature.FORCE_JSON);
			} else if (format.equals("xml")) {
				session.with(OpenStackSession.Feature.FORCE_XML);
			} else {
				throw new IllegalArgumentException("Unknown format: " + format);
			}
		}

		session.authenticate(credentials, false);
		return session;
	}
*/
	public static OpenstackTestContext buildFromProperties() {
		Properties properties = new Properties();

		String configPath = System.getProperties().getProperty("openstack.config", null);
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

		// Command line properties should take precedence
		properties.putAll(System.getProperties());
		
		OpenstackTestContext context = new OpenstackTestContext();

		context.verbose = Boolean.parseBoolean(properties.getProperty("openstack.debug", "true"));
		context.glanceEnabled = Boolean.parseBoolean(properties.getProperty("openstack.glance", "false"));
		context.swiftEnabled = Boolean.parseBoolean(properties.getProperty("openstack.swift", "false"));
		context.format = properties.getProperty("openstack.format", null);

		String url = properties.getProperty("openstack.auth.url", "http://192.168.1.45:5000/v2.0");
		String username = properties.getProperty("openstack.auth.user", "demo");
		String secret = properties.getProperty("openstack.auth.secret", "secret0");
		String tenant = properties.getProperty("openstack.auth.tenant", "demo");

		Client client = RestClient.INSTANCE.verbose(true).getJerseyClient();
		KeyStoneAuthentication authentication = new KeyStoneAuthentication().withPasswordCredentials(username, secret);
		IdentityResource identity = IdentityResource.endpoint(client,url);
		
		context.access = identity.tokens().authenticate(authentication);

		return context;
		
	}

	public boolean isGlanceEnabled() {
		return glanceEnabled;
	}

	public boolean isSwiftEnabled() {
		return swiftEnabled;
	}
}
