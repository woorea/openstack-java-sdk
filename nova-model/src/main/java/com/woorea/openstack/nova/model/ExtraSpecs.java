package com.woorea.openstack.nova.model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.map.annotate.JsonRootName;

@JsonRootName("extra_specs")
public class ExtraSpecs extends HashMap<String, String> {
	
	@JsonCreator
	public ExtraSpecs(Map<String, String> extraSpecs) {
		super(extraSpecs);
	}

	@Override
	public String toString() {
		return "ExtraSpecs [Map entries=" + super.toString() + "]";
	}

}
