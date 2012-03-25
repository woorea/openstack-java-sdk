package org.openstack.console.common.output;

public interface ClientActionFormatter<T> {
	ClientAction formatAction(T object);
}
