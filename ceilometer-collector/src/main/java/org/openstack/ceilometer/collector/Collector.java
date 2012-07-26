package org.openstack.ceilometer.collector;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openstack.ceilometer.collector.handlers.ConsoleMeterEventListener;
import org.openstack.ceilometer.collector.handlers.FloatingIpNotificationHandler;
import org.openstack.ceilometer.collector.handlers.InstanceNotificationHandler;
import org.openstack.ceilometer.collector.handlers.MeterEventListener;
import org.openstack.ceilometer.collector.handlers.MeterEventMessageHandler;
import org.openstack.ceilometer.collector.handlers.NotificationMessageHandler;
import org.openstack.ceilometer.mongodb.MongoDbMeterEventListener;
import org.openstack.ceilometer.rabbitmq.RabbitMqConsumer;

public abstract class Collector {
	
	public static final String CONFIG_FILE_PATH = "/etc/ceilometer/ceilometer-collector.properties";

	public static void main(String[] args) throws Exception {
		
		File propertiesFile = new File(CONFIG_FILE_PATH);
		
		Properties properties = new Properties();
		if(!propertiesFile.exists()) {
			System.out.println(String.format("%s not found, using default values", CONFIG_FILE_PATH));
		} else {
			properties.load(new FileInputStream(propertiesFile));
		}
		
		MongoDbMeterEventListener mongoDb = new MongoDbMeterEventListener();
		mongoDb.setHost(properties.getProperty("mongodb.host", "192.168.1.38"));
		mongoDb.setPort(Integer.parseInt(properties.getProperty("mongodb.port", "27017")));
		mongoDb.setDbname(properties.getProperty("mongodb.dbname", "ceilometer"));
		mongoDb.setUsername(properties.getProperty("mongodb.username", null));
		mongoDb.setPassword(properties.getProperty("mongodb.password", null));
		
		mongoDb.start();
		
		MeterEventListener console = new ConsoleMeterEventListener();
		
		RabbitMqConsumer notificationsConsumer = new RabbitMqConsumer();
		notificationsConsumer.setHost(properties.getProperty("mq.host", "192.168.1.38"));
		notificationsConsumer.setUsername(properties.getProperty("mq.username", "guest"));
		notificationsConsumer.setPassword(properties.getProperty("mq.password", "secret0"));
		notificationsConsumer.setExchangeName("nova");
		notificationsConsumer.setRoutingKey("notifications.#");
		notificationsConsumer.setQueueName(properties.getProperty("mq.notifications.queue_name", "notifications_collector"));
		NotificationMessageHandler notificationMessageHandler = new NotificationMessageHandler();
		notificationMessageHandler.add(new InstanceNotificationHandler());
		notificationMessageHandler.add(new FloatingIpNotificationHandler());
		notificationsConsumer.setMessageHandler(notificationMessageHandler);
		notificationsConsumer.add(mongoDb);
		notificationsConsumer.add(console);
		
		RabbitMqConsumer computeAgentConsumer = new RabbitMqConsumer();
		computeAgentConsumer.setHost(properties.getProperty("mq.host", "192.168.1.38"));
		computeAgentConsumer.setUsername(properties.getProperty("mq.username", "guest"));
		computeAgentConsumer.setPassword(properties.getProperty("mq.password", "secret0"));
		computeAgentConsumer.setExchangeName(properties.getProperty("mq.metering.exchange_name", "metering"));
		computeAgentConsumer.setRoutingKey(properties.getProperty("mq.metering.routing_key", "ceilometer.#"));
		computeAgentConsumer.setQueueName(properties.getProperty("mq.metering.queue_name", "ceilometer_collector"));
		computeAgentConsumer.setMessageHandler(new MeterEventMessageHandler());
		computeAgentConsumer.add(mongoDb);
		computeAgentConsumer.add(console);
		
		new Thread(notificationsConsumer, "notificationsConsumer").start();
		new Thread(computeAgentConsumer, "computeAgentConsumer").start();
		
	}

}
