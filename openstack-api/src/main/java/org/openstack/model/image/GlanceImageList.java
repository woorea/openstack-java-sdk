package org.openstack.model.image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "images")
@XmlAccessorType(XmlAccessType.NONE)
public class GlanceImageList implements Serializable {

    @XmlElementWrapper(name = "images")
    @XmlElement(name = "image")
    public List<GlanceImage> images = new ArrayList<GlanceImage>();
    
    public List<GlanceImage> getList() {
    	return images;
    }
    
}
