package org.openstack.model.exceptions;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("error")
public class OpenstackException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private Integer code;
	private String title;
	
	public OpenstackException() {
		
	}

	public OpenstackException(String message, Throwable cause) {
		super(message, cause);
	}

	public OpenstackException(String message) {
		super(message);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OpenstackException [message=" + message + ", code=" + code + ", title=" + title + "]";
	}

}
