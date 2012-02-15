package org.openstack.model.compute.extensions.diskconfig;

import javax.xml.bind.annotation.XmlAttribute;

public class DiskConfigAttributes {
    @XmlAttribute
    public String diskConfig;

    @Override
    public String toString() {
        return "DiskConfigAttributes [diskConfig=" + diskConfig + "]";
    }

}
