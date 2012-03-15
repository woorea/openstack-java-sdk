package org.openstack.model.compute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.PagingListBase;

@XmlRootElement(name = "images")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaImageList extends PagingListBase<NovaImage> {

	@XmlElement(name = "image")
	private List<NovaImage> list = new ArrayList<NovaImage>();

	@Override
	public Iterator<NovaImage> iterateItemsOnPage() {
		return list.iterator();
	}

	public List<NovaImage> getList() {
		return list;
	}

	public void setList(List<NovaImage> list) {
		this.list = list;
		
	}

}
