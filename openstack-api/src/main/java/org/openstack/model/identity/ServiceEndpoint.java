package org.openstack.model.identity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.NONE)
public class ServiceEndpoint {

    @XmlAttribute
    public String region;

    @XmlAttribute
    public String tenantId;

    @XmlAttribute
    public String internalURL;

    @XmlAttribute
    public String publicURL;

    // @XmlElement
    // public ServiceVersion version;

}
