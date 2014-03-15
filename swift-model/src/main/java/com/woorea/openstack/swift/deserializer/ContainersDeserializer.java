package com.woorea.openstack.swift.deserializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.woorea.openstack.swift.model.Container;
import com.woorea.openstack.swift.model.Containers;

public class ContainersDeserializer extends JsonDeserializer<Containers> {

	@Override
	public Containers deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Container[] containersArray = jp.readValueAs(Container[].class);
		return new Containers(containersArray);
	}

}
