package org.openstack.model.atom;

import java.io.Serializable;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.client.OpenstackException;
import org.openstack.client.common.OpenstackSession;
import org.openstack.client.common.RequestBuilder;

@XmlRootElement(name="link")
@XmlAccessorType(XmlAccessType.NONE)
public class Link implements Serializable {

	@XmlAttribute
	private String rel;
	
	@XmlAttribute
	private String href;
	
	@XmlAttribute
	private String type;

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public <T> T follow(OpenstackSession session, String method, Class<T> c) {
		// TODO: Handle method?
		try {
			RequestBuilder request = session.resource(href).addAcceptType(MediaType.APPLICATION_XML_TYPE).setContentType(MediaType.APPLICATION_XML_TYPE);
			return request.get(c);
		} catch (Exception e) {
			throw new OpenstackException(e.getMessage(), e);
		}
	}

	@Override
	public String toString() {
		return "Link [rel=" + rel + ", href=" + href + ", type=" + type + "]";
	}
	
}
