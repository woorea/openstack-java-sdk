package org.openstack.model.compute.nova.volume;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.openstack.model.compute.Volume;


@XmlRootElement(name = "volume", namespace="")
@XmlAccessorType(XmlAccessType.NONE)
@JsonRootName("volume")
public class NovaVolume implements Serializable, Volume {
	
	@XmlAttribute
	@JsonProperty
	private String id;
	
	@XmlAttribute
	@JsonProperty
	private String status;

	@XmlAttribute(name="size")
	@JsonProperty("size")
	private Integer sizeInGB;
	
	@XmlAttribute(name="availabilityZone")
	@JsonProperty
	private String availabilityZone;
	
	@XmlAttribute(name="volumeType")
	@JsonProperty("volumeType")
	private String type;
	
	@XmlAttribute(name="createdAt")
	@JsonProperty("createdAt")
	private String created;
	
	@XmlAttribute(name="displayName")
	@JsonProperty("displayName")
	private String name;
	
	@XmlAttribute(name="displayDescription")
	@JsonProperty("displayDescription")
	private String description;
	
	@XmlAttribute(name="snapshotId")
	@JsonProperty
	private Integer snapshotId;
	
	@XmlElement(name="metadata")
	@JsonProperty
	private Map<String, String> metadata;
	
	@JsonProperty
	private List<String> attachments;
	
	public NovaVolume() {
		
	}
	
	public NovaVolume(String id, String name, Integer snapshotId) {
		this.id = id;
		this.name = name;
		this.snapshotId = snapshotId;
	}

	public String getId() {
		return id;
	}

	public String getStatus() {
		return status;
	}

	public Integer getSizeInGB() {
		return sizeInGB;
	}

	public String getAvailabilityZone() {
		return availabilityZone;
	}

	public String getType() {
		return type;
	}

	public String getCreated() {
		return created;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Integer getSnapshotId() {
		return snapshotId;
	}

	public Map<String, String> getMetadata() {
		return metadata;
	}

	public List<String> getAttachments() {
		return attachments;
	}

}
