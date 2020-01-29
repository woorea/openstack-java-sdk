package com.woorea.openstack.cinder.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

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

		private Integer maxTotalVolumes;
		private Integer totalVolumesUsed;

		private Integer maxTotalSnapshots;
		private Integer totalSnapshotsUsed;

		private Integer maxTotalVolumeGigabytes;
		private Integer totalGigabytesUsed;

		private Integer maxTotalBackups;
		private Integer totalBackupsUsed;

		private Integer maxTotalBackupGigabytes;
		private Integer totalBackupGigabytesUsed;

		/**
		 * @return the maxTotalVolumes
		 */
		public Integer getMaxTotalVolumes() {
			return maxTotalVolumes;
		}

		/**
		 * @return the totalVolumesUsed
		 */
		public Integer getTotalVolumesUsed() {
			return totalVolumesUsed;
		}

		/**
		 * @return the maxTotalSnapshots
		 */
		public Integer getMaxTotalSnapshots() {
			return maxTotalSnapshots;
		}
		
		/**
		 * @return the totalSnapshotsUsed
		 */
		public Integer getTotalSnapshotsUsed() {
			return totalSnapshotsUsed;
		}

		/**
		 * @return the maxTotalVolumeGigabytes
		 */
		public Integer getMaxTotalVolumeGigabytes() {
			return maxTotalVolumeGigabytes;
		}

		/**
		 * @return the totalGigabytesUsed
		 */
		public Integer getTotalGigabytesUsed() {
			return totalGigabytesUsed;
		}

		/**
		 * @return the maxTotalBackupGigabytes
		 */
		public Integer getMaxTotalBackupGigabytes() {
			return maxTotalBackupGigabytes;
		}

		/**
		 * @return the totalBackupGigabytesUsed
		 */
		public Integer getTotalBackupGigabytesUsed() {
			return totalBackupGigabytesUsed;
		}

		/*
		 * (non-Javadoc)
		 *
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "AbsoluteLimit [maxTotalVolumes=" + maxTotalVolumes +
					", totalVolumesUsed=" + totalVolumesUsed +
					", maxTotalSnapshots=" + maxTotalSnapshots +
					", totalSnapshotsUsed="	+ totalSnapshotsUsed +
					", maxTotalVolumeGigabytes=" + maxTotalVolumeGigabytes +
					", totalGigabytesUsed=" + totalGigabytesUsed +
					", maxTotalBackupGigabytes=" + maxTotalBackupGigabytes +
					", totalBackupGigabytesUsed=" + totalBackupGigabytesUsed +"]";
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
