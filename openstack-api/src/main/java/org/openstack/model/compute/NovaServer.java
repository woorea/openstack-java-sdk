package org.openstack.model.compute;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openstack.model.atom.Link;

@XmlRootElement(name = "server")
@XmlAccessorType(XmlAccessType.NONE)
public class NovaServer implements Serializable {

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String name;

	@XmlAttribute
	private String status;

	@XmlAttribute
	private Date updated;

	@XmlAttribute
	private Date created;

	@XmlAttribute
	private String hostId;

	@XmlAttribute
	@JsonProperty("user_id")
	private String userId;

	@XmlAttribute
	@JsonProperty("tenant_id")
	private String tenantId;

	@XmlAttribute(name = "accessIPv4")
	private String accessIpV4;

	@XmlAttribute(name = "accessIPv6")
	private String accessIpV6;
	
	@XmlAnyAttribute
	private Map<QName, String> extensionAttributes;

	@XmlAttribute
	private String adminPass;

	@XmlAttribute()
	private String progress;

	@XmlAttribute(name = "config_drive")
	private String configDrive;

	@XmlAttribute(name = "key_name")
	private String keyName;

	@XmlElement(name = "image")
	private NovaImage image;

	@XmlElement(name = "flavor")
	private NovaFlavor flavor;

	@XmlElement(name = "fault")
	private NovaFault fault;

	@XmlElement(name = "metadata")
	private NovaMetadata metadata;

	@XmlElement(name = "addresses")
	private NovaAddresses addresses;

	@XmlElement(name = "link", namespace = "http://www.w3.org/2005/Atom")
	@JsonProperty("links")
	private List<Link> links;

	@XmlAttribute
	private String uuid;
	
	public NovaServer() {
		// TODO Auto-generated constructor stub
	}

	public NovaServer(String id, String name) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public String getAccessIpV4() {
		return accessIpV4;
	}

	public void setAccessIpV4(String accessIpV4) {
		this.accessIpV4 = accessIpV4;
	}

	public String getAccessIpV6() {
		return accessIpV6;
	}

	public void setAccessIpV6(String accessIpV6) {
		this.accessIpV6 = accessIpV6;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getConfigDrive() {
		return configDrive;
	}

	public void setConfigDrive(String configDrive) {
		this.configDrive = configDrive;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public NovaImage getImage() {
		return image;
	}

	public String getImageId() {
		if (image != null) {
			return image.getId();
		}
		return null;
	}

	public void setImage(NovaImage image) {
		this.image = image;
	}

	public NovaFlavor getFlavor() {
		return flavor;
	}

	public void setFlavor(NovaFlavor flavor) {
		this.flavor = flavor;
	}

	public NovaFault getFault() {
		return fault;
	}

	public void setFault(NovaFault fault) {
		this.fault = fault;
	}

	public NovaMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(NovaMetadata metadata) {
		this.metadata = metadata;
	}

	public NovaAddresses getAddresses() {
		return addresses;
	}

	public void setAddresses(NovaAddresses addresses) {
		this.addresses = addresses;
	}
	
	
	public Map<QName, String> getExtensionAttributes() {
		return extensionAttributes;
	}

	public void setExtensionAttributes(Map<QName, String> extensionAttributes) {
		this.extensionAttributes = extensionAttributes;
	}

	/*
	@XmlAnyAttribute
	public Map<QName, String> getExtensionAttributes() {
		Map<QName, String> transform = new HashMap<QName, String>();
		for(Map.Entry<String, String> entry : extensionAttributes.entrySet()) {
			
		}
		return transform;
	}

	public void setExtensionAttributes(Map<QName, String> extensionAttributes) {
		Map<String, String> transform = new HashMap<String, String>();
		for(Map.Entry<QName, String> entry : extensionAttributes.entrySet()) {
			
		}
		this.extensionAttributes = transform;
	}
	*/
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Link> getLinks() {
		return links;
	}

	public void setLinks(List<Link> links) {
		this.links = links;
	}

	@Override
	public String toString() {
		return "Server [id=" + id + ", name=" + name + ", status=" + status + ", updated=" + updated + ", created="
				+ created + ", hostId=" + hostId + ", userId=" + userId + ", tenantId=" + tenantId + ", accessIpV4="
				+ accessIpV4 + ", accessIpV6=" + accessIpV6 + ", adminPass=" + adminPass + ", progress=" + progress
				+ ", configDrive=" + configDrive + ", keyName=" + keyName + ", image=" + image + ", flavor=" + flavor
				+ ", fault=" + fault + ", metadata=" + metadata + ", addresses=" + addresses + ", links=" + links + "]";
	}

}
