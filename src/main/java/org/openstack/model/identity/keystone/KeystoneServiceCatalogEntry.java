package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.openstack.model.identity.ServiceCatalogEntry;
import org.openstack.model.identity.ServiceEndpoint;

public class KeystoneServiceCatalogEntry implements Serializable, ServiceCatalogEntry {

	@XmlAttribute
    private String name;

    @XmlAttribute
    private String type;
    
	
	@XmlElement(nillable = true, name = "endpoint", type = KeystoneServiceEndpoint.class)
	@JsonProperty("endpoints")
	@JsonDeserialize(as=List.class, contentAs=KeystoneServiceEndpoint.class)
	private List<ServiceEndpoint> endpoints;

	@JsonProperty("endpoints_links")
	private List<String> endpointsLinks;

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceCatalogEntry#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceCatalogEntry#getType()
	 */
	@Override
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceCatalogEntry#getEndpoints()
	 */
	@Override
	public List<ServiceEndpoint> getEndpoints() {
		return (List<ServiceEndpoint>) (List<?>) endpoints;
	}

	public void setEndpoints(List<ServiceEndpoint> endpoints) {
		this.endpoints = endpoints;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.identity.keystone.ServiceCatalogEntry#getEndpointsLinks()
	 */
	@Override
	public List<String> getEndpointsLinks() {
		return endpointsLinks;
	}

	public void setEndpointsLinks(List<String> endpointsLinks) {
		this.endpointsLinks = endpointsLinks;
	}
	
}
