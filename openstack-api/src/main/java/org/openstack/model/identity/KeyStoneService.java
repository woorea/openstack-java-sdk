package org.openstack.model.identity;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.api.Namespaces;
import org.openstack.model.common.JsonRootElement;

import com.google.common.collect.Lists;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name="service", namespace=Namespaces.NS_OPENSTACK_IDENTITY_ADM_1_0)
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("OS-KSADM:service")
public class KeyStoneService implements Serializable {

	@SerializedName("endpoints")
	@XmlElement(nillable = true, name = "endpoint")
	private List<KeyStoneServiceEndpoint> endpoints;

	// Not sure what these are...
	@SerializedName("endpoints_links")
	private List<String> endpointsLinks;

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private String type;

    @XmlElement
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<KeyStoneServiceEndpoint> getEndpoints() {
        if (endpoints == null) {
            endpoints = Lists.newArrayList();
        }
        return endpoints;
    }

	@Override
	public String toString() {
		return "KeyStoneService [endpoints=" + endpoints + ", endpointsLinks="
				+ endpointsLinks + ", id=" + id + ", name=" + name + ", type="
				+ type + ", description=" + description + "]";
	}
    
    

}
