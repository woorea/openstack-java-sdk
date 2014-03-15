package com.woorea.openstack.keystone.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class Extra implements Serializable {

	Map<String, String> map = new HashMap<String, String>();

	@JsonAnyGetter
	public Map<String, String> any() {
		return map;
	}

	@JsonAnySetter
	public void set(String name, String value) {
		map.put(name, value);
	}
	
	public String toString() {
		return "extra=" + map.toString();
	}
}
