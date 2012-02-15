package org.openstack.model.compute;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;

@XmlRootElement(name="images")
@XmlAccessorType(XmlAccessType.NONE)
public class ImageList extends ListWithAtomLinks {

	@XmlElement(name="image")
	private List<Image> list = new ArrayList<Image>();

	public List<Image> getList() {
		return list;
	}

	public void setList(List<Image> list) {
		this.list = list;
	}
	
}
