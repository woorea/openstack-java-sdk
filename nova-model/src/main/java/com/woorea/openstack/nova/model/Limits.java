package com.woorea.openstack.nova.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("limits")
public class Limits implements Serializable {

	public static final class RateLimit implements Serializable {

		public static final class LimitEntry implements Serializable {

			@JsonProperty("next-available")
			private Calendar nextAvailable;

			private String unit;

			private String verb;

			private Integer remaining;

			private Integer available;

			private Integer value;

			/**
			 * @return the nextAvailable
			 */
			public Calendar getNextAvailable() {
				return nextAvailable;
			}

			/**
			 * @return the unit
			 */
			public String getUnit() {
				return unit;
			}

			/**
			 * @return the verb
			 */
			public String getVerb() {
				return verb;
			}

			/**
			 * @return the remaining
			 */
			public Integer getRemaining() {
				return remaining;
			}

			/**
			 * @return the available
			 */
			public Integer getAvailable() {
				return available;
			}

			/**
			 * @return the value
			 */
			public Integer getValue() {
				return value;
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.Object#toString()
			 */
			@Override
			public String toString() {
				return "LimitEntry [nextAvailable=" + nextAvailable + ", unit="
						+ unit + ", verb=" + verb + ", remaining=" + remaining
						+ ", available=" + available + ", value=" + value + "]";
			}

		}

		private String regex;

		private String uri;

		private List<LimitEntry> limit;

		/**
		 * @return the regex
		 */
		public String getRegex() {
			return regex;
		}

		/**
		 * @return the uri
		 */
		public String getUri() {
			return uri;
		}

		/**
		 * @return the limit
		 */
		public List<LimitEntry> getLimit() {
			return limit;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "RateLimit [regex=" + regex + ", uri=" + uri + ", limit="
					+ limit + "]";
		}

	}

	public static final class AbsoluteLimit {

		private Integer maxServerMeta;
		private Integer serverMetaUsed;

		private Integer maxPersonality;
		private Integer personalityUsed;

		private Integer maxImageMeta;
		private Integer imageMetaUsed;

		private Integer maxPersonalitySize;
		private Integer personalitySizeUsed;

		private Integer maxTotalCores;
		private Integer totalCoresUsed;

		private Integer maxTotalInstances;
		private Integer totalInstancesUsed;

		private Integer maxTotalRAMSize;
		private Integer totalRAMUsed;

		private Integer maxSecurityGroupRules;
		private Integer securityGroupRulesUsed;

		private Integer maxTotalKeypairs;
		private Integer totalKeyPairsUsed;

		private Integer maxTotalVolumes;
		private Integer totalVolumesUsed;

		private Integer maxSecurityGroups;
		private Integer totalSecurityGroupsUsed;

		private Integer maxTotalFloatingIps;
		private Integer totalFloatingIpsUsed;

		private Integer maxTotalVolumeGigabytes;
		private Integer totalVolumeGigabytesUsed;

		/**
		 * @return the maxServerMeta
		 */
		public Integer getMaxServerMeta() {
			return maxServerMeta;
		}

		/**
		 * @return the maxPersonality
		 */
		public Integer getMaxPersonality() {
			return maxPersonality;
		}

		/**
		 * @return the maxImageMeta
		 */
		public Integer getMaxImageMeta() {
			return maxImageMeta;
		}

		/**
		 * @return the maxPersonalitySize
		 */
		public Integer getMaxPersonalitySize() {
			return maxPersonalitySize;
		}

		/**
		 * @return the maxTotalCores
		 */
		public Integer getMaxTotalCores() {
			return maxTotalCores;
		}

		/**
		 * @return the maxTotalInstances
		 */
		public Integer getMaxTotalInstances() {
			return maxTotalInstances;
		}

		/**
		 * @return the maxTotalRAMSize
		 */
		public Integer getMaxTotalRAMSize() {
			return maxTotalRAMSize;
		}

		/**
		 * @return the totalVolumesUsed
		 */
		public Integer getTotalVolumesUsed() {
			return totalVolumesUsed;
		}

		/**
		 * @return the maxSecurityGroupRules
		 */
		public Integer getMaxSecurityGroupRules() {
			return maxSecurityGroupRules;
		}
		
		/**
		 * @return the maxTotalKeypairs
		 */
		public Integer getMaxTotalKeypairs() {
			return maxTotalKeypairs;
		}

		/**
		 * @return the totalCoresUsed
		 */
		public Integer getTotalCoresUsed() {
			return totalCoresUsed;
		}

		/**
		 * @return the maxTotalVolumes
		 */
		public Integer getMaxTotalVolumes() {
			return maxTotalVolumes;
		}

		/**
		 * @return the totalRAMUsed
		 */
		public Integer getTotalRAMUsed() {
			return totalRAMUsed;
		}

		/**
		 * @return the totalInstancesUsed
		 */
		public Integer getTotalInstancesUsed() {
			return totalInstancesUsed;
		}

		/**
		 * @return the maxSecurityGroups
		 */
		public Integer getMaxSecurityGroups() {
			return maxSecurityGroups;
		}
		
		/**
		 * @return the totalVolumeGigabytesUsed
		 */
		public Integer getTotalVolumeGigabytesUsed() {
			return totalVolumeGigabytesUsed;
		}

		/**
		 * @return the totalSecurityGroupsUsed
		 */
		public Integer getTotalSecurityGroupsUsed() {
			return totalSecurityGroupsUsed;
		}

		/**
		 * @return the maxTotalFloatingIps
		 */
		public Integer getMaxTotalFloatingIps() {
			return maxTotalFloatingIps;
		}

		/**
		 * @return the totalKeyPairsUsed
		 */
		public Integer getTotalKeyPairsUsed() {
			return totalKeyPairsUsed;
		}

		/**
		 * @return the maxTotalVolumeGigabytes
		 */
		public Integer getMaxTotalVolumeGigabytes() {
			return maxTotalVolumeGigabytes;
		}

		/**
		 * @return the serverMetaUsed
		 */
		public Integer getServerMetaUsed() {
			return serverMetaUsed;
		}

		/**
		 * @return the personalityUsed
		 */
		public Integer getPersonalityUsed() {
			return personalityUsed;
		}

		/**
		 * @return the imageMetaUsed
		 */
		public Integer getImageMetaUsed() {
			return imageMetaUsed;
		}

		/**
		 * @return the personalitySizeUsed
		 */
		public Integer getPersonalitySizeUsed() {
			return personalitySizeUsed;
		}

		/**
		 * @return the securityGroupRulesUsed
		 */
		public Integer getSecurityGroupRulesUsed() {
			return securityGroupRulesUsed;
		}

		/**
		 * @return the totalFloatingIpsUsed
		 */
		public Integer getTotalFloatingIpsUsed() {
			return totalFloatingIpsUsed;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "AbsoluteLimit [maxServerMeta=" + maxServerMeta
					+ ", maxPersonality=" + maxPersonality + ", maxImageMeta="
					+ maxImageMeta + ", maxPersonalitySize="
					+ maxPersonalitySize + ", maxTotalCores=" + maxTotalCores
					+ ", maxTotalInstances=" + maxTotalInstances
					+ ", maxTotalRAMSize=" + maxTotalRAMSize + "]";
		}

	}

	private List<RateLimit> rate;

	private AbsoluteLimit absolute;

	/**
	 * @return the rate
	 */
	public List<RateLimit> getRate() {
		return rate;
	}

	/**
	 * @return the absolute
	 */
	public AbsoluteLimit getAbsolute() {
		return absolute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Limits [rate=" + rate + ", absolute=" + absolute + "]";
	}

}
