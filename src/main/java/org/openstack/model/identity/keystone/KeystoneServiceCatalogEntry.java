package org.openstack.model.identity.keystone;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.openstack.model.identity.ServiceEndpoint;

import com.google.gson.annotations.SerializedName;

public class KeystoneServiceCatalogEntry implements Serializable, ServiceCatalogEntry {

	@XmlAttribute
    private String name;

    @XmlAttribute
    private String type;
    
	@SerializedName("endpoints")
	@XmlElement(nillable = true, name = "endpoint", type = KeystoneServiceEndpoint.class)
	private List<KeystoneServiceEndpoint> endpoints;

	// Not sure what these are...
	@SerializedName("endpoints_links")
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

	public void setEndpoints(List<KeystoneServiceEndpoint> endpoints) {
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
