package org.openstack.model.compute.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Personality implements Serializable {

    @XmlAccessorType(XmlAccessType.NONE)
    public static final class File {

        @XmlAttribute
        public String path;

        @XmlValue
        public byte[] contents;

    }

    @XmlElement(name = "file")
    public List<File> files = new ArrayList<File>();

}
