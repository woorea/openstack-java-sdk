package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "images")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaImageList implements Serializable {

	@XmlElement(name = "image")
	@SerializedName("images")
	private List<NovaImage> list = new ArrayList<NovaImage>();

	public List<NovaImage> getList() {
		return list;
	}

	public void setList(List<NovaImage> list) {
		this.list = list;
		
	}
	
	@Override
	public String toString() {
		return "NovaImageList [list=" + list + "]";
	}

}
