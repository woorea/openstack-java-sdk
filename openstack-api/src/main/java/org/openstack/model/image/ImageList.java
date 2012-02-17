package org.openstack.model.image;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.common.PagingListBase;

@XmlRootElement(name = "images")
@XmlAccessorType(XmlAccessType.NONE)
public class ImageList extends PagingListBase<Image> {

    @XmlElementWrapper(name = "images")
    @XmlElement(name = "image")
    public List<Image> images = new ArrayList<Image>();

    @Override
    public Iterator<Image> iterateItemsOnPage() {
        return images.iterator();
    }

}
