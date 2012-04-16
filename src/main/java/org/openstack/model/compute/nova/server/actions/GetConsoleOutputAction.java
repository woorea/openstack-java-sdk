package org.openstack.model.compute.nova.server.actions;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerAction;

@XmlRootElement(name="os-getConsoleOutput")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("os-getConsoleOutput")
public class GetConsoleOutputAction implements Serializable, ServerAction {

	@XmlElement(required=true)
	private Integer length;

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}
	
	@Override
	public Class<? extends Serializable> getReturnType() {
		return Output.class;
	}
	
}
