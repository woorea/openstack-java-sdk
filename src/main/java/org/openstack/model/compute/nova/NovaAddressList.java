package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import org.openstack.model.compute.AddressList;

import com.google.common.collect.Lists;

@XmlAccessorType(XmlAccessType.NONE)
public class NovaAddressList implements Serializable, AddressList {

    @XmlAccessorType(XmlAccessType.NONE)
    public static class Network implements Serializable {

        @XmlAccessorType(XmlAccessType.NONE)
        public static class Ip implements Serializable {

            @XmlAttribute
            private String version;

            @XmlAttribute
            private String addr;
            
            public Ip() {
            	
            }
            
            public Ip(String version, String addr) {
            	this.version = version;
            	this.addr = addr;
            }

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public String getAddr() {
                return addr;
            }

            public void setAddr(String addr) {
                this.addr = addr;
            }

            @Override
            public String toString() {
                return "Ip [version=" + version + ", addr=" + addr + "]";
            }

        }

        @XmlAttribute
        private String id;

        @XmlElement(name = "ip")
        private List<Ip> ips;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Ip> getIps() {
        	if (ips == null) {
        		ips = Lists.newArrayList();
        	}
            return ips;
        }

        public void setIps(List<Ip> ips) {
            this.ips = ips;
        }

        @Override
        public String toString() {
            return "Network [id=" + id + ", ips=" + ips + "]";
        }

    }

    
    @XmlElement(name = "network")
    private List<Network> networks;

    @Override
    public String toString() {
        return "Addresses [networks=" + networks + "]";
    }

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.AddressList#getNetworks()
	 */
	@Override
	public List<Network> getNetworks() {
		if (networks == null) {
			networks = Lists.newArrayList();
		}
		return networks;
	}
}
