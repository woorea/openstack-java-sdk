package org.openstack.model.compute;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

import org.openstack.model.atom.Link;
import org.openstack.model.common.JsonRootElement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.gson.annotations.SerializedName;

@XmlRootElement(name="flavor")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("flavor")
public class NovaFlavor implements Serializable {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int ram;

    @XmlAttribute
    private int vcpus;

    @XmlAttribute
    private String swap;

    @XmlAttribute(name = "rxtx_factor")
    @SerializedName("rxtx_factor")
    private float rxTxFactor;

    @XmlAttribute
    private int disk;
    
    @XmlAnyAttribute
    private Map<QName, Object> extensionAttributes;

    @XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
	private List<Link> links;
    
    public NovaFlavor() {
    	
    }

    public NovaFlavor(String id, String name) {
		this.id = id;
		this.name = name;
	}

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

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getVcpus() {
        return vcpus;
    }

    public void setVcpus(int vcpus) {
        this.vcpus = vcpus;
    }

    public float getRxTxFactor() {
        return rxTxFactor;
    }

    public void setRxTxFactor(float rxTxFactor) {
        this.rxTxFactor = rxTxFactor;
    }

    public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public String getSwap() {
		return swap;
	}

	public void setSwap(String swap) {
		this.swap = swap;
	}

	public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
    
    @Override
	public String toString() {
		return "NovaFlavor [id=" + id + ", name=" + name + ", ram=" + ram
				+ ", vcpus=" + vcpus + ", swap=" + swap + ", rxTxFactor="
				+ rxTxFactor + ", disk=" + disk + ", links=" + links + "]";
	}

	public Link getLink(final String rel) {
		return Iterables.find(links, new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				return rel.equals(link.getRel());
			}
		});
	}

}
