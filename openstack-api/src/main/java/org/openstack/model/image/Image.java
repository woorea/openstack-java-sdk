package org.openstack.model.image;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Image {
    @XmlAttribute
    public String uri;
    @XmlAttribute
    public String name;
    @XmlAttribute(name = "disk_format")
    public String diskFormat;
    @XmlAttribute(name = "container_format")
    public String containerFormat;
    @XmlAttribute
    public long size;
    @XmlAttribute
    public String checksum;
    @XmlAttribute(name = "created_at")
    public Date createdAt;
    @XmlAttribute(name = "updated_at")
    public Date updatedAt;
    @XmlAttribute(name = "deleted_at")
    public Date deletedAt;
    @XmlAttribute
    public String status;
    @XmlAttribute(name = "is_public")
    public boolean isPublic;
    @XmlAttribute(name = "min_ram")
    public int minRam;
    @XmlAttribute(name = "min_disk")
    public int minDisk;
    @XmlAttribute
    public String owner;
    @XmlAttribute
    public boolean deleted;
    @XmlAttribute(name = "protected")
    public boolean isProtected;
    @XmlAttribute
    public String id;

    @XmlElement
    public ImageProperties properties;
}
