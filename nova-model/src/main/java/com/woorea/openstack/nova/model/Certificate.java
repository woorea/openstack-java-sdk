package com.woorea.openstack.nova.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("certificate")
public class Certificate {

	private String data;
	
	@JsonProperty("private_key")
	private String privateKey;

	/**
	 * @return the data
	 */
	public String getData() {
		return data;
	}

	/**
	 * @return the privateKey
	 */
	public String getPrivateKey() {
		return privateKey;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Certificate [data=" + data + ", privateKey=" + privateKey + "]";
	}
	
}
