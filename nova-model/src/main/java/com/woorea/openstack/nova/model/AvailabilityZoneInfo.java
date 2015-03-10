package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

public class AvailabilityZoneInfo implements Serializable {

	private static final class ZoneState {
		@JsonProperty("available")
		private boolean available;

		public boolean getAvailable() {
			return available;
		}
		@Override
		public String toString() {
			return " available =[" + available + "]";
		}

	}

	private static final class ZoneServiceInfo {
		@JsonProperty("updated_at")
		private String updatedAt; 
		private boolean active;
		private boolean available;

		public String getUpdatedAt() {
			return updatedAt;
		}

		public boolean getActive() {
			return active;
		}
		public boolean getAvailable() {
			return available;
		}

		@Override
		public String toString() {
			return "updatedAt=" + updatedAt + ", active=" + active
				+ ", available=" + available;
		}
	}

	private static final class ZoneInfo {
		private String zoneName;
		private Map<String, Map<String, ZoneServiceInfo>> hosts;
		private ZoneState zoneState;

		public String getZoneName() {
			return zoneName;
		}
		public Map<String, Map<String, ZoneServiceInfo>> getHosts() {
			return hosts;
		}
		public ZoneState getZoneState() {
			return zoneState;
		}

		@Override
		public String toString() {
			return "zoneName=" + zoneName + ", hosts=" + hosts
				+ ", zoneState=" + zoneState + "]";
		}
	}
	
	private List<ZoneInfo> availabilityZoneInfo;

	public List<ZoneInfo> getAvailabilityZoneInfo() {
		return availabilityZoneInfo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//FIXME(thatsdone): ipmlement!
		return "AvailabilityZoneInfo=[" + availabilityZoneInfo + "]";
	}
}
