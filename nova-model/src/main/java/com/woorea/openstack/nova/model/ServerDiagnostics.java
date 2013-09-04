package com.woorea.openstack.nova.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class ServerDiagnostics implements Serializable {
	@JsonProperty("memory")
	String memory;
	@JsonProperty("cpu0_time")
	String cpu0_time;
	@JsonProperty("vda_read")
	String vda_read;
	@JsonProperty("vda_write")
	String vda_write;
	@JsonProperty("vda_write_req")
	String vda_write_req;
	@JsonProperty("tap7baaefe5-d7_rx_packets")
	String t1;
	@JsonProperty("tap7baaefe5-d7_rx")
	String tap1;
	@JsonProperty("tap7baaefe5-d7_rx_drop")
	String drop1;
	@JsonProperty("tap7baaefe5-d7_tx")
	String d7_tx;
	@JsonProperty("tap7baaefe5-d7_tx_drop")
	String d7_tx_drop;
	@JsonProperty("tap7baaefe5-d7_rx_errors")
	String rx_errors;
	@JsonProperty("memory-actual")
	String actual;
	@JsonProperty("memory-rss")
	String rss;
	@JsonProperty("tap7baaefe5-d7_tx_packets")
	String d7_tx_packets;
	@JsonProperty("vda_read_req")
	String vda_read_req;
	@JsonProperty("vda_errors")
	String vda_errors;
	@JsonProperty("tap7baaefe5-d7_tx_errors")
	String d7_tx_errors;

}
