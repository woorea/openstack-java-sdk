package org.openstack.ceilometer.rabbitmq;

import org.openstack.ceilometer.MessageListener;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMqProducer implements MessageListener {

	private String host = "192.168.1.38";
	
	private String username;
	
	private String password;
	
	private String exchangeName = "metering";
	
	private String exchangeType = "topic";
	
	private String routingKey;
	
	private Connection connection;
	
	private Channel channel;

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param exchangeName the exchangeName to set
	 */
	public void setExchangeName(String exchangeName) {
		this.exchangeName = exchangeName;
	}

	/**
	 * @param exchangeType the exchangeType to set
	 */
	public void setExchangeType(String exchangeType) {
		this.exchangeType = exchangeType;
	}

	/**
	 * @param routingKey the routingKey to set
	 */
	public void setRoutingKey(String routingKey) {
		this.routingKey = routingKey;
	}

	public void init() {
		try {
			
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

			connection = cf.newConnection();
			channel = connection.createChannel();
			
			channel.exchangeDeclare(exchangeName, exchangeType);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	public void produce(String message) {
		try {
			System.out.println("Publish " + message);
			channel.basicPublish(exchangeName, routingKey, null, message.getBytes());
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
	public void detroy() {
		try {
			channel.close();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	@Override
	public void onMessage(String message) {
		produce(message);
	}

}
