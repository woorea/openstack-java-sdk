package org.openstack.model.image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.ListWithAtomLinks;
import org.openstack.model.common.PagingListBase;

@XmlRootElement(name = "images")
@XmlAccessorType(XmlAccessType.NONE)
public class ImageList extends PagingListBase<Image> {

    @XmlElement(name = "images")
    public List<Image> list = new ArrayList<Image>();

    public List<Image> getList() {
        return list;
    }

    public void setList(List<Image> list) {
        this.list = list;
    }

    @Override
    public Iterator<Image> iterateItemsOnPage() {
        return list.iterator();
    }

}
