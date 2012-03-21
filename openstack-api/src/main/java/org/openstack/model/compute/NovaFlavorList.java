package org.openstack.model.compute;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "flavors")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaFlavorList implements Serializable {

    @XmlElement(name = "flavor")
    @SerializedName("flavors")
    private List<NovaFlavor> list = new ArrayList<NovaFlavor>();
    
    public List<NovaFlavor> getList() {
    	return list;
    }

	public void setList(List<NovaFlavor> list) {
		this.list = list;
		
	}

	@Override
	public String toString() {
		return "NovaFlavorList [list=" + list + "]";
	}
}
