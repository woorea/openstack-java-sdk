package com.woorea.openstack.ceilometer.v2.model;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;

public class Statistics {
	
	private BigDecimal avg;
	
	private BigDecimal count;
	
	private BigDecimal duration;
	
	@JsonProperty("duration_start")
	private String durationStart;
	
	@JsonProperty("duration_end")
	private String durationEnd;
	
	private BigDecimal max;
	
	private BigDecimal min;
	
	private BigDecimal period;
	
	@JsonProperty("period_start")
	private String periodStart;
	
	@JsonProperty("period_end")
	private String periodEnd;
	
	private BigDecimal sum;

	public BigDecimal getAvg() {
		return avg;
	}

	public BigDecimal getCount() {
		return count;
	}

	public BigDecimal getDuration() {
		return duration;
	}

	public String getDurationStart() {
		return durationStart;
	}

	public String getDurationEnd() {
		return durationEnd;
	}

	public BigDecimal getMax() {
		return max;
	}

	public BigDecimal getMin() {
		return min;
	}

	public BigDecimal getPeriod() {
		return period;
	}

	public String getPeriodStart() {
		return periodStart;
	}

	public String getPeriodEnd() {
		return periodEnd;
	}

	public BigDecimal getSum() {
		return sum;
	}

	@Override
	public String toString() {
		return "Statistics [avg=" + avg + ", count=" + count + ", duration="
				+ duration + ", durationStart=" + durationStart
				+ ", durationEnd=" + durationEnd + ", max=" + max + ", min="
				+ min + ", period=" + period + ", periodStart=" + periodStart
				+ ", periodEnd=" + periodEnd + ", sum=" + sum + "]";
	}
	
}
