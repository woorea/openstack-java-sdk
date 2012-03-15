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
public class KeyStoneUserList extends PagingListBase<KeyStoneUser> {

	@XmlElement(name = "user")
	private List<KeyStoneUser> list;

	public List<KeyStoneUser> getList() {
		return list;
	}

	public void setList(List<KeyStoneUser> list) {
		this.list = list;
	}

	@Override
	public Iterator<KeyStoneUser> iterateItemsOnPage() {
		return list.iterator();
	}

}
