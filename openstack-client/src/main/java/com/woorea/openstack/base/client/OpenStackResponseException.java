package com.woorea.openstack.base.client;

public class OpenStackResponseException extends RuntimeException {

	private static final long serialVersionUID = 7294957362769575271L;

	protected String message;
	protected String fullMessage;
	protected int status;

	public OpenStackResponseException(String message, int status) {
		this.message = message;
		this.status = status;
	}

	public OpenStackResponseException(String message, String fullMessage, int status) {
		this.message = message;
		this.status = status;
		this.fullMessage = fullMessage;
	}

	public String getMessage() {
		return message;
	}

	public String getFullMessage() {
		return fullMessage;
	}

	public int getStatus() {
		return status;
	}

}
