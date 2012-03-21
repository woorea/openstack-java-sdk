package org.openstack.client;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.DigestException;
import java.util.Properties;

import org.openstack.client.jersey2.OpenStackClient;
import org.openstack.client.jersey2.OpenStackClientFactory;
import org.openstack.client.utils.RandomUtil;
import org.openstack.utils.Io;
import org.openstack.utils.Md5Hash;
import org.testng.SkipException;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractOpenStackTest {
	
	protected OpenStackClient client;
	
	protected boolean verbose;
	
	protected boolean glanceEnabled;
	protected boolean swiftEnabled;
	
	protected String format;
	
	protected RandomUtil random = new RandomUtil();

	@BeforeMethod
	public void beforeMethod() {
		
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
		
		

		this.verbose = Boolean.parseBoolean(properties.getProperty("openstack.debug", "true"));
		this.glanceEnabled = Boolean.parseBoolean(properties.getProperty("openstack.glance", "true"));
		this.swiftEnabled = Boolean.parseBoolean(properties.getProperty("openstack.swift", "true"));
		this.format = properties.getProperty("openstack.format", null);

		String url = properties.getProperty("openstack.auth.url", "http://192.168.1.52:35357/v2.0");
		String username = properties.getProperty("openstack.auth.user", "demo");
		String secret = properties.getProperty("openstack.auth.secret", "secret0");
		String tenant = properties.getProperty("openstack.auth.tenant", "demo");

		this.client = OpenStackClientFactory.authenticate(url, username, secret, tenant);

	}

	protected void skipUntilBugFixed(int bugNumber) {
		throw new SkipException("Skipping because of bug #" + bugNumber);
	}

	protected void assertStreamsTheSame(InputStream actual, InputStream expected) throws DigestException, IOException {
		byte[] actualHash = new Md5Hash().hash(actual);
		byte[] expectedHash = new Md5Hash().hash(expected);

		assertEquals(actualHash, expectedHash);
	}

}
