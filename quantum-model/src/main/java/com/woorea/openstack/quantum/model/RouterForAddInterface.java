package com.woorea.openstack.quantum.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class RouterForAddInterface implements Serializable {

		@JsonProperty("subnet_id")
		String subnetId;
		String routerId;

		public String getSubnetId() {
			return subnetId;
		}

		public void setSubnetId(String subnetId) {
			this.subnetId = subnetId;
		}

		public String getRouterId() {
			return routerId;
		}

		public void setRouterId(String routerId) {
			this.routerId = routerId;
		}
	}
