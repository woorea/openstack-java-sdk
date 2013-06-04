package com.woorea.openstack.base.client;

public class OpenStackResponseException extends RuntimeException {

	private static final long serialVersionUID = 7294957362769575271L;

	protected String message;

	protected int status;

	public OpenStackResponseException(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

}
