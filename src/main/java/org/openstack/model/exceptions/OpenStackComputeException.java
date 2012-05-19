package org.openstack.model.exceptions;

import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("computeFault")
public class OpenStackComputeException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String message;
	private Integer code;
	
	public OpenStackComputeException() {
		
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "OpenstackException [message=" + message + ", code=" + code + "]";
	}
	
}
