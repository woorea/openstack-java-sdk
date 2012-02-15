package org.openstack.model.compute;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.openstack.model.atom.Link;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Flavor implements Serializable {

    @XmlAttribute
    private String id;

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int ram;

    @XmlAttribute
    private int vcpus;

    @XmlAttribute
    public Integer swap;

    @XmlAttribute(name = "rxtx_factor")
    private float rxTxFactor;

    @XmlAttribute
    private int disk;

    @XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
    private List<Link> links;

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

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "Flavor [id=" + id + ", name=" + name + ", ram=" + ram + ", vcpus=" + vcpus + ", rxtxFactor=" + rxTxFactor + ", disk=" + disk + ", links=" + links + "]";
    }

}
