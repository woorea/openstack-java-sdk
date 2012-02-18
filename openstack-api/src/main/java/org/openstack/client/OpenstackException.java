package org.openstack.client;

public class OpenstackException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public OpenstackException(String message, Throwable cause) {
		super(message, cause);
	}

	public OpenstackException(String message) {
		super(message);
	}

}
