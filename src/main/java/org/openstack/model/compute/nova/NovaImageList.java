package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;

@XmlRootElement(name = "images")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaImageList implements Serializable, ImageList {

	@XmlElement(name = "image")
	@JsonProperty("images")
	private List<NovaImage> list = new ArrayList<NovaImage>();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.ImageList#getList()
	 */
	@Override
	public List<Image> getList() {
		return (List<Image>) (List<?>) list;
	}

	public void setList(List<NovaImage> list) {
		this.list = list;
		
	}
	
	@Override
	public String toString() {
		return "NovaImageList [list=" + list + "]";
	}

	@Override
	public Iterator<Image> iterator() {
		return getList().iterator();
	}

}
