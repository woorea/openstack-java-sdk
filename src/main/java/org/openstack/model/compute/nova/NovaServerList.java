package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.Server;
import org.openstack.model.compute.ServerList;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "servers")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class NovaServerList implements Serializable, ServerList {

	@XmlElement(name = "server")
	@SerializedName("servers")
	@JsonProperty("servers")
	private List<NovaServer> list;
	
	public NovaServerList() {
		list = new ArrayList<NovaServer>();
	}

	public NovaServerList(Collection<NovaServer> values) {
		list = new ArrayList<NovaServer>(values);
	}

	@Override
	public String toString() {
		return "ServerList [list=" + list + "]";
	}
	
	public void setList(List<NovaServer> list) {
		this.list = list;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.ServerList#getList()
	 */
	@Override
	public List<Server> getList() {
		return (List<Server>) (List<?>) list;
	}

	@Override
	public Iterator<Server> iterator() {
		return getList().iterator();
	}

}
