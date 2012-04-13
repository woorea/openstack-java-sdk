package org.openstack.model.compute.nova;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import org.openstack.model.compute.Fault;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class NovaFault implements Serializable, Fault {

	@XmlAttribute
	private int code;
	
	@XmlAttribute
	private String created;
	
	@XmlElement
	private String message;
	
	@XmlElement
	private String details;
	
	public NovaFault() {
		
	}
	
	public NovaFault(int code, String created, String message, String details) {
		this.code = code;
		this.created = created;
		this.message = message;
		this.details = details;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Fault#getCode()
	 */
	@Override
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Fault#getCreated()
	 */
	@Override
	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Fault#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Fault#getDetails()
	 */
	@Override
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Fault [code=" + code + ", created=" + created + ", message="
				+ message + ", details=" + details + "]";
	}
	
}
