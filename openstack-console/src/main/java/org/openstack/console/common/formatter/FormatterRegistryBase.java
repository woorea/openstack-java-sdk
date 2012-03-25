package org.openstack.console.common.formatter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openstack.console.common.discovery.Discovery;


public class FormatterRegistryBase implements FormatterRegistry {
	final Map<Class<?>, Formatter> registry = new HashMap<Class<?>, Formatter>();

	public Formatter getFormatter(Class<?> clazz) {
		return registry.get(clazz);
	}

	protected void addDefaultFormatters() {
		addFormatter(new StringFormatter());
		addFormatter(new ClientActionDefaultFormatter());
	}

	protected void addFormatter(Formatter formatter) {
		for (Class<?> command : formatter.getHandledClasses()) {
			registry.put(command, formatter);
		}
	}

	protected void discoverFormatters(Package package1) {
		Discovery discovery = new Discovery();
		List<Class<?>> classes = discovery.findClasses(getClass().getPackage());
		List<Formatter> formatters = discovery.buildInstances(Formatter.class, classes);
		for (Formatter formatter : formatters) {
			addFormatter(formatter);
		}
	}
}
