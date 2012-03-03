package org.openstack.model.identity.keystone;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.model.identity.Service;
import org.openstack.model.identity.ServiceEndpoint;

import com.google.common.collect.Lists;

@XmlRootElement(name = "service")
@XmlAccessorType(XmlAccessType.NONE)
public class KeyStoneService implements Service {

	@JsonProperty("endpoints")
	@XmlElement(nillable = true, name = "endpoint", namespace="http://docs.openstack.org/identity/api/v2.0", type = KeyStoneServiceEndpoint.class)
	private List<ServiceEndpoint> endpoints;

	// Not sure what these are...
	@JsonProperty("endpoints_links")
	private List<String> endpointsLinks;

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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#setId(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#setName(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#setType(java.lang.String)
	 */
    @Override
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

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#setDescription(java.lang.String)
	 */
    @Override
	public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Service [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description + ", endpoints=" + endpoints + "]";
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.Service#getEndpoints()
	 */
    @Override
	public List<ServiceEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = Lists.newArrayList();
        }
        return endpoints;
    }

}
