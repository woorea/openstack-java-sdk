package org.openstack.client;

import java.util.Properties;
import java.util.logging.Logger;

import org.openstack.client.utils.RandomUtil;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.SkipException;

public abstract class AbstractOpenStackTest {
	
	private static final Logger LOGGER = Logger.getLogger(AbstractOpenStackTest.class.getName());
	
	protected OpenStackClient client;
	
	protected boolean verbose;
	
	protected boolean glanceEnabled;
	protected boolean swiftEnabled;
	
	protected String format;
	
	protected RandomUtil random = new RandomUtil();

	public void init(String configuration) {
		
		try {
			Properties properties = new Properties();
			properties.load(AbstractOpenStackTest.class.getResourceAsStream(configuration));
			
			glanceEnabled = Boolean.parseBoolean(properties.getProperty("test.glance"));
			swiftEnabled = Boolean.parseBoolean(properties.getProperty("test.swift"));
			
			// Command line properties should take precedence
			//properties.putAll(System.getProperties());
			
			client = OpenStackClientFactory.authenticate();
		} catch (Exception e) {
			throw new OpenstackException(e.getMessage(), e);
		}

	}

	protected void skipUntilBugFixed(int bugNumber) {
		throw new SkipException("Skipping because of bug #" + bugNumber);
	}

}
