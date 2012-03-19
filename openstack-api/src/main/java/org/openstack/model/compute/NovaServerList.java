package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

@XmlRootElement(name = "servers")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaServerList implements Serializable {

	@XmlElement(name = "server")
	@JsonProperty("servers")
	private List<NovaServer> list = new ArrayList<NovaServer>();

	@Override
	public String toString() {
		return "ServerList [list=" + list + "]";
	}
	
	public void setList(List<NovaServer> list) {
		this.list = list;
	}

	public List<NovaServer> getList() {
		return list;
	}

}
