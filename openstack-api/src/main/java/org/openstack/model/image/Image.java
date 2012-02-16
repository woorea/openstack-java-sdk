package org.openstack.model.image;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
public class Image {
    @XmlAttribute
    private String uri;
    @XmlAttribute
    private String name;
    @XmlAttribute(name = "disk_format")
    private String diskFormat;
    @XmlAttribute(name = "container_format")
    private String containerFormat;
    @XmlAttribute
    private Long size;
    @XmlAttribute
    private String checksum;
    @XmlAttribute(name = "created_at")
    private Date createdAt;
    @XmlAttribute(name = "updated_at")
    private Date updatedAt;
    @XmlAttribute(name = "deleted_at")
    private Date deletedAt;
    @XmlAttribute
    private String status;
    @XmlAttribute(name = "is_public")
    private Boolean isPublic;
    @XmlAttribute(name = "min_ram")
    private Integer minRam;
    @XmlAttribute(name = "min_disk")
    private Integer minDisk;
    @XmlAttribute
    private String owner;
    @XmlAttribute
    private Boolean deleted;
    @XmlAttribute(name = "protected")
    private Boolean isProtected;
    @XmlAttribute
    private String id;

    @XmlElement
    private ImageProperties properties;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiskFormat() {
        return diskFormat;
    }

    public void setDiskFormat(String diskFormat) {
        this.diskFormat = diskFormat;
    }

    public String getContainerFormat() {
        return containerFormat;
    }

    public void setContainerFormat(String containerFormat) {
        this.containerFormat = containerFormat;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean isPublic() {
        return isPublic;
    }

    public void setPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Integer getMinRam() {
        return minRam;
    }

    public void setMinRam(Integer minRam) {
        this.minRam = minRam;
    }

    public Integer getMinDisk() {
        return minDisk;
    }

    public void setMinDisk(Integer minDisk) {
        this.minDisk = minDisk;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean isProtected() {
        return isProtected;
    }

    public void setProtected(Boolean isProtected) {
        this.isProtected = isProtected;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ImageProperties getProperties() {
        if (properties == null) {
            properties = new ImageProperties();
        }
        return properties;
    }

    public void setProperties(ImageProperties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "Image [uri=" + uri + ", name=" + name + ", diskFormat=" + diskFormat + ", containerFormat=" + containerFormat + ", size=" + size + ", checksum=" + checksum + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", status=" + status + ", isPublic=" + isPublic + ", minRam=" + minRam + ", minDisk=" + minDisk + ", owner="
                + owner + ", deleted=" + deleted + ", isProtected=" + isProtected + ", id=" + id + ", properties=" + properties + "]";
    }

}
