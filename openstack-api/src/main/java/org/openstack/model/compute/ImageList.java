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
public class ImageList extends PagingListBase<Image> {

	@XmlElement(name = "image")
	private List<Image> list = new ArrayList<Image>();

	@Override
	public Iterator<Image> iterateItemsOnPage() {
		return list.iterator();
	}

}
