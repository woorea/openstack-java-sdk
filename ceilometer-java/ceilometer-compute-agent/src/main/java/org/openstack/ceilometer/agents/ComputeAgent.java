package org.openstack.ceilometer.agents;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openstack.ceilometer.libvirt.LibvirtPoller;
import org.openstack.ceilometer.rabbitmq.RabbitMqProducer;

public abstract class ComputeAgent {
	
	public static final String CONFIG_FILE_PATH = "/etc/ceilometer/ceilometer-agent.properties";
	
	public static void main(String[] args) throws Exception {
		
		File propertiesFile = new File(CONFIG_FILE_PATH);
		
		Properties properties = new Properties();
		if(!propertiesFile.exists()) {
			System.out.println(String.format("%s not found, using default values", CONFIG_FILE_PATH));
		} else {
			properties.load(new FileInputStream(propertiesFile));
		}
		
		RabbitMqProducer publisher = new RabbitMqProducer();
		publisher.setHost(properties.getProperty("mq.host", "192.168.1.38"));
		publisher.setUsername(properties.getProperty("mq.username", "guest"));
		publisher.setPassword(properties.getProperty("mq.password", "secret0"));
		publisher.setExchangeName(properties.getProperty("mq.ceilometer.exchange_name","metering"));
		publisher.setRoutingKey(properties.getProperty("mq.ceilometer.routing_key", "ceilometer.compute_agent"));
		publisher.init();
		
		LibvirtPoller libvirtPoller = new LibvirtPoller();
		libvirtPoller.setUri(properties.getProperty("libvirt.uri", "qemu:///system"));
		libvirtPoller.addListener(publisher);
		
		new Thread(libvirtPoller).start();
		
	}

}
