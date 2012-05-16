package org.openstack.model.images.glance;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.images.Image;

import com.google.common.collect.Maps;

@JsonRootName("image")
public class GlanceImage implements Serializable, Image {
	
	
    private String uri;

    @JsonProperty("name")
    private String name;
    
    @JsonProperty("disk_format")
    private String diskFormat;

    @JsonProperty("container_format")
    private String containerFormat;

    @JsonProperty("size")
    private Long size;

    @JsonProperty("checksum")
    private String checksum;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("deleted_at")
    private Date deletedAt;

    @JsonProperty("status")
    private String status;
 
    @JsonProperty("is_public")
    private Boolean isPublic;

    @JsonProperty("min_ram")
    private Integer minRam;

    @JsonProperty("min_disk")
    private Integer minDisk;

    @JsonProperty("owner")
    private String owner;

    @JsonProperty("deleted")
    private Boolean deleted;
    
    @JsonProperty("protected")
    private Boolean isProtected;

    @JsonProperty("id")
    private String id;
   
    final Map<String, Object> properties = Maps.newHashMap();
    
    public GlanceImage() {
    	
    }
    
    public GlanceImage(String id, String name) {
    	this.id = id;
    	this.name = name;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getUri()
	 */
    @Override
	public String getUri() {
        return uri;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setUri(java.lang.String)
	 */
    @Override
	public void setUri(String uri) {
        this.uri = uri;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getName()
	 */
    @Override
	public String getName() {
        return name;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setName(java.lang.String)
	 */
    @Override
	public void setName(String name) {
        this.name = name;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getDiskFormat()
	 */
    @Override
	public String getDiskFormat() {
        return diskFormat;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setDiskFormat(java.lang.String)
	 */
    @Override
	public void setDiskFormat(String diskFormat) {
        this.diskFormat = diskFormat;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getContainerFormat()
	 */
    @Override
	public String getContainerFormat() {
        return containerFormat;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setContainerFormat(java.lang.String)
	 */
    @Override
	public void setContainerFormat(String containerFormat) {
        this.containerFormat = containerFormat;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getSize()
	 */
    @Override
	public Long getSize() {
        return size;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setSize(java.lang.Long)
	 */
    @Override
	public void setSize(Long size) {
        this.size = size;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getChecksum()
	 */
    @Override
	public String getChecksum() {
        return checksum;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setChecksum(java.lang.String)
	 */
    @Override
	public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getCreatedAt()
	 */
    @Override
	public String getCreatedAt() {
        return createdAt;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setCreatedAt(java.lang.String)
	 */
    @Override
	public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getUpdatedAt()
	 */
    @Override
	public String getUpdatedAt() {
        return updatedAt;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setUpdatedAt(java.lang.String)
	 */
    @Override
	public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getDeletedAt()
	 */
    @Override
	public Date getDeletedAt() {
        return deletedAt;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setDeletedAt(java.util.Date)
	 */
    @Override
	public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getStatus()
	 */
    @Override
	public String getStatus() {
        return status;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setStatus(java.lang.String)
	 */
    @Override
	public void setStatus(String status) {
        this.status = status;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#isPublic()
	 */
    @Override
	public Boolean isPublic() {
        return isPublic;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setPublic(java.lang.Boolean)
	 */
    @Override
	public void setPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getMinRam()
	 */
    @Override
	public Integer getMinRam() {
        return minRam;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setMinRam(java.lang.Integer)
	 */
    @Override
	public void setMinRam(Integer minRam) {
        this.minRam = minRam;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getMinDisk()
	 */
    @Override
	public Integer getMinDisk() {
        return minDisk;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setMinDisk(java.lang.Integer)
	 */
    @Override
	public void setMinDisk(Integer minDisk) {
        this.minDisk = minDisk;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getOwner()
	 */
    @Override
	public String getOwner() {
        return owner;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setOwner(java.lang.String)
	 */
    @Override
	public void setOwner(String owner) {
        this.owner = owner;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#isDeleted()
	 */
    @Override
	public Boolean isDeleted() {
        return deleted;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setDeleted(java.lang.Boolean)
	 */
    @Override
	public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#isProtected()
	 */
    @Override
	public Boolean isProtected() {
        return isProtected;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setProtected(java.lang.Boolean)
	 */
    @Override
	public void setProtected(Boolean isProtected) {
        this.isProtected = isProtected;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getId()
	 */
    @Override
	public String getId() {
        return id;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#setId(java.lang.String)
	 */
    @Override
	public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see org.openstack.model.image.glance.Image#getProperties()
	 */
    @Override
	public Map<String, Object> getProperties() {
		return properties;
	}

	@Override
    public String toString() {
        return "Image [uri=" + uri + ", name=" + name + ", diskFormat=" + diskFormat + ", containerFormat=" + containerFormat + ", size=" + size + ", checksum=" + checksum + ", createdAt="
                + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + ", status=" + status + ", isPublic=" + isPublic + ", minRam=" + minRam + ", minDisk=" + minDisk + ", owner="
                + owner + ", deleted=" + deleted + ", isProtected=" + isProtected + ", id=" + id + ", properties=" + properties + "]";
    }


}
