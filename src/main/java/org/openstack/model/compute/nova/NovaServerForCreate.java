package org.openstack.model.compute.nova;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.ServerForCreate;

import com.google.common.collect.Lists;

@XmlRootElement(name = "server")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("server")
public class NovaServerForCreate implements Serializable, ServerForCreate {

	@XmlType
	@XmlAccessorType(XmlAccessType.NONE)
	public static final class SecurityGroup implements Serializable {

		@XmlElement(name = "name")
		private String name;

		public SecurityGroup() {

		}

		public SecurityGroup(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "CreateSecurityGroupRequest [name=" + name + "]";
		}

	}

	@XmlType
	@XmlAccessorType(XmlAccessType.NONE)
	public static final class File implements Serializable {

		@XmlAttribute
		private String path;

		@XmlValue
		private String contents;

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public String getContents() {
			return contents;
		}

		public void setContents(String contents) {
			this.contents = contents;
		}

	}

	@XmlAttribute
	private String name;
	
	@XmlAttribute
	private Integer min;
	
	@XmlAttribute
	private Integer max;

	@XmlAttribute
	private String imageRef;

	@XmlAttribute
	private String flavorRef;

	@XmlAttribute
	private String accessIPv4;

	@XmlAttribute
	private String accessIPv6;

	@XmlAttribute
	private String zone;

	@XmlAttribute(name="key_name")
	@JsonProperty("key_name")
	private String keyName;

	// We have a problem here - config_drive can be both a boolean and an image ref...
	// But booleans can't be quoted!
	@XmlAttribute(name="config_drive")
	@JsonProperty("config_drive")
	private boolean configDrive;

	@XmlElementWrapper(name="metatadata")
	@XmlElement(name="meta")
	//private List<NovaMetadata.Item> metadata;
	private Map<String, String> metadata = new HashMap<String, String>();

	@XmlElementWrapper(name = "personality")
	@XmlElement(name="file")
	private List<File> personality = new ArrayList<NovaServerForCreate.File>();

	/**
	 * This security groups are not created on the fly. They must be exist in
	 * the tenant.
	 */
	@XmlElementWrapper(name = "security_groups")
	@XmlElement(name = "security_group")
	private List<SecurityGroup> securityGroups = new ArrayList<NovaServerForCreate.SecurityGroup>();

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getMin()
	 */
	@Override
	public Integer getMin() {
		return min;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setMin(java.lang.Integer)
	 */
	@Override
	public void setMin(Integer min) {
		this.min = min;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getMax()
	 */
	@Override
	public Integer getMax() {
		return max;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setMax(java.lang.Integer)
	 */
	@Override
	public void setMax(Integer max) {
		this.max = max;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getImageRef()
	 */
	@Override
	public String getImageRef() {
		return imageRef;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setImageRef(java.lang.String)
	 */
	@Override
	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getFlavorRef()
	 */
	@Override
	public String getFlavorRef() {
		return flavorRef;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setFlavorRef(java.lang.String)
	 */
	@Override
	public void setFlavorRef(String flavorRef) {
		this.flavorRef = flavorRef;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getZone()
	 */
	@Override
	public String getZone() {
		return zone;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setZone(java.lang.String)
	 */
	@Override
	public void setZone(String zone) {
		this.zone = zone;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getKeyName()
	 */
	@Override
	public String getKeyName() {
		return keyName;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setKeyName(java.lang.String)
	 */
	@Override
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getAccessIPv4()
	 */
	@Override
	public String getAccessIPv4() {
		return accessIPv4;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setAccessIPv4(java.lang.String)
	 */
	@Override
	public void setAccessIPv4(String accessIPv4) {
		this.accessIPv4 = accessIPv4;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getAccessIPv6()
	 */
	@Override
	public String getAccessIPv6() {
		return accessIPv6;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setAccessIpV6(java.lang.String)
	 */
	@Override
	public void setAccessIPv6(String accessIPv6) {
		this.accessIPv6 = accessIPv6;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getMetadata()
	 */
	@Override
	public Map<String, String> getMetadata() {
		return metadata;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setMetadata(java.util.List)
	 */
	@Override
	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getPersonality()
	 */
	@Override
	public List<File> getPersonality() {
		if (personality == null) {
			personality = Lists.newArrayList();
		}
		return personality;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setPersonality(java.util.List)
	 */
	@Override
	public void setPersonality(List<File> personality) {
		this.personality = personality;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getSecurityGroups()
	 */
	@Override
	public List<SecurityGroup> getSecurityGroups() {
		if (securityGroups == null) {
			securityGroups = Lists.newArrayList();
		}
		return securityGroups;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setSecurityGroups(java.util.List)
	 */
	@Override
	public void setSecurityGroups(List<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#addUploadFile(java.lang.String, java.lang.String)
	 */
	@Override
	public void addUploadFile(String path, String contents) {
		File item = new File();
		item.path = path;
		item.contents = contents;
		getPersonality().add(item);
	}

	//public void addUploadFile(String path, String contents) {
	//	addUploadFile(path, contents.getBytes(Charsets.UTF_8));
	//}

	

	

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#getConfigDrive()
	 */
	@Override
	public boolean getConfigDrive() {
		return configDrive;
	}

	/* (non-Javadoc)
	 * @see org.openstack.model.compute.nova.ServerForCreate#setConfigDrive(boolean)
	 */
	@Override
	public void setConfigDrive(boolean configDrive) {
		this.configDrive = configDrive;
	}

	@Override
	public String toString() {
		return "NovaServerForCreate [name=" + name + ", min=" + min + ", max="
				+ max + ", imageRef=" + imageRef + ", flavorRef=" + flavorRef
				+ ", accessIpV4=" + accessIPv4 + ", accessIpV6=" + accessIPv6
				+ ", zone=" + zone + ", keyName=" + keyName + ", configDrive="
				+ configDrive + ", metadata=" + metadata + ", personality="
				+ personality + ", securityGroups=" + securityGroups + "]";
	}

}
