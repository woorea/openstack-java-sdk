package org.openstack.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openstack.client.utils.RandomUtil;
import org.openstack.model.exceptions.OpenstackException;
import org.testng.SkipException;

public abstract class AbstractOpenStackTest {
	
	protected OpenStackClient client;
	
	protected boolean verbose;
	
	protected boolean glanceEnabled;
	protected boolean swiftEnabled;
	
	protected String format;
	
	protected RandomUtil random = new RandomUtil();

	public void init(String configuration) {
		
		try {
			Properties properties = new Properties();
			properties.load(new FileInputStream(configuration));
			
			glanceEnabled = Boolean.parseBoolean(properties.getProperty("test.glance"));
			swiftEnabled = Boolean.parseBoolean(properties.getProperty("test.swift"));
			
			// Command line properties should take precedence
			properties.putAll(System.getProperties());
			
			client = OpenStackClient.authenticate(properties);
		} catch (IOException e) {
			throw new OpenstackException(e.getMessage(), e);
		}

	}

	protected void skipUntilBugFixed(int bugNumber) {
		throw new SkipException("Skipping because of bug #" + bugNumber);
	}

}
