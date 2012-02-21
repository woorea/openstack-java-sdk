package org.openstack.model.compute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonUnwrapped;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.common.PagingListBase;

@XmlRootElement(name = "servers")
@XmlAccessorType(XmlAccessType.NONE)
public class ServerList extends PagingListBase<Server> {

	@XmlElement(name = "server")
	@JsonProperty("servers")
	private List<Server> list = new ArrayList<Server>();

	@Override
	public Iterator<Server> iterateItemsOnPage() {
		return list.iterator();
	}

	@Override
	public String toString() {
		return "ServerList [list=" + list + "]";
	}

}
