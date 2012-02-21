package org.openstack.client.common;

import java.io.Serializable;

import javax.ws.rs.core.MediaType;

public class OpenStackComputeConfig implements Serializable {

	public enum Feature {

		VERBOSE(true);

		private boolean enabled;

		public boolean isEnabled() {
			return enabled;
		}

		public int mask() {
			return (1 << ordinal());
		}

		private Feature(boolean enabled) {
			this.enabled = enabled;
		}
	}

	private int features;

	private String acceptHeader = MediaType.APPLICATION_XML;

	private String typeHeader = MediaType.APPLICATION_XML;

	public OpenStackComputeConfig() {

		// calculate the bitmap
		for (Feature f : Feature.class.getEnumConstants()) {
			if (f.isEnabled()) {
				features = features | f.mask();
			}
		}
	}

	public boolean isEnabled(Feature feature) {
		return (features & feature.mask()) == 1;
	}

	public OpenStackComputeConfig with(Feature... features) {
		for (Feature feature : features) {
			this.features = this.features | feature.mask();
		}
		return this;
	}

	public OpenStackComputeConfig without(Feature... features) {
		for (Feature feature : features) {
			this.features = this.features & ~feature.mask();
		}
		return this;
	}

	public void setAcceptHeader(String value) {
		this.acceptHeader = value;
	}

	public String getAcceptHeader() {
		return this.acceptHeader;
	}

	public void setTypeHeader(String value) {
		this.typeHeader = value;
	}

	public String getTypeHeader() {
		return this.typeHeader;
	}

}
