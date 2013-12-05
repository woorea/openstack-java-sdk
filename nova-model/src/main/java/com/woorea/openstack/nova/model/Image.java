package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("image")
public class Image implements Serializable {
	
	public static final class Server implements Serializable {
		
		private String id;
		
		private List<Link> links;
		
		/**
		 * @return the id
		 */
		public String getId() {
			return id;
		}
		
		/**
		 * @return the links
		 */
		public List<Link> getLinks() {
			return links;
		}
		
		@Override
		public String toString() {
			return "Server [id=" + id + ", links=" + links + "]";
		}
		
	}

	private String id;
	
	private String status;
	
	private String name;
	
	private Integer progress;
	
	private Integer minRam;
	
	private Integer minDisk;
	
	private Calendar created;
	
	private Calendar updated;
	
	@JsonProperty("OS-EXT-IMG-SIZE:size")
	private Long size;
	
	private Map<String, String> metadata;
	
	private Server server;
		
	private List<Link> links;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the progress
	 */
	public Integer getProgress() {
		return progress;
	}

	/**
	 * @param progress the progress to set
	 */
	public void setProgress(Integer progress) {
		this.progress = progress;
	}

	/**
	 * @return the minRam
	 */
	public Integer getMinRam() {
		return minRam;
	}

	/**
	 * @param minRam the minRam to set
	 */
	public void setMinRam(Integer minRam) {
		this.minRam = minRam;
	}

	/**
	 * @return the minDisk
	 */
	public Integer getMinDisk() {
		return minDisk;
	}

	/**
	 * @param minDisk the minDisk to set
	 */
	public void setMinDisk(Integer minDisk) {
		this.minDisk = minDisk;
	}

	/**
	 * @return the created
	 */
	public Calendar getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Calendar created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public Calendar getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}

	/**
	 * @return the metadata
	 */
	public Map<String, String> getMetadata() {
		return metadata;
	}

	/**
	 * @return the size
	 */
	public Long getSize() {
		return size;
	}

	/**
	 * @param metadata the metadata to set
	 */
	public void setMetadata(Map<String, String> metadata) {
		this.metadata = metadata;
	}
	
	/**
	 * @return the server
	 */
	public Server getServer() {
		return server;
	}

	/**
	 * @return the links
	 */
	public List<Link> getLinks() {
		return links;
	}

	/**
	 * @param links the links to set
	 */
	public void setLinks(List<Link> links) {
		this.links = links;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Image [id=" + id + ", status=" + status + ", name=" + name
				+ ", progress=" + progress + ", minRam=" + minRam
				+ ", minDisk=" + minDisk + ", created=" + (created != null ? created.getTime() : null)
				+ ", updated=" + (updated != null ? updated.getTime() : null) + ", size=" + size + ", metadata="
				+ metadata + ", server="+server+", links=" + links + "]";
	}
	
}
