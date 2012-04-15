package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.JsonRootElement;
import org.openstack.model.compute.Flavor;
import org.openstack.model.compute.FlavorList;

import com.google.gson.annotations.SerializedName;

@XmlRootElement(name = "flavors")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement()
public class NovaFlavorList implements Serializable, FlavorList {

    @XmlElement(name = "flavor")
    @SerializedName("flavors")
    private List<NovaFlavor> list = new ArrayList<NovaFlavor>();
    
    public NovaFlavorList() {
    	this.list = new ArrayList<NovaFlavor>();
    }
    
    public NovaFlavorList(Collection<NovaFlavor> collection) {
		this.list = new ArrayList<NovaFlavor>();
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.FlavorList#getList()
	 */
    @Override
	public List<Flavor> getList() {
    	return (List<Flavor>) (List<?>) list;
    }

	public void setList(List<NovaFlavor> list) {
		this.list = list;
		
	}

	@Override
	public String toString() {
		return "NovaFlavorList [list=" + list + "]";
	}

	@Override
	public Iterator<Flavor> iterator() {
		return getList().iterator();
	}
}
