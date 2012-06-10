package org.openstack.model.exceptions;


public class OpenStackException extends RuntimeException {
	
	private int status;

	public OpenStackException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public OpenStackException(int status, String message, Throwable cause) {
		super(message, cause);
		this.status = status;
	}

	public OpenStackException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	public OpenStackException(String message, Throwable e) {
		super(message, e);
		// TODO Auto-generated constructor stub
	}

	
	
}
