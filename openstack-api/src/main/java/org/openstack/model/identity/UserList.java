package org.openstack.model.identity;

import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.PagingListBase;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.NONE)
public class UserList extends PagingListBase<User> {

	@XmlElement(name = "user")
	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	@Override
	public Iterator<User> iterateItemsOnPage() {
		return list.iterator();
	}

}
