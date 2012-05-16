package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.atom.Link;
import org.openstack.model.compute.Flavor;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

@XmlRootElement(name="flavor")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("flavor")
public class NovaFlavor implements Serializable, Flavor {

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
    @JsonProperty("rxtx_factor")
    private float rxTxFactor;

    @XmlAttribute
    private int disk;
    
    @JsonProperty("OS-FLV-EXT-DATA:ephemeral")
    private int ephemeralGb;
    
    private Map<String, String> extensions = new HashMap<String, String>();

    @XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
	private List<Link> links;
    
    public NovaFlavor() {
    	
    }

    public NovaFlavor(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getId()
	 */
	@Override
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getName()
	 */
    @Override
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getRam()
	 */
    @Override
	public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getVcpus()
	 */
    @Override
	public int getVcpus() {
        return vcpus;
    }

    public void setVcpus(int vcpus) {
        this.vcpus = vcpus;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getRxTxFactor()
	 */
    @Override
	public float getRxTxFactor() {
        return rxTxFactor;
    }

    public void setRxTxFactor(float rxTxFactor) {
        this.rxTxFactor = rxTxFactor;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getDisk()
	 */
    @Override
	public int getDisk() {
        return disk;
    }

    public void setDisk(int disk) {
        this.disk = disk;
    }

    public int getEphemeralGb() {
		return ephemeralGb;
	}

	public void setEphemeralGb(int ephemeralGb) {
		this.ephemeralGb = ephemeralGb;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getSwap()
	 */
    @Override
	public String getSwap() {
		return swap;
	}

	public void setSwap(String swap) {
		this.swap = swap;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getLinks()
	 */
	@Override
	public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

	@JsonAnyGetter
	public Map<String, String> getExtensions() {
		return extensions;
	}

	@JsonAnySetter 
	public void put(String key, String value) {
	      extensions.put(key, value);
	}
    
    @Override
	public String toString() {
		return "NovaFlavor [id=" + id + ", name=" + name + ", ram=" + ram
				+ ", vcpus=" + vcpus + ", swap=" + swap + ", rxTxFactor="
				+ rxTxFactor + ", disk=" + disk + ", links=" + links + "]";
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.Flavor#getLink(java.lang.String)
	 */
	@Override
	public Link getLink(final String rel) {
		return Iterables.find(links, new Predicate<Link>() {

			@Override
			public boolean apply(Link link) {
				return rel.equals(link.getRel());
			}
		});
	}

}
