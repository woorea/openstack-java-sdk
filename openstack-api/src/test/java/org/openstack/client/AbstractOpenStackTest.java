package org.openstack.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;
import org.openstack.client.OpenStackClient;
import org.openstack.client.OpenStackClientFactory;
import org.openstack.client.utils.RandomUtil;
import org.testng.SkipException;

public abstract class AbstractOpenStackTest {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractOpenStackTest.class.getName());
	
	protected OpenStackClient client;
	
	protected boolean verbose;
	
	protected boolean glanceEnabled;
	protected boolean swiftEnabled;
	
	protected String format;
	
	protected RandomUtil random = new RandomUtil();

	public void init() {
		
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
				IOUtils.closeQuietly(fis);
			}
		}

		// Command line properties should take precedence
		properties.putAll(System.getProperties());
		
		

		this.verbose = Boolean.parseBoolean(properties.getProperty("openstack.debug", "true"));
		this.glanceEnabled = Boolean.parseBoolean(properties.getProperty("openstack.glance", "true"));
		this.swiftEnabled = Boolean.parseBoolean(properties.getProperty("openstack.swift", "true"));
		this.format = properties.getProperty("openstack.format", null);

		String url = properties.getProperty("openstack.auth.url", "http://192.168.1.52:5000/v2.0");
		String username = properties.getProperty("openstack.auth.user", "admin");
		String secret = properties.getProperty("openstack.auth.secret", "secret0");
		String tenant = properties.getProperty("openstack.auth.tenant", "admin");

		this.client = OpenStackClientFactory.authenticate(url, username, secret, tenant);

	}

	protected void skipUntilBugFixed(int bugNumber) {
		throw new SkipException("Skipping because of bug #" + bugNumber);
	}

}
