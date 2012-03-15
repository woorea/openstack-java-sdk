package org.openstack.model.compute;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.PagingListBase;

@XmlRootElement(name = "flavors")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaFlavorList extends PagingListBase<NovaFlavor> {

    @XmlElement(name = "flavor")
    private List<NovaFlavor> list = new ArrayList<NovaFlavor>();

    @Override
    public Iterator<NovaFlavor> iterateItemsOnPage() {
        return list.iterator();
    }
    
    public List<NovaFlavor> getList() {
    	return list;
    }

	public void setList(List<NovaFlavor> list) {
		this.list = list;
		
	}
}
