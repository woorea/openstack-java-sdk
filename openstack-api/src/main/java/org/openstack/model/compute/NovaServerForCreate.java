package org.openstack.model.compute;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import org.openstack.model.common.JsonRootElement;

import com.google.common.collect.Lists;

@XmlRootElement(name = "server")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootElement("server")
public class NovaServerForCreate implements Serializable {

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
		public String path;

		@XmlValue
		public String contents;

	}

	@XmlAttribute
	private String name;

	@XmlAttribute
	private String imageRef;

	@XmlAttribute
	private String flavorRef;

	@XmlAttribute(name = "accessIPv4")
	private String accessIpV4;

	@XmlAttribute(name = "accessIPv6")
	private String accessIpV6;

	@XmlAttribute
	private String zone;

	// OSAPI-BUG: I think this is only valid in JSON
	@XmlAttribute(name="key_name")
	private String keyName;

	// We have a problem here - config_drive can be both a boolean and an image ref...
	// But booleans can't be quoted!
	@XmlAttribute(name="config_drive")
	private boolean configDrive;

	@XmlElement
	private NovaMetadata metadata;

	@XmlElementWrapper(name = "personality")
	@XmlElement(name="file")
	private List<File> personality;

	/**
	 * This security groups are not created on the fly. They must be exist in
	 * the tenant.
	 */
	@XmlElementWrapper(name = "security_groups")
	@XmlElement(name = "security_group")
	private List<SecurityGroup> securityGroups;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageRef() {
		return imageRef;
	}

	public void setImageRef(String imageRef) {
		this.imageRef = imageRef;
	}

	public String getFlavorRef() {
		return flavorRef;
	}

	public void setFlavorRef(String flavorRef) {
		this.flavorRef = flavorRef;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
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

	public NovaMetadata getMetadata() {
		if (metadata == null) {
			metadata = new NovaMetadata();
		}
		return metadata;
	}

	public void setMetadata(NovaMetadata metadata) {
		this.metadata = metadata;
	}

	public List<File> getPersonality() {
		if (personality == null) {
			personality = Lists.newArrayList();
		}
		return personality;
	}

	public void setPersonality(List<File> personality) {
		this.personality = personality;
	}

	public List<SecurityGroup> getSecurityGroups() {
		if (securityGroups == null) {
			securityGroups = Lists.newArrayList();
		}
		return securityGroups;
	}

	public void setSecurityGroups(List<SecurityGroup> securityGroups) {
		this.securityGroups = securityGroups;
	}

	public void addUploadFile(String path, String contents) {
		File item = new File();
		item.path = path;
		item.contents = contents;
		getPersonality().add(item);
	}

	//public void addUploadFile(String path, String contents) {
	//	addUploadFile(path, contents.getBytes(Charsets.UTF_8));
	//}

	@Override
	public String toString() {
		return "ServerForCreate [name=" + name + ", imageRef=" + imageRef
				+ ", flavorRef=" + flavorRef + ", accessIpV4=" + accessIpV4
				+ ", accessIpV6=" + accessIpV6 + ", zone=" + zone
				+ ", keyName=" + keyName + ", metadata=" + metadata
				+ ", personality=" + personality + ", securityGroups="
				+ securityGroups + "]";
	}

	public boolean getConfigDrive() {
		return configDrive;
	}

	public void setConfigDrive(boolean configDrive) {
		this.configDrive = configDrive;
	}

}
