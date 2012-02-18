package org.openstack.model.compute.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.PagingListBase;

@XmlRootElement(name = "servers")
@XmlAccessorType(XmlAccessType.NONE)
public class ServerList extends PagingListBase<Server> {

	@XmlElement(name = "server")
	private List<Server> list = new ArrayList<Server>();

	@Override
	public Iterator<Server> iterateItemsOnPage() {
		return list.iterator();
	}

}
