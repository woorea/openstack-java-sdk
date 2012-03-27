package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.compute.Image;
import org.openstack.model.compute.ImageList;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "images")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaImageList implements Serializable, ImageList {

	@XmlElement(name = "image")
	@SerializedName("images")
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

}
