package org.openstack.ceilometer.rabbitmq;

import java.util.HashSet;
import java.util.Set;

import org.openstack.ceilometer.collector.handlers.MessageHandler;
import org.openstack.ceilometer.collector.handlers.MeterEventListener;
import org.openstack.ceilometer.model.MeterEvent;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class RabbitMqConsumer implements Runnable {

	private String host;

	private String username;

	private String password;

	private String exchangeName = "metering";

	private String routingKey;

	private String queueName;

	private MessageHandler messageHandler;

	private Set<MeterEventListener> meterEventListeners = new HashSet<MeterEventListener>();

	private Connection connection;

	private Channel channel;

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param exchangeName
	 *            the exchangeName to set
	 */
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	/**
	 * @param routingKey
	 *            the routingKey to set
	 */
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	/**
	 * @param queueName
	 *            the queueName to set
	 */
	public void setQueueName(String queueName) {
		this.queueName = queueName;
	}

	/**
	 * @param messageHandler
	 *            the messageHandler to set
	 */
	public void setMessageHandler(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
	}
	
	public void add(MeterEventListener meterEventListener) {
		meterEventListeners.add(meterEventListener);
	}

	@Override
	public void run() {
		ConnectionFactory cf = new ConnectionFactory();
		if (host != null) {
			cf.setHost(host);
		}
		if (username != null) {
			cf.setUsername(username);
		}
		if (password != null) {
			cf.setPassword(password);
		}
		try {

			connection = cf.newConnection();

			channel = connection.createChannel();

			channel.queueDeclare(queueName, true, false, false, null);

			if (exchangeName != null && routingKey != null) {

				channel.queueBind(queueName, exchangeName, routingKey);

			}

			QueueingConsumer consumer = new QueueingConsumer(channel);

			channel.basicConsume(queueName, true, consumer);

			while (true) {
				System.out
						.println(" ["+Thread.currentThread().getName()+"] waiting for messages ...");
				try {
					QueueingConsumer.Delivery delivery = consumer
							.nextDelivery();
					String message = new String(delivery.getBody());
					String routingKey = delivery.getEnvelope().getRoutingKey();

					System.out.println(" ["+Thread.currentThread().getName()+"] Received '"
							+ routingKey + "':'" + message + "'");

					Set<MeterEvent> meterEvents = messageHandler.handle(message);
					
					for(MeterEventListener meterEventListener : meterEventListeners) {
						for(MeterEvent meterEvent : meterEvents) {
							meterEventListener.onMeterEvent(meterEvent);
						}
					}
							
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
