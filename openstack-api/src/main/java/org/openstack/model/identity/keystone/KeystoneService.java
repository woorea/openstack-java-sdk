package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.api.Namespaces;
import org.openstack.model.common.JsonRootElement;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceEndpoint;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name="service", namespace=Namespaces.NS_OPENSTACK_IDENTITY_ADM_1_0)
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("OS-KSADM:service")
public class KeystoneService implements Serializable, Service {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String type;

    @XmlElement
    private String description;

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#getId()
	 */
    @Override
	public String getId() {
        return id;
    }

	public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#getName()
	 */
    @Override
	public String getName() {
        return name;
    }

	public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#getType()
	 */
    @Override
	public String getType() {
        return type;
    }
    
	public void setType(String type) {
        this.type = type;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#getDescription()
	 */
    @Override
	public String getDescription() {
        return description;
    }

	public void setDescription(String description) {
        this.description = description;
    }
	    
    

}
