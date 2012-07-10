package org.openstack.api.common;

import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.InvocationException;
import javax.ws.rs.client.Target;

import org.glassfish.jersey.filter.LoggingFilter;
import org.openstack.model.exceptions.OpenStackException;

public class Resource {
	
	protected Target target;
	protected Properties properties;
	
	protected Resource(Target target, Properties properties) {
		this.target = target;
		this.properties = properties;
	}

	public <T extends Resource> T path(String relativePath, Class<T> clazz) {
		//T instance = clazz.cast(resources.get(relativePath));
		T instance = null;
		if (instance == null) {
			try {
				instance = (T) clazz.getConstructor(Target.class, Properties.class).newInstance(target.path(relativePath), properties);
			} catch (Exception e) {
				throw new IllegalStateException("Error creating resource instance", e);
			}
		}
		return instance;
	}
	
	public String getURL() {
		return target.getUri().toString();
	}
	
	protected <T> T execute(Invocation invocation, Class<T> responseType) {
		try {
			return invocation.invoke(responseType);
		} catch (InvocationException e) {
			throw new OpenStackException(e.getResponse().getStatus(), e.getResponse().readEntity(String.class),e);
		}
	}

	protected void registerLoggingFilter(String loggerName) {
		Formatter formatter = new Formatter() {
			@Override
			public String format(LogRecord record) {
				StringBuilder b = new StringBuilder();
				b.append(record.getMessage().replaceAll("\"password\":\".+\"(,|})", "\"password\":\"******\"$1"));
				b.append(System.getProperty("line.separator"));
				return b.toString();
			}
		};
		Logger logger = Logger.getLogger(loggerName);
		Handler ch = new ConsoleHandler();
		ch.setFormatter(formatter);
		Handler[] handlers = logger.getHandlers();
		for(Handler handler : handlers) {
			logger.removeHandler(handler);
		}
		logger.setUseParentHandlers(false);
		logger.addHandler(ch);
		target.configuration().register(new LoggingFilter(logger, true));
	}
}
