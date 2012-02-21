package org.openstack.client.common;

import java.io.Serializable;

public class OpenStackImageConfig implements Serializable {

	public enum Feature {

		VERBOSE(false);

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

	public OpenStackImageConfig() {

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

	public OpenStackImageConfig with(Feature... features) {
		for (Feature feature : features) {
			this.features = this.features | feature.mask();
		}
		return this;
	}

	public OpenStackImageConfig without(Feature... features) {
		for (Feature feature : features) {
			this.features = this.features & ~feature.mask();
		}
		return this;
	}

}
